package qj3;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends LinearLayout {
    public static final int d = 0;
    public ImageView a;
    public TextView b;
    public ImageView c;

    public static final class a {
    }

    static {
        d = com.bytedance.android.shopping.extensions.b.b(12);
    }

    public final ImageView getLeftImage() {
        return this.a;
    }

    public final ImageView getRightImage() {
        return this.c;
    }

    public final TextView getTextView() {
        return this.b;
    }

    public c(Context r9) {
        int r0 = com.bytedance.android.shopping.extensions.b.b(44);
        int r1 = com.bytedance.android.shopping.extensions.b.b(8);
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9);
        setGravity(17);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ImageView r2 = new ImageView(r9);
        ViewGroup.LayoutParams r3 = new LinearLayout.LayoutParams(r0, r1);
        r2.setImageResource(2131234802);
        r2.setAdjustViewBounds(true);
        addView(r2, r3);
        Unit r4 = Unit.INSTANCE;
        this.a = r2;
        TextView r5 = new TextView(r9);
        r5.setTypeface(Typeface.DEFAULT_BOLD);
        r5.setTextColor(-15329245);
        r5.setTextSize(2, 15.0f);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
        int r7 = d;
        r6.leftMargin = r7;
        r6.rightMargin = r7;
        addView(r5, r6);
        this.b = r5;
        ImageView r8 = new ImageView(r9);
        r8.setScaleX(-1.0f);
        r8.setImageResource(2131234802);
        r8.setAdjustViewBounds(true);
        addView(r8, new LinearLayout.LayoutParams(r0, r1));
        this.c = r8;
    }

    public final void setLeftImage(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setRightImage(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setTextView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}
