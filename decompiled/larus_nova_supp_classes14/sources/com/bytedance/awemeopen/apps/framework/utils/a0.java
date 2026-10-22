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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a0 {
    public static final boolean a(DetailPromotion r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (b(r8) == true) goto L5;
        return false;
    L5:
        PromotionToutiao r9 = r8.getToutiao();
        if (r9 == null) goto L15;
        SeckillInfo r10 = r9.getSecKillInfo();
        if (r10 == null) goto L16;
        long r2 = r10.getBeginTime();
        long r4 = r10.getEndTime();
        long r6 = r10.getCurrentTime();
        if (r2 <= r6) goto L12;
        return false;
    L12:
        if (r6 > r4) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    public static final boolean b(DetailPromotion r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        PromotionToutiao r1 = r7.getToutiao();
        PromotionAppointment r2 = null;
        if (r1 == null) goto L5;
        PromotionPreSale r3 = r1.getPreSale();
    L7:
        if (r3 == null) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L27;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        PromotionToutiao r0 = r7.getToutiao();
        if (r0 == null) goto L14;
        r2 = r0.getAppointment();
    L14:
        if (r2 == null) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == true) goto L27;
        PromotionToutiao r8 = r7.getToutiao();
        if (r8 == null) goto L23;
        SeckillInfo r9 = r8.getSecKillInfo();
        if (r9 == null) goto L23;
        long r6 = r9.getCurrentTime();
    L25:
        if (r6 == 0) goto L27;
        return true;
    L23:
        r6 = 0;
        goto L25
    L16:
        r5 = false;
    L27:
        return false;
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean c(DetailPromotion r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long r0 = r10.getPromotionSource();
        if (r0 != BaseDetailPromotion.SourceType.TAOBAO.getType()) goto L5;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
    L32:
        return true;
    L13:
        if (r0 != BaseDetailPromotion.SourceType.JINGDONG.getType()) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == true) goto L32;
        Long r1 = Long.valueOf(r0);
        if (r1 == null) goto L29;
        BaseDetailPromotion.SourceType[] r4 = BaseDetailPromotion.SourceType.values();
        int r5 = r4.length;
        int r6 = 0;
    L24:
        if (r6 >= r5) goto L29;
        if (r4[r6].getType() == r1.longValue()) goto L27;
        r6 = r6 + 1;
        goto L24
    L27:
        boolean r7 = true;
    L31:
        if ((!r7) == true) goto L32;
        return false;
    L29:
        r7 = false;
        goto L31
    L15:
        if (r0 == BaseDetailPromotion.SourceType.KAOLA.getType()) goto L18;
        r3 = false;
        goto L19
    L5:
        if (r0 == BaseDetailPromotion.SourceType.TAOBAO_PHONE.getType()) goto L10;
        if (r0 == BaseDetailPromotion.SourceType.TAOBAO_COMMAND.getType()) goto L10;
        r2 = false;
        goto L11
    }

    public static final List d(DetailPromotion r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        List r0 = r3.getElasticImages();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        List r4 = r3.getImages();
        if (r4 != null) goto L14;
    L16:
        if (r1 == false) goto L20;
        return r3.getImages();
    L20:
        return CollectionsKt.emptyList();
    L14:
        if ((!r4.isEmpty()) != true) goto L16;
        r1 = true;
        goto L16
    L10:
        return r3.getElasticImages();
    L5:
        if ((!r0.isEmpty()) != true) goto L7;
        r2 = true;
        goto L8
    }

    public static final String e(DetailPromotion r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (TextUtils.isEmpty(r2.getElasticTitle()) == true) goto L10;
        String r3 = r2.getElasticTitle();
        if (r3 != null) goto L8;
        return "";
    L8:
        return r3;
    L10:
        if (TextUtils.isEmpty(r2.getTitle()) == true) goto L17;
        String r4 = r2.getTitle();
        if (r4 != null) goto L15;
        return "";
    L15:
        return r4;
    L17:
        return "";
    }
}
