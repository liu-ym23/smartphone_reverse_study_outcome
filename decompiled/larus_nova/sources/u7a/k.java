package u7a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;

/* JADX INFO: loaded from: classes32.dex */
public final class k {
    public static String[] c(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.equalsIgnoreCase("") == true) goto L41;
        String[] r101 = r100.split(" ");
        if (r101.length > 4) goto L39;
        int r102 = 0;
        boolean r103 = true;
    L11:
        if (r102 >= Math.min(r101.length, 4)) goto L30;
        if (r101[r102].endsWith(GXTemplateKey.GAIAX_PX) == true) goto L18;
        if (r101[r102].endsWith(GXTemplateKey.GAIAX_PE) == true) goto L18;
    L16:
        r103 = false;
    L29:
        r102 = r102 + 1;
    L18:
        if (r101[r102].endsWith(GXTemplateKey.GAIAX_PX) == false) goto L24;
        if (r101[r102].length() <= 2) goto L16;
        String r104 = r101[r102];
        r103 = r104.substring(0, r104.length() - 2).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L24:
        if (r101[r102].endsWith(GXTemplateKey.GAIAX_PE) == false) goto L29;
        if (r101[r102].length() <= 1) goto L16;
        String r105 = r101[r102];
        r103 = r105.substring(0, r105.length() - 1).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L30:
        if (r103 == true) goto L32;
        return null;
    L32:
        return r101;
    L39:
        return null;
    L41:
        return null;
    }

    public static float[] d(String[] r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length > 4) goto L28;
        float[] r103 = {0.0f, 0.0f, 0.0f, 0.0f};
        int r104 = 0;
    L8:
        if (r104 >= r100.length) goto L20;
        if (r100[r104].endsWith(GXTemplateKey.GAIAX_PX) == false) goto L13;
        String r105 = r100[r104];
        r103[r104] = CastFloatProtector.parseFloat(r105.substring(0, r105.length() - 2));
    L19:
        r104 = r104 + 1;
        goto L8
    L13:
        if (r100[r104].endsWith(GXTemplateKey.GAIAX_PE) == false) goto L19;
        if (r104 == 0) goto L18;
        if (r104 == 2) goto L18;
        String r106 = r100[r104];
        r103[r104] = CastFloatProtector.parseFloat(r106.substring(0, r106.length() - 2)) * r101;
    L18:
        String r107 = r100[r104];
        r103[r104] = CastFloatProtector.parseFloat(r107.substring(0, r107.length() - 2)) * r102;
        goto L19
    L20:
        return r103;
    L28:
        return null;
    }

    public static Matrix e(int r100, int r101, int r110, int r111, m.b r112) {
        TraceEvent.beginSection("image.NinePatchHelper.getMatrix");
        Matrix r102 = new Matrix();
        float r103 = r100;
        float r113 = r110;
        float r104 = (r103 * 1.0f) / r113;
        float r105 = r101;
        float r114 = r111;
        float r106 = (r105 * 1.0f) / r114;
        if (r112 != m.b.f549123a) goto L6;
        r102.preScale(r104, r106);
    L18:
        TraceEvent.endSection("image.NinePatchHelper.getMatrix");
        return r102;
    L6:
        if (r112 != m.b.f549124b) goto L12;
        if (r104 <= r106) goto L10;
        r102.setScale(r106, r106);
        r102.postTranslate((r103 - (r113 * r106)) / 2.0f, 0.0f);
        goto L18
    L10:
        r102.setScale(r104, r104);
        r102.postTranslate(0.0f, (r105 - (r114 * r104)) / 2.0f);
        goto L18
    L12:
        if (r112 == m.b.f549126d) goto L14;
        float r115 = com.lynx.tasm.utils.i.b(1.0f, 0.0f);
        float r107 = Math.round((r103 - (r113 * r115)) * 0.5f);
        float r108 = Math.round((r105 - (r114 * r115)) * 0.5f);
        r102.setScale(r115, r115);
        r102.postTranslate(r107, r108);
        goto L18
    L14:
        if (r104 <= r106) goto L16;
        r102.setScale(r104, r104);
        r102.postTranslate(0.0f, (r105 - (r114 * r104)) / 2.0f);
        goto L18
    L16:
        r102.setScale(r106, r106);
        r102.postTranslate((r103 - (r113 * r106)) / 2.0f, 0.0f);
        goto L18
    }

    public static boolean a(int r110, int r111, int r112, int r113, m.b r114, String r115, String r210, Canvas r211, Bitmap r212, int r213) {
        TraceEvent.beginSection("image.NinePatchHelper.drawNinePatch");
        boolean r116 = false;
        float[] r100 = d(c(r115), r112, r113);     // Catch: Throwable -> L37
        if (r210 != null) goto L6;
    L13:
        float r101 = 1.0f;
    L15:
        if (r100 != null) goto L17;
    L28:
        boolean r102 = false;
    L29:
        if (r102 == true) goto L35;
        Matrix r103 = e(r110, r111, r112, r113, r114);     // Catch: Throwable -> L37
        if (r213 != 255) goto L33;
        Paint r104 = null;
    L34:
        r211.drawBitmap(r212, r103, r104);     // Catch: Throwable -> L37
    L36:
        r116 = true;
    L39:
        TraceEvent.endSection("image.NinePatchHelper.drawNinePatch");
        return r116;
    L33:
        r104 = new Paint(1);     // Catch: Throwable -> L37
        r104.setAlpha(r213);     // Catch: Throwable -> L37
        goto L34
    L35:
        b(r110, r111, r112, r113, r114, r100, r101, r211, r212, r213);     // Catch: Throwable -> L37
        goto L36
    L17:
        if (r100.length != 4) goto L28;
        if (r100[0] == 0.0f) goto L21;
    L27:
        r102 = true;
        goto L29
    L21:
        if (r100[1] != 0.0f) goto L27;
        if (r100[2] != 0.0f) goto L27;
        if (r100[3] != 0.0f) goto L27;
    L6:
        if (r210.equalsIgnoreCase("") == true) goto L13;
        r101 = CastFloatProtector.parseFloat(r210);     // Catch: Throwable -> L10
        goto L15
    L10:
        th = move-exception;
        LLog.w("BaseRoundedCornerPostprocessor", "initCapInsetsScale error " + th.getMessage());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        LLog.w("BaseRoundedCornerPostprocessor", "process customDraw warn " + th.getMessage());
        goto L39
    }

    public static void b(int r310, int r311, int r312, int r313, m.b r314, float[] r315, float r316, Canvas r317, Bitmap r410, int r411) {
        TraceEvent.beginSection("image.NinePatchHelper.drawWithCapInsets");
        Rect r100 = new Rect(0, 0, (int) (r315[3] * r316), (int) (r315[0] * r316));
        float r110 = r312;
        Rect r111 = new Rect(r100.right, r100.top, (int) (r110 - (r315[1] * r316)), r100.bottom);
        Rect r112 = new Rect(r111.right, r100.top, r312, r100.bottom);
        float r101 = r313;
        Rect r113 = new Rect(r100.left, r100.bottom, r100.right, (int) (r101 - (r315[2] * r316)));
        Rect r102 = new Rect(r113.right, r113.top, r111.right, r113.bottom);
        Rect r103 = new Rect(r102.right, r113.top, r112.right, r113.bottom);
        Rect r114 = new Rect(r113.left, r113.bottom, r113.right, r313);
        Rect r115 = new Rect(r114.right, r114.top, r102.right, r114.bottom);
        Rect r104 = new Rect(r115.right, r114.top, r103.right, r114.bottom);
        Rect r116 = new Rect();
        Rect r117 = new Rect();
        Rect r118 = new Rect();
        Rect r119 = new Rect();
        Rect r105 = new Rect();
        Rect r120 = new Rect();
        Rect r106 = new Rect();
        Rect r107 = new Rect();
        Rect r108 = new Rect();
        float r109 = r311;
        float r121 = r310;
        float r122 = r310 / r312;
        float r123 = r311 / r313;
        if (r314 != m.b.f549124b) goto L8;
        if (r122 > r123) goto L12;
    L11:
        float r124 = r101 * r122;
        float r125 = ((r109 - r124) / 2.0f) + 0.0f;
        float r126 = 0.0f;
    L18:
        int r127 = (int) r126;
        r116.left = r127;
        int r128 = (int) r125;
        r116.top = r128;
        r116.right = (int) (com.lynx.tasm.utils.i.b(r315[3], 0.0f) + r126);
        r116.bottom = (int) (com.lynx.tasm.utils.i.b(r315[0], 0.0f) + r125);
        r117.left = r116.right;
        r117.top = r116.top;
        int r129 = (int) ((r126 + r121) - com.lynx.tasm.utils.i.b(r315[1], 0.0f));
        r117.right = r129;
        r117.bottom = r116.bottom;
        r118.left = r129;
        r118.top = r116.top;
        r118.right = r127 + ((int) r121);
        r118.bottom = r116.bottom;
        r119.left = r116.left;
        r119.top = r116.bottom;
        r119.right = r116.right;
        int r130 = (int) ((r125 + r124) - com.lynx.tasm.utils.i.b(r315[2], 0.0f));
        r119.bottom = r130;
        r105.left = r119.right;
        r105.top = r119.top;
        int r131 = r117.right;
        r105.right = r131;
        r105.bottom = r130;
        r120.left = r131;
        r120.top = r118.bottom;
        r120.right = r118.right;
        r120.bottom = r119.bottom;
        r106.left = r116.left;
        r106.top = r119.bottom;
        int r132 = r119.right;
        r106.right = r132;
        int r133 = r128 + ((int) r124);
        r106.bottom = r133;
        r107.left = r132;
        r107.top = r105.bottom;
        int r134 = r105.right;
        r107.right = r134;
        r107.bottom = r133;
        r108.left = r134;
        r108.top = r120.bottom;
        r108.right = r120.right;
        r108.bottom = r133;
        Paint r135 = new Paint(1);
        r135.setAlpha(r411);
        r317.drawBitmap(r410, r100, r116, r135);
        r317.drawBitmap(r410, r111, r117, r135);
        r317.drawBitmap(r410, r112, r118, r135);
        r317.drawBitmap(r410, r113, r119, r135);
        r317.drawBitmap(r410, r102, r105, r135);
        r317.drawBitmap(r410, r103, r120, r135);
        r317.drawBitmap(r410, r114, r106, r135);
        r317.drawBitmap(r410, r115, r107, r135);
        r317.drawBitmap(r410, r104, r108, r135);
        TraceEvent.endSection("image.NinePatchHelper.drawWithCapInsets");
        return;
    L12:
        float r136 = r110 * r123;
        float r137 = ((r121 - r136) / 2.0f) + 0.0f;
    L17:
        r126 = r137;
        r124 = r109;
        r121 = r136;
        r125 = 0.0f;
        goto L18
    L8:
        if (r314 != m.b.f549126d) goto L14;
        if (r122 <= r123) goto L12;
    L14:
        if (r314 != m.b.f549125c) goto L16;
        float r138 = com.lynx.tasm.utils.i.b(1.0f, 0.0f);
        int r139 = (int) (r110 * r138);
        int r140 = (int) (r101 * r138);
        r126 = Math.round((r310 - r139) * 0.5f);
        r125 = Math.round((r311 - r140) * 0.5f);
        r121 = r139;
        r124 = r140;
        goto L18
    L16:
        r136 = r121;
        r137 = 0.0f;
        goto L17
    }
}
