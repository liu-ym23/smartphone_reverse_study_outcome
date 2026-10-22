package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentVM;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.fragment.DriveMediaImmersiveVM;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.FooterBehavior;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0014\u0010\u001e\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 J\u001e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 H\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/screen/DriveFullScreenImmersivePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "mDriveFullScreenManager", "Lcom/bytedance/ee/bear/drive/biz/preview/screen/DriveFullScreenManager;", "mLoadListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "mMediaImmersiveVM", "Lcom/bytedance/ee/bear/drive/core/fragment/DriveMediaImmersiveVM;", "mPresentationExitGeneration", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "isVcPresentationMode", "", "isMediaImmersivePreviewEnabled", "isFooterScrollFullScreenEnabled", "isMediaImmersiveActive", "initFullScreen", "previewFileModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewFileModel;", "forceTitleInTop", "onAttachPreview", "onDetachPreview", "onDetachFromHost", "switchFullScreenImpl", "exitPreviewPresentationIfNeeded", "onComplete", "Lkotlin/Function0;", "runAfterPreviewLayoutStable", "fileId", "", "getViewType", "fileModel", "onBackPressed", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFullScreenImmersivePlugin extends AbsDrivePlugin implements sa5.d {
    public static final a Companion = null;
    private static final String TAG = "DriveSdkImmersivePlugin";
    private com.bytedance.ee.bear.drive.biz.preview.screen.k mDriveFullScreenManager;
    private u75.b.a mLoadListener;
    private DriveMediaImmersiveVM mMediaImmersiveVM;
    private int mPresentationExitGeneration;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements FooterBehavior.a {
        public final /* synthetic */ DriveFullScreenImmersivePlugin a;

        @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.FooterBehavior.a
        public final void a() {
            DriveFullScreenImmersivePlugin.access$switchFullScreenImpl(this.a);
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.FooterBehavior.a
        public final boolean n0() {
            com.bytedance.ee.bear.drive.biz.preview.screen.k r0 = DriveFullScreenImmersivePlugin.access$getMDriveFullScreenManager$p(this.a);
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.a != true) goto L9;
            return true;
        L9:
            return false;
        }

        public b(DriveFullScreenImmersivePlugin r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveFullScreenImmersivePlugin a;
        public final /* synthetic */ DrivePluginHost b;
        public final /* synthetic */ PreviewViewModel c;

        public c(DriveFullScreenImmersivePlugin r1, DrivePluginHost r2, PreviewViewModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            com.bytedance.ee.bear.drive.biz.preview.screen.a r4 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) ((DriveFullScreenVM) new ViewModelProvider(DriveFullScreenImmersivePlugin.access$getActivity(this.a)).get(DriveFullScreenVM.class)).getLiveFullScreen().getValue();
            if (r4 == null) goto L7;
            boolean r0 = true;
            if (r4.a != true) goto L7;
        L8:
            if (r0 == true) goto L10;
            return;
        L10:
            if (this.b.c.isInBlockState() == false) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual(this.c.liveInnerIsWPSPresentationMode().getValue(), Boolean.FALSE) == false) goto L14;
            return;
        L14:
            if (DriveFullScreenImmersivePlugin.access$isVcPresentationMode(this.a) == true) goto L20;
            DriveFullScreenImmersivePlugin.access$switchFullScreenImpl(this.a);
            return;
        L20:
            return;
        L7:
            r0 = false;
            goto L8
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;

        public d(DrivePluginHost r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            MutableLiveData<com.bytedance.ee.bear.drive.biz.preview.screen.a> r0 = k75.a.e(this.a).liveOuterFullScreenSate;
            r0.postValue((com.bytedance.ee.bear.drive.biz.preview.screen.a) r2);
        }
    }

    public static final class e extends u75.b.C0306b {
        public final /* synthetic */ DriveFullScreenImmersivePlugin a;
        public final /* synthetic */ DrivePluginHost b;

        @Override // u75.b.C0306b, u75.b.a
        public final void b(z r3) {
            Intrinsics.checkNotNullParameter(r3, "previewFileModel");
            this.a.initFullScreen(r3, this.b.c.isInBlockState());
        }

        public e(DriveFullScreenImmersivePlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 == InfoCode.HitCache) goto L5;
            return;
        L5:
            if ((r3 instanceof w75.a) == false) goto L9;
            this.a.initFullScreen(((w75.a) r3).i(), this.b.c.isInBlockState());
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveFullScreenImmersivePlugin b;

        public f(DrivePluginHost r1, DriveFullScreenImmersivePlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            w75.a r5 = this.a.c.getFileModel();
            if (r5 == null) goto L6;
            DriveFullScreenImmersivePlugin r0 = this.b;
            DrivePluginHost r1 = this.a;
            r0.initFullScreen(r5.i(), r1.c.isInBlockState());
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveFullScreenImmersivePlugin b;

        public g(DrivePluginHost r1, DriveFullScreenImmersivePlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r8) {
            Boolean r9 = (Boolean) r8;
            if (r9 != null) goto L5;
            return;
        L5:
            if (this.a.c.isInBlockState() == true) goto L24;
            com.bytedance.ee.bear.drive.report.c r0 = k75.a.c(this.a);
            w75.a r1 = this.a.c.getFileModel();
            if (this.a.c.isInBlockFullScreenState() == false) goto L10;
            String r2 = "preview";
        L12:
            if (r9.booleanValue() == false) goto L14;
            String r3 = "landscape";
        L15:
            r0.getClass();
            HashMap<String, Object> r4 = new HashMap();
            r4.put("click", "media_rotate");
            r4.put("diaplay", r2);
            r4.put("target", "none");
            r4.put("media_display", r3);
            r0.r(r1, r4);
            com.bytedance.ee.bear.drive.biz.preview.screen.a r10 = com.bytedance.ee.bear.drive.biz.preview.screen.b.a(this.a.c, r9);
            if (r10 == null) goto L22;
            DriveFullScreenImmersivePlugin r5 = this.b;
            com.bytedance.ee.bear.drive.biz.preview.screen.k r6 = DriveFullScreenImmersivePlugin.access$getMDriveFullScreenManager$p(r5);
            if (r6 == null) goto L23;
            r6.f(DriveFullScreenImmersivePlugin.access$getActivity(r5), r10);
            return;
        L23:
            return;
        L22:
            return;
        L14:
            r3 = "portrait";
            goto L15
        L10:
            r2 = "card";
            goto L12
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveFullScreenImmersivePlugin b;

        public h(DrivePluginHost r1, DriveFullScreenImmersivePlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r1) {
            String r2 = (String) r1;
            if (this.a.c.isInBlockState() == true) goto L7;
            DriveFullScreenImmersivePlugin.access$switchFullScreenImpl(this.b);
            return;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveFullScreenImmersivePlugin b;

        public i(DrivePluginHost r1, DriveFullScreenImmersivePlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (this.a.c.isInBlockState() == true) goto L13;
            com.bytedance.ee.bear.drive.biz.preview.screen.k r0 = DriveFullScreenImmersivePlugin.access$getMDriveFullScreenManager$p(this.b);
            if (r0 == null) goto L11;
            DriveFullScreenImmersivePlugin r1 = this.b;
            if (Intrinsics.areEqual(Boolean.valueOf(r0.a), r4) == true) goto L12;
            DriveFullScreenImmersivePlugin.access$switchFullScreenImpl(r1);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ DriveCommentVM a;
        public final /* synthetic */ DrivePluginHost b;
        public final /* synthetic */ DriveFullScreenImmersivePlugin c;

        public j(DriveCommentVM r1, DrivePluginHost r2, DriveFullScreenImmersivePlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r2) {
            Void r3 = (Void) r2;
            if (Intrinsics.areEqual(this.a.getCommentPanelShowing().getValue(), Boolean.TRUE) == false) goto L5;
            return;
        L5:
            if (this.b.c.isInBlockState() == true) goto L10;
            DriveFullScreenImmersivePlugin.access$switchFullScreenImpl(this.c);
            return;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ DriveFullScreenImmersivePlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public k(DriveFullScreenImmersivePlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r5) {
            Boolean r6 = (Boolean) r5;
            if (DriveFullScreenImmersivePlugin.access$isMediaImmersiveActive(this.a) == false) goto L6;
            tt5.a.h(DriveFullScreenImmersivePlugin.TAG, "skip immersiveTitleTopState: mediaImmersive active");
            return;
        L6:
            if (this.b.c.getFileModel() == null) goto L19;
            DrivePluginHost r0 = this.b;
            DriveFullScreenImmersivePlugin r1 = this.a;
            if (r0.c.isInBlockState() == true) goto L21;
            View r2 = r1.findViewById(2131370322);
            if (r2 != null) goto L13;
            return;
        L13:
            if (r6.booleanValue() == false) goto L15;
            int r7 = 0;
        L16:
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            r2.setPadding(0, r7, 0, 0);
            ((RelativeLayout.LayoutParams) r3).removeRule(3);
            return;
        L15:
            r7 = DriveFullScreenImmersivePlugin.access$getResources(r1).getDimensionPixelSize(2131166316);
            goto L16
        L21:
            return;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ Function0<Unit> a;

        public l(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0<Unit> c;

        public static final class a implements ViewTreeObserver.OnPreDrawListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ Function0<Unit> b;

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                ViewTreeObserver r0 = this.a.getViewTreeObserver();
                if (r0.isAlive() == false) goto L5;
                r0.removeOnPreDrawListener(this);
            L5:
                this.b.invoke();
                return true;
            }

            public a(View r1, Function0<Unit> r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public m(View r1, String r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            ViewTreeObserver r0 = this.a.getViewTreeObserver();
            if (r0.isAlive() == true) goto L6;
            tt5.a.k(DriveFullScreenImmersivePlugin.TAG, "media presentation preDraw unavailable, fallback callback, fileId=" + this.b);
            this.c.invoke();
            return;
        L6:
            r0.addOnPreDrawListener(new a(this.a, this.c));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class n implements Runnable {
        public final /* synthetic */ Function0 a;

        public n(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final boolean isMediaImmersiveActive() {
        DriveMediaImmersiveVM r0 = this.mMediaImmersiveVM;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isMediaImmersiveActive(isMediaImmersivePreviewEnabled(), getHost().c.isVCFollowMode()) != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean isFooterScrollFullScreenEnabled() {
        com.bytedance.ee.drive.render.k r0 = getDriveUIConfig();
        boolean r2 = false;
        if (r0 == null) goto L10;
        com.bytedance.ee.drive.render.k.d r1 = r0.b();
        if (r1 == null) goto L10;
        if (r1.a == true) goto L10;
        r2 = true;
    L10:
        return !r2;
    }

    private final boolean isMediaImmersivePreviewEnabled() {
        com.bytedance.ee.drive.render.k r0 = getDriveUIConfig();
        if (r0 == null) goto L10;
        com.bytedance.ee.drive.render.k.c r1 = r0.d();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.a != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private final boolean isVcPresentationMode() {
        PreviewViewModel r0 = k75.a.i(getHost());
        if (getHost().c.isVCFollowMode() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r0.liveInnerIsPresentationMode().getValue(), Boolean.TRUE) == false) goto L10;
        return true;
    L10:
        return false;
    }

    private final void switchFullScreenImpl() {
        w75.c r0 = getHost().c.getIFileModel();
        if (r0 == null) goto L17;
        com.bytedance.ee.bear.drive.biz.preview.screen.k r1 = this.mDriveFullScreenManager;
        if (r1 == null) goto L18;
        com.bytedance.ee.bear.drive.biz.preview.screen.a r2 = com.bytedance.ee.bear.drive.biz.preview.screen.b.a(getHost().c, null);
        if (r2 != null) goto L9;
        return;
    L9:
        if (r1.q == true) goto L11;
    L13:
        r2.a = !r1.a;
        boolean r3 = r1.i(r2);
    L14:
        if (r3 == false) goto L20;
        o75.b.a().Ke().v(r0.getDetails(), r1.a);
        return;
    L20:
        return;
    L11:
        if (r1.r == false) goto L13;
        tt5.a.h("DriveFullScreenManager", "ignore fullscreen request: progressive animation running");
        r3 = false;
        goto L14
    L18:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        View r2 = findViewById(2131370319);
        View r0 = findViewById(2131379451);
        View r4 = findViewById(2131370322);
        this.mDriveFullScreenManager = new com.bytedance.ee.bear.drive.biz.preview.screen.k(r2, findViewById(2131370259), r4, getHost().c.isVCFollowMode(), getActivity(), isMediaImmersivePreviewEnabled());
        DriveFullScreenVM r1 = (DriveFullScreenVM) new ViewModelProvider(getActivity()).get(DriveFullScreenVM.class);
        if (r1.getOriginNavigationBarColor() != 0) goto L5;
        r1.setOriginStatusBarColor(getActivity().getWindow().getStatusBarColor());
        r1.setOriginNavigationBarColor(getActivity().getWindow().getNavigationBarColor());
    L5:
        if (r0 == null) goto L11;
        CoordinatorLayout.LayoutParams r3 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r5 = r3;
        if (isFooterScrollFullScreenEnabled() == false) goto L9;
        r5.setBehavior(new FooterBehavior(new b(this)));
        return;
    L9:
        r5.setBehavior(null);
        tt5.a.h(TAG, "disable FooterBehavior fullscreen by uiConfig");
        return;
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        if (getHost().c.fromBlockPreview() == true) goto L5;
    L8:
        DrivePreviewContentPlugin r0 = (DrivePreviewContentPlugin) findPlugin(DrivePreviewContentPlugin.class);
        if (r0 == null) goto L13;
        AbsPreviewView r1 = r0.currentPreviewView();
        if (r1 == null) goto L13;
        Boolean r2 = Boolean.valueOf(r1.onBackPressed());
    L15:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L18;
        tt5.a.h(TAG, "onBackPressed() previewHandled true");
        return true;
    L18:
        com.bytedance.ee.bear.drive.biz.preview.screen.k r3 = this.mDriveFullScreenManager;
        if (r3 != null) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r4 == false) goto L27;
        tt5.a.h(TAG, "onBackPressed() mDriveFullScreenManager handle true,current is fullscreen");
        switchFullScreenImpl();
        return true;
    L27:
        return false;
    L21:
        if (r3.a != true) goto L23;
        r4 = true;
    L13:
        r2 = null;
        goto L15
    L5:
        if (getHost().c.isInBlockFullScreenState() == true) goto L8;
        tt5.a.h(TAG, "onBackPressed() not isInBlockFullScreenState ignore handle");
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        this.mPresentationExitGeneration++;
        com.bytedance.ee.bear.drive.biz.preview.screen.k r0 = this.mDriveFullScreenManager;
        if (r0 == null) goto L8;
        r0.h.cancel();
        r0.i.cancel();
        r0.t = null;
        r0.s.a = null;
        if (r0.q == false) goto L9;
        r0.b();
        return;
    L9:
        return;
    }

    public DriveFullScreenImmersivePlugin() {
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_bear_drive_biz_preview_screen_DriveFullScreenImmersivePlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveFullScreenImmersivePlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.drive.biz.preview.screen.k access$getMDriveFullScreenManager$p(DriveFullScreenImmersivePlugin r0) {
        return r0.mDriveFullScreenManager;
    }

    public static final /* synthetic */ int access$getMPresentationExitGeneration$p(DriveFullScreenImmersivePlugin r0) {
        return r0.mPresentationExitGeneration;
    }

    public static final /* synthetic */ Resources access$getResources(DriveFullScreenImmersivePlugin r0) {
        return r0.getResources();
    }

    public static final /* synthetic */ boolean access$isMediaImmersiveActive(DriveFullScreenImmersivePlugin r0) {
        return r0.isMediaImmersiveActive();
    }

    public static final /* synthetic */ boolean access$isVcPresentationMode(DriveFullScreenImmersivePlugin r0) {
        return r0.isVcPresentationMode();
    }

    public static final /* synthetic */ void access$switchFullScreenImpl(DriveFullScreenImmersivePlugin r0) {
        r0.switchFullScreenImpl();
    }

    private final int getViewType(z r2) {
        if (r2.q != 2) goto L5;
        return 1;
    L5:
        return 0;
    }

    public final boolean exitPreviewPresentationIfNeeded(Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r12, "onComplete");
        String r0 = getHost().c.getOpenEntity().getFileId();
        DrivePreviewContentPlugin r1 = (DrivePreviewContentPlugin) findPlugin(DrivePreviewContentPlugin.class);
        boolean r2 = true;
        if (r1 == null) goto L9;
        AbsPreviewView r3 = r1.currentPreviewView();
        if (r3 == null) goto L9;
        if (r3.onBackPressed() != true) goto L9;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        tt5.a.h(TAG, "exit preview presentation handled by media, fileId=" + r0);
        Intrinsics.checkNotNull(r0);
        runAfterPreviewLayoutStable(r0, r12);
        return true;
    L14:
        w75.c r5 = getHost().c.getIFileModel();
        if (r5 != null) goto L17;
        return false;
    L17:
        com.bytedance.ee.bear.drive.biz.preview.screen.a r6 = com.bytedance.ee.bear.drive.biz.preview.screen.b.a(getHost().c, null);
        if (r6 != null) goto L20;
        return false;
    L20:
        com.bytedance.ee.bear.drive.biz.preview.screen.k r7 = this.mDriveFullScreenManager;
        if (r7 == null) goto L46;
        n r8 = new n(r12);
        if (r7.r == false) goto L32;
        com.bytedance.ee.bear.drive.biz.preview.screen.c r13 = r7.s;
        if (r13.a != null) goto L28;
        r13.a = r8;
    L28:
        if (r7.a == false) goto L30;
        r7.t = r6;
        tt5.a.h("DriveFullScreenManager", "exit preview presentation deferred: entering fullscreen, ext=" + r6.b);
    L42:
        if (r2 == false) goto L45;
        tt5.a.h(TAG, "exit preview presentation handled by outer fullscreen, fileId=" + r0);
        o75.b.a().Ke().v(r5.getDetails(), false);
    L45:
        return r2;
    L30:
        tt5.a.h("DriveFullScreenManager", "exit preview presentation deferred: exiting fullscreen, ext=" + r6.b);
        goto L42
    L32:
        if (r7.a == true) goto L34;
        tt5.a.h("DriveFullScreenManager", "exit preview presentation skipped: not fullscreen, ext=" + r6.b);
    L41:
        r2 = false;
        goto L42
    L34:
        com.bytedance.ee.bear.drive.biz.preview.screen.c r14 = r7.s;
        if (r14.a != null) goto L37;
        r14.a = r8;
    L37:
        tt5.a.h("DriveFullScreenManager", "exit preview presentation start, ext=" + r6.b);
        r6.a = false;
        if (r7.i(r6) == true) goto L42;
        r7.s.a = null;
        tt5.a.k("DriveFullScreenManager", "exit preview presentation rejected by fullscreen manager, ext=" + r6.b);
        goto L41
    L46:
        return false;
    L9:
        r4 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r6) {
        Intrinsics.checkNotNullParameter(r6, "host");
        super.onAttachToHost(r6);
        this.mMediaImmersiveVM = r6.f();
        ((DriveFullScreenVM) new ViewModelProvider(getActivity()).get(DriveFullScreenVM.class)).getLiveFullScreen().observe(getLifecycleOwner(), new d(r6));
        u75.b r0 = r6.c();
        e r1 = new e(this, r6);
        this.mLoadListener = r1;
        r0.c(r1);
        r6.c.livePreviewType().observe(getLifecycleOwner(), new f(r6, this));
        PreviewViewModel r2 = k75.a.i(r6);
        r2.liveInnerVideoFullScreen().observe(getLifecycleOwner(), new g(r6, this));
        r2.liveInnerToggleFullScreen().observe(getLifecycleOwner(), new h(r6, this));
        r2.liveInnerForceFullScreen().observe(getLifecycleOwner(), new i(r6, this));
        DriveCommentVM r3 = (DriveCommentVM) viewModel(DriveCommentVM.class);
        r2.liveInnerSingleTap().observe(getLifecycleOwner(), new j(r3, r6, this));
        ((DriveViewFullScreenVM) viewModel(DriveViewFullScreenVM.class)).getImmersiveTitleTopState().observe(getLifecycleOwner(), new k(this, r6));
        ((DriveConfigurationVM) viewModel(DriveConfigurationVM.class)).isPortrait().observe(getLifecycleOwner(), new c(this, r6, r2));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r6) {
        Intrinsics.checkNotNullParameter(r6, "host");
        super.onDetachFromHost(r6);
        com.bytedance.ee.bear.drive.biz.preview.screen.a r0 = com.bytedance.ee.bear.drive.biz.preview.screen.b.a(r6.c, Boolean.FALSE);
        if (r0 != null) goto L5;
    L23:
        u75.b.a r1 = this.mLoadListener;
        if (r1 == null) goto L26;
        r6.c().g(r1);
    L26:
        this.mMediaImmersiveVM = null;
        return;
    L5:
        if (r6.c.isVCFollowMode() == false) goto L23;
        int r2 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        Integer r3 = Integer.valueOf(r6.c.getBizType());
        boolean r4 = false;
        if (r3 != null) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L23;
        com.bytedance.ee.bear.drive.biz.preview.screen.k r7 = this.mDriveFullScreenManager;
        if (r7 != null) goto L17;
    L19:
        if (r4 == false) goto L23;
        tt5.a.h(TAG, "onDetachFromHost() reset fullscreen: isVCFollowMode & isSpaceFile & isFullScreenMode");
        com.bytedance.ee.bear.drive.biz.preview.screen.k r8 = this.mDriveFullScreenManager;
        if (r8 == null) goto L23;
        r8.f(getActivity(), r0);
        goto L23
    L17:
        if (r7.a != true) goto L19;
        r4 = true;
        goto L19
    L10:
        if (r3.intValue() != 2) goto L12;
        r5 = true;
        goto L13
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    private final void runAfterPreviewLayoutStable(final String r3, final Function0<Unit> r4) {
        final int r0 = this.mPresentationExitGeneration;
        Function0<Unit> r1 = new DriveFullScreenImmersivePlugin$runAfterPreviewLayoutStable$runIfCurrent$1(r0, this, r3, r4);
        View r5 = findViewById(2131370322);
        if (r5 != null) goto L6;
        tt5.a.k(TAG, "media presentation preview view missing, fallback callback, fileId=" + r3);
        INVOKEVIRTUAL_com_bytedance_ee_bear_drive_biz_preview_screen_DriveFullScreenImmersivePlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getActivity().getWindow()).post(new l(r1));
        return;
    L6:
        r5.post(new m(r5, r3, r1));
    }

    public final void initFullScreen(z r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "previewFileModel");
        g85.e r8 = ((g85.b) o75.b.a().getMimeTypeManager()).b(r6.c, null);
        String r0 = r6.c;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        r0 = r6.b;
    L5:
        com.bytedance.ee.bear.drive.biz.preview.screen.k r1 = this.mDriveFullScreenManager;
        if (r1 == null) goto L26;
        MimeTypeCategory r9 = r8.a;
        int r10 = getViewType(r6);
        if (r1.d() == false) goto L29;
        r1.o = r0;
        r1.n = r10;
        DriveMediaImmersiveVM r11 = r1.m;
        if (r11 != null) goto L13;
    L15:
        boolean r12 = false;
    L16:
        if (r12 == false) goto L19;
        r1.p.getLiveTitleBarInTop().postValue(Boolean.TRUE);
        tt5.a.h("DriveFullScreenManager", "initLayout skipped: mediaImmersiveActive category=" + r9);
        return;
    L19:
        if (r9 == MimeTypeCategory.IMAGE) goto L24;
        RelativeLayout.LayoutParams r13 = (RelativeLayout.LayoutParams) r1.d.getLayoutParams();
        if (r1.d.getId() != 2131370322) goto L23;
        r13.addRule(3, 2131370319);
        r13.addRule(2, 2131370259);
    L23:
        r1.d.setPadding(0, 0, 0, 0);
        r1.p.getLiveTitleBarInTop().postValue(Boolean.FALSE);
        return;
    L24:
        RelativeLayout.LayoutParams r14 = (RelativeLayout.LayoutParams) r1.d.getLayoutParams();
        r14.removeRule(3);
        r14.removeRule(2);
        r1.p.getLiveTitleBarInTop().postValue(Boolean.TRUE);
        return;
    L13:
        if (r11.isMediaImmersiveActive(r1.l, r1.k) == false) goto L15;
        r12 = true;
        goto L16
    L29:
        return;
    }
}
