package com.larus.platform.service;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g implements com.larus.platform.api.n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f365738a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365739b = null;

    public g() {
    }

    static {
        f365738a = new g();
        f365739b = LazyKt.lazy(new f());
    }

    public static com.larus.platform.api.n1 j() {
        return (com.larus.platform.api.n1) f365739b.getValue();
    }

    @Override // com.larus.platform.api.n1
    public final void c() {
        Intrinsics.checkNotNullParameter("NAVIGATION_LOCATING", "scene");
        com.larus.platform.api.n1 r100 = j();
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void d() {
        Intrinsics.checkNotNullParameter("NAVIGATION_LOCATING", "scene");
        com.larus.platform.api.n1 r100 = j();
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.larus.platform.api.n1
    public final String a() {
        com.larus.platform.api.n1 r100 = j();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.n1
    public final String b() {
        com.larus.platform.api.n1 r100 = j();
        if (r100 == null) goto L6;
        String r101 = r100.b();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.n1
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.larus.platform.api.n1 r101 = j();
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        com.larus.platform.api.n1 r101 = j();
        if (r101 == null) goto L6;
        r101.ensureNotReachHere(r100);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.larus.platform.api.n1 r101 = j();
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final com.larus.platform.api.e1 h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        com.larus.platform.api.n1 r101 = j();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.h(r100);
    }

    @Override // com.larus.platform.api.n1
    public final void i(com.larus.bmhome.chat.screenshot.j r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        com.larus.platform.api.n1 r101 = j();
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        com.larus.platform.api.n1 r101 = j();
        if (r101 == null) goto L6;
        r101.ensureNotReachHere(r100);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "msg");
        com.larus.platform.api.n1 r102 = j();
        if (r102 == null) goto L6;
        r102.ensureNotReachHere(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void f(byte[] r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r101, "msgHeaders");
        com.larus.platform.api.n1 r102 = j();
        if (r102 == null) goto L6;
        r102.f(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "selfDefineData");
        com.larus.platform.api.n1 r103 = j();
        if (r103 == null) goto L6;
        r103.ensureNotReachHere(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.n1
    public final void monitorEventForSlardar(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.larus.platform.api.n1 r104 = j();
        if (r104 == null) goto L6;
        r104.monitorEventForSlardar(r100, r101, r102, r103);
        return;
    }
}
