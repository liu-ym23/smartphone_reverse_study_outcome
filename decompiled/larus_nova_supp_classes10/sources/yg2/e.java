package yg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ xg2.e b;
    public final /* synthetic */ String c;

    public e(a r1, xg2.e r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        this.a.a(this.b);
        a r0 = this.a;
        xg2.e r1 = this.b;
        String r2 = this.c;
        Map<String, String> r3 = r0.c;
        ConcurrentHashMap r4 = (ConcurrentHashMap) r3;
        r4.put(r1.b.toString(), r2);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.a = r2;
        System.currentTimeMillis();
        LinkedList r5 = new LinkedList();
        r5.add(r1);
        ((ConcurrentHashMap) r0.b).put(r2, r5);
        this.a.b(this.b, EventType.RATE_START, "ec_live_quality_monitor_start", this.c);
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
