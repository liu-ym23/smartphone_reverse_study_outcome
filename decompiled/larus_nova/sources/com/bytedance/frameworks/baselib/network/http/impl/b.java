package com.bytedance.frameworks.baselib.network.http.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cookie.f;
import com.bytedance.frameworks.baselib.network.http.cookie.g;
import com.bytedance.frameworks.baselib.network.http.cookie.h;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f244755b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f244756a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f244757a = null;

        static {
            f244757a = new b();
        }
    }

    public b() {
        long r100 = System.nanoTime();
        if (ix5.b.f496375n == false) goto L5;
        this.f244756a = null;
    L6:
        f244755b = (System.nanoTime() - r100) / 1000;
        return;
    L5:
        this.f244756a = new h();
        goto L6
    }

    public final String a(URI r100) {
        h r101 = this.f244756a;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.a(r100, null);
    L7:
        th = move-exception;
        Logger.e("CookieManagerWrap", "getCookie error", th);
        return null;
    }

    public final Pair<String, Map<String, Set<f>>> b(URI r100) {
        h r101 = this.f244756a;
        if (r101 != null) goto L10;
        return null;
    L10:
        HashMap r102 = new HashMap();     // Catch: Throwable -> L7
        return new Pair(r101.a(r100, new g(r102)), r102);
    L7:
        th = move-exception;
        Logger.e("CookieManagerWrap", "getCookieForRelTest error", th);
        return null;
    }

    public final void c(URI r100, List r101) {
        if (this.f244756a == null) goto L20;
        if (r100 != null) goto L6;
        return;
    L6:
        if (Lists.isEmpty(r101) == true) goto L31;
        Iterator r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L32;
        String r103 = (String) r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L10;
    L18:
        th = move-exception;
        Logger.d("CookieManagerWrap", "setCookies error: " + r103, th);
        goto L10
    L15:
        if (this.f244756a.d(r100, r103) == true) goto L10;
        Logger.d("CookieManagerWrap", "setCookies failed: " + r103);     // Catch: Throwable -> L18
        goto L10
    L32:
        return;
    L31:
        return;
    }
}
