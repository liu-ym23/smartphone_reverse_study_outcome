package t08;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends GradientDrawable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f544126e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f544127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f544128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f544129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f544130d;

    /* JADX INFO: renamed from: t08.a$a, reason: collision with other inner class name */
    public static final class C7675a {
        public static a a(ColorStateList r100, int r101, ColorStateList r102, int r103, int r104, int r105, int r106, boolean r107, int r108) {
            a r109 = new a();
            r109.f544127a = r100;
            r109.setColor(r100);
            r109.f544129c = r101;
            r109.f544128b = r102;
            r109.setStroke(r101, r102);
            if (r103 > 0) goto L11;
            if (r104 > 0) goto L11;
            if (r105 > 0) goto L11;
            if (r106 > 0) goto L11;
            r109.setCornerRadius(r108);
            if (r108 > 0) goto L12;
        L13:
            r109.f544130d = r107;
            return r109;
        L12:
            r107 = false;
        L11:
            float r110 = r103;
            float r111 = r104;
            float r112 = r106;
            float r113 = r105;
            r109.setCornerRadii(new float[]{r110, r110, r111, r111, r112, r112, r113, r113});
            goto L12
        }
    }

    static {
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList r100 = this.f544127a;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        if (r100.isStateful() == false) goto L6;
    L12:
        return true;
    L6:
        ColorStateList r101 = this.f544128b;
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
        if (this.f544130d == false) goto L6;
        setCornerRadius(Math.min(r100.width(), r100.height()) / 2);
        return;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "stateSet");
        boolean r101 = super.onStateChange(r100);
        ColorStateList r102 = this.f544127a;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        setColor(r102.getColorForState(r100, 0));
        r101 = true;
    L5:
        ColorStateList r103 = this.f544128b;
        if (r103 == null) goto L9;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getColorForState(r100, 0);
        setStroke(this.f544129c, r104);
        return true;
    L9:
        return r101;
    }
}
