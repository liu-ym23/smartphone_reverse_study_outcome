package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.kmp.voice_setting.voice.component.VoiceEditAreaLayoutMode;
import com.larus.kmp.voice_setting.voice.component.VoiceEditMode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceEditMode f354292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f354293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f354294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VoiceEditAreaLayoutMode f354295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f354296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f354297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final VoiceEditMode f354298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f354299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f354300i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e8) == true) goto L8;
        return false;
    L8:
        e8 r101 = (e8) r100;
        if (this.f354292a == r101.f354292a) goto L12;
        return false;
    L12:
        if (this.f354293b == r101.f354293b) goto L15;
        return false;
    L15:
        if (this.f354294c == r101.f354294c) goto L18;
        return false;
    L18:
        if (this.f354295d == r101.f354295d) goto L21;
        return false;
    L21:
        if (this.f354296e == r101.f354296e) goto L24;
        return false;
    L24:
        if (this.f354297f == r101.f354297f) goto L27;
        return false;
    L27:
        if (this.f354298g == r101.f354298g) goto L30;
        return false;
    L30:
        if (this.f354299h == r101.f354299h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f354300i, r101.f354300i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f354292a.hashCode() * 31;
        int r101 = 1231;
        if (this.f354293b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f354294c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f354295d.hashCode()) * 31;
        if (this.f354296e == true) goto L15;
        r101 = 1237;
    L15:
        return ((((((((r105 + r101) * 31) + this.f354297f) * 31) + this.f354298g.hashCode()) * 31) + this.f354299h) * 31) + this.f354300i.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceEditRegionMeasureSignature(mode=" + this.f354292a + ", visible=" + this.f354293b + ", hasVoiceContent=" + this.f354294c + ", layoutMode=" + this.f354295d + ", controlsVisible=" + this.f354296e + ", mixVoiceCount=" + this.f354297f + ", mixMode=" + this.f354298g + ", mixItemCount=" + this.f354299h + ", mixItemIds=" + this.f354300i + ')';
    }

    public e8(VoiceEditMode r100, boolean r101, boolean r102, VoiceEditAreaLayoutMode r103, boolean r104, int r105, VoiceEditMode r106, int r107, List<String> r110) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r103, "layoutMode");
        Intrinsics.checkNotNullParameter(r106, "mixMode");
        Intrinsics.checkNotNullParameter(r110, "mixItemIds");
        this.f354292a = r100;
        this.f354293b = r101;
        this.f354294c = r102;
        this.f354295d = r103;
        this.f354296e = r104;
        this.f354297f = r105;
        this.f354298g = r106;
        this.f354299h = r107;
        this.f354300i = r110;
    }
}
