package t55;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.permission.adapter.UserPermissionV2TypeAdapter;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermissionV2;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Object r3) {
        Intrinsics.checkNotNullParameter("CONTENT_COPY", "operation");
        if (r3 != null) goto L21;
        tt5.a.h("DriveOfflinePermissionInjectImpl", "canOperatePass CONTENT_COPY");
        return false;
    L21:
    L17:
        th = move-exception;
        tt5.a.f("DriveOfflinePermissionInjectImpl", th.getCause(), false);
    L19:
        tt5.a.d("DriveOfflinePermissionInjectImpl", "canOperatePass error happens");
        return false;
    L7:
        if ((r3 instanceof u55.b) == false) goto L11;
        return ((u55.b) r3).b.a.canCopy();
    L11:
        if ((r3 instanceof ThirdPartyAttachmentPermission) == false) goto L19;
        if (((ThirdPartyAttachmentPermission) r3).getCopy() != 1) goto L22;
        return true;
    L22:
        return false;
    }

    public static u55.b b(String r3, String r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r4) == true) goto L15;
        GsonBuilder r0 = new GsonBuilder();     // Catch: Throwable -> L8
        r0.registerTypeAdapter(IDocUserPermission.class, new UserPermissionV2TypeAdapter());     // Catch: Throwable -> L8
        DocUserPermissionV2 r5 = (DocUserPermissionV2) r0.create().fromJson(r4, DocUserPermissionV2.class);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L8
        return new u55.b(r3, new DocPermission(r5, 2));
    L8:
        th = move-exception;
        tt5.a.f("DriveOfflinePermissionInjectImpl", th, false);
        return null;
    L15:
        return null;
    }
}
