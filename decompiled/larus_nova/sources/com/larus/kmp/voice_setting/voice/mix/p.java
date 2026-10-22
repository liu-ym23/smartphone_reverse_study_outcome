package com.larus.kmp.voice_setting.voice.mix;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f353898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f353899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f353900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f353901d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f353898a == r101.f353898a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353899b, r101.f353899b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353900c, r101.f353900c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353901d, r101.f353901d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f353898a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f353899b.hashCode()) * 31) + this.f353900c.hashCode()) * 31;
        s r102 = this.f353901d;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceEditAreaControlsState(visible=" + this.f353898a + ", pitch=" + this.f353899b + ", rate=" + this.f353900c + ", mixedPlayCta=" + this.f353901d + ')';
    }

    public p(boolean r100, t r101, t r102, s r103) {
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_PITCH);
        Intrinsics.checkNotNullParameter(r102, "rate");
        this.f353898a = r100;
        this.f353899b = r101;
        this.f353900c = r102;
        this.f353901d = r103;
    }

    public static p a(p r100, t r101, t r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        boolean r104 = r100.f353898a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = r100.f353899b;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r102 = r100.f353900c;
    L13:
        if ((r103 & 8) == 0) goto L15;
        s r105 = r100.f353901d;
    L16:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_PITCH);
        Intrinsics.checkNotNullParameter(r102, "rate");
        return new p(r104, r101, r102, r105);
    L15:
        r105 = null;
        goto L16
    L5:
        r104 = false;
        goto L7
    }
}
