package com.bytedance.ug.sdk.luckydog.task.tasktimer.executor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends bl7.a {
    public final int hashCode() {
        return ((336 + c().f546539a.hashCode()) * 24) + c().f546540b.hashCode();
    L5:
        return super.hashCode();
    }

    public a() {
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
        Object r101 = null;
    L6:
        a r102 = (a) r101;     // Catch: Exception -> L17
        if (r102 == null) goto L16;
        if (Intrinsics.areEqual(r102.c().f546539a, c().f546539a) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(r102.c().f546540b, c().f546540b) == false) goto L13;
        return true;
    L16:
        return super.equals(r100);
    L5:
        r101 = r100;
        goto L6
    L18:
        return super.equals(r100);
    }
}
