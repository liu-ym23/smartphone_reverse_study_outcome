package hz7;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends ColorDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f487708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Shader f487709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Shader f487710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f487711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f487712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f487713f;

    /* JADX INFO: renamed from: hz7.a$a, reason: collision with other inner class name */
    public static final class C6214a {
    }

    static {
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public a() {
        this.f487708a = new Paint();
        this.f487713f = 2.25f;
    }

    public final void b(int r100) {
        if (this.f487712e == r100) goto L6;
        this.f487712e = r100;
        this.f487709b = null;
        this.f487708a.setShader(null);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        r110.drawColor(this.f487711d);
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return;
    L6:
        if (this.f487709b != null) goto L8;
    L10:
        int r100 = this.f487712e;
        int[] r101 = {r100, r100, 0};
        float[] r102 = {0.0f, 0.33f, 1.0f};
        this.f487709b = new RadialGradient(0.0f, 0.0f, 240.0f, r101, r102, Shader.TileMode.CLAMP);
        this.f487710c = new RadialGradient(0.0f, 0.0f, 210.0f, r101, r102, Shader.TileMode.CLAMP);
    L11:
        float r103 = this.f487713f;
        int r104 = r110.save();
        r110.scale(r103, r103, 0.0f, 0.0f);
        int r111 = r110.save();     // Catch: Throwable -> L20
        r110.translate(300.0f, 70.0f);     // Catch: Throwable -> L20
        Shader r105 = this.f487709b;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L17
        a(r110, r105, -320.0f, 10.0f, 0.33f, 0.0f, 240.0f);     // Catch: Throwable -> L17
        Shader r106 = this.f487710c;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L17
        a(r110, r106, 10.0f, -80.0f, 0.875f, -45.0f, 210.0f);     // Catch: Throwable -> L17
        Shader r107 = this.f487709b;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L17
        a(r110, r107, 296.0f, 30.0f, 0.33f, 0.0f, 240.0f);     // Catch: Throwable -> L17
        r110.restoreToCount(r111);     // Catch: Throwable -> L20
        r110.restoreToCount(r104);
        return;
    L17:
        th = move-exception;
        r110.restoreToCount(r111);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r110.restoreToCount(r104);
        throw th;
    L8:
        if (this.f487710c == null) goto L10;
        goto L10
    }

    @Override // android.graphics.drawable.ColorDrawable
    public final void setColor(int r100) {
        super.setColor(r100);
        this.f487711d = r100;
        invalidateSelf();
    }

    public final void a(Canvas r100, Shader r101, float r110, float r111, float r112, float r113, float r114) {
        this.f487708a.setShader(r101);
        int r102 = r100.save();
        r100.translate(r110, r111);
        int r115 = r100.save();     // Catch: Throwable -> L17
        r100.scale(1.0f, r112, 0.0f, 0.0f);     // Catch: Throwable -> L17
        int r116 = r100.save();     // Catch: Throwable -> L14
        r100.rotate(r113, 0.0f, 0.0f);     // Catch: Throwable -> L14
        float r103 = -r114;
        r100.drawOval(r103, r103, r114, r114, this.f487708a);     // Catch: Throwable -> L11
        r100.restoreToCount(r116);     // Catch: Throwable -> L14
        r100.restoreToCount(r115);     // Catch: Throwable -> L17
        r100.restoreToCount(r102);
        return;
    L11:
        th = move-exception;
        r100.restoreToCount(r116);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r100.restoreToCount(r115);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r100.restoreToCount(r102);
        throw th;
    }
}
