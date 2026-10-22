package tu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f547635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f547636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f547637c;

    public d(c r100, String r101, Map<String, String> r102) {
        this.f547635a = r100;
        this.f547636b = r101;
        this.f547637c = r102;
    }

    public final void a() {
        if (this.f547635a.f547624a == false) goto L5;
        String r100 = this.f547636b;
        long r101 = System.currentTimeMillis();
        Map<String, String> r102 = this.f547637c;
        Lazy r103 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.f215603a;
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r104 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_FAIL", r101, false, 12);
        r104.addExtras(r102);
        com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r100, r104);
        return;
    L5:
        b.i(this.f547636b, Long.valueOf(System.currentTimeMillis()), this.f547637c);
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
