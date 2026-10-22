package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a0 extends hp4.g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f208119m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public q f208120n;

    public interface a {
        void a();

        void b();
    }

    @Override // hp4.g
    public final boolean u() {
        return !com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.option.panel.only.trans.bar.disable");
    }

    @Override // hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        super.show();
        Window r100 = this.f486398b.getWindow();
        if (r100 == null) goto L5;
        r100.setBackgroundDrawableResource(R.color.bg_mask);
        r100.setWindowAnimations(0);
    L5:
        q r101 = this.f208120n;
        if (r101 == null) goto L9;
        r101.J0(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_MORE_VIEW);
        return;
    }

    @Override // hp4.g
    public final View q(Context r100) {
        return this.f486399c;
    }

    public a0(Context r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "titleContent");
        Intrinsics.checkNotNullParameter(r102, "titleColor");
        Intrinsics.checkNotNullParameter(r103, "titleBackgroundColor");
        super(r100);
        View r105 = LayoutInflater.from(r100).inflate(R.layout.bitable_card_option_more_operation_panel, null);
        this.f486399c = r105;
        ((CellEditDragView) r105.findViewById(R.id.panel)).getTopBar().setVisibility(8);
        ((ImageView) r105.findViewById(R.id.closeIcon)).setOnClickListener(new b0(this));
        SelectTextView r106 = (SelectTextView) r105.findViewById(R.id.titleView);
        r106.setText(r101);
        r106.Q(r103, r102);
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L13;
        Intrinsics.checkNotNullParameter(r106, "titleView");
        BaseTagSize r107 = BaseTagSize.LARGE;
        r106.setTextSize(r107.getTextSizeSp());
        r106.R(r107.getRadiusPx());
        r106.setPadding(com.bytedance.ee.util.ui.n.d(r107.getTextPaddingHorizontalDp()), r106.getPaddingTop(), com.bytedance.ee.util.ui.n.d(r107.getTextPaddingHorizontalDp()), r106.getPaddingBottom());
        BaseTagSize.Companion.getClass();
        int r108 = BaseTagSize.a.a(r104);
        if (r108 == 0) goto L9;
        GradientDrawable r109 = r106.getMBackgroundDrawable();
        if (r109 == null) goto L12;
        r109.setStroke(r107.getStrokeWidthPx(), r108);
    L12:
        r106.setBackground(r106.getMBackgroundDrawable());
        goto L13
    L9:
        GradientDrawable r110 = r106.getMBackgroundDrawable();
        if (r110 == null) goto L12;
        r110.setStroke(0, 0);
    L13:
        ((RoundFrameLayout) r105.findViewById(R.id.modifyItem)).setOnClickListener(new c0(this));
        ((RoundFrameLayout) r105.findViewById(R.id.deleteItem)).setOnClickListener(new d0(this));
    }
}
