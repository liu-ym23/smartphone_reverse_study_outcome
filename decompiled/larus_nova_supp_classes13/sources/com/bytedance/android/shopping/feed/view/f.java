package com.bytedance.android.shopping.feed.view;

import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.feed.utils.InflowRedPacketTimer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends FrameLayout implements l1.a {

    public static final class a {
    }

    public interface b {
        void a(c2 r1);
    }

    public final void onStart() {
    }

    static {
        com.bytedance.android.shopping.extensions.b.b(68);
        com.bytedance.android.shopping.extensions.b.b(9);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r0 = if.a.a;
        InflowRedPacketTimer r1 = (InflowRedPacketTimer) InflowRedPacketTimer.b.getValue();
        l1 r2 = r1.a;
        if (r2 == null) goto L5;
        r2.a();
    L5:
        r1.a = null;
        s0.e(this);
    }

    public final void onFinish() {
        throw null;
    }

    private final void setCouponCommonStyle(rd3.c r1) {
        throw null;
    }

    public final void onTick(long r3) {
        int r0 = c2.h;
        c2.a.a(getContext(), r3, false);
    }
}
