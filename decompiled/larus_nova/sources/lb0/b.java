package lb0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends Drawable implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f508301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f508302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f508303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f508304d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return (int) (this.f508301a * 255);
    }

    public b() {
        this.f508301a = 0.7f;
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        r100.setStyle(Paint.Style.FILL);
        Unit r101 = Unit.INSTANCE;
        this.f508302b = r100;
        this.f508303c = Integer.valueOf(ColorProtector.parseColor("#395A88"));
        this.f508304d = Integer.valueOf(ColorProtector.parseColor("#4C78B8"));
    }

    @Override // lb0.a
    public final Integer a() {
        return this.f508304d;
    }

    @Override // lb0.a
    public final float c() {
        return this.f508301a;
    }

    @Override // lb0.a
    public final Integer e() {
        return this.f508303c;
    }

    @Override // android.graphics.drawable.Drawable, lb0.a
    public final void invalidateSelf() {
        super.invalidateSelf();
    }

    @Override // lb0.a
    public final void b(Integer r100) {
        this.f508303c = r100;
    }

    @Override // lb0.a
    public final void d(Integer r100) {
        this.f508304d = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = getBounds().width();
        float r101 = getBounds().height();
        if (this.f508303c == null) goto L5;
    L6:
        Paint r102 = this.f508302b;
        Integer r103 = this.f508303c;
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        int r111 = r104;
        Integer r105 = this.f508304d;
        if (r105 == null) goto L13;
        int r106 = r105.intValue();
    L14:
        r102.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r101, r111, r106, Shader.TileMode.MIRROR));
        r110.drawRect(0.0f, 0.0f, r100, r101, this.f508302b);
        return;
    L13:
        r106 = ColorProtector.parseColor("#5A8FDB");
        goto L14
    L9:
        r104 = ColorProtector.parseColor("#395A88");
        goto L10
    L5:
        if (this.f508304d != null) goto L6;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f508301a = r100 / 255;
    }
}
