package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class k extends u0 {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f277379a = null;

        static {
            int[] r100 = new int[d0.values().length];
            f277379a = r100;
            r100[d0.f277313c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f277379a[d0.f277311a.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f277379a[d0.f277312b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static f0 a(String r100, String r101, String r102, String r103) {
        f0 r104 = u0.a(r100, r101, r102, r103);
        String r105 = j.a().a(a1.c(r101, r102));
        long r106 = System.currentTimeMillis();
        String r107 = SHA.sha256Encrypt(q0.f() + r105 + r106);
        r104.f(String.valueOf(r106));
        r104.g(r107);
        return r104;
    }

    public static h1 a(List<b1> r100, String r101, String r102, String r103, String r104) {
        h1 r105 = u0.b(r101, r102);
        if (r105 != null) goto L6;
        return null;
    L6:
        r105.a(a(m1.d().a(), r101, r102, r103));
        r105.a(a(r101, r102));
        r105.a(a(r102, r101, r104));
        r105.a(a1.g(r101, r102));
        r105.a(r100);
        return r105;
    }

    public static l a(String r100, String r101) {
        l r102 = u0.a(r100, r101);
        i r103 = j.a().c(r100, r101);
        r102.g(j.a().a(a1.c(r100, r101)));
        r102.f(a1.o(r100, r101));
        r102.c(j.a().f(r100, r101));
        d0 r104 = r103.a();
        int r105 = a.f277379a[r104.ordinal()];
        if (r105 != 1) goto L5;
        r102.d(r103.b());
    L12:
        return r102;
    L5:
        if (r105 != 2) goto L7;
        r102.b(r103.b());
        goto L12
    L7:
        if (r105 != 3) goto L12;
        r102.e(r103.b());
        goto L12
    }

    public static y0 a(String r100, String r101, String r102) {
        y0 r103 = u0.a(r100, r101, r102);
        Pair<String, String> r104 = j.a().e(r101, r100);
        r103.f((String) r104.first);
        r103.g((String) r104.second);
        r103.h(o.b());
        r103.d(j.a().d(r101, r100));
        return r103;
    }

    public static Map<String, String> b(String r100, String r101, String r102) {
        Map<String, String> r103 = u0.c(r100, r102);
        Map<String, String> r104 = a1.i(r100, r101);
        if (r104 != null) goto L5;
        return r103;
    L5:
        r103.putAll(r104);
        return r103;
    }
}
