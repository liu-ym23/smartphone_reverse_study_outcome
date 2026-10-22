package com.ss.android.lark.image.entity;

import android.graphics.drawable.GradientDrawable;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends GradientDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f426345a;

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(getIntrinsicWidth()), Integer.valueOf(getIntrinsicHeight()), Integer.valueOf(this.f426345a)});
    }

    public a() {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Objects.equals(Integer.valueOf(getIntrinsicWidth()), Integer.valueOf(r101.getIntrinsicWidth())) == true) goto L11;
    L15:
        return false;
    L11:
        if (Objects.equals(Integer.valueOf(getIntrinsicHeight()), Integer.valueOf(r101.getIntrinsicHeight())) == false) goto L15;
        if (Objects.equals(Integer.valueOf(this.f426345a), Integer.valueOf(r101.f426345a)) == false) goto L15;
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable
    public final void setColor(int r100) {
        super.setColor(r100);
        this.f426345a = r100;
    }
}
