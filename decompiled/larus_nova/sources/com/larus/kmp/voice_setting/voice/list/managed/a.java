package com.larus.kmp.voice_setting.voice.list.managed;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ManagedVoiceListOverlayIconKind f353450b;

    public a() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f353449a, r101.f353449a) == true) goto L12;
        return false;
    L12:
        if (this.f353450b == r101.f353450b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f353449a.hashCode() * 31) + this.f353450b.hashCode();
    }

    public final String toString() {
        return "ManagedVoiceListOverlayUiState(message=" + this.f353449a + ", iconKind=" + this.f353450b + ')';
    }

    public a(String r100, ManagedVoiceListOverlayIconKind r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "iconKind");
        this.f353449a = r100;
        this.f353450b = r101;
    }

    public /* synthetic */ a(String r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r101 & 2) == 0) goto L8;
        ManagedVoiceListOverlayIconKind r102 = ManagedVoiceListOverlayIconKind.NONE;
    L9:
        this(r100, r102);
        return;
    L8:
        r102 = null;
        goto L9
    }
}
