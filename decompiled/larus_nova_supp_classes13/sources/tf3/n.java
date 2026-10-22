package tf3;

import com.bytedance.android.ec.model.response.anchorv3.MFPromotionEvent;
import com.bytedance.android.ec.model.response.anchorv3.ProductLeaderBoardEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionCrossBorderStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductServiceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n {
    public static final String a(PromotionProductStruct r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$promotionMessageBarType");
        PromotionProductPrivilegesStruct r0 = r4.getPrivilegeInfo();
        List r1 = null;
        if (r0 == null) goto L7;
        PromotionProductActivitiesStruct r2 = r0.getActivities();
        if (r2 == null) goto L7;
        MFPromotionEvent r3 = r2.getMfPromotionEvent();
    L8:
        if (r3 == null) goto L10;
        return "daily_reduction";
    L10:
        PromotionProductPrivilegesStruct r5 = r4.getPrivilegeInfo();
        if (r5 == null) goto L15;
        PromotionProductActivitiesStruct r6 = r5.getActivities();
        if (r6 == null) goto L15;
        PromotionMarketFloor r7 = r6.getPlatformTextActivity();
    L16:
        if (r7 == null) goto L18;
        return "nice_stuff";
    L18:
        PromotionProductExtraStruct r8 = r4.getExtraInfo();
        if (r8 == null) goto L21;
        PromotionCrossBorderStruct r9 = r8.getCrossborderInfo();
    L22:
        if (r9 == null) goto L24;
        return "global";
    L24:
        PromotionProductPrivilegesStruct r10 = r4.getPrivilegeInfo();
        if (r10 == null) goto L27;
        List r11 = r10.getBanners();
    L29:
        if (r11 == null) goto L48;
        PromotionProductPrivilegesStruct r12 = r4.getPrivilegeInfo();
        if (r12 == null) goto L101;
        List r13 = r12.getBanners();
        if (r13 == null) goto L101;
        PromotionProductBannerStruct r14 = (PromotionProductBannerStruct) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L101;
        Integer r15 = r14.getBannerType();
        if (r15 != null) goto L40;
    L42:
        if (r15 == null) goto L101;
        if (r15.intValue() != 1) goto L101;
        return "brand";
    L40:
        if (r15.intValue() != 14) goto L42;
        return "best_selected";
    L101:
        return "";
    L48:
        PromotionProductPrivilegesStruct r16 = r4.getPrivilegeInfo();
        if (r16 == null) goto L51;
        List r17 = r16.getTags();
    L52:
        if (r17 == null) goto L65;
        PromotionProductPrivilegesStruct r18 = r4.getPrivilegeInfo();
        if (r18 == null) goto L101;
        List r19 = r18.getTags();
        if (r19 == null) goto L101;
        PromotionProductBannerStruct r20 = (PromotionProductBannerStruct) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L101;
        Integer r21 = r20.getBannerType();
        if (r21 == null) goto L101;
        if (r21.intValue() != 7) goto L101;
        return "selected_product";
    L65:
        PromotionProductAuthorEntriesStruct r22 = r4.getEntryInfo();
        if (r22 == null) goto L68;
        ProductLeaderBoardEntryStruct r23 = r22.getLeaderBoardEntry();
    L69:
        if (r23 == null) goto L71;
        return "ranking_list";
    L71:
        PromotionProductBaseStruct r24 = r4.getBaseInfo();
        if (r24 == null) goto L74;
        List r25 = r24.getSellingPointInfo();
    L75:
        if (r25 == null) goto L77;
        return "selling_point";
    L77:
        PromotionProductPrivilegesStruct r26 = r4.getPrivilegeInfo();
        if (r26 == null) goto L84;
        List r27 = r26.getServices();
        if (r27 == null) goto L84;
        PromotionProductServiceStruct r28 = (PromotionProductServiceStruct) CollectionsKt.firstOrNull(r27);
        if (r28 == null) goto L84;
        Integer r29 = r28.getServiceType();
    L85:
        if (r29 != null) goto L88;
    L90:
        PromotionProductPrivilegesStruct r30 = r4.getPrivilegeInfo();
        if (r30 == null) goto L93;
        r1 = r30.getServices();
    L93:
        if (r1 == null) goto L101;
        return "aftersale_information";
    L88:
        if (r29.intValue() != 11) goto L90;
        return "secure_buy";
    L84:
        r29 = null;
        goto L85
    L74:
        r25 = null;
        goto L75
    L68:
        r23 = null;
        goto L69
    L51:
        r17 = null;
        goto L52
    L27:
        r11 = null;
        goto L29
    L21:
        r9 = null;
    L15:
        r7 = null;
    L7:
        r3 = null;
        goto L8
    }
}
