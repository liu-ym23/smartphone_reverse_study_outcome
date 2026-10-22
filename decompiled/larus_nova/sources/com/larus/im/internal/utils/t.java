package com.larus.im.internal.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public abstract class t<T> implements Function1<T, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final buc.a f350553a;

    public abstract void a(T r100);

    public t() {
        this.f350553a = buc.b.a(false);
    }

    public final void b(T r100) {
        if (this.f350553a.c() == false) goto L5;
        return;
    L5:
        if (this.f350553a.c() == true) goto L15;
        if (this.f350553a.a(false, true) == false) goto L5;
        a(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        b(r100);
        return Unit.INSTANCE;
    }
}
