package com.bytedance.android.uicomponent.popover;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010v\u001a\u00020u¢\u0006\u0004\bw\u0010xB\u001b\b\u0016\u0012\u0006\u0010v\u001a\u00020u\u0012\b\u0010z\u001a\u0004\u0018\u00010y¢\u0006\u0004\bw\u0010{B#\b\u0016\u0012\u0006\u0010v\u001a\u00020u\u0012\b\u0010z\u001a\u0004\u0018\u00010y\u0012\u0006\u0010|\u001a\u00020\u0002¢\u0006\u0004\bw\u0010}J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\"\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\"\u00102\u001a\u00020\u001b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010<\u001a\u0004\bO\u0010>\"\u0004\bP\u0010@R\"\u0010U\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010\r\u001a\u0004\bS\u0010\u000f\"\u0004\bT\u0010\u0011R\"\u0010Y\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010<\u001a\u0004\bW\u0010>\"\u0004\bX\u0010@R\"\u0010`\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010[\u001a\u0004\bb\u0010]\"\u0004\bc\u0010_R\"\u0010h\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010[\u001a\u0004\bf\u0010]\"\u0004\bg\u0010_R\"\u0010l\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010[\u001a\u0004\bj\u0010]\"\u0004\bk\u0010_R\"\u0010p\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010[\u001a\u0004\bn\u0010]\"\u0004\bo\u0010_R\"\u0010t\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010[\u001a\u0004\br\u0010]\"\u0004\bs\u0010_¨\u0006~"}, d2 = {"Lcom/bytedance/android/uicomponent/popover/PopLayout;", "Landroid/widget/LinearLayout;", "", "bubbleOrientation", "", "setBubbleOrientation", "", "getBubbleOffset", "getPADDING", "", "need", "setNeedAddColor", "a", "F", "getMPadding", "()F", "setMPadding", "(F)V", "mPadding", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getMFillPaint", "()Landroid/graphics/Paint;", "setMFillPaint", "(Landroid/graphics/Paint;)V", "mFillPaint", "Landroid/graphics/Path;", "c", "Landroid/graphics/Path;", "getMPath", "()Landroid/graphics/Path;", "setMPath", "(Landroid/graphics/Path;)V", "mPath", "d", "getMBubbleArrowPath", "setMBubbleArrowPath", "mBubbleArrowPath", "f", "getMWidth", "setMWidth", "mWidth", "g", "getMHeight", "setMHeight", "mHeight", "h", "getMBorderBubbleArrowPath", "setMBorderBubbleArrowPath", "mBorderBubbleArrowPath", "Landroid/graphics/RectF;", "i", "Landroid/graphics/RectF;", "getMBorderRoundRect", "()Landroid/graphics/RectF;", "setMBorderRoundRect", "(Landroid/graphics/RectF;)V", "mBorderRoundRect", "j", "I", "getMBorderWidth", "()I", "setMBorderWidth", "(I)V", "mBorderWidth", "Landroid/graphics/Matrix;", "k", "Landroid/graphics/Matrix;", "getMBorderMatrix", "()Landroid/graphics/Matrix;", "setMBorderMatrix", "(Landroid/graphics/Matrix;)V", "mBorderMatrix", "n", "getMBgColor", "setMBgColor", "mBgColor", "o", "getMBorderColor", "setMBorderColor", "mBorderColor", "p", "getMCornerRadius", "setMCornerRadius", "mCornerRadius", "q", "getMShadowColor", "setMShadowColor", "mShadowColor", "r", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "(Z)V", "mNeedShadow", "u", "getMNeedPath", "setMNeedPath", "mNeedPath", "v", "getMNeedPressFade", "setMNeedPressFade", "mNeedPressFade", "w", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "x", "getMNeedAddColor", "setMNeedAddColor", "mNeedAddColor", "y", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PopLayout extends LinearLayout {
    public static int A;
    public static float B;
    public static float C;
    public static int D;
    public static int E;
    public static int z;
    public float a;
    public Paint b;
    public Path c;
    public Path d;
    public RectF e;
    public float f;
    public float g;
    public Path h;
    public RectF i;
    public int j;
    public Matrix k;
    public Bitmap l;
    public Canvas m;
    public int n;
    public int o;
    public float p;
    public int q;
    public boolean r;
    public float s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;

    public static final class a {
    }

    static {
    }

    public final float getBubbleOffset() {
        float r0 = Math.max(this.s, C);
        int r1 = this.t;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r0, this.f - C);
    L18:
        return Math.min(r0, this.g - C);
    L19:
        return Math.min(r0, this.g - C);
    L15:
        return Math.min(r0, this.f - C);
    }

    public final Path getMBorderBubbleArrowPath() {
        Path r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L5:
        return r0;
    }

    public final Matrix getMBorderMatrix() {
        Matrix r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L5:
        return r0;
    }

    public final RectF getMBorderRoundRect() {
        RectF r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L5:
        return r0;
    }

    public final Path getMBubbleArrowPath() {
        Path r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L5:
        return r0;
    }

    public final Paint getMFillPaint() {
        Paint r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        return r0;
    }

    public final Path getMPath() {
        Path r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L5:
        return r0;
    }

    public final int getPADDING() {
        return z / 2;
    }

    public final int getMBgColor() {
        return this.n;
    }

    public final int getMBorderColor() {
        return this.o;
    }

    public final int getMBorderWidth() {
        return this.j;
    }

    public final float getMCornerRadius() {
        return this.p;
    }

    public final float getMHeight() {
        return this.g;
    }

    public final boolean getMNeedAddColor() {
        return this.x;
    }

    public final boolean getMNeedArrow() {
        return this.w;
    }

    public final boolean getMNeedPath() {
        return this.u;
    }

    public final boolean getMNeedPressFade() {
        return this.v;
    }

    public final boolean getMNeedShadow() {
        return this.r;
    }

    public final float getMPadding() {
        return this.a;
    }

    public final int getMShadowColor() {
        return this.q;
    }

    public final float getMWidth() {
        return this.f;
    }

    public final boolean getUseDefaultView() {
        return this.y;
    }

    public PopLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r15) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        if (this.l != null) goto L5;
        Bitmap r0 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.l = r0;
        this.m = new Canvas(r0);
    L5:
        float r1 = this.f;
        float r2 = this.g;
        float r3 = Math.max(this.s, C);
        Matrix r4 = new Matrix();
        this.k = new Matrix();
        int r5 = this.t;
        if (r5 != 0) goto L8;
        float r6 = Math.min(r3, r1 - C);
        r4.postRotate(90.0f);
        Matrix r7 = this.k;
        if (r7 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L33:
        r7.postRotate(90.0f);
        Matrix r8 = this.k;
        if (r8 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L36:
        int r9 = this.j;
        r8.postTranslate((((r9 * 3) / 2) + r6) - ((z * 3) / 2), r9 + 0.0f);
        setPadding(0, z, 0, 0);
        setGravity(17);
        this.e = new RectF(0.0f, z, this.f, this.g);
        float r10 = (this.j * 3) / 2;
        r4.postTranslate((r6 + r10) - ((z * 3) / 2), r10 + 0.0f);
    L37:
        RectF r11 = this.e;
        if (r11 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L40:
        r11.left += (this.j * 3) / 2;
        RectF r12 = this.e;
        if (r12 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L43:
        r12.top += (this.j * 3) / 2;
        RectF r13 = this.e;
        if (r13 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L46:
        r13.right += (this.j * 3) / 2;
        RectF r14 = this.e;
        if (r14 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L49:
        r14.bottom += (this.j * 3) / 2;
        float r16 = z - e.a(getContext(), 1.4f);
        float r17 = z - e.a(getContext(), 1.3f);
        RectF r18 = this.e;
        if (r18 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L52:
        r18.left += r16;
        RectF r19 = this.e;
        if (r19 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L55:
        r19.top += r17;
        RectF r20 = this.e;
        if (r20 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L58:
        r20.right += r16;
        RectF r21 = this.e;
        if (r21 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L61:
        r21.bottom += r17;
        r4.postTranslate(r16, r17);
        Matrix r22 = this.k;
        if (r22 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L64:
        r22.postTranslate(r16, r17);
        RectF r23 = new RectF();
        this.i = r23;
        RectF r24 = this.e;
        if (r24 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L67:
        r23.left = r24.left - (this.j / 2);
        RectF r25 = this.i;
        if (r25 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L70:
        RectF r26 = this.e;
        if (r26 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L73:
        r25.top = r26.top - (this.j / 2);
        RectF r27 = this.i;
        if (r27 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L76:
        RectF r28 = this.e;
        if (r28 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L79:
        r27.right = r28.right + (this.j / 2);
        RectF r29 = this.i;
        if (r29 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L82:
        RectF r30 = this.e;
        if (r30 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L85:
        r29.bottom = r30.bottom + (this.j / 2);
        if (this.r == false) goto L92;
        Paint r31 = this.b;
        if (r31 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L90:
        r31.setShadowLayer(16.0f, 0.0f, 0.0f, this.q);
    L92:
        if (this.u == false) goto L171;
        Paint r32 = this.b;
        if (r32 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L96:
        r32.setColor(this.o);
        Paint r33 = this.b;
        if (r33 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L99:
        r33.setStyle(Paint.Style.STROKE);
        Paint r34 = this.b;
        if (r34 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L102:
        r34.setStrokeWidth(this.j);
        Path r35 = this.c;
        if (r35 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L105:
        r35.reset();
        Path r36 = this.c;
        if (r36 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L108:
        RectF r110 = this.i;
        if (r110 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L111:
        float r111 = this.p;
        int r112 = this.j;
        r36.addRoundRect(r110, (r112 / 2) + r111, r111 + (r112 / 2), Path.Direction.CW);
        if (this.w == false) goto L123;
        Path r37 = this.c;
        if (r37 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L116:
        Path r113 = this.h;
        if (r113 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L119:
        Matrix r114 = this.k;
        if (r114 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L122:
        r37.addPath(r113, r114);
    L123:
        Canvas r38 = this.m;
        if (r38 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L126:
        Path r115 = this.c;
        if (r115 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L129:
        Paint r116 = this.b;
        if (r116 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L132:
        r38.drawPath(r115, r116);
        if (this.x == false) goto L171;
        Paint r39 = this.b;
        if (r39 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L137:
        r39.setColor(getResources().getColor(2131108348));
        Paint r40 = this.b;
        if (r40 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L140:
        r40.setStyle(Paint.Style.STROKE);
        Path r41 = this.c;
        if (r41 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L143:
        r41.reset();
        if (this.w == false) goto L155;
        Path r42 = this.c;
        if (r42 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L148:
        Path r117 = this.h;
        if (r117 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L151:
        Matrix r118 = this.k;
        if (r118 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L154:
        r42.addPath(r117, r118);
    L155:
        Path r43 = this.c;
        if (r43 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L158:
        RectF r44 = this.i;
        if (r44 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderRoundRect");
    L161:
        float r45 = this.p;
        int r119 = this.j;
        r43.addRoundRect(r44, (r119 / 2) + r45, r45 + (r119 / 2), Path.Direction.CW);
        Canvas r46 = this.m;
        if (r46 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L164:
        Path r47 = this.c;
        if (r47 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L167:
        Paint r48 = this.b;
        if (r48 != null) goto L170;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L170:
        r46.drawPath(r47, r48);
    L171:
        Paint r49 = this.b;
        if (r49 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L174:
        r49.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        Paint r50 = this.b;
        if (r50 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L177:
        r50.setColor(this.n);
        Paint r51 = this.b;
        if (r51 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L180:
        r51.setStyle(Paint.Style.FILL);
        Path r52 = this.c;
        if (r52 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L183:
        r52.reset();
        Path r53 = this.c;
        if (r53 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L186:
        RectF r54 = this.e;
        if (r54 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L189:
        float r55 = this.p;
        r53.addRoundRect(r54, r55, r55, Path.Direction.CW);
        if (this.w == false) goto L198;
        Path r56 = this.c;
        if (r56 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L194:
        Path r57 = this.d;
        if (r57 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L197:
        r56.addPath(r57, r4);
    L198:
        Canvas r58 = this.m;
        if (r58 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L201:
        Path r59 = this.c;
        if (r59 != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L204:
        Paint r60 = this.b;
        if (r60 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L207:
        r58.drawPath(r59, r60);
        Paint r61 = this.b;
        if (r61 != null) goto L210;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L210:
        r61.setXfermode(null);
        Bitmap r62 = this.l;
        if (r62 == null) goto L214;
        r15.drawBitmap(r62, 0.0f, 0.0f, null);
        return;
    L214:
        return;
    L8:
        if (r5 == 1) goto L26;
        if (r5 == 2) goto L19;
        if (r5 != 3) goto L37;
        float r63 = Math.min(r3, r1 - C);
        r4.postRotate(270.0f);
        Matrix r64 = this.k;
        if (r64 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L15:
        r64.postRotate(270.0f);
        Matrix r65 = this.k;
        if (r65 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L18:
        int r66 = this.j;
        r65.postTranslate((((r66 * 3) / 2) + r63) - ((z * 3) / 2), (r66 * 2) + r2);
        setPadding(0, 0, 0, z);
        setGravity(17);
        this.e = new RectF(0.0f, 0.0f, this.f, this.g - z);
        float r67 = (this.j * 3) / 2;
        r4.postTranslate((r63 + r67) - ((z * 3) / 2), r2 + r67);
        goto L37
    L19:
        float r68 = Math.min(r3, r2 - C);
        r4.postRotate(180.0f);
        Matrix r69 = this.k;
        if (r69 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L22:
        r69.postRotate(180.0f);
        Matrix r70 = this.k;
        if (r70 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L25:
        float r71 = this.j * 2;
        r70.postTranslate(r71 + r1, (r71 + r68) - ((z * 3) / 2));
        setPadding(0, 0, z, 0);
        setGravity(17);
        this.e = new RectF(0.0f, 0.0f, this.f - z, this.g);
        int r72 = this.j;
        r4.postTranslate(r1 + ((r72 * 3) / 2), (r68 + (r72 * 2)) - ((z * 3) / 2));
        goto L37
    L26:
        float r73 = Math.min(r3, r2 - C);
        setPadding(z, 0, 0, 0);
        setGravity(17);
        Matrix r74 = this.k;
        if (r74 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderMatrix");
    L29:
        int r75 = this.j;
        r74.postTranslate(r75 + 0.0f, ((r75 * 2) + r73) - ((z * 3) / 2));
        this.e = new RectF(z, 0.0f, this.f, this.g);
        int r76 = this.j;
        r4.postTranslate(((r76 * 3) / 2) + 0.0f, (r73 + (r76 * 2)) - ((z * 3) / 2));
        goto L37
    }

    public final void setBubbleOrientation(int r1) {
        this.t = r1;
    }

    public final void setMBgColor(int r1) {
        this.n = r1;
    }

    public final void setMBorderBubbleArrowPath(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setMBorderColor(int r1) {
        this.o = r1;
    }

    public final void setMBorderMatrix(Matrix r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setMBorderRoundRect(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setMBorderWidth(int r1) {
        this.j = r1;
    }

    public final void setMBubbleArrowPath(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setMCornerRadius(float r1) {
        this.p = r1;
    }

    public final void setMFillPaint(Paint r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMHeight(float r1) {
        this.g = r1;
    }

    public final void setMNeedAddColor(boolean r1) {
        this.x = r1;
    }

    public final void setMNeedArrow(boolean r1) {
        this.w = r1;
    }

    public final void setMNeedPath(boolean r1) {
        this.u = r1;
    }

    public final void setMNeedPressFade(boolean r1) {
        this.v = r1;
    }

    public final void setMNeedShadow(boolean r1) {
        this.r = r1;
    }

    public final void setMPadding(float r1) {
        this.a = r1;
    }

    public final void setMPath(Path r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMShadowColor(int r1) {
        this.q = r1;
    }

    public final void setMWidth(float r1) {
        this.f = r1;
    }

    public final void setNeedAddColor(boolean r1) {
        this.x = r1;
    }

    public final void setUseDefaultView(boolean r1) {
        this.y = r1;
    }

    public PopLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r19, int r20) {
        super.onMeasure(r19, r20);
        A = (int) (e.a(getContext(), 5.0f) + this.a);
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r2 = getChildAt(0);
        if (r2 == null) goto L8;
        TextView r3 = (TextView) r2;
    L10:
        int r4 = View.MeasureSpec.getMode(r19);
        int r5 = View.MeasureSpec.getSize(r19);
        int r6 = View.MeasureSpec.getMode(r20);
        int r7 = View.MeasureSpec.getSize(r20);
        if (r3 != null) goto L13;
        int r10 = getMeasuredWidth();
        char r8 = 0;
    L28:
        if (this.y == false) goto L49;
        int r1 = this.t;
        if (r1 == 2) goto L36;
        if (r1 == 1) goto L36;
        int r9 = D;
        if (r10 <= r9) goto L40;
        r9 = (A * 2) + r10;
    L40:
        if (r3 == null) goto L42;
        int r11 = ((int) e.a(getContext(), r3.getTextSize() - (this.j * 2))) + (getContext().getResources().getDimensionPixelSize(2131169483) * 2);
    L43:
        if (r8 != 2) goto L50;
        Context r12 = getContext();
        if (r3 == null) goto L47;
        float r13 = r3.getTextSize();
    L48:
        r11 = r11 + ((int) e.a(r12, r13));
        goto L50
    L47:
        r13 = 0.0f;
    L50:
        int r14 = this.j;
        int r15 = r9 + (r14 * 3);
        int r16 = r11 + (r14 * 3);
        if (r4 != Integer.MIN_VALUE) goto L54;
        if (r6 != Integer.MIN_VALUE) goto L54;
        setMeasuredDimension(r15, r16);
    L58:
        this.f = getMeasuredWidth() - (z * 2);
        this.g = getMeasuredHeight() - (z * 2);
        return;
    L54:
        if (r4 != Integer.MIN_VALUE) goto L56;
        setMeasuredDimension(r15, r7);
        goto L58
    L56:
        if (r6 != Integer.MIN_VALUE) goto L58;
        setMeasuredDimension(r5, r16);
        goto L58
    L42:
        r11 = E;
    L36:
        int r17 = D;
        if (r10 <= r17) goto L39;
        r17 = (A * 2) + r10;
    L39:
        r9 = r17 + z;
        goto L40
    L49:
        PopupWindow r18 = new PopupWindow(getChildAt(0), -2, -2, true);
        r18.getContentView().measure(0, 0);
        r9 = (r18.getContentView().getMeasuredWidth() + (z * 3)) + A;
        r11 = (r18.getContentView().getMeasuredHeight() + (z * 3)) + A;
        goto L50
    L13:
        if (((int) r3.getPaint().measureText(r3.getText().toString())) <= e.a(getContext(), 220.0f)) goto L24;
        int r110 = (int) e.a(getContext(), 220.0f);
        String r111 = r3.getText().toString();
        if (StringsKt.contains$default(r111, "\n", false, 2, null) == false) goto L23;
        TextPaint r21 = r3.getPaint();
        int r112 = StringsKt.indexOf$default(r111, "\n", 0, false, 6, null);
        if (r111 == null) goto L22;
        int r22 = (int) r21.measureText(r111.substring(0, r112));
        if (r22 >= r110) goto L23;
        r110 = r22;
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L23:
        r8 = 2;
    L25:
        r10 = (r110 + r3.getPaddingLeft()) + r3.getPaddingRight();
        goto L28
    L24:
        r110 = (int) r3.getPaint().measureText(r3.getText().toString());
        r8 = 1;
        goto L25
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r3 = null;
        goto L10
    }

    public PopLayout(Context r18, AttributeSet r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        this.a = 12.0f;
        this.q = -16777216;
        this.s = 0.75f;
        this.t = 1;
        this.u = true;
        this.w = true;
        this.y = true;
        Intrinsics.checkNotNullParameter(r18, "context");
        this.j = (int) e.a(r18, 1.0f);
        z = (int) e.a(r18, 7.0f);
        B = 2.0f;
        this.p = e.a(r18, 8.0f);
        C = e.a(r18, 3.0f);
        D = (int) e.a(r18, 40.0f);
        E = (int) e.a(r18, 56.0f);
        this.b = new Paint();
        this.c = new Path();
        this.h = new Path();
        this.d = new Path();
        Paint r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        r1.setStyle(Paint.Style.FILL);
        Paint r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r2.setStrokeCap(Paint.Cap.BUTT);
        Paint r3 = this.b;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r3.setAntiAlias(true);
        Paint r4 = this.b;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L14:
        r4.setStrokeWidth(B);
        Paint r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L17:
        r5.setStrokeJoin(Paint.Join.MITER);
        this.n = getResources().getColor(2131108344);
        this.o = getResources().getColor(2131108344);
        Paint r6 = this.b;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L20:
        r6.setColor(this.n);
        Paint r7 = this.b;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L23:
        setLayerType(1, r7);
        if (this.r == false) goto L29;
        Paint r8 = this.b;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L28:
        r8.setShadowLayer(16.0f, 0.0f, 0.0f, this.q);
    L29:
        float r9 = e.a(getContext(), 2.0f);
        double r10 = 2.0f;
        float r11 = r9 / ((float) Math.sqrt(r10));
        Path r12 = this.d;
        if (r12 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L32:
        r12.moveTo(r11, -r11);
        Path r13 = this.d;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L35:
        int r14 = z;
        r13.lineTo(r14, -r14);
        Path r15 = this.d;
        if (r15 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L38:
        float r16 = z;
        r15.lineTo(r16, r16);
        Path r17 = this.d;
        if (r17 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L41:
        r17.lineTo(r11, r11);
        Path r21 = this.d;
        if (r21 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L44:
        float r110 = 2;
        float r22 = r11 * r110;
        r21.arcTo(new RectF(r22 - r9, -r9, r22 + r9, r9), 135.0f, 90.0f, true);
        Path r23 = this.d;
        if (r23 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L47:
        r23.close();
        float r24 = e.a(getContext(), 2.0f) + this.j;
        float r25 = r24 / ((float) Math.sqrt(r10));
        Path r26 = this.h;
        if (r26 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L50:
        r26.moveTo(r25, -r25);
        Path r27 = this.h;
        if (r27 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L53:
        r27.lineTo((float) (((double) z) + (((double) this.j) * Math.sqrt(2.0d))), (float) (((double) (-z)) - (((double) this.j) * Math.sqrt(2.0d))));
        Path r28 = this.h;
        if (r28 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L56:
        r28.lineTo((float) (((double) z) + (((double) this.j) * Math.sqrt(2.0d))), (float) (((double) z) + (((double) this.j) * Math.sqrt(2.0d))));
        Path r29 = this.h;
        if (r29 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L59:
        r29.lineTo(r25, r25);
        Path r30 = this.h;
        if (r30 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L62:
        float r111 = r110 * r25;
        r30.arcTo(new RectF(r111 - r24, -r24, r111 + r24, r24), 135.0f, 90.0f, true);
        Path r31 = this.h;
        if (r31 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mBorderBubbleArrowPath");
    L65:
        r31.close();
        setBackgroundColor(0);
        setClipChildren(false);
    }
}
