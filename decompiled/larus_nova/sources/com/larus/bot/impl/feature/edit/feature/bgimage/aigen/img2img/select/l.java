package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<BgSelectViewHolder.a> f318835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f318836b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f318835a, r101.f318835a) == true) goto L12;
        return false;
    L12:
        if (this.f318836b == r101.f318836b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f318835a.hashCode() * 31;
        if (this.f318836b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "BgSelectUIState(viewPagerViewData=" + this.f318835a + ", canConfirm=" + this.f318836b + ')';
    }

    public l(List<BgSelectViewHolder.a> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "viewPagerViewData");
        this.f318835a = r100;
        this.f318836b = r101;
    }
}
