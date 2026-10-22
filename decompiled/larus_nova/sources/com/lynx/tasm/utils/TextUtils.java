package com.lynx.tasm.utils;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.camera.video.AudioStats;
import com.lynx.react.bridge.JavaOnlyMap;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import z6a.p;

/* JADX INFO: loaded from: classes32.dex */
class TextUtils {
    public TextUtils() {
    }

    private static double getTextWidth(String r100, String r101, String r102) {
        if (r100.isEmpty() == false) goto L5;
    L11:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        if (r101.isEmpty() == true) goto L11;
        DecimalFormat r103 = com.lynx.tasm.behavior.shadow.text.b.f382275a;
        float r104 = n.a(r101, i.b(14.0f, 0.0f));
        if (r104 <= 0.0f) goto L11;
        return i.c(com.lynx.tasm.behavior.shadow.text.b.k(r104, r102).measureText(r100));
    }

    private static String getFirstLineText(String r110, String r111, String r112, String r113) {
        if (r110.isEmpty() == false) goto L5;
    L23:
        return "";
    L5:
        if (r111.isEmpty() == true) goto L23;
        DecimalFormat r100 = com.lynx.tasm.behavior.shadow.text.b.f382275a;
        float r114 = n.a(r111, i.b(14.0f, 0.0f));
        if (android.text.TextUtils.isEmpty(r113) == false) goto L10;
        float r115 = 0.0f;
    L12:
        if (r114 <= 0.0f) goto L23;
        if (r115 < 1.0f) goto L23;
        TextPaint r101 = com.lynx.tasm.behavior.shadow.text.b.k(r114, r112);
        if (Build.VERSION.SDK_INT < 23) goto L19;
        StaticLayout.Builder r116 = StaticLayout.Builder.obtain(r110, 0, r110.length(), r101, (int) Math.floor(r115));
        r116.setMaxLines(1);
        StaticLayout r117 = r116.build();
    L21:
        if (r117.getLineCount() <= 0) goto L23;
        return r110.substring(r117.getLineStart(0), r117.getLineEnd(0));
    L19:
        r117 = p.a(r110, r110.length(), r101, (int) Math.floor(r115), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 1, TextDirectionHeuristics.FIRSTSTRONG_LTR);
        goto L21
    L10:
        r115 = n.a(r113, i.b(0.0f, 0.0f));
        goto L12
    }

    private static ByteBuffer getTextInfo(String r100, String r101, String r102, String r103, int r104) {
        JavaOnlyMap r105 = com.lynx.tasm.behavior.shadow.text.b.i(r100, r101, r102, r103, r104);
        j7a.a.f497652a.getClass();
        return j7a.a.b(r105);
    }
}
