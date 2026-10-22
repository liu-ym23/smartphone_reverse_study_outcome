package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class o8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f405207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Double> f405208b;

    public final int getType() {
        return this.f405207a;
    }

    public o8(int r100, ArrayList<Double> r101) {
        Intrinsics.checkNotNullParameter(r101, "args");
        this.f405207a = r100;
        this.f405208b = r101;
    }
}
