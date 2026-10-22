package com.bytedance.tools.kcp.ultrasettings.runtime;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f271017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f271018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f271019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f271020d;

    public final T a() {
        return this.f271018b;
    }

    public final String b() {
        return this.f271017a;
    }

    public final boolean c() {
        return this.f271020d;
    }

    public final Type getType() {
        return this.f271019c;
    }

    public a(String r100, T r101, Type r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f271017a = r100;
        this.f271018b = r101;
        this.f271019c = r102;
        this.f271020d = r103;
    }
}
