package com.larus.voice.output.volume;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f376036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f376037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f376038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f376039d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f376036a == r101.f376036a) goto L12;
        return false;
    L12:
        if (this.f376037b == r101.f376037b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f376038c, r101.f376038c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f376039d, r101.f376039d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f376036a * 31;
        if (this.f376037b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((r100 + r101) * 31) + this.f376038c.hashCode()) * 31;
        Map<String, String> r103 = this.f376039d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ZeroVolumeHandlerContext(strategyId=" + this.f376036a + ", enableAutoPlayToast=" + this.f376037b + ", scene=" + this.f376038c + ", bizExt=" + this.f376039d + ')';
    }

    public c(int r100, boolean r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f376036a = r100;
        this.f376037b = r101;
        this.f376038c = r102;
        this.f376039d = r103;
    }
}
