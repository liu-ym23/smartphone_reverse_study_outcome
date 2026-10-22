package gh3;

import android.content.Context;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r2, String r3) {
        e r0 = new e("similar_product_notice_click");
        r0.a = r2;
        r0.b = r3;
        r0.post(null, null);
    }

    public static void a(Context r2, String r3, String r4, SimilarProductVM r5, rd3.a r6) {
        Intrinsics.checkNotNullParameter(r3, "event");
        b r0 = new b(r3);
        String r7 = null;
        if (r5 == null) goto L5;
        String r1 = r5.getProductFrameId();
    L6:
        r0.a = r1;
        r0.f = "product_card";
        if (r5 == null) goto L9;
        Integer r8 = Integer.valueOf(r5.getFrameRank());
    L10:
        r0.b = String.valueOf(r8);
        if (r6 == null) goto L19;
        Promotion r9 = r6.f();
        if (r9 == null) goto L19;
        PromotionProductStruct r10 = r9.getPromotionInfo();
        if (r10 == null) goto L19;
        PromotionProductBaseStruct r11 = r10.getBaseInfo();
        if (r11 == null) goto L19;
        String r12 = r11.getProductId();
    L20:
        r0.d = r12;
        r0.c = r4;
        if (r6 == null) goto L25;
        rd3.g r13 = r6.d();
        if (r13 == null) goto L25;
        String r14 = r13.a();
    L26:
        r0.g = r14;
        if (r5 == null) goto L29;
        String r15 = r5.getRequestId();
    L30:
        r0.h = r15;
        r0.e = "similar_product_homepage";
        if (r6 == null) goto L39;
        Promotion r16 = r6.f();
        if (r16 == null) goto L39;
        PromotionProductStruct r17 = r16.getPromotionInfo();
        if (r17 == null) goto L39;
        PromotionProductExtraStruct r18 = r17.getExtraInfo();
        if (r18 == null) goto L39;
        r7 = r18.getSimilarProductType();
    L39:
        r0.i = r7;
        h.a(r0, r2);
        return;
    L29:
        r15 = null;
    L25:
        r14 = null;
    L19:
        r12 = null;
        goto L20
    L9:
        r8 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
