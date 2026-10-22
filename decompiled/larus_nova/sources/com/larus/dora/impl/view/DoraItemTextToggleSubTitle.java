package com.larus.dora.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/view/DoraItemTextToggleSubTitle;", "Lcom/larus/bmhome/view/item/ItemTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setEnabled", "", "enabled", "", "toggleView", "Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "getToggleView", "()Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "subTitle", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "init", "setSubTitle", "subTitleText", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraItemTextToggleSubTitle extends ItemTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CustomSwitchCompat f338181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f338182d;

    public final TextView getSubTitle() {
        return this.f338182d;
    }

    public final CustomSwitchCompat getToggleView() {
        return this.f338181c;
    }

    public DoraItemTextToggleSubTitle(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        CustomSwitchCompat r101 = new CustomSwitchCompat(getContext(), null);
        r101.setId(R.id.view_id_toggle);
        r101.setChecked(true);
        r101.setThumbResource(R.drawable.larus_bg_switch_thumb);
        r101.setTrackResource(R.drawable.larus_bg_switch_track);
        this.f338181c = r101;
        TextView r102 = new TextView(getContext());
        r102.setId(R.id.subTitle);
        r102.setTextColor(c.a(R.attr.larus_neutral_50, r102.getContext(), R.color.larus_neutral_50));
        r102.setTextSize(0, i5.h());
        r102.setGravity(16);
        this.f338182d = r102;
        R5(r100, null);
    }

    @Override // com.larus.bmhome.view.item.ItemTextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f338181c.setEnabled(r100);
    }

    public final void setSubTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subTitleText");
        this.f338182d.setText(r100);
    }

    public DoraItemTextToggleSubTitle(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        CustomSwitchCompat r102 = new CustomSwitchCompat(getContext(), null);
        r102.setId(R.id.view_id_toggle);
        r102.setChecked(true);
        r102.setThumbResource(R.drawable.larus_bg_switch_thumb);
        r102.setTrackResource(R.drawable.larus_bg_switch_track);
        this.f338181c = r102;
        TextView r103 = new TextView(getContext());
        r103.setId(R.id.subTitle);
        r103.setTextColor(c.a(R.attr.larus_neutral_50, r103.getContext(), R.color.larus_neutral_50));
        r103.setTextSize(0, i5.h());
        r103.setGravity(16);
        this.f338182d = r103;
        R5(r100, r101);
    }

    private final void R5(Context r100, AttributeSet r101) {
        boolean r102 = true;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_sub_text});
        View r104 = this.f338181c;
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(-2, i5.C());
        r105.topToTop = 0;
        r105.bottomToBottom = 0;
        r105.endToEnd = 0;
        Unit r106 = Unit.INSTANCE;
        addView(r104, r105);
        View r107 = this.f338182d;
        ConstraintLayout.LayoutParams r108 = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) r108).width = 0;
        r108.topToBottom = getTextView().getId();
        r108.bottomToBottom = 0;
        r108.startToStart = getTextView().getId();
        r108.endToEnd = getTextView().getId();
        r108.verticalChainStyle = 2;
        ((ViewGroup.MarginLayoutParams) r108).topMargin = i5.z();
        addView(r107, r108);
        TextView r109 = this.f338182d;
        String r110 = r103.getString(0);
        if (r110 != null) goto L5;
        r110 = "";
    L5:
        r109.setText(r110);
        ViewGroup.LayoutParams r111 = getTextView().getLayoutParams();
        if ((r111 instanceof ConstraintLayout.LayoutParams) == false) goto L8;
        ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r111;
    L9:
        if (r112 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r112).width = 0;
        r112.topToTop = 0;
        r112.bottomToTop = this.f338182d.getId();
        r112.startToEnd = getImageView().getId();
        r112.endToStart = this.f338181c.getId();
        r112.verticalChainStyle = 2;
        if (getImageView().getVisibility() == 0) goto L14;
        r102 = false;
    L14:
        if (r102 == false) goto L16;
        r112.setMarginStart(i5.q());
        r112.setMarginEnd(i5.q());
        r112.setMarginEnd(0);
    L17:
        getTextView().setGravity(GravityCompat.START);
        goto L18
    L16:
        r112.setMarginStart(0);
        r112.setMarginEnd(0);
    L18:
        int r113 = r103.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16));
        FLogger.f375446a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r113 + ",top:" + r113 + ",end:" + r113 + ",bottom:" + r113);
        setPaddingRelative(r113, r113, r113, r113);
        setMinHeight(i5.h0());
        r103.recycle();
        return;
    L8:
        r112 = null;
        goto L9
    }

    public DoraItemTextToggleSubTitle(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        CustomSwitchCompat r103 = new CustomSwitchCompat(getContext(), null);
        r103.setId(R.id.view_id_toggle);
        r103.setChecked(true);
        r103.setThumbResource(R.drawable.larus_bg_switch_thumb);
        r103.setTrackResource(R.drawable.larus_bg_switch_track);
        this.f338181c = r103;
        TextView r104 = new TextView(getContext());
        r104.setId(R.id.subTitle);
        r104.setTextColor(c.a(R.attr.larus_neutral_50, r104.getContext(), R.color.larus_neutral_50));
        r104.setTextSize(0, i5.h());
        r104.setGravity(16);
        this.f338182d = r104;
        R5(r100, r101);
    }
}
