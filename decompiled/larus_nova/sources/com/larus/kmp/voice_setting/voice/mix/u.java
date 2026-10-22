package com.larus.kmp.voice_setting.voice.mix;

import com.larus.kmp.voice_setting.voice.component.VoiceEditAreaLayoutMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f353929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f353930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceEditAreaLayoutMode f353931c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f353929a, r101.f353929a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353930b, r101.f353930b) == true) goto L15;
        return false;
    L15:
        if (this.f353931c == r101.f353931c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f353929a.hashCode() * 31) + this.f353930b.hashCode()) * 31) + this.f353931c.hashCode();
    }

    public final String toString() {
        return "VoiceEditAreaState(emptyRow=" + this.f353929a + ", controls=" + this.f353930b + ", layoutMode=" + this.f353931c + ')';
    }

    public static u a(u r100, p r101) {
        r r102 = r100.f353929a;
        VoiceEditAreaLayoutMode r103 = r100.f353931c;
        Intrinsics.checkNotNullParameter(r102, "emptyRow");
        Intrinsics.checkNotNullParameter(r101, "controls");
        Intrinsics.checkNotNullParameter(r103, "layoutMode");
        return new u(r102, r101, r103);
    }

    public u(r r100, p r101, VoiceEditAreaLayoutMode r102) {
        Intrinsics.checkNotNullParameter(r100, "emptyRow");
        Intrinsics.checkNotNullParameter(r101, "controls");
        Intrinsics.checkNotNullParameter(r102, "layoutMode");
        this.f353929a = r100;
        this.f353930b = r101;
        this.f353931c = r102;
    }
}
