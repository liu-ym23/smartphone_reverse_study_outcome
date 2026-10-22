package af3;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public final String a;
    public final String b;
    public final long c;
    public final boolean d;
    public final Map<String, Object> e;

    public g(Map<String, ? extends Object> r4) {
        this.e = r4;
        String r0 = "";
        if (r4 == null) goto L8;
        Object r1 = r4.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r1 == null) goto L8;
        String r2 = r1.toString();
        if (r2 == null) goto L8;
    L9:
        this.a = r2;
        if (r4 == null) goto L17;
        Object r3 = r4.get(SimilarProductParam.ENTER_FROM);
        if (r3 == null) goto L17;
        String r5 = r3.toString();
        if (r5 == null) goto L17;
        r0 = r5;
    L17:
        this.b = r0;
        if (r4 == null) goto L23;
        Object r6 = r4.get("ec_device_score");
        if (r6 == null) goto L23;
        String r7 = r6.toString();
        if (r7 == null) goto L23;
    L24:
        CastFloatProtector.parseFloat(r7);
        Object r8 = null;
        if (r4 == null) goto L27;
        Object r9 = r4.get("real_open_time");
    L29:
        if ((r9 instanceof Long) == true) goto L31;
        r9 = null;
    L31:
        Long r10 = (Long) r9;
        if (r10 == null) goto L34;
        long r11 = r10.longValue();
    L35:
        this.c = r11;
        if (r4 == null) goto L38;
        Object r12 = r4.get("is_guide_to_mall_by_schema");
    L40:
        if ((r12 instanceof Boolean) == false) goto L43;
        r8 = r12;
    L43:
        this.d = Intrinsics.areEqual((Boolean) r8, Boolean.TRUE);
        return;
    L38:
        r12 = null;
        goto L40
    L34:
        r11 = System.currentTimeMillis();
        goto L35
    L27:
        r9 = null;
    L23:
        r7 = "0";
    L8:
        r2 = "";
        goto L9
    }
}
