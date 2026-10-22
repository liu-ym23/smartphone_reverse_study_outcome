package jc3;

import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.data.StatIdEnum;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p53.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(CommentParams r15, long r16, long r18, boolean r20, long r21, String r23, boolean r24, int r25, int r26, long r27, String r29, String r30, String r31) {
        Intrinsics.checkNotNullParameter(r23, "extra");
        Intrinsics.checkNotNullParameter("", "contextInfo");
        Intrinsics.checkNotNullParameter(r29, "previousPage");
        Intrinsics.checkNotNullParameter(r30, "firstFilter");
        Intrinsics.checkNotNullParameter(r31, "secondFilter");
        boolean r5 = true;
        h r9 = new h();
        r9.b();
        r9.a(Boolean.FALSE);
        Unit r10 = Unit.INSTANCE;
        int r11 = 0;
        List r8 = CollectionsKt.mutableListOf(new h[]{r9});
        LinkedHashMap r12 = new LinkedHashMap();
        long r13 = 0;
        if (r15 == null) goto L9;
        String r14 = r15.getProductId();
        if (r14 == null) goto L9;
        Long r17 = StringsKt.toLongOrNull(r14);
        if (r17 == null) goto L9;
        long r19 = r17.longValue();
    L10:
        r12.put(PdpOpenThirdParam.KEY_PRODUCT_ID, Long.valueOf(r19));
        r12.put("cursor", Long.valueOf(r21));
        r12.put("count", Long.valueOf(r16));
        if (r20 == false) goto L13;
        long r110 = r18;
    L14:
        r12.put("stat_id", Long.valueOf(r110));
        if (r20 == false) goto L17;
        long r111 = StatIdEnum.INVALID.getId();
    L18:
        r12.put("tag_id", Long.valueOf(r111));
        r12.put("sort_type", Integer.valueOf(r25));
        JsonObject r112 = new JsonObject();
        r112.add("tag_filters", GsonProtectorUtils.toJsonTree(new Gson(), r8));
        r12.put("filter", r112.toString());
        r12.put("need_adapt_addr", 1);
        r12.put("need_page", Integer.valueOf(r26));
        r12.put("context_info", "");
        r12.put("extra", r23);
        r12.put("tag_version", Long.valueOf(r27));
        r12.put("previous_page", r29);
        if (r30.length() <= 0) goto L21;
        boolean r0 = true;
    L22:
        if (r0 == false) goto L25;
        r12.put("first_filter", r30);
    L25:
        if (r31.length() > 0) goto L28;
        r5 = false;
    L28:
        if (r5 == false) goto L31;
        r12.put("second_filter", r31);
    L31:
        if (o53.b.a() == false) goto L51;
        r12.put("from_scene", "");
        if (r15 == null) goto L39;
        String r1 = r15.getReferKolId();
        if (r1 == null) goto L39;
        Long r2 = StringsKt.toLongOrNull(r1);
        if (r2 == null) goto L39;
        long r3 = r2.longValue();
    L40:
        r12.put("kol_id", Long.valueOf(r3));
        if (r15 == null) goto L47;
        String r4 = r15.getReferKolId();
        if (r4 == null) goto L47;
        Long r6 = StringsKt.toLongOrNull(r4);
        if (r6 == null) goto L47;
        r13 = r6.longValue();
    L47:
        r12.put("from_kol_id", Long.valueOf(r13));
        r12.put("is_similar_data", Integer.valueOf(r24 ? 1 : 0));
        if (r15 == null) goto L50;
        r11 = r15.getShowOrderStat();
    L50:
        r12.put("show_order_stat", Integer.valueOf(r11));
    L58:
        r12.put("bff_ab_value", 1);
        return r12;
    L39:
        r3 = 0;
        goto L40
    L51:
        if (r15 == null) goto L57;
        String r7 = r15.getShopId();
        if (r7 == null) goto L57;
        Long r22 = StringsKt.toLongOrNull(r7);
        if (r22 == null) goto L57;
        r13 = r22.longValue();
    L57:
        r12.put("shop_id", Long.valueOf(r13));
        goto L58
    L21:
        r0 = false;
        goto L22
    L17:
        r111 = r18;
        goto L18
    L13:
        r110 = StatIdEnum.INVALID.getId();
    L9:
        r19 = 0;
        goto L10
    }
}
