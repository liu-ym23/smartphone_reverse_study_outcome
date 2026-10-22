package com.larus.bmhome.chat.camera.command;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f297604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Boolean, iq9.e> f297605b;

    public o() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f297604a, r101.f297604a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297605b, r101.f297605b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f297604a.hashCode() * 31) + this.f297605b.hashCode();
    }

    public final String toString() {
        return "CameraSuggestedActionOptions(canEnterAIBeautifyPage=" + this.f297604a + ", draftOperationsProvider=" + this.f297605b + ')';
    }

    public /* synthetic */ o(g r100, int r101) {
        Function0 r102 = r100;
        if ((r101 & 1) == 0) goto L6;
        r102 = new zb8.c();
    L6:
        if ((r101 & 2) == 0) goto L8;
        n r103 = n.f297603a;
    L9:
        this(r102, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function0<Boolean> r100, Function1<? super Boolean, iq9.e> r101) {
        Intrinsics.checkNotNullParameter(r100, "canEnterAIBeautifyPage");
        Intrinsics.checkNotNullParameter(r101, "draftOperationsProvider");
        this.f297604a = r100;
        this.f297605b = r101;
    }
}
