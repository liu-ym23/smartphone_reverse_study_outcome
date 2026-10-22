package com.larus.kmp.voice_setting.voice.screen.single;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Shape f354957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f354958b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f354957a, r101.f354957a) == true) goto L12;
        return false;
    L12:
        if (this.f354958b == r101.f354958b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f354957a.hashCode() * 31;
        if (this.f354958b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SingleTtsSpeakerRowLayout(shape=" + this.f354957a + ", showBottomSpacer=" + this.f354958b + ')';
    }

    public z(RoundedCornerShape r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "shape");
        this.f354957a = r100;
        this.f354958b = r101;
    }
}
