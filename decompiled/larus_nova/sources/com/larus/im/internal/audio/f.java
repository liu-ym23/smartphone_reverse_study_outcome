package com.larus.im.internal.audio;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.im.service.audio.v f347179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f347180b;

    @Override // com.larus.im.internal.audio.v
    public final int L2() {
        return w.a(this.f347179a);
    }

    public final int hashCode() {
        return this.f347179a.hashCode();
    }

    @Override // com.larus.im.service.audio.v
    public final String getName() {
        return this.f347180b;
    }

    public f(com.larus.im.service.audio.v r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f347179a = r100;
        this.f347180b = r100.getName();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f) == false) goto L7;
        return Intrinsics.areEqual(this.f347179a, ((f) r100).f347179a);
    L7:
        return Intrinsics.areEqual(this.f347179a, r100);
    }

    @Override // com.larus.im.service.audio.v
    public final void O1(final jd9.c r100, final jd9.c r101) {
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r101, "newState");
        Function0 r102 = new e(this, r100, r101);
        com.larus.im.internal.delegate.c r103 = com.larus.im.internal.delegate.c.f348197a;
        long r104 = r103.elapsedRealtime();
        r102.invoke();
        long r105 = r103.elapsedRealtime() - r104;
        if (r105 <= 5) goto L6;
        fe9.a.f476620a.a("LLMSessionConnectionStateListenerTrace", "onConnectionStateChanged cost " + r105 + ", name: " + this.f347180b);
        return;
    }
}
