package com.bytedance.android.window.shop.innerflow.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECExpandableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "", "setTextInner", "Landroid/graphics/Bitmap;", "getBitmapFixedHeight", "f", "Landroid/graphics/Bitmap;", "getBitmapCache", "()Landroid/graphics/Bitmap;", "setBitmapCache", "(Landroid/graphics/Bitmap;)V", "bitmapCache", "Lkotlin/Function0;", "g", "Lkotlin/jvm/functions/Function0;", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECExpandableTextView extends AppCompatTextView {
    public final int a;
    public boolean b;
    public final String c;
    public final String d;
    public CharSequence e;
    public Bitmap f;
    public Function0<Unit> g;
    public final c h;
    public final d i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ECExpandableTextView a;

        public a(ECExpandableTextView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            int r0 = rp.a.a;
            if (rp.a.a(r2.getId()) == false) goto L5;
            return;
        L5:
            ECExpandableTextView r3 = this.a;
            if (r3.b == false) goto L9;
            r3.y();
            return;
        }
    }

    public static final class b {
    }

    public static final class c extends ClickableSpan {
        public final /* synthetic */ ECExpandableTextView a;

        public c(ECExpandableTextView r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            ECExpandableTextView r3 = this.a;
            r3.b = false;
            ECExpandableTextView.x(r3, r3.e);
            Function0<Unit> r4 = this.a.getClickCallback();
            if (r4 == null) goto L6;
            Unit r5 = (Unit) r4.invoke();
            return;
        }
    }

    public static final class d extends ImageSpan {
        public d(Context r2, Bitmap r3) {
            super(r2, r3, 0);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
            Intrinsics.checkNotNullParameter(r2, "paint");
            int r7 = super.getSize(r2, r3, r4, r5, r6);
            if (r6 == null) goto L5;
            r6.top = 0;
            r6.bottom = 0;
            r6.ascent = 0;
            r6.descent = 0;
        L5:
            return r7;
        }
    }

    static {
    }

    public final void y() {
        this.b = false;
        setTextInner(this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bitmap getBitmapFixedHeight() {
        int r0 = com.bytedance.android.shopping.extensions.b.b(32);
        int r1 = com.bytedance.android.shopping.extensions.b.b(20);
        BitmapFactory.Options r2 = new BitmapFactory.Options();
        r2.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap r3 = BitmapFactory.decodeResource(getResources(), 2131234713, r2);
        float r4 = r3.getHeight() / r1;
        if (r4 >= 0.9f) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L10;
        return r3;
    L10:
        return Bitmap.createScaledBitmap(r3, r0, r1, false);
    L5:
        if (r4 > 1.1f) goto L7;
        r5 = true;
        goto L8
    }

    public final Bitmap getBitmapCache() {
        return this.f;
    }

    public final Function0<Unit> getClickCallback() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setTextInner(CharSequence r2) {
        super/*android.widget.TextView*/.setText(r2, TextView.BufferType.NORMAL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super/*android.widget.TextView*/.onDraw(r9);
        if (getLayout().getEllipsisCount(getLayout().getLineCount() - 1) <= 0) goto L5;
        boolean r10 = true;
    L7:
        if (getLayout().getLineCount() <= this.a) goto L9;
        boolean r2 = true;
    L10:
        if (r10 == true) goto L14;
        if (r2 == true) goto L14;
        boolean r11 = false;
    L16:
        if (this.b == false) goto L31;
        if (r11 == false) goto L32;
        CharSequence r12 = getLayout().getText();
        int r3 = getLayout().getLineEnd(this.a - 1);
        CharSequence r4 = r12.subSequence(getLayout().getLineStart(this.a - 1), r3);
        float r5 = getPaint().measureText(r4, 0, r4.length()) - (getPaint().measureText(this.c + this.d) + getLayout().getSpacingAdd());
        if (r5 > 0) goto L21;
        CharSequence r13 = r12.subSequence(0, r3);
    L27:
        SpannableStringBuilder r14 = new SpannableStringBuilder().append(StringsKt.trimEnd(r13)).append(this.c).append(this.d);
        r14.setSpan(this.i, r14.length() - this.d.length(), r14.length(), 33);
        r14.setSpan(this.h, r14.length() - this.d.length(), r14.length(), 33);
        setMovementMethod(LinkMovementMethod.getInstance());
        setTextInner(r14);
        return;
    L21:
        int r6 = r4.length() - 1;
        int r7 = 1;
    L22:
        if (r6 <= 0) goto L26;
        if (getPaint().measureText(r4, 0, r6) < r5) goto L26;
        r7 = r7 + 1;
        r6 = r4.length() - r7;
    L26:
        r13 = r12.subSequence(0, (r3 - r7) - 1);
        goto L27
    L32:
        return;
    L31:
        return;
    L14:
        r11 = true;
        goto L16
    L9:
        r2 = false;
        goto L10
    L5:
        r10 = false;
        goto L7
    }

    public final void setBitmapCache(Bitmap r1) {
        this.f = r1;
    }

    public final void setClickCallback(Function0<Unit> r1) {
        this.g = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECExpandableTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = 2;
        this.b = true;
        this.c = "... ";
        this.d = "  ";
        this.h = new c(this);
        this.i = new d(r2, getBitmapFixedHeight());
        if (Build.VERSION.SDK_INT < 23) goto L5;
        setBreakStrategy(0);
    L5:
        setOnClickListener(new a(this));
    }

    public static final /* synthetic */ void x(ECExpandableTextView r0, CharSequence r1) {
        r0.setTextInner(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        this.e = r1;
        super/*android.widget.TextView*/.setText(r1, r2);
    }
}
