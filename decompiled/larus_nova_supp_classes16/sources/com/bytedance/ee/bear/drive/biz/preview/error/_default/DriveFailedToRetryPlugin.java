package com.bytedance.ee.bear.drive.biz.preview.error._default;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.loader.download.platform.api.ServerErrParser;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PlaceHolderView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.x;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/_default/DriveFailedToRetryPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "reloadDp", "Lio/reactivex/disposables/Disposable;", "thirdPartyPadding", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachPreview", "showFailedToRetryView", "Lcom/bytedance/ee/bear/drive/view/preview/retryview/FailedToRetryView;", "showFilePreviewFailed", "viewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewViewModel;", "driveModel", "Lcom/bytedance/ee/bear/drive/core/DriveViewModel;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DriveFailedToRetryPlugin extends AbsDrivePreviewPlugin {
    private final CompositeDisposable compositeDisposable;
    private Disposable reloadDp;
    private final int thirdPartyPadding;

    public static final class a extends u75.b.C0306b {
        public final /* synthetic */ DriveFailedToRetryPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.error._default.DriveFailedToRetryPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0136a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ErrCode.values().length];
                r0[ErrCode.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
            L23:
                r0[ErrCode.REQUEST_TRANSFORM_SERVER_EXP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
            L35:
                r0[ErrCode.REQUEST_FILE_INFO_EXP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
            L25:
                r0[ErrCode.RUST_SUBMIT_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
            L27:
                r0[ErrCode.NO_NETWORK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
            L21:
                r0[ErrCode.RUST_NOT_LOGIN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
            L29:
                r0[ErrCode.THIRD_SECRET_FILE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
            L31:
                r0[ErrCode.COPY_FAILED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
            L11:
                a = r0;
            }
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r5) {
            Intrinsics.checkNotNullParameter(r5, "code");
            DrivePreviewContentPlugin r0 = (DrivePreviewContentPlugin) DriveFailedToRetryPlugin.access$findPlugin(this.a, DrivePreviewContentPlugin.class);
            if (r0 == null) goto L5;
            AbsPreviewView r1 = r0.currentPreviewView();
        L7:
            if (r1 == null) goto L11;
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin#error in preview, ignore");
            return;
        L11:
            switch(C0136a.a[r5.ordinal()]) {
                case 1: goto L19;
                case 2: goto L19;
                case 3: goto L19;
                case 4: goto L19;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L14;
                case 8: goto L13;
                default: goto L33;
            };
        L13:
            FailedToRetryView r6 = this.a.showFailedToRetryView();
            r6.g();
            r6.setPlaceHolderText(DriveFailedToRetryPlugin.access$getResources(this.a).getString(2131887249));
            return;
        L14:
            x95.a r7 = new x95.a(DriveFailedToRetryPlugin.access$getContext(this.a));
            ViewOwner r2 = this.b.e();
            if (r2 == null) goto L17;
            r7.a(r2, -1);
        L17:
            r7.setTitle("");
            r7.setDesc(DriveFailedToRetryPlugin.access$getString(this.a, 2131889705));
            int r3 = DriveFailedToRetryPlugin.access$getThirdPartyPadding$p(this.a);
            int r4 = DriveFailedToRetryPlugin.access$getThirdPartyPadding$p(this.a);
            r7.b.setPadding(y9c.d.a(r3), 0, y9c.d.a(r4), 0);
            DriveFailedToRetryPlugin.access$removeAndAddPreviewView(this.a, r7);
            return;
        L18:
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin RUST_NOT_LOGIN not show retry and openExternal ");
            FailedToRetryView r8 = this.a.showFailedToRetryView();
            r8.showPrimaryAction(false);
            r8.showSecondaryAction(false);
            return;
        L19:
            FailedToRetryView r9 = this.a.showFailedToRetryView();
            if (ServerErrParser.isAuthFail(r5.getCause()) == false) goto L23;
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin isAuthFail not show retry and openExternal ");
            r9.showPrimaryAction(false);
            r9.showSecondaryAction(false);
        L23:
            if (ServerErrParser.isPreviewDLPFail(r5.getCause()) == false) goto L31;
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin isPreviewDLPFail not show retry and openExternal ");
            FailedToRetryView r10 = this.a.showFailedToRetryView();
            r10.showPrimaryAction(false);
            r10.showSecondaryAction(false);
            r10.setPlaceHolderText(DriveFailedToRetryPlugin.access$getResources(this.a).getString(2131889535));
            DriveTitleBarVisibilityPlugin r11 = (DriveTitleBarVisibilityPlugin) DriveFailedToRetryPlugin.access$findPlugin(this.a, DriveTitleBarVisibilityPlugin.class);
            if (r11 == null) goto L32;
            r11.updateDLpStatus(true);
            return;
        L32:
            return;
        L31:
            return;
        L33:
            return;
        L5:
            r1 = null;
            goto L7
        }

        public a(DriveFailedToRetryPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveFailedToRetryPlugin a;

        public b(DriveFailedToRetryPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Void r2 = (Void) r1;
            this.a.showFailedToRetryView();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;

        public c(DrivePluginHost r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Void r2 = (Void) r1;
            k75.a.a(this.a);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveFailedToRetryPlugin b;

        public d(DrivePluginHost r1, DriveFailedToRetryPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            Void r5 = (Void) r4;
            k75.a.b(this.a).f(k75.a.d(this.b));
            Disposable r6 = DriveFailedToRetryPlugin.access$getReloadDp$p(this.b);
            if (r6 == null) goto L5;
            r6.dispose();
        L5:
            DriveFailedToRetryPlugin r7 = this.b;
            int r0 = com.bytedance.ee.bear.drive.biz.cache.a.a;
            DrivePluginHost r1 = this.a;
            DriveFailedToRetryPlugin.access$setReloadDp$p(r7, com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(r1.c, new com.bytedance.ee.bear.drive.biz.preview.error._default.a(r7, r1), r1.b()));
            Disposable r8 = DriveFailedToRetryPlugin.access$getReloadDp$p(this.b);
            if (r8 == null) goto L9;
            DriveFailedToRetryPlugin.access$getCompositeDisposable$p(this.b).add(r8);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ PreviewViewModel b;
        public final /* synthetic */ DriveFailedToRetryPlugin c;

        public e(DrivePluginHost r1, PreviewViewModel r2, DriveFailedToRetryPlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r3) {
            Void r4 = (Void) r3;
            StringBuilder r0 = new StringBuilder("DriveFailedToRetryPlugin liveInnerShowPreviewFailedPage，it is null=");
            if (r4 != null) goto L5;
            boolean r5 = true;
        L6:
            r0.append(r5);
            tt5.a.h("DriveComponent", r0.toString());
            if (this.a.c.getFileModel() == null) goto L11;
            this.b.liveOuterExportVisible().postValue(Boolean.TRUE);
            this.c.showFilePreviewFailed(this.b, this.a.c);
            return;
        L11:
            return;
        L5:
            r5 = false;
            goto L6
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.LinearLayout, com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView] */
    public FailedToRetryView showFailedToRetryView() {
        ?? r0 = new ka5.c(getActivity()).a(((DrivePluginHost) getHost()).e(), k75.a.i((DrivePluginHost) getHost()));
        removeAndAddPreviewView(r0);
        r0.setVisibility(0);
        dispatchToBlockHandler(3);
        return r0;
    }

    public DriveFailedToRetryPlugin() {
        this.compositeDisposable = new CompositeDisposable();
        this.thirdPartyPadding = 64;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        this.compositeDisposable.clear();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(DriveFailedToRetryPlugin r0) {
        return r0.compositeDisposable;
    }

    public static final /* synthetic */ Context access$getContext(DriveFailedToRetryPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ Disposable access$getReloadDp$p(DriveFailedToRetryPlugin r0) {
        return r0.reloadDp;
    }

    public static final /* synthetic */ Resources access$getResources(DriveFailedToRetryPlugin r0) {
        return r0.getResources();
    }

    public static final /* synthetic */ int access$getThirdPartyPadding$p(DriveFailedToRetryPlugin r0) {
        return r0.thirdPartyPadding;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DriveFailedToRetryPlugin r0) {
        return r0.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        r5.c().c(new a(this, r5));
        k75.a.i(r5).liveInnerShowRetryPage().observe(getLifecycleOwner(), new b(this));
        k75.a.i(r5).liveInnerClosePage().observe(getLifecycleOwner(), new c(r5));
        PreviewViewModel r0 = k75.a.i(r5);
        r0.liveInnerReload().observe(getLifecycleOwner(), new d(r5, this));
        r0.getLiveInnerShowPreviewFailedPage().observe(getLifecycleOwner(), new e(r5, r0, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DriveFailedToRetryPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ String access$getString(DriveFailedToRetryPlugin r0, int r1) {
        return r0.getString(r1);
    }

    public static final /* synthetic */ void access$removeAndAddPreviewView(DriveFailedToRetryPlugin r0, View r1) {
        r0.removeAndAddPreviewView(r1);
    }

    public static final /* synthetic */ void access$setReloadDp$p(DriveFailedToRetryPlugin r0, Disposable r1) {
        r0.reloadDp = r1;
    }

    public void showFilePreviewFailed(PreviewViewModel r8, DriveViewModel r9) {
        Intrinsics.checkNotNullParameter(r8, "viewModel");
        Intrinsics.checkNotNullParameter(r9, "driveModel");
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == true) goto L5;
        return;
    L5:
        w75.a r10 = r9.getFileModel();
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.d() == false) goto L11;
        int r11 = 2131888398;
    L12:
        PlaceHolderView r6 = new PlaceHolderView(getContext());
        r6.b(((DrivePluginHost) getHost()).d(), ((DrivePluginHost) getHost()).e());
        r6.setImagePlaceHolder(2131232553);
        r6.setTipsText(getContext().getString(r11));
        r6.setPrimaryText(getContext().getString(2131888429));
        r6.setSizeInBytes(r10.i().e);
        new x(getContext(), r6, com.bytedance.ee.bear.drive.biz.external.f.e(((DrivePluginHost) getHost()).c.getBizType(), getContext(), ((DrivePluginHost) getHost()).b()), new ViewOwner(getHost(), getLifecycleOwner()), r10.i());
        removeAndAddPreviewView(r6);
        r6.setVisibility(0);
        return;
    L11:
        r11 = 2131887363;
        goto L12
    }
}
