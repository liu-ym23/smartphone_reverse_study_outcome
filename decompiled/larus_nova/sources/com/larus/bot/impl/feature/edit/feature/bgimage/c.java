package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.net.Uri;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f318964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f318965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f318966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextRes f318967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f318968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f318969f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f318964a, r101.f318964a) == true) goto L12;
        return false;
    L12:
        if (this.f318965b == r101.f318965b) goto L15;
        return false;
    L15:
        if (this.f318966c == r101.f318966c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f318967d, r101.f318967d) == true) goto L21;
        return false;
    L21:
        if (this.f318968e == r101.f318968e) goto L24;
        return false;
    L24:
        if (this.f318969f == r101.f318969f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Uri r100 = this.f318964a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.f318965b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f318966c == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((r105 + r106) * 31) + this.f318967d.hashCode()) * 31;
        if (this.f318968e == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f318969f == true) goto L23;
        r103 = 1237;
    L23:
        return r109 + r103;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BgImageUIState(uri=" + this.f318964a + ", needResize=" + this.f318965b + ", isCircle=" + this.f318966c + ", btnStr=" + this.f318967d + ", isBtnBlue=" + this.f318968e + ", isGenerating=" + this.f318969f + ')';
    }

    public c(Uri r100, boolean r101, boolean r102, TextRes.StringResId r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r103, "btnStr");
        this.f318964a = r100;
        this.f318965b = r101;
        this.f318966c = r102;
        this.f318967d = r103;
        this.f318968e = r104;
        this.f318969f = r105;
    }
}
