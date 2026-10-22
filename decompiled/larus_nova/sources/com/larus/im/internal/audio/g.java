package com.larus.im.internal.audio;

import com.larus.im.service.audio.DataType;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g implements com.larus.im.service.audio.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.im.service.audio.x f347181a;

    @Override // com.larus.im.service.audio.x
    public final String getName() {
        return this.f347181a.getName();
    }

    @Override // com.larus.im.service.audio.x
    public DataType getType() {
        return this.f347181a.getType();
    }

    public final int hashCode() {
        return (((this.f347181a.hashCode() * 31) + getName().hashCode()) * 31) + getType().hashCode();
    }

    public g(com.larus.im.service.audio.x r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f347181a = r100;
    }

    @Override // com.larus.im.service.audio.x
    public final void a(com.larus.im.service.audio.l r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        com.larus.im.internal.delegate.c r101 = com.larus.im.internal.delegate.c.f348197a;
        long r102 = r101.elapsedRealtime();
        this.f347181a.a(r100);
        Unit r103 = Unit.INSTANCE;
        long r104 = r101.elapsedRealtime() - r102;
        if (r104 <= 5) goto L6;
        fe9.a.f476620a.a("LLMSessionFrameReceiverTrace", "onReceive cost: " + r104 + ", name: " + getName());
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f347181a, r101.f347181a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getName(), r101.getName()) == true) goto L15;
        return false;
    L15:
        if (getType() == r101.getType()) goto L17;
        return false;
    L17:
        return true;
    }
}
