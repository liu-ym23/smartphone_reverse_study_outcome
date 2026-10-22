package com.bytedance.ee.bear.drive.biz.preview;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.services.DriveOpenMonitorImpl;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.m;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import g85.f;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t85.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J)\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\"\u00020\u001dH\u0004¢\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001c\"\u00020 H\u0004¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0013J\u0012\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u0011H\u0004J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000bH\u0004J\b\u0010)\u001a\u00020\u0013H\u0004J\b\u0010*\u001a\u00020+H\u0016J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.J\n\u0010/\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020.H\u0004J\u0012\u00102\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u000103H\u0002J\u0012\u00104\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mPreviewContainer", "Landroid/view/ViewGroup;", "getMPreviewContainer", "()Landroid/view/ViewGroup;", "setMPreviewContainer", "(Landroid/view/ViewGroup;)V", "mCurrentPreviewView", "Landroid/view/View;", "getMCurrentPreviewView", "()Landroid/view/View;", "setMCurrentPreviewView", "(Landroid/view/View;)V", "mCurrentIPreviewView", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/AbsPreviewView;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "addErrorHandler", "cmd", "Ljava/lang/Runnable;", "codes", "", "Lcom/bytedance/ee/bear/drive/loader/model/ErrCode;", "(Ljava/lang/Runnable;[Lcom/bytedance/ee/bear/drive/loader/model/ErrCode;)V", "addInfoHandler", "Lcom/bytedance/ee/bear/drive/loader/model/InfoCode;", "(Ljava/lang/Runnable;[Lcom/bytedance/ee/bear/drive/loader/model/InfoCode;)V", "getPreviewView", "fileModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewFileModel;", "reloadCurrentPreviewView", "removeAndAddPreviewView", "previewView", "view", "removePreviewView", "isShowingContent", "", "updateShowingContentVisibility", "visibility", "", "currentPreviewView", "dispatchToBlockHandler", "type", "setPreviewOpenCallback", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/IPreviewView;", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDrivePreviewPlugin extends AbsDrivePlugin {
    private AbsPreviewView mCurrentIPreviewView;
    private View mCurrentPreviewView;
    private ViewGroup mPreviewContainer;

    public static final class a extends u75.b.C0306b {
        public final /* synthetic */ ErrCode[] a;
        public final /* synthetic */ Runnable b;

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r5) {
            Intrinsics.checkNotNullParameter(r5, "srcCode");
            ErrCode[] r0 = this.a;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            if (r0[r2] == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            this.b.run();
            return;
        }

        public a(ErrCode[] r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ InfoCode[] a;
        public final /* synthetic */ Runnable b;

        public b(InfoCode[] r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r4, T r5) {
            Intrinsics.checkNotNullParameter(r4, "srcCode");
            InfoCode[] r6 = this.a;
            int r0 = r6.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L9;
            if (r6[r1] == r4) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            this.b.run();
            return;
        }
    }

    public static final class c implements c95.c {
        public c() {
        }

        @Override // c95.c
        public final void onShowStart() {
        }

        @Override // c95.c
        public final void b(String r1) {
            DriveOpenMonitorImpl.a();
        }

        @Override // c95.c
        public final void a(String r1, Throwable r2) {
            DriveOpenMonitorImpl.a();
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean isShowingContent() {
        View r0 = this.mCurrentPreviewView;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.getVisibility() != 0) goto L9;
        r1 = true;
        goto L10
    }

    public final void reloadCurrentPreviewView() {
        AbsPreviewView r0 = this.mCurrentIPreviewView;
        if (r0 == null) goto L8;
        z r1 = r0.getPreviewFileModel();
        if (r1 == null) goto L9;
        removeAndAddPreviewView(getPreviewView(r1));
        return;
    L9:
        return;
    }

    public final void removePreviewView() {
        ViewGroup r0 = this.mPreviewContainer;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.getChildCount() <= 0) goto L9;
        ViewGroup r1 = this.mPreviewContainer;
        Intrinsics.checkNotNull(r1);
        r1.removeAllViews();
        return;
    L9:
        return;
    }

    public AbsDrivePreviewPlugin() {
    }

    public AbsPreviewView currentPreviewView() {
        return this.mCurrentIPreviewView;
    }

    public final View getMCurrentPreviewView() {
        return this.mCurrentPreviewView;
    }

    public final ViewGroup getMPreviewContainer() {
        return this.mPreviewContainer;
    }

    private final void setPreviewOpenCallback(m r2) {
        if (r2 == null) goto L5;
        r2.setOnShowViewTrackEventCallback(new c());
        return;
    }

    public final void dispatchToBlockHandler(int r3) {
        if (getHost().c.isInBlockState() == true) goto L5;
        return;
    L5:
        y55.a r0 = (y55.a) getHost().getHostAbilityOrNull(y55.a.class);
        if (r0 == null) goto L9;
        r0.dispatchToBlockHandler(r3);
        return;
    }

    public final AbsPreviewView getPreviewView(z r18) {
        Intrinsics.checkNotNullParameter(r18, "fileModel");
        f r1 = o75.b.a().getMimeTypeManager();
        DrivePluginHost r2 = getHost();
        Context r3 = getContext();
        ViewOwner r5 = r2.b;
        LifecycleOwner r6 = r2.getLifecycleOwner();
        if (r18 == null) goto L21;
        if (r6 == null) goto L21;
        if (com.bytedance.ee.util.ui.b.b(r3) == false) goto L21;
        tt5.a.h("PreviewViewManager", "LifecycleOwner=" + r6);
        if (r18.q == 2) goto L10;
        int r4 = ((g85.b) r1).b(r18.c, r18.u).c;
    L14:
        tt5.a.h("PreviewViewManager", "getPreviewType previewType = " + r4);
        Class<? extends AbsPreviewView> r7 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).ca(r4, r18);
        ViewOwner r9 = new ViewOwner(r2, r6);
        if (r7 != null) goto L23;
        return null;
    L23:
        Constructor<? extends AbsPreviewView> r12 = r7.getDeclaredConstructor(new Class[]{ViewOwner.class, ViewOwner.class, Context.class, z.class, a95.a.class});     // Catch: Exception -> L19
        r12.setAccessible(true);     // Catch: Exception -> L19
        AbsPreviewView r0 = r12.newInstance(new Object[]{r5, r9, r3, r18, r2.b()});     // Catch: Exception -> L19
        r0.setSourceType(3);     // Catch: Exception -> L19
        tt5.a.h("PreviewViewManager", "DRIVE_PREVIEW_FLOW getPreviewView()...clazz = " + r7);     // Catch: Exception -> L19
        return r0;
    L19:
        e = move-exception;
        tt5.a.f("PreviewViewManager", e, false);
        return null;
    L10:
        if (((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).pa() == false) goto L12;
        r4 = DriveLocalMime.WPS.getValue();
        goto L14
    L12:
        r4 = ((g85.b) r1).b(r18.c, r18.u).c;
        tt5.a.k("PreviewViewManager", "block WPS preview mode because host has no WPS package, fallbackPreviewType=" + r4);
    L21:
        tt5.a.d("PreviewViewManager", "getPreviewView return Null, filemodel=" + r18 + ", owner=" + r6);
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        AbsPreviewView r0 = this.mCurrentIPreviewView;
        if (r0 == null) goto L6;
        r0.onNewConfiguration(r2);
        return;
    }

    public final void removeAndAddPreviewView(AbsPreviewView r9) {
        if (this.mPreviewContainer == null) goto L23;
        if (r9 == null) goto L23;
        if (r9.getView() == null) goto L23;
        setPreviewOpenCallback(r9);
        removeAndAddPreviewView(r9.getView());
        r9.show();
        this.mCurrentIPreviewView = r9;
        BaseOpenEntity r0 = getHost().c.getOpenEntity();
        com.bytedance.ee.bear.drive.report.c r1 = k75.a.c(getHost());
        int r2 = r0.getBizType();
        w75.a r3 = getHost().c.getFileModel();
        if (r0.getBizType() != 3) goto L11;
        String r4 = "im_file";
    L12:
        r1.getClass();
        if (r3 == null) goto L29;
        boolean r10 = r9.isPreviewSupported();
        e r5 = r1.g.a(r3.c().a);
        if (r5 == null) goto L17;
        String r6 = r5.a();
    L18:
        tt5.a.h("DriveReport", "reportCcmDocsOrDrivePageView: mountPoint = " + r4 + ", bizType = " + r2);
        if (r2 != 2) goto L21;
        HashMap<String, Object> r7 = r1.h(r3.c().a, r6);
        r7.put("preview_viable", Integer.valueOf(r10 ? 1 : 0));
        r7.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r4);
        r1.A("ccm_docs_page_view", r7);
        return;
    L21:
        String r8 = r3.c().a;
        HashMap<String, Object> r11 = r1.h(r8, r6);
        r11.put("is_degraded", com.bytedance.ee.bear.drive.report.c.k(r1.g.a(r8)));
        r11.put("preview_viable", Integer.valueOf(r10 ? 1 : 0));
        r11.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r4);
        r1.A("ccm_drive_page_view", r11);
        return;
    L17:
        r6 = "";
        goto L18
    L29:
        return;
    L11:
        r4 = r0.getMountPoint();
    L23:
        StringBuilder r12 = new StringBuilder("removeAndAddPreviewView() mPreviewContainer=");
        r12.append(this.mPreviewContainer);
        r12.append(" previewView=");
        r12.append(r9);
        r12.append(" previewView.view=");
        if (r9 == null) goto L26;
        View r13 = r9.getView();
    L27:
        r12.append(r13);
        tt5.a.k("DriveComponent", r12.toString());
        return;
    L26:
        r13 = null;
        goto L27
    }

    public final void setMCurrentPreviewView(View r1) {
        this.mCurrentPreviewView = r1;
    }

    public final void setMPreviewContainer(ViewGroup r1) {
        this.mPreviewContainer = r1;
    }

    public final void updateShowingContentVisibility(int r2) {
        View r0 = this.mCurrentPreviewView;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    public final void removeAndAddPreviewView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        removePreviewView();
        ViewParent r0 = r3.getParent();
        if (r0 != null) goto L5;
    L7:
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup r1 = this.mPreviewContainer;
        if (r1 == null) goto L11;
        r1.addView(r3);
    L11:
        if (r3.getVisibility() == 0) goto L13;
        r3.setVisibility(0);
    L13:
        this.mCurrentPreviewView = r3;
        return;
    L5:
        if ((r0 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r0).removeView(r3);
        goto L7
    }

    public final void addErrorHandler(Runnable r3, ErrCode... r4) {
        Intrinsics.checkNotNullParameter(r3, "cmd");
        Intrinsics.checkNotNullParameter(r4, "codes");
        getHost().c().c(new a(r4, r3));
    }

    public final void addInfoHandler(Runnable r3, InfoCode... r4) {
        Intrinsics.checkNotNullParameter(r3, "cmd");
        Intrinsics.checkNotNullParameter(r4, "codes");
        getHost().c().c(new b(r4, r3));
    }

    public void onAttachToUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        View r4 = r3.findView(2131370305);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mPreviewContainer = (ViewGroup) r4;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }
}
