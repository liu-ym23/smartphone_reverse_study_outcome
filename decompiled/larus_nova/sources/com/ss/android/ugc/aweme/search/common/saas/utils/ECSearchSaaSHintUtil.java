package com.ss.android.ugc.aweme.search.common.saas.utils;

import com.bytedance.android.ec.core.event.a;
import com.ss.android.ugc.aweme.helper.VideoInfoExtraHelper;
import com.ss.android.ugc.aweme.search.common.bean.ECCouponInfo;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/utils/ECSearchSaaSHintUtil;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSaaSHintUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchSaaSHintUtil f452176a = null;

    private ECSearchSaaSHintUtil() {
    }

    static {
        f452176a = new ECSearchSaaSHintUtil();
    }

    public static String a(ECSearchParam r110) {
        String r100 = r110.getVideoInfoExtra();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L127;
    L107:
        return null;
    L127:
        String r103 = r110.getGroupId();     // Catch: Throwable -> L116
        String r111 = r110.getVideoInfoExtra();     // Catch: Throwable -> L116
        if (r111 == null) goto L107;
        JSONObject r104 = new JSONObject(r111);     // Catch: Throwable -> L116
        int r112 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r113 = r104.get("enable_log");     // Catch: Throwable -> L20
        if ((r113 instanceof Boolean) == true) goto L18;
        r113 = null;
    L18:
        Boolean r114 = (Boolean) r113;     // Catch: Throwable -> L20
    L21:
        if (r114 == null) goto L23;
        boolean r115 = r114.booleanValue();     // Catch: Throwable -> L116
    L24:
        if (r115 == true) goto L26;
        return null;
    L26:
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L116
        r116.putOpt(a.KEY_ENTER_GROUP_ID, r103);     // Catch: Throwable -> L116
        int r105 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r106 = r104.get("content_type");     // Catch: Throwable -> L32
        if ((r106 instanceof String) == true) goto L30;
        r106 = null;
    L30:
        String r107 = (String) r106;     // Catch: Throwable -> L32
    L33:
        if (r107 == null) goto L105;
        int r108 = r107.hashCode();     // Catch: Throwable -> L116
        if (r108 == 3322092) goto L91;
        if (r108 != 112202875) goto L105;
        if (r107.equals("video") == false) goto L105;
        int r109 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r117 = r104.get("is_livehead");     // Catch: Throwable -> L49
        if ((r117 instanceof Boolean) == true) goto L47;
        r117 = null;
    L47:
        Boolean r118 = (Boolean) r117;     // Catch: Throwable -> L49
    L50:
        if (r118 == null) goto L52;
        boolean r119 = r118.booleanValue();     // Catch: Throwable -> L116
    L53:
        int r120 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r121 = r104.get("is_ecom_cart");     // Catch: Throwable -> L59
        if ((r121 instanceof Boolean) == true) goto L57;
        r121 = null;
    L57:
        Boolean r122 = (Boolean) r121;     // Catch: Throwable -> L59
    L60:
        if (r122 == null) goto L62;
        r101 = r122.booleanValue();     // Catch: Throwable -> L116
    L62:
        if (r101 == false) goto L64;
        String r123 = "cart_video";
    L65:
        r116.putOpt("content_type", r123);     // Catch: Throwable -> L116
        int r124 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r125 = r104.get("author_id");     // Catch: Throwable -> L112
        if ((r125 instanceof Object) == false) goto L68;
    L69:
        r116.putOpt("author_id", r125);     // Catch: Throwable -> L116
        int r126 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r127 = r104.get("duration");     // Catch: Throwable -> L111
        if ((r127 instanceof Object) == false) goto L72;
    L73:
        r116.putOpt("duration", r127);     // Catch: Throwable -> L116
        int r128 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r129 = r104.get("feed_duration");     // Catch: Throwable -> L110
        if ((r129 instanceof Object) == false) goto L76;
    L77:
        r116.putOpt("feed_duration", r129);     // Catch: Throwable -> L116
        if (r101 == false) goto L84;
        int r130 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r131 = r104.get("product_id");     // Catch: Throwable -> L108
        if ((r131 instanceof Object) == false) goto L82;
    L83:
        r116.putOpt("product_id", r131);     // Catch: Throwable -> L116
    L82:
        r131 = null;
    L84:
        if (r119 == false) goto L105;
        int r132 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r133 = r104.get("room_id");     // Catch: Throwable -> L109
        if ((r133 instanceof Object) == false) goto L88;
    L89:
        r116.putOpt("livehead_room_id", r133);     // Catch: Throwable -> L116
    L88:
        r133 = null;
    L76:
        r129 = null;
    L72:
        r127 = null;
    L68:
        r125 = null;
        goto L69
    L64:
        r123 = "other_video";
    L59:
        r122 = null;
        goto L60
    L52:
        r119 = false;
    L49:
        r118 = null;
        goto L50
    L91:
        if (r107.equals("live") == false) goto L105;
        r116.putOpt("content_type", "live_cell");     // Catch: Throwable -> L116
        int r134 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r135 = r104.get("author_id");     // Catch: Throwable -> L115
        if ((r135 instanceof Object) == false) goto L95;
    L96:
        r116.putOpt("author_id", r135);     // Catch: Throwable -> L116
        int r136 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r137 = r104.get("duration");     // Catch: Throwable -> L114
        if ((r137 instanceof Object) == false) goto L99;
    L100:
        r116.putOpt("duration", r137);     // Catch: Throwable -> L116
        int r138 = VideoInfoExtraHelper.f450874a;     // Catch: Throwable -> L116
        Object r139 = r104.get("product_id");     // Catch: Throwable -> L113
        if ((r139 instanceof Object) == false) goto L103;
    L104:
        r116.putOpt("product_id", r139);     // Catch: Throwable -> L116
    L103:
        r139 = null;
    L99:
        r137 = null;
    L95:
        r135 = null;
    L105:
        return r116.toString();
    L32:
        r107 = null;
        goto L33
    L23:
        r115 = false;
    L20:
        r114 = null;
        goto L21
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L10
    }

    public static ECCouponInfo b(ECSearchParam r100) {
        String r101 = r100.getHintIconTagType();
        if (Intrinsics.areEqual(r101, "text") == false) goto L6;
        String r102 = r100.getHintIconText();
    L9:
        ECCouponInfo r103 = new ECCouponInfo();
        if (r102 != null) goto L39;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L37;
        JSONObject r105 = new JSONObject(r102).optJSONObject("log_data");     // Catch: Exception -> L38
        String r106 = null;
        if (r105 == null) goto L20;
        String r107 = r105.optString("coupon_apply_type");     // Catch: Exception -> L38
    L21:
        r103.f451501a = r107;     // Catch: Exception -> L38
        if (r105 == null) goto L24;
        String r108 = r105.optString("coupon_bsk");     // Catch: Exception -> L38
    L25:
        r103.f451502b = r108;     // Catch: Exception -> L38
        if (r105 == null) goto L28;
        Boolean r109 = Boolean.valueOf(r105.optBoolean("is_coupon_package"));     // Catch: Exception -> L38
    L29:
        r103.f451503c = r109;     // Catch: Exception -> L38
        if (r105 == null) goto L32;
        String r110 = r105.optString("coupon_meta_ids");     // Catch: Exception -> L38
    L33:
        r103.f451504d = r110;     // Catch: Exception -> L38
        if (r105 == null) goto L36;
        r106 = r105.optString("coupon_ids");     // Catch: Exception -> L38
    L36:
        r103.f451505e = r106;     // Catch: Exception -> L38
        goto L37
    L32:
        r110 = null;
        goto L33
    L28:
        r109 = null;
        goto L29
    L24:
        r108 = null;
        goto L25
    L20:
        r107 = null;
    L37:
        return r103;
    L39:
        if (r102.length() == 0) goto L15;
        r104 = false;
        goto L16
    L6:
        if (Intrinsics.areEqual(r101, "icon") == false) goto L8;
        r102 = r100.getSearchHintIcon();
        goto L9
    L8:
        r102 = "";
        goto L9
    }
}
