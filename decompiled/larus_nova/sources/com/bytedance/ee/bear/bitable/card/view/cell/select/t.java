package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorBean;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t extends hp4.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Integer[] f208173u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Integer[] f208174v = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ColorBean[] f208175m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f208176n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f208177o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a f208178p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public q f208179q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f208180r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f208181s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final EditText f208182t;

    public interface a {
        void a(String r100);

        com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a b(String r100);

        void c(int r100);

        void d(String r100, int r101);
    }

    public static final class b {
    }

    static {
        f208173u = new Integer[]{40, 28, 27, 37, 25, 24, 23, 33, 41, 42, 43};
        f208174v = new Integer[]{0, 18, 29, 40, 51, 2, 17, 28, 39, 50, 4, 16, 27, 38, 49, 7, 15, 26, 37, 48, 9, 14, 25, 36, 47, 3, 13, 24, 35, 46, 1, 12, 23, 34, 45, 5, 11, 22, 33, 44, 8, 19, 30, 41, 52, 6, 20, 31, 42, 53, 10, 21, 32, 43, 54};
    }

    public final void B() {
        ((LinearLayout) this.f486399c.findViewById(R.id.optionInputContainer)).setVisibility(8);
    }

    public final void C() {
        CellEditDragView r100 = (CellEditDragView) this.f486399c.findViewById(R.id.panel);
        r100.setLeftTextVisible(false);
        r100.setRightTextVisible(false);
        r100.setLeftIconVisible(true);
    }

    @Override // hp4.g
    public final boolean u() {
        return !com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.option.panel.only.trans.bar.disable");
    }

    public final void x() {
        ColorBean[] r100 = this.f208175m;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length < 55) goto L18;
        CommonColorSchemeView.ColorScheme[] r101 = new CommonColorSchemeView.ColorScheme[11];
        int r102 = 0;
    L8:
        if (r102 >= 11) goto L13;
        String[] r103 = new String[5];
        int r104 = 0;
    L10:
        if (r104 >= 5) goto L12;
        r103[r104] = this.f208175m[f208174v[(5 * r102) + r104].intValue()].getColor();
        r104 = r104 + 1;
        goto L10
    L12:
        String r105 = this.f208175m[f208173u[r102].intValue()].getColor();
        r101[r102] = new CommonColorSchemeView.ColorScheme(r105, r105, r103);
        r102 = r102 + 1;
        goto L8
    L13:
        ((CommonColorSchemeView) this.f486399c.findViewById(R.id.colorSchemeView)).a(r101, this.f208175m[this.f208176n].getColor());
        return;
    }

    public final void y() {
        EditText r100 = this.f208182t;
        ColorBean[] r101 = this.f208175m;
        if (r101 == null) goto L20;
        ColorBean r102 = r101[this.f208176n];
        if (r102 == null) goto L21;
    L14:
        e = move-exception;
        tt5.a.e("OptionCreationPanel", "parse color failed!", e, false);
        return;
    L7:
        if (r102.getTextColor() != null) goto L9;
        return;
    L9:
        if (r102.getColor() == null) goto L19;
        String r103 = r102.getTextColor();     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L14
        r100.setTextColor(ColorUtils.h(r103));     // Catch: Exception -> L14
        String r104 = r102.getTextColor();     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L14
        r100.setHintTextColor(ColorUtils.c(127, ColorUtils.h(r104)));     // Catch: Exception -> L14
        String r105 = r102.getColor();     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L14
        r100.setBackgroundTintList(ColorStateList.valueOf(ColorUtils.h(r105)));     // Catch: Exception -> L14
        return;
    L19:
        return;
    L21:
        return;
    }

    public final void z() {
        EditText r100 = this.f208182t;
        if ((r100 instanceof SelectEditTextView) == false) goto L5;
        SelectEditTextView r101 = (SelectEditTextView) r100;
    L6:
        if (r101 == null) goto L35;
        ColorBean[] r102 = this.f208175m;
        if (r102 == null) goto L36;
        ColorBean r103 = r102[this.f208176n];
        if (r103 != null) goto L33;
        return;
    L33:
        String r104 = r103.getTextColor();     // Catch: Exception -> L27
        if (r104 != null) goto L15;
        return;
    L15:
        if (r103.getColor() == null) goto L39;
        r101.Q(r103.getColor(), r104);     // Catch: Exception -> L27
        if (this.f208181s == false) goto L29;
        String r105 = r103.getBorderColor();     // Catch: Exception -> L27
        BaseTagSize.Companion.getClass();     // Catch: Exception -> L27
        int r106 = BaseTagSize.a.a(r105);     // Catch: Exception -> L27
        if (r106 == 0) goto L23;
        GradientDrawable r107 = r101.getMBackgroundDrawable();     // Catch: Exception -> L27
        if (r107 == null) goto L26;
        r107.setStroke(BaseTagSize.LARGE.getStrokeWidthPx(), r106);     // Catch: Exception -> L27
    L26:
        r101.setBackground(r101.getMBackgroundDrawable());     // Catch: Exception -> L27
        goto L29
    L23:
        GradientDrawable r108 = r101.getMBackgroundDrawable();     // Catch: Exception -> L27
        if (r108 == null) goto L26;
        r108.setStroke(0, 0);     // Catch: Exception -> L27
    L29:
        r101.setHintTextColor(ColorUtils.c(127, ColorUtils.h(r104)));     // Catch: Exception -> L27
        return;
    L39:
        return;
    L27:
        e = move-exception;
        tt5.a.e("OptionCreationPanel", "parse color failed!", e, false);
        return;
    L36:
        return;
    L35:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        super.show();
        Window r100 = this.f486398b.getWindow();
        if (r100 == null) goto L5;
        r100.setBackgroundDrawableResource(R.color.bg_mask);
        r100.setWindowAnimations(R.style.Animation_AppCompat_Dialog);
        r100.setSoftInputMode(48);
    L5:
        q r101 = this.f208179q;
        if (r101 == null) goto L9;
        r101.J0(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_EDIT_VIEW);
        return;
    }

    public final void A(CharSequence r100) {
        View r101 = this.f486399c;
        this.f208182t.setText(r100);
        EditText r102 = this.f208182t;
        if (r100 == null) goto L5;
        int r103 = r100.length();
    L6:
        r102.setSelection(r103);
        ((CellEditDragView) r101.findViewById(R.id.panel)).setRightTextEnabled(!TextUtils.isEmpty(r100));
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void D(CharSequence r100) {
        ((CellEditDragView) this.f486399c.findViewById(R.id.panel)).setTitle(r100);
    }

    @Override // hp4.g
    public final View q(Context r100) {
        return this.f486399c;
    }

    public t(Context r100, ColorBean[] r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f208175m = r101;
        this.f208176n = r110;
        boolean r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.disable.select.edittext");
        this.f208180r = r102;
        boolean r111 = com.bytedance.ee.bear.bitable.c.B();
        this.f208181s = r111;
        if (r102 == false) goto L5;
        int r103 = R.layout.bitable_card_option_creation_panel;
    L6:
        SelectEditTextView r104 = null;
        View r105 = LayoutInflater.from(r100).inflate(r103, null);
        this.f486399c = r105;
        EditText r106 = (EditText) r105.findViewById(R.id.optionET);
        this.f208182t = r106;
        View r107 = this.f486399c;
        r106.requestFocus();
        if (r102 == false) goto L9;
        y();
    L16:
        r106.addTextChangedListener(new u(r107, this));
        ((LinearLayout) r107.findViewById(R.id.availableOptionContainer)).setOnClickListener(new v(this));
        CommonColorSchemeView r112 = (CommonColorSchemeView) r107.findViewById(R.id.colorSchemeView);
        int r108 = r112.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        int r109 = r112.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        ViewGroup.LayoutParams r113 = r112.f240174a.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ((ViewGroup.MarginLayoutParams) r113).setMargins(r108, 0, r109, 0);
        r112.f240174a.setLayoutParams(r113);
    L19:
        r112.setSpecificColorPickerHeight(r112.getResources().getDimensionPixelSize(R.dimen.space_kit_len_40));
        ((CommonColorSchemeView) r107.findViewById(R.id.colorSchemeView)).setTopicColorViewType(!ku5.c.k(r107.getContext()) ? 1 : 0);
        CommonColorSchemeView r114 = (CommonColorSchemeView) r107.findViewById(R.id.colorSchemeView);
        int r115 = r107.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        int r116 = r107.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        ViewGroup.LayoutParams r117 = r114.f240174a.getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ((ViewGroup.MarginLayoutParams) r117).setMargins(r115, 0, r116, 0);
        r114.f240174a.setLayoutParams(r117);
    L22:
        ((CommonColorSchemeView) r107.findViewById(R.id.colorSchemeView)).setDelegate(new w(this));
        x();
        ((CellEditDragView) r107.findViewById(R.id.panel)).setOnActionListener(new x(this));
        ((CellEditDragView) r107.findViewById(R.id.panel)).setRightTextEnabled(false);
        r106.postDelayed(new y(this), 130);
        r106.setOnFocusChangeListener(z.f208189a);
        return;
    L9:
        z();
        if (r111 == false) goto L16;
        if ((r106 instanceof SelectEditTextView) == false) goto L14;
        r104 = (SelectEditTextView) r106;
    L14:
        if (r104 == null) goto L16;
        BaseTagSize r118 = BaseTagSize.LARGE;
        Intrinsics.checkNotNullParameter(r118, "size");
        r104.setTextSize(r118.getTextSizeSp());
        r104.R(r118.getRadiusPx());
        r104.setPadding(com.bytedance.ee.util.ui.n.d(r118.getTextPaddingHorizontalDp()), r104.getPaddingTop(), com.bytedance.ee.util.ui.n.d(r118.getTextPaddingHorizontalDp()), r104.getPaddingBottom());
        goto L16
    L5:
        r103 = R.layout.bitable_card_option_creation_panel_v2;
        goto L6
    }

    public static final void w(t r100, String r101, String r102) {
        ColorBean[] r103 = r100.f208175m;
        int r104 = 0;
        if (r103 == null) goto L10;
        int r105 = r103.length;
        int r106 = 0;
        int r107 = 0;
    L5:
        if (r106 >= r105) goto L10;
        int r108 = r107 + 1;
        if (TextUtils.equals(r101, r103[r106].getColor()) == true) goto L8;
        r106 = r106 + 1;
        r107 = r108;
        goto L5
    L8:
        r104 = r107;
    L10:
        r100.f208176n = r104;
        if (r100.f208180r == false) goto L13;
        r100.y();
    L14:
        a r109 = r100.f208177o;
        if (r109 == null) goto L17;
        r109.c(r100.f208176n);
    L17:
        q r110 = r100.f208179q;
        if (r110 == null) goto L23;
        r110.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_EDIT_CLICK, r102);
        return;
    L23:
        return;
    L13:
        r100.z();
        goto L14
    }
}
