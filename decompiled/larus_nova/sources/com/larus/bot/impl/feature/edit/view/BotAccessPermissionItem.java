package com.larus.bot.impl.feature.edit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bot.impl.databinding.LarusItemBotAccessPermissionBinding;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/larus/bot/impl/feature/edit/view/BotAccessPermissionItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusItemBotAccessPermissionBinding;", "value", "", "itemSelected", "getItemSelected", "()Z", "setItemSelected", "(Z)V", DyPayConstant.KEY_SHOW_LOADING, "", "hideLoading", "isLoading", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAccessPermissionItem extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemBotAccessPermissionBinding f319306a;

    public BotAccessPermissionItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BotAccessPermissionItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        ImageView r100 = this.f319306a.f317773c;
        if (getItemSelected() == false) goto L5;
        int r101 = 0;
    L6:
        r100.setVisibility(r101);
        this.f319306a.f317774d.setVisibility(8);
        return;
    L5:
        r101 = 8;
        goto L6
    }

    public final void S5() {
        this.f319306a.f317773c.setVisibility(8);
        this.f319306a.f317774d.setVisibility(0);
    }

    public final boolean getItemSelected() {
        if (this.f319306a.f317773c.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setItemSelected(boolean r100) {
        ImageView r101 = this.f319306a.f317773c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public BotAccessPermissionItem(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LayoutInflater.from(r110).inflate(R.layout.larus_item_bot_access_permission, this);
        int r113 = R.id.fl_state;
        FrameLayout r100 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.fl_state);
        if (r100 == null) goto L38;
        r113 = R.id.iv_icon;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(this, R.id.iv_icon);
        if (r101 == null) goto L38;
        r113 = R.id.iv_state;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(this, R.id.iv_state);
        if (r102 == null) goto L38;
        r113 = R.id.loading;
        ProgressBar r103 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.loading);
        if (r103 == null) goto L38;
        r113 = R.id.tv_content;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_content);
        if (r104 == null) goto L38;
        this.f319306a = new LarusItemBotAccessPermissionBinding(this, r100, r101, r102, r103, r104);
        TypedArray r114 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.text, R.attr.larus_item_icon_src, R.attr.larus_item_public_dialog, R.attr.larus_item_selected});
        r101.setImageResource(r114.getResourceId(1, 0));
        r101.setColorFilter(ContextCompat.getColor(r110, R.color.larus_neutral_100));
        String r115 = r114.getString(0);
        if (r115 != null) goto L15;
        r115 = "";
    L15:
        r104.setText(r115);
        if (r114.getBoolean(3, false) == false) goto L18;
        int r116 = 0;
    L19:
        r102.setVisibility(r116);
        if (r114.getBoolean(2, false) == false) goto L35;
        ViewGroup.LayoutParams r117 = r101.getLayoutParams();
        if (r117 == null) goto L34;
        r117.width = i5.C();
        r117.height = i5.C();
        r101.setLayoutParams(r117);
        ViewGroup.LayoutParams r118 = r104.getLayoutParams();
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
    L27:
        if (r119 == null) goto L29;
        r119.setMarginStart(i5.q());
    L29:
        if (r119 == null) goto L31;
        r119.setMarginEnd(i5.q());
    L31:
        if (r119 == null) goto L35;
        r104.setLayoutParams(r119);
        goto L35
    L26:
        r119 = null;
        goto L27
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L35:
        r114.recycle();
        return;
    L18:
        r116 = 8;
    L38:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ BotAccessPermissionItem(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
