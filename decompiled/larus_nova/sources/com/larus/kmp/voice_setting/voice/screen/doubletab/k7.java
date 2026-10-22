package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.kmp.voice_setting.voice.component.VoiceEditAreaLayoutMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f354436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f354437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f354438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f354439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VoiceEditAreaLayoutMode f354440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f354441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f354442g;

    public k7() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k7) == true) goto L8;
        return false;
    L8:
        k7 r101 = (k7) r100;
        if (this.f354436a == r101.f354436a) goto L12;
        return false;
    L12:
        if (this.f354437b == r101.f354437b) goto L15;
        return false;
    L15:
        if (this.f354438c == r101.f354438c) goto L18;
        return false;
    L18:
        if (this.f354439d == r101.f354439d) goto L21;
        return false;
    L21:
        if (this.f354440e == r101.f354440e) goto L24;
        return false;
    L24:
        if (this.f354441f == r101.f354441f) goto L27;
        return false;
    L27:
        if (this.f354442g == r101.f354442g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f354436a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f354437b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f354438c) * 31;
        if (this.f354439d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.f354440e.hashCode()) * 31;
        if (this.f354441f == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f354442g == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceDoubleTabSelectModeSnapshot(voiceCanEdit=" + this.f354436a + ", isMultiVoiceMixMode=" + this.f354437b + ", selectVoiceMode=" + this.f354438c + ", showSelectedVoicesOnTop=" + this.f354439d + ", editAreaLayoutMode=" + this.f354440e + ", editAreaControlsVisible=" + this.f354441f + ", collapseEnabled=" + this.f354442g + ')';
    }

    public final boolean a() {
        if (this.f354436a == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f354437b == false) goto L11;
        if (this.f354440e != VoiceEditAreaLayoutMode.LEGACY_MIX) goto L11;
        if (this.f354441f == false) goto L11;
        return true;
    }

    public /* synthetic */ k7(int r100) {
        this(false, false, 0, false, VoiceEditAreaLayoutMode.LEGACY_MIX, false, false);
    }

    public k7(boolean r100, boolean r101, int r102, boolean r103, VoiceEditAreaLayoutMode r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r104, "editAreaLayoutMode");
        this.f354436a = r100;
        this.f354437b = r101;
        this.f354438c = r102;
        this.f354439d = r103;
        this.f354440e = r104;
        this.f354441f = r105;
        this.f354442g = r106;
    }
}
