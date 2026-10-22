package com.bytedance.applog.log;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class c implements i {
    public static final Map<String, i> c = null;
    public String a;
    public final List<String> b;

    static {
        c = new ConcurrentHashMap();
    }

    public c() {
        ArrayList r0 = new ArrayList();
        this.b = r0;
        r0.add("logger@" + hashCode());
    }

    public static String u(String r7, Object... r8) {
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L30
        if (r8.length != 0) goto L5;
    L27:
        r0.append(r7);     // Catch: Throwable -> L30
    L28:
        return r0.toString();
    L5:
        if (r7.contains("{}") == false) goto L27;
        int r1 = r7.length();     // Catch: Throwable -> L30
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r2 >= r1) goto L28;
        char r4 = r7.charAt(r2);     // Catch: Throwable -> L30
        if (r2 >= (r1 - 1)) goto L12;
        char r5 = r7.charAt(r2 + 1);     // Catch: Throwable -> L30
    L14:
        if (r4 == '{') goto L16;
    L25:
        r0.append(r4);     // Catch: Throwable -> L30
    L26:
        r2 = r2 + 1;     // Catch: Throwable -> L30
        goto L8
    L16:
        if (r5 != '}') goto L25;
        if (r3 >= r8.length) goto L24;
        int r6 = r3 + 1;     // Catch: Throwable -> L30
        Object r9 = r8[r3];     // Catch: Throwable -> L30
        if (r9 == null) goto L22;
        String r10 = r9.toString();     // Catch: Throwable -> L30
    L23:
        r0.append(r10);     // Catch: Throwable -> L30
        r3 = r6;
        goto L24
    L22:
        r10 = XmlPullParser.NO_NAMESPACE;
    L24:
        r2 = r2 + 1;     // Catch: Throwable -> L30
        goto L26
    L12:
        r5 = ' ';
    L36:
        return r7;
    }

    public void v(int r6, int r7, List<String> r8, Throwable r9, String r10, Object... r11) {
        boolean r1 = true;
        if (l.a.isEmpty() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        k r2 = new k();
        r2.g = System.currentTimeMillis();
        r2.a = this.a;
        r2.d = r6;
        r2.c = r7;
        r2.b = ThreadMethodProxy.currentThread().getName();
        r2.h = r9;
        if (r8 != null) goto L13;
    L15:
        List r12 = this.b;
    L16:
        r2.e = r12;
        r2.f = u(r10, r11);
        l.a(r2);
        String r13 = this.a;
        if (r13 != null) goto L19;
    L21:
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        j r14 = (j) ((ConcurrentHashMap) l.b).get(r13);
    L25:
        if (r14 == null) goto L28;
        r14.a(r2);
        return;
    L28:
        return;
    L24:
        r14 = null;
        goto L25
    L19:
        if (r13.isEmpty() == true) goto L21;
    L13:
        if (r8.size() <= 0) goto L15;
        ArrayList r15 = new ArrayList();
        r15.addAll(this.b);
        r15.addAll(r8);
        r12 = r15;
        goto L16
    L5:
        if (((ConcurrentHashMap) l.b).isEmpty() == false) goto L7;
        r0 = true;
        goto L8
    }
}
