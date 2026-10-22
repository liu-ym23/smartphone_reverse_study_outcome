package u16;

import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "x.predefineMonitor")
public final class b extends u16.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f548298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, d> f548299e = null;

    public static final class a {
    }

    static {
        f548298d = "";
        f548299e = new HashMap();
    }

    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        u16.a.b r113 = (u16.a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        s26.d r114 = s26.d.f540305c;
        r r115 = (r) s26.d.f540305c.c(r.class);
        if (r115 == null) goto L17;
        c1 r100 = new c1("bdx_predefine_monitor", null, null, null, null, 254);
        r100.f247792b = f548298d;
        JSONObject r101 = new JSONObject();
        r101.put("url", f548298d);
        r101.put("group", r113.getGroup());
        r101.put("time_cull", r113.getTimeCull());
        r101.put("fe_duration", r113.getFeDuration());
        r101.put("schema_pkgs", r113.getSchemaPkgs());
        r101.put("schema_pkg_num", r113.getSchemaPkgNum());
        r101.put("predefine_pkgs", r113.getPredefinePkgs());
        r101.put("predefine_pkg_num", r113.getPredefinePkgNum());
        r101.put("predefine_state", r113.getPredefineState());
        r101.put("extra", r113.getExtra());
        HashMap<String, d> r116 = f548299e;
        d r102 = r116.get(f548298d);
        if (r102 == null) goto L7;
        ArrayList<c> r103 = r102.f548306c;
    L8:
        r101.put("client_file_preload_duration", String.valueOf(r103));
        d r104 = r116.get(f548298d);
        if (r104 == null) goto L11;
        Boolean r105 = Boolean.valueOf(r104.f548304a);
    L12:
        r101.put("client_meta_fetch", r105);
        d r117 = r116.get(f548298d);
        if (r117 == null) goto L15;
        Boolean r118 = Boolean.valueOf(r117.f548305b);
    L16:
        r100.f247795e = r101.put("client_predefine_enable", r118);
        r115.S(r100);
        goto L17
    L15:
        r118 = null;
        goto L16
    L11:
        r105 = null;
        goto L12
    L7:
        r103 = null;
    L17:
        u16.a.c r119 = (u16.a.c) e.c(Reflection.getOrCreateKotlinClass(u16.a.c.class));
        r119.setCode(1);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, r119, null, 2, null);
    }
}
