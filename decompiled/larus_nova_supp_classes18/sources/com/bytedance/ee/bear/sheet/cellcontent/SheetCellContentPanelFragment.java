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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.fabview.FabView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.cellcontent.view.SheetCellContentView;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.sheet.fab.FabViewModel;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetCellContentPanelFragment extends BaseFragment {
    public static final /* synthetic */ int l = 0;
    public SheetCellContentViewModel e;
    public SheetCellContentView f;
    public p g;
    public SheetDragView h;
    public TextView i;
    public LinearLayout j;
    public int k;

    public final void V90() {
        int r0 = getResources().getColor(2131100548);
        if (TextUtils.isEmpty(this.e.getBgColor()) == true) goto L5;
        r0 = ColorUtils.h(this.e.getBgColor());
    L5:
        GradientDrawable r1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, r0});
        r1.setGradientType(0);
        this.i.setBackground(r1);
    }

    public SheetCellContentPanelFragment() {
    }

    public final void U90(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        LinearLayout r0 = this.j;
        TextView r1 = new TextView(getContext());
        r1.setText(r6);
        r1.setTextColor(ContextCompat.getColor(requireContext(), 2131106622));
        r1.setTextSize(14.0f);
        r1.setGravity(8388611);
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, -2);
        r7.setMargins(0, X90(8.0f), 0, X90(8.0f));
        r1.setLayoutParams(r7);
        r0.addView(r1);
    }

    public final int X90(float r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        int r3 = r2.orientation;
        if (r3 == this.k) goto L6;
        this.k = r3;
        this.e.setActive(false);
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.e = q.a(this, SheetCellContentViewModel.class);
    }

    public final TextView W90(String r9, List<FormulaInputStyleData.ColoredRange> r10) {
        TextView r0 = new TextView(getContext());
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        SpannableString r1 = new SpannableString(r9);
        if (r10 == null) goto L22;
        int r3 = 0;
    L10:
        if (r3 >= r10.size()) goto L22;
        FormulaInputStyleData.ColoredRange r4 = (FormulaInputStyleData.ColoredRange) ListProtector.get(r10, r3);
        if (r4 == null) goto L21;
        if (TextUtils.isEmpty(r4.getColor()) == true) goto L21;
        int r5 = Math.max(0, r4.getStart());
        int r6 = Math.min(r9.length(), r4.getEnd());
        if (r6 <= r5) goto L21;
        r1.setSpan(new ForegroundColorSpan(Color.parseColor(r4.getColor())), r5, r6, 33);
    L21:
        r3 = r3 + 1;
    L22:
        r0.setText(r1);
        r0.setTextColor(ContextCompat.getColor(requireContext(), 2131106622));
        r0.setTextSize(14.0f);
        r0.setGravity(16);
        r0.setPadding(X90(12.0f), X90(12.0f), X90(12.0f), X90(12.0f));
        r0.setMinHeight(X90(56.0f));
        GradientDrawable r11 = new GradientDrawable();
        r11.setColor(ContextCompat.getColor(requireContext(), 2131100549));
        r11.setCornerRadius(X90(8.0f));
        r0.setBackground(r11);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-1, -2);
        r12.setMargins(0, 0, 0, X90(16.0f));
        r0.setLayoutParams(r12);
        return r0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(final View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        this.k = getContext().getResources().getConfiguration().orientation;
        this.f = (SheetCellContentView) r5.findViewById(2131365380);
        this.j = (LinearLayout) r5.findViewById(2131373217);
        int r7 = this.f.getPaddingBottom();
        if (this.e.isDocAIEnabled() == false) goto L6;
        r7 = r7 + com.bytedance.ee.util.ui.n.d(28);
    L6:
        if (this.f.getPaddingBottom() == r7) goto L8;
        AppCompatTextView r0 = this.f;
        r0.setPadding(r0.getPaddingLeft(), this.f.getPaddingTop(), this.f.getPaddingRight(), r7);
    L8:
        this.h = (SheetDragView) r5.findViewById(2131365394);
        this.i = (TextView) r5.findViewById(2131365377);
        if (TextUtils.isEmpty(this.e.getBgColor()) == true) goto L11;
        this.h.setPanelBackgroundColorByColorInt(ColorUtils.h(this.e.getBgColor()));
    L11:
        V90();
        this.h.setOnCloseListener(new e(this, r5));
        this.h.setOnPositionChangeListener(new k(this));
        float r8 = com.bytedance.ee.util.ui.n.t() * 0.4f;
        if (this.e.getMidHeight() == 0.0f) goto L14;
        r8 = com.bytedance.ee.util.ui.n.t() * this.e.getMidHeight();
    L14:
        SheetDragView r1 = this.h;
        float r2 = com.bytedance.ee.util.ui.n.t();
        if (this.e.isVCFollow() == false) goto L17;
        float r3 = 0.6f;
    L18:
        float r4 = r2 * r3;
        r1.y = 0.0f;
        r1.z = r8;
        r1.A = r4;
        r1.x.m(0.0f, r8, r4);
        FabView r9 = r5.findViewById(2131386185);
        final FabViewModel r10 = (FabViewModel) q.a(this, FabViewModel.class);
        r9.setOnClickListener(new f(this, r10));
        this.g = new p(this.f, this.e.getOnSegmentsClickListener());
        this.e.getCellData().observe(getViewLifecycleOwner(), new b(this));
        final FabViewModel r11 = (FabViewModel) q.a(this, FabViewModel.class);
        r11.getTopItems().observe(this, new c(r5, r11));
        this.e.getCopyAble().observe(getViewLifecycleOwner(), new d(this));
        return;
    L17:
        r3 = 0.8f;
        goto L18
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564530, r3, false);
    }
}
