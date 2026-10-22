package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function0 b;

    public j(long r1, Function0 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void a() {
        dm.a.a("BottomRightCardManager").i("hide explain card after extend " + this.a + "ms");
        this.b.invoke();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
