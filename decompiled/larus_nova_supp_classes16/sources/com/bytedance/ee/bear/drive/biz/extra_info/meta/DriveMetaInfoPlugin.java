package com.bytedance.ee.bear.drive.biz.extra_info.meta;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/extra_info/meta/DriveMetaInfoPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMetaInfoPlugin extends AbsDrivePlugin {

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveMetaInfoVM a;
        public final /* synthetic */ DrivePluginHost b;

        public a(DriveMetaInfoVM r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r5) {
            ConnectionService.NetworkState r6 = (ConnectionService.NetworkState) r5;
            boolean r0 = false;
            if (r6 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == true) goto L10;
        L12:
            if (r6 != null) goto L14;
        L16:
            if (r0 == true) goto L18;
            return;
        L18:
            if (this.a.getLiveDocVersion().getValue() != null) goto L22;
            this.a.fetchDocVersion(this.b.c.getOpenEntity().getFileId());
            return;
        L22:
            return;
        L14:
            if (r6.a() != true) goto L16;
            r0 = true;
            goto L16
        L10:
            if (this.a.getLiveMetaInfo().getValue() != null) goto L12;
            this.a.fetchMetaInfo(this.b.c.getOpenEntity().getFileId());
            goto L12
        L5:
            if (r6.a() != true) goto L7;
            r2 = true;
            goto L8
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveMetaInfoPlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        k75.a.h(this, new a((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class), r3));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
