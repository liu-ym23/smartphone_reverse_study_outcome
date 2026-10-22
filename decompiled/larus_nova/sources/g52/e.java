package g52;

import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f480020j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f480021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f480022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Typeface f480023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f480024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f480025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f480026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f480027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f480028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f480029i;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (Float.compare(this.f480021a, r101.f480021a) == 0) goto L8;
        return false;
    L8:
        if (this.f480022b == r101.f480022b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f480023c, r101.f480023c) == true) goto L12;
        return false;
    L12:
        if (this.f480024d == r101.f480024d) goto L14;
        return false;
    L14:
        if (this.f480025e == r101.f480025e) goto L16;
        return false;
    L16:
        if (this.f480026f == r101.f480026f) goto L18;
        return false;
    L18:
        if (this.f480027g == r101.f480027g) goto L20;
        return false;
    L20:
        if (Float.compare(this.f480028h, r101.f480028h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.f480029i, r101.f480029i) == 0) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r100 = ((Float.floatToIntBits(this.f480021a) * 31) + this.f480022b) * 31;
        Typeface r101 = this.f480023c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((((((((((((r100 + r102) * 31) + this.f480024d) * 31) + this.f480025e) * 31) + this.f480026f) * 31) + this.f480027g) * 31) + Float.floatToIntBits(this.f480028h)) * 31) + Float.floatToIntBits(this.f480029i);
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "TextConfig(textSizeInPx=" + this.f480021a + ", minHeight=" + this.f480022b + ", typeface=" + this.f480023c + ", paddingLeft=" + this.f480024d + ", paddingTop=" + this.f480025e + ", paddingRight=" + this.f480026f + ", paddingBottom=" + this.f480027g + ", lineSpacing=" + this.f480028h + ", fontSizeScale=" + this.f480029i + ")";
    }

    public final void c(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        int r101 = this.f480024d;
        if (r101 != (-1)) goto L5;
        r101 = r100.getPaddingLeft();
    L5:
        int r102 = this.f480025e;
        if (r102 != (-1)) goto L8;
        r102 = r100.getPaddingTop();
    L8:
        int r103 = this.f480026f;
        if (r103 != (-1)) goto L11;
        r103 = r100.getPaddingRight();
    L11:
        int r104 = this.f480027g;
        if (r104 != (-1)) goto L14;
        r104 = r100.getPaddingBottom();
    L14:
        r100.setPadding(r101, r102, r103, r104);
    }

    public static void b(e r100, ImageView r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "imageView");
        float r102 = r100.f480029i;
        if (r102 <= 0) goto L6;
        r101.setScaleX(r102);
        r101.setScaleY(r100.f480029i);
        return;
    }

    public final void a(TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (r101 == false) goto L5;
        float r102 = f.a(this.f480021a, this.f480029i);
    L6:
        r100.setTextSize(0, r102);
        r100.setMinHeight(this.f480022b);
        float r103 = this.f480028h;
        if (r103 == (-1.0f)) goto L9;
        r100.setLineSpacing(r103, r100.getLineSpacingMultiplier());
    L9:
        Typeface r104 = this.f480023c;
        if (r104 == null) goto L12;
        r100.setTypeface(r104);
    L12:
        int r105 = this.f480024d;
        if (r105 != (-1)) goto L15;
        r105 = r100.getPaddingLeft();
    L15:
        int r106 = this.f480025e;
        if (r106 != (-1)) goto L18;
        r106 = r100.getPaddingTop();
    L18:
        int r107 = this.f480026f;
        if (r107 != (-1)) goto L21;
        r107 = r100.getPaddingRight();
    L21:
        int r108 = this.f480027g;
        if (r108 != (-1)) goto L24;
        r108 = r100.getPaddingBottom();
    L24:
        r100.setPadding(r105, r106, r107, r108);
        return;
    L5:
        r102 = this.f480021a;
        goto L6
    }

    public /* synthetic */ e(float r110, int r111, Typeface r112, int r113, int r114, int r115, int r116) {
        this(r110, r111, r112, r113, r114, r115, r116, -1.0f, 0.0f);
    }

    public e(float r100, int r101, Typeface r102, int r103, int r104, int r105, int r106, float r107, float r108) {
        this.f480021a = r100;
        this.f480022b = r101;
        this.f480023c = r102;
        this.f480024d = r103;
        this.f480025e = r104;
        this.f480026f = r105;
        this.f480027g = r106;
        this.f480028h = r107;
        this.f480029i = r108;
    }
}
