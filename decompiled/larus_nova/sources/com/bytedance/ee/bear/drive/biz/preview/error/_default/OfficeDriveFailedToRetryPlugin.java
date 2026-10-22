package com.bytedance.ee.bear.drive.biz.preview.error._default;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/_default/OfficeDriveFailedToRetryPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "reloadDp", "Lio/reactivex/disposables/Disposable;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "showFailedToRetryView", "Lcom/bytedance/ee/bear/drive/view/preview/retryview/FailedToRetryView;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OfficeDriveFailedToRetryPlugin extends AbsDrivePreviewPlugin {
    private final CompositeDisposable compositeDisposable;
    private Disposable reloadDp;

    public static final class a extends u75.b.C7844b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeDriveFailedToRetryPlugin f223309a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.error._default.OfficeDriveFailedToRetryPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3193a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f223310a = null;

            static {
                int[] r100 = new int[ErrCode.values().length];
                r100[ErrCode.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[ErrCode.REQUEST_TRANSFORM_SERVER_EXP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[ErrCode.REQUEST_FILE_INFO_EXP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[ErrCode.RUST_SUBMIT_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[ErrCode.NO_NETWORK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f223310a = r100;
            }
        }

        public a(OfficeDriveFailedToRetryPlugin r100) {
            this.f223309a = r100;
        }

        @Override // u75.b.C7844b, u75.b.a
        public final void c(ErrCode r100) {
            Intrinsics.checkNotNullParameter(r100, "code");
            DrivePreviewContentPlugin r101 = (DrivePreviewContentPlugin) OfficeDriveFailedToRetryPlugin.access$findPlugin(this.f223309a, DrivePreviewContentPlugin.class);
            if (r101 == null) goto L5;
            AbsPreviewView r102 = r101.currentPreviewView();
        L6:
            if (r102 == null) goto L9;
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin#error in preview, ignore");
            return;
        L9:
            int r103 = C3193a.f223310a[r100.ordinal()];
            if (r103 != 1) goto L12;
        L20:
            this.f223309a.showFailedToRetryView();
            return;
        L12:
            if (r103 == 2) goto L20;
            if (r103 == 3) goto L20;
            if (r103 == 4) goto L20;
            if (r103 == 5) goto L20;
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrivePluginHost f223311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeDriveFailedToRetryPlugin f223312b;

        public b(DrivePluginHost r100, OfficeDriveFailedToRetryPlugin r101) {
            this.f223311a = r100;
            this.f223312b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Void r101 = (Void) r100;
            k75.a.b(this.f223311a).f(k75.a.d(this.f223312b));
            Disposable r102 = OfficeDriveFailedToRetryPlugin.access$getReloadDp$p(this.f223312b);
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            OfficeDriveFailedToRetryPlugin r103 = this.f223312b;
            int r104 = com.bytedance.ee.bear.drive.biz.cache.a.f222617a;
            DrivePluginHost r105 = this.f223311a;
            OfficeDriveFailedToRetryPlugin.access$setReloadDp$p(r103, com.bytedance.ee.bear.drive.biz.cache.a.C3174a.b(r105.f224125c, new com.bytedance.ee.bear.drive.biz.preview.error._default.b(r103, r105), r105.b()));
            Disposable r106 = OfficeDriveFailedToRetryPlugin.access$getReloadDp$p(this.f223312b);
            if (r106 == null) goto L9;
            OfficeDriveFailedToRetryPlugin.access$getCompositeDisposable$p(this.f223312b).add(r106);
            return;
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

    public OfficeDriveFailedToRetryPlugin() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(OfficeDriveFailedToRetryPlugin r100) {
        return r100.compositeDisposable;
    }

    public static final /* synthetic */ Disposable access$getReloadDp$p(OfficeDriveFailedToRetryPlugin r100) {
        return r100.reloadDp;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(OfficeDriveFailedToRetryPlugin r100) {
        return r100.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        r100.c().c(new a(this));
        k75.a.i(r100).liveInnerReload().observe(getLifecycleOwner(), new b(r100, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DrivePluginHost) r100);
    }

    public static final /* synthetic */ f access$findPlugin(OfficeDriveFailedToRetryPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public static final /* synthetic */ void access$setReloadDp$p(OfficeDriveFailedToRetryPlugin r100, Disposable r101) {
        r100.reloadDp = r101;
    }
}
