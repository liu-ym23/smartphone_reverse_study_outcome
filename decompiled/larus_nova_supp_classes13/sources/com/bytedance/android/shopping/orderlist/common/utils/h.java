package com.bytedance.android.shopping.orderlist.common.utils;

import android.view.Choreographer;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {

    public static final class a implements Choreographer.FrameCallback {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ g b;

        public a(WeakReference r1, g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r2) {
            OrderListFragment r3 = (OrderListFragment) this.a.get();
            if (r3 != null) goto L5;
        L7:
            g r4 = this.b;
            int r0 = r4.a + 1;
            r4.a = r0;
            if (r0 < r4.b) goto L10;
            r4.c.run();
            return;
        L10:
            h.a(r4, this.a);
            return;
        L5:
            if (r3.isRemoving() != true) goto L7;
        }
    }

    public static final void a(g r2, WeakReference<OrderListFragment> r3) {
        Intrinsics.checkNotNullParameter(r2, "runner");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Choreographer.getInstance().postFrameCallback(new a(r3, r2));
    }
}
