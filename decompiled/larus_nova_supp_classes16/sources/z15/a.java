package z15;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileManager;
import com.bytedance.ee.bear.document.expand.ActivityExpandPlugin;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements e {
    public com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b a;
    public DriveShadowFileEntity b;

    /* JADX INFO: renamed from: z15.a$a, reason: collision with other inner class name */
    public static final class C0331a {
    }

    static {
    }

    public a() {
    }

    public final com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c e() {
        DriveShadowFileEntity r0 = this.b;
        if (r0 == null) goto L7;
        String r1 = r0.getShadowFileUUID();
        if (r1 == null) goto L7;
        Lazy<DriveShadowFileManager> r2 = DriveShadowFileManager.b;
        DriveShadowFileManager r3 = DriveShadowFileManager.a.a();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        tt5.a.h("DriveShadowFileManager", "findMoreMenuManager, key=".concat(r1));
        return r3.a.get(r1);
    L7:
        return null;
    }

    public final com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b d(com.bytedance.ee.bear.browser.plugin.f<?> r4) {
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r0 = this.a;
        if (r0 != null) goto L6;
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r5 = new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b(new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b.a(r4.getHost().getActivity(), r4, r4.getHost().getUIContainer()));
        this.a = r5;
        return r5;
    L6:
        return r0;
    }

    @Override // z15.e
    public final void a(PluginHost r3, com.bytedance.ee.bear.browser.plugin.f r4) {
        Intrinsics.checkNotNullParameter(r4, "plugin");
        DriveShadowFileEntity r0 = null;
        if (r3 == null) goto L9;
        Fragment r5 = r3.getHostFragment();
        if (r5 == null) goto L9;
        Bundle r6 = r5.getArguments();
        if (r6 == null) goto L9;
        Serializable r7 = r6.getSerializable(DriveShadowFileEntity.SHADOW_FILE_DATA);
    L11:
        if ((r7 instanceof DriveShadowFileEntity) == false) goto L13;
        r0 = (DriveShadowFileEntity) r7;
    L13:
        this.b = r0;
        if (r0 == null) goto L16;
        boolean r8 = r0.getShadowFileEnable();
    L17:
        tt5.a.h("DriveMenuItemClickInterceptor", "onAttachToUIContainer enable= " + r8);
        if (r8 == true) goto L20;
        return;
    L20:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c r9 = e();
        if (r9 == null) goto L24;
        r9.d(d(r4));
        return;
    L24:
        return;
    L16:
        r8 = false;
    L9:
        r7 = null;
        goto L11
    }

    @Override // z15.e
    public final void b(PluginHost r5, com.bytedance.ee.bear.browser.plugin.f r6) {
        Intrinsics.checkNotNullParameter(r6, "plugin");
        DriveShadowFileEntity r0 = this.b;
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.getShadowFileEnable();
    L6:
        tt5.a.h("DriveMenuItemClickInterceptor", "onDetachFromUIContainer enable= " + r2);
        if (r2 == true) goto L9;
        return;
    L9:
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c r3 = e();
        if (r3 == null) goto L30;
        if (r5 == null) goto L17;
        ActivityExpandPlugin r7 = (ActivityExpandPlugin) r5.findPlugin(ActivityExpandPlugin.class);
        if (r7 == null) goto L17;
        if (r7.isExpandActivity() != true) goto L17;
        r1 = true;
    L17:
        if (r1 == false) goto L20;
        tt5.a.h("DriveMenuItemClickInterceptor", "onDetachFromUIContainer current is expand activity. don't release");
        return;
    L20:
        r3.a(d(r6));
        r3.b();
        Lazy<DriveShadowFileManager> r8 = DriveShadowFileManager.b;
        DriveShadowFileManager r9 = DriveShadowFileManager.a.a();
        r9.getClass();
        tt5.a.h("DriveShadowFileManager", "removeMoreMenuManager, manager=" + Integer.valueOf(r3.hashCode()));
        Iterator<Map.Entry<String, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c>> r10 = r9.a.entrySet().iterator();
    L22:
        if (r10.hasNext() == false) goto L31;
        if (Intrinsics.areEqual(r10.next().getValue(), r3) == false) goto L22;
        r10.remove();
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // z15.e
    public final boolean c(String r5, BasePlugin r6, View r7) {
        Intrinsics.checkNotNullParameter(r5, "menuId");
        Intrinsics.checkNotNullParameter(r6, "plugin");
        Intrinsics.checkNotNullParameter(r7, "view");
        DriveShadowFileEntity r0 = this.b;
        if (r0 != null) goto L7;
        tt5.a.h("DriveMenuItemClickInterceptor", "onIntercept false, data is not ready");
        return false;
    L7:
        if (r0.getShadowFileEnable() == true) goto L9;
    L16:
        tt5.a.h("DriveMenuItemClickInterceptor", "onIntercept false, enable=" + r0.getShadowFileEnable() + ", moreId != MORE_ID");
        return false;
    L9:
        if (Intrinsics.areEqual("MORE_OPERATE", r5) == false) goto L16;
        com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c r8 = e();
        if (r8 == null) goto L15;
        tt5.a.h("DriveMenuItemClickInterceptor", "onIntercept true, uuid= " + r0.getShadowFileUUID());
        r8.c(d(r6)).onClick(r7);
        return true;
    L15:
        return false;
    }
}
