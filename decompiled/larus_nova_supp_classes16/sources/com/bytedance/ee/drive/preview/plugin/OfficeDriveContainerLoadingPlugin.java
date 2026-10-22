package com.bytedance.ee.drive.preview.plugin;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.render.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/drive/preview/plugin/OfficeDriveContainerLoadingPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "hideContainerLoading", "fileLoadingObserver", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "startFileLoadingObserver", "stopFileLoadingObserver", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDriveContainerLoadingPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    private static final String TAG = "OfficeDriveContainerLoadingPlugin";
    private final u75.b.a fileLoadingObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ OfficeDriveContainerLoadingPlugin a;

        public b(OfficeDriveContainerLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void b(z r2) {
            Intrinsics.checkNotNullParameter(r2, "previewFileModel");
            Intrinsics.checkNotNullParameter(r2, "previewFileModel");
            OfficeDriveContainerLoadingPlugin.access$hideContainerLoading(this.a);
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r3) {
            Intrinsics.checkNotNullParameter(r3, "code");
            Intrinsics.checkNotNullParameter(r3, "code");
            tt5.a.k(OfficeDriveContainerLoadingPlugin.TAG, "onFailed: ErrCode:" + r3);
            if (r3 != ErrCode.NO_NETWORK) goto L6;
            OfficeDriveContainerLoadingPlugin.access$hideContainerLoading(this.a);
            return;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r1, T r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
            Intrinsics.checkNotNullParameter(r1, "code");
            if (r1 != InfoCode.FileInfoSuccess) goto L6;
            OfficeDriveContainerLoadingPlugin.access$hideContainerLoading(this.a);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeDriveContainerLoadingPlugin() {
        this.fileLoadingObserver = new b(this);
    }

    private final void hideContainerLoading() {
        i r0 = (i) getHost().getHostAbilityOrNull(i.class);
        if (r0 == null) goto L6;
        r0.hideLoading();
        return;
    }

    private final void startFileLoadingObserver() {
        getHost().c().c(this.fileLoadingObserver);
    }

    private final void stopFileLoadingObserver() {
        getHost().c().g(this.fileLoadingObserver);
    }

    public static final /* synthetic */ void access$hideContainerLoading(OfficeDriveContainerLoadingPlugin r0) {
        r0.hideContainerLoading();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        startFileLoadingObserver();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        stopFileLoadingObserver();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }
}
