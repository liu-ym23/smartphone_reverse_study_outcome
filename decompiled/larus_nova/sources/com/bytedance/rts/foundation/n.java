package com.bytedance.rts.foundation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<s> f267582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f267583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<s> f267584c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f267585a;

        public a(s r100) {
            this.f267585a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n.a(this.f267585a.f267592e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public n() {
        this.f267582a = new LinkedList();
        this.f267583b = new Handler(Looper.getMainLooper());
        this.f267584c = new LinkedList();
    }

    public static final void a(n r110) {
    L3:
        if (r110.f267584c.isEmpty() == true) goto L7;
        s r100 = (s) ((LinkedList) r110.f267584c).poll();
        if (r100 == null) goto L3;
        r100.f267588a.invoke();
        goto L3
    L7:
        LinkedList r101 = new LinkedList(r110.f267582a);
        long r102 = Long.MAX_VALUE;
    L9:
        if (r101.isEmpty() == true) goto L33;
        s r103 = (s) r101.poll();
        if (r103 == null) goto L9;
        if (r103.f267589b < SystemClock.uptimeMillis()) goto L14;
        long r104 = r103.f267589b;
        if (r102 <= r104) goto L9;
        r102 = r104;
        goto L9
    L14:
        long r105 = SystemClock.uptimeMillis();
        r103.f267588a.invoke();
    L16:
        if (r110.f267584c.isEmpty() == true) goto L21;
        s r106 = (s) ((LinkedList) r110.f267584c).poll();
        if (r106 == null) goto L16;
        r106.f267588a.invoke();
        goto L16
    L21:
        if (r103.f267591d == false) goto L28;
        if (((LinkedList) r110.f267582a).contains(r103) == false) goto L28;
        long r107 = r105 + r103.f267590c;
        r103.f267589b = r107;
        if (r102 <= r107) goto L27;
        r102 = r107;
    L27:
        ((LinkedList) r110.f267582a).remove(r103);
        ((LinkedList) r110.f267582a).add(r103);
    L28:
        ((LinkedList) r110.f267582a).remove(r103);
        goto L9
    L33:
        if (r102 == Long.MAX_VALUE) goto L60;
        r110.f267583b.postAtTime(new p(r110), r102);
        return;
    }

    public final s b(Function0<Unit> r100, long r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "action");
        s r102 = new s(r100, this, r101, r110);
        ((LinkedList) this.f267582a).add(r102);
        this.f267583b.postDelayed(new a(r102), r101);
        return r102;
    }
}
