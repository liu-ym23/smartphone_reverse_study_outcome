package com.bytedance.ee.bear.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AtUtils {
    public static final ArrayList<String> a = null;
    public static final ArrayList<String> b = null;
    public static final ArrayList<String> c = null;

    public static boolean a(int r1, int r2, int r3) {
        if (r3 >= r2) goto L5;
        return false;
    L5:
        if (r2 > r1) goto L13;
        if (r3 > r1) goto L13;
        if (r2 < 0) goto L13;
        if (r3 < 0) goto L13;
        return true;
    L13:
        return false;
    }

    static {
        a = new AnonymousClass1();
        ArrayList<String> r0 = new ArrayList();
        b = r0;
        r0.add(String.valueOf(a.b[0]));
        c = new ArrayList();
    }

    public static ArrayList<String> c() {
        ArrayList<String> r0 = new ArrayList();
        r0.addAll(a);
        r0.addAll(c);
        return r0;
    }

    public static String b(List<String> r4) {
        if (r4 != null) goto L5;
    L14:
        tt5.a.h("AtUtils", "convertSearchTypeStrFromList: types is null ");
        return "";
    L5:
        if (r4.isEmpty() == true) goto L14;
        StringBuilder r1 = new StringBuilder();
        r1.append((String) ListProtector.get(r4, 0));
        int r3 = 1;
        if (r4.size() > 1) goto L10;
    L12:
        tt5.a.h("AtUtils", "convertSearchTypeStrFromList end: " + r1.toString());
        return r1.toString();
    L10:
        if (r3 >= r4.size()) goto L12;
        r1.append(',');
        r1.append((String) ListProtector.get(r4, r3));
        r3 = r3 + 1;
        goto L10
    }

    public static sbb.e d(int r2) {
        HashMap<Integer, sbb.e> r0 = a.h;
        if (r0.containsKey(Integer.valueOf(r2)) == true) goto L5;
        tt5.a.d("AtUtils", "getDocumentType null");
        return sbb.e.g;
    L5:
        return r0.get(Integer.valueOf(r2));
    }

    public static int e(int r4) {
        sbb.e r0 = sbb.e.d(r4);
        if (r0 != sbb.e.e) goto L9;
        boolean r3 = false;
        if (a.b[0] != r4) goto L7;
        r3 = true;
    L7:
        if (r3 == false) goto L9;
        return r4;
    L9:
        HashMap<sbb.e, Integer> r5 = a.g;
        if (r5.containsKey(r0) == true) goto L12;
        tt5.a.d("AtUtils", "getMentionType null");
        return 1;
    L12:
        return r5.get(r0).intValue();
    }

    public static int f(sbb.e r2) {
        HashMap<sbb.e, Integer> r0 = a.g;
        if (r0.containsKey(r2) == true) goto L5;
        tt5.a.d("AtUtils", "getMentionType null");
        return 1;
    L5:
        return r0.get(r2).intValue();
    }

    public static int h(sbb.e r2) {
        HashMap<sbb.e, Integer> r0 = a.i;
        if (r0.containsKey(r2) == true) goto L5;
        return 1;
    L5:
        return r0.get(r2).intValue();
    }

    public static boolean i(int r4) {
        if (c().contains(r4 + "") == false) goto L5;
        return true;
    L5:
        if (b.contains(r4 + "") == false) goto L7;
        return true;
    L7:
        if (r4 != 9) goto L9;
        return true;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("apaas.miaoda.migrate_to_ccm") == true) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == true) goto L21;
        return false;
    L21:
        return true;
    L11:
        if (sbb.g.b(r4) == false) goto L13;
        r5 = true;
        goto L14
    }

    public static int g(int r2, int r3) {
        if (r2 != 16) goto L8;
        int r0 = a.e.get(r3, -1);
        if (r0 == (-1)) goto L8;
        return kac.a.b(r0);
    L8:
        int r1 = a.e.get(r2, -1);
        if (r1 != (-1)) goto L11;
        tt5.a.h("AtUtils", "getResId(): default, type = " + r2 + ", subType = " + r3);
        return kac.a.b(a.k);
    L11:
        return kac.a.b(r1);
    }
}
