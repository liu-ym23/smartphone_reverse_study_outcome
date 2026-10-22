package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f405014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<q1> f405015b;

    public b1() {
        throw null;
    }

    public b1(String r100) {
        ArrayList<q1> r101 = com.bytedance.rts.foundation.j.k(new q1[0]);
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "listeners");
        this.f405014a = "";
        this.f405014a = r100;
        this.f405015b = r101;
    }
}
