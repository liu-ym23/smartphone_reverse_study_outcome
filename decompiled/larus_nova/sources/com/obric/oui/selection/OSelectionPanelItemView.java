package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelItemView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "", "showDivider", "", "setDividerMode", "isMultiSelect", "setSelectMode", "Landroid/widget/ImageView;", "getIconView", "Lcom/obric/oui/text/OTextView;", "getTextView", "Lcom/obric/oui/radio/ORadio;", "getRadioView", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "h", "Z", "()Z", "setMultiSelect", "(Z)V", RXScreenCaptureService.KEY_INDEX, "getShowDivider", "setShowDivider", "value", "S5", "setItemSelected", "isItemSelected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSelectionPanelItemView extends OUIConstraintLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f402771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f402772i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f402773j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OTextView f402774k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ORadio f402775l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OCheckBox f402776m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f402777n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f402778o;

    public OSelectionPanelItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 14);
    }

    public OSelectionPanelItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 12);
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    public final boolean S5() {
        if (this.f402771h == false) goto L6;
        return this.f402776m.isChecked();
    L6:
        return this.f402775l.isChecked();
    }

    public final OCheckBox getCheckBox() {
        return this.f402776m;
    }

    public final ImageView getIconView() {
        return this.f402773j;
    }

    public final ORadio getRadioView() {
        return this.f402775l;
    }

    public final boolean getShowDivider() {
        return this.f402772i;
    }

    public final OTextView getTextView() {
        return this.f402774k;
    }

    private final void setDividerMode(boolean r100) {
        if (r100 == false) goto L4;
        j.f(this.f402777n);
        return;
    L4:
        j.e(this.f402777n);
    }

    public final void setItemSelected(boolean r100) {
        if (this.f402771h == false) goto L5;
        this.f402776m.setChecked(r100);
    L7:
        if (this.f402778o == true) goto L10;
        ORadio r101 = this.f402775l;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r101.setVisibility(4);
        return;
    L10:
        return;
    L5:
        this.f402775l.setChecked(r100);
        goto L7
    }

    public final void setMultiSelect(boolean r100) {
        this.f402771h = r100;
    }

    public final void setSelectMode(boolean r100) {
        this.f402771h = r100;
        if (r100 == false) goto L5;
        j.f(this.f402776m);
        j.e(this.f402775l);
    L6:
        setItemSelected(S5());
        return;
    L5:
        j.e(this.f402776m);
        j.f(this.f402775l);
        goto L6
    }

    public final void setShowDivider(boolean r100) {
        this.f402772i = r100;
    }

    public OSelectionPanelItemView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0, 12);
        this.f402771h = false;
        this.f402772i = false;
        this.f402778o = true;
        ViewGroup.inflate(r100, R.layout.o_view_selection_item, this);
        setMinHeight((int) getResources().getDimension(R.dimen.oui_h_l2));
        this.f402773j = (ImageView) findViewById(R.id.iv_icon);
        this.f402774k = (OTextView) findViewById(R.id.tv_text);
        this.f402775l = (ORadio) findViewById(R.id.radio);
        OCheckBox r103 = (OCheckBox) findViewById(R.id.checkbox);
        this.f402776m = r103;
        this.f402777n = findViewById(R.id.divider);
        r103.setClickable(false);
        setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
        setSelectMode(this.f402771h);
        setDividerMode(this.f402772i);
        setPadding(getResources().getDimensionPixelSize(R.dimen.oui_p_list_item_2), getPaddingTop(), getResources().getDimensionPixelSize(R.dimen.oui_p_list_item_2), getPaddingBottom());
        ViewCompat.setAccessibilityDelegate(this, new OSelectionPanelItemView$addAccessibilityCompat$1(this));
    }
}
