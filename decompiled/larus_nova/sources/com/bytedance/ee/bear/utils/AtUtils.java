package com.bytedance.ee.bear.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class AtUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f239806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<String> f239807b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<String> f239808c = null;

    public static boolean a(int r100, int r101, int r102) {
        if (r102 >= r101) goto L5;
        return false;
    L5:
        if (r101 > r100) goto L13;
        if (r102 > r100) goto L13;
        if (r101 < 0) goto L13;
        if (r102 < 0) goto L13;
        return true;
    L13:
        return false;
    }

    static {
        f239806a = new AnonymousClass1();
        ArrayList<String> r100 = new ArrayList();
        f239807b = r100;
        r100.add(String.valueOf(a.f239813b[0]));
        f239808c = new ArrayList();
    }

    public static ArrayList<String> c() {
        ArrayList<String> r100 = new ArrayList();
        r100.addAll(f239806a);
        r100.addAll(f239808c);
        return r100;
    }

    public static String b(List<String> r100) {
        if (r100 != null) goto L5;
    L14:
        tt5.a.h("AtUtils", "convertSearchTypeStrFromList: types is null ");
        return "";
    L5:
        if (r100.isEmpty() == true) goto L14;
        StringBuilder r101 = new StringBuilder();
        r101.append((String) ListProtector.get(r100, 0));
        int r102 = 1;
        if (r100.size() > 1) goto L10;
    L12:
        tt5.a.h("AtUtils", "convertSearchTypeStrFromList end: " + r101.toString());
        return r101.toString();
    L10:
        if (r102 >= r100.size()) goto L12;
        r101.append(',');
        r101.append((String) ListProtector.get(r100, r102));
        r102 = r102 + 1;
        goto L10
    }

    public static sbb.e d(int r100) {
        HashMap<Integer, sbb.e> r101 = a.f239819h;
        if (r101.containsKey(Integer.valueOf(r100)) == true) goto L5;
        tt5.a.d("AtUtils", "getDocumentType null");
        return sbb.e.f541296g;
    L5:
        return r101.get(Integer.valueOf(r100));
    }

    public static int e(int r100) {
        sbb.e r101 = sbb.e.d(r100);
        if (r101 != sbb.e.f541294e) goto L9;
        boolean r102 = false;
        if (a.f239813b[0] != r100) goto L7;
        r102 = true;
    L7:
        if (r102 == false) goto L9;
        return r100;
    L9:
        HashMap<sbb.e, Integer> r103 = a.f239818g;
        if (r103.containsKey(r101) == true) goto L12;
        tt5.a.d("AtUtils", "getMentionType null");
        return 1;
    L12:
        return r103.get(r101).intValue();
    }

    public static int f(sbb.e r100) {
        HashMap<sbb.e, Integer> r101 = a.f239818g;
        if (r101.containsKey(r100) == true) goto L5;
        tt5.a.d("AtUtils", "getMentionType null");
        return 1;
    L5:
        return r101.get(r100).intValue();
    }

    public static int h(sbb.e r100) {
        HashMap<sbb.e, Integer> r101 = a.f239820i;
        if (r101.containsKey(r100) == true) goto L5;
        return 1;
    L5:
        return r101.get(r100).intValue();
    }

    public static boolean i(int r100) {
        if (c().contains(r100 + "") == false) goto L5;
        return true;
    L5:
        if (f239807b.contains(r100 + "") == false) goto L7;
        return true;
    L7:
        if (r100 != 9) goto L9;
        return true;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("apaas.miaoda.migrate_to_ccm") == true) goto L11;
    L13:
        boolean r101 = false;
    L14:
        if (r101 == true) goto L21;
        return false;
    L21:
        return true;
    L11:
        if (sbb.g.b(r100) == false) goto L13;
        r101 = true;
        goto L14
    }

    public static int g(int r100, int r101) {
        if (r100 != 16) goto L8;
        int r102 = a.f239816e.get(r101, -1);
        if (r102 == (-1)) goto L8;
        return kac.a.b(r102);
    L8:
        int r103 = a.f239816e.get(r100, -1);
        if (r103 != (-1)) goto L11;
        tt5.a.h("AtUtils", "getResId(): default, type = " + r100 + ", subType = " + r101);
        return kac.a.b(a.f239822k);
    L11:
        return kac.a.b(r103);
    }
}
