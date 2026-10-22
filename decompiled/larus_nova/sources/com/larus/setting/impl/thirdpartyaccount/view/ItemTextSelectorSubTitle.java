package com.larus.setting.impl.thirdpartyaccount.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.alipay.sdk.m.x.d;
import com.larus.nova.R;
import com.larus.setting.impl.databinding.LarusItemMusicAccountBinding;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0012R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/setting/impl/thirdpartyaccount/view/ItemTextSelectorSubTitle;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/setting/impl/databinding/LarusItemMusicAccountBinding;", "binding", "getBinding", "()Lcom/larus/setting/impl/databinding/LarusItemMusicAccountBinding;", "init", "", d.f25925o, "mainTitle", "", "setSelected", "selected", "", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTextSelectorSubTitle extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusItemMusicAccountBinding f368460a;

    public final LarusItemMusicAccountBinding getBinding() {
        LarusItemMusicAccountBinding r100 = this.f368460a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void R5() {
        LarusItemMusicAccountBinding r100 = getBinding();
        ImageView r101 = r100.f368159d;
        if (isSelected() == false) goto L5;
        float r102 = 1.0f;
    L6:
        r101.setAlpha(r102);
        r100.f368157b.setAlpha(0.0f);
        getBinding().f368156a.postInvalidate();
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }

    public ItemTextSelectorSubTitle(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        S5(r100, null);
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        ImageView r101 = getBinding().f368159d;
        if (r100 == false) goto L5;
        float r102 = 1.0f;
    L6:
        r101.setAlpha(r102);
        getBinding().f368156a.postInvalidate();
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mainTitle");
        getBinding().f368158c.setText(r100);
    }

    public ItemTextSelectorSubTitle(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        S5(r100, r101);
    }

    public final void S5(Context r100, AttributeSet r101) {
        LayoutInflater.from(r100).inflate(R.layout.larus_item_music_account, this);
        int r102 = R.id.larus_item_music_account_395045554;
        if (((LinearLayout) ViewBindings.findChildViewById(this, R.id.larus_item_music_account_395045554)) == null) goto L13;
        r102 = R.id.loading_view;
        ProgressBar r103 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.loading_view);
        if (r103 == null) goto L13;
        r102 = R.id.mainTitle;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.mainTitle);
        if (r104 == null) goto L13;
        r102 = R.id.selectedImg;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(this, R.id.selectedImg);
        if (r105 == null) goto L13;
        this.f368460a = new LarusItemMusicAccountBinding(this, r103, r104, r105);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public ItemTextSelectorSubTitle(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        S5(r100, r101);
    }
}
