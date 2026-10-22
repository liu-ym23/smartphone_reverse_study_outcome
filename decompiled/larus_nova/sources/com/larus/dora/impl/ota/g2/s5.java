package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class s5 {
    private final FailureReason reason;
    private final TerminalResult result;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s5) == true) goto L8;
        return false;
    L8:
        s5 r101 = (s5) r100;
        if (this.result == r101.result) goto L12;
        return false;
    L12:
        if (this.reason == r101.reason) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.result.hashCode() * 31) + this.reason.hashCode();
    }

    public final String toString() {
        return "UiTerminal(result=" + this.result + ", reason=" + this.reason + ')';
    }

    public final FailureReason a() {
        return this.reason;
    }

    public final TerminalResult b() {
        return this.result;
    }

    public s5(TerminalResult r100, FailureReason r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.result = r100;
        this.reason = r101;
    }
}
