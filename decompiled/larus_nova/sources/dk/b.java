package dk;

import com.bytedance.android.ec.hybrid.popup.c;
import com.bytedance.android.ec.hybrid.popup.f;
import com.bytedance.android.ec.hybrid.popup.o;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment$pageStateHelper$1;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.android.ec.hybrid.bridge.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ck.b f468985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.api.mall.b f468986e;

    public static final class a {
    }

    static {
    }

    public b(ck.a r100, ECMallFragment$pageStateHelper$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        super("ec.popup_submit_task");
        this.f468985d = r100;
        this.f468986e = r101;
    }

    @Override // com.bytedance.android.ec.hybrid.bridge.b
    public final Pair<Boolean, String> a(IBDXBridgeContext r100, Map<String, ? extends Object> r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "result");
        JSONObject r103 = new JSONObject(r101).optJSONObject("task_config");
        if (r103 == null) goto L5;
        JSONObject r104 = r103.optJSONObject("popup_config");
        if (r104 == null) goto L9;
        o r105 = c.c(r103);
        f r106 = c.a(r104);
        if (r106 == null) goto L13;
        boolean r107 = true;
        if (r105.f47617e == false) goto L26;
        com.bytedance.android.shopping.api.mall.b r108 = this.f468986e;
        if (r108 != null) goto L19;
    L21:
        boolean r109 = false;
    L22:
        if (r109 == true) goto L26;
        return TuplesKt.to(Boolean.FALSE, "mall_is_not_visible_now");
    L19:
        if (r108.a() != true) goto L21;
        r109 = true;
    L26:
        if (r105.f47615c == false) goto L28;
    L29:
        com.bytedance.android.shopping.api.mall.b r110 = this.f468986e;
        if (r110 != null) goto L32;
    L34:
        r107 = false;
    L35:
        if (r107 == false) goto L37;
    L38:
        Pair r111 = c.b(this.f468985d, r105, r106, null);
        boolean r112 = ((Boolean) r111.component1()).booleanValue();
        r102.put("container_id", (String) r111.component2());
        return TuplesKt.to(Boolean.valueOf(r112), null);
    L37:
        return TuplesKt.to(Boolean.FALSE, "page is not visible");
    L32:
        if (r110.a() != true) goto L34;
    L28:
        if (r106.getType() != 2) goto L38;
    L13:
        return TuplesKt.to(Boolean.FALSE, "unsupported type");
    L9:
        return TuplesKt.to(Boolean.FALSE, "popup_config is null");
    L5:
        return TuplesKt.to(Boolean.FALSE, "task_config is null");
    }
}
