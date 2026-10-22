package com.larus.uaigc.service;

import hq9.r3;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<z> f373955a;

    @Override // hq9.r3
    public final void a() {
    }

    @Override // hq9.r3
    public final void d() {
    }

    @Override // hq9.r3
    public final void b() {
        z r100 = (z) CollectionsKt.getOrNull(this.f373955a, 1);
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f374002b;
        if (r101 == null) goto L9;
        r101.invoke();
        return;
    L9:
        return;
    }

    @Override // hq9.r3
    public final void c() {
        z r100 = (z) CollectionsKt.getOrNull(this.f373955a, 0);
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f374002b;
        if (r101 == null) goto L9;
        r101.invoke();
        return;
    L9:
        return;
    }

    public d(List<z> r100) {
        this.f373955a = r100;
    }
}
