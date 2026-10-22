package com.bytedance.ee.bear.drive.report;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import t85.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/report/DriveSpaceFileReportPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "hasReport", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "reportFile", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileReportPlugin extends AbsDrivePlugin {
    private boolean hasReport;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileReportPlugin a;

        public a(DriveSpaceFileReportPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            u55.b r2 = (u55.b) r1;
            this.a.reportFile();
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ DriveSpaceFileReportPlugin a;

        public b(DriveSpaceFileReportPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r1, T r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
            if (r1 != InfoCode.FileInfoSuccess) goto L6;
            this.a.reportFile();
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final void reportFile() {
        f85.a r0 = (f85.a) getHost().c.getFileModel();
        String r1 = getHost().c.getOpenEntity().getPreviewFrom();
        u55.b r2 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r0 == null) goto L29;
        if (r2 != null) goto L6;
        return;
    L6:
        if (this.hasReport == true) goto L31;
        this.hasReport = true;
        c r4 = k75.a.c(getHost());
        String r8 = ((f85.a.C0229a) r0.a).q;
        r4.getClass();
        if (((f85.a.C0229a) r0.a) == null) goto L19;
        AccountService$Account r3 = r4.f.G2();
        if (r3 != null) goto L13;
        String r5 = "";
    L14:
        w75.b r6 = r0.a;
        String r7 = ((f85.a.C0229a) r6).a;
        String r9 = ((f85.a.C0229a) r6).k;
        if (TextUtils.equals(r8, r5) == true) goto L17;
        String r10 = "true";
    L18:
        r4.C("client_file_open", r7, r9, r8, r10);
        goto L19
    L17:
        r10 = "false";
        goto L18
    L13:
        r5 = r3.tenantId;
    L19:
        c r11 = k75.a.c(getHost());
        r11.d.h("driveCommonParams");
        h r12 = r11.h;
        if (r12 == null) goto L25;
        if (r12.a == false) goto L25;
        r1 = "vc";
    L27:
        r11.d.j("driveCommonParams", "file_id", du5.b.g(((f85.a.C0229a) r0.a).a));
        r11.d.j("driveCommonParams", "file_type", e.l.getType());
        r11.d.j("driveCommonParams", "page_token", du5.b.g(((f85.a.C0229a) r0.a).a));
        r11.d.j("driveCommonParams", "sub_file_type", ((f85.a.C0229a) r0.a).k);
        r11.d.j("driveCommonParams", "module", "drive");
        r11.d.j("driveCommonParams", "sub_module", "none");
        r11.d.j("driveCommonParams", "user_permission", r2.b.b.getReportJson());
        r11.d.j("driveCommonParams", "file_permission", r2.b.b.getReportJson());
        r11.d.j("driveCommonParams", "app_form", r1);
        k75.a.c(getHost()).l(c.e(r0));
        return;
    L25:
        if (TextUtils.isEmpty(r1) == false) goto L27;
        r1 = "none";
        goto L27
    L31:
        return;
    }

    public DriveSpaceFileReportPlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new a(this));
        r4.c().c(new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
