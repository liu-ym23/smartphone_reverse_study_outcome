package nd7;

import com.bytedance.sdk.xbridge.cn.auth.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends nd7.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f518798b;

    public static final class a {
    }

    static {
    }

    @Override // nd7.a
    public final JSONObject b() {
        g r100 = this.f518796a;
        if (r100 == null) goto L7;
        com.ivy.ivykit.plugin.impl.jsb.auth.a r101 = r100.b();
        if (r101 == null) goto L7;
        int r102 = com.bytedance.sdk.xbridge.cn.utils.e.f270259a;
        Intrinsics.checkNotNullParameter(r101, "localStorage");
        Intrinsics.checkNotNullParameter("com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response", "key");
        String r103 = r101.a();
    L9:
        if (com.bytedance.sdk.xbridge.cn.utils.e.a(r103) == false) goto L11;
        return null;
    L11:
        Intrinsics.checkNotNull(r103);
        JSONObject r104 = com.bytedance.sdk.xbridge.cn.utils.e.b(r103);
        int r105 = com.bytedance.sdk.xbridge.cn.utils.a.f270258a;
        JSONObject r106 = new JSONObject();
        r106.put("data", r104);
        return r106;
    L7:
        r103 = null;
        goto L9
    }

    public c() {
        this.f518798b = "LocalPermissionLoader";
    }

    @Override // nd7.a
    public final String a() {
        return this.f518798b;
    }
}
