package com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.drive.biz.external.f;
import com.bytedance.ee.bear.drive.biz.external.g;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/download/spacefile/DriveSpaceFileDownloadPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "spaceFileDownloadManager", "Lcom/bytedance/ee/bear/drive/biz/preview/more/download/spacefile/SpaceFileDownloadManager;", "openExternalHelper", "Lcom/bytedance/ee/bear/drive/biz/external/OpenExternalHelper;", "onAttachToHost", "", "host", "openWithOtherApps", "saveToLocal", "onDetachFromHost", "cancelTask", "bindPermission", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileDownloadPlugin extends BasePlugin<DrivePluginHost> {
    public static final a Companion = null;
    private static final String TAG = "SpaceFileDownloadPlugin";
    private f openExternalHelper;
    private SpaceFileDownloadManager spaceFileDownloadManager;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileDownloadPlugin a;

        public b(DriveSpaceFileDownloadPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            u55.b r4 = (u55.b) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.d() == true) goto L8;
            tt5.a.h(DriveSpaceFileDownloadPlugin.TAG, "No export permission, cancelTask.");
            DriveSpaceFileDownloadPlugin.access$cancelTask(this.a);
        L8:
            if (r4.e() == true) goto L12;
            tt5.a.h(DriveSpaceFileDownloadPlugin.TAG, "No read permission, hideFileStateDialog.");
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).y();
            return;
        }
    }

    public static final class c implements f.c {
        public final /* synthetic */ f85.a.C0229a a;

        public c(f85.a.C0229a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.external.f.c
        public final String getFileId() {
            return this.a.a;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void bindPermission() {
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new b(this));
    }

    private final void cancelTask() {
        SpaceFileDownloadManager r0 = this.spaceFileDownloadManager;
        if (r0 == null) goto L5;
        r0.e.b();
    L5:
        f r1 = this.openExternalHelper;
        if (r1 == null) goto L9;
        r1.b();
        return;
    }

    public final void openWithOtherApps() {
        tt5.a.h(TAG, "saveToLocal.");
        if (this.openExternalHelper != null) goto L5;
        this.openExternalHelper = new f(getContext(), null, new g(), getHost().b());
    L5:
        f85.a r0 = (f85.a) getHost().c.getFileModel();
        if (r0 != null) goto L8;
        return;
    L8:
        f85.a.C0229a r1 = (f85.a.C0229a) r0.a;
        if (r1 != null) goto L11;
        return;
    L11:
        f r2 = this.openExternalHelper;
        if (r2 == null) goto L14;
        r2.a = new c(r1);
    L14:
        if (r2 == null) goto L17;
        com.bytedance.ee.bear.drive.biz.external.a.C0122a r3 = new com.bytedance.ee.bear.drive.biz.external.a.C0122a();
        r3.b = r1.c;
        r3.a = r1.a;
        r3.c = r1.h;
        r3.d = r1.n;
        r3.e = "from_drive_more_api_download";
        r3.f = getHost().c.getOpenEntity().getBizScene();
        r3.g = getHost().c.getOpenEntity().getWatermarkScene();
        r2.g(new com.bytedance.ee.bear.drive.biz.external.a(r3), null, "LARK-PSDA-ccm_space_drive_preview_download");
        return;
    }

    public final void saveToLocal() {
        tt5.a.h(TAG, "openWithOtherApps.");
        DrivePluginHost r0 = getHost();
        if (r0 == null) goto L10;
        DriveViewModel r1 = r0.c;
        if (r1 == null) goto L10;
        BaseOpenEntity r2 = r1.getOpenEntity();
        if (r2 == null) goto L10;
        r2.setDownloadFrom("from_drive_more_download");
    L10:
        if (this.spaceFileDownloadManager != null) goto L12;
        Context r3 = getContext();
        BaseOpenEntity r4 = getHost().c.getOpenEntity();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity");
        this.spaceFileDownloadManager = new SpaceFileDownloadManager(r3, (BaseSpaceOpenEntity) r4, getHost().c.getFileModel(), null, getHost().b());
    L12:
        SpaceFileDownloadManager r5 = this.spaceFileDownloadManager;
        if (r5 == null) goto L16;
        r5.c();
        return;
    }

    public DriveSpaceFileDownloadPlugin() {
    }

    public static final /* synthetic */ void access$cancelTask(DriveSpaceFileDownloadPlugin r0) {
        r0.cancelTask();
    }

    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        bindPermission();
    }

    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        cancelTask();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }
}
