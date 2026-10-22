package com.bytedance.locallife.biz.base.cube;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements fp6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f256531a = null;

    static {
        f256531a = new a();
    }

    public a() {
    }

    public final Object b(Class r100) {
        Intrinsics.checkNotNullParameter("cube_optimize_jsb_thread", "key");
        Intrinsics.checkNotNullParameter(r100, "targetClass");
        return HostServiceUtilsKt.y().a("cube_optimize_jsb_thread", r100, null);
    }

    public final int a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return HostServiceUtilsKt.y().b(r100, r101);
    }
}
