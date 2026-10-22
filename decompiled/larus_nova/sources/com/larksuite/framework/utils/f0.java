package com.larksuite.framework.utils;

import android.text.TextUtils;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes24.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BitSet f285960a = null;

    public class a extends ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        public final StringBuilder initialValue() {
            return new StringBuilder(8192);
        }

        public a() {
        }
    }

    static {
        new String[]{"", " ", tb2.c.DEFAULT_TEXT, "   ", LineContent.FOUR_SPACE, "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};
        new a();
        f285960a = new BitSet(256);
        int r100 = 97;
    L4:
        if (r100 > 122) goto L6;
        f285960a.set(r100);
        r100 = r100 + 1;
        goto L4
    L6:
        int r101 = 65;
    L8:
        if (r101 > 90) goto L10;
        f285960a.set(r101);
        r101 = r101 + 1;
        goto L8
    L10:
        int r102 = 48;
    L12:
        if (r102 > 57) goto L14;
        f285960a.set(r102);
        r102 = r102 + 1;
        goto L12
    L14:
        BitSet r103 = f285960a;
        r103.set(43);
        r103.set(45);
        r103.set(95);
        r103.set(46);
        r103.set(42);
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
    L25:
        return true;
    L5:
        if (r100.length() == 0) goto L25;
        int r101 = r100.length();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L25;
        int r103 = r100.codePointAt(r102);
        if (r103 != 32) goto L12;
    L21:
        boolean r104 = true;
    L22:
        if (r104 == false) goto L23;
        r102 = r102 + 1;
        goto L8
    L23:
        return false;
    L12:
        if (r103 == 9) goto L21;
        if (r103 == 10) goto L21;
        if (r103 == 12) goto L21;
        if (r103 == 13) goto L21;
        r104 = false;
        goto L22
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r100.length()) goto L19;
        char r102 = r100.charAt(r101);
        if (r102 < 'a') goto L13;
        if (r102 > 'z') goto L13;
    L17:
        r101 = r101 + 1;
    L13:
        if (r102 < 'A') goto L18;
        if (r102 <= 'Z') goto L17;
    L18:
        return false;
    L19:
        return true;
    }

    public static String d(Collection r100) {
        Iterator r101 = r100.iterator();
        if (r101.hasNext() == true) goto L5;
        return "";
    L5:
        String r102 = r101.next().toString();
        if (r101.hasNext() == false) goto L16;
        StringBuilder r103 = new StringBuilder(64);
        r103.append(r102);
    L10:
        if (r101.hasNext() == false) goto L13;
        r103.append(",");
        r103.append(r101.next());
        goto L10
    L13:
        return r103.toString();
    L16:
        return r102;
    }

    public static boolean c(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return TextUtils.isEmpty(r101);
    L7:
        return r100.equals(r101);
    }
}
