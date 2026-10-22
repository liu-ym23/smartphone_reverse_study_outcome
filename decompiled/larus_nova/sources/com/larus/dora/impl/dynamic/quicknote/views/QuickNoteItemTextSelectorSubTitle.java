package com.larus.dora.impl.dynamic.quicknote.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusItemQuickNoteBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0012J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u0012R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/impl/dynamic/quicknote/views/QuickNoteItemTextSelectorSubTitle;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/common_res/common_ui/databinding/LarusItemQuickNoteBinding;", "binding", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusItemQuickNoteBinding;", "init", "", "setMainTitle", "mainTitle", "", "setSubTitle", "subTitle", "setConfirmed", "setSelected", "selected", "", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickNoteItemTextSelectorSubTitle extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusItemQuickNoteBinding f335269a;

    public final LarusItemQuickNoteBinding getBinding() {
        LarusItemQuickNoteBinding r100 = this.f335269a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public QuickNoteItemTextSelectorSubTitle(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        R5(r100, null);
    }

    public final void setMainTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mainTitle");
        getBinding().f326725c.setText(r100);
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        e1.o(getBinding().f326724b);
        e1.y(getBinding().f326727e, o0.d(getBinding().f326727e.getText().toString()));
        AppCompatImageView r101 = getBinding().f326726d;
        if ((!r100) == false) goto L5;
        int r102 = 4;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void setSubTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subTitle");
        if (isEnabled() == true) goto L5;
        return;
    L5:
        e1.y(getBinding().f326727e, o0.d(r100));
        getBinding().f326727e.setText(r100);
    }

    public QuickNoteItemTextSelectorSubTitle(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        R5(r100, r101);
    }

    public final void R5(Context r100, AttributeSet r101) {
        LayoutInflater.from(r100).inflate(R.layout.larus_item_quick_note, this);
        int r102 = R.id.confirm;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.confirm);
        if (r103 == null) goto L15;
        r102 = R.id.loading_view;
        if (((ProgressBar) ViewBindings.findChildViewById(this, R.id.loading_view)) == null) goto L15;
        r102 = R.id.mainTitle;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.mainTitle);
        if (r104 == null) goto L15;
        r102 = R.id.selectedImg;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.selectedImg);
        if (r105 == null) goto L15;
        r102 = R.id.subTitle;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.subTitle);
        if (r106 == null) goto L15;
        this.f335269a = new LarusItemQuickNoteBinding(this, r103, r104, r105, r106);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public QuickNoteItemTextSelectorSubTitle(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        R5(r100, r101);
    }
}
