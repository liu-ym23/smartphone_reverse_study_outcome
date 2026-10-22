package com.bytedance.ee.bear.drive.report;

import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/report/DriveImFileReportPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "onAttachToHost", "", "host", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImFileReportPlugin extends BasePlugin<DrivePluginHost> {

    public static final class a extends u75.b.C0306b {
        public final /* synthetic */ DrivePluginHost a;

        public a(DrivePluginHost r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void b(z r7) {
            Intrinsics.checkNotNullParameter(r7, "previewFileModel");
            c r0 = k75.a.c(this.a);
            f85.b r8 = (f85.b) this.a.c.getFileModel();
            r0.getClass();
            if (r8 != null) goto L5;
            return;
        L5:
            if (((f85.b.a) r8.a) == null) goto L13;
            AccountService$Account r1 = r0.f.G2();
            if (r1 != null) goto L9;
            String r2 = "";
        L10:
            f85.b.a r9 = (f85.b.a) r8.a;
            String r3 = r9.a;
            String r4 = r9.k;
            r0.C("drive_sdk_file_open", r3, r4, r2, "false");
            return;
        L9:
            r2 = r1.tenantId;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 == InfoCode.FileInfoSuccess) goto L5;
            return;
        L5:
            if ((r3 instanceof w75.a) == false) goto L9;
            k75.a.c(this.a).l(c.e((w75.a) r3));
            return;
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveImFileReportPlugin() {
    }

    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        r3.c().c(new a(r3));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
