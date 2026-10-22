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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/_default/OfficeDriveFailedToRetryPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "reloadDp", "Lio/reactivex/disposables/Disposable;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "showFailedToRetryView", "Lcom/bytedance/ee/bear/drive/view/preview/retryview/FailedToRetryView;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OfficeDriveFailedToRetryPlugin extends AbsDrivePreviewPlugin {
    private final CompositeDisposable compositeDisposable;
    private Disposable reloadDp;

    public static final class a extends u75.b.C0306b {
        public final /* synthetic */ OfficeDriveFailedToRetryPlugin a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.error._default.OfficeDriveFailedToRetryPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0137a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ErrCode.values().length];
                r0[ErrCode.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[ErrCode.REQUEST_TRANSFORM_SERVER_EXP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[ErrCode.REQUEST_FILE_INFO_EXP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[ErrCode.RUST_SUBMIT_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[ErrCode.NO_NETWORK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public a(OfficeDriveFailedToRetryPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r3) {
            Intrinsics.checkNotNullParameter(r3, "code");
            DrivePreviewContentPlugin r0 = (DrivePreviewContentPlugin) OfficeDriveFailedToRetryPlugin.access$findPlugin(this.a, DrivePreviewContentPlugin.class);
            if (r0 == null) goto L5;
            AbsPreviewView r1 = r0.currentPreviewView();
        L6:
            if (r1 == null) goto L9;
            tt5.a.h("DriveComponent", "DriveFailedToRetryPlugin#error in preview, ignore");
            return;
        L9:
            int r4 = C0137a.a[r3.ordinal()];
            if (r4 != 1) goto L12;
        L20:
            this.a.showFailedToRetryView();
            return;
        L12:
            if (r4 == 2) goto L20;
            if (r4 == 3) goto L20;
            if (r4 == 4) goto L20;
            if (r4 == 5) goto L20;
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ OfficeDriveFailedToRetryPlugin b;

        public b(DrivePluginHost r1, OfficeDriveFailedToRetryPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            Void r5 = (Void) r4;
            k75.a.b(this.a).f(k75.a.d(this.b));
            Disposable r6 = OfficeDriveFailedToRetryPlugin.access$getReloadDp$p(this.b);
            if (r6 == null) goto L5;
            r6.dispose();
        L5:
            OfficeDriveFailedToRetryPlugin r7 = this.b;
            int r0 = com.bytedance.ee.bear.drive.biz.cache.a.a;
            DrivePluginHost r1 = this.a;
            OfficeDriveFailedToRetryPlugin.access$setReloadDp$p(r7, com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(r1.c, new com.bytedance.ee.bear.drive.biz.preview.error._default.b(r7, r1), r1.b()));
            Disposable r8 = OfficeDriveFailedToRetryPlugin.access$getReloadDp$p(this.b);
            if (r8 == null) goto L9;
            OfficeDriveFailedToRetryPlugin.access$getCompositeDisposable$p(this.b).add(r8);
            return;
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

    public OfficeDriveFailedToRetryPlugin() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(OfficeDriveFailedToRetryPlugin r0) {
        return r0.compositeDisposable;
    }

    public static final /* synthetic */ Disposable access$getReloadDp$p(OfficeDriveFailedToRetryPlugin r0) {
        return r0.reloadDp;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(OfficeDriveFailedToRetryPlugin r0) {
        return r0.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        r4.c().c(new a(this));
        k75.a.i(r4).liveInnerReload().observe(getLifecycleOwner(), new b(r4, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(OfficeDriveFailedToRetryPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$setReloadDp$p(OfficeDriveFailedToRetryPlugin r0, Disposable r1) {
        r0.reloadDp = r1;
    }
}
