package tu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map<String, String> c;

    public d(c r1, String r2, Map<String, String> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.a == false) goto L5;
        String r0 = this.b;
        long r3 = System.currentTimeMillis();
        Map<String, String> r7 = this.c;
        Lazy r1 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.a;
        Intrinsics.checkNotNullParameter(r0, "traceId");
        BitableStatisticEventModel$NormalPointModel r2 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_FAIL", r3, false, 12);
        r2.addExtras(r7);
        com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r0, r2);
        return;
    L5:
        b.i(this.b, Long.valueOf(System.currentTimeMillis()), this.c);
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
