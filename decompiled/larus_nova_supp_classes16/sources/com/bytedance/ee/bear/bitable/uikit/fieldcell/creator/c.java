package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.CheckboxModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class c extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<CheckboxModel> {

    public static final class a extends ColorDrawable {
        public final Paint a;
        public final float b;

        public a(int r2) {
            super(r2);
            this.a = new Paint(1);
            this.b = com.bytedance.ee.util.ui.n.d(4);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas r4) {
            Intrinsics.checkNotNullParameter(r4, "canvas");
            this.a.setColor(getColor());
            RectF r0 = new RectF();
            r0.set(getBounds());
            float r1 = this.b;
            r4.drawRoundRect(r0, r1, r1, this.a);
        }
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.CHECKBOX.getValue();
    }

    public c(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final Drawable e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new a(ResourcesCompat.getColor(r3.getResources(), 2131109109, r3.getTheme()));
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = ht4.b.a;
        getType();
        View r5 = LayoutInflater.from(r3).inflate(2131558906, r4, false);
        r5.setPadding(0, 0, 0, 0);
        return r5;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r2, h0 r3) {
        CheckboxModel r4 = (CheckboxModel) r3;
        Intrinsics.checkNotNullParameter(r2, "kitView");
        Intrinsics.checkNotNullParameter(r4, "model");
        if ((r2 instanceof AppCompatCheckBox) == false) goto L6;
        ((AppCompatCheckBox) r2).setChecked(r4.getChecked());
        return;
    }
}
