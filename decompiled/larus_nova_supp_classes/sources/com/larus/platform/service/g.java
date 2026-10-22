package com.larus.platform.service;

import com.larus.bmhome.chat.screenshot.j;
import com.larus.platform.api.e1;
import com.larus.platform.api.n1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class g implements n1 {
    public static final g a = null;
    public static final Lazy b = null;

    public g() {
    }

    static {
        a = new g();
        b = LazyKt.lazy(new f());
    }

    public static n1 j() {
        return (n1) b.getValue();
    }

    @Override // com.larus.platform.api.n1
    public final void c() {
        Intrinsics.checkNotNullParameter("NAVIGATION_LOCATING", "scene");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void d() {
        Intrinsics.checkNotNullParameter("NAVIGATION_LOCATING", "scene");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.larus.platform.api.n1
    public final String a() {
        n1 r0 = j();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // com.larus.platform.api.n1
    public final String b() {
        n1 r0 = j();
        if (r0 == null) goto L6;
        String r1 = r0.b();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.platform.api.n1
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.ensureNotReachHere(r2);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final e1 h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        n1 r0 = j();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h(r2);
    }

    @Override // com.larus.platform.api.n1
    public final void i(j r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.ensureNotReachHere(r2);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "t");
        Intrinsics.checkNotNullParameter(r3, "msg");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.ensureNotReachHere(r2, r3);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void f(byte[] r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        Intrinsics.checkNotNullParameter(r3, "msgHeaders");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.f(r2, r3);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "t");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "selfDefineData");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.ensureNotReachHere(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void monitorEventForSlardar(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "event");
        n1 r0 = j();
        if (r0 == null) goto L6;
        r0.monitorEventForSlardar(r2, r3, r4, r5);
        return;
    }
}
