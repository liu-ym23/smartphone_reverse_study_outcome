package yh3;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends u33.a implements t43.c, t43.b, t43.d, t43.a {
    public final e f;
    public final Map<String, Object> g;
    public final String h;
    public final String i;
    public final boolean j;
    public final String k;

    public a() {
        throw null;
    }

    public final String a() {
        return this.k;
    }

    public final String b() {
        return this.i;
    }

    public final Map<String, Object> getApiParams() {
        return this.g;
    }

    public final String getProductID() {
        return this.h;
    }

    public a(r33.a r15, PageInfo r16, e r17, u33.c r18, v33.b r19, u33.b r20, String r21, String r22, boolean r23, String r24, int r25) {
        if ((r25 & 64) == 0) goto L5;
        LinkedHashMap r1 = new LinkedHashMap();
    L6:
        LinkedHashMap r11 = r1;
        if ((r25 & 512) == 0) goto L9;
        boolean r12 = false;
    L10:
        Intrinsics.checkNotNullParameter(r15, "btmInfo");
        Intrinsics.checkNotNullParameter(r16, "pageInfo");
        Intrinsics.checkNotNullParameter(r17, "uiProps");
        Intrinsics.checkNotNullParameter(r18, "yataProps");
        Intrinsics.checkNotNullParameter(r19, "sliceProps");
        Intrinsics.checkNotNullParameter(r20, "trackProps");
        Intrinsics.checkNotNullParameter(r11, "apiParams");
        Intrinsics.checkNotNullParameter(r21, "productID");
        Intrinsics.checkNotNullParameter(r22, "skuSessionID");
        Intrinsics.checkNotNullParameter(r24, "preSessionID");
        super(r16, r15, r19, r18, r20);
        this.f = r17;
        this.g = r11;
        this.h = r21;
        this.i = r22;
        this.j = r12;
        this.k = r24;
        r11.put("b_type_new", Integer.valueOf(j43.a.a()));
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == false) goto L13;
        String r2 = String.valueOf(j43.a.a);
    L14:
        r11.put("sub_b_type", r2);
        String r3 = r16.getSchemaModel().getQueryParam("shape");
        String r4 = "";
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        r11.put("buy_render_shape", r3);
        if (we.a.a == false) goto L25;
        String r5 = j43.a.b();
        if (r5 == null) goto L23;
        r4 = r5;
    L23:
        r11.put("webcast_appid", r4);
        return;
    L25:
        return;
    L13:
        r2 = "3";
        goto L14
    L9:
        r12 = r23;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
