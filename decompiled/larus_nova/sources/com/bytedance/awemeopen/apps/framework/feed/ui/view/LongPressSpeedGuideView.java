package com.bytedance.awemeopen.apps.framework.feed.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import c04.g;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r14.c;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\f\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/LongPressSpeedGuideView;", "Landroid/widget/FrameLayout;", "", "getLayoutId", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", "b", "Lkotlin/Lazy;", "getMLeftRipple", "()Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", "mLeftRipple", "c", "getMRightRipple", "mRightRipple", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LongPressSpeedGuideView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f196803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f196804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f196805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f196806d;

    public LongPressSpeedGuideView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LongPressSpeedGuideView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getLayoutId() {
        return R.layout.familiar_speed_long_press_fast_speed_guide;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    private final PinchRippleContainer getMLeftRipple() {
        return (PinchRippleContainer) this.f196804b.getValue();
    }

    private final PinchRippleContainer getMRightRipple() {
        return (PinchRippleContainer) this.f196805c.getValue();
    }

    public final void a(c r100) {
        int r101 = g.f21925a;
        if (g.a(this.f196806d) == true) goto L5;
        return;
    L5:
        this.f196806d = r100;
        setAlpha(1.0f);
        setVisibility(0);
        int r102 = (int) (d0.d(getContext()) * 0.19f);
        getMLeftRipple().getLayoutParams().width = r102;
        getMRightRipple().getLayoutParams().width = r102;
        getMLeftRipple().invalidate();
        getMRightRipple().invalidate();
    }

    public LongPressSpeedGuideView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f196803a = LayoutInflater.from(r100).inflate(getLayoutId(), this);
        this.f196804b = LazyKt.lazy(new LongPressSpeedGuideView$mLeftRipple$2(this));
        this.f196805c = LazyKt.lazy(new LongPressSpeedGuideView$mRightRipple$2(this));
    }

    public /* synthetic */ LongPressSpeedGuideView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
