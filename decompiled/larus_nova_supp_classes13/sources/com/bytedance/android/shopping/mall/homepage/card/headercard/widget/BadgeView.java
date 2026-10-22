package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import if3.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/BadgeView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "mode", "", "setMode", "getMode", "color", "setBadgeColor", "count", "setCount", "padding", "setHorizontalPadding", "", "useDefault", "setUseDefaultDraw", "maxNumber", "setMaxNumberInCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "Mode", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BadgeView extends AppCompatTextView {
    public static final /* synthetic */ int p = 0;
    public int a;
    public int b;
    public boolean c;
    public int d;
    public CharSequence e;
    public boolean f;
    public final int g;
    public final int h;
    public final float i;
    public int j;
    public final Rect k;
    public int l;
    public final int m;
    public Animator n;
    public Animator o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/BadgeView$Mode;", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Mode {
    }

    public static final class a {
    }

    static {
    }

    public BadgeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BadgeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
        setVisibility(0);
        if (this.b == 3) goto L5;
        return;
    L5:
        if (this.c == false) goto L12;
        Animator r0 = this.n;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.1f, 0.8f, 1.4f, 1.1f, 1.0f});
        r1.setDuration(600);
        r1.setInterpolator(new AccelerateDecelerateInterpolator());
        r1.addUpdateListener(new if3.a(this));
        r1.addListener(new b(this, this));
        Unit r2 = Unit.INSTANCE;
        this.n = r1;
        r1.start();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        int r0 = this.b;
        if (r0 != 2) goto L5;
    L8:
        int r1 = this.l;
        int r2 = r1;
    L9:
        int r3 = this.m;
        super/*android.widget.TextView*/.setPadding(r1, r3, r2, r3);
        return;
    L5:
        if (r0 == 3) goto L8;
        r1 = 0;
        r2 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        int r0 = this.b;
        if (r0 != 2) goto L5;
    L7:
        Integer r1 = Integer.valueOf(this.h);
        int r2 = c.a;
        int r3 = c.c(r1, getContext(), true);
        int r4 = getMeasuredWidth();
        if (r4 >= r3) goto L10;
    L9:
        r4 = r3;
    L10:
        setMeasuredDimension(r4, r3);
        int r5 = getMeasuredHeight();
        if (this.d == r5) goto L14;
        this.d = r5;
        z(r5, this.a);
        return;
    L14:
        return;
    L5:
        if (r0 == 3) goto L7;
        Integer r6 = Integer.valueOf(this.g);
        int r7 = c.a;
        r3 = c.c(r6, getContext(), true);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        setVisibility(8);
        Animator r0 = this.n;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.n = null;
        Animator r1 = this.o;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.o = null;
    }

    public final int getMode() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (this.f == false) goto L5;
        super/*android.widget.TextView*/.onDraw(r8);
        return;
    L5:
        getPaint().setTextAlign(Paint.Align.LEFT);
        getPaint().setColor(getCurrentTextColor());
        r8.getClipBounds(this.k);
        int r0 = this.k.height();
        int r1 = this.k.width();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), this.k);
        float r2 = this.k.width() / 2.0f;
        String r4 = getText().toString();
        if (this.b == 2) goto L8;
    L10:
        float r3 = (r1 / 2.0f) - r2;
        Rect r5 = this.k;
        r8.drawText(r4, r3 - r5.left, ((r0 / 2.0f) + (r5.height() / 2.0f)) - this.k.bottom, getPaint());
        return;
    L8:
        if (Intrinsics.areEqual(r4, "1") == false) goto L10;
        r2 = (this.k.width() / 2.0f) + (this.k.width() / 4.0f);
        goto L10
    }

    public final void setBadgeColor(int r2) {
        if (r2 != this.a) goto L5;
        return;
    L5:
        this.a = r2;
        z(this.d, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCount(int r1) {
        setText(String.valueOf(r1));
    }

    public final void setHorizontalPadding(int r2) {
        if (this.l == r2) goto L6;
        this.l = r2;
        A();
        return;
    }

    public final void setMaxNumberInCount(int r1) {
        this.j = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMode(int r3) {
        if (this.b != r3) goto L5;
        return;
    L5:
        this.b = r3;
        CharSequence r4 = getText();
        int r0 = this.b;
        if (r0 != 2) goto L8;
    L10:
        boolean r1 = false;
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L25;
        CharSequence r6 = this.e;
        if (r6 != null) goto L21;
    L22:
        r1 = true;
    L23:
        if (r1 == true) goto L25;
        setText(this.e);
        goto L25
    L21:
        if (r6.length() != 0) goto L23;
    L25:
        A();
        x();
        return;
    L13:
        if (r4.length() == 0) goto L16;
        r5 = false;
        goto L17
    L8:
        if (r0 == 3) goto L10;
        this.e = r4;
        setText("");
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setUseDefaultDraw(boolean r1) {
        this.f = r1;
        invalidate();
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r4, TextView.BufferType r5) {
        Intrinsics.checkNotNullParameter(r4, "inText");
        if (this.b == 2) goto L5;
    L17:
        this.e = r4;
        if (this.b == 3) goto L20;
    L19:
        r4 = "";
    L20:
        super/*android.widget.TextView*/.setText(r4, r5);
        return;
    L5:
        if (r4.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L17;
        int r1 = CastIntegerProtector.valueOf(r4.toString()).intValue();     // Catch: Exception -> L15
        if (r1 <= this.j) goto L13;
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L15
        r6.append(this.j);     // Catch: Exception -> L15
        r6.append('+');     // Catch: Exception -> L15
        r4 = r6.toString();     // Catch: Exception -> L15
    L13:
        if (r1 >= 0) goto L20;
    L16:
        throw new IllegalArgumentException("Excepted a int but get " + getText());
    L7:
        r0 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextSize(int r2, float r3) {
        Float r4 = Float.valueOf(this.i);
        int r5 = c.a;
        super.setTextSize(0, c.c(r4, getContext(), true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(int r4, int r5) {
        float r6 = r4 / 2;
        Drawable r7 = DrawableCompat.wrap(new ShapeDrawable(new RoundRectShape(new float[]{r6, r6, r6, r6, r6, r6, r6, r6}, null, null)));
        DrawableCompat.setTint(r7, r5);
        setBackground(r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BadgeView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.b = -1;
        this.f = true;
        this.g = 7;
        this.h = 14;
        this.i = 10.0f;
        this.j = 99;
        this.k = new Rect();
        int r1 = c.a;
        this.l = c.c(4, getContext(), true);
        this.m = c.c(1, getContext(), true);
        this.a = ContextCompat.getColor(r3, 2131106126);
        setMode(1);
        setTextSize(0, c.c(Float.valueOf(10.0f), getContext(), true));
        setTextColor(ContextCompat.getColor(r3, 2131106130));
        setGravity(17);
        setClickable(false);
        setIncludeFontPadding(false);
        setSingleLine();
    }

    public /* synthetic */ BadgeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void setPadding(int r1, int r2, int r3, int r4) {
        A();
    }
}
