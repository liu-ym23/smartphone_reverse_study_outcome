package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b<M extends h0> {
    public iv4.b a;
    public MutilCellLayout b;
    public ViewGroup c;
    public boolean d;

    public static final class a extends ColorDrawable {
        public final Paint a;

        public a(int r2) {
            super(r2);
            this.a = new Paint(1);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas r5) {
            Intrinsics.checkNotNullParameter(r5, "canvas");
            this.a.setColor(getColor());
            RectF r0 = new RectF();
            r0.set(getBounds());
            r5.drawRoundRect(r0, getBounds().height() / 2, getBounds().height() / 2, this.a);
        }
    }

    public abstract View c(Context r1, ViewGroup r2);

    public iv4.a d() {
        return null;
    }

    public abstract void f(View r1, M r2);

    public abstract String getType();

    public b(iv4.b r1) {
        this.a = r1;
        this.d = true;
    }

    public Drawable e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new a(ResourcesCompat.getColor(r3.getResources(), 2131109109, r3.getTheme()));
    }

    public void g(List<? extends M> r10) {
        MutilCellLayout r0 = this.b;
        if (r0 == null) goto L33;
        List<? extends M> r1 = r10;
        int r2 = 0;
        if (r1 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        r0.removeAllViews();
        return;
    L14:
        int r4 = r10.size();
        int r5 = r0.getChildCount();
        if (r4 <= r5) goto L23;
        int r6 = r4 - r5;
        int r7 = 0;
    L17:
        if (r7 >= r6) goto L25;
        View r8 = c(r0.getContext(), r0);
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 != null) goto L21;
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -2);
    L22:
        r8.setLayoutParams(r11);
        r0.addView(r8);
        r7 = r7 + 1;
        goto L17
    L21:
        r11 = new LinearLayout.LayoutParams(r9);
    L25:
        if (r2 >= r4) goto L41;
        if (r2 < r10.size()) goto L29;
    L31:
        tt5.a.h("NATIVE_VIEW_TAG", "error path. index:" + r2 + ", newCount:" + r4 + ", oldCount:" + r5);
    L32:
        r2 = r2 + 1;
        goto L25
    L29:
        if (r2 >= r0.getChildCount()) goto L31;
        f(r0.getChildAt(r2), (h0) ListProtector.get(r10, r2));
        goto L32
    L41:
        return;
    L23:
        if (r4 >= r5) goto L25;
        r0.removeViews(r4, r5 - r4);
        goto L25
    L7:
        if (r1.isEmpty() == true) goto L10;
        r3 = false;
        goto L11
    }

    public void a(TextView r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "textView");
        if (this.d == true) goto L5;
        return;
    L5:
        iv4.b r0 = this.a;
        if (r0 == null) goto L12;
        r0.a(r4);
        Intrinsics.checkNotNullParameter(r4, "view");
        r4.setMaxLines(r0.c);
        Intrinsics.checkNotNullParameter(r4, "view");
        Integer r1 = r0.c(r4.getContext());
        if (r1 == null) goto L10;
        r4.setTextColor(r1.intValue());
    L10:
        r0.b(r4, r5);
        return;
    }

    public View b(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        MutilCellLayout r4 = new MutilCellLayout(r2);
        r4.setMutilCellLabelStyleProvider(new com.bytedance.ee.bear.bitable.uikit.fieldcell.a(this, r2));
        iv4.a r5 = d();
        if (r5 == null) goto L5;
        int r0 = r5.a;
        int r6 = r5.b;
        r4.d = r0;
        r4.c = r6;
    L5:
        this.b = r4;
        return r4;
    }
}
