package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(View r2, final String r3) {
        if (r3 == null) goto L6;
        final boolean r1 = true;
        ViewCompat.setAccessibilityDelegate(r2, new AccessibilityHelper$addContentDescription$1(r3, r1));
        return;
    }

    @JvmStatic
    public static final String b(ECUIPromotion r6, Context r7) {
        String r0 = "";
        if (r7 != null) goto L6;
        return "";
    L6:
        if (r6.canShowHotAtmosphere() == false) goto L57;
        ECHotAtmosphere r1 = r6.getHotAtmosphere();
        if (r1 == null) goto L10;
        Integer r2 = Integer.valueOf(r1.type);
    L12:
        if (r2 != null) goto L15;
    L23:
        if (r2 != null) goto L26;
    L34:
        if (r2 != null) goto L37;
    L45:
        if (r2 != null) goto L48;
        return "";
    L48:
        if (r2.intValue() != 4) goto L61;
        Object[] r3 = new Object[1];
        ECHotAtmosphere r8 = r6.getHotAtmosphere();
        if (r8 == null) goto L55;
        String r9 = r8.num;
        if (r9 == null) goto L55;
        r0 = r9;
    L55:
        r3[0] = r0;
        return th.a.h(r7, 2131896495, r3);
    L61:
        return "";
    L37:
        if (r2.intValue() != 3) goto L45;
        Object[] r4 = new Object[1];
        ECHotAtmosphere r10 = r6.getHotAtmosphere();
        if (r10 == null) goto L44;
        String r11 = r10.num;
        if (r11 == null) goto L44;
        r0 = r11;
    L44:
        r4[0] = r0;
        return th.a.h(r7, 2131896494, r4);
    L26:
        if (r2.intValue() != 2) goto L34;
        Object[] r5 = new Object[1];
        ECHotAtmosphere r12 = r6.getHotAtmosphere();
        if (r12 == null) goto L33;
        String r13 = r12.num;
        if (r13 == null) goto L33;
        r0 = r13;
    L33:
        r5[0] = r0;
        return th.a.h(r7, 2131896496, r5);
    L15:
        if (r2.intValue() != 1) goto L23;
        Object[] r14 = new Object[1];
        ECHotAtmosphere r15 = r6.getHotAtmosphere();
        if (r15 == null) goto L22;
        String r16 = r15.num;
        if (r16 == null) goto L22;
        r0 = r16;
    L22:
        r14[0] = r0;
        return th.a.h(r7, 2131896497, r14);
    L10:
        r2 = null;
        goto L12
    L57:
        return "";
    }

    @JvmStatic
    public static final String c(ECUIPromotion r4, Context r5, boolean r6) {
        if (r5 != null) goto L5;
    L19:
        return "";
    L5:
        if (r4.isFlash() == false) goto L8;
        return th.a.g(r5, 2131896547);
    L8:
        if (r4.isPreSale() == false) goto L11;
        return th.a.g(r5, 2131913563);
    L11:
        if (r4.isSecKill().booleanValue() == false) goto L17;
        ECUICampaign r7 = r4.getCampaign();
        if (r7 == null) goto L17;
        boolean r0 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.a;
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.a(r7.startTime, r7.endTime) != true) goto L17;
        return th.a.g(r5, 2131913721);
    L17:
        if (r6 == false) goto L19;
        return th.a.g(r5, 2131896897);
    }
}
