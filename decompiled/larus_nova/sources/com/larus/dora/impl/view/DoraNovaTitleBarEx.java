package com.larus.dora.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.alipay.sdk.m.x.d;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.dora.impl.databinding.LarusDoraWidgetTitlebarExBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\nJ\"\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J)\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010#J,\u0010$\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\"\u0010'\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010(\u001a\u00020\u0012J\u0006\u0010)\u001a\u00020\u0012J\u0006\u0010*\u001a\u00020+J\"\u0010,\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u001fJ\u0006\u0010/\u001a\u00020\u0012J\u0006\u00100\u001a\u00020\u0012J\u0006\u00101\u001a\u00020\u0012R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00062"}, d2 = {"Lcom/larus/dora/impl/view/DoraNovaTitleBarEx;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/dora/impl/databinding/LarusDoraWidgetTitlebarExBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraWidgetTitlebarExBinding;", "init", "", d.f25925o, "title", "", "color", "listener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "updateTitleVisibility", RemoteMessageConst.Notification.VISIBILITY, "showLeftImg", "resId", "staticColor", "", "showLeftText", "text", "", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "showRightImgSec", "alpha", "", "showRightImg", "hideRightImg", "hideLeftImg", "getRightImg", "Landroid/view/View;", "showRightText", "setRightTextEnable", "enable", "showRightLoading", "hideRightLoading", "hideRightView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraNovaTitleBarEx extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusDoraWidgetTitlebarExBinding f338203a;

    public final LarusDoraWidgetTitlebarExBinding getBinding() {
        LarusDoraWidgetTitlebarExBinding r100 = this.f338203a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final View getRightImg() {
        return getBinding().f333315d;
    }

    public DoraNovaTitleBarEx(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        R5(r100, null);
    }

    public final void setRightTextEnable(boolean r100) {
        LarusDoraWidgetTitlebarExBinding r101 = getBinding();
        r101.f333317f.setEnabled(r100);
        TextView r102 = r101.f333317f;
        if (r100 == false) goto L5;
        float r103 = 1.0f;
    L6:
        r102.setAlpha(r103);
        return;
    L5:
        r103 = 0.3f;
        goto L6
    }

    public DoraNovaTitleBarEx(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        R5(r100, r101);
    }

    public static void S5(DoraNovaTitleBarEx r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "title");
        LarusDoraWidgetTitlebarExBinding r102 = r100.getBinding();
        r102.f333318g.setVisibility(0);
        r102.f333318g.setText(r101);
    }

    public static void T5(DoraNovaTitleBarEx r100, View.OnClickListener r101) {
        LarusDoraWidgetTitlebarExBinding r102 = r100.getBinding();
        r102.f333313b.setVisibility(0);
        r102.f333313b.setColorFilter(ContextCompat.getColor(r100.getContext(), R.color.larus_neutral_100));
        r102.f333314c.setVisibility(8);
        r102.f333313b.setImageResource(R.drawable.larus_dora_ic_left_back);
        e1.c(r102.f333313b, r101);
    }

    public static void U5(DoraNovaTitleBarEx r100, View.OnClickListener r101) {
        LarusDoraWidgetTitlebarExBinding r102 = r100.getBinding();
        r102.f333315d.setVisibility(0);
        r102.f333317f.setVisibility(8);
        r102.f333316e.setVisibility(8);
        r102.f333315d.setImageResource(R.drawable.larus_dora_ic_title_add);
        r102.f333315d.setColorFilter(ContextCompat.getColor(r100.getContext(), R.color.larus_neutral_100));
        e1.c(r102.f333315d, r101);
    }

    public final void R5(Context r100, AttributeSet r110) {
        LayoutInflater.from(r100).inflate(R.layout.larus_dora_widget_titlebar_ex, this);
        int r101 = R.id.left_img;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(this, R.id.left_img);
        if (r102 == null) goto L19;
        r101 = R.id.left_text;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.left_text);
        if (r103 == null) goto L19;
        r101 = R.id.right_img;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.right_img);
        if (r104 == null) goto L19;
        r101 = R.id.right_img_sec;
        if (((ImageView) ViewBindings.findChildViewById(this, R.id.right_img_sec)) == null) goto L19;
        r101 = R.id.right_loading;
        ProgressBar r105 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.right_loading);
        if (r105 == null) goto L19;
        r101 = R.id.right_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.right_text);
        if (r106 == null) goto L19;
        r101 = R.id.title_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, R.id.title_text);
        if (r107 == null) goto L19;
        this.f338203a = new LarusDoraWidgetTitlebarExBinding(this, r102, r103, r104, r105, r106, r107);
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r101)));
    }

    public DoraNovaTitleBarEx(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        R5(r100, r101);
    }
}
