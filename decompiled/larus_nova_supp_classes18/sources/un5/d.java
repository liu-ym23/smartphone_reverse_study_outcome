package un5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends ImageSpan implements i {
    public final Context a;
    public int b;
    public String c;
    public boolean d;
    public int e;
    public int f;
    public Drawable g;
    public final String h;
    public final TextView i;
    public final a j;

    public interface a {
    }

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    @Override // un5.i
    public final /* synthetic */ int F() {
        throw null;
    }

    public final void a() {
        if (TextUtils.isEmpty(this.h) == false) goto L5;
        return;
    L5:
        Boolean r1 = Boolean.FALSE;
        obb.a r0 = new obb.a(r1, r1, null);
        r0.b(IconScene.DOCUMENT);
        int r2 = this.f;
        if (r2 == (-1)) goto L9;
        r0.d = Integer.valueOf(r2);
    L12:
        boolean r3 = mbb.c.a;
        mbb.c.a(this.c, this.b, this.h, IconShape.SQUARE_OUTLINE, r0).subscribe(new b(this), new c());
        return;
    L9:
        if (this.d == false) goto L11;
        r0.d = 2131103454;
        goto L12
    L11:
        r0.d = 2131101111;
        goto L12
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        Drawable r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.getDrawable();
    }

    public Context getContext() {
        return this.a;
    }

    public int getType() {
        return this.b;
    }

    public d(Context r3) {
        super(r3, 2131235929);
        ColorMatrix r0 = new ColorMatrix();
        this.e = -1;
        this.f = -1;
        this.a = r3;
        this.b = 0;
        this.c = "";
        r0.setSaturation(0.0f);
    }

    public d(Context r5, int r6, int r7, String r8) {
        super(r5.getDrawable(r6));
        ColorMatrix r9 = new ColorMatrix();
        this.e = -1;
        this.f = -1;
        getDrawable().setBounds(0, 0, n.d(14), n.d(14));
        this.a = r5;
        this.b = r7;
        this.c = r8;
        r9.setSaturation(0.0f);
    }

    public d(Context r5, Drawable r6, int r7, String r8) {
        super(r6);
        ColorMatrix r0 = new ColorMatrix();
        this.e = -1;
        this.f = -1;
        r6.setBounds(0, 0, n.d(14), n.d(14));
        this.a = r5;
        this.b = r7;
        this.c = r8;
        r0.setSaturation(0.0f);
    }

    public d(Context r8, TextView r9, String r10, int r11, String r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
        Rect r8 = getDrawable().getBounds();
        if (r7 == null) goto L9;
        Paint.FontMetricsInt r9 = r3.getFontMetricsInt();
        if (kac.a.a() == false) goto L7;
        int r10 = (r9.ascent + r9.descent) / 2;
        int r11 = r8.height() / 2;
        int r0 = Math.min(r9.ascent, r10 - r11);
        r7.ascent = r0;
        r7.top = r0;
        int r12 = Math.max(r9.descent, r10 + r11);
        r7.descent = r12;
        r7.bottom = r12;
        goto L9
    L7:
        int r13 = r9.bottom - r9.top;
        int r14 = (r8.bottom - r8.top) / 2;
        int r15 = r13 / 4;
        int r16 = r14 - r15;
        int r17 = -(r14 + r15);
        r7.ascent = r17;
        r7.top = r17;
        r7.bottom = r16;
        r7.descent = r16;
    L9:
        return r8.right + this.a.getResources().getDimensionPixelSize(2131165832);
    }

    public d(Context r3, TextView r4, String r5, int r6, String r7, a r8) {
        super(AppCompatResources.getDrawable(r3, ua5.a.i(r6)));
        ColorMatrix r0 = new ColorMatrix();
        this.e = -1;
        this.f = -1;
        this.a = r3;
        this.j = r8;
        this.b = r6;
        this.c = r7;
        r0.setSaturation(0.0f);
        this.h = r5;
        this.i = r4;
        a();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r2, CharSequence r3, int r4, int r5, float r6, int r7, int r8, int r9, Paint r10) {
        Drawable r11 = getDrawable();
        r2.save();
        if (this.g == null) goto L5;
    L11:
        r2.saveLayer(null, r10, 31);
        if (kac.a.a() == false) goto L14;
        Paint.FontMetricsInt r12 = r10.getFontMetricsInt();
        int r13 = (r8 + ((r12.ascent + r12.descent) / 2)) - (r11.getBounds().height() / 2);
    L15:
        r2.translate(r6 + (this.a.getResources().getDimensionPixelSize(2131165832) / 2), r13);
        r11.draw(r2);
        r2.restore();
        return;
    L14:
        r13 = (((r9 - r7) - r11.getBounds().bottom) / 2) + r7;
        goto L15
    L5:
        if (this.e == (-1)) goto L8;
        r10.setColorFilter(new PorterDuffColorFilter(this.e, PorterDuff.Mode.SRC_IN));
        goto L11
    L8:
        if (this.d == false) goto L10;
        r10.setColorFilter(new PorterDuffColorFilter(this.a.getResources().getColor(2131103454), PorterDuff.Mode.SRC_IN));
        goto L11
    L10:
        r10.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(this.a, 2131106616), PorterDuff.Mode.SRC_IN));
        goto L11
    }
}
