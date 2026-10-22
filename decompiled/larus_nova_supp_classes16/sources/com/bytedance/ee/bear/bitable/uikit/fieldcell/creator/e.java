package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.FieldSelectModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.FieldSelectItemView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<FieldSelectModel> {
    public final int e;
    public final int f;
    public final int g;

    public static final class a implements MutilCellLayout.a {
        public final /* synthetic */ e a;
        public final /* synthetic */ Context b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.e$a$a, reason: collision with other inner class name */
        public static final class C0029a extends ColorDrawable {
            public final Paint a;
            public final float b;

            public C0029a(int r2) {
                super(r2);
                this.a = new Paint(1);
                this.b = y9c.d.a(100);
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

        @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
        public final Drawable a() {
            return new C0029a(ResourcesCompat.getColor(this.b.getResources(), 2131109109, this.b.getTheme()));
        }

        @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
        public final boolean b() {
            iv4.b r0 = this.a.a;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.a;
        }

        @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
        public final int getTextColor() {
            iv4.b r0 = this.a.a;
            if (r0 == null) goto L8;
            Integer r1 = r0.c(this.b);
            if (r1 == null) goto L8;
            return r1.intValue();
        L8:
            return ResourcesCompat.getColor(this.b.getResources(), 2131106607, this.b.getTheme());
        }

        @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout.a
        public final float getTextSize() {
            iv4.b r0 = this.a.a;
            if (r0 != null) goto L7;
            return 14.0f;
        L7:
            return r0.b;
        }

        public a(e r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.FieldSelect.getValue();
    }

    public e(iv4.b r2) {
        super(r2);
        this.e = y9c.d.a(8);
        this.f = y9c.d.a(30);
        this.g = y9c.d.a(8);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View b(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        View r6 = super.b(r4, r5);
        MutilCellLayout r0 = (MutilCellLayout) r6;
        r0.setItemSpace(this.e);
        int r1 = this.f;
        int r2 = this.g;
        r0.d = r1;
        r0.c = r2;
        r0.setMutilCellLabelStyleProvider(new a(this, r4));
        return r6;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AppCompatTextView r6 = new FieldSelectItemView(r4, null, 6, 0);
        com.bytedance.ee.bear.bitable.m.t(r6, this.e);
        r6.setPadding(this.g, y9c.d.a(4), this.g, y9c.d.a(4));
        com.bytedance.ee.bear.bitable.m.e(r6, this.f);
        r6.setMinWidth(y9c.d.a(30));
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.FieldSelectItemView] */
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r5, h0 r6) {
        FieldSelectModel r7 = (FieldSelectModel) r6;
        Intrinsics.checkNotNullParameter(r5, "kitView");
        Intrinsics.checkNotNullParameter(r7, "model");
        if ((r5 instanceof FieldSelectItemView) == false) goto L23;
        ?? r8 = (FieldSelectItemView) r5;
        a(r8, false);
        if (r7 == null) goto L25;
        r8.setText(r7.getFieldName());     // Catch: Exception -> L19
        if (r7.isError() == false) goto L10;
        r8.b.setColor(AppCompatResources.getColorStateList(r8.getContext(), 2131109097));     // Catch: Exception -> L19
        r8.setBackground(r8.b);     // Catch: Exception -> L19
        r8.setTextColor(AppCompatResources.getColorStateList(r8.getContext(), 2131109124));     // Catch: Exception -> L19
        ColorStateList r1 = AppCompatResources.getColorStateList(r8.getContext(), 2131109124);     // Catch: Exception -> L19
    L12:
        if (r7.isShowIcon() == false) goto L17;
        Drawable r9 = ContextCompat.getDrawable(r8.getContext(), r7.getFieldUIType().getIconRes());     // Catch: Exception -> L19
        if (r9 == null) goto L16;
        Drawable r10 = DrawableCompat.wrap(r9).mutate();     // Catch: Exception -> L19
        DrawableCompat.setTintList(r10, r1);     // Catch: Exception -> L19
        int r2 = y9c.d.a(14);     // Catch: Exception -> L19
        r10.setBounds(0, 0, r2, r2);     // Catch: Exception -> L19
        r8.setCompoundDrawablesRelative(r10, null, null, null);     // Catch: Exception -> L19
    L16:
        r8.setCompoundDrawablePadding(y9c.d.a(4));     // Catch: Exception -> L19
        return;
    L17:
        r8.setCompoundDrawablesRelative(null, null, null, null);     // Catch: Exception -> L19
        r8.setCompoundDrawablePadding(0);     // Catch: Exception -> L19
        return;
    L10:
        r8.b.setColor(AppCompatResources.getColorStateList(r8.getContext(), 2131109109));     // Catch: Exception -> L19
        r8.setBackground(r8.b);     // Catch: Exception -> L19
        r8.setTextColor(AppCompatResources.getColorStateList(r8.getContext(), 2131106622));     // Catch: Exception -> L19
        r1 = AppCompatResources.getColorStateList(r8.getContext(), 2131102419);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        tt5.a.e("SelectTextView", "parse color failed!", e, false);
        return;
    L25:
        return;
    }
}
