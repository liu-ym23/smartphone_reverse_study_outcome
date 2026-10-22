package com.bytedance.android.shopping.mall.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/mall/widget/ECDetectableFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/mall/widget/ECTouchEventDetector;", "a", "Lcom/bytedance/android/shopping/mall/widget/ECTouchEventDetector;", "getTouchEventDetector", "()Lcom/bytedance/android/shopping/mall/widget/ECTouchEventDetector;", "setTouchEventDetector", "(Lcom/bytedance/android/shopping/mall/widget/ECTouchEventDetector;)V", "touchEventDetector", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECDetectableFrameLayout extends FrameLayout {
    public ECTouchEventDetector a;

    public ECDetectableFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECDetectableFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ECTouchEventDetector getTouchEventDetector() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "ev");
        ECTouchEventDetector r0 = this.a;
        if (r0 == null) goto L42;
        Intrinsics.checkNotNullParameter(this, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r12, "motionEvent");
        int r1 = getLeft();
        int r2 = getRight();
        int r3 = (int) r12.getRawX();
        if (r1 > r3) goto L42;
        if (r2 < r3) goto L42;
        int r4 = getTop();
        int r5 = getBottom();
        int r6 = (int) r12.getRawY();
        if (r4 > r6) goto L42;
        if (r5 < r6) goto L42;
        int r7 = r12.getActionMasked();
        if (r7 != 0) goto L15;
        r0.d = System.currentTimeMillis();
        r0.e = (int) r12.getRawX();
        r0.f = (int) r12.getRawY();
        ECTouchEventDetector.a r8 = r0.g;
        r8.a.postDelayed(r8, r8.b.b);
        goto L42
    L15:
        if (r7 == 1) goto L28;
        if (r7 != 2) goto L18;
    L20:
        int r9 = (int) r12.getRawX();
        int r10 = (int) r12.getRawY();
        if (Math.abs(r9 - r0.e) <= ((Number) r0.c.getValue()).intValue()) goto L23;
    L24:
        ECTouchEventDetector.a r11 = r0.g;
        r11.a.removeCallbacks(r11);
    L26:
        if ((System.currentTimeMillis() - r0.d) > r0.a) goto L42;
        r0.d = Long.MAX_VALUE;
        goto L42
    L23:
        if (Math.abs(r10 - r0.f) <= ((Number) r0.c.getValue()).intValue()) goto L26;
    L18:
        if (r7 == 3) goto L20;
    L28:
        long r13 = System.currentTimeMillis() - r0.d;
        long r14 = r0.b;
        if (0 <= r13) goto L32;
    L34:
        int r15 = (int) r12.getRawX();
        int r16 = (int) r12.getRawY();
        int r17 = Math.abs(r15 - r0.e);
        int r18 = Math.abs(r16 - r0.f);
        if (r17 > (((Number) r0.c.getValue()).intValue() * 7)) goto L37;
    L39:
        ECTouchEventDetector.a r19 = r0.g;
        r19.a.removeCallbacks(r19);
        r0.d = Long.MAX_VALUE;
        goto L42
    L37:
        if (r18 >= (r17 / 2)) goto L39;
        r0.c(r0.e, r0.f, r15, r16);
        goto L39
    L32:
        if (r14 <= r13) goto L34;
        r0.a();
    L42:
        return super.dispatchTouchEvent(r12);
    }

    public final void setTouchEventDetector(ECTouchEventDetector r1) {
        this.a = r1;
    }

    public ECDetectableFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECDetectableFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
