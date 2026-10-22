package com.larus.profile.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.larus.profile.impl.databinding.LarusCommonRedDotImageViewBinding;
import com.larus.profile.impl.databinding.LarusWidgetMineTabTitleBarBinding;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\nJ\"\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\nJ\u001c\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%J\u001c\u0010&\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/profile/impl/view/MineTabTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/profile/impl/databinding/LarusWidgetMineTabTitleBarBinding;", "binding", "getBinding", "()Lcom/larus/profile/impl/databinding/LarusWidgetMineTabTitleBarBinding;", "init", "", com.alipay.sdk.m.x.d.f25925o, "title", "", "listener", "Landroid/view/View$OnClickListener;", "updateTitleVisibility", RemoteMessageConst.Notification.VISIBILITY, "showRightImg", "resId", "accessibilityContent", "showLeftImg", "showRedDotImg", "updateRedDotUnreadCount", "count", "setLeftCustomView", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setRightCustomView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MineTabTitleBar extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f366876b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusWidgetMineTabTitleBarBinding f366877a;

    public final LarusWidgetMineTabTitleBarBinding getBinding() {
        LarusWidgetMineTabTitleBarBinding r100 = this.f366877a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public MineTabTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        R5(r100, null);
    }

    public final void V5(int r100) {
        LarusWidgetMineTabTitleBarBinding r101 = getBinding();
        if (r100 == 0) goto L5;
    L10:
        r101.f366564g.setVisibility(r100);
        return;
    L5:
        if (getBinding().f366560c.getVisibility() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        r100 = 8;
        goto L10
    L7:
        r102 = false;
        goto L8
    }

    public MineTabTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        R5(r100, r101);
    }

    public static void S5(MineTabTitleBar r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "title");
        LarusWidgetMineTabTitleBarBinding r102 = r100.getBinding();
        if (r100.getBinding().f366560c.getVisibility() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r102.f366564g.setVisibility(8);
        return;
    L8:
        r102.f366564g.setVisibility(0);
        r102.f366564g.setText(r101);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void R5(Context r100, AttributeSet r110) {
        LayoutInflater.from(r100).inflate(R.layout.larus_widget_mine_tab_title_bar, this);
        int r101 = R.id.layout_stub_left;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.layout_stub_left);
        if (r102 == null) goto L17;
        r101 = R.id.layout_stub_right;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.layout_stub_right);
        if (r103 == null) goto L17;
        r101 = R.id.left_img;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.left_img);
        if (r104 == null) goto L17;
        r101 = R.id.red_dot_img;
        CommonRedDotImageView r105 = (CommonRedDotImageView) ViewBindings.findChildViewById(this, R.id.red_dot_img);
        if (r105 == null) goto L17;
        r101 = R.id.right_img;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(this, R.id.right_img);
        if (r106 == null) goto L17;
        r101 = R.id.title_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, R.id.title_text);
        if (r107 == null) goto L17;
        this.f366877a = new LarusWidgetMineTabTitleBarBinding(this, r102, r103, r104, r105, r106, r107);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r101)));
    }

    public final void T5(int r100, View.OnClickListener r101) {
        LarusWidgetMineTabTitleBarBinding r102 = getBinding();
        r102.f366562e.setVisibility(0);
        LarusCommonRedDotImageViewBinding r103 = r102.f366562e.f366875a;
        if (r103 == null) goto L5;
        r103.f366430b.setImageResource(r100);
    L5:
        e1.c(r102.f366562e, r101);
    }

    public final void U5(String r100, View.OnClickListener r101) {
        Intrinsics.checkNotNullParameter(r100, "accessibilityContent");
        LarusWidgetMineTabTitleBarBinding r102 = getBinding();
        r102.f366563f.setVisibility(0);
        r102.f366563f.setImageResource(R.drawable.larus_ic_flow_settings);
        r102.f366563f.setColorFilter(ContextCompat.getColor(getContext(), R.color.larus_neutral_100));
        r102.f366563f.setContentDescription(r100);
        e1.c(r102.f366563f, r101);
    }

    public MineTabTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        R5(r100, r101);
    }
}
