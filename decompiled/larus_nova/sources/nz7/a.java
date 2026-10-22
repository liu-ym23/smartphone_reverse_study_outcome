package nz7;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends GradientDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f521548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f521549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f521550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f521551d;

    /* JADX INFO: renamed from: nz7.a$a, reason: collision with other inner class name */
    public static final class C6998a {
    }

    static {
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList r100 = this.f521548a;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        if (r100.isStateful() == false) goto L6;
    L12:
        return true;
    L6:
        ColorStateList r101 = this.f521549b;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNull(r101);
        if (r101.isStateful() == true) goto L12;
    L11:
        if (super.isStateful() == true) goto L12;
        return false;
    }

    public a() {
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        super.onBoundsChange(r100);
        if (this.f521551d == false) goto L6;
        setCornerRadius(Math.min(r100.width(), r100.height()) / 2);
        return;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "stateSet");
        boolean r101 = super.onStateChange(r100);
        ColorStateList r102 = this.f521548a;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        setColor(r102.getColorForState(r100, 0));
        r101 = true;
    L5:
        ColorStateList r103 = this.f521549b;
        if (r103 == null) goto L9;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getColorForState(r100, 0);
        setStroke(this.f521550c, r104);
        return true;
    L9:
        return r101;
    }
}
