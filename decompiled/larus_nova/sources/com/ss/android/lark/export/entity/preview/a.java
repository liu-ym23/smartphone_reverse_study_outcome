package com.ss.android.lark.export.entity.preview;

import android.content.Context;
import android.graphics.Color;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    static {
    }

    public static int b(int r100) {
        int r101 = (r100 >> 24) & 255;
        int r102 = (r100 >> 16) & 255;
        int r103 = (r100 >> 8) & 255;
        return Color.argb(r100 & 255, r101, r102, r103);
    }

    @JvmStatic
    public static final int a(ThemeColor r100, Context r101, ycb.a r102) {
        Intrinsics.checkNotNullParameter(r100, "themeColor");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r100.getToken();
        if (r103 == null) goto L8;
        int r104 = c(r101, r103, r102);
        if (r104 <= 0) goto L8;
        return UDColorUtils.getColor(r101, r104);
    L8:
        int r105 = 0;
        if (r100.getKey().getType() == null) goto L31;
        ThemeColor.Key r106 = r100.getKey();
        if (r106.getType() != ThemeColor.KeyType.STATIC_WHITE) goto L19;
        int r107 = c(r101, "static_white", r102);
        if (r107 != 0) goto L36;
        Integer r108 = r100.getValue();
        if (r108 == null) goto L37;
        r105 = r108.intValue();
    L37:
        return b(r105);
    L36:
        return UDColorUtils.getAlphaColor(r101, r107, r106.getAlpha() / 100.0f);
    L19:
        StringBuilder r109 = new StringBuilder("ud_");
        ThemeColor.KeyType r110 = r106.getType();
        if (r110 == null) goto L22;
        String r111 = r110.name();
    L23:
        r109.append(r111);
        r109.append(r106.getValue());
        int r112 = c(r101, r109.toString(), r102);
        if (r112 != 0) goto L38;
        Integer r113 = r100.getValue();
        if (r113 == null) goto L30;
        r105 = r113.intValue();
    L30:
        return b(r105);
    L38:
        return UDColorUtils.getAlphaColor(r101, r112, r106.getAlpha() / 100.0f);
    L22:
        r111 = null;
        goto L23
    L31:
        Integer r114 = r100.getValue();
        if (r114 == null) goto L35;
        r105 = r114.intValue();
    L35:
        return b(r105);
    }

    public static int c(Context r100, String r101, ycb.a r102) {
        if (r102 == null) goto L6;
        Integer r103 = r102.a(r101);
        if (r103 == null) goto L6;
        int r104 = r103.intValue();
    L7:
        if (r104 <= 0) goto L10;
        return r104;
    L10:
        return UDColorUtils.getColorIdByToken(r100, r101);
    L6:
        r104 = 0;
        goto L7
    }
}
