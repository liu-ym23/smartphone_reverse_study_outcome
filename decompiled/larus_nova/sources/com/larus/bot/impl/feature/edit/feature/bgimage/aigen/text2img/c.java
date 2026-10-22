package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f318912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f318913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Text2BgImageBindingViewHolder.a> f318914c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f318912a == r101.f318912a) goto L12;
        return false;
    L12:
        if (this.f318913b == r101.f318913b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f318914c, r101.f318914c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f318912a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f318913b == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f318914c.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AIGenBgImageUIState(isLoadError=" + this.f318912a + ", hasChosenImage=" + this.f318913b + ", viewData=" + this.f318914c + ')';
    }

    public c(boolean r100, boolean r101, List<Text2BgImageBindingViewHolder.a> r102) {
        Intrinsics.checkNotNullParameter(r102, "viewData");
        this.f318912a = r100;
        this.f318913b = r101;
        this.f318914c = r102;
    }

    public static c a(c r100, boolean r101, List r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        boolean r104 = r100.f318912a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = r100.f318913b;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = r100.f318914c;
    L12:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "viewData");
        return new c(r104, r101, r102);
    L5:
        r104 = false;
        goto L7
    }
}
