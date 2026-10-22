package com.larus.kmp.voice_setting.voice.dialog.v2.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f353051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceMaterialSelectionSource f353052b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f353051a, r101.f353051a) == true) goto L12;
        return false;
    L12:
        if (this.f353052b == r101.f353052b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f353051a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f353052b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceMaterialSelectionResult(value=" + this.f353051a + ", source=" + this.f353052b + ')';
    }

    public e(T r100, VoiceMaterialSelectionSource r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f353051a = r100;
        this.f353052b = r101;
    }
}
