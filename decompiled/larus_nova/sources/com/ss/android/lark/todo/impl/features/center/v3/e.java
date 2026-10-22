package com.ss.android.lark.todo.impl.features.center.v3;

import android.text.TextUtils;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<Character> f441576a = null;

    static {
        ArrayList<Character> r100 = new ArrayList();
        Character[] r101 = new Character[10];
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= 10) goto L5;
        r101[r103] = Character.valueOf((char) (r103 + 48));
        r103 = r103 + 1;
        goto L3
    L5:
        CollectionsKt.addAll(r100, r101);
        Character[] r104 = new Character[26];
    L6:
        if (r102 >= 26) goto L8;
        r104[r102] = Character.valueOf((char) (r102 + 97));
        r102 = r102 + 1;
        goto L6
    L8:
        CollectionsKt.addAll(r100, r104);
        f441576a = r100;
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rank");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "000000";
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(StringsKt.toMutableList(StringsKt.reversed(r100).toString()));
        if (r101.size() != 0) goto L8;
        return "000000";
    L8:
        int r102 = r101.size();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L16;
        char r104 = ((Character) ListProtector.get(r101, r103)).charValue();
        ArrayList<Character> r105 = f441576a;
        char r106 = ((Character) ListProtector.get(r105, (r105.indexOf(Character.valueOf(r104)) + 8) % r105.size())).charValue();
        if (Intrinsics.compare(r106, ((Character) ListProtector.get(r101, r103)).charValue()) > 0) goto L13;
        ListProtector.set(r101, r103, Character.valueOf(r106));
        r103 = r103 + 1;
        goto L10
    L13:
        ListProtector.set(r101, r103, Character.valueOf(r106));
        CollectionsKt.reverse(r101);
        String r107 = new String(CollectionsKt.toCharArray(r101));
        Log.i("RankUtil", "compute next rank(" + r100 + ") = " + r107);
        return r107;
    L16:
        Log.i("RankUtil", "compute next rank(" + r100 + ") = " + r100 + 'k');
        return r100 + 'k';
    }

    public static String c(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        ConcurrentHashMap r101 = (ConcurrentHashMap) r100;
        if (r101.values().isEmpty() == false) goto L7;
        return "000000";
    L7:
        return b((String) Collections.max(r101.values()));
    }

    public static String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rank");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "000000";
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(StringsKt.toMutableList(StringsKt.reversed(r100).toString()));
        if (r101.size() != 0) goto L8;
        return "000000";
    L8:
        int r102 = r101.size();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L19;
        int r104 = f441576a.indexOf(Character.valueOf(((Character) ListProtector.get(r101, r103)).charValue())) - 8;
    L12:
        if (r104 >= 0) goto L14;
        r104 = r104 + f441576a.size();
        goto L12
    L14:
        ArrayList<Character> r105 = f441576a;
        char r106 = ((Character) ListProtector.get(r105, r104 % r105.size())).charValue();
        if (Intrinsics.compare(r106, ((Character) ListProtector.get(r101, r103)).charValue()) < 0) goto L16;
        ListProtector.set(r101, r103, Character.valueOf(r106));
        r103 = r103 + 1;
        goto L10
    L16:
        ListProtector.set(r101, r103, Character.valueOf(r106));
        CollectionsKt.reverse(r101);
        String r107 = new String(CollectionsKt.toCharArray(r101));
        Log.i("RankUtil", "compute prev rank(" + r100 + ") = " + r107);
        return r107;
    L19:
        Log.i("RankUtil", "compute prev rank(" + r100 + ") = 0" + r100);
        return "0" + r100;
    }

    public static String e(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        ConcurrentHashMap r101 = (ConcurrentHashMap) r100;
        if (r101.values().isEmpty() == false) goto L7;
        return "000000";
    L7:
        return d((String) Collections.min(r101.values()));
    }

    public static String a(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "rank1");
        Intrinsics.checkNotNullParameter(r110, "rank2");
        if (TextUtils.equals(r100, r110) == false) goto L7;
        return b(r100);
    L7:
        if (r100.compareTo(r110) <= 0) goto L11;
        return a(r110, r100);
    L11:
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return d(r110);
    L15:
        if (TextUtils.isEmpty(r110) == true) goto L17;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L20:
        if (r102 < r100.length()) goto L30;
        if (r102 < r110.length()) goto L30;
        String r103 = new String(CollectionsKt.toCharArray(r101));
        if (Intrinsics.areEqual(r103, r100) == true) goto L60;
        Log.i("RankUtil", "compute middle rank(" + r100 + ") and rank(" + r110 + ") = " + r103);
        return r103;
    L60:
        return a(r100, r110.concat(ce.f26396k));
    L30:
        if (r102 >= 0) goto L32;
    L34:
        boolean r104 = false;
    L35:
        if (r104 == false) goto L37;
        char r105 = r100.charAt(r102);
    L38:
        if (r102 >= 0) goto L40;
    L42:
        boolean r106 = false;
    L43:
        if (r106 == false) goto L45;
        char r107 = r110.charAt(r102);
    L46:
        ArrayList<Character> r108 = f441576a;
        int r109 = r108.indexOf(Character.valueOf(r105));
        int r111 = r108.indexOf(Character.valueOf(r107));
        if (r109 == (-1)) goto L51;
        if (r111 == (-1)) goto L51;
        Object r112 = ListProtector.get(r108, (r109 + r111) / 2);
        Intrinsics.checkNotNull(r112);
        char r113 = ((Character) r112).charValue();
    L53:
        if (Intrinsics.compare(r105, r107) > 0) goto L55;
        r101.add(Character.valueOf(r113));
    L56:
        r102 = r102 + 1;
        goto L20
    L55:
        r101.add(Character.valueOf(r105));
    L51:
        r113 = (char) ((r105 + r107) / 2);
        goto L53
    L45:
        ArrayList<Character> r114 = f441576a;
        r107 = ((Character) ListProtector.get(r114, r114.size() - 1)).charValue();
        goto L46
    L40:
        if (r102 >= r110.length()) goto L42;
        r106 = true;
        goto L43
    L37:
        r105 = ((Character) ListProtector.get(f441576a, 0)).charValue();
        goto L38
    L32:
        if (r102 >= r100.length()) goto L34;
        r104 = true;
        goto L35
    L17:
        return b(r100);
    }
}
