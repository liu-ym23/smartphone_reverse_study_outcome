package com.larus.bot.impl.feature.edit.feature.avatar;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f318518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f318519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f318520c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f318518a, r101.f318518a) == true) goto L12;
        return false;
    L12:
        if (this.f318519b == r101.f318519b) goto L15;
        return false;
    L15:
        if (this.f318520c == r101.f318520c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Uri r100 = this.f318518a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.f318519b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f318520c == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AvatarUIState(uri=" + this.f318518a + ", needResize=" + this.f318519b + ", isGenerating=" + this.f318520c + ')';
    }

    public c(Uri r100, boolean r101, boolean r102) {
        this.f318518a = r100;
        this.f318519b = r101;
        this.f318520c = r102;
    }
}
