package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.util.ui.n;
import h18.e;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eJ\u0015\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0015J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010&\u001a\u0004\u0018\u00010'R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/custom/WikiSpaceIconView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mPaint", "Landroid/graphics/Paint;", "mTextString", "", "mTintColor", "Ljava/lang/Integer;", "mBitmapWidth", "mBitmapHeight", "setTextString", "", "textString", "setTintColor", "tintColor", "(Ljava/lang/Integer;)V", "setBitmapWidth", "width", "setBitmapHeight", "height", "getTextSize", "", "getBorderRadius", "onDraw", "canvas", "Landroid/graphics/Canvas;", "isEmojiCharacter", "", "text", "createBitmap", "Landroid/graphics/Bitmap;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceIconView extends View {
    public static final float f = 0.0f;
    public static final float g = 0.0f;
    public static final float h = 0.0f;
    public static final float i = 0.0f;
    public final Paint a;
    public String b;
    public Integer c;
    public int d;
    public int e;

    public static final class a {
    }

    public WikiSpaceIconView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public WikiSpaceIconView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public WikiSpaceIconView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    static {
        f = n.d(1);
        g = n.d(8);
        h = n.d(32);
        i = n.G(18);
    }

    private final float getBorderRadius() {
        return (g * this.d) / h;
    }

    private final float getTextSize() {
        return (i * this.d) / h;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        super.onDraw(r7);
        Integer r0 = this.c;
        if (r0 == null) goto L5;
        this.a.setColor(getContext().getResources().getColor(r0.intValue()));
        this.a.setStyle(Paint.Style.STROKE);
        Paint r1 = this.a;
        float r2 = f;
        r1.setStrokeWidth(r2);
        this.a.setAntiAlias(true);
        r7.drawRoundRect(new RectF(r2, r2, this.d - r2, this.e - r2), getBorderRadius(), getBorderRadius(), this.a);
    L5:
        this.a.setColor(getContext().getResources().getColor(2131100557));
        this.a.setStyle(Paint.Style.FILL);
        this.a.setAntiAlias(true);
        float r3 = f;
        r7.drawRoundRect(new RectF(r3, r3, this.d - r3, this.e - r3), getBorderRadius(), getBorderRadius(), this.a);
        String r4 = this.b;
        boolean r5 = false;
        if (r4 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == true) goto L22;
        int r8 = 0;
    L16:
        if (r8 >= r4.length()) goto L22;
        if (yu5.a.b(r4.charAt(r8)) == true) goto L19;
        r8 = r8 + 1;
        goto L16
    L19:
        r5 = true;
    L22:
        if (r5 == true) goto L29;
        String r9 = this.b;
        if (r9 == null) goto L38;
        String r10 = r9.toUpperCase(Locale.ROOT);
        Integer r11 = this.c;
        if (r11 == null) goto L28;
        this.a.setColor(getContext().getResources().getColor(r11.intValue()));
    L28:
        this.a.setStyle(Paint.Style.FILL);
        this.a.setTextSize(getTextSize());
        Paint r12 = this.a;
        int r13 = e.a;
        r12.setTypeface(e.b(getContext(), 1));
        Paint.FontMetrics r14 = this.a.getFontMetrics();
        float r15 = 2;
        r7.drawText(r10, (this.d - this.a.measureText(r10)) / r15, (this.e / 2) - ((r14.descent + r14.ascent) / r15), this.a);
        return;
    L38:
        return;
    L29:
        String r16 = this.b;
        if (r16 == null) goto L40;
        Integer r17 = this.c;
        if (r17 == null) goto L34;
        this.a.setColor(getContext().getResources().getColor(r17.intValue()));
    L34:
        this.a.setStyle(Paint.Style.FILL);
        this.a.setTextSize(getTextSize());
        Paint r18 = this.a;
        int r19 = e.a;
        r18.setTypeface(e.b(getContext(), 1));
        Paint.FontMetrics r20 = this.a.getFontMetrics();
        float r21 = 2;
        r7.drawText(r16, (this.d - this.a.measureText(r16)) / r21, (this.e / 2) - ((r20.ascent + r20.descent) / r21), this.a);
        return;
    L40:
        return;
    L8:
        if (r4.length() == 0) goto L11;
        r6 = false;
        goto L12
    }

    public final void setBitmapHeight(int r1) {
        this.e = r1;
    }

    public final void setBitmapWidth(int r1) {
        this.d = r1;
    }

    public final void setTextString(String r1) {
        this.b = r1;
    }

    public final void setTintColor(Integer r1) {
        this.c = r1;
    }

    public WikiSpaceIconView(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        this.a = new Paint();
    }
}
