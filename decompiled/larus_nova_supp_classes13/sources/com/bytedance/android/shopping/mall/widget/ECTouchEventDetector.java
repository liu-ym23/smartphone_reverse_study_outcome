package com.bytedance.android.shopping.mall.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewConfiguration;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class ECTouchEventDetector {
    public final int a;
    public final int b;
    public final Lazy c;
    public long d;
    public int e;
    public int f;
    public final a g;

    public final class a implements Runnable {
        public final Handler a;
        public final /* synthetic */ ECTouchEventDetector b;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ECTouchEventDetector r2) {
            this.b = r2;
            this.a = new Handler(Looper.getMainLooper());
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void c(int r1, int r2, int r3, int r4);

    public ECTouchEventDetector() {
        this.a = ViewConfiguration.getTapTimeout();
        this.b = ViewConfiguration.getLongPressTimeout();
        this.c = LazyKt.lazy(new ECTouchEventDetector$touchSlop$2(this));
        this.d = Long.MAX_VALUE;
        this.e = -1;
        this.f = -1;
        this.g = new a(this);
    }
}
