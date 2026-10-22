package com.bytedance.android.uicomponent.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/uicomponent/button/UIButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/graphics/Rect;", "d", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "bounds", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UIButton extends AppCompatTextView {
    public final float a;
    public final int b;
    public final int c;
    public final Rect d;

    public static final class a {
    }

    static {
    }

    public UIButton(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UIButton(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final Rect getBounds() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UIButton(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.d = new Rect();
        TypedArray r10 = r7.obtainStyledAttributes(r8, new int[]{2130974700, 2130974701, 2130974713, 2130974714, 2130974715, 2130974716, 2130974717, 2130974718});
        int r1 = r10.getInt(0, 1);
        if (r1 != 0) goto L5;
        this.a = e.a(r7, 2.0f);
        this.b = getResources().getDimensionPixelSize(2131169448);
        this.c = getResources().getDimensionPixelSize(2131169448);
    L15:
        Drawable r11 = r10.getDrawable(4);
        Drawable r0 = null;
        if (r11 == null) goto L18;
        r11.setBounds(0, 0, this.b, this.c);
    L19:
        Drawable r2 = r10.getDrawable(6);
        if (r2 == null) goto L22;
        r2.setBounds(0, 0, this.b, this.c);
    L23:
        Drawable r3 = r10.getDrawable(5);
        if (r3 == null) goto L26;
        r3.setBounds(0, 0, this.b, this.c);
    L27:
        Drawable r4 = r10.getDrawable(2);
        if (r4 == null) goto L30;
        r4.setBounds(0, 0, this.b, this.c);
        r0 = r4;
    L30:
        setCompoundDrawables(r11, r2, r3, r0);
        setCompoundDrawablePadding((int) this.a);
        r10.recycle();
        return;
    L26:
        r3 = null;
        goto L27
    L22:
        r2 = null;
        goto L23
    L18:
        r11 = null;
        goto L19
    L5:
        if (r1 != 1) goto L7;
        this.a = e.a(r7, 4.0f);
        this.b = getResources().getDimensionPixelSize(2131169447);
        this.c = getResources().getDimensionPixelSize(2131169447);
        goto L15
    L7:
        if (r1 != 2) goto L9;
        this.a = e.a(r7, 4.0f);
        this.b = getResources().getDimensionPixelSize(2131169446);
        this.c = getResources().getDimensionPixelSize(2131169446);
        goto L15
    L9:
        if (r1 == 3) goto L11;
        this.a = e.a(r7, 4.0f);
        this.b = getResources().getDimensionPixelSize(2131169446);
        this.c = getResources().getDimensionPixelSize(2131169446);
        goto L15
    L11:
        this.a = e.a(r7, 4.0f);
        this.b = getResources().getDimensionPixelSize(2131169445);
        this.c = getResources().getDimensionPixelSize(2131169445);
        goto L15
    }

    public /* synthetic */ UIButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), this.d);
        int r8 = (int) ((((double) getWidth()) / 2.0d) - (((double) ((this.b + this.a) + this.d.width())) / 2.0d));
        setCompoundDrawablePadding((int) ((-r8) + this.a));
        boolean r9 = true;
        if (getCompoundDrawables()[0] == null) goto L5;
        boolean r10 = true;
    L7:
        if (getCompoundDrawables()[2] != null) goto L10;
        r9 = false;
    L10:
        if (r10 == false) goto L13;
        if (r9 == false) goto L13;
        setPadding(r8, getPaddingTop(), r8, getPaddingBottom());
        return;
    L13:
        if (r10 == false) goto L15;
        setPadding(r8, getPaddingTop(), 0, getPaddingBottom());
        return;
    L15:
        if (r9 == false) goto L17;
        setPadding(0, getPaddingTop(), r8, getPaddingBottom());
        return;
    L17:
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        return;
    L5:
        r10 = false;
        goto L7
    }
}
