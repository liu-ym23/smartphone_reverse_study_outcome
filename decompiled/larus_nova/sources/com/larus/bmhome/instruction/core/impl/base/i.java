package com.larus.bmhome.instruction.core.impl.base;

import com.larus.bmhome.actionbar.model.r;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f311939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f311940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f311941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f311942d;

    public i() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f311939a, r101.f311939a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f311940b, r101.f311940b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f311941c, r101.f311941c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f311942d, r101.f311942d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f311939a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        r r104 = this.f311940b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        r r107 = this.f311941c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        r r110 = this.f311942d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstructionControllerInitData(defaultParams=" + this.f311939a + ", draftConf=" + this.f311940b + ", usuallyConf=" + this.f311941c + ", conf=" + this.f311942d + ')';
    }

    public i(Map<String, ? extends Object> r100, r r101, r r102, r r103) {
        this.f311939a = r100;
        this.f311940b = r101;
        this.f311941c = r102;
        this.f311942d = r103;
    }
}
