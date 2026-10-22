package yh3;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n33.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends g<c, a> {
    public l33.b<c, a> a;

    public final String a() {
        l33.b<c, a> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
    L5:
        String r1 = ((u33.a) ((a) r0.c)).a.getSchemaModel().getQueryParam("shape");
        if (r1 != null) goto L8;
        r1 = "0";
    L8:
        String r2 = "/order/component/confirmOrderEdit/?buy_render_shape=".concat(r1);
        int r3 = j43.a.a;
        Lazy r4 = ECAppInfoService.a;
        if (we.a.a == false) goto L15;
        String r5 = j43.a.b();
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        return r2 + "&webcast_appid=" + r5;
    L15:
        return r2;
    }

    public final Map<String, Object> b() {
        l33.b<c, a> r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
    L6:
        return MapsKt.mapOf(TuplesKt.to("uplink_version", Long.valueOf(r0.a.b().get())));
    }

    public d() {
    }
}
