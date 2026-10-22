package com.obric.oui.sheet.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetFooterBtnContainer;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/button/OButton;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "setBtnNegative", "(Lcom/obric/oui/button/OButton;)V", "btnNegative", "b", "getBtnPositive", "setBtnPositive", "btnPositive", "Landroid/view/View;", "c", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "setHorizontal_space", "(Landroid/view/View;)V", "horizontal_space", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSheetFooterBtnContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OButton f402902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButton f402903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f402904c;

    public final OButton getBtnNegative() {
        return this.f402902a;
    }

    public final OButton getBtnPositive() {
        return this.f402903b;
    }

    public final View getHorizontal_space() {
        return this.f402904c;
    }

    public OSheetFooterBtnContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final OButton a(boolean r100) {
        Context r101 = getContext();
        if (r100 == false) goto L5;
        int r102 = R.layout.oui_widget_panel_primary_btn;
    L6:
        View r103 = LinearLayout.inflate(r101, r102, this);
        if (r103 == null) goto L15;
        ViewGroup r104 = (ViewGroup) r103;
        View r105 = r104.getChildAt(r104.getChildCount() - 1);
        if (r105 == null) goto L13;
        return (OButton) r105;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r102 = R.layout.oui_widget_panel_netural_btn;
        goto L6
    }

    public final void setBtnNegative(OButton r100) {
        this.f402902a = r100;
    }

    public final void setBtnPositive(OButton r100) {
        this.f402903b = r100;
    }

    public final void setHorizontal_space(View r100) {
        this.f402904c = r100;
    }

    public OSheetFooterBtnContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        int r102 = getResources().getDimensionPixelSize(R.dimen.oui_p_container_large_1);
        setPadding(r102, pla.d.n(this, 8), r102, 0);
    }

    public final void b(String r100, boolean r101, View.OnClickListener r102, String r103, boolean r104, View.OnClickListener r105) {
        if (r100 != null) goto L5;
        char r106 = 0;
    L18:
        if (r106 <= 0) goto L27;
        View r107 = new View(getContext());
        this.f402904c = r107;
        addView(r107);
        View r108 = this.f402904c;
        if (r108 == null) goto L23;
        int r109 = pla.d.n(this, 12);
        Intrinsics.checkNotNullParameter(r108, "<this>");
        r108.getLayoutParams().width = r109;
        r108.requestLayout();
    L23:
        View r110 = this.f402904c;
        if (r110 == null) goto L27;
        int r111 = pla.d.n(this, 1);
        Intrinsics.checkNotNullParameter(r110, "<this>");
        r110.getLayoutParams().height = r111;
        r110.requestLayout();
    L27:
        if (r103 == null) goto L42;
        setBtnPositive(a(r104));
        OButton r112 = getBtnPositive();
        if (r112 == null) goto L33;
        r112.setId(R.id.btn_positive);
    L33:
        OButton r113 = getBtnPositive();
        if (r113 == null) goto L37;
        r113.setOnClickListener(r105);
    L37:
        OButton r114 = getBtnPositive();
        if (r114 == null) goto L43;
        r114.setText(r103);
        return;
    L43:
        return;
    L42:
        return;
    L5:
        setBtnNegative(a(r101));
        OButton r115 = getBtnNegative();
        if (r115 == null) goto L9;
        r115.setId(R.id.btn_negative);
    L9:
        OButton r116 = getBtnNegative();
        if (r116 == null) goto L13;
        r116.setOnClickListener(r102);
    L13:
        OButton r117 = getBtnNegative();
        if (r117 == null) goto L17;
        r117.setText(r100);
    L17:
        r106 = 1;
        goto L18
    }
}
