package com.larus.bmhome.view.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusItemTextDescSelectorBinding;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\nR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006#"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextDescSelector;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/common_res/common_ui/databinding/LarusItemTextDescSelectorBinding;", "binding", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusItemTextDescSelectorBinding;", "init", "", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "descText", "getDescText", "setDescText", "setSelected", "selected", "", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "setTextFontWeight", "weight", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTextDescSelector extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusItemTextDescSelectorBinding f316967a;

    public final LarusItemTextDescSelectorBinding getBinding() {
        LarusItemTextDescSelectorBinding r100 = this.f316967a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final CharSequence getDescText() {
        return getBinding().f326743d.getText();
    }

    public final CharSequence getText() {
        return getBinding().f326741b.getText();
    }

    public ItemTextDescSelector(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        R5(r100, null);
    }

    public final void setDescText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        getBinding().f326743d.setText(r100);
        TextView r101 = getBinding().f326743d;
        int r102 = 0;
        if (r100.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = 8;
    L9:
        r101.setVisibility(r102);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        ImageView r101 = getBinding().f326742c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        getBinding().f326741b.setText(r100);
    }

    public final void setTextFontWeight(int r100) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Typeface r101 = Typeface.create(getBinding().f326741b.getTypeface(), r100, getBinding().f326741b.getTypeface().isItalic());
        getBinding().f326741b.setTypeface(r101);
        return;
    }

    public ItemTextDescSelector(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        R5(r100, r101);
    }

    public final void R5(Context r100, AttributeSet r101) {
        LayoutInflater.from(r100).inflate(R.layout.larus_item_text_desc_selector, this);
        int r102 = R.id.container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(this, R.id.container)) == null) goto L22;
        r102 = R.id.loading_view;
        if (((ProgressBar) ViewBindings.findChildViewById(this, R.id.loading_view)) == null) goto L22;
        r102 = R.id.mainTitle;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.mainTitle);
        if (r103 == null) goto L22;
        r102 = R.id.selectedImg;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.selectedImg);
        if (r104 == null) goto L22;
        r102 = R.id.subTitle;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.subTitle);
        if (r105 == null) goto L22;
        this.f316967a = new LarusItemTextDescSelectorBinding(this, r103, r104, r105);
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.text, R.attr.larus_desc_text});
        TextView r107 = getBinding().f326741b;
        String r108 = r106.getString(0);
        String r109 = "";
        if (r108 != null) goto L15;
        r108 = "";
    L15:
        r107.setText(r108);
        TextView r110 = getBinding().f326743d;
        String r111 = r106.getString(1);
        if (r111 == null) goto L19;
        r109 = r111;
    L19:
        r110.setText(r109);
        return;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public ItemTextDescSelector(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        R5(r100, r101);
    }
}
