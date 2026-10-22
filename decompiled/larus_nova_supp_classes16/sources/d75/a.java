package d75;

import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(DrivePluginHost r3, DriveMGPermissionVM r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "permissionViewModel");
        Intrinsics.checkNotNullParameter(r5, "reason");
        int r0 = com.bytedance.ee.bear.drive.biz.cache.a.a;
        com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(r3.c, null, r3.b());
        tt5.a.h("DriveComponent", "version update refresh latest, reason=".concat(r5));
        r3.c().load();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.d() == false) goto L6;
        DriveMGPermissionVM.fetchPermission$default(r4, r3.c.getFileId(), null, 2, null);
        return;
    }
}
