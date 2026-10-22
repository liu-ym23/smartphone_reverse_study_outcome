package com.lynx.tasm.utils;

import android.util.Pair;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class c {
    public c() {
    }

    public static boolean a(String r100) {
        if (r100.endsWith(".woff") == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.endsWith(".woff2") == true) goto L8;
        return false;
    }

    public static String d(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r100.length()) goto L16;
        if (r100.charAt(r101) == ' ') goto L14;
        if (r100.charAt(r101) == '\"') goto L14;
        if (r100.charAt(r101) != '\'') goto L16;
    L14:
        r101 = r101 + 1;
    L16:
        if (r101 < r100.length()) goto L18;
        return null;
    L18:
        int r102 = r100.length() - 1;
    L19:
        if (r102 <= r101) goto L28;
        if (r100.charAt(r102) == ' ') goto L26;
        if (r100.charAt(r102) == '\"') goto L26;
        if (r100.charAt(r102) != '\'') goto L28;
    L26:
        r102 = r102 - 1;
    L28:
        return r100.substring(r101, r102 + 1);
    }

    public static String e(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length();
        if (r100.startsWith("'") == false) goto L8;
    L11:
        int r102 = 1;
    L13:
        if (r100.endsWith("'") == false) goto L15;
    L16:
        r101 = r101 - 1;
    L17:
        if (r102 <= r101) goto L20;
        return null;
    L20:
        return r100.substring(r102, r101);
    L15:
        if (r100.endsWith("\"") == false) goto L17;
    L8:
        if (r100.startsWith("\"") == true) goto L11;
        r102 = 0;
        goto L13
    }

    public static FontFace b(LynxContext r110, String r111) {
        if (r111 != null) goto L6;
        c(r110, "Font-family is empty", "");
        return null;
    L6:
        Map r112 = r110.getFontFaces(r111);
        if (r112 != null) goto L9;
        return null;
    L9:
        FontFace r100 = new FontFace();
        Iterator r113 = r112.values().iterator();
        boolean r101 = false;
    L11:
        if (r113.hasNext() == false) goto L71;
        Object r102 = r113.next();
        if ((r102 instanceof String) == false) goto L14;
        String r103 = (String) r102;
        int r104 = r103.length();
        int r105 = 0;
    L16:
        boolean r106 = true;
        if (r105 >= r104) goto L65;
        int r107 = r103.indexOf("url(", r105);
        int r108 = r103.indexOf("local(", r105);
        if (r107 != (-1)) goto L23;
        if (r108 == (-1)) goto L65;
    L23:
        if (r107 == (-1)) goto L44;
        if (r108 == (-1)) goto L44;
        if (r107 >= r108) goto L35;
        int r109 = r103.indexOf(")", r107);
        if (r109 == (-1)) goto L64;
        int r114 = r109 + 2;
        String r115 = e(r103.substring(r107 + 4, r109));
        if (r115 == null) goto L64;
        if (a(r115) == false) goto L34;
    L61:
        r105 = r114;
        r101 = true;
        goto L16
    L34:
        List<Pair<FontFace.TYPE, String>> r116 = r100.f383377a;
        ArrayList r117 = (ArrayList) r116;
        r117.add(new Pair(FontFace.TYPE.URL, r115));
    L63:
        r105 = r114;
    L64:
        r106 = false;
        goto L65
    L35:
        int r118 = r103.indexOf(")", r108);
        if (r118 == (-1)) goto L64;
        r114 = r118 + 2;
        String r119 = e(r103.substring(r108 + 6, r118));
        if (r119 == null) goto L64;
        if (a(r119) == true) goto L61;
        List<Pair<FontFace.TYPE, String>> r120 = r100.f383377a;
        ArrayList r121 = (ArrayList) r120;
        r121.add(new Pair(FontFace.TYPE.LOCAL, r119));
    L44:
        if (r107 == (-1)) goto L54;
        int r122 = r103.indexOf(")", r107);
        if (r122 == (-1)) goto L64;
        r114 = r122 + 2;
        String r123 = e(r103.substring(r107 + 4, r122));
        if (r123 == null) goto L64;
        if (a(r123) == true) goto L61;
        List<Pair<FontFace.TYPE, String>> r124 = r100.f383377a;
        ArrayList r125 = (ArrayList) r124;
        r125.add(new Pair(FontFace.TYPE.URL, r123));
        goto L63
    L54:
        int r126 = r103.indexOf(")", r108);
        if (r126 == (-1)) goto L64;
        r114 = r126 + 2;
        String r127 = e(r103.substring(r108 + 6, r126));
        if (r127 == null) goto L64;
        if (a(r127) == true) goto L61;
        List<Pair<FontFace.TYPE, String>> r128 = r100.f383377a;
        ArrayList r129 = (ArrayList) r128;
        r129.add(new Pair(FontFace.TYPE.LOCAL, r127));
    L65:
        if (r106 == true) goto L67;
        c(r110, "Src format error", r103);
    L67:
        if (r101 == false) goto L11;
        if (((ArrayList) r100.f383377a).isEmpty() == false) goto L11;
        r110.reportResourceError(r103, LynxResourceModule.FONT_TYPE, new LynxError(30204, "The woff file format is not supported on Android"));
        LLog.e("FontFaceParser", "The woff file format is not supported on Android,src:".concat(r103));
        goto L11
    L14:
        c(r110, "Src is not string", r102.toString());
        goto L11
    L71:
        return r100;
    }

    public static void c(LynxContext r100, String r101, String r102) {
        r100.reportResourceError(r102, LynxResourceModule.FONT_TYPE, new LynxError(30201, r101));
        LLog.e("FontFaceParser", r101 + ",src:" + r102);
    }
}
