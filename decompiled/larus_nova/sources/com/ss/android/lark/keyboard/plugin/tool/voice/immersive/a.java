package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f430165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f430166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f430167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f430168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f430169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f430170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f430171g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f430165a == r101.f430165a) goto L12;
        return false;
    L12:
        if (this.f430166b == r101.f430166b) goto L15;
        return false;
    L15:
        if (Float.compare(this.f430167c, r101.f430167c) == 0) goto L18;
        return false;
    L18:
        if (this.f430168d == r101.f430168d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f430169e, r101.f430169e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f430170f, r101.f430170f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f430171g, r101.f430171g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f430165a * 31;
        int r101 = 1231;
        if (this.f430166b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + Float.floatToIntBits(this.f430167c)) * 31;
        if (this.f430168d == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        Integer r105 = this.f430169e;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        Integer r109 = this.f430170f;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Integer r112 = this.f430171g;
        if (r112 == null) goto L23;
        r106 = r112.hashCode();
    L23:
        return r111 + r106;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AdvanceVoiceButtonConfig(textRes=" + this.f430165a + ", enableTextMode=" + this.f430166b + ", textSizeSp=" + this.f430167c + ", isTextBold=" + this.f430168d + ", buttonHeight=" + this.f430169e + ", buttonVerticalPadding=" + this.f430170f + ", buttonTopMargin=" + this.f430171g + ')';
    }

    public a(boolean r100, boolean r101, Integer r102, Integer r103, Integer r104) {
        this.f430165a = R.string.Lark_IM_AudioMsg_ReleaseToStop_Button;
        this.f430166b = r100;
        this.f430167c = 14.0f;
        this.f430168d = r101;
        this.f430169e = r102;
        this.f430170f = r103;
        this.f430171g = r104;
    }
}
