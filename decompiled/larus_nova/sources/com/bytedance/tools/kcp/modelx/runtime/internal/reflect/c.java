package com.bytedance.tools.kcp.modelx.runtime.internal.reflect;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f270986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f270987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f270988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f270989d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "FieldInfo(key = " + this.f270986a + ", type = " + this.f270987b + ", getter = " + this.f270988c + ", setter = " + this.f270989d + ')';
    }

    public c(String r100, int r101, Method r102, Method r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "getter");
        this.f270986a = r100;
        this.f270987b = r101;
        this.f270988c = r102;
        this.f270989d = r103;
    }
}
