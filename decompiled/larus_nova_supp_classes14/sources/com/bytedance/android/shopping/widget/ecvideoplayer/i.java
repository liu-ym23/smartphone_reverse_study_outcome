package com.bytedance.android.shopping.widget.ecvideoplayer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public final ReentrantLock a;
    public final Condition b;
    public int c;
    public volatile int d;

    public i() {
        ReentrantLock r0 = new ReentrantLock();
        this.a = r0;
        this.b = r0.newCondition();
    }

    public static String b(int[] r7) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L9;
        int r4 = r7[r2];
        int r5 = r3 + 1;
        int r6 = ECVideoPlayer.r;
        r0.append(ECVideoPlayer.a.a(r4));
        if (r3 == (r7.length - 1)) goto L7;
        r0.append(",");
    L7:
        r2 = r2 + 1;
        r3 = r5;
        goto L3
    L9:
        return r0.toString();
    }

    public final void a(int r3) {
        this.a.lock();
        int r0 = a.a;
        StringBuilder r1 = new StringBuilder("PlayerTaskExecutor");
        r1.append(this.c);
        r1.append(" ChangeState ");
        int r2 = ECVideoPlayer.r;
        r1.append(ECVideoPlayer.a.a(r3));
        a.a(r1.toString());
        this.d = r3;
        this.b.signalAll();
        this.a.unlock();
    }

    public final boolean c(int... r6) {
        int r0 = a.a;
        StringBuilder r1 = new StringBuilder("PlayerTaskExecutor");
        r1.append(this.c);
        r1.append(" Syncing TargetStates ");
        r1.append(b(r6));
        r1.append(" currentState=");
        int r2 = ECVideoPlayer.r;
        r1.append(ECVideoPlayer.a.a(this.d));
        a.a(r1.toString());
        this.a.lock();
    L4:
        if (ArraysKt.contains(r6, this.d) == true) goto L15;
        if (this.d != (-1)) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L13;
        this.b.await();
        goto L4
    L13:
        boolean r7 = false;
    L16:
        int r4 = a.a;
        a.a("PlayerTaskExecutor" + this.c + " SyncToTargetStates " + b(new int[]{this.d}) + " success=" + r7);
        this.a.unlock();
        return r7;
    L8:
        if (this.d == 6) goto L11;
        r3 = false;
        goto L12
    L15:
        r7 = true;
        goto L16
    }
}
