package com.bytedance.ee.bear.drive.biz.preview.titlebar;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.biz.preview.more.AbsDriveMoreMenuPlugin;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.DrivePreviewViewPager;
import com.bytedance.ee.drive.render.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u001c\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002R\u0018\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/titlebar/DriveTitleBarPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mObserver", "Landroidx/lifecycle/Observer;", "", "mRiskObserver", "", "mSubTitleOverrideObserver", "mViewPager", "Lcom/bytedance/ee/bear/drive/view/preview/imageviewer/DrivePreviewViewPager;", "mListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "initScrollListener", "", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onAttachPreview", "updateSubTitle", "position", "", "resolveSubTitle", "onDetachPreview", "onDetachFromUIContainer", "onDetachFromHost", "handleDrivePageTitleBarStateIfNeed", "showPagerCounter", "titleBarDarkModeConfigurationChangedCallbacks", "Landroid/content/ComponentCallbacks;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveTitleBarPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveTitleBarPlugin";
    private ViewPager.OnPageChangeListener mListener;
    private Observer<String> mObserver;
    private Observer<Boolean> mRiskObserver;
    private Observer<String> mSubTitleOverrideObserver;
    private DrivePreviewViewPager mViewPager;
    private final ComponentCallbacks titleBarDarkModeConfigurationChangedCallbacks;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveTitleBarPlugin a;

        public b(DriveTitleBarPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            tt5.a.h(DriveTitleBarPlugin.TAG, "liveFileName-onChanged()");
            TitleBar r0 = DriveTitleBarPlugin.access$getUIContainer(this.a).getTitleBar();
            r0.setTitle((String) r3);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveTitleBarPlugin a;

        public c(DriveTitleBarPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            tt5.a.h(DriveTitleBarPlugin.TAG, "liveRiskFlag-onChanged() riskFlag is " + r4);
            DriveTitleBarPlugin.access$getUIContainer(this.a).getTitleBar().setRiskFlag(r4);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveTitleBarPlugin a;

        public d(DriveTitleBarPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            String r5 = (String) r4;
            StringBuilder r0 = new StringBuilder("liveTitleBarSubtitleOverride-onChanged() hasSubtitleOverride is ");
            if (r5 == null) goto L5;
            boolean r6 = true;
        L6:
            r0.append(r6);
            tt5.a.h(DriveTitleBarPlugin.TAG, r0.toString());
            DriveTitleBarPlugin.updateSubTitle$default(this.a, 0, 1, null);
            return;
        L5:
            r6 = false;
            goto L6
        }
    }

    public static final class e implements ComponentCallbacks {
        public final /* synthetic */ DriveTitleBarPlugin a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public e(DriveTitleBarPlugin r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r2) {
            Intrinsics.checkNotNullParameter(r2, "newConfig");
            TitleBar r3 = DriveTitleBarPlugin.access$getTitleBar(this.a);
            if (r3 == null) goto L6;
            r3.invalidate();
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void initScrollListener() {
        if (this.mViewPager != null) goto L8;
        DrivePreviewViewPager r0 = (DrivePreviewViewPager) findViewById(2131370322);
        this.mViewPager = r0;
        if (r0 == null) goto L9;
        ViewPager.SimpleOnPageChangeListener r1 = new AnonymousClass1(this);
        this.mListener = r1;
        r0.addOnPageChangeListener(r1);
        return;
    L9:
        return;
    }

    public DriveTitleBarPlugin() {
        this.titleBarDarkModeConfigurationChangedCallbacks = new e(this);
    }

    private final void handleDrivePageTitleBarStateIfNeed() {
        Bundle r0 = getHost().a.getArguments();
        if (r0 == null) goto L5;
        Bundle r1 = r0.getBundle("doc_page_config");
    L6:
        if (r1 == null) goto L25;
        boolean r2 = r1.getBoolean("hideTitleBar", false);
        if (r2 == false) goto L10;
        getTitleBar().getTitleBarLayout().setVisibility(8);
    L10:
        boolean r4 = r1.getBoolean("hideTitle", false);
        if (r4 == false) goto L13;
        getTitleBar().setTitleVisibility(false);
        getTitleBar().h();
    L13:
        boolean r5 = r1.getBoolean("hideBackIcon", false);
        if (r5 == false) goto L16;
        getTitleBar().setLeftIconVisibility(false);
    L16:
        ArrayList r6 = new ArrayList();
        boolean r7 = r1.getBoolean("hideMessageIcon", false);
        boolean r8 = r1.getBoolean("hideShareIcon", false);
        boolean r3 = r1.getBoolean("hideMoreIcon", false);
        if (r7 == false) goto L19;
        r6.add(new MenuItem(AbsDriveMoreMenuPlugin.FEED_MENU_ID, null));
    L19:
        if (r8 == false) goto L21;
        r6.add(new MenuItem(AbsDriveMoreMenuPlugin.SHARE_MENU_ID, null));
    L21:
        if (r3 == false) goto L23;
        r6.add(new MenuItem(AbsDriveMoreMenuPlugin.MORE_MENU_ID, null));
    L23:
        getTitleBar().setHiddenMenus(r6);
        tt5.a.b(TAG, "hideTitleBar=" + r2 + ", hideTitle=" + r4 + ", hideBackIcon=" + r5 + ", hiddenMenuItems=" + r6);
        return;
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final boolean showPagerCounter() {
        k r0 = getDriveUIConfig();
        if (r0 == null) goto L7;
        k.g r1 = r0.getTitleBar();
        if (r1 == null) goto L7;
        return r1.b;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        LiveData<String> r0 = getHost().c.liveFileName();
        LifecycleOwner r1 = getHost().getLifecycleOwner();
        b r2 = new b(this);
        this.mObserver = r2;
        Unit r3 = Unit.INSTANCE;
        r0.observe(r1, r2);
        LiveData<Boolean> r4 = getHost().c.liveRiskFlag();
        LifecycleOwner r5 = getHost().getLifecycleOwner();
        c r6 = new c(this);
        this.mRiskObserver = r6;
        r4.observe(r5, r6);
        LiveData<String> r7 = getHost().c.liveTitleBarSubtitleOverride();
        LifecycleOwner r8 = getHost().getLifecycleOwner();
        d r9 = new d(this);
        this.mSubTitleOverrideObserver = r9;
        r7.observe(r8, r9);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        Observer<String> r0 = this.mObserver;
        if (r0 == null) goto L5;
        getHost().c.liveFileName().removeObserver(r0);
    L5:
        Observer<Boolean> r1 = this.mRiskObserver;
        if (r1 == null) goto L8;
        getHost().c.liveRiskFlag().removeObserver(r1);
    L8:
        Observer<String> r2 = this.mSubTitleOverrideObserver;
        if (r2 == null) goto L12;
        getHost().c.liveTitleBarSubtitleOverride().removeObserver(r2);
        return;
    }

    public static final /* synthetic */ TitleBar access$getTitleBar(DriveTitleBarPlugin r0) {
        return r0.getTitleBar();
    }

    public static final /* synthetic */ t access$getUIContainer(DriveTitleBarPlugin r0) {
        return r0.getUIContainer();
    }

    private final String resolveSubTitle(int r4) {
        DrivePluginHost r0 = getHost();
        if (r0 == null) goto L14;
        DriveViewModel r1 = r0.c;
        if (r1 == null) goto L14;
        String r2 = r1.getTitleBarSubtitleOverride();
        if (r2 == null) goto L14;
        if ((!StringsKt.isBlank(r2)) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        return r2;
    L14:
        DrivePreviewViewPager r3 = this.mViewPager;
        if (r3 == null) goto L19;
        PagerAdapter r5 = r3.getAdapter();
        if (r5 == null) goto L19;
        int r6 = r5.getCount();
    L21:
        if (showPagerCounter() == false) goto L24;
        if (r6 <= 1) goto L24;
        StringBuilder r7 = new StringBuilder();
        r7.append(r4 + 1);
        r7.append('/');
        r7.append(r6);
        return r7.toString();
    L24:
        return "";
    L19:
        r6 = 0;
        goto L21
    }

    private final void updateSubTitle(int r2) {
        getTitleBar().setSubTitle(resolveSubTitle(r2));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        ViewPager.OnPageChangeListener r3 = this.mListener;
        if (r3 == null) goto L8;
        DrivePreviewViewPager r0 = this.mViewPager;
        if (r0 == null) goto L9;
        r0.removeOnPageChangeListener(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$updateSubTitle(DriveTitleBarPlugin r0, int r1) {
        r0.updateSubTitle(r1);
    }

    public void onAttachToUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        initScrollListener();
        getTitleBar().b(TitleBar.TitleGravity.Left);
        updateSubTitle$default(this, 0, 1, null);
        handleDrivePageTitleBarStateIfNeed();
        getActivity().getApplicationContext().registerComponentCallbacks(this.titleBarDarkModeConfigurationChangedCallbacks);
    }

    public void onDetachFromUIContainer(DrivePluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        getActivity().getApplicationContext().unregisterComponentCallbacks(this.titleBarDarkModeConfigurationChangedCallbacks);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }

    public static /* synthetic */ void updateSubTitle$default(DriveTitleBarPlugin r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L8;
        DrivePreviewViewPager r4 = r0.mViewPager;
        if (r4 == null) goto L7;
        r1 = r4.getCurrentItem();
        goto L8
    L7:
        r1 = 0;
    L8:
        r0.updateSubTitle(r1);
    }
}
