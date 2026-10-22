package com.bytedance.ee.bear.drive.biz.external;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.OpenExternalMenu;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.lark.android.encryption.CipherManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/external/DriveLocalFileOpenExternalPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveLocalFileOpenExternalPlugin extends AbsDrivePlugin {

    public static final class a<T> implements Observer {
        public final /* synthetic */ LocalOpenEntity a;
        public final /* synthetic */ DrivePluginHost b;
        public final /* synthetic */ DriveLocalFileOpenExternalPlugin c;

        public a(LocalOpenEntity r1, DrivePluginHost r2, DriveLocalFileOpenExternalPlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r7) {
            Void r8 = (Void) r7;
            if (CipherManager.d() != 1) goto L6;
            Toast.showText(eu5.b.a, 2131887299);
            CipherManager.h();
            return;
        L6:
            if (TextUtils.isEmpty(this.a.getFileId()) == true) goto L9;
            ((com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6)).k(this.a.getAppId(), this.a.getFileId(), Boolean.TRUE, this.a.getThirdPartyAppID());
            ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(sbb.e.l.b, this.a.getFileId(), "open_with_other_app");
        L9:
            if (hu5.a.d(this.b.c.getOpenEntity().getMoreMenuActions()) == true) goto L24;
            Iterator<BaseMoreMenuAction> r9 = this.b.c.getOpenEntity().getMoreMenuActions().iterator();
        L12:
            if (r9.hasNext() == false) goto L24;
            BaseMoreMenuAction r1 = r9.next();
            if ((r1 instanceof OpenExternalMenu) == false) goto L12;
            if (((OpenExternalMenu) r1).a == null) goto L12;
            BinderMenuAction r10 = ((OpenExternalMenu) r1).a;     // Catch: Exception -> L21
            if (r10 == null) goto L36;
            r10.action(new Bundle());     // Catch: Exception -> L21
            return;
        L36:
            return;
        L21:
            e = move-exception;
            tt5.a.e("DriveComponent", "liveInnerOpenExternal() custom OpenExternalMenu action error", e, false);
            return;
        L24:
            if (TextUtils.isEmpty(this.a.getBizContentProviderAuthority()) == false) goto L26;
            tt5.a.h("DriveComponent", "local file openFile");
            FileUtils.I(DriveLocalFileOpenExternalPlugin.access$getContext(this.c), ay4.d.a().z(this.a.getLocalFilePath()), "");
            return;
        L26:
            tt5.a.h("DriveComponent", "local file openFileWithAuthority");
            FileUtils.K(DriveLocalFileOpenExternalPlugin.access$getContext(this.c), ay4.d.a().z(this.a.getLocalFilePath()), this.a.getBizContentProviderAuthority());
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveLocalFileOpenExternalPlugin() {
    }

    public static final /* synthetic */ Context access$getContext(DriveLocalFileOpenExternalPlugin r0) {
        return r0.getContext();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        BaseOpenEntity r0 = r5.c.getOpenEntity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity");
        k75.a.i(r5).liveInnerOpenExternal().observe(getLifecycleOwner(), new a((LocalOpenEntity) r0, r5, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
