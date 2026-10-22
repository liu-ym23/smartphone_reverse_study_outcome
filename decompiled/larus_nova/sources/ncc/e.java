package ncc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f518724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f518725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f518726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f518727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f518728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f518729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f518730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f518731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f518732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f518733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f518734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean[] f518735l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f518736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f518737b;

        public final int hashCode() {
            return Objects.hash(new Object[]{0, this.f518736a, Integer.valueOf(this.f518737b), Boolean.TRUE});
        }

        public a(CharSequence r100) {
            this.f518736a = r100;
            if (r100 == null) goto L5;
            this.f518737b = ((String) r100).length();
            return;
        L5:
            this.f518737b = 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L15:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L15;
            if (hashCode() == r100.hashCode()) goto L16;
            return false;
        L16:
            return true;
        }
    }

    static {
        UIHelper.dp2px(10.0f);
        new Paint();
    }

    public final int hashCode() {
        return (Objects.hash(new Object[]{this.f518724a, this.f518725b, this.f518726c, Integer.valueOf(this.f518727d), Integer.valueOf(this.f518730g), Integer.valueOf(this.f518731h), this.f518732i, Integer.valueOf(this.f518733j), Integer.valueOf(this.f518734k)}) * 31) + Arrays.hashCode(this.f518735l);
    }

    public final void a(Drawable.Callback r100) {
        Drawable r101 = this.f518726c;
        if (r101 == null) goto L6;
        r101.setCallback(r100);
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f518727d == r101.f518727d) goto L11;
    L29:
        return false;
    L11:
        if (this.f518730g != r101.f518730g) goto L29;
        if (this.f518731h != r101.f518731h) goto L29;
        if (this.f518733j != r101.f518733j) goto L29;
        if (this.f518734k != r101.f518734k) goto L29;
        if (Objects.equals(this.f518724a, r101.f518724a) == false) goto L29;
        if (Objects.equals(this.f518725b, r101.f518725b) == false) goto L29;
        if (Objects.equals(this.f518726c, r101.f518726c) == false) goto L29;
        if (Objects.equals(this.f518732i, r101.f518732i) == false) goto L29;
        if (Arrays.equals(this.f518735l, r101.f518735l) == false) goto L29;
        return true;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        if (this.f518725b == null) goto L5;
    L8:
        int r105 = this.f518727d;
        if (r105 != (-1)) goto L12;
        r105 = (int) r100.getTextSize();
    L12:
        if (TextUtils.isEmpty(this.f518724a) == false) goto L16;
        return (this.f518730g + r105) + this.f518731h;
    L16:
        return (((this.f518730g + r105) + this.f518731h) + ((int) r100.measureText(this.f518724a))) + this.f518731h;
    L5:
        if (this.f518726c != null) goto L8;
        return (int) r100.measureText(this.f518724a);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r210, int r211, int r212, float r213, int r214, int r215, int r216, Paint r217) {
        int r100 = this.f518727d;
        if (r100 != (-1)) goto L5;
        r100 = (int) r217.getTextSize();
    L5:
        Rect r101 = new Rect();
        boolean r102 = false;
        r217.getTextBounds(r210.toString(), Math.max(0, r211 - 5), Math.min(r212 + 5, r210.length()), r101);
        Bitmap r103 = this.f518725b;
        if (r103 == null) goto L9;
        int r104 = r101.top;
        float r105 = ((r215 + r104) + ((r101.bottom - r104) / 2)) - (r100 / 2);
        int r106 = this.f518730g;
        float r111 = r100;
        r110.drawBitmap(r103, null, new RectF(r106 + r213, r105, (r106 + r213) + r111, r111 + r105), r217);
        int r107 = this.f518730g + r100;
        int r108 = this.f518731h;
    L8:
        int r109 = r107 + r108;
    L14:
        if (TextUtils.isEmpty(this.f518724a) == false) goto L17;
        return;
    L17:
        if (this.f518735l != null) goto L19;
        r217.setColor(this.f518733j);
        r110.drawText(this.f518724a, r109 + r213, r215, r217);
        return;
    L19:
        r217.setColor(this.f518734k);
        int r112 = this.f518724a.length();
        int r113 = r109;
        int r114 = 0;
        int r115 = 0;
    L20:
        if (r115 >= r112) goto L60;
        boolean r116 = this.f518735l[r115];
        if (r102 != r116) goto L27;
        if (r115 == (r112 - 1)) goto L27;
    L52:
        r115 = r115 + 1;
    L27:
        if (r102 == r116) goto L29;
    L32:
        if (r115 != 0) goto L39;
        if (r112 != 1) goto L39;
        if (r116 == false) goto L36;
        int r117 = this.f518733j;
    L37:
        r217.setColor(r117);
        r110.drawText(this.f518724a, r113 + r213, r215, r217);
        return;
    L36:
        r117 = this.f518734k;
    L39:
        if (r115 != 0) goto L44;
        if (r116 == false) goto L42;
        int r118 = this.f518733j;
    L43:
        r217.setColor(r118);
        r102 = r116;
        goto L52
    L42:
        r118 = this.f518734k;
        goto L43
    L44:
        float r119 = r215;
        r110.drawText(this.f518724a, r114, r115, r213 + r113, r119, r217);
        r113 = r113 + ((int) r217.measureText(this.f518724a.substring(r114, r115)));
        if (r116 == false) goto L47;
        int r120 = this.f518733j;
    L48:
        r217.setColor(r120);
        if (r115 != (r112 - 1)) goto L51;
        r110.drawText(this.f518724a, r115, r115 + 1, r213 + r113, r119, r217);
    L51:
        r114 = r115;
        r102 = r116;
        goto L52
    L47:
        r120 = this.f518734k;
        goto L48
    L29:
        if (r115 != (r112 - 1)) goto L32;
        r110.drawText(this.f518724a, r114, 1 + r115, r113 + r213, r215, r217);
        return;
    L60:
        return;
    L9:
        Drawable r121 = this.f518726c;
        if (r121 == null) goto L12;
        int r122 = r101.top;
        float r123 = ((r215 + r122) + ((r101.bottom - r122) / 2)) - (r100 / 2);
        int r124 = this.f518730g;
        int r125 = (int) r213;
        int r126 = (int) r123;
        r121.setBounds(new Rect(r124 + r125, r126, (r124 + r125) + r100, r126 + r100));
        this.f518726c.draw(r110);
        r107 = this.f518730g + r100;
        r108 = this.f518731h;
        goto L8
    L12:
        r109 = 0;
        goto L14
    }

    public e(Context r100, a r101, String r102, Bitmap r103, Drawable r104, int r105, boolean r106, int r107, int r110, int r111, int r112, int r113) {
        new WeakReference(r100);
        this.f518732i = r101;
        this.f518724a = r102;
        this.f518725b = r103;
        this.f518726c = r104;
        this.f518727d = r105;
        this.f518734k = r110;
        this.f518733j = r111;
        this.f518735l = null;
        this.f518728e = r106;
        this.f518729f = r107;
        if (r103 != null) goto L6;
        if (r104 != null) goto L6;
        return;
    L6:
        if (r112 > 0) goto L8;
        this.f518730g = UIUtils.dp2px(r100, 3.0f);
    L9:
        if (r113 > 0) goto L11;
        this.f518731h = UIUtils.dp2px(r100, 3.0f);
        return;
    L11:
        this.f518731h = r113;
        return;
    L8:
        this.f518730g = r112;
        goto L9
    }
}
