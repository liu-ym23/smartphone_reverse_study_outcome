package com.bytedance.awemeopen.apps.framework.feed.ui.panelswitch;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.infra.util.e;
import java.util.LinkedHashMap;
import k14.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\n\u0010B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/panelswitch/BottomPanelSwitch;", "Landroid/widget/FrameLayout;", "", "state", "", "setBottomPanelSwitchState", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/panelswitch/BottomPanelSwitch$b;", "listener", "setSwitchListener", "Lk14/c;", "a", "Lkotlin/Lazy;", "getBottomPanelSwitchTrackView", "()Lk14/c;", "bottomPanelSwitchTrackView", "Lk14/b;", "b", "getBottomPanelSwitchThumbView", "()Lk14/b;", "bottomPanelSwitchThumbView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class BottomPanelSwitch extends FrameLayout {
    public static final int e = 0;
    public final Lazy a;
    public final Lazy b;
    public b c;
    public boolean d;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a();

        void b();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    static {
        new a();
        e = e.a(y54.a.a(), 2.0f);
    }

    private final k14.b getBottomPanelSwitchThumbView() {
        return (k14.b) this.b.getValue();
    }

    private final c getBottomPanelSwitchTrackView() {
        return (c) this.a.getValue();
    }

    public static void a(BottomPanelSwitch r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        ValueAnimator r2 = null;
        if (r5.d == false) goto L20;
        c r0 = r5.getBottomPanelSwitchTrackView();
        r0.d = Integer.valueOf(r0.b);
        r0.invalidate();
        k14.b r1 = r5.getBottomPanelSwitchThumbView();
        ValueAnimator r4 = r1.g;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("turnOnAnimator");
        r4 = null;
    L8:
        if (r4.isRunning() == false) goto L13;
        ValueAnimator r6 = r1.g;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("turnOnAnimator");
        r6 = null;
    L12:
        r6.cancel();
    L13:
        ValueAnimator r3 = r1.f;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("turnOffAnimator");
    L17:
        r2.start();
        b r7 = r5.c;
        if (r7 == null) goto L36;
        r7.b();
    L36:
        r5.d = !r5.d;
        return;
    L16:
        r2 = r3;
        goto L17
    L20:
        c r8 = r5.getBottomPanelSwitchTrackView();
        r8.d = Integer.valueOf(r8.a);
        r8.invalidate();
        k14.b r9 = r5.getBottomPanelSwitchThumbView();
        ValueAnimator r10 = r9.f;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("turnOffAnimator");
        r10 = null;
    L24:
        if (r10.isRunning() == false) goto L29;
        ValueAnimator r11 = r9.f;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("turnOffAnimator");
        r11 = null;
    L28:
        r11.cancel();
    L29:
        ValueAnimator r12 = r9.g;
        if (r12 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("turnOnAnimator");
    L33:
        r2.start();
        b r13 = r5.c;
        if (r13 == null) goto L36;
        r13.a();
        goto L36
    L32:
        r2 = r12;
        goto L33
    }

    public final void setBottomPanelSwitchState(boolean r2) {
        this.d = r2;
        getBottomPanelSwitchTrackView().setTrackState(r2);
        getBottomPanelSwitchThumbView().setThumbState(r2);
    }

    public final void setSwitchListener(b r1) {
        this.c = r1;
    }

    public BottomPanelSwitch(final Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "attributeSet");
        new LinkedHashMap();
        super(r10, r11);
        this.a = LazyKt.lazy(new BottomPanelSwitch$bottomPanelSwitchTrackView$2(r10));
        this.b = LazyKt.lazy(new BottomPanelSwitch$bottomPanelSwitchThumbView$2(r10));
        this.d = true;
        TypedArray r12 = r10.obtainStyledAttributes(r11, new int[]{2130974561, 2130974562, 2130974640, 2130974641, 2130974645, 2130974646, 2130974647});
        float r13 = r12.getDimension(6, e.a(y54.a.a(), 43.0f));
        float r1 = r12.getDimension(3, e.a(y54.a.a(), 25.0f));
        int r2 = r12.getColor(5, -65536);
        int r3 = r12.getColor(4, -7829368);
        float r4 = r12.getDimension(2, e.a(y54.a.a(), 44.0f));
        float r6 = r12.getDimension(1, e.a(y54.a.a(), 10.5f));
        int r7 = r12.getColor(0, -1);
        r12.recycle();
        c r14 = getBottomPanelSwitchTrackView();
        r14.c = r4;
        r14.a = r2;
        r14.b = r3;
        addView(getBottomPanelSwitchTrackView(), new FrameLayout.LayoutParams((int) r13, (int) r1));
        int r15 = e;
        float r5 = 2 * r6;
        int r16 = (int) ((r13 - r15) - r5);
        k14.b r8 = getBottomPanelSwitchThumbView();
        r8.a = r7;
        r8.b = r6;
        r8.d = r16;
        r8.e = r15;
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{r16, r15});
        r9.setDuration(300);
        r9.addUpdateListener(new k14.a(r8));
        r8.f = r9;
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{r15, r16});
        r0.setDuration(300);
        r0.addUpdateListener(new k14.a(r8));
        r8.g = r0;
        int r17 = (int) r5;
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(r17, r17);
        r18.setMarginStart(r16);
        r18.topMargin = r15;
        addView(getBottomPanelSwitchThumbView(), r18);
        setOnClickListener(new com.bytedance.awemeopen.apps.framework.feed.ui.panelswitch.a(this));
    }
}
