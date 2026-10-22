package com.bytedance.ee.bear.fabview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FabView extends FrameLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public String e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabType {
        public static final int TYPE_IMAGE = 0;
        public static final int TYPE_MULTIPLE = 2;
        public static final int TYPE_TEXT = 1;
    }

    public FabView(Context r2) {
        this(r2, null);
    }

    private void setColor(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.d <= 0) goto L10;
        Drawable r4 = r3.getBackground();
        if ((r4 instanceof GradientDrawable) == false) goto L11;
        int r0 = getContext().getResources().getColor(this.d);
        GradientDrawable r1 = (GradientDrawable) r4;
        r4.mutate();
        r1.setColor(r0);
        r1.setStroke(n.d(1), r0);
        return;
    L11:
        return;
    }

    public final void b(Context r4) {
        LayoutInflater r5 = LayoutInflater.from(r4);
        removeAllViews();
        int r0 = this.a;
        if (r0 != 0) goto L5;
        r5.inflate(2131564550, this);
    L12:
        int r1 = 0;
    L14:
        if (r1 >= getChildCount()) goto L16;
        a(getChildAt(r1), isEnabled());
        r1 = r1 + 1;
        goto L14
    L16:
        setColor(getChildAt(0));
        ImageView r6 = (ImageView) findViewById(2131372040);
        if (r6 == null) goto L21;
        r6.setImageResource(this.b);
        if (this.c <= 0) goto L21;
        r6.setColorFilter(getContext().getResources().getColor(this.c));
    L21:
        TextView r7 = (TextView) findViewById(2131372041);
        if (r7 == null) goto L26;
        r7.setText(this.e);
        return;
    L26:
        return;
    L5:
        if (r0 != 1) goto L7;
        r5.inflate(2131564552, this);
        goto L12
    L7:
        if (r0 != 2) goto L12;
        r5.inflate(2131564551, this);
        goto L12
    }

    public void setColorRes(int r1) {
        this.d = r1;
    }

    public void setImageRes(int r1) {
        this.b = r1;
    }

    public void setImageTintRes(int r1) {
        this.c = r1;
    }

    public void setTextRes(String r1) {
        this.e = r1;
    }

    public void setType(int r1) {
        this.a = r1;
    }

    public FabView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static void a(View r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.setEnabled(r3);
        if ((r2 instanceof ViewGroup) == false) goto L12;
        ViewGroup r4 = (ViewGroup) r2;
        if (r4.getChildCount() <= 0) goto L14;
        int r0 = 0;
    L10:
        if (r0 >= r4.getChildCount()) goto L15;
        a(r4.getChildAt(r0), r3);
        r0 = r0 + 1;
        goto L10
    L15:
        return;
    L14:
        return;
    }

    public FabView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        if (r3 == null) goto L5;
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130970022, 2130970027, 2130970028, 2130970030, 2130970031});
        this.a = r5.getInteger(4, 0);
        this.b = r5.getResourceId(1, 0);
        this.c = r5.getResourceId(2, 0);
        this.e = r5.getString(3);
        this.d = r5.getResourceId(0, 2131100557);
        r5.recycle();
    L5:
        int r6 = n.d(6);
        setPadding(r6, r6, r6, r6);
        setClipToPadding(false);
        b(r2);
    }
}
