package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.paintreference.PaintStyleViewHolder;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.ReferenceImageContainer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f318673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<PaintStyleViewHolder.a> f318674b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f318673a == r101.f318673a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f318674b, r101.f318674b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f318673a * 31) + this.f318674b.hashCode();
    }

    public final String toString() {
        return "BgImageGenerateUIState(referenceImageUIState=" + this.f318673a + ", paintStylesViewData=" + this.f318674b + ')';
    }

    public d(@ReferenceImageContainer.ReferenceImageUIState int r100, List<PaintStyleViewHolder.a> r101) {
        Intrinsics.checkNotNullParameter(r101, "paintStylesViewData");
        this.f318673a = r100;
        this.f318674b = r101;
    }
}
