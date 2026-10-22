package com.bytedance.android.shopping.mall.background;

import android.text.TextUtils;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.api.mall.idl.ECMallDeviceScreenTypeEnum;
import com.bytedance.android.shopping.api.mall.model.BackgroundInfo;
import com.bytedance.android.shopping.api.mall.model.BackgroundWrapper;
import com.bytedance.android.shopping.api.mall.model.SkinConfig;
import com.bytedance.android.shopping.api.mall.model.SkinConfigPage;
import com.bytedance.android.shopping.api.mall.model.SkinConfigStyle;
import com.bytedance.android.shopping.api.mall.model.SkinExtraData;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static BackgroundWrapper a(String r27, com.bytedance.android.shopping.api.mall.idl.c r28) {
        SkinConfig r2 = (SkinConfig) new Gson().fromJson(r27, SkinConfig.class);     // Catch: Exception -> L5
    L6:
        String r3 = null;
        if (r2 == null) goto L9;
        String r0 = r2.getExtra();
    L10:
        boolean r4 = false;
        if (TextUtils.isEmpty(r0) == false) goto L125;
    L29:
        boolean r1 = false;
    L30:
        if (r2 == null) goto L36;
        SkinConfigStyle r5 = r2.getLight();
        if (r5 == null) goto L36;
        SkinConfigPage r6 = r5.getPageStyle();
        if (r6 == null) goto L36;
        String r7 = r6.getBgUrlFold();
    L37:
        if (r2 == null) goto L43;
        SkinConfigStyle r8 = r2.getDark();
        if (r8 == null) goto L43;
        SkinConfigPage r9 = r8.getPageStyle();
        if (r9 == null) goto L43;
        String r10 = r9.getBgUrlFold();
    L45:
        if (r2 == null) goto L51;
        SkinConfigStyle r11 = r2.getLight();
        if (r11 == null) goto L51;
        SkinConfigPage r12 = r11.getPageStyle();
        if (r12 == null) goto L51;
        String r13 = r12.getBgColor();
    L52:
        if (r28 == null) goto L54;
        Integer r14 = r28.k;
    L55:
        ECMallDeviceScreenTypeEnum r17 = ECMallDeviceScreenTypeEnum.WIDE_SCREEN;
        int r15 = r17.getValue();
        if (r14 != null) goto L59;
    L68:
        if (r2 == null) goto L75;
        SkinConfigStyle r16 = r2.getLight();
        if (r16 == null) goto L75;
        SkinConfigPage r18 = r16.getPageStyle();
        if (r18 == null) goto L75;
        r7 = r18.getBgUrl();
    L74:
        String r19 = r7;
    L77:
        if (r2 == null) goto L83;
        SkinConfigStyle r20 = r2.getLight();
        if (r20 == null) goto L83;
        SkinConfigPage r21 = r20.getPageStyle();
        if (r21 == null) goto L83;
        String r110 = r21.getBgGradientConfig();
    L84:
        BackgroundInfo r111 = new BackgroundInfo(r13, r19, null, null, r110, 12, null);
        if (r2 == null) goto L91;
        SkinConfigStyle r22 = r2.getDark();
        if (r22 == null) goto L91;
        SkinConfigPage r23 = r22.getPageStyle();
        if (r23 == null) goto L91;
        String r24 = r23.getBgColor();
    L92:
        if (r28 == null) goto L94;
        Integer r25 = r28.k;
    L95:
        int r26 = r17.getValue();
        if (r25 != null) goto L99;
    L106:
        if (r2 == null) goto L113;
        SkinConfigStyle r29 = r2.getDark();
        if (r29 == null) goto L113;
        SkinConfigPage r30 = r29.getPageStyle();
        if (r30 == null) goto L113;
        r10 = r30.getBgUrl();
    L112:
        String r210 = r10;
    L115:
        if (r2 == null) goto L122;
        SkinConfigStyle r31 = r2.getDark();
        if (r31 == null) goto L122;
        SkinConfigPage r32 = r31.getPageStyle();
        if (r32 == null) goto L122;
        r3 = r32.getBgGradientConfig();
    L122:
        return new BackgroundWrapper(r111, new BackgroundInfo(r24, r210, null, null, r3, 12, null), null, null, Boolean.valueOf(r1), 12, null);
    L113:
        r210 = null;
        goto L115
    L99:
        if (r25.intValue() != r26) goto L106;
        if (r10 != null) goto L102;
    L103:
        r4 = true;
    L104:
        if (r4 == true) goto L106;
    L102:
        if (r10.length() != 0) goto L104;
    L94:
        r25 = null;
    L91:
        r24 = null;
    L83:
        r110 = null;
    L75:
        r19 = null;
        goto L77
    L59:
        if (r14.intValue() != r15) goto L68;
        if (r7 != null) goto L62;
    L65:
        boolean r33 = true;
    L66:
        if (r33 == true) goto L68;
    L62:
        if (r7.length() == 0) goto L65;
        r33 = false;
        goto L66
    L54:
        r14 = null;
    L51:
        r13 = null;
    L43:
        r10 = null;
    L36:
        r7 = null;
        goto L37
    L125:
        Gson r34 = new Gson();     // Catch: Exception -> L22
        if (r2 == null) goto L15;
        String r35 = r2.getExtra();     // Catch: Exception -> L22
    L16:
        SkinExtraData r36 = (SkinExtraData) r34.fromJson(r35, SkinExtraData.class);     // Catch: Exception -> L22
        if (r36 == null) goto L19;
        Boolean r37 = r36.isDarkMode();     // Catch: Exception -> L22
    L20:
        r1 = Intrinsics.areEqual(r37, Boolean.TRUE);     // Catch: Exception -> L22
        goto L30
    L19:
        r37 = null;
        goto L20
    L15:
        r35 = null;
    L22:
        e = move-exception;
        IHybridHostService r38 = com.bytedance.android.ec.hybrid.a.h();
        if (r38 == null) goto L29;
        String r39 = e.getMessage();
        if (r39 != null) goto L28;
        r39 = "";
    L28:
        r38.ensureNotReachHere(r39);
        goto L29
    L9:
        r0 = null;
    L5:
        r2 = new SkinConfig(null, null, null, 7, null);
        goto L6
    }
}
