package com.bytedance.ee.bear.widgets.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u0003J\u0018\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0014J0\u0010/\u001a\u00020+2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/PanelTitleBarContainer;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftIconIV", "Landroidx/appcompat/widget/AppCompatImageView;", "getLeftIconIV", "()Landroidx/appcompat/widget/AppCompatImageView;", "setLeftIconIV", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "rightIconIV", "getRightIconIV", "setRightIconIV", "leftTV", "Landroid/widget/TextView;", "getLeftTV", "()Landroid/widget/TextView;", "setLeftTV", "(Landroid/widget/TextView;)V", "rightTV", "getRightTV", "setRightTV", "titleTV", "getTitleTV", "setTitleTV", "subTitleTV", "getSubTitleTV", "setSubTitleTV", "titleContainer", "Landroid/widget/LinearLayout;", "getTitleContainer", "()Landroid/widget/LinearLayout;", "setTitleContainer", "(Landroid/widget/LinearLayout;)V", "initView", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelTitleBarContainer extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f240296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f240297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f240298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f240299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f240300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f240301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f240302g;

    public final AppCompatImageView getLeftIconIV() {
        AppCompatImageView r100 = this.f240296a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("leftIconIV");
        return null;
    }

    public final TextView getLeftTV() {
        TextView r100 = this.f240298c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("leftTV");
        return null;
    }

    public final AppCompatImageView getRightIconIV() {
        AppCompatImageView r100 = this.f240297b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rightIconIV");
        return null;
    }

    public final TextView getRightTV() {
        TextView r100 = this.f240299d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rightTV");
        return null;
    }

    public final TextView getSubTitleTV() {
        TextView r100 = this.f240301f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("subTitleTV");
        return null;
    }

    public final LinearLayout getTitleContainer() {
        LinearLayout r100 = this.f240302g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        return null;
    }

    public final TextView getTitleTV() {
        TextView r100 = this.f240300e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        return null;
    }

    public PanelTitleBarContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LayoutInflater.from(r100).inflate(R.layout.comment_panel_title_bar, this);
        setLeftIconIV((AppCompatImageView) findViewById(R.id.leftIconIV));
        setRightIconIV((AppCompatImageView) findViewById(R.id.rightIconIV));
        setLeftTV((TextView) findViewById(R.id.leftTV));
        setRightTV((TextView) findViewById(R.id.rightTV));
        setTitleTV((TextView) findViewById(R.id.titleTV));
        setSubTitleTV((TextView) findViewById(R.id.subTitleTV));
        setTitleContainer((LinearLayout) findViewById(R.id.titleContainer));
    }

    public final void setLeftIconIV(AppCompatImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f240296a = r100;
    }

    public final void setLeftTV(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f240298c = r100;
    }

    public final void setRightIconIV(AppCompatImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f240297b = r100;
    }

    public final void setRightTV(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f240299d = r100;
    }

    public final void setSubTitleTV(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f240301f = r100;
    }

    public final void setTitleContainer(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f240302g = r100;
    }

    public final void setTitleTV(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f240300e = r100;
    }

    public PanelTitleBarContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        a(r100);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r100 = 0;
        if (getLeftIconIV().getVisibility() != 0) goto L5;
        int r101 = getLeftIconIV().getMeasuredWidth();
    L7:
        if (getRightIconIV().getVisibility() != 0) goto L9;
        int r102 = getRightIconIV().getMeasuredWidth();
    L11:
        if (getLeftTV().getVisibility() != 0) goto L13;
        int r103 = getLeftTV().getMeasuredWidth();
    L15:
        if (getRightTV().getVisibility() != 0) goto L17;
        r100 = getRightTV().getMeasuredWidth();
    L17:
        int r104 = Math.max(Math.max(Math.max(r101, r102), r103), r100);
        if (r104 <= 0) goto L23;
        int r112 = View.MeasureSpec.getSize(r110) - (r104 * 2);
        measureChildWithMargins(getTitleTV(), View.MeasureSpec.makeMeasureSpec(r112, Integer.MIN_VALUE), 0, r111, 0);
        if (getSubTitleTV().getVisibility() != 0) goto L24;
        measureChildWithMargins(getSubTitleTV(), View.MeasureSpec.makeMeasureSpec(r112, Integer.MIN_VALUE), 0, r111, 0);
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r103 = 0;
        goto L15
    L9:
        r102 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L7
    }

    public PanelTitleBarContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a(r100);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (getSubTitleTV().getVisibility() != 0) goto L5;
        int r105 = Math.max(getTitleTV().getMeasuredWidth(), getSubTitleTV().getMeasuredWidth());
    L6:
        int r106 = (getMeasuredWidth() - r105) / 2;
        int r107 = (getMeasuredHeight() - getTitleContainer().getMeasuredHeight()) / 2;
        tt5.a.h("PanelTitleBarContainer", "titleMaxWidth: " + r105 + ", left: " + r106 + ", top: " + r107);
        getTitleContainer().layout(r106, r107, r105 + r106, getTitleContainer().getMeasuredHeight() + r107);
        return;
    L5:
        r105 = getTitleTV().getMeasuredWidth();
        goto L6
    }
}
