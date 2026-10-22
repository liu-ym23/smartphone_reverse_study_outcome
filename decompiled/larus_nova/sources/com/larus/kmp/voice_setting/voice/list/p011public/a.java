package com.larus.kmp.voice_setting.voice.list.p011public;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353557a;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f353557a, ((a) r100).f353557a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f353557a.hashCode();
    }

    public final String toString() {
        return "PublicVoiceListEmptyUiState(message=" + this.f353557a + ')';
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f353557a = r100;
    }

    public /* synthetic */ a(int r100) {
        this("");
    }
}
