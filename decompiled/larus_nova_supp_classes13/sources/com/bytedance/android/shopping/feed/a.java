package com.bytedance.android.shopping.feed;

import android.os.Looper;
import android.os.MessageQueue;
import java.util.LinkedList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> {
    public final LinkedList<T> a;
    public int b;
    public boolean c;
    public final C0063a d;
    public final Function0<T> e;
    public int f;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.a$a, reason: collision with other inner class name */
    public static final class C0063a implements MessageQueue.IdleHandler {
        public final /* synthetic */ a a;

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            a r0 = this.a;
            if (r0.b < r0.f) goto L5;
        L7:
            r0.c = false;
        L8:
            return false;
        L5:
            if (r0.c == false) goto L7;
            this.a.a.add((T) r0.e.invoke());
            this.a.b++;
            Looper.myQueue().addIdleHandler(this);
            goto L8
        }

        public C0063a(a r1) {
            this.a = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends T> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        this.e = r2;
        this.f = r3;
        this.a = new LinkedList();
        this.d = new C0063a(this);
    }
}
