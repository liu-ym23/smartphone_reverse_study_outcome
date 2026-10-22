package com.bytedance.ee.bear.drive.biz.preview.loading;

import android.widget.FrameLayout;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.capture.DriveCaptureVM;
import com.bytedance.ee.bear.drive.view.preview.loadingview.BlockLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.LoadingAnimView;
import fo5.d;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/loading/DriveLoadingPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "setUpLoadingView", "tipsText", "", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveLoadingPlugin extends AbsDrivePreviewPlugin {

    public static final class a extends b.C0306b {
        public final /* synthetic */ DriveLoadingPlugin a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.loading.DriveLoadingPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0139a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[InfoCode.values().length];
                r0[InfoCode.PreFetchFileInfo.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public a(DriveLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r1, T r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
            if (C0139a.a[r1.ordinal()] != 1) goto L11;
            DrivePreviewContentPlugin r3 = (DrivePreviewContentPlugin) DriveLoadingPlugin.access$findPlugin(this.a, DrivePreviewContentPlugin.class);
            if (r3 != null) goto L7;
        L9:
            DriveLoadingPlugin.access$setUpLoadingView(this.a, "");
            return;
        L7:
            if (r3.isShowingContent() == false) goto L9;
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveLoadingPlugin() {
    }

    private final void setUpLoadingView(String r5) {
        Integer r0 = (Integer) ((DrivePluginHost) getHost()).c.livePreviewType().getValue();
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        if (r1 == false) goto L16;
        BlockLoadingView r6 = new BlockLoadingView(getContext());
        DriveComponentRenderVM r3 = (DriveComponentRenderVM) ((DrivePluginHost) getHost()).d().viewModel(DriveComponentRenderVM.class);
        r6.b = r3;
        r3.bindReleaseListener(r6);
        r6.setLayoutParams(r2);
        if (Intrinsics.areEqual(((DriveCaptureVM) viewModel(DriveCaptureVM.class)).getInCapture().getValue(), Boolean.TRUE) == false) goto L14;
        r6.setVisibility(0);
    L15:
        removeAndAddPreviewView(r6);
        return;
    L14:
        r6.setVisibility(8);
        Disposable r4 = Observable.timer(400, TimeUnit.MILLISECONDS).observeOn(d.d()).doOnComplete(new com.bytedance.ee.bear.drive.view.preview.loadingview.a(r6)).subscribe();
        r6.a.add(r4);
        goto L15
    L16:
        LoadingAnimView r7 = new LoadingAnimView(getContext());
        r7.c(((DrivePluginHost) getHost()).d());
        r7.setGravity(17);
        r7.setLayoutParams(r2);
        r7.a();
        removeAndAddPreviewView(r7);
        r7.setTipText(r5);
        return;
    L6:
        if (r0.intValue() != 3) goto L8;
        r1 = true;
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        r2.c().c(new a(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DriveLoadingPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$setUpLoadingView(DriveLoadingPlugin r0, String r1) {
        r0.setUpLoadingView(r1);
    }
}
