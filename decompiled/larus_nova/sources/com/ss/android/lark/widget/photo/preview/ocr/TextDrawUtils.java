package com.ss.android.lark.widget.photo.preview.ocr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import com.alipay.sdk.m.u.i;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes38.dex */
public final class TextDrawUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextPaint f447050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f447051b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f447052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f447053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f447054c;

        public a(float r100, float r101, float r102) {
            this.f447052a = r100;
            this.f447053b = r101;
            this.f447054c = r102;
        }
    }

    static {
        TextPaint r100 = new TextPaint();
        r100.setAntiAlias(true);
        r100.setTextAlign(Paint.Align.LEFT);
        f447050a = r100;
        f447051b = new Regex("(?<=[\\u4E00-\\u9FFF])([,.;?!])(?=[\\u4E00-\\u9FFF])");
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Regex r101 = f447051b;     // Catch: Exception -> L5
        final Map r102 = MapsKt.mapOf(new Pair[]{TuplesKt.to(",", "，"), TuplesKt.to(".", "。"), TuplesKt.to(i.f25853b, "；"), TuplesKt.to("?", "？"), TuplesKt.to("!", "！")});     // Catch: Exception -> L5
        return r101.replace(r100, new TextDrawUtils$convertPunctuationInChineseText$1(r102));
    L5:
        e = move-exception;
        Log.e("TextDrawUtils", "convertPunctuationInChineseText: " + ExceptionsKt.stackTraceToString(e));
        return r100;
    }

    public static a a(String r100, float r101, float r102, float r103, float r110) {
        if (r100.length() > 1) goto L5;
    L24:
        float r104 = 0.0f;
    L26:
        return new a(r101, r104, r103);
    L5:
        if (r110 >= r102) goto L24;
        float r105 = r102 - r110;
        int r111 = r100.length();
        boolean r106 = false;
        int r107 = 0;
        int r108 = 0;
    L7:
        if (r107 >= r111) goto L18;
        char r109 = r100.charAt(r107);
        if (19968 <= r109) goto L11;
    L13:
        boolean r112 = false;
    L14:
        if (r112 == false) goto L16;
        r108 = r108 + 1;
    L16:
        r107 = r107 + 1;
        goto L7
    L11:
        if (r109 >= 40960) goto L13;
        r112 = true;
        goto L14
    L18:
        if (r108 <= (r100.length() / 2)) goto L20;
        r106 = true;
    L20:
        if (r106 == false) goto L22;
        float r113 = 0.1f;
    L23:
        r104 = Math.min(r105 / (r100.length() - 1), r113 * r101);
        goto L26
    L22:
        r113 = 0.2f;
        goto L23
    }

    @JvmStatic
    public static final void c(Canvas r100, String r101, RectF r102, float r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r102, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r104, "paint");
        if (r101 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        return;
    L11:
        float r106 = r104.getTextSize();
        r104.setAntiAlias(true);
        r104.setStyle(Paint.Style.FILL);
        r104.setLetterSpacing(r103 / r106);
        Paint.FontMetrics r107 = r104.getFontMetrics();
        float r108 = r107.bottom - r107.top;
        float r109 = r102.top;
        float r110 = r102.height() + r108;
        float r111 = 2;
        r100.drawText(r101, r102.left + ((r102.width() - r104.measureText(r101)) / r111), (r109 + (r110 / r111)) - r107.bottom, r104);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
