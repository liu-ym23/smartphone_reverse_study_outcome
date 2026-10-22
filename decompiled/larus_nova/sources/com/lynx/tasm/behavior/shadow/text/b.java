package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z6a.j;
import z6a.p;
import z6a.q;
import z6a.r;
import z6a.w;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DecimalFormat f382275a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f382276a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            f382276a = r100;
            r100[ReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f382276a[ReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f382276a[ReadableType.Long.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f382276a[ReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f382276a[ReadableType.Boolean.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f382276a[ReadableType.Null.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        f382275a = new DecimalFormat("###################.###########");
    }

    public static String b(f6a.a r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ReadableType r101 = r100.getType();
        switch(a.f382276a[r101.ordinal()]) {
            case 1: goto L13;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            default: goto L14;
        };
    L14:
        return null;
    L15:
        return String.valueOf(r100.asBoolean());
    L16:
        return h(r100.asDouble());
    L17:
        return String.valueOf(r100.asLong());
    L18:
        return String.valueOf(r100.asInt());
    L13:
        return r100.asString();
    }

    public static String h(double r100) {
        if (r100 >= 9.223372036854776E18d) goto L11;
        if (r100 <= (-9.223372036854776E18d)) goto L11;
        long r101 = (long) Math.floor(r100);
        if (r100 != r101) goto L11;
        return String.valueOf(r101);
    L11:
        return f382275a.format(r100);
    }

    public static void e(Canvas r210, Layout r211) {
        Spanned r100 = (Spanned) r211.getText();
        q[] r101 = (q[]) r100.getSpans(0, r100.length(), q.class);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length == 0) goto L51;
        int r110 = r100.getSpanStart(r101[0]);
        int r102 = r100.getSpanEnd(r101[0]);
        int r103 = (int) r211.getPaint().getTextSize();
        if (r110 != 0) goto L34;
        int r104 = 1;
    L11:
        if (r104 >= r101.length) goto L33;
        int r105 = r100.getSpanStart(r101[r104]);
        int r106 = r100.getSpanEnd(r101[r104]);
        AbsoluteSizeSpan[] r107 = (AbsoluteSizeSpan[]) r100.getSpans(r105, r106, AbsoluteSizeSpan.class);
        if (r107.length == 0) goto L15;
        int r108 = r107[0].getSize();
    L16:
        q r111 = r101[r104];
        d(r210, r211, r111.f570608c, r111.f570609d, r111.f570606a, r111.f570607b, r105, r106, r108);
        if (r105 < r110) goto L32;
        if (r106 > r102) goto L32;
        q r112 = r101[0];
        d(r210, r211, r112.f570608c, r112.f570609d, r112.f570606a, r112.f570607b, r106 + 1, r102, r103);
        q r109 = r101[0];
        if (r109.f570606a == true) goto L22;
    L24:
        boolean r113 = false;
    L26:
        if (r109.f570607b == true) goto L28;
    L30:
        boolean r114 = false;
    L31:
        d(r210, r211, r109.f570608c, r109.f570609d, r113, r114, r105, r106, r108);
        r102 = r105;
        goto L32
    L28:
        if (r101[r104].f570607b == true) goto L30;
        r114 = true;
        goto L31
    L22:
        if (r101[r104].f570606a == true) goto L24;
        r113 = true;
    L32:
        r104 = r104 + 1;
        goto L11
    L15:
        r108 = r103;
        goto L16
    L33:
        q r115 = r101[0];
        d(r210, r211, r115.f570608c, r115.f570609d, r115.f570606a, r115.f570607b, r110, r102, r103);
        return;
    L34:
        int r116 = 0;
    L36:
        if (r116 >= r101.length) goto L52;
        int r117 = r100.getSpanStart(r101[r116]);
        int r118 = r100.getSpanEnd(r101[r116]);
        AbsoluteSizeSpan[] r119 = (AbsoluteSizeSpan[]) r100.getSpans(r117, r118, AbsoluteSizeSpan.class);
        if (r119.length == 0) goto L40;
        int r212 = r119[0].getSize();
    L41:
        q r120 = r101[r116];
        d(r210, r211, r120.f570608c, r120.f570609d, r120.f570606a, r120.f570607b, r117, r118, r212);
        r116 = r116 + 1;
        goto L36
    L40:
        r212 = r103;
        goto L41
    L52:
        return;
    }

    public static void g(Layout r100, Canvas r101) {
        Spanned r102 = (Spanned) r100.getText();
        j[] r103 = (j[]) r102.getSpans(0, r102.length(), j.class);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.length <= 0) goto L15;
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r103[r105].f570588d = true;
        r105 = r105 + 1;
        goto L7
    L9:
        r100.draw(r101);
        int r106 = r103.length;
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L16;
        r103[r107].f570588d = false;
        r107 = r107 + 1;
        goto L10
    L16:
        return;
    }

    public static TextPaint k(float r100, String r101) {
        TextPaint r102 = new TextPaint(1);
        r102.setTextSize(r100);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        Typeface r103 = g.c(r101, 0);
    L6:
        if (r103 == null) goto L8;
        r102.setTypeface(r103);
    L9:
        return r102;
    L8:
        r102.setTypeface(DeviceUtils.b());
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public static TextPaint l(com.lynx.tasm.behavior.shadow.text.a r100, Typeface r101) {
        TextPaint r102 = new TextPaint(1);
        r102.setTextSize(r100.f382258n);
        if (TextUtils.isEmpty(r100.f382265u) == true) goto L6;
        if (r101 == null) goto L6;
        r102.setTypeface(r101);
    L7:
        String r103 = r100.c();
        String r104 = r100.E;
        int r105 = r100.f382252h;
        if (r105 == 0) goto L10;
    L13:
        n(r102, r100.f382265u, r105, r100.f382251g, r103, r104, r100.B);
    L14:
        Integer r106 = r100.f382247c;
        if (r106 == null) goto L17;
        r102.setColor(r106.intValue());
    L17:
        float r107 = r100.f382256l;
        if (r107 == 1.0E21f) goto L20;
        r102.setLetterSpacing(r107 / r102.getTextSize());
    L20:
        com.lynx.tasm.behavior.ui.g r108 = r100.I;
        if (r108 == null) goto L23;
        r102.setShadowLayer(r108.f382530d, r108.f382528b, r108.f382529c, r108.f382527a);
    L23:
        return r102;
    L10:
        if (r100.f382251g != 0) goto L13;
        if (r103 != null) goto L13;
        if (r104 == null) goto L14;
    L6:
        r102.setTypeface(DeviceUtils.b());
        goto L7
    }

    public static ArrayList<CharSequence> m(CharSequence r100, boolean r101) {
        ArrayList<CharSequence> r102 = new ArrayList();
        boolean r103 = false;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r100.length()) goto L30;
        char r106 = r100.charAt(r104);
        if (r106 < 19968) goto L11;
        if (r106 > 40869) goto L11;
        Pattern r107 = PatternProtector.compile("[一-龥][\\u3002\\uff1f\\uff01\\uff0c\\u3001\\uff1b\\uff1a\\u2018\\u2019\\u201c\\u201d\\uff08\\uff09\\u3014\\u3015\\u3010\\u3011\\u2026\\u2014\\p{Punct}]*");
    L20:
        if (r107 != null) goto L21;
        if (Character.isHighSurrogate(r106) == true) goto L27;
        r104 = r104 + 1;
        goto L4
    L27:
        r105 = r104 + 2;
        r102.add(r100.subSequence(r104, r105));
    L28:
        r104 = r105;
        goto L4
    L21:
        Matcher r108 = r107.matcher(r100.subSequence(r104, r100.length()));
        if (r108.find() == false) goto L24;
        int r109 = r104 + r108.end();
        r102.add(r100.subSequence(r105, r109));
        r105 = r109;
        goto L28
    L24:
        r105 = r104 + 1;
        r102.add(r100.subSequence(r104, r105));
    L11:
        if (Character.isLetter(r106) == false) goto L14;
        r107 = PatternProtector.compile("\\w+\\p{Punct}*");
        goto L20
    L14:
        if (Character.isDigit(r106) == false) goto L17;
        r107 = PatternProtector.compile("\\d+\\.\\d+");
        goto L20
    L17:
        if (Character.isSpaceChar(r106) == false) goto L19;
        r107 = PatternProtector.compile("\\s*");
        goto L20
    L19:
        r107 = null;
        goto L20
    L30:
        if (r105 == r104) goto L33;
        r102.add(r100.subSequence(r105, r104));
    L33:
        if (r101 == false) goto L35;
        int r110 = 0;
    L36:
        CharSequence r111 = (CharSequence) ListProtector.get(r102, r110);
        int r112 = 0;
    L38:
        if (r112 >= r111.length()) goto L43;
        if (Character.isWhitespace(r111.charAt(r112)) == false) goto L44;
        r112 = r112 + 1;
    L44:
        if (r103 == false) goto L46;
        ListProtector.remove(r102, r110);
    L46:
        return r102;
    L43:
        r103 = true;
        goto L44
    L35:
        r110 = r102.size() - 1;
        goto L36
    }

    public static int a(int r100, Paint.FontMetricsInt r101, boolean r110) {
        int r102 = r101.top;
        int r103 = r101.ascent;
        int r104 = r101.descent;
        int r105 = r104 - r103;
        int r106 = (r100 - r105) / 2;
        int r107 = (r100 - r106) - r105;
        int r108 = r101.bottom;
        int r109 = r108 - r102;
        int r111 = (r100 - r109) / 2;
        int r112 = r103 - r106;
        r101.ascent = r112;
        int r113 = r104 + r107;
        r101.descent = r113;
        int r114 = r102 - r111;
        r101.top = r114;
        int r115 = r108 + ((r100 - r111) - r109);
        r101.bottom = r115;
        if (r113 >= 0) goto L5;
        r101.ascent = r112 - r113;
        r101.descent = 0;
    L5:
        int r116 = r101.ascent;
        if (r116 <= 0) goto L8;
        r101.descent -= r116;
        r101.ascent = 0;
    L8:
        if (r115 >= 0) goto L10;
        r101.top = r114 - r115;
        r101.bottom = 0;
    L10:
        int r117 = r101.top;
        if (r117 <= 0) goto L13;
        r101.bottom -= r117;
        r101.top = 0;
    L13:
        if (r110 == false) goto L17;
        return r102 - r101.top;
    L17:
        return r103 - r101.ascent;
    }

    public static void c(final LynxContext r100, int r110, w r111) {
        if (r100 == null) goto L17;
        if (r111 == null) goto L18;
        Layout r101 = r111.f570621c;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r111.f570632n == true) goto L20;
        int r102 = r111.f570626h;
        if (r102 <= 0) goto L12;
        if (r101 == null) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L21;
        final m7a.a r112 = j(r110, r101, r111.f570628j, r102, r111.f570627i, r111.f570629k, r111.f570630l, r111.f570631m);
        r111.f570632n = true;
        UIThreadUtils.runOnUiThread(new r(r100, r112));
        return;
    L21:
        return;
    L12:
        r103 = false;
        goto L13
    L20:
        return;
    L18:
        return;
    }

    public static void f(Canvas r110, Layout r111, float r112) {
        int r100 = r111.getLineCount();
        ArrayList[] r101 = new ArrayList[r100];
        ArrayList[] r102 = new ArrayList[r100];
        int r103 = 1;
        CharSequence r104 = r111.getText();     // Catch: Exception -> L35
        int r105 = 0;
    L4:
        if (r105 >= r100) goto L34;
        CharSequence r106 = r104.subSequence(r111.getLineStart(r105), r111.getLineEnd(r105));     // Catch: Exception -> L35
        float r113 = 0.0f;
        if (r105 != (r100 - 1)) goto L8;
        float r107 = Layout.getDesiredWidth(r106, r111.getPaint());     // Catch: Exception -> L35
        ArrayList r108 = new ArrayList();     // Catch: Exception -> L35
        r108.add(r106);     // Catch: Exception -> L35
        r101[r105] = r108;     // Catch: Exception -> L35
        ArrayList r109 = new ArrayList();     // Catch: Exception -> L35
        if (r111.getParagraphDirection(r105) != (-1)) goto L32;
        r113 = r112 - r107;     // Catch: Exception -> L35
    L32:
        r109.add(Float.valueOf(r113));     // Catch: Exception -> L35
        r102[r105] = r109;     // Catch: Exception -> L35
    L33:
        r105 = r105 + 1;
        r103 = 1;
        goto L4
    L8:
        if (r111.getParagraphDirection(r105) != (-1)) goto L10;
        boolean r114 = true;
    L11:
        ArrayList<CharSequence> r115 = m(r106, r114);     // Catch: Exception -> L35
        r101[r105] = r115;     // Catch: Exception -> L35
        ArrayList r116 = new ArrayList();     // Catch: Exception -> L35
        int r117 = r115.size() - r103;     // Catch: Exception -> L35
        float[] r118 = new float[r115.size()];     // Catch: Exception -> L35
        int r119 = 0;
        float r120 = 0.0f;
    L13:
        if (r119 >= r115.size()) goto L15;
        float r121 = Layout.getDesiredWidth((CharSequence) ListProtector.get(r115, r119), r111.getPaint());     // Catch: Exception -> L35
        r118[r119] = r121;     // Catch: Exception -> L35
        r120 = r120 + r121;     // Catch: Exception -> L35
        r119 = r119 + 1;     // Catch: Exception -> L35
        goto L13
    L15:
        float r122 = r112 - r120;     // Catch: Exception -> L35
        if (r117 == 0) goto L19;
        r122 = r122 / r117;     // Catch: Exception -> L35
    L19:
        if (r117 == 0) goto L21;
    L23:
        r116.add(Float.valueOf(0.0f));     // Catch: Exception -> L35
    L24:
        int r123 = 1;
    L26:
        if (r123 >= r115.size()) goto L28;
        r113 = (r113 + r118[r123 - 1]) + r122;     // Catch: Exception -> L35
        r116.add(Float.valueOf(r113));     // Catch: Exception -> L35
        r123 = r123 + 1;     // Catch: Exception -> L35
        goto L26
    L28:
        r102[r105] = r116;     // Catch: Exception -> L35
        goto L33
    L21:
        if (r111.getParagraphDirection(r105) != (-1)) goto L23;
        r116.add(Float.valueOf(r112 - r120));     // Catch: Exception -> L35
        goto L24
    L10:
        r114 = false;
        goto L11
    L34:
        boolean r124 = false;
    L37:
        if (r124 == true) goto L45;
        int r125 = 0;
    L39:
        if (r125 >= r100) goto L55;
        float r126 = r111.getLineBaseline(r125);
        ArrayList r127 = r101[r125];
        ArrayList r128 = r102[r125];
        int r129 = 0;
    L42:
        if (r129 >= r127.size()) goto L44;
        r110.drawText(((CharSequence) ListProtector.get(r127, r129)).toString(), ((Float) ListProtector.get(r128, r129)).floatValue(), r126, r111.getPaint());
        r129 = r129 + 1;
        goto L42
    L44:
        r125 = r125 + 1;
        goto L39
    L55:
        return;
    L45:
        return;
    L35:
        e = move-exception;
        LLog.e("TextHelper", "draw justify text error:" + e.toString());
        r111.draw(r110);
        r124 = true;
        goto L37
    }

    public static JavaOnlyMap i(String r110, String r111, String r210, String r211, int r212) {
        float r100 = n.a(r111, i.b(14.0f, 0.0f));
        if (TextUtils.isEmpty(r211) == false) goto L5;
        float r101 = 0.0f;
    L6:
        JavaOnlyMap r112 = new JavaOnlyMap();
        if (r110.isEmpty() == false) goto L9;
    L38:
        r112.putDouble("width", 0.0f);
        return r112;
    L9:
        if (r100 <= 0.0f) goto L38;
        if (r212 > 1) goto L13;
    L15:
        if (r212 == 1) goto L17;
    L19:
        TextPaint r102 = k(r100, r210);
        JavaOnlyArray r113 = new JavaOnlyArray();
        float r114 = -1.0f;
        int r115 = 0;
        if (Build.VERSION.SDK_INT < 23) goto L28;
        StaticLayout.Builder r103 = StaticLayout.Builder.obtain(r110, 0, r110.length(), r102, (int) Math.floor(r101));
        r103.setMaxLines(r212);
        StaticLayout r104 = r103.build();
        int r105 = 0;
    L23:
        if (r105 >= r104.getLineCount()) goto L25;
        r114 = Math.max(r114, r104.getLineMax(r105));
        r105 = r105 + 1;
        goto L23
    L25:
        float r106 = i.c(r114);
        int r107 = r104.getLineCount();
    L26:
        if (r115 >= r107) goto L36;
        r113.add(r110.substring(r104.getLineStart(r115), r104.getLineEnd(r115)));
        r115 = r115 + 1;
    L36:
        r112.putDouble("width", r106);
        r112.putArray("content", r113);
        return r112;
    L28:
        StaticLayout r108 = p.a(r110, r110.length(), r102, (int) Math.floor(r101), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, r212, TextDirectionHeuristics.FIRSTSTRONG_LTR);
        int r109 = r108.getLineCount();
        int r116 = 0;
    L29:
        if (r116 >= r109) goto L31;
        r113.add(r110.substring(r108.getLineStart(r116), r108.getLineEnd(r116)));
        r116 = r116 + 1;
        goto L29
    L31:
        int r117 = 0;
    L33:
        if (r117 >= r108.getLineCount()) goto L35;
        r114 = Math.max(r114, r108.getLineMax(r117));
        r117 = r117 + 1;
        goto L33
    L35:
        r106 = i.c(r114);
        goto L36
    L17:
        if (r101 >= 1.0f) goto L19;
        r101 = 32767.0f;
        goto L19
    L13:
        if (r101 >= 1.0f) goto L15;
    L5:
        r101 = n.a(r211, i.b(0.0f, 0.0f));
        goto L6
    }

    public static void n(TextPaint r100, String r101, int r102, int r110, String r111, String r112, boolean r113) {
        Typeface r103 = r100.getTypeface();
        int r104 = Build.VERSION.SDK_INT;
        boolean r105 = false;
        if (r104 < 28) goto L13;
        if (r110 != 1) goto L6;
        int r106 = 700;
    L9:
        if (r102 != 2) goto L11;
        boolean r107 = true;
    L12:
        Typeface r108 = Typeface.create(r103, r106, r107);
    L20:
        r100.setTypeface(r108);
        if (r102 > 0) goto L23;
    L35:
        if (r111 != null) goto L37;
        if (r112 != null) goto L37;
        return;
    L37:
        com.lynx.tasm.fontface.g r109 = new com.lynx.tasm.fontface.g(r111, r100.getTextSize(), r101);
        FontFaceManager r114 = FontFaceManager.g.f383410a;
        Typeface r115 = r114.f383383d.get(r109);
        if (r115 == null) goto L40;
        r100.setTypeface(r115);
    L62:
        if (r112 == null) goto L66;
        r100.setFontFeatureSettings(r112);
        return;
    L66:
        return;
    L40:
        if (r111 != null) goto L42;
    L57:
        if (r113 == false) goto L62;
        Typeface r116 = r100.getTypeface();
        if (r116 == null) goto L61;
        r114.f383383d.put(r109, r116);
        goto L62
    L61:
        r114.getClass();
        goto L62
    L42:
        if (r104 >= 26) goto L45;
    L55:
        if (r105 == false) goto L57;
        r100.setFontVariationSettings(r111);
        goto L57
    L45:
        if (r104 != 35) goto L54;
        String r117 = Build.BRAND;
        if (r117 != null) goto L50;
    L52:
        boolean r118 = false;
    L53:
        if (r118 == true) goto L55;
    L50:
        if (r117.toLowerCase(Locale.ENGLISH).indexOf(RomUtils.BRAND_HONOR) <= (-1)) goto L52;
        r118 = true;
    L54:
        r105 = true;
        goto L55
    L23:
        if (TextUtils.isEmpty(r101) == false) goto L35;
        if (r108 == null) goto L26;
        int r119 = r108.getStyle();
    L27:
        int r120 = r102 & (~r119);
        if ((r120 & 1) == 0) goto L31;
        if (r110 != 1) goto L31;
        boolean r121 = true;
    L32:
        r100.setFakeBoldText(r121);
        if ((r120 & 2) == 0) goto L35;
        r100.setTextSkewX(-0.25f);
    L31:
        r121 = false;
        goto L32
    L26:
        r119 = 0;
        goto L27
    L11:
        r107 = false;
        goto L12
    L6:
        if (r110 != 0) goto L8;
        r106 = 400;
        goto L9
    L8:
        r106 = (r110 - 1) * 100;
        goto L9
    L13:
        if (r103 != null) goto L15;
        int r122 = 0;
    L16:
        int r123 = r122 | r102;
        if (r103 != null) goto L19;
        r108 = Typeface.defaultFromStyle(r123);
        goto L20
    L19:
        r108 = Typeface.create(r103, r123);
        goto L20
    L15:
        r122 = r103.getStyle();
        goto L16
    }

    public static m7a.a j(int r100, Layout r101, int r102, int r110, int r111, int r112, float r113, boolean r114) {
        m7a.a r103 = new m7a.a(r100, "layout");
        r103.a("lineCount", Integer.valueOf(r110));
        int r104 = 0;
        if (r110 > r101.getLineCount()) goto L23;
        if (r110 == 0) goto L23;
        ArrayList r105 = new ArrayList();
    L8:
        if (r104 >= r110) goto L10;
        HashMap r106 = new HashMap();
        r106.put("start", Integer.valueOf(r101.getLineStart(r104)));
        r106.put("end", Integer.valueOf(r101.getLineEnd(r104)));
        r106.put("ellipsisCount", Integer.valueOf(r101.getEllipsisCount(r104)));
        r105.add(r106);
        r104 = r104 + 1;
        goto L8
    L10:
        int r107 = r110 - 1;
        HashMap r108 = (HashMap) ListProtector.get(r105, r107);
        int r109 = ((Integer) r108.get("ellipsisCount")).intValue();
        int r115 = ((Integer) r108.get("end")).intValue();
        if (r111 <= 0) goto L14;
    L19:
        r108.put("ellipsisCount", Integer.valueOf(r111));
        r108.put("end", Integer.valueOf(r112));
        r103.a(GXTemplateKey.STYLE_FONT_LINES, r105);
        if (r114 == false) goto L22;
        HashMap r116 = new HashMap();
        r116.put("width", Float.valueOf(i.c(r113)));
        r116.put("height", Float.valueOf(i.c(r101.getLineBottom(r107))));
        r103.a("size", r116);
    L22:
        return r103;
    L14:
        if (r110 < r101.getLineCount()) goto L18;
        if (r102 == 0) goto L18;
        r111 = r109;
    L18:
        r111 = r112 - r115;
    L23:
        LLog.e("TextHelper", "getTextLayoutEvent: get lineCount error");
        r103.a("lineCount", 0);
        return r103;
    }

    public static void d(Canvas r210, Layout r211, int r212, int r213, boolean r310, boolean r311, int r312, int r313, int r314) {
        Layout r100 = r211;
        int r101 = r313;
        if (r312 >= r101) goto L108;
        if (r310 == true) goto L8;
        if (r311 == true) goto L8;
        return;
    L8:
        if (r212 != 4) goto L10;
        float r102 = r314;
        Paint r110 = new Paint();
        r110.setColor(r213);
        float r111 = r102 / 3.0f;
        r110.setStrokeWidth(r111 / 5.0f);
        int r112 = r100.getLineForOffset(r312);
        int r113 = r100.getLineForOffset(r101);
        int r114 = r112;
    L92:
        if (r114 > r113) goto L135;
        float r103 = r100.getLineLeft(r114);
        float r104 = r100.getLineBaseline(r114);
        float r105 = r100.getLineMax(r114);
        if (r114 != r112) goto L96;
        r105 = (r103 + r105) - r100.getPrimaryHorizontal(r312);
        r103 = r100.getPrimaryHorizontal(r312);
    L96:
        float r115 = r103;
        if (r114 != r113) goto L99;
        r105 = r100.getPrimaryHorizontal(r101) - r115;
    L99:
        float r116 = r105;
        if (r310 == false) goto L104;
        float r106 = r104 + (r111 / 3.0f);
        r210.drawLine(r115, r106, r115 + r116, r106, r110);
    L104:
        if (r311 == false) goto L107;
        float r107 = r104 - ((r102 / 15.0f) * 4.0f);
        r210.drawLine(r115, r107, r115 + r116, r107, r110);
    L107:
        r114 = r114 + 1;
        goto L92
    L135:
        return;
    L10:
        if (r212 != 8) goto L12;
        float r108 = r314;
        Paint r117 = new Paint();
        r117.setColor(r213);
        float r118 = r108 / 3.0f;
        int r119 = r100.getLineForOffset(r312);
        int r120 = r100.getLineForOffset(r101);
        float r121 = r118 / 5.0f;
        r117.setStrokeWidth(r121);
        int r109 = r119;
    L77:
        if (r109 > r120) goto L134;
        float r122 = r100.getLineLeft(r109);
        float r123 = r100.getLineBaseline(r109);
        float r124 = r100.getLineMax(r109);
        if (r109 != r119) goto L81;
        r124 = (r122 + r124) - r100.getPrimaryHorizontal(r312);
        r122 = r100.getPrimaryHorizontal(r312);
    L81:
        float r125 = r122;
        if (r109 != r120) goto L84;
        r124 = r100.getPrimaryHorizontal(r101) - r125;
    L84:
        float r126 = r124;
        if (r310 == false) goto L87;
        float r214 = r123 + (r118 / 3.0f);
        float r215 = r125 + r126;
        float r216 = r123;
        r210.drawLine(r125, r214, r215, r214, r117);
        float r127 = r216 + (r121 * 3.0f);
        r210.drawLine(r125, r127, r215, r127, r117);
    L88:
        if (r311 == false) goto L90;
        float r217 = r216 - ((r108 / 15.0f) * 4.0f);
        float r128 = r125 + r126;
        r210.drawLine(r125, r217, r128, r217, r117);
        float r129 = r217 + ((r118 / 15.0f) * 4.0f);
        r210.drawLine(r125, r129, r128, r129, r117);
    L90:
        r109 = r109 + 1;
        goto L77
    L87:
        r216 = r123;
        goto L88
    L134:
        return;
    L12:
        if (r212 != 16) goto L14;
        float r130 = r314;
        Paint r131 = new Paint();
        r131.setColor(r213);
        float r132 = r130 / 3.0f;
        float r133 = r130 / 4.0f;
        int r134 = r100.getLineForOffset(r312);
        int r135 = r100.getLineForOffset(r101);
        r131.setStrokeWidth(r132 / 5.0f);
        int r136 = r134;
    L55:
        if (r136 > r135) goto L132;
        float r137 = r100.getLineLeft(r136);
        float r138 = r100.getLineBaseline(r136);
        float r139 = r100.getLineMax(r136);
        if (r136 != r134) goto L59;
        r139 = (r137 + r139) - r100.getPrimaryHorizontal(r312);
        r137 = r100.getPrimaryHorizontal(r312);
    L59:
        if (r136 != r135) goto L61;
        r139 = r100.getPrimaryHorizontal(r101) - r137;
    L61:
        int r218 = r134;
        int r140 = (int) Math.floor(r139 / r133);
        if (r140 == 0) goto L133;
        if (r310 == false) goto L69;
        int r141 = 0;
        float r142 = 0.0f;
    L67:
        if (r141 >= (r140 + 1)) goto L69;
        r210.drawPoint(r137 + r142, r138 + (r132 / 3.0f), r131);
        r142 = r142 + r133;
        r141 = r141 + 1;
        r132 = r132;
    L69:
        float r219 = r132;
        if (r311 == false) goto L75;
        float r143 = r138 - ((r130 / 15.0f) * 4.0f);
        int r144 = 0;
        float r145 = 0.0f;
    L73:
        if (r144 >= (r140 + 1)) goto L75;
        r210.drawPoint(r137 + r145, r143, r131);
        r145 = r145 + r133;
        r144 = r144 + 1;
    L75:
        r136 = r136 + 1;
        r134 = r218;
        r132 = r219;
        goto L55
    L133:
        return;
    L132:
        return;
    L14:
        if (r212 != 32) goto L16;
        float r146 = r314;
        int r147 = r211.getLineForOffset(r312);
        int r148 = r211.getLineForOffset(r313);
        Paint r149 = new Paint();
        r149.setColor(r213);
        float r150 = r146 / 3.0f;
        r149.setStrokeWidth(r150 / 5.0f);
        r149.setPathEffect(new DashPathEffect(new float[]{r146 / 7.0f, r146 / 20.0f}, 0.0f));
        int r151 = r147;
    L40:
        if (r151 > r148) goto L131;
        float r152 = r211.getLineLeft(r151);
        float r153 = r211.getLineBaseline(r151);
        float r154 = r211.getLineMax(r151);
        if (r151 != r147) goto L44;
        r154 = (r152 + r154) - r211.getPrimaryHorizontal(r312);
        r152 = r211.getPrimaryHorizontal(r312);
    L44:
        float r155 = r152;
        if (r151 != r148) goto L47;
        r154 = r211.getPrimaryHorizontal(r313) - r155;
    L47:
        float r156 = r154;
        if (r310 == false) goto L51;
        float r157 = r153 + (r150 / 3.0f);
        r210.drawLine(r155, r157, r155 + r156, r157, r149);
    L51:
        if (r311 == false) goto L53;
        float r158 = r153 - ((r146 / 15.0f) * 4.0f);
        r210.drawLine(r155, r158, r155 + r156, r158, r149);
    L53:
        r151 = r151 + 1;
        goto L40
    L131:
        return;
    L16:
        if (r212 != 64) goto L129;
        float r159 = r314;
        float r160 = 2.0f;
        float r161 = r159 / 2.0f;
        float r162 = r159 / 3.0f;
        int r163 = r100.getLineForOffset(r312);
        int r164 = r100.getLineForOffset(r101);
        Paint r165 = new Paint();
        r165.setStyle(Paint.Style.STROKE);
        r165.setColor(r213);
        r165.setStrokeWidth(r162 / 5.0f);
        int r166 = r163;
    L19:
        if (r166 > r164) goto L130;
        float r167 = r100.getLineLeft(r166);
        float r168 = r100.getLineBaseline(r166);
        float r169 = r100.getLineMax(r166);
        if (r166 != r163) goto L23;
        r169 = (r167 + r169) - r100.getPrimaryHorizontal(r312);
        r167 = r100.getPrimaryHorizontal(r312);
    L23:
        if (r166 != r164) goto L25;
        r169 = r100.getPrimaryHorizontal(r101) - r167;
    L25:
        int r170 = Math.round(r169 / r161);
        if (r310 == false) goto L31;
        Path r171 = new Path();
        float r172 = r168 + (r162 / r160);
        r171.moveTo(r167, r172);
        int r173 = 0;
        float r220 = 0.0f;
    L28:
        if (r173 >= r170) goto L30;
        float r221 = r161 / 4.0f;
        r171.quadTo((r167 + r221) + r220, r168, (r167 + (r161 / 2.0f)) + r220, r172);
        r171.quadTo((r167 + (r221 * 3.0f)) + r220, r168 + r162, (r167 + r161) + r220, r172);
        r220 = r220 + r161;
        r173 = r173 + 1;
        r163 = r163;
        goto L28
    L30:
        int r222 = r163;
        r210.drawPath(r171, r165);
    L32:
        if (r311 == false) goto L37;
        Path r174 = new Path();
        float r175 = 4.0f;
        float r176 = r168 - ((r159 / 15.0f) * 4.0f);
        r174.moveTo(r167, r176);
        int r177 = 0;
        float r178 = 0.0f;
    L34:
        if (r177 >= r170) goto L36;
        float r179 = r161 / r175;
        float r223 = r162 / 2.0f;
        r174.quadTo((r167 + r179) + r178, r176 - r223, (r167 + (r161 / 2.0f)) + r178, r176);
        r174.quadTo(((r179 * 3.0f) + r167) + r178, r223 + r176, (r167 + r161) + r178, r176);
        r178 = r178 + r161;
        r177 = r177 + 1;
        r159 = r159;
        r175 = 4.0f;
        goto L34
    L36:
        float r224 = r159;
        r210.drawPath(r174, r165);
    L38:
        r166 = r166 + 1;
        r100 = r211;
        r101 = r313;
        r164 = r164;
        r159 = r224;
        r163 = r222;
        r160 = 2.0f;
        goto L19
    L37:
        r224 = r159;
        goto L38
    L31:
        r222 = r163;
        goto L32
    L130:
        return;
    L129:
        return;
    }
}
