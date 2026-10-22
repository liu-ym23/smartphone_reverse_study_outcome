package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements t1a.f, m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f354713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f354714b;

    public v() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f354713a == r101.f354713a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354714b, r101.f354714b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f354713a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f354714b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoubleTabCreateVoiceButtonUiState(visible=" + this.f354713a + ", text=" + this.f354714b + ')';
    }

    public /* synthetic */ v(int r100) {
        this(false, "");
    }

    public v(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f354713a = r100;
        this.f354714b = r101;
    }
}
