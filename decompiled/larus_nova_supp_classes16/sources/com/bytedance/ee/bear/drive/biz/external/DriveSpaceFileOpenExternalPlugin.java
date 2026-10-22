package com.bytedance.ee.bear.drive.biz.external;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.ss.lark.android.encryption.CipherManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/external/DriveSpaceFileOpenExternalPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileOpenExternalPlugin extends AbsDrivePlugin {

    public static final class a<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveSpaceFileOpenExternalPlugin b;

        public a(DrivePluginHost r1, DriveSpaceFileOpenExternalPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r9) {
            Void r10 = (Void) r9;
            com.bytedance.ee.bear.middleground_permission_export.model.c r2 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
            String r4 = this.a.c.getOpenEntity().getFileId();
            Boolean r5 = Boolean.FALSE;
            boolean r7 = true;
            if (CipherManager.d() != 1) goto L6;
            r7 = false;
        L6:
            r2.m(null, r4, r5, null, Boolean.valueOf(r7));
            ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(sbb.e.l.b, this.a.c.getOpenEntity().getFileId(), "open_with_other_app");
            w75.a r11 = this.a.c.getFileModel();
            if (r11 == null) goto L11;
            w75.b r12 = r11.c();
            if (r12 == null) goto L11;
            Long r13 = Long.valueOf(r12.c);
        L12:
            f r1 = f.e(this.a.c.getOpenEntity().getBizType(), DriveSpaceFileOpenExternalPlugin.access$getContext(this.b), this.a.b());
            com.bytedance.ee.bear.drive.biz.external.a.C0122a r3 = new com.bytedance.ee.bear.drive.biz.external.a.C0122a();
            DrivePluginHost r6 = this.a;
            if (r13 == null) goto L15;
            long r8 = r13.longValue();
        L16:
            r3.b = r8;
            r3.a = r6.c.getOpenEntity().getFileId();
            r3.c = r6.c.getOpenEntity().getApiExtra();
            r3.d = r6.c.getOpenEntity().getMountPoint();
            r3.e = r6.c.getOpenEntity().getDownloadFrom();
            r3.f = r6.c.getOpenEntity().getBizScene();
            r3.g = r6.c.getOpenEntity().getWatermarkScene();
            r1.g(new com.bytedance.ee.bear.drive.biz.external.a(r3), null, "LARK-PSDA-ccm_drive_preview_open_external");
            k75.a.c(this.a).n(this.a.c.getFileModel(), "open_in_other_apps", "none");
            return;
        L15:
            r8 = 0;
        L11:
            r13 = null;
            goto L12
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveSpaceFileOpenExternalPlugin() {
    }

    public static final /* synthetic */ Context access$getContext(DriveSpaceFileOpenExternalPlugin r0) {
        return r0.getContext();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        k75.a.i(r4).liveInnerOpenExternal().observe(getLifecycleOwner(), new a(r4, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
