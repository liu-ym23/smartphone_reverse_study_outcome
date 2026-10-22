package com.larus.bmhome.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\b\b\u0001\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextSelector;", "Lcom/larus/bmhome/view/item/ItemTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "manualTickMode", "", "tickView", "Landroid/widget/ImageView;", "loadingView", "Landroid/widget/ProgressBar;", "init", "", "setSelected", "selected", "setManualTick", "resId", "visible", "clearManualTick", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "isLoading", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTextSelector extends ItemTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f316973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f316974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f316975e;

    public final void T5() {
        int r100 = 0;
        this.f316973c = false;
        ImageView r101 = this.f316974d;
        if (isSelected() == true) goto L6;
        r100 = 8;
    L6:
        r101.setVisibility(r100);
    }

    private final void U5() {
        View r100 = this.f316974d;
        ConstraintLayout.LayoutParams r101 = new ConstraintLayout.LayoutParams(-2, -2);
        r101.topToTop = 0;
        r101.bottomToBottom = 0;
        r101.endToEnd = 0;
        Unit r102 = Unit.INSTANCE;
        addView(r100, r101);
        View r103 = this.f316975e;
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(i5.m(), i5.m());
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        r104.endToEnd = 0;
        addView(r103, r104);
        TextView r105 = getTextView();
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(0, -2);
        r106.topToTop = 0;
        r106.bottomToBottom = 0;
        r106.startToEnd = getImageView().getId();
        boolean r107 = true;
        if (getImageView().getVisibility() != 0) goto L5;
        boolean r108 = true;
    L6:
        if (r108 == false) goto L8;
        r106.setMarginStart(i5.q());
        r106.setMarginEnd(0);
    L10:
        if (this.f316974d.getVisibility() != 0) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == false) goto L16;
        r106.endToStart = this.f316974d.getId();
    L22:
        r105.setLayoutParams(r106);
        return;
    L16:
        if (this.f316975e.getVisibility() == 0) goto L19;
        r107 = false;
    L19:
        if (r107 == false) goto L21;
        r106.endToStart = this.f316975e.getId();
        goto L22
    L21:
        r106.endToEnd = 0;
        goto L22
    L12:
        r109 = false;
        goto L13
    L8:
        r106.setMarginStart(0);
        r106.setMarginEnd(0);
        goto L10
    L5:
        r108 = false;
        goto L6
    }

    public ItemTextSelector(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        ImageView r101 = new ImageView(getContext());
        r101.setId(R.id.view_id_tick);
        r101.setImageResource(c.b(R.attr.larus_ic_selector, r101.getContext(), R.drawable.larus_ic_selector));
        r101.setContentDescription(r101.getResources().getString(android.R.string.ok));
        r101.setVisibility(8);
        this.f316974d = r101;
        ProgressBar r102 = new ProgressBar(getContext(), null, 0, R.style.larus_LoadingProgressBar);
        r102.setId(R.id.view_id_loading);
        r102.setVisibility(8);
        this.f316975e = r102;
        U5();
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        if (this.f316973c == true) goto L10;
        ImageView r101 = this.f316974d;
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public ItemTextSelector(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        ImageView r102 = new ImageView(getContext());
        r102.setId(R.id.view_id_tick);
        r102.setImageResource(c.b(R.attr.larus_ic_selector, r102.getContext(), R.drawable.larus_ic_selector));
        r102.setContentDescription(r102.getResources().getString(android.R.string.ok));
        r102.setVisibility(8);
        this.f316974d = r102;
        ProgressBar r103 = new ProgressBar(getContext(), null, 0, R.style.larus_LoadingProgressBar);
        r103.setId(R.id.view_id_loading);
        r103.setVisibility(8);
        this.f316975e = r103;
        U5();
    }

    public ItemTextSelector(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        ImageView r103 = new ImageView(getContext());
        r103.setId(R.id.view_id_tick);
        r103.setImageResource(c.b(R.attr.larus_ic_selector, r103.getContext(), R.drawable.larus_ic_selector));
        r103.setContentDescription(r103.getResources().getString(android.R.string.ok));
        r103.setVisibility(8);
        this.f316974d = r103;
        ProgressBar r104 = new ProgressBar(getContext(), null, 0, R.style.larus_LoadingProgressBar);
        r104.setId(R.id.view_id_loading);
        r104.setVisibility(8);
        this.f316975e = r104;
        U5();
    }
}
