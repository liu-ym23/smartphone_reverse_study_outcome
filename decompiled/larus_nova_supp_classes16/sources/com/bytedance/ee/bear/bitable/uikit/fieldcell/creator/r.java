package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTagView;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.CapsuleModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.SelectItemView;
import com.bytedance.ee.util.ui.ColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class r extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<CapsuleModel> {

    public static final class a extends ColorDrawable {
        public final Paint a;
        public final /* synthetic */ r b;

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas r5) {
            Intrinsics.checkNotNullParameter(r5, "canvas");
            this.a.setColor(getColor());
            RectF r0 = new RectF();
            r0.set(getBounds());
            r5.drawRoundRect(r0, this.b.i(), this.b.i(), this.a);
        }

        public a(r r1, int r2) {
            this.b = r1;
            super(r2);
            this.a = new Paint(1);
        }
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.MutilSELECT.getValue();
    }

    public float i() {
        return com.bytedance.ee.util.ui.n.d(100);
    }

    public r(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public Drawable e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new a(this, ResourcesCompat.getColor(r3.getResources(), 2131109109, r3.getTheme()));
    }

    public View h(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        SelectItemView r0 = new SelectItemView(r5, null, 6, 0);
        com.bytedance.ee.bear.bitable.m.t(r0, com.bytedance.ee.util.ui.n.d(6));
        r0.setPadding(com.bytedance.ee.util.ui.n.d(10), com.bytedance.ee.util.ui.n.d(0), com.bytedance.ee.util.ui.n.d(10), com.bytedance.ee.util.ui.n.d(0));
        com.bytedance.ee.bear.bitable.m.e(r0, com.bytedance.ee.util.ui.n.d(24));
        return r0;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public void a(TextView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        iv4.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        r0.b(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        int r3 = ht4.b.a;
        getType();
        return h(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r4, h0 r5) {
        CapsuleModel r6 = (CapsuleModel) r5;
        Intrinsics.checkNotNullParameter(r4, "kitView");
        Intrinsics.checkNotNullParameter(r6, "model");
        String r1 = "";
        if ((r4 instanceof SelectTagView) == false) goto L14;
        TextView r7 = (SelectTagView) r4;
        a(r7, true);
        if (r6 == null) goto L10;
        r7.getClass();
        String r0 = r6.getText();
        if (r0 == null) goto L10;
        r1 = r0;
    L10:
        r7.setTextSimple(r1);
        if (r6 == null) goto L37;
        r7.Q(r6.getCapsuleColor(), r6.getTextColor());
        r7.S(r6.getBorderColor());
        return;
    L37:
        return;
    L14:
        if ((r4 instanceof SelectItemView) == false) goto L39;
        SelectItemView r8 = (SelectItemView) r4;
        a(r8, true);
        if (r6 == null) goto L20;
        r8.getClass();
        String r2 = r6.getText();
        if (r2 == null) goto L20;
        r1 = r2;
    L20:
        r8.setText(r1);
        if (r6 == null) goto L40;
        String r3 = r6.getCapsuleColor();
        String r9 = r6.getTextColor();
        if (r3 != null) goto L35;
    L30:
        if (r9 == null) goto L41;
        r8.setTextColor(ColorUtils.h(r9));     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        tt5.a.e("SelectTextView", "parse color failed!", e, false);
        return;
    L41:
        return;
    L35:
        GradientDrawable r10 = r8.b;     // Catch: Exception -> L28
        if (r10 == null) goto L27;
        r10.setColor(ColorUtils.h(r3));     // Catch: Exception -> L28
    L27:
        r8.setBackground(r8.b);     // Catch: Exception -> L28
        goto L30
    L40:
        return;
    }
}
