package com.larus.kmp.voice_setting.voice.utils;

import com.larus.im.FlowRuntime;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p2a.p;

/* JADX INFO: loaded from: classes30.dex */
public final class h implements p2a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f355098a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f355099b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f355100c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f355101d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f355102e = null;

    public h() {
    }

    static {
        f355098a = new h();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f355099b = LazyKt.lazy(r100, new d());
        f355100c = LazyKt.lazy(r100, new e());
        f355101d = LazyKt.lazy(r100, new f());
        f355102e = LazyKt.lazy(r100, new g());
    }

    @Override // p2a.a
    public final p c() {
        return (p) f355099b.getValue();
    }

    @Override // p2a.a
    public final boolean a() {
        b r100 = c.a();
        int r101 = jh9.a.f499103a;
        jh9.b r102 = i.a(r100);
        String r103 = f(r100);
        Intrinsics.checkNotNullParameter(r102, "input");
        if (r102.f499104a == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
    L12:
        return false;
    L10:
        if (jh9.a.a(r102.f499107d, r103) == false) goto L12;
        return true;
    L5:
        if (r102.f499105b == false) goto L7;
        r104 = true;
        goto L8
    }

    @Override // p2a.a
    public final boolean e() {
        b r100 = c.a();
        int r101 = jh9.a.f499103a;
        jh9.b r102 = i.a(r100);
        String r103 = f(r100);
        Intrinsics.checkNotNullParameter(r102, "input");
        if (r102.f499104a == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L21;
        Boolean r105 = r102.f499106c;
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L13;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L21;
        return true;
    L13:
        if (Intrinsics.areEqual(r105, Boolean.FALSE) == false) goto L15;
        r106 = jh9.a.a(r102.f499107d, r103);
        goto L17
    L15:
        if (r105 != null) goto L20;
        r106 = false;
        goto L17
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        return false;
    L5:
        if (r102.f499105b == false) goto L7;
        r104 = true;
        goto L8
    }

    public static String f(b r100) {
        FlowRuntime.b().a().isOversea();
        return r100.f355096f;
    }

    @Override // p2a.a
    public final boolean b(String r100) {
        b r101 = c.a();
        int r102 = jh9.a.f499103a;
        jh9.b r103 = i.a(r101);
        FlowRuntime.b().a().isOversea();
        Intrinsics.checkNotNullParameter(r103, "input");
        if (r103.f499104a == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
    L12:
        return false;
    L10:
        if (jh9.a.a(r103.f499107d, r100) == false) goto L12;
        return true;
    L5:
        if (r103.f499105b == false) goto L7;
        r104 = true;
        goto L8
    }

    @Override // p2a.a
    public final boolean d(String r100) {
        b r101 = c.a();
        int r102 = jh9.a.f499103a;
        FlowRuntime.b().a().isOversea();
        Set<String> r103 = r101.f355094d;
        FlowRuntime.b().a().isOversea();
        Intrinsics.checkNotNullParameter(r103, "allowedLanguages");
        return true;
    }
}
