package com.lynx.tasm.utils;

import android.util.DisplayMetrics;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class n {
    public n() {
    }

    public static float a(String r100, float r101) {
        return b(r100, 0.0f, 0.0f, 0.0f, 0.0f, r101, DisplayMetricsHolder.getScreenDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [float] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static float e(String r100, float r110, DisplayMetrics r111) {
        ?? r101 = 0;
        if (android.text.TextUtils.isEmpty(r100) == false) goto L5;
        int r102 = 0;
    L7:
        if (r102 > 1) goto L15;
    L11:
        r100 = b(r100, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r111);     // Catch: Throwable -> L13
    L12:
        r101 = r100;
        return r101 == true ? 1.0f : 0.0f;
    L13:
        LLog.w("lynx", "Number parse error from value = " + r100 + " to px!");
        return r101;
    L15:
        if (r100.endsWith(GXTemplateKey.GAIAX_PE) == false) goto L11;
        r100 = (CastFloatProtector.parseFloat(r100.substring(0, r102 - 1)) * r110) / 100.0f;     // Catch: Throwable -> L13
        goto L12
    L5:
        r102 = r100.length();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static float d(String r100, float r101, float r102, DisplayMetrics r110) {
        if (android.text.TextUtils.isEmpty(r100) == false) goto L5;
        int r103 = 0;
    L7:
        if (r103 > 1) goto L15;
    L11:
        r100 = b(r100, 0.0f, 0.0f, 0.0f, 0.0f, r102, r110);     // Catch: Throwable -> L13
    L12:
        r102 = r100;
        return r102;
    L13:
        LLog.w("lynx", "Number parse error from value = " + r100 + " to px!");
        return r102;
    L15:
        if (r100.endsWith(GXTemplateKey.GAIAX_PE) == false) goto L11;
        r100 = (CastFloatProtector.parseFloat(r100.substring(0, r103 - 1)) * r101) / 100.0f;     // Catch: Throwable -> L13
        goto L12
    L5:
        r103 = r100.length();
        goto L7
    }

    public static float c(String r100, float r101, float r102, float r110, float r111, DisplayMetrics r112) {
        return b(r100, r101, r102, r110, r111, 0.0f, r112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [float] */
    /* JADX WARN: Type inference failed for: r6v11, types: [float] */
    /* JADX WARN: Type inference failed for: r6v12, types: [float] */
    /* JADX WARN: Type inference failed for: r6v3, types: [float] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [float] */
    /* JADX WARN: Type inference failed for: r6v9, types: [float] */
    public static float b(String r100, float r101, float r102, float r103, float r110, float r111, DisplayMetrics r112) {
        if (android.text.TextUtils.isEmpty(r100) == false) goto L5;
        int r104 = 0;
    L7:
        if (r104 > 3) goto L47;
    L11:
        if (r104 <= 3) goto L16;
        if (r100.endsWith("ppx") == false) goto L16;
        r111 = CastFloatProtector.parseFloat(r100.substring(0, r104 - 3));     // Catch: Throwable -> L44
    L46:
    L45:
        return r111;
    L44:
        LLog.w("lynx", "Number parse error from value = " + r100 + " to px!");
    L16:
        if (r104 <= 2) goto L21;
        if (r100.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L21;
        r111 = i.b(CastFloatProtector.parseFloat(r100.substring(0, r104 - 2)), 0.0f);     // Catch: Throwable -> L44
    L21:
        if (r104 > 1) goto L23;
    L25:
        if (r104 > 3) goto L27;
    L29:
        if (r104 > 2) goto L31;
    L33:
        if (r104 > 2) goto L35;
    L37:
        if (r104 > 2) goto L39;
    L41:
        if (r104 <= 0) goto L46;
        r111 = CastFloatProtector.parseFloat(r100);     // Catch: Throwable -> L44
        goto L46
    L39:
        if (r100.endsWith("vh") == false) goto L41;
        r100 = CastFloatProtector.parseFloat(r100.substring(0, r104 - 2));     // Catch: Throwable -> L44
        r111 = (r110 * r100) / 100.0f;     // Catch: Throwable -> L44
        goto L46
    L35:
        if (r100.endsWith("vw") == false) goto L37;
        r100 = CastFloatProtector.parseFloat(r100.substring(0, r104 - 2));     // Catch: Throwable -> L44
        r111 = (r103 * r100) / 100.0f;     // Catch: Throwable -> L44
        goto L46
    L31:
        if (r100.endsWith("em") == false) goto L33;
        r100 = CastFloatProtector.parseFloat(r100.substring(0, r104 - 2));     // Catch: Throwable -> L44
        r111 = r102 * r100;     // Catch: Throwable -> L44
        goto L46
    L27:
        if (r100.endsWith("rem") == false) goto L29;
        r100 = CastFloatProtector.parseFloat(r100.substring(0, r104 - 3));     // Catch: Throwable -> L44
        r111 = r101 * r100;     // Catch: Throwable -> L44
        goto L46
    L23:
        if (r100.endsWith(GXTemplateKey.GAIAX_PE) == false) goto L25;
        r100 = CastFloatProtector.parseFloat(r100.substring(0, r104 - 1));     // Catch: Throwable -> L44
        r111 = r100 / 100.0f;     // Catch: Throwable -> L44
        goto L46
    L47:
        if (r100.endsWith("rpx") == false) goto L11;
        r100 = r112.widthPixels * CastFloatProtector.parseFloat(r100.substring(0, r104 - 3));     // Catch: Throwable -> L44
        r111 = r100 / 750.0f;     // Catch: Throwable -> L44
        goto L46
    L5:
        r104 = r100.length();
        goto L7
    }
}
