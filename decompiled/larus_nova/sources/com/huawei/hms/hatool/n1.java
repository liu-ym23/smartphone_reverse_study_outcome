package com.huawei.hms.hatool;

import android.util.Pair;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public abstract class n1 {
    public static long a(String r100, long r101) {
        SimpleDateFormat r102 = new SimpleDateFormat(r100, Locale.getDefault());     // Catch: ParseException -> L4
        return r102.parse(r102.format(Long.valueOf(r101))).getTime();
    L4:
        v.f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
        return 0;
    }

    public static Pair<String, String> a(String r100) {
        if ("_default_config_tag".equals(r100) == true) goto L11;
        String[] r101 = r100.split("-");
        if (r101.length <= 2) goto L7;
        String r102 = r101[r101.length - 1];
        int r103 = r102.length();
        String r104 = r100.substring(0, (r100.length() - r103) - 1);
    L9:
        return new Pair(r104, r102);
    L7:
        r104 = r101[0];
        r102 = r101[1];
        goto L9
    L11:
        return new Pair(r100, "");
    }

    public static String a(int r100) {
        if (r100 != 0) goto L4;
        return "oper";
    L4:
        if (r100 != 1) goto L6;
        return "maint";
    L6:
        if (r100 != 2) goto L8;
        return "preins";
    L8:
        if (r100 == 3) goto L11;
        return "alltype";
    L11:
        return "diffprivacy";
    }

    public static String a(String r100, String r101) {
        if ("_default_config_tag".equals(r100) == false) goto L6;
        return r100;
    L6:
        return r100 + "-" + r101;
    }

    public static String a(String r100, String r101, String r102) {
        if ("_default_config_tag".equals(r100) == false) goto L6;
        return "_default_config_tag#" + r102;
    L6:
        return r100 + "-" + r101 + "#" + r102;
    }

    public static Set<String> a(Set<String> r100) {
        if (r100 == null) goto L15;
        if (r100.size() == 0) goto L15;
        HashSet r101 = new HashSet();
        Iterator<String> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        if ("_default_config_tag".equals(r103) == false) goto L11;
        r101.add("_default_config_tag");
        goto L8
    L11:
        String r104 = r103 + "-oper";
        String r105 = r103 + "-maint";
        r101.add(r104);
        r101.add(r105);
        r101.add(r103 + "-diffprivacy");
        goto L8
    L13:
        return r101;
    L15:
        return new HashSet();
    }
}
