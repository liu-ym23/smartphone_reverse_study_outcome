package com.larus.audio.call.record;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<byte[], Unit> f289606a;

    public m() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f289606a, ((m) r100).f289606a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Function1<byte[], Unit> r100 = this.f289606a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "RecordDumpConfig(opusDump=" + this.f289606a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function1<? super byte[], Unit> r100) {
        this.f289606a = r100;
    }
}
