package com.obric.assistant.common.ui.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0015\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/common/ui/item/ObricItemTextArrowSubTitle;", "Lcom/larus/bmhome/view/item/ItemTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowView", "Landroid/widget/ImageView;", "getArrowView", "()Landroid/widget/ImageView;", "subTitle", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "init", "", "setSubTitle", "subTitleText", "", "setSubTitleTextColor", "textColor", "(Ljava/lang/Integer;)V", "utils_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricItemTextArrowSubTitle extends ItemTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f387853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f387854d;

    public final ImageView getArrowView() {
        return this.f387853c;
    }

    public final TextView getSubTitle() {
        return this.f387854d;
    }

    public ObricItemTextArrowSubTitle(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        ImageView r101 = new ImageView(getContext());
        r101.setId(R.id.view_id_arrow);
        r101.setImageResource(c.b(R.attr.larus_ic_arrow, r101.getContext(), R.drawable.larus_ic_arrow));
        r101.setVisibility(0);
        this.f387853c = r101;
        TextView r102 = new TextView(getContext());
        r102.setId(R.id.view_id_subt_title);
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), c.b(R.attr.larus_neutral_50, r102.getContext(), R.color.larus_neutral_50)));
        r102.setTextSize(0, i5.h());
        r102.setGravity(16);
        this.f387854d = r102;
        R5(r100, null);
    }

    public final void setSubTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subTitleText");
        this.f387854d.setText(r100);
    }

    public final void setSubTitleTextColor(Integer r100) {
        TextView r101 = this.f387854d;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        r101.setTextColor(r102);
        return;
    L5:
        r102 = ContextCompat.getColor(getContext(), c.b(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50));
        goto L6
    }

    public ObricItemTextArrowSubTitle(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        ImageView r102 = new ImageView(getContext());
        r102.setId(R.id.view_id_arrow);
        r102.setImageResource(c.b(R.attr.larus_ic_arrow, r102.getContext(), R.drawable.larus_ic_arrow));
        r102.setVisibility(0);
        this.f387853c = r102;
        TextView r103 = new TextView(getContext());
        r103.setId(R.id.view_id_subt_title);
        r103.setTextColor(ContextCompat.getColor(r103.getContext(), c.b(R.attr.larus_neutral_50, r103.getContext(), R.color.larus_neutral_50)));
        r103.setTextSize(0, i5.h());
        r103.setGravity(16);
        this.f387854d = r103;
        R5(r100, r101);
    }

    private final void R5(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.obric_sub_text, R.attr.obric_toggle_visibility});
        View r103 = this.f387853c;
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-2, -2);
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        r104.endToEnd = 0;
        Unit r105 = Unit.INSTANCE;
        addView(r103, r104);
        View r106 = this.f387854d;
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) r107).width = 0;
        r107.topToBottom = getTextView().getId();
        r107.bottomToBottom = 0;
        r107.leftToLeft = getTextView().getId();
        r107.rightToLeft = this.f387853c.getId();
        r107.verticalChainStyle = 2;
        ((ViewGroup.MarginLayoutParams) r107).topMargin = i5.z();
        ((ViewGroup.MarginLayoutParams) r107).bottomMargin = i5.z();
        ((ViewGroup.MarginLayoutParams) r107).rightMargin = i5.r0();
        addView(r106, r107);
        TextView r108 = this.f387854d;
        String r109 = r102.getString(0);
        if (r109 != null) goto L5;
        r109 = "";
    L5:
        r108.setText(r109);
        ViewGroup.LayoutParams r110 = getTextView().getLayoutParams();
        if ((r110 instanceof ConstraintLayout.LayoutParams) == false) goto L8;
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
    L9:
        if (r111 == null) goto L18;
        ((ViewGroup.MarginLayoutParams) r111).width = 0;
        r111.topToTop = 0;
        r111.bottomToTop = this.f387854d.getId();
        r111.startToEnd = getImageView().getId();
        r111.endToEnd = 0;
        r111.verticalChainStyle = 2;
        if (getImageView().getVisibility() != 0) goto L13;
        boolean r112 = true;
    L14:
        if (r112 == false) goto L16;
        r111.setMarginStart(i5.q());
        r111.setMarginEnd(0);
    L17:
        getTextView().setGravity(GravityCompat.START);
        goto L18
    L16:
        r111.setMarginStart(0);
        r111.setMarginEnd(0);
        goto L17
    L13:
        r112 = false;
    L18:
        int r113 = r102.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16));
        int r114 = r102.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8));
        FLogger.f375446a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r113 + ",top:" + r114 + ",end:" + r113 + ",bottom:" + r114);
        setPaddingRelative(r113, r114, r113, r114);
        setMinHeight(i5.h0());
        r102.recycle();
        return;
    L8:
        r111 = null;
        goto L9
    }

    public ObricItemTextArrowSubTitle(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        ImageView r103 = new ImageView(getContext());
        r103.setId(R.id.view_id_arrow);
        r103.setImageResource(c.b(R.attr.larus_ic_arrow, r103.getContext(), R.drawable.larus_ic_arrow));
        r103.setVisibility(0);
        this.f387853c = r103;
        TextView r104 = new TextView(getContext());
        r104.setId(R.id.view_id_subt_title);
        r104.setTextColor(ContextCompat.getColor(r104.getContext(), c.b(R.attr.larus_neutral_50, r104.getContext(), R.color.larus_neutral_50)));
        r104.setTextSize(0, i5.h());
        r104.setGravity(16);
        this.f387854d = r104;
        R5(r100, r101);
    }
}
