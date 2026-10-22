package com.obric.assistant.settings.wakeupsound;

import com.obric.assistant.WakeupSoundEffectSettings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f392507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f392508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f392509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f392510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f392511e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f392507a, r101.f392507a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392508b, r101.f392508b) == true) goto L15;
        return false;
    L15:
        if (this.f392509c == r101.f392509c) goto L18;
        return false;
    L18:
        if (this.f392510d == r101.f392510d) goto L21;
        return false;
    L21:
        if (this.f392511e == r101.f392511e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f392507a.hashCode() * 31) + this.f392508b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f392509c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f392510d == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.f392511e;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "WakeupSoundEffectItemUiModel(value=" + this.f392507a + ", title=" + this.f392508b + ", selected=" + this.f392509c + ", playing=" + this.f392510d + ", cardPosition=" + this.f392511e + ')';
    }

    public g(@WakeupSoundEffectSettings String r100, String r101, boolean r102, boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f392507a = r100;
        this.f392508b = r101;
        this.f392509c = r102;
        this.f392510d = r103;
        this.f392511e = r104;
    }
}
