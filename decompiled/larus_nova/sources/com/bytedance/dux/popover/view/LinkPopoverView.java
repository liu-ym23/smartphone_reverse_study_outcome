package com.bytedance.dux.popover.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.largefont.a;
import com.bytedance.dux.popover.PopoverLinearLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/dux/popover/view/LinkPopoverView;", "Lcom/bytedance/dux/popover/PopoverLinearLayout;", "", "resId", "", "setLeftIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "", "charSequence", "setTips", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTvTips", "()Landroid/widget/TextView;", "tvTips", "d", "getIvArrow", "ivArrow", "dux_release"}, k = 1, mv = {1, 7, 1})
public class LinkPopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f205483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f205484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f205485d;

    public LinkPopoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public LinkPopoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final void a() {
        if (getLimitLargeFontScale() == true) goto L5;
        return;
    L5:
        a.c(this.f205484c, 14.0f);
        a.a(this.f205483b, 20, 20);
        a.a(this.f205485d, 12, 12);
    }

    public final ImageView getIvArrow() {
        return this.f205485d;
    }

    public final ImageView getIvIcon() {
        return this.f205483b;
    }

    public final TextView getTvTips() {
        return this.f205484c;
    }

    public void setLeftIcon(int r100) {
        this.f205483b.setImageResource(r100);
        n.f(this.f205483b);
    }

    public final void setTips(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        this.f205484c.setText(r100);
    }

    public void setLeftIcon(Drawable r100) {
        this.f205483b.setImageDrawable(r100);
        n.f(this.f205483b);
    }

    public LinkPopoverView(Context r100, AttributeSet r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LinearLayout.inflate(r100, R.layout.dux_popover_link_view, this);
        setOrientation(0);
        Resources r103 = Resources.getSystem();
        int r104 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        setPadding(r104, r104, r104, r104);
        setBackground(ContextCompat.getDrawable(r100, R.drawable.dux_popover_view_bg));
        this.f205483b = (ImageView) findViewById(R.id.iv_icon);
        this.f205484c = (TextView) findViewById(R.id.tv_tips);
        this.f205485d = (ImageView) findViewById(R.id.iv_arrow);
        a();
    }

    public /* synthetic */ LinkPopoverView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, false);
    }
}
