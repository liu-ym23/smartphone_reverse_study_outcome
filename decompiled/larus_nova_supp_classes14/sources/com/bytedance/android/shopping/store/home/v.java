package com.bytedance.android.shopping.store.home;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v implements com.bytedance.android.ec.store.view.r {
    public boolean a;
    public final a b;
    public final /* synthetic */ ECStoreTabKitFragment c;

    public static final class a extends Handler {
        public final /* synthetic */ v a;

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            if (r3.what != 0) goto L8;
            v r4 = this.a;
            if (r4.a == true) goto L9;
            r4.a = true;
            com.bytedance.android.ec.core.arch.event.c.d(r4.c.V90(), new kj3.d(true));
            return;
        L9:
            return;
        }

        public a(v r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public v(ECStoreTabKitFragment r2) {
        this.c = r2;
        this.a = true;
        this.b = new a(this, Looper.getMainLooper());
    }

    public final void c(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getAction() != 1) goto L5;
    L12:
        this.b.sendEmptyMessageDelayed(0, 2000);
        return;
    L5:
        if (r4.getAction() == 3) goto L12;
        if (r4.getAction() != 0) goto L14;
        this.b.removeMessages(0);
        if (this.a == false) goto L15;
        this.a = false;
        com.bytedance.android.ec.core.arch.event.c.d(this.c.V90(), new kj3.d(false));
        return;
    L15:
        return;
    }
}
