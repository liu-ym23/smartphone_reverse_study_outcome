package com.bytedance.router;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.mapping.SmartRouter$$Mapping;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SmartRouter {
    private static r97.b errorListener;
    private static a sRouterIntentAdapter;
    private static p97.b serializationService;

    public SmartRouter() {
    }

    public static a getRouterIntentAdapter() {
        return null;
    }

    public static p97.b getSerializationService() {
        return null;
    }

    public static void setRouterIntentAdapter(a r100) {
    }

    public static void setSerializationService(p97.b r100) {
    }

    public static r97.b getErrorListener() {
        return errorListener;
    }

    public static boolean isDebug() {
        return u97.a.f549215a;
    }

    public static void addInterceptor(q97.a r100) {
        d.a.f267543a.f267540c.a(r100);
    }

    public static void addRewriteMap(Map<String, String> r100) {
        q97.b r101 = d.a.f267543a.f267541d;
        Object r102 = r101.f532135b;
        monitor-enter(r102);
        if (r100 != null) goto L6;
        r101.f532134a = Collections.EMPTY_MAP;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L6:
        r101.f532134a = r100;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static void autowire(Object r100) {
        p97.a r101 = p97.a.C7169a.f528308a;
        r101.getClass();
        String r102 = r100.getClass().getName();
    L10:
        ((ArrayList) r101.f528307b).add(r102);
        return;
    L4:
        if (((ArrayList) r101.f528307b).contains(r102) == true) goto L14;
        p97.c r103 = r101.f528306a.get(r102);     // Catch: Exception -> L10
        if (r103 != null) goto L8;
        r103 = (p97.c) p97.a.a(r100.getClass().getName().concat("$$SmartRouter$$Autowired")).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L10
    L8:
        r103.a();     // Catch: Exception -> L10
        r101.f528306a.put(r102, r103);     // Catch: Exception -> L10
        return;
    }

    public static boolean canOpen(String r100) {
        d r101 = d.a.f267543a;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (u97.b.c(r100) == false) goto L54;
        String r102 = u97.b.a(r100);
        Map<String, String> r103 = r101.f267541d.f532134a;
        if (r103 != null) goto L11;
        String r104 = null;
    L13:
        if (TextUtils.isEmpty(r104) == true) goto L15;
        r102 = r104;
    L15:
        String r105 = UriProtector.parse(r102).getScheme();
        if (TextUtils.isEmpty(r105) == false) goto L19;
        r105 = UriProtector.parse(r100).getScheme();
    L19:
        if (r101.f267539b.a(r105) == true) goto L22;
        return false;
    L22:
        if (r101.f267539b.a(r105) == false) goto L56;
        String r106 = r101.f267538a.a(r102);
        if (TextUtils.isEmpty(r106) == false) goto L29;
        monitor-enter(r101);
        monitor-exit(r101);
    L29:
        if (TextUtils.isEmpty(r106) == false) goto L49;
        b r107 = r101.f267540c;
        r107.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L47;
        List<q97.a> r108 = r107.f267526a;
        if (r108 == null) goto L47;
        if (((LinkedList) r108).size() == 0) goto L47;
        Intent r109 = new Intent();
        c r110 = new c();
        getRouterIntentAdapter();
        c.c(r109, r100, false);
        r110.f267527a = r100;
        if (r110.f267529c.equals(r100) == true) goto L41;
        r110.f267529c = r110.f267527a;
    L41:
        r110.f267528b = r109;
        r110.f267534h = -1;
        r110.f267535i = -1;
        r110.f267537k = null;
        r110.a();
        Iterator<q97.a> r111 = r107.f267526a.iterator();
    L43:
        if (r111.hasNext() == false) goto L47;
        if (r111.next().b(r110) == false) goto L43;
        boolean r112 = true;
    L48:
        if (r112 == true) goto L49;
        return false;
    L47:
        r112 = false;
    L49:
        return true;
    L56:
        return false;
    L11:
        r104 = r103.get(r102);
        goto L13
    L54:
        return false;
    }

    public static g configRouter(String r100) {
        g r101 = new g(r100);
        d.a.f267543a.f267539b = r101;
        return r101;
    }

    public static void init(Context r100) {
        d r101 = d.a.f267543a;
        r101.f267542e = r100.getApplicationContext();
        e r102 = r101.f267538a;
        Object r103 = r102.f267545b;
        monitor-enter(r103);
        new SmartRouter$$Mapping().init(r102.f267544a);     // Catch: Throwable -> L8
        monitor-exit(r103);     // Catch: Throwable -> L8
        String.format("RouteMapper#loadMappingByRouter routes: %d .", new Object[]{Integer.valueOf(((HashMap) r102.f267544a).size())});
        r101.f267540c.a(r101.f267541d);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean isSmartIntent(Intent r100) {
        int r101 = SmartIntent.f267525a;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100 instanceof SmartIntent;
    }

    public static void setDebug(boolean r100) {
        u97.a.f549215a = r100;
    }

    public static void setOnErrorListener(r97.b r100) {
        errorListener = r100;
    }

    public static void setSupportPluginCallback(s97.a r100) {
        d.a.f267543a.getClass();
    }

    public static h smartBundle(Bundle r100) {
        return new h(r100);
    }

    public static Intent smartIntent(Intent r100) {
        int r101 = SmartIntent.f267525a;
        if (r100 != null) goto L6;
        return r100;
    L6:
        if ((r100 instanceof SmartIntent) == false) goto L9;
        return r100;
    L9:
        return new SmartIntent(r100);
    }

    public static i buildRoute(Fragment r100, String r101) {
        i r102 = new i(r100.getActivity());
        r102.f267553b = r101;
        return r102;
    }

    public static void open(Context r100, c r101) {
        d.a.f267543a.b(r100, r101);
    }

    public static void putRewriteValue(String r100, String r101) {
        q97.b r102 = d.a.f267543a.f267541d;
        Object r103 = r102.f532135b;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r102.f532134a != null) goto L7;
        r102.f532134a = new HashMap();     // Catch: Throwable -> L10
    L7:
        r102.f532134a.put(r100, r101);     // Catch: Throwable -> L10
        monitor-exit(r103);     // Catch: Throwable -> L10
    }

    public static i buildRoute(Context r100, String r101) {
        i r102 = new i(r100);
        r102.f267553b = r101;
        return r102;
    }
}
