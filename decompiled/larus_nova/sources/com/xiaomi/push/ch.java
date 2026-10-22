package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ch {

    public static class a extends cg {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.cg
        public String a(Context r100, String r101, List<as> r102) {
            if (r102 == null) goto L4;
            Uri.Builder r103 = UriProtector.parse(r101).buildUpon();
            Iterator<as> r104 = r102.iterator();
        L7:
            if (r104.hasNext() == false) goto L10;
            as r105 = r104.next();
            r103.appendQueryParameter(r105.a(), r105.b());
            goto L7
        L10:
            return at.a(r100, new URL(r103.toString()));
        L4:
            return at.a(r100, new URL(r101));
        }
    }

    public static int a(List<as> r100) {
        Iterator<as> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        as r103 = r101.next();
        if (TextUtils.isEmpty(r103.a()) == true) goto L9;
        r102 = r102 + r103.a().length();
    L9:
        if (TextUtils.isEmpty(r103.b()) == true) goto L4;
        r102 = r102 + r103.b().length();
        goto L4
    L12:
        return r102 * 2;
    }

    public static int a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return 0;
    L8:
        return r100.getBytes("UTF-8").length;
    L7:
        return 0;
    }

    public static int a(int r100, int r101) {
        return (((((r101 + 243) / 1448) * 132) + 1080) + r100) + r101;
    }

    public static int a(int r100, int r101, int r102) {
        return ((((((r101 + 200) / 1448) * 132) + 1011) + r101) + r100) + r102;
    }

    public static String a(Context r100, String r101, List<as> r102) {
        return a(r100, r101, r102, new a(), true);
    }

    private static int a(cg r100, String r101, List<as> r102, String r103) {
        if (r100.a() != 1) goto L7;
        return a(r101.length(), a(r103));
    L7:
        if (r100.a() != 2) goto L10;
        int r104 = a(r102);
        return a(r101.length(), r104, a(r103));
    L10:
        return -1;
    }

    public static String a(Context r210, String r211, List<as> r212, cg r213, boolean r214) {
        if (at.m8819a(r210) == true) goto L64;
    L55:
        return null;
    L64:
        ArrayList<String> r100 = new ArrayList();     // Catch: MalformedURLException -> L53
        if (r214 == false) goto L10;
        cb r101 = cf.a().m8897a(r211);     // Catch: MalformedURLException -> L53
        if (r101 == null) goto L9;
        r100 = r101.a(r211);     // Catch: MalformedURLException -> L53
    L9:
        cb r110 = r101;
    L12:
        if (r100.contains(r211) == true) goto L14;
        r100.add(r211);     // Catch: MalformedURLException -> L53
    L14:
        Iterator<String> r102 = r100.iterator();     // Catch: MalformedURLException -> L53
        String r103 = null;
    L15:
        if (r102.hasNext() == false) goto L77;
        String r111 = r102.next();     // Catch: MalformedURLException -> L53
        if (r212 == null) goto L20;
        ArrayList r112 = new ArrayList(r212);     // Catch: MalformedURLException -> L53
    L21:
        long r113 = System.currentTimeMillis();     // Catch: MalformedURLException -> L53
    L46:
        e = move-exception;
        IOException r114 = e;
        String r104 = r103;
    L48:
        if (r110 == null) goto L50;
        r110.a(r111, System.currentTimeMillis() - r113, a(r213, r111, r112, r104), r114);     // Catch: MalformedURLException -> L53
    L50:
        r114.printStackTrace();     // Catch: MalformedURLException -> L53
        r103 = r104;
        goto L15
    L23:
        if (r213.m8907a(r210, r111, r112) == false) goto L52;
        String r115 = r213.a(r210, r111, r112);     // Catch: IOException -> L46
    L43:
        e = e;
        String r116 = r115;
    L45:
        String r117 = r116;
        r114 = e;
        r104 = r117;
        goto L48
    L27:
        if (TextUtils.isEmpty(r115) == false) goto L28;
        if (r110 == null) goto L41;
        r116 = r115;
        r110.a(r111, System.currentTimeMillis() - r113, a(r213, r111, r112, r115), null);     // Catch: IOException -> L39
    L42:
        r103 = r116;
    L39:
        e = e;
        goto L45
    L41:
        r116 = r115;
        goto L42
    L28:
        if (r110 == null) goto L76;
        r110.a(r111, System.currentTimeMillis() - r113, a(r213, r111, r112, r115));     // Catch: IOException -> L31
    L31:
        e = move-exception;
        r114 = e;
        r104 = r115;
    L76:
        return r115;
    L52:
        return r103;
    L20:
        r112 = null;
        goto L21
    L77:
        return r103;
    L10:
        r110 = null;
    L53:
        e = move-exception;
        e.printStackTrace();
        goto L55
    }
}
