package com.larus.im.internal.delegate;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class j0 implements gd9.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd9.t f348246a;

    public static final class a {
    }

    static {
    }

    public j0(gd9.t r100) {
        Intrinsics.checkNotNullParameter(r100, "impl");
        this.f348246a = r100;
    }

    public static gd9.e f(Function0 r210) {
        b r100 = b.f348193b;
        boolean r101 = r100.e();
        String r102 = StringsKt.trim(r100.getUserId()).toString();
        boolean r103 = r100.a();
        gd9.e r104 = (gd9.e) r210.invoke();
        String r105 = StringsKt.trim(r100.getUserId()).toString();
        boolean r106 = r100.e();
        boolean r107 = r100.a();
        if (r101 == false) goto L7;
        if (r106 == false) goto L7;
        return r104;
    L7:
        if (r106 == true) goto L13;
        if (r101 == true) goto L13;
        if (Intrinsics.areEqual(r102, r105) == false) goto L12;
        if (r103 != r107) goto L12;
        return r104;
    L12:
        String r110 = "Current user_id(" + r105 + ") not equal request uid(" + r102 + ") or minor mode not equal before minor = " + r103 + " after minor = " + r107;
        IllegalStateException r111 = new IllegalStateException(r110);
        c0.f348199b.e("FlowHttpApiDelegate", r110, r111);
        gd9.e r108 = new gd9.e(r104.f480965a, -100, r104.f480967c, null, r110, null, r111, r104.f480972h, r104.f480973i, r104.f480974j, r104.f480975k, r104.f480976l, null, 4096);
    L15:
        return r108;
    L13:
        String r112 = "Current user_id(" + r105 + ") not equal request uid(" + r102 + ')';
        IllegalStateException r113 = new IllegalStateException(r112);
        c0.f348199b.e("FlowHttpApiDelegate", r112, r113);
        r108 = new gd9.e(r104.f480965a, -100, r104.f480967c, null, r112, null, r113, r104.f480972h, r104.f480973i, r104.f480974j, r104.f480975k, r104.f480976l, null, 4096);
        goto L15
    }

    @Override // gd9.t
    public final gd9.e executeGet(final String r100, final Map<String, String> r101, final Map<String, String> r110, final Map<String, ? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r100, "relativeUrl");
        return f(new i0(this, r100, r101, r110, r111));
    }

    @Override // gd9.t
    public final gd9.e a(final String r100, final Map<String, String> r110, final Map<String, String> r111, final Map<String, String> r112, final Map<String, ? extends Object> r113) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return f(new f0(this, r100, r110, r111, r112, r113));
    }

    @Override // gd9.t
    public final gd9.e c(final String r100, final String r110, final Map<String, String> r111, final Map<String, String> r112, final Map<String, ? extends Object> r113) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Intrinsics.checkNotNullParameter(r110, "relativeUrl");
        return f(new g0(this, r100, r110, r111, r112, r113));
    }

    @Override // gd9.t
    public final gd9.e d(final String r100, final Object r110, final Map<String, String> r111, final Map<String, String> r112, final Map<String, ? extends Object> r113) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r110, ContainerPosition.BODY);
        return f(new h0(this, r100, r110, r111, r112, r113));
    }

    @Override // gd9.t
    public final gd9.e e(String r100, Object r101, Map<String, String> r110, Map<String, String> r111, Map<String, Long> r112) {
        Intrinsics.checkNotNullParameter(r100, "relativeUrl");
        Intrinsics.checkNotNullParameter(r101, ContainerPosition.BODY);
        return this.f348246a.e(r100, r101, r110, r111, r112);
    }

    @Override // gd9.t
    public final gd9.e b(final String r110, final String r111, final Object r112, final Map<String, String> r113, final Map<String, String> r114, final Map<String, ? extends Object> r115) {
        Intrinsics.checkNotNullParameter(r110, "baseUrl");
        Intrinsics.checkNotNullParameter(r111, "relativeUrl");
        Intrinsics.checkNotNullParameter(r112, "postBody");
        return f(new e0(this, r110, r111, r112, r113, r114, r115));
    }
}
