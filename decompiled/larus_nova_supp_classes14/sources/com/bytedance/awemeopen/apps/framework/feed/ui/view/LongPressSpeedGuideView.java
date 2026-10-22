package com.bytedance.awemeopen.apps.framework.feed.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import c04.g;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r14.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\f\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/LongPressSpeedGuideView;", "Landroid/widget/FrameLayout;", "", "getLayoutId", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", "b", "Lkotlin/Lazy;", "getMLeftRipple", "()Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", "mLeftRipple", "c", "getMRightRipple", "mRightRipple", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LongPressSpeedGuideView extends FrameLayout {
    public final View a;
    public final Lazy b;
    public final Lazy c;
    public c d;

    public LongPressSpeedGuideView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LongPressSpeedGuideView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getLayoutId() {
        return 2131561094;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    private final PinchRippleContainer getMLeftRipple() {
        return (PinchRippleContainer) this.b.getValue();
    }

    private final PinchRippleContainer getMRightRipple() {
        return (PinchRippleContainer) this.c.getValue();
    }

    public final void a(c r2) {
        int r0 = g.a;
        if (g.a(this.d) == true) goto L5;
        return;
    L5:
        this.d = r2;
        setAlpha(1.0f);
        setVisibility(0);
        int r3 = (int) (d0.d(getContext()) * 0.19f);
        getMLeftRipple().getLayoutParams().width = r3;
        getMRightRipple().getLayoutParams().width = r3;
        getMLeftRipple().invalidate();
        getMRightRipple().invalidate();
    }

    public LongPressSpeedGuideView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = LayoutInflater.from(r2).inflate(getLayoutId(), this);
        this.b = LazyKt.lazy(new LongPressSpeedGuideView$mLeftRipple$2(this));
        this.c = LazyKt.lazy(new LongPressSpeedGuideView$mRightRipple$2(this));
    }

    public /* synthetic */ LongPressSpeedGuideView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
