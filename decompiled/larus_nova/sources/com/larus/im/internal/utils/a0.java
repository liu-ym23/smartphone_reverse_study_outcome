package com.larus.im.internal.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a0<State> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f350524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public State f350525b;

    public abstract jd9.c a(Object r100, Object r101);

    public a0() {
        State r100 = (State) jd9.c.f.f498762c;
        this.f350524a = r100;
        this.f350525b = r100;
    }

    public final boolean b(State r100) {
        State r101 = this.f350525b;
        State r102 = (State) a(r101, r100);
        if (Intrinsics.areEqual(r101, r102) == false) goto L6;
        return false;
    L6:
        this.f350525b = r102;
        return true;
    }
}
