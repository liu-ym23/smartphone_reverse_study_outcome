package com.bytedance.android.shopping.widget.ecvideoplayer;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public final ExecutorService a;
    public volatile boolean b;
    public volatile boolean c;
    public final LinkedList<j> d;
    public volatile j e;
    public final Object f;
    public volatile j g;
    public volatile j h;
    public final ECVideoPlayer i;

    public final void e() {
        Object r0 = this.f;
        monitor-enter(r0);
    L35:
        th = move-exception;
        throw th;
    L5:
        if (this.d.size() < 2) goto L32;
        j r1 = this.d.peekLast();     // Catch: Throwable -> L35
        if (r1 != null) goto L10;
        monitor-exit(r0);
        return;
    L10:
        int r3 = this.d.size() - 2;     // Catch: Throwable -> L35
        int r2 = this.d.size() - 1;     // Catch: Throwable -> L35
    L12:
        if (r3 < 0) goto L21;
        int r5 = this.d.get(r3).getType();     // Catch: Throwable -> L35
        if (r1.getType() == 4) goto L18;
        if (r5 == 4) goto L21;
    L18:
        if (r1.getType() == r5) goto L19;
        r3 = r3 - 1;     // Catch: Throwable -> L35
        goto L12
    L19:
        Integer r4 = Integer.valueOf(r3);     // Catch: Throwable -> L35
    L22:
        if (r4 == null) goto L32;
        r4.intValue();     // Catch: Throwable -> L35
        int r6 = a.a;     // Catch: Throwable -> L35
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L35
        r7.append("PlayerTaskExecutor");     // Catch: Throwable -> L35
        r7.append(hashCode());     // Catch: Throwable -> L35
        r7.append(" shrink begin from ");     // Catch: Throwable -> L35
        r7.append(r4);     // Catch: Throwable -> L35
        r7.append(" - ");     // Catch: Throwable -> L35
        r7.append(r2);     // Catch: Throwable -> L35
        r7.append(" queue: ");     // Catch: Throwable -> L35
        int r8 = ECVideoView.h;     // Catch: Throwable -> L35
        r7.append(null);     // Catch: Throwable -> L35
        a.a(r7.toString());     // Catch: Throwable -> L35
        Iterator<j> r9 = this.d.iterator();     // Catch: Throwable -> L35
        Iterator r10 = CollectionsKt.withIndex(r9);     // Catch: Throwable -> L35
    L25:
        if (r10.hasNext() == false) goto L31;
        IndexedValue r11 = (IndexedValue) r10.next();     // Catch: Throwable -> L35
        if (r11.getIndex() < r4.intValue()) goto L25;
        if (r11.getIndex() >= r2) goto L25;
        r9.remove();     // Catch: Throwable -> L35
        goto L25
    L31:
        int r12 = a.a;     // Catch: Throwable -> L35
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L35
        r13.append("PlayerTaskExecutor");     // Catch: Throwable -> L35
        r13.append(hashCode());     // Catch: Throwable -> L35
        r13.append(" shrink end queue: ");     // Catch: Throwable -> L35
        int r14 = ECVideoView.h;     // Catch: Throwable -> L35
        r13.append(null);     // Catch: Throwable -> L35
        a.a(r13.toString());     // Catch: Throwable -> L35
    L21:
        r4 = null;
    L32:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r0);
    }

    public k(ECVideoPlayer r2) {
        Intrinsics.checkNotNullParameter(r2, "ecVideoPlayer");
        this.i = r2;
        this.a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("PlayerTaskExecutor"));
        this.d = new LinkedList();
        this.f = new Object();
        this.h = new f(-1);
    }

    public final void a(j r6) {
        Object r2 = this.f;
        monitor-enter(r2);
        Iterator<j> r3 = this.d.iterator();     // Catch: Throwable -> L16
        int r4 = a.a;     // Catch: Throwable -> L16
        int r0 = ECVideoView.h;     // Catch: Throwable -> L16
        a.a("PlayerTaskExecutor" + hashCode() + " addErrorTask begin queue: null");     // Catch: Throwable -> L16
    L6:
        if (r3.hasNext() == false) goto L13;
        j r1 = r3.next();     // Catch: Throwable -> L16
        if (r1.getType() == 4) goto L13;
        if (r1.getType() == 0) goto L13;
        r3.remove();     // Catch: Throwable -> L16
    L13:
        int r5 = a.a;     // Catch: Throwable -> L16
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L16
        r7.append("PlayerTaskExecutor");     // Catch: Throwable -> L16
        r7.append(hashCode());     // Catch: Throwable -> L16
        r7.append(" addErrorTask end queue: ");     // Catch: Throwable -> L16
        int r8 = ECVideoView.h;     // Catch: Throwable -> L16
        r7.append(null);     // Catch: Throwable -> L16
        a.a(r7.toString());     // Catch: Throwable -> L16
        a.a("PlayerTaskExecutor" + hashCode() + " enqueue to first " + r6.b());     // Catch: Throwable -> L16
        this.d.addFirst(r6);     // Catch: Throwable -> L16
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r2);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final boolean b(j r13) {
        Object r1 = this.f;
        monitor-enter(r1);
        j r2 = this.d.peekFirst();     // Catch: Throwable -> L82
        if (r2 != null) goto L7;
    L8:
        j r3 = this.g;     // Catch: Throwable -> L82
        if (r3 != null) goto L11;
    L14:
        j r4 = this.d.peekLast();     // Catch: Throwable -> L82
        if (r4 != null) goto L17;
        r4 = this.g;     // Catch: Throwable -> L82
    L17:
        if (r4 != null) goto L19;
        r4 = this.h;     // Catch: Throwable -> L82
    L19:
        int r5 = r4.getType();     // Catch: Throwable -> L82
        int r6 = r13.getType();     // Catch: Throwable -> L82
        if (r6 == 0) goto L65;
        if (r6 != 1) goto L23;
        if (r5 != 0) goto L56;
    L62:
        monitor-exit(r1);
        return true;
    L56:
        if ((r4 instanceof m) == true) goto L58;
    L77:
        int r7 = a.a;     // Catch: Throwable -> L82
        a.a("PlayerTaskExecutor" + hashCode() + " can't enqueue " + r13.b() + ", because last is " + r4.b());     // Catch: Throwable -> L82
        monitor-exit(r1);
        return false;
    L58:
        if (((m) r4).c != 0) goto L60;
        boolean r8 = true;
    L61:
        if (r8 == false) goto L77;
    L60:
        r8 = false;
        goto L61
    L23:
        if (r6 == 2) goto L49;
        if (r6 == 4) goto L41;
        if (r6 == 5) goto L38;
        if (r6 != 7) goto L77;
        if (r5 == 0) goto L32;
        if (r5 == 1) goto L32;
        if (r5 != 7) goto L77;
    L32:
        if ((r4 instanceof m) == false) goto L34;
        ((m) r13).c = ((m) r4).c;     // Catch: Throwable -> L82
    L35:
        monitor-exit(r1);
        return true;
    L34:
        ((m) r13).c = r5;     // Catch: Throwable -> L82
        goto L35
    L38:
        if (this.d.isEmpty() == false) goto L77;
        monitor-exit(r1);
        return true;
    L41:
        if (r5 != 2) goto L43;
    L47:
        monitor-exit(r1);
        return true;
    L43:
        if (r5 == (-1)) goto L47;
        if (r5 == 4) goto L47;
        if (r5 == 6) goto L47;
        if (r5 != 5) goto L77;
    L49:
        if (r5 == 0) goto L52;
        if (r5 == 1) goto L52;
        if (r5 != 7) goto L77;
    L52:
        monitor-exit(r1);
        return true;
    L65:
        if ((r4 instanceof m) == true) goto L67;
    L71:
        if (r5 == 6) goto L80;
        if (r5 == 5) goto L80;
        if (r5 == 1) goto L80;
        if (r5 == 2) goto L80;
        if (r5 != 4) goto L77;
    L80:
        monitor-exit(r1);
        return true;
    L67:
        if (((m) r4).c != 1) goto L69;
        boolean r9 = true;
    L70:
        if (r9 == true) goto L80;
    L69:
        r9 = false;
        goto L70
    L11:
        if (r3.getType() != 3) goto L14;
    L12:
        monitor-exit(r1);
        return false;
    L7:
        if (r2.getType() == 3) goto L12;
    L82:
        th = move-exception;
        throw th;
    }

    public final void c(j r7) {
        Intrinsics.checkNotNullParameter(r7, "playerTask");
        Object r2 = this.f;
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.c == false) goto L8;
        monitor-exit(r2);
        return;
    L8:
        Intrinsics.checkNotNullParameter(this, "<set-?>");     // Catch: Throwable -> L26
        r7.a = this;     // Catch: Throwable -> L26
        if (r7.getType() != 3) goto L12;
        this.c = true;     // Catch: Throwable -> L26
        this.d.clear();     // Catch: Throwable -> L26
        int r0 = a.a;     // Catch: Throwable -> L26
        a.a("PlayerTaskExecutor" + hashCode() + " clear all task enqueue " + r7.b());     // Catch: Throwable -> L26
        this.d.add(r7);     // Catch: Throwable -> L26
    L21:
        if (this.b == true) goto L23;
        this.b = true;     // Catch: Throwable -> L26
        d(null);     // Catch: Throwable -> L26
    L23:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r2);
        return;
    L12:
        if (r7.getType() != 10) goto L15;
        this.e = r7;     // Catch: Throwable -> L26
        goto L21
    L15:
        if (r7.getType() != 6) goto L18;
        a(r7);     // Catch: Throwable -> L26
        goto L21
    L18:
        if (b(r7) == false) goto L21;
        int r1 = a.a;     // Catch: Throwable -> L26
        a.a("PlayerTaskExecutor" + hashCode() + " enqueue " + r7.b());     // Catch: Throwable -> L26
        this.d.add(r7);     // Catch: Throwable -> L26
        e();     // Catch: Throwable -> L26
        goto L21
    }

    public final void d(j r7) {
        Object r2 = this.f;
        monitor-enter(r2);
        if (r7 != null) goto L45;
    L8:
        String r4 = null;
        if (r7 == null) goto L16;
        if (r7.getType() != 3) goto L16;
        this.a.shutdown();     // Catch: Throwable -> L26
        this.g = null;     // Catch: Throwable -> L26
        this.b = false;     // Catch: Throwable -> L26
        monitor-exit(r2);
        return;
    L16:
        if (this.e != null) goto L18;
    L28:
        j r8 = this.d.peekFirst();     // Catch: Throwable -> L26
        if (r8 != null) goto L31;
    L36:
        j r9 = this.d.pollFirst();     // Catch: Throwable -> L26
    L37:
        if (r9 != null) goto L39;
        this.g = null;     // Catch: Throwable -> L26
        this.b = false;     // Catch: Throwable -> L26
    L40:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r2);
        return;
    L39:
        int r1 = a.a;     // Catch: Throwable -> L26
        a.a("PlayerTaskExecutor" + hashCode() + " execute next " + r9.b());     // Catch: Throwable -> L26
        this.g = r9;     // Catch: Throwable -> L26
        this.a.execute(r9);     // Catch: Throwable -> L26
        goto L40
    L31:
        if (r8.getType() != 0) goto L36;
        if (this.i.c == false) goto L35;
        r9 = this.d.pollFirst();     // Catch: Throwable -> L26
        goto L37
    L35:
        r9 = null;
        goto L37
    L18:
        if (this.i.g.d != 7) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == true) goto L28;
        j r12 = this.e;     // Catch: Throwable -> L26
        this.e = null;     // Catch: Throwable -> L26
        int r0 = a.a;     // Catch: Throwable -> L26
        StringBuilder r3 = new StringBuilder("PlayerTaskExecutor");     // Catch: Throwable -> L26
        r3.append(hashCode());     // Catch: Throwable -> L26
        r3.append(" execute priority ");     // Catch: Throwable -> L26
        if (r12 == null) goto L25;
        r4 = r12.b();     // Catch: Throwable -> L26
    L25:
        r3.append(r4);     // Catch: Throwable -> L26
        a.a(r3.toString());     // Catch: Throwable -> L26
        this.a.execute(r12);     // Catch: Throwable -> L26
        goto L40
    L20:
        r11 = false;
        goto L21
    L45:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r7.getType() == 10) goto L8;
        this.h = r7;     // Catch: Throwable -> L26
        goto L8
    }
}
