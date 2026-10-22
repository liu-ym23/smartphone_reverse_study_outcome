package com.bytedance.anniex.bd.foundation.impl;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.rts.foundation.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u {
    public static final /* synthetic */ int c = 0;
    public Uri a;
    public Map<String, String> b;

    public static final class a {
        public static u a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uriStr");
            return new u(r2);
        L5:
            th = move-exception;
            int r0 = y.a;
            y.a.b(new Object[]{th});
            return null;
        }
    }

    static {
    }

    public final void a() {
        Uri r0 = this.a;
        if (r0 == null) goto L9;
        Uri.Builder r1 = r0.buildUpon();
        if (r1 == null) goto L9;
        Uri.Builder r2 = r1.clearQuery();
        if (r2 == null) goto L9;
        Uri r3 = r2.build();
    L10:
        this.a = r3;
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final String b() {
        Uri r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHost();
    }

    public final Map<String, String> d() {
        Map<String, String> r1 = this.b;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNull(r1);
        return r1;
    L6:
        this.b = new LinkedHashMap();
        Uri r3 = this.a;     // Catch: Throwable -> L36
        if (r3 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L38;
        Uri r5 = this.a;     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L36
        String r6 = r5.getEncodedQuery();     // Catch: Throwable -> L36
        if (r6 != null) goto L18;
        Map<String, String> r0 = this.b;     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L36
        return r0;
    L18:
        Iterator r7 = com.bytedance.rts.foundation.r.f(r6, "&", -1).iterator();     // Catch: Throwable -> L36
    L20:
        if (r7.hasNext() == false) goto L34;
        String r8 = (String) r7.next();     // Catch: Throwable -> L36
        if (Intrinsics.areEqual(r8, "") == true) goto L20;
        int r9 = StringsKt.indexOf$default(r8, "=", 0, false, 6, null);     // Catch: Throwable -> L36
        if (r9 < 0) goto L27;
        String r10 = com.bytedance.rts.foundation.r.e(r8, 0, r9);     // Catch: Throwable -> L36
        String r11 = com.bytedance.rts.foundation.r.e(r8, r9 + 1, r8.length());     // Catch: Throwable -> L36
        r8 = r10;
    L29:
        if (Intrinsics.areEqual(r8, "") == true) goto L20;
        String r12 = Uri.decode(r8);     // Catch: Throwable -> L36
        String r13 = Uri.decode(r11);     // Catch: Throwable -> L36
        if (r12 == null) goto L20;
        if (r13 == null) goto L20;
        Map<String, String> r14 = this.b;     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L36
        com.bytedance.rts.foundation.m.e(r14, r12, r13);     // Catch: Throwable -> L36
        goto L20
    L27:
        r11 = "";
        goto L29
    L34:
        Map<String, String> r2 = this.b;     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L36
        return r2;
    L38:
        Map<String, String> r15 = this.b;
        Intrinsics.checkNotNull(r15);
        return r15;
    L10:
        if (r3.isHierarchical() != true) goto L12;
        r4 = true;
    L36:
        th = move-exception;
        int r16 = y.a;
        y.a.b(new Object[]{th});
        goto L38
    }

    public final String e() {
        Uri r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        Intrinsics.checkNotNull(r1);
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public u(String r2) {
        Intrinsics.checkNotNullParameter(r2, "s");
        Uri r3 = UriProtector.parse(r2);
        Intrinsics.checkNotNull(r3);
        this.a = r3;
    }

    public final String c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return (String) ((LinkedHashMap) d()).get(r3);
    L5:
        th = move-exception;
        int r0 = y.a;
        y.a.b(new Object[]{th});
        return null;
    }

    public final void f(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "k");
        Intrinsics.checkNotNullParameter(r7, "v");
        Uri r0 = this.a;
        Uri r1 = null;
        if (r0 == null) goto L5;
        String r2 = UriProtector.getQueryParameter(r0, r6);
    L6:
        if (r2 != null) goto L16;
        Uri r3 = this.a;
        if (r3 == null) goto L14;
        Uri.Builder r4 = r3.buildUpon();
        if (r4 == null) goto L14;
        Uri.Builder r8 = r4.appendQueryParameter(r6, r7);
        if (r8 == null) goto L14;
        r1 = r8.build();
    L14:
        this.a = r1;
        return;
    L16:
        if (Intrinsics.areEqual(r2, r7) == false) goto L18;
        return;
    L18:
        Uri r5 = this.a;
        if (r5 == null) goto L21;
        Set r9 = UriProtector.getQueryParameterNames(r5);
    L22:
        Uri r10 = this.a;
        if (r10 == null) goto L27;
        Uri.Builder r11 = r10.buildUpon();
        if (r11 == null) goto L27;
        Uri.Builder r12 = r11.clearQuery();
    L28:
        if (r9 == null) goto L42;
        if (r12 == null) goto L42;
        Iterator r13 = r9.iterator();
    L32:
        if (r13.hasNext() == false) goto L42;
        String r14 = (String) r13.next();
        if (Intrinsics.areEqual(r14, r6) == true) goto L35;
        Uri r15 = this.a;
        if (r15 == null) goto L39;
        String r16 = UriProtector.getQueryParameter(r15, r14);
    L40:
        if (r16 == null) goto L32;
        r12.appendQueryParameter(r14, r16);
        goto L32
    L39:
        r16 = null;
        goto L40
    L35:
        r12.appendQueryParameter(r6, r7);
    L42:
        if (r12 == null) goto L44;
        r1 = r12.build();
    L44:
        this.a = r1;
        return;
    L27:
        r12 = null;
        goto L28
    L21:
        r9 = null;
        goto L22
    L5:
        r2 = null;
        goto L6
    }
}
