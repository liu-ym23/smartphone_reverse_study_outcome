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
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class c extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<CheckboxModel> {

    public static final class a extends ColorDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f216172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f216173b;

        public a(int r100) {
            super(r100);
            this.f216172a = new Paint(1);
            this.f216173b = com.bytedance.ee.util.ui.n.d(4);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            this.f216172a.setColor(getColor());
            RectF r101 = new RectF();
            r101.set(getBounds());
            float r102 = this.f216173b;
            r100.drawRoundRect(r101, r102, r102, this.f216172a);
        }
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.CHECKBOX.getValue();
    }

    public c(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final Drawable e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new a(ResourcesCompat.getColor(r100.getResources(), R.color.udtoken_tag_neutral_bg_normal, r100.getTheme()));
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        View r103 = LayoutInflater.from(r100).inflate(R.layout.bitable_cell_checkbox_view, r101, false);
        r103.setPadding(0, 0, 0, 0);
        return r103;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r100, h0 r101) {
        CheckboxModel r102 = (CheckboxModel) r101;
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof AppCompatCheckBox) == false) goto L6;
        ((AppCompatCheckBox) r100).setChecked(r102.getChecked());
        return;
    }
}
