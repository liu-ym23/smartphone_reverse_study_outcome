package li5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.j a;
        public final /* synthetic */ int b;

        public a(com.bytedance.ee.bear.middleground_permission_export.model.j r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            SimpleRequestResult r3 = (SimpleRequestResult) r2;
            tt5.a.h("DocPublicPermissionManager", "updatePublicPermission succeed");
            this.a.c(this.b);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.j a;

        public b(com.bytedance.ee.bear.middleground_permission_export.model.j r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("DocPublicPermissionManager", "updatePublicPermission error:", r5, false);
            this.a.b(r5);
        }
    }

    static {
    }

    public static void b(String r3, int r4, com.bytedance.ee.bear.middleground_permission_export.model.j r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r1 = new NetService.f("/space/api/suite/permission/public/update.v5/");
        ((NetService.e) r1).j = r3;
        ((NetService.e) r1).c = 1;
        r5.a();
        r0.Vc(new ax4.f()).a(r1).subscribe(new a(r5, r4), new b(r5));
    }

    @JvmStatic
    public static final String a(String r2, int r3, int r4, int r5) {
        tt5.a.h("DocPublicPermissionManager", "buildUpdatePublicPermParam()...type = " + r3 + ", permType = " + r5 + ", externalAccessEntity = " + r4);
        JSONObject r0 = new JSONObject();
        r0.put(ResourceData.KEY_TYPE, r3);
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.put(ResourceData.KEY_TOKEN, r2);
        r0.put("external_access_entity", r4);
        if (r5 == (-99)) goto L9;
        JSONObject r6 = new JSONObject();
        r6.put("external_access_switch", r5);
        Unit r7 = Unit.INSTANCE;
        r0.put("perm_type", r6);
    L9:
        return r0.toString();
    }
}
