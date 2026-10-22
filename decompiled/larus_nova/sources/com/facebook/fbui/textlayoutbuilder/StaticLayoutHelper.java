package com.facebook.fbui.textlayoutbuilder;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import com.facebook.fbui.textlayoutbuilder.proxy.StaticLayoutProxy;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes23.dex */
class StaticLayoutHelper {
    private static final String SPACE_AND_ELLIPSIS = " …";

    public StaticLayoutHelper() {
    }

    public static boolean fixLayout(StaticLayout r100) {
        int r101 = r100.getLineStart(0);
        int r102 = r100.getLineCount();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L13;
        int r104 = r100.getLineEnd(r103);
        if (r104 < r101) goto L15;
        r103 = r103 + 1;
        r101 = r104;
        goto L4
    L15:
        Field r105 = StaticLayout.class.getDeclaredField("mLines");     // Catch: Exception -> L14
        r105.setAccessible(true);     // Catch: Exception -> L14
        Field r106 = StaticLayout.class.getDeclaredField("mColumns");     // Catch: Exception -> L14
        r106.setAccessible(true);     // Catch: Exception -> L14
        int[] r107 = (int[]) r105.get(r100);     // Catch: Exception -> L14
        int r108 = r106.getInt(r100);     // Catch: Exception -> L14
        int r109 = 0;
    L8:
        if (r109 >= r108) goto L11;
        int r110 = (r108 * r103) + r109;     // Catch: Exception -> L14
        swap(r107, r110, r110 + r108);     // Catch: Exception -> L14
        r109 = r109 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    private static void swap(int[] r100, int r101, int r102) {
        int r103 = r100[r101];
        r100[r101] = r100[r102];
        r100[r102] = r103;
    }

    private static StaticLayout getStaticLayoutNoMaxLines(CharSequence r110, int r111, int r112, TextPaint r113, int r114, Layout.Alignment r115, float r116, float r210, boolean r211, TextUtils.TruncateAt r212, int r213) {
        return new StaticLayout(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, r213);
    }

    private static StaticLayout getStaticLayoutMaybeMaxLines(CharSequence r100, int r101, int r102, TextPaint r103, int r104, Layout.Alignment r105, float r106, float r107, boolean r108, TextUtils.TruncateAt r109, int r110, int r111, TextDirectionHeuristicCompat r112) {
        return StaticLayoutProxy.create(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112);
    L5:
        return getStaticLayoutNoMaxLines(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110);
    }

    public static StaticLayout make(CharSequence r110, int r111, int r112, TextPaint r210, int r211, Layout.Alignment r212, float r213, float r214, boolean r215, TextUtils.TruncateAt r216, int r217, int r218, TextDirectionHeuristicCompat r219, int r310, int r311, int r312, int[] r313, int[] r314) {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 23) goto L9;
        StaticLayout.Builder r101 = StaticLayout.Builder.obtain(r110, r111, r112, r210, r211).setAlignment(r212).setLineSpacing(r214, r213).setIncludePad(r215).setEllipsize(r216).setEllipsizedWidth(r217).setMaxLines(r218).setTextDirection(StaticLayoutProxy.fromTextDirectionHeuristicCompat(r219)).setBreakStrategy(r310).setHyphenationFrequency(r311).setIndents(r313, r314);
        if (r100 < 26) goto L8;
        r101.setJustificationMode(r312);
    L8:
        return r101.build();
    L9:
        StaticLayout r102 = getStaticLayoutMaybeMaxLines(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219);
        if (r218 <= 0) goto L30;
        StaticLayout r103 = r102;
        int r104 = r112;
    L13:
        if (r103.getLineCount() <= r218) goto L28;
        int r105 = r103.getLineStart(r218);
        if (r105 >= r104) goto L28;
        int r106 = r105;
    L18:
        if (r106 <= r111) goto L22;
        if (Character.isSpace(r110.charAt(r106 - 1)) == false) goto L22;
        r106 = r106 - 1;
    L22:
        int r113 = r106;
        StaticLayout r107 = getStaticLayoutMaybeMaxLines(r110, r111, r106, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219);
        if (r107.getLineCount() < r218) goto L27;
        if (r107.getEllipsisCount(r218 - 1) != 0) goto L27;
        String r108 = r110.subSequence(r111, r113) + SPACE_AND_ELLIPSIS;
        r107 = getStaticLayoutMaybeMaxLines(r108, 0, r108.length(), r210, r211, r212, r213, r214, r215, r216, r217, r218, r219);
    L27:
        r103 = r107;
        r104 = r113;
    L28:
        r102 = r103;
    L30:
        if (fixLayout(r102) == false) goto L30;
        return r102;
    }
}
