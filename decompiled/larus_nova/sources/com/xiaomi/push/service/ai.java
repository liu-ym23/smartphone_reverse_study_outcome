package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class ai {

    /* JADX INFO: renamed from: com.xiaomi.push.service.ai$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f464209a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f464210b = null;

        static {
            int[] r100 = new int[gl.values().length];
            f464210b = r100;
            r100[gl.f463790a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            f464210b[gl.f463791b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L22:
            f464210b[gl.f463792c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L28:
            f464210b[gl.f463793d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r101 = new int[gk.values().length];
            f464209a = r101;
            r101[gk.f463788a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L20:
            f464209a[gk.f463789b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private static List<Pair<Integer, Object>> a(List<gp> r100, boolean r101) {
        if (com.xiaomi.push.y.a(r100) == false) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<gp> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L29;
        gp r104 = r103.next();
        int r105 = r104.a();
        gl r106 = gl.a(r104.b());
        if (r106 == null) goto L7;
        if (r101 == false) goto L15;
        if (r104.f656a == false) goto L15;
        r102.add(new Pair(Integer.valueOf(r105), null));
    L15:
        int r107 = AnonymousClass1.f464210b[r106.ordinal()];
        if (r107 != 1) goto L18;
        Pair r108 = new Pair(Integer.valueOf(r105), Integer.valueOf(r104.c()));
    L28:
        r102.add(r108);
        goto L7
    L18:
        if (r107 != 2) goto L20;
        r108 = new Pair(Integer.valueOf(r105), Long.valueOf(r104.m9148a()));
        goto L28
    L20:
        if (r107 != 3) goto L22;
        r108 = new Pair(Integer.valueOf(r105), r104.m9149a());
        goto L28
    L22:
        if (r107 == 4) goto L24;
        r108 = null;
        goto L28
    L24:
        r108 = new Pair(Integer.valueOf(r105), Boolean.valueOf(r104.g()));
        goto L28
    L29:
        return r102;
    }

    public static void a(ah r100, hc r101) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", new Object[]{"-->updateNormalConfigs(): onlineConfig=", r100, ", configMessage=", r101});
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<gn> r104 = r101.a().iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        gn r105 = r104.next();
        r102.add(new Pair(r105.m9144a(), Integer.valueOf(r105.a())));
        List<Pair<Integer, Object>> r106 = a(r105.f648a, false);
        if (com.xiaomi.push.y.a(r106) == true) goto L4;
        r103.addAll(r106);
        goto L4
    L8:
        r100.a(r102, r103);
        r100.b();
    }

    public static void a(ah r100, hb r101) {
        com.xiaomi.channel.commonutils.logger.b.b("OnlineConfigHelper", new Object[]{"-->updateCustomConfigs(): onlineConfig=", r100, ", configMessage=", r101});
        r100.a(a(r101.a(), true));
        r100.b();
    }

    public static int a(ah r100, gk r101) {
        int r102 = 1;
        if (AnonymousClass1.f464209a[r101.ordinal()] == 1) goto L6;
        r102 = 0;
    L6:
        return r100.a(r101, r102);
    }
}
