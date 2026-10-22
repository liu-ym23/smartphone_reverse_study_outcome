package hj3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.shopping.store.mall.follows.ThemeStatus;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends FrameLayout {
    public final AttributeSet a;
    public final ThemeStatus b;

    public final AttributeSet getAttrs() {
        return this.a;
    }

    public final ThemeStatus getStatus() {
        return this.b;
    }

    public d(Context r6, ThemeStatus r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "status");
        ViewGroup.LayoutParams r0 = null;
        super(r6, null, 0);
        this.a = null;
        this.b = r7;
        LayoutInflater.from(getContext()).inflate(2131560866, this);
        View r9 = findViewById(2131367837);
        ImageView r2 = (ImageView) findViewById(2131386873);
        View r3 = findViewById(2131386874);
        GenericDraweeHierarchy r4 = findViewById(2131367838).getHierarchy();
        if (r8 == false) goto L5;
        int r10 = 2131234795;
    L6:
        r4.setPlaceholderImage(r10);
        int r11 = c.a[r7.ordinal()];
        if (r11 != 1) goto L9;
    L41:
        ViewGroup.LayoutParams r12 = r2.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == true) goto L44;
        r12 = null;
    L44:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 == null) goto L47;
        r13.topMargin = 0;
    L47:
        ViewGroup.LayoutParams r14 = r9.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L51;
        r0 = r14;
    L51:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L59;
        r1.topMargin = com.bytedance.android.shopping.extensions.b.b(72);
        return;
    L59:
        return;
    L9:
        if (r11 == 2) goto L41;
        if (r11 != 3) goto L13;
        r2.setImageResource(2131234797);
        ViewGroup.LayoutParams r15 = r2.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == true) goto L31;
        r15 = null;
    L31:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (r16 == null) goto L34;
        r16.topMargin = 0;
    L34:
        ViewGroup.LayoutParams r17 = r9.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        r0 = r17;
    L38:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r0;
        if (r5 == null) goto L57;
        r5.topMargin = com.bytedance.android.shopping.extensions.b.b(72);
        return;
    L57:
        return;
    L13:
        if (r11 != 4) goto L60;
        ViewGroup.LayoutParams r18 = r2.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L18;
        r18 = null;
    L18:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L21;
        r19.topMargin = com.bytedance.android.shopping.extensions.b.b(12);
    L21:
        r3.setBackgroundResource(2131247719);
        ViewGroup.LayoutParams r20 = r9.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        r0 = r20;
    L25:
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r0;
        if (r21 == null) goto L55;
        r21.topMargin = com.bytedance.android.shopping.extensions.b.b(84);
        return;
    L55:
        return;
    L60:
        return;
    L5:
        r10 = 2131234794;
        goto L6
    }
}
