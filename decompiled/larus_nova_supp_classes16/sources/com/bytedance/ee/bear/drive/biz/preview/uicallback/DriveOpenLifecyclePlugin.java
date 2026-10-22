package com.bytedance.ee.bear.drive.biz.preview.uicallback;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BinderOpenLifecycle;
import com.bytedance.ee.bear.drive.biz.expand.DriveIMActivityExpandPlugin;
import com.bytedance.ee.bear.drive.biz.sheet.DriveIMSheetPlugin;
import com.bytedance.ee.bear.drive.biz.slides.DriveIMSlidesPlugin;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/uicallback/DriveOpenLifecyclePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "onDetachPreview", "onDetachFromHost", "interceptCloseLifecycle", "", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOpenLifecyclePlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveOpenLifecyclePlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;

        public b(DrivePluginHost r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Void r2 = (Void) r1;
            k75.a.a(this.a);
        }
    }

    public static final class c extends u75.b.C0306b {
        public final /* synthetic */ DrivePluginHost a;

        public c(DrivePluginHost r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r1, T r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
            if (r1 != InfoCode.LoadStart) goto L6;
            this.a.c().g(this);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final boolean interceptCloseLifecycle() {
        DriveIMActivityExpandPlugin r0 = (DriveIMActivityExpandPlugin) findPlugin(DriveIMActivityExpandPlugin.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        DriveIMSheetPlugin r2 = (DriveIMSheetPlugin) findPlugin(DriveIMSheetPlugin.class);
        if (r2 == null) goto L17;
        DriveShadowFileEntity r3 = r2.getShadowFileEntity();
        if (r3 == null) goto L17;
        if (r3.getShadowFileEnable() != true) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        return true;
    L20:
        DriveIMSlidesPlugin r5 = (DriveIMSlidesPlugin) findPlugin(DriveIMSlidesPlugin.class);
        if (r5 == null) goto L27;
        DriveShadowFileEntity r6 = r5.getShadowFileEntity();
        if (r6 == null) goto L27;
        if (r6.getShadowFileEnable() != true) goto L27;
        boolean r7 = true;
    L28:
        if (r7 == false) goto L30;
        return true;
    L30:
        return false;
    L27:
        r7 = false;
    L17:
        r4 = false;
        goto L18
    L5:
        if (r0.isExpandActivity() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        BaseOpenEntity r1 = getHost().c.getOpenEntity();
        if (r1 == null) goto L13;
        BinderOpenLifecycle r2 = r1.getBinderOpenLifecycle();
        if (r2 == null) goto L14;
        tt5.a.h(TAG, "loadStart()#onAttachPreview() start");     // Catch: Throwable -> L8
        r2.onVisibleChange(true);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.e(TAG, "loadStart()#onAttachData() err=", th, false);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        BaseOpenEntity r1 = getHost().c.getOpenEntity();
        if (r1 == null) goto L14;
        BinderOpenLifecycle r2 = r1.getBinderOpenLifecycle();
        if (r2 != null) goto L12;
        return;
    L12:
        tt5.a.h(TAG, "onDetachPreview()#binderOpenLifecycle start");     // Catch: Throwable -> L9
        r2.onVisibleChange(false);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        tt5.a.e(TAG, "onDetachPreview()#binderOpenLifecycle err=", th, false);
        return;
    }

    public DriveOpenLifecyclePlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        c r0 = new c(r4);
        r4.c().c(r0);
        k75.a.i(r4).liveInnerClosePage().observe(getLifecycleOwner(), new b(r4));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onDetachFromHost(r4);
        if (o75.b.a().H7() != null) goto L5;
    L16:
    L13:
        th = move-exception;
        tt5.a.e("DriveComponent", "DriveOpenLifecyclePlugin#onDetachFromHost() err=", th, false);
        return;
    L8:
        if (interceptCloseLifecycle() == true) goto L18;
        BinderOpenLifecycle r5 = r4.c.getOpenEntity().getBinderOpenLifecycle();     // Catch: Throwable -> L13
        if (r5 == null) goto L19;
        r5.onClose();     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == false) goto L16;
        o75.b.a().H7().a();
        goto L16
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
