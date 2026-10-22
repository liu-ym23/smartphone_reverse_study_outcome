package com.bytedance.ee.bear.sheet.cellcontent;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.fabview.FabView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.cellcontent.view.SheetCellContentView;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.sheet.fab.FabViewModel;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class SheetCellContentPanelFragment extends BaseFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f237412l = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SheetCellContentViewModel f237413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SheetCellContentView f237414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f237415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SheetDragView f237416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f237417i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f237418j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f237419k;

    public final void V90() {
        int r100 = getResources().getColor(R.color.bg_body);
        if (TextUtils.isEmpty(this.f237413e.getBgColor()) == true) goto L5;
        r100 = ColorUtils.h(this.f237413e.getBgColor());
    L5:
        GradientDrawable r101 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, r100});
        r101.setGradientType(0);
        this.f237417i.setBackground(r101);
    }

    public SheetCellContentPanelFragment() {
    }

    public final void U90(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        LinearLayout r101 = this.f237418j;
        TextView r102 = new TextView(getContext());
        r102.setText(r100);
        r102.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_title));
        r102.setTextSize(14.0f);
        r102.setGravity(GravityCompat.START);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-1, -2);
        r103.setMargins(0, X90(8.0f), 0, X90(8.0f));
        r102.setLayoutParams(r103);
        r101.addView(r102);
    }

    public final int X90(float r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        int r101 = r100.orientation;
        if (r101 == this.f237419k) goto L6;
        this.f237419k = r101;
        this.f237413e.setActive(false);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f237413e = (SheetCellContentViewModel) q.a(this, SheetCellContentViewModel.class);
    }

    public final TextView W90(String r100, List<FormulaInputStyleData.ColoredRange> r110) {
        TextView r101 = new TextView(getContext());
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        SpannableString r102 = new SpannableString(r100);
        if (r110 == null) goto L22;
        int r103 = 0;
    L10:
        if (r103 >= r110.size()) goto L22;
        FormulaInputStyleData.ColoredRange r104 = (FormulaInputStyleData.ColoredRange) ListProtector.get(r110, r103);
        if (r104 == null) goto L21;
        if (TextUtils.isEmpty(r104.getColor()) == true) goto L21;
        int r105 = Math.max(0, r104.getStart());
        int r106 = Math.min(r100.length(), r104.getEnd());
        if (r106 <= r105) goto L21;
        r102.setSpan(new ForegroundColorSpan(Color.parseColor(r104.getColor())), r105, r106, 33);
    L21:
        r103 = r103 + 1;
    L22:
        r101.setText(r102);
        r101.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_title));
        r101.setTextSize(14.0f);
        r101.setGravity(16);
        r101.setPadding(X90(12.0f), X90(12.0f), X90(12.0f), X90(12.0f));
        r101.setMinHeight(X90(56.0f));
        GradientDrawable r107 = new GradientDrawable();
        r107.setColor(ContextCompat.getColor(requireContext(), R.color.bg_body_overlay));
        r107.setCornerRadius(X90(8.0f));
        r101.setBackground(r107);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-1, -2);
        r108.setMargins(0, 0, 0, X90(16.0f));
        r101.setLayoutParams(r108);
        return r101;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(final View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f237419k = getContext().getResources().getConfiguration().orientation;
        this.f237414f = (SheetCellContentView) r100.findViewById(R.id.cell_content_text);
        this.f237418j = (LinearLayout) r100.findViewById(R.id.formula_content_container);
        int r102 = this.f237414f.getPaddingBottom();
        if (this.f237413e.isDocAIEnabled() == false) goto L6;
        r102 = r102 + com.bytedance.ee.util.ui.n.d(28);
    L6:
        if (this.f237414f.getPaddingBottom() == r102) goto L8;
        SheetCellContentView r103 = this.f237414f;
        r103.setPadding(r103.getPaddingLeft(), this.f237414f.getPaddingTop(), this.f237414f.getPaddingRight(), r102);
    L8:
        this.f237416h = (SheetDragView) r100.findViewById(R.id.cellpanel_dragview);
        this.f237417i = (TextView) r100.findViewById(R.id.cell_content_gradient);
        if (TextUtils.isEmpty(this.f237413e.getBgColor()) == true) goto L11;
        this.f237416h.setPanelBackgroundColorByColorInt(ColorUtils.h(this.f237413e.getBgColor()));
    L11:
        V90();
        this.f237416h.setOnCloseListener(new e(this, r100));
        this.f237416h.setOnPositionChangeListener(new k(this));
        float r104 = com.bytedance.ee.util.ui.n.t() * 0.4f;
        if (this.f237413e.getMidHeight() == 0.0f) goto L14;
        r104 = com.bytedance.ee.util.ui.n.t() * this.f237413e.getMidHeight();
    L14:
        SheetDragView r105 = this.f237416h;
        float r106 = com.bytedance.ee.util.ui.n.t();
        if (this.f237413e.isVCFollow() == false) goto L17;
        float r107 = 0.6f;
    L18:
        float r108 = r106 * r107;
        r105.f237476y = 0.0f;
        r105.f237477z = r104;
        r105.A = r108;
        r105.f237475x.m(0.0f, r104, r108);
        FabView r109 = (FabView) r100.findViewById(R.id.sheet_operation_fab);
        final FabViewModel r110 = (FabViewModel) q.a(this, FabViewModel.class);
        r109.setOnClickListener(new f(this, r110));
        this.f237415g = new p(this.f237414f, this.f237413e.getOnSegmentsClickListener());
        this.f237413e.getCellData().observe(getViewLifecycleOwner(), new b(this));
        final FabViewModel r111 = (FabViewModel) q.a(this, FabViewModel.class);
        r111.getTopItems().observe(this, new c(r100, r111));
        this.f237413e.getCopyAble().observe(getViewLifecycleOwner(), new d(this));
        return;
    L17:
        r107 = 0.8f;
        goto L18
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.sheet_cell_content_fragment, r101, false);
    }
}
