package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends TimerTask {
    public final /* synthetic */ ChannelCardViewNew41.a a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ long c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.a$a, reason: collision with other inner class name */
    public static final class C0096a extends TimerTask {
        public final /* synthetic */ a a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            this.a.b.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public C0096a(a r1) {
            this.a = r1;
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.b.invoke();     // Catch: Throwable -> L4
        ChannelCardViewNew41.a r0 = this.a;     // Catch: Throwable -> L4
        PthreadTimer r7 = new PthreadTimer("ChannelCardViewNew41$ContentContainer$startDelayedAndPeriodicAction$$inlined$apply$lambda$1");     // Catch: Throwable -> L4
        r7.scheduleAtFixedRate(new C0096a(this), 0, this.c);     // Catch: Throwable -> L4
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L4
        r0.setIntervalHandle(r7);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(ChannelCardViewNew41.a r1, Function0 r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
