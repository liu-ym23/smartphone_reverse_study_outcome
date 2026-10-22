package com.bytedance.locallife.cube;

import com.bytedance.locallife.biz.base.cube.l;
import com.bytedance.locallife.biz.base.cube.p;
import fp6.e;
import fp6.f;
import fp6.g;
import fp6.i;
import fp6.k;
import fp6.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f257193a;

    static {
    }

    public static e a() {
        if (f257193a == null) goto L5;
        d().n();
        return com.bytedance.locallife.biz.base.cube.a.f256531a;
    L5:
        return null;
    }

    public static i d() {
        i r100 = f257193a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("cubeHostDependency");
        return null;
    }

    public static k e() {
        if (f257193a == null) goto L5;
        d().m();
        return l.f256544a;
    L5:
        return null;
    }

    public static f b() {
        d().j();
        return com.bytedance.locallife.biz.base.cube.c.f256533a;
    }

    public static g c() {
        d().i();
        return com.bytedance.locallife.biz.base.cube.d.f256534a;
    }

    public static m f() {
        d().c();
        return p.f256548a;
    }
}
