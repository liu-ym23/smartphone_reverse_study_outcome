package com.bytedance.ee.bear.drive.biz.wps;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.encryption.DriveEncryptionVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveThirdPartyPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.loadingview.BlockLoadingView;
import com.bytedance.ee.bear.drive.view.preview.wps.WpsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/wps/DriveWPSLoadingPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "loadingView", "Lcom/bytedance/ee/bear/drive/view/preview/loadingview/BlockLoadingView;", "getLoadingView", "()Lcom/bytedance/ee/bear/drive/view/preview/loadingview/BlockLoadingView;", "setLoadingView", "(Lcom/bytedance/ee/bear/drive/view/preview/loadingview/BlockLoadingView;)V", "preloadLoadingView", "getPreloadLoadingView", "setPreloadLoadingView", "onAttachToHost", "", "host", "setupLoadingView", "setupPreloadView", "dismissLoadingView", "dismissPreloadView", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveWPSLoadingPlugin extends BasePlugin<DrivePluginHost> {
    public static final a Companion = null;
    private static final String TAG = "DriveWPSLoadingPlugin";
    private BlockLoadingView loadingView;
    private BlockLoadingView preloadLoadingView;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ DriveWPSLoadingPlugin a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[InfoCode.values().length];
                r0[InfoCode.FileInfoSuccess.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public b(DriveWPSLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r1, T r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
            if (a.a[r1.ordinal()] != 1) goto L6;
            DriveWPSLoadingPlugin.access$setupLoadingView(this.a);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveWPSLoadingPlugin a;

        public c(DriveWPSLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((String) r1) == null) goto L6;
            DriveWPSLoadingPlugin.access$dismissLoadingView(this.a);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveWPSLoadingPlugin a;

        public d(DriveWPSLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((String) r1) == null) goto L6;
            DriveWPSLoadingPlugin r2 = this.a;
            DriveWPSLoadingPlugin.access$dismissLoadingView(r2);
            DriveWPSLoadingPlugin.access$dismissPreloadView(r2);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DriveWPSLoadingPlugin a;

        public e(DriveWPSLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((String) r1) == null) goto L6;
            DriveWPSLoadingPlugin.access$dismissPreloadView(this.a);
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DriveWPSLoadingPlugin a;

        public f(DriveWPSLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((String) r1) == null) goto L6;
            DriveWPSLoadingPlugin.access$setupPreloadView(this.a);
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ DriveWPSLoadingPlugin a;

        public g(DriveWPSLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ThirdPartyAttachmentPermission r3 = (ThirdPartyAttachmentPermission) r2;
            DriveThirdPartyPermissionVM r4 = (DriveThirdPartyPermissionVM) DriveWPSLoadingPlugin.access$viewModel(this.a, DriveThirdPartyPermissionVM.class);
            if (r4 == null) goto L7;
            boolean r0 = true;
            if (r4.isFilePermission() != true) goto L7;
        L8:
            if (r0 == false) goto L11;
            DriveWPSLoadingPlugin.access$dismissLoadingView(this.a);
            DriveWPSLoadingPlugin.access$dismissPreloadView(this.a);
            return;
        L11:
            return;
        L7:
            r0 = false;
            goto L8
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ DriveWPSLoadingPlugin a;

        public h(DriveWPSLoadingPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
            DriveWPSLoadingPlugin.access$dismissLoadingView(this.a);
            DriveWPSLoadingPlugin.access$dismissPreloadView(this.a);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void dismissLoadingView() {
        if (this.loadingView == null) goto L6;
        getUIContainer().m(this, this.loadingView);
        return;
    }

    private final void dismissPreloadView() {
        if (this.preloadLoadingView == null) goto L6;
        getUIContainer().m(this, this.preloadLoadingView);
        return;
    }

    private final void setupPreloadView() {
        BlockLoadingView r0 = new BlockLoadingView(getContext(), 0);
        this.preloadLoadingView = r0;
        DriveComponentRenderVM r1 = (DriveComponentRenderVM) getHost().d().viewModel(DriveComponentRenderVM.class);
        r0.b = r1;
        r1.bindReleaseListener(r0);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        getUIContainer().h(this, this.preloadLoadingView);
    }

    private final void setupLoadingView() {
        Integer r0 = (Integer) getHost().c.livePreviewType().getValue();
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        w75.a r3 = getHost().c.getFileModel();
        if (r3 != null) goto L12;
    L14:
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -1);
        if (r2 == false) goto L19;
        if (r1 == false) goto L20;
        BlockLoadingView r5 = new BlockLoadingView(getContext());
        this.loadingView = r5;
        DriveComponentRenderVM r6 = (DriveComponentRenderVM) getHost().d().viewModel(DriveComponentRenderVM.class);
        r5.b = r6;
        r6.bindReleaseListener(r5);
        r5.setLayoutParams(r4);
        getUIContainer().h(this, this.loadingView);
        return;
    L20:
        return;
    L19:
        return;
    L12:
        if (r3.q != 2) goto L14;
        r1 = true;
        goto L14
    L6:
        if (r0.intValue() != 3) goto L8;
        r2 = true;
        goto L9
    }

    public DriveWPSLoadingPlugin() {
    }

    public final BlockLoadingView getLoadingView() {
        return this.loadingView;
    }

    public final BlockLoadingView getPreloadLoadingView() {
        return this.preloadLoadingView;
    }

    public static final /* synthetic */ void access$dismissLoadingView(DriveWPSLoadingPlugin r0) {
        r0.dismissLoadingView();
    }

    public static final /* synthetic */ void access$dismissPreloadView(DriveWPSLoadingPlugin r0) {
        r0.dismissPreloadView();
    }

    public static final /* synthetic */ void access$setupLoadingView(DriveWPSLoadingPlugin r0) {
        r0.setupLoadingView();
    }

    public static final /* synthetic */ void access$setupPreloadView(DriveWPSLoadingPlugin r0) {
        r0.setupPreloadView();
    }

    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        r3.c().c(new b(this));
        ((WpsViewModel) viewModel(WpsViewModel.class)).getSuccessLiveData().observe(getLifecycleOwner(), new c(this));
        ((WpsViewModel) viewModel(WpsViewModel.class)).getErrorLiveData().observe(getLifecycleOwner(), new d(this));
        ((WpsViewModel) viewModel(WpsViewModel.class)).getPreloadLoadEndLiveData().observe(getLifecycleOwner(), new e(this));
        ((WpsViewModel) viewModel(WpsViewModel.class)).getPreloadStartLiveData().observe(getLifecycleOwner(), new f(this));
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new g(this));
        ((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).getEncryptionKeyDeleted().observe(getLifecycleOwner(), new h(this));
    }

    public final void setLoadingView(BlockLoadingView r1) {
        this.loadingView = r1;
    }

    public final void setPreloadLoadingView(BlockLoadingView r1) {
        this.preloadLoadingView = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveWPSLoadingPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
