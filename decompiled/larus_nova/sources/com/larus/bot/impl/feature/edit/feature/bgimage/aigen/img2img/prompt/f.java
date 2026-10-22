package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import com.larus.bot.impl.common.propertyconfig.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextRes f318740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f318741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f318742c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f318740a, r101.f318740a) == true) goto L12;
        return false;
    L12:
        if (this.f318741b == r101.f318741b) goto L15;
        return false;
    L15:
        if (this.f318742c == r101.f318742c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f318740a.hashCode() * 31;
        if (this.f318741b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f318742c;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "BgPromptGenerateUIState(hint=" + this.f318740a + ", disableEdit=" + this.f318741b + ", bgPromptEditState=" + this.f318742c + ')';
    }

    public f(TextRes.StringResId r100, boolean r101, @BgPromptEditState int r102) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        this.f318740a = r100;
        this.f318741b = r101;
        this.f318742c = r102;
    }
}
