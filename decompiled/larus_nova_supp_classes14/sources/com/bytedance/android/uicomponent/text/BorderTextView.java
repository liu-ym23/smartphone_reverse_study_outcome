package com.bytedance.android.uicomponent.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import fm3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/uicomponent/text/BorderTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BorderTextView extends AppCompatTextView {
    public final Paint a;
    public final int b;
    public final float c;
    public final float d;

    public static final class a {
    }

    static {
    }

    public BorderTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BorderTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super/*android.widget.TextView*/.onDraw(r11);
        this.a.setColor(this.b);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.c);
        float r5 = getWidth();
        float r6 = getHeight();
        float r8 = this.d;
        r11.drawRoundRect(0.0f, 0.0f, r5, r6, r8, r8, this.a);
    }

    public BorderTextView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = new Paint();
        int r7 = (int) 4278190080L;
        this.b = r7;
        float r0 = e.a(r4, 1.0f);
        this.c = r0;
        float r1 = e.a(r4, 8.0f);
        this.d = r1;
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130969028, 2130969029, 2130969032});
        this.b = r8.getColor(0, r7);
        this.c = r8.getDimension(2, r0);
        this.d = r8.getDimension(1, r1);
        r8.recycle();
    }

    public /* synthetic */ BorderTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
