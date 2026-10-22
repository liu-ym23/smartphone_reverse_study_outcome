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
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class r extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<CapsuleModel> {

    public static final class a extends ColorDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f216187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f216188b;

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            this.f216187a.setColor(getColor());
            RectF r101 = new RectF();
            r101.set(getBounds());
            r100.drawRoundRect(r101, this.f216188b.i(), this.f216188b.i(), this.f216187a);
        }

        public a(r r100, int r101) {
            this.f216188b = r100;
            super(r101);
            this.f216187a = new Paint(1);
        }
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.MutilSELECT.getValue();
    }

    public float i() {
        return com.bytedance.ee.util.ui.n.d(100);
    }

    public r(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public Drawable e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new a(this, ResourcesCompat.getColor(r100.getResources(), R.color.udtoken_tag_neutral_bg_normal, r100.getTheme()));
    }

    public View h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SelectItemView r101 = new SelectItemView(r100, null, 6, 0);
        com.bytedance.ee.bear.bitable.m.t(r101, com.bytedance.ee.util.ui.n.d(6));
        r101.setPadding(com.bytedance.ee.util.ui.n.d(10), com.bytedance.ee.util.ui.n.d(0), com.bytedance.ee.util.ui.n.d(10), com.bytedance.ee.util.ui.n.d(0));
        com.bytedance.ee.bear.bitable.m.e(r101, com.bytedance.ee.util.ui.n.d(24));
        return r101;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public void a(TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        iv4.b r102 = this.f216158a;
        if (r102 == null) goto L6;
        r102.a(r100);
        r102.b(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        return h(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r100, h0 r101) {
        CapsuleModel r102 = (CapsuleModel) r101;
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String r103 = "";
        if ((r100 instanceof SelectTagView) == false) goto L14;
        SelectTagView r104 = (SelectTagView) r100;
        a(r104, true);
        if (r102 == null) goto L10;
        r104.getClass();
        String r105 = r102.getText();
        if (r105 == null) goto L10;
        r103 = r105;
    L10:
        r104.setTextSimple(r103);
        if (r102 == null) goto L37;
        r104.Q(r102.getCapsuleColor(), r102.getTextColor());
        r104.S(r102.getBorderColor());
        return;
    L37:
        return;
    L14:
        if ((r100 instanceof SelectItemView) == false) goto L39;
        SelectItemView r106 = (SelectItemView) r100;
        a(r106, true);
        if (r102 == null) goto L20;
        r106.getClass();
        String r107 = r102.getText();
        if (r107 == null) goto L20;
        r103 = r107;
    L20:
        r106.setText(r103);
        if (r102 == null) goto L40;
        String r108 = r102.getCapsuleColor();
        String r109 = r102.getTextColor();
        if (r108 != null) goto L35;
    L30:
        if (r109 == null) goto L41;
        r106.setTextColor(ColorUtils.h(r109));     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        tt5.a.e("SelectTextView", "parse color failed!", e, false);
        return;
    L41:
        return;
    L35:
        GradientDrawable r110 = r106.f216202b;     // Catch: Exception -> L28
        if (r110 == null) goto L27;
        r110.setColor(ColorUtils.h(r108));     // Catch: Exception -> L28
    L27:
        r106.setBackground(r106.f216202b);     // Catch: Exception -> L28
        goto L30
    L40:
        return;
    }
}
