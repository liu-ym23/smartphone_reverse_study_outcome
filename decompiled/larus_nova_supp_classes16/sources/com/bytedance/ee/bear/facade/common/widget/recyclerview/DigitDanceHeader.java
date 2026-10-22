package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.h;
import dqa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wa5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0017J \u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0017J\b\u0010&\u001a\u00020'H\u0017J\b\u0010(\u001a\u00020)H\u0017J\u0014\u0010*\u001a\u00020\u001a2\n\u0010+\u001a\u00020,\"\u00020\u000bH\u0017J \u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0017J \u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0017J \u00105\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0017J\u0018\u00106\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u00107\u001a\u00020\u001dH\u0017J\b\u00108\u001a\u00020\u001dH\u0017J \u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<H\u0017J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u000bH\u0016J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u0010H\u0016J\u0012\u0010B\u001a\u00020\u001a2\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/DigitDanceHeader;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/AssociatedHeader;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mTAG", "", "mText", "mCustomText", "mTextView", "Landroid/widget/TextView;", "mSpaceLoadingImage", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceLoadingImage;", "mAssociatedHeader", "mFinishDuration", "initView", "", "onMoving", "isDragging", "", "percent", "", "offset", "headerHeight", "extendHeight", "onReleased", "layout", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "getView", "Landroid/view/View;", "getSpinnerStyle", "Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;", "setPrimaryColors", "colors", "", "onInitialized", "kernel", "Lcom/scwang/smartrefresh/layout/api/RefreshKernel;", "height", "onHorizontalDrag", "percentX", "offsetX", "offsetMax", "onStartAnimator", "onFinish", "success", "isSupportHorizontalDrag", "onStateChanged", "refreshLayout", "oldState", "Lcom/scwang/smartrefresh/layout/constant/RefreshState;", "newState", "setStartNumber", "number", "setCustomText", "text", "setAssociatedHeader", "associatedHeader", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitDanceHeader extends FrameLayout implements a {
    public final String a;
    public String b;
    public String c;
    public TextView d;
    public SpaceLoadingImage e;
    public a f;
    public final int g;

    public final boolean a() {
        return false;
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void f(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "layout");
    }

    public View getView() {
        return this;
    }

    public void setPrimaryColors(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
    }

    public b getSpinnerStyle() {
        return b.d;
    }

    public DigitDanceHeader(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = "DigitDanceHeader";
        this.g = 500;
        k(r2, null);
    }

    @Override // wa5.a
    public void setAssociatedHeader(a r1) {
        this.f = r1;
    }

    @Override // wa5.a
    public void setCustomText(String r4) {
        Intrinsics.checkNotNullParameter(r4, "text");
        tt5.a.h(this.a, "setCustomText text: " + r4);
        this.c = r4;
        a r0 = this.f;
        if (r0 == null) goto L6;
        r0.setCustomText(r4);
        return;
    }

    @Override // wa5.a
    public void setStartNumber(int r4) {
        tt5.a.h(this.a, "setStartNumber number: " + r4);
        this.b = r4 + ' ' + this.c;
        a r0 = this.f;
        if (r0 == null) goto L6;
        r0.setStartNumber(r4);
        return;
    }

    public DigitDanceHeader(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = "DigitDanceHeader";
        this.g = 500;
        k(r2, r3);
    }

    public final int j(SmartRefreshLayout r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        SpaceLoadingImage r0 = this.e;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        TextView r1 = this.d;
        if (r1 == null) goto L8;
        r1.setText(this.b);
    L8:
        TextView r2 = this.d;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        a r5 = this.f;
        if (r5 == null) goto L15;
        r5.j(r3, r4);
    L15:
        return this.g;
    }

    public final void k(Context r2, AttributeSet r3) {
        LayoutInflater.from(r2).inflate(2131560045, this, true);
        SpaceLoadingImage r4 = findViewById(2131369106);
        if (r4 == null) goto L5;
        r4.stop();
    L6:
        this.e = r4;
        this.d = (TextView) findViewById(2131369107);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public DigitDanceHeader(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "DigitDanceHeader";
        this.g = 500;
        k(r2, r3);
    }

    public final void e(h r2, RefreshState r3, RefreshState r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
        a r0 = this.f;
        if (r0 == null) goto L5;
        r0.e(r2, r3, r4);
    L5:
        SpaceLoadingImage r5 = this.e;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r4 != RefreshState.None) goto L10;
        r5.stop();
        return;
    L10:
        UDLoadingDrawable r6 = r5.a;
        if (r6 == null) goto L16;
        r6.start();
        return;
    }

    public final void g(SmartRefreshLayout.j r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "kernel");
        a r0 = this.f;
        if (r0 == null) goto L6;
        r0.g(r2, r3, r4);
        return;
    }

    public final void i(h r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        a r0 = this.f;
        if (r0 == null) goto L6;
        r0.i(r2, r3, r4);
        return;
    }

    public final void b(boolean r9, float r10, int r11, int r12, int r13) {
        if (r9 == false) goto L9;
        SpaceLoadingImage r0 = this.e;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        TextView r1 = this.d;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
    L9:
        a r2 = this.f;
        if (r2 == null) goto L13;
        r2.b(r9, r10, r11, r12, r13);
        return;
    }
}
