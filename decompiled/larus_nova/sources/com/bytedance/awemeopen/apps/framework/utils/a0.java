package com.bytedance.awemeopen.apps.framework.utils;

import android.text.TextUtils;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.BaseDetailPromotion;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.PromotionAppointment;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.PromotionPreSale;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.PromotionToutiao;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.SeckillInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a0 {
    public static final boolean a(DetailPromotion r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (b(r100) == true) goto L5;
        return false;
    L5:
        PromotionToutiao r101 = r100.getToutiao();
        if (r101 == null) goto L15;
        SeckillInfo r102 = r101.getSecKillInfo();
        if (r102 == null) goto L16;
        long r103 = r102.getBeginTime();
        long r104 = r102.getEndTime();
        long r105 = r102.getCurrentTime();
        if (r103 <= r105) goto L12;
        return false;
    L12:
        if (r105 > r104) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    public static final boolean b(DetailPromotion r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        PromotionToutiao r101 = r100.getToutiao();
        PromotionAppointment r102 = null;
        if (r101 == null) goto L5;
        PromotionPreSale r103 = r101.getPreSale();
    L7:
        if (r103 == null) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L27;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        PromotionToutiao r105 = r100.getToutiao();
        if (r105 == null) goto L14;
        r102 = r105.getAppointment();
    L14:
        if (r102 == null) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == true) goto L27;
        PromotionToutiao r107 = r100.getToutiao();
        if (r107 == null) goto L23;
        SeckillInfo r108 = r107.getSecKillInfo();
        if (r108 == null) goto L23;
        long r109 = r108.getCurrentTime();
    L25:
        if (r109 == 0) goto L27;
        return true;
    L23:
        r109 = 0;
        goto L25
    L16:
        r106 = false;
    L27:
        return false;
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final boolean c(DetailPromotion r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        long r100 = r110.getPromotionSource();
        if (r100 != BaseDetailPromotion.SourceType.TAOBAO.getType()) goto L5;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
    L32:
        return true;
    L13:
        if (r100 != BaseDetailPromotion.SourceType.JINGDONG.getType()) goto L15;
    L18:
        boolean r102 = true;
    L19:
        if (r102 == true) goto L32;
        Long r103 = Long.valueOf(r100);
        if (r103 == null) goto L29;
        BaseDetailPromotion.SourceType[] r104 = BaseDetailPromotion.SourceType.values();
        int r105 = r104.length;
        int r106 = 0;
    L24:
        if (r106 >= r105) goto L29;
        if (r104[r106].getType() == r103.longValue()) goto L27;
        r106 = r106 + 1;
        goto L24
    L27:
        boolean r107 = true;
    L31:
        if ((!r107) == true) goto L32;
        return false;
    L29:
        r107 = false;
        goto L31
    L15:
        if (r100 == BaseDetailPromotion.SourceType.KAOLA.getType()) goto L18;
        r102 = false;
        goto L19
    L5:
        if (r100 == BaseDetailPromotion.SourceType.TAOBAO_PHONE.getType()) goto L10;
        if (r100 == BaseDetailPromotion.SourceType.TAOBAO_COMMAND.getType()) goto L10;
        r101 = false;
        goto L11
    }

    public static final List d(DetailPromotion r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<t14.a> r101 = r100.getElasticImages();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        List<t14.a> r104 = r100.getImages();
        if (r104 != null) goto L14;
    L16:
        if (r102 == false) goto L20;
        return r100.getImages();
    L20:
        return CollectionsKt.emptyList();
    L14:
        if ((!r104.isEmpty()) != true) goto L16;
        r102 = true;
        goto L16
    L10:
        return r100.getElasticImages();
    L5:
        if ((!r101.isEmpty()) != true) goto L7;
        r103 = true;
        goto L8
    }

    public static final String e(DetailPromotion r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (TextUtils.isEmpty(r100.getElasticTitle()) == true) goto L10;
        String r101 = r100.getElasticTitle();
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L10:
        if (TextUtils.isEmpty(r100.getTitle()) == true) goto L17;
        String r102 = r100.getTitle();
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L17:
        return "";
    }
}
