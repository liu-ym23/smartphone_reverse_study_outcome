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
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/_default/DriveFailedToRetryPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "reloadDp", "Lio/reactivex/disposables/Disposable;", "thirdPartyPadding", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachPreview", "showFailedToRetryView", "Lcom/bytedance/ee/bear/drive/view/preview/retryview/FailedToRetryView;", "showFilePreviewFailed", "viewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewViewModel;", "driveModel", "Lcom/bytedance/ee/bear/drive/core/DriveViewModel;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DriveFailedToRetryPlugin extends AbsDrivePreviewPlugin {
    private final CompositeDisposable compositeDisposable;
    private Disposable reloadDp;
    private final int thirdPartyPadding;

    public static final class a extends u75.b.C7844b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveFailedToRetryPlugin f223299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DrivePluginHost f223300b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.error._default.DriveFailedToRetryPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3192a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f223301a = null;

            static {
                int[] r100 = new int[ErrCode.values().length];
                r100[ErrCode.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
            L23:
                r100[ErrCode.REQUEST_TRANSFORM_SERVER_EXP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
            L35:
                r100[ErrCode.REQUEST_FILE_INFO_EXP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
            L25:
                r100[ErrCode.RUST_SUBMIT_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
            L27:
                r100[ErrCode.NO_NETWORK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
            L21:
                r100[ErrCode.RUST_NOT_LOGIN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
            L29:
                r100[ErrCode.THIRD_SECRET_FILE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
            L31:
                r100[ErrCode.COPY_FAILED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
            L11:
                f223301a = r100;
            }
        }

        @Override // u75.b.C7844b, u75.b.a
        public final void c(ErrCode r100) {
            Intrinsics.checkNotNullParameter(r100, "code");
            DrivePreviewContentPlugin r101 = (DrivePreviewContentPlugin) DriveFailedToRetryPlugin.access$findPlugin(this.f223299a, DrivePreviewContentPlugin.class);
            if (r101 == null) goto L5;
            AbsPreviewView r102 = r101.currentPreviewView();
        L7:
            if (r102 == null) goto L11;
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin#error in preview, ignore");
            return;
        L11:
            switch(C3192a.f223301a[r100.ordinal()]) {
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
            FailedToRetryView r103 = this.f223299a.showFailedToRetryView();
            r103.g();
            r103.setPlaceHolderText(DriveFailedToRetryPlugin.access$getResources(this.f223299a).getString(R.string.CreationMobile_ECM_CreateLaterToast));
            return;
        L14:
            x95.a r104 = new x95.a(DriveFailedToRetryPlugin.access$getContext(this.f223299a));
            ViewOwner r105 = this.f223300b.e();
            if (r105 == null) goto L17;
            r104.a(r105, -1);
        L17:
            r104.setTitle("");
            r104.setDesc(DriveFailedToRetryPlugin.access$getString(this.f223299a, R.string.LarkCCM_Perms_ThirdParty_UnableToPreview_Toast));
            int r106 = DriveFailedToRetryPlugin.access$getThirdPartyPadding$p(this.f223299a);
            int r107 = DriveFailedToRetryPlugin.access$getThirdPartyPadding$p(this.f223299a);
            r104.f562980b.setPadding(y9c.d.a(r106), 0, y9c.d.a(r107), 0);
            DriveFailedToRetryPlugin.access$removeAndAddPreviewView(this.f223299a, r104);
            return;
        L18:
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin RUST_NOT_LOGIN not show retry and openExternal ");
            FailedToRetryView r108 = this.f223299a.showFailedToRetryView();
            r108.showPrimaryAction(false);
            r108.showSecondaryAction(false);
            return;
        L19:
            FailedToRetryView r109 = this.f223299a.showFailedToRetryView();
            if (ServerErrParser.isAuthFail(r100.getCause()) == false) goto L23;
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin isAuthFail not show retry and openExternal ");
            r109.showPrimaryAction(false);
            r109.showSecondaryAction(false);
        L23:
            if (ServerErrParser.isPreviewDLPFail(r100.getCause()) == false) goto L31;
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin isPreviewDLPFail not show retry and openExternal ");
            FailedToRetryView r110 = this.f223299a.showFailedToRetryView();
            r110.showPrimaryAction(false);
            r110.showSecondaryAction(false);
            r110.setPlaceHolderText(DriveFailedToRetryPlugin.access$getResources(this.f223299a).getString(R.string.LarkCCM_IM_DLP_UnableToViewFileSensitiveInfoNew_Text));
            DriveTitleBarVisibilityPlugin r111 = (DriveTitleBarVisibilityPlugin) DriveFailedToRetryPlugin.access$findPlugin(this.f223299a, DriveTitleBarVisibilityPlugin.class);
            if (r111 == null) goto L32;
            r111.updateDLpStatus(true);
            return;
        L32:
            return;
        L31:
            return;
        L33:
            return;
        L5:
            r102 = null;
            goto L7
        }

        public a(DriveFailedToRetryPlugin r100, DrivePluginHost r101) {
            this.f223299a = r100;
            this.f223300b = r101;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveFailedToRetryPlugin f223302a;

        public b(DriveFailedToRetryPlugin r100) {
            this.f223302a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Void r101 = (Void) r100;
            this.f223302a.showFailedToRetryView();
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrivePluginHost f223303a;

        public c(DrivePluginHost r100) {
            this.f223303a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Void r101 = (Void) r100;
            k75.a.a(this.f223303a);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrivePluginHost f223304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DriveFailedToRetryPlugin f223305b;

        public d(DrivePluginHost r100, DriveFailedToRetryPlugin r101) {
            this.f223304a = r100;
            this.f223305b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Void r101 = (Void) r100;
            k75.a.b(this.f223304a).f(k75.a.d(this.f223305b));
            Disposable r102 = DriveFailedToRetryPlugin.access$getReloadDp$p(this.f223305b);
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            DriveFailedToRetryPlugin r103 = this.f223305b;
            int r104 = com.bytedance.ee.bear.drive.biz.cache.a.f222617a;
            DrivePluginHost r105 = this.f223304a;
            DriveFailedToRetryPlugin.access$setReloadDp$p(r103, com.bytedance.ee.bear.drive.biz.cache.a.C3174a.b(r105.f224125c, new com.bytedance.ee.bear.drive.biz.preview.error._default.a(r103, r105), r105.b()));
            Disposable r106 = DriveFailedToRetryPlugin.access$getReloadDp$p(this.f223305b);
            if (r106 == null) goto L9;
            DriveFailedToRetryPlugin.access$getCompositeDisposable$p(this.f223305b).add(r106);
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrivePluginHost f223306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PreviewViewModel f223307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DriveFailedToRetryPlugin f223308c;

        public e(DrivePluginHost r100, PreviewViewModel r101, DriveFailedToRetryPlugin r102) {
            this.f223306a = r100;
            this.f223307b = r101;
            this.f223308c = r102;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Void r101 = (Void) r100;
            StringBuilder r102 = new StringBuilder("DriveFailedToRetryPlugin liveInnerShowPreviewFailedPage，it is null=");
            if (r101 != null) goto L5;
            boolean r103 = true;
        L6:
            r102.append(r103);
            tt5.a.h("DriveComponent", r102.toString());
            if (this.f223306a.f224125c.getFileModel() == null) goto L11;
            this.f223307b.liveOuterExportVisible().postValue(Boolean.TRUE);
            this.f223308c.showFilePreviewFailed(this.f223307b, this.f223306a.f224125c);
            return;
        L11:
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public FailedToRetryView showFailedToRetryView() {
        FailedToRetryView r100 = new ka5.c(getActivity()).a(((DrivePluginHost) getHost()).e(), k75.a.i((DrivePluginHost) getHost()));
        removeAndAddPreviewView(r100);
        r100.setVisibility(0);
        dispatchToBlockHandler(3);
        return r100;
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

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(DriveFailedToRetryPlugin r100) {
        return r100.compositeDisposable;
    }

    public static final /* synthetic */ Context access$getContext(DriveFailedToRetryPlugin r100) {
        return r100.getContext();
    }

    public static final /* synthetic */ Disposable access$getReloadDp$p(DriveFailedToRetryPlugin r100) {
        return r100.reloadDp;
    }

    public static final /* synthetic */ Resources access$getResources(DriveFailedToRetryPlugin r100) {
        return r100.getResources();
    }

    public static final /* synthetic */ int access$getThirdPartyPadding$p(DriveFailedToRetryPlugin r100) {
        return r100.thirdPartyPadding;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DriveFailedToRetryPlugin r100) {
        return r100.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        r100.c().c(new a(this, r100));
        k75.a.i(r100).liveInnerShowRetryPage().observe(getLifecycleOwner(), new b(this));
        k75.a.i(r100).liveInnerClosePage().observe(getLifecycleOwner(), new c(r100));
        PreviewViewModel r101 = k75.a.i(r100);
        r101.liveInnerReload().observe(getLifecycleOwner(), new d(r100, this));
        r101.getLiveInnerShowPreviewFailedPage().observe(getLifecycleOwner(), new e(r100, r101, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DrivePluginHost) r100);
    }

    public static final /* synthetic */ f access$findPlugin(DriveFailedToRetryPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public static final /* synthetic */ String access$getString(DriveFailedToRetryPlugin r100, int r101) {
        return r100.getString(r101);
    }

    public static final /* synthetic */ void access$removeAndAddPreviewView(DriveFailedToRetryPlugin r100, View r101) {
        r100.removeAndAddPreviewView(r101);
    }

    public static final /* synthetic */ void access$setReloadDp$p(DriveFailedToRetryPlugin r100, Disposable r101) {
        r100.reloadDp = r101;
    }

    public void showFilePreviewFailed(PreviewViewModel r100, DriveViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "driveModel");
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == true) goto L5;
        return;
    L5:
        w75.a r102 = r101.getFileModel();
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.d() == false) goto L11;
        int r103 = R.string.Drive_Drive_File_Preview_Failed;
    L12:
        PlaceHolderView r104 = new PlaceHolderView(getContext());
        r104.b(((DrivePluginHost) getHost()).d(), ((DrivePluginHost) getHost()).e());
        r104.setImagePlaceHolder(R.drawable.ccm_empty_neutral_no_preview);
        r104.setTipsText(getContext().getString(r103));
        r104.setPrimaryText(getContext().getString(R.string.Drive_Drive_OpenWithOtherApps));
        r104.setSizeInBytes(r102.i().f225837e);
        new x(getContext(), r104, com.bytedance.ee.bear.drive.biz.external.f.e(((DrivePluginHost) getHost()).f224125c.getBizType(), getContext(), ((DrivePluginHost) getHost()).b()), new ViewOwner(getHost(), getLifecycleOwner()), r102.i());
        removeAndAddPreviewView(r104);
        r104.setVisibility(0);
        return;
    L11:
        r103 = R.string.CreationMobile_Preview_ExtensionMismatch_placeholder;
        goto L12
    }
}
