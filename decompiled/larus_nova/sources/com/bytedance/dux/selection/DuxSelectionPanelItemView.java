package com.bytedance.dux.selection;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.image.DuxImageView;
import com.bytedance.dux.largefont.DuxLargeFontHelper;
import com.bytedance.dux.largefont.a;
import com.bytedance.dux.radio.DuxRadio;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.dux.widget.DuxCheckBox;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/dux/selection/DuxSelectionPanelItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "showDivider", "", "setDividerMode", "isMultiSelect", "setSelectMode", "Lcom/bytedance/dux/image/DuxImageView;", "getIconView", "Lcom/bytedance/dux/text/DuxTextView;", "getTextView", "Lcom/bytedance/dux/radio/DuxRadio;", "getRadioView", "Lcom/bytedance/dux/widget/DuxCheckBox;", "getCheckBox", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "()Z", "setMultiSelect", "(Z)V", "b", "getShowDivider", "setShowDivider", "value", "R5", "setItemSelected", "isItemSelected", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxSelectionPanelItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f205582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f205583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxImageView f205584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DuxTextView f205585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DuxRadio f205586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DuxCheckBox f205587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f205588g;

    public DuxSelectionPanelItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, null, false, 62);
    }

    public DuxSelectionPanelItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, null, false, 60);
    }

    public final boolean R5() {
        if (this.f205582a == false) goto L6;
        return this.f205587f.isChecked();
    L6:
        return this.f205586e.isChecked();
    }

    public final DuxCheckBox getCheckBox() {
        return this.f205587f;
    }

    public final DuxImageView getIconView() {
        return this.f205584c;
    }

    public final DuxRadio getRadioView() {
        return this.f205586e;
    }

    public final boolean getShowDivider() {
        return this.f205583b;
    }

    public final DuxTextView getTextView() {
        return this.f205585d;
    }

    private final void setDividerMode(boolean r100) {
        if (r100 == false) goto L4;
        n.f(this.f205588g);
        return;
    L4:
        n.e(this.f205588g);
    }

    public final void setItemSelected(boolean r100) {
        if (this.f205582a == false) goto L5;
        this.f205587f.setChecked(r100);
        return;
    L5:
        this.f205586e.setChecked(r100);
    }

    public final void setMultiSelect(boolean r100) {
        this.f205582a = r100;
    }

    public final void setSelectMode(boolean r100) {
        this.f205582a = r100;
        if (r100 == false) goto L5;
        n.f(this.f205587f);
        n.e(this.f205586e);
    L6:
        setItemSelected(R5());
        return;
    L5:
        n.e(this.f205587f);
        n.f(this.f205586e);
        goto L6
    }

    public final void setShowDivider(boolean r100) {
        this.f205583b = r100;
    }

    public DuxSelectionPanelItemView(Context r100, AttributeSet r101, Boolean r102, boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 16) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 32) == 0) goto L11;
        r103 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f205582a = false;
        this.f205583b = false;
        Lazy r105 = DuxLargeFontHelper.f205243a;
        boolean r106 = DuxLargeFontHelper.a(DuxComponent.SELECTION, r102);
        if (r106 == false) goto L14;
        int r107 = R.layout.dux_view_selection_item_new;
    L15:
        ViewGroup.inflate(r100, r107, this);
        if (r106 == true) goto L18;
        Resources r108 = Resources.getSystem();
        setMinHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 52, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()))));
    L18:
        DuxImageView r109 = (DuxImageView) findViewById(R.id.iv_icon);
        this.f205584c = r109;
        DuxTextView r110 = (DuxTextView) findViewById(R.id.tv_text);
        this.f205585d = r110;
        DuxRadio r111 = (DuxRadio) findViewById(R.id.radio);
        this.f205586e = r111;
        DuxCheckBox r112 = (DuxCheckBox) findViewById(R.id.checkbox);
        this.f205587f = r112;
        this.f205588g = findViewById(R.id.divider);
        r112.setClickable(false);
        setSelectMode(this.f205582a);
        setDividerMode(this.f205583b);
        ViewCompat.setAccessibilityDelegate(this, new DuxSelectionPanelItemView$addAccessibilityCompat$1(this));
        if (r103 == false) goto L23;
        a.a(r109, 20, 20);
        a.c(r110, 15.0f);
        r111.setLimitLargeFontScale(true);
        r112.f205881a = true;
        r112.setSize(r112.f205883c);
        return;
    L23:
        return;
    L14:
        r107 = R.layout.dux_view_selection_item;
        goto L15
    }
}
