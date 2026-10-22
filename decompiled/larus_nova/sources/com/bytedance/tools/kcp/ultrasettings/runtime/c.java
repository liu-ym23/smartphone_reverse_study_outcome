package com.bytedance.tools.kcp.ultrasettings.runtime;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<?> f271023a;

    public final KClass<?> getType() {
        return this.f271023a;
    }

    public c(String r100, Type r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "description");
        Intrinsics.checkNotNullParameter(r110, "owner");
        this(r100, Reflection.getOrCreateKotlinClass(Object.class), r102, r110, "");
    }

    public /* synthetic */ c(String r100, KClass r101, String r102, String r110) {
        this(r100, r101, r102, r110, "");
    }

    public c(String r100, KClass<?> r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "description");
        Intrinsics.checkNotNullParameter(r103, "owner");
        Intrinsics.checkNotNullParameter(r104, "from");
        this.f271023a = r101;
    }
}
