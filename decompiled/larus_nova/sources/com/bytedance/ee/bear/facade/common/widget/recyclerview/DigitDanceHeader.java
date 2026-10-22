package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.ss.android.lark.utils.statistics.PerfLog;
import cqa.h;
import dqa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wa5.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0017J \u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0017J\b\u0010&\u001a\u00020'H\u0017J\b\u0010(\u001a\u00020)H\u0017J\u0014\u0010*\u001a\u00020\u001a2\n\u0010+\u001a\u00020,\"\u00020\u000bH\u0017J \u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0017J \u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0017J \u00105\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0017J\u0018\u00106\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u00107\u001a\u00020\u001dH\u0017J\b\u00108\u001a\u00020\u001dH\u0017J \u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<H\u0017J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u000bH\u0016J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u0010H\u0016J\u0012\u0010B\u001a\u00020\u001a2\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/DigitDanceHeader;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/facade/common/widget/recyclerview/AssociatedHeader;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mTAG", "", "mText", "mCustomText", "mTextView", "Landroid/widget/TextView;", "mSpaceLoadingImage", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceLoadingImage;", "mAssociatedHeader", "mFinishDuration", "initView", "", "onMoving", "isDragging", "", "percent", "", "offset", "headerHeight", "extendHeight", "onReleased", "layout", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "getView", "Landroid/view/View;", "getSpinnerStyle", "Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;", "setPrimaryColors", "colors", "", "onInitialized", "kernel", "Lcom/scwang/smartrefresh/layout/api/RefreshKernel;", "height", "onHorizontalDrag", "percentX", "offsetX", "offsetMax", "onStartAnimator", "onFinish", "success", "isSupportHorizontalDrag", "onStateChanged", "refreshLayout", "oldState", "Lcom/scwang/smartrefresh/layout/constant/RefreshState;", "newState", "setStartNumber", "number", "setCustomText", "text", "setAssociatedHeader", "associatedHeader", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitDanceHeader extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f226656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f226657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f226658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f226659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SpaceLoadingImage f226660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f226661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f226662g;

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layout");
    }

    @Override // cqa.f
    public View getView() {
        return this;
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
    }

    @Override // cqa.f
    public b getSpinnerStyle() {
        return b.f469717d;
    }

    public DigitDanceHeader(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f226656a = "DigitDanceHeader";
        this.f226662g = 500;
        k(r100, null);
    }

    @Override // wa5.a
    public void setAssociatedHeader(a r100) {
        this.f226661f = r100;
    }

    @Override // wa5.a
    public void setCustomText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        tt5.a.h(this.f226656a, "setCustomText text: " + r100);
        this.f226658c = r100;
        a r101 = this.f226661f;
        if (r101 == null) goto L6;
        r101.setCustomText(r100);
        return;
    }

    @Override // wa5.a
    public void setStartNumber(int r100) {
        tt5.a.h(this.f226656a, "setStartNumber number: " + r100);
        this.f226657b = r100 + ' ' + this.f226658c;
        a r101 = this.f226661f;
        if (r101 == null) goto L6;
        r101.setStartNumber(r100);
        return;
    }

    public DigitDanceHeader(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f226656a = "DigitDanceHeader";
        this.f226662g = 500;
        k(r100, r101);
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        SpaceLoadingImage r102 = this.f226660e;
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        TextView r103 = this.f226659d;
        if (r103 == null) goto L8;
        r103.setText(this.f226657b);
    L8:
        TextView r104 = this.f226659d;
        if (r104 == null) goto L11;
        r104.setVisibility(0);
    L11:
        a r105 = this.f226661f;
        if (r105 == null) goto L15;
        r105.j(r100, r101);
    L15:
        return this.f226662g;
    }

    public final void k(Context r100, AttributeSet r101) {
        LayoutInflater.from(r100).inflate(R.layout.digit_refresh_header, this, true);
        SpaceLoadingImage r102 = (SpaceLoadingImage) findViewById(R.id.digit_refresh_progress);
        if (r102 == null) goto L5;
        r102.stop();
    L6:
        this.f226660e = r102;
        this.f226659d = (TextView) findViewById(R.id.digit_text);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public DigitDanceHeader(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f226656a = "DigitDanceHeader";
        this.f226662g = 500;
        k(r100, r101);
    }

    @Override // gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
        a r103 = this.f226661f;
        if (r103 == null) goto L5;
        r103.e(r100, r101, r102);
    L5:
        SpaceLoadingImage r104 = this.f226660e;
        if (r104 != null) goto L8;
        return;
    L8:
        if (r102 != RefreshState.None) goto L10;
        r104.stop();
        return;
    L10:
        UDLoadingDrawable r105 = r104.f240350a;
        if (r105 == null) goto L16;
        r105.start();
        return;
    }

    @Override // cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "kernel");
        a r103 = this.f226661f;
        if (r103 == null) goto L6;
        r103.g(r100, r101, r102);
        return;
    }

    @Override // cqa.f
    public final void i(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        a r103 = this.f226661f;
        if (r103 == null) goto L6;
        r103.i(r100, r101, r102);
        return;
    }

    @Override // cqa.f
    public final void b(boolean r100, float r110, int r111, int r112, int r113) {
        if (r100 == false) goto L9;
        SpaceLoadingImage r101 = this.f226660e;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
    L6:
        TextView r102 = this.f226659d;
        if (r102 == null) goto L9;
        r102.setVisibility(8);
    L9:
        a r103 = this.f226661f;
        if (r103 == null) goto L13;
        r103.b(r100, r110, r111, r112, r113);
        return;
    }
}
