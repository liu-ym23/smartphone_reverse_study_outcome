package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DataEngineWrapper$domainConnect$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DataEngineWrapper this$0;

    public DataEngineWrapper$domainConnect$1(DataEngineWrapper r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1446invoke() {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "DataEngineWrapper#domainConnect()@" + this.this$0.hashCode() + ", start");
        long r1 = System.currentTimeMillis();
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L18;
        yj.n r4 = r3.getIHybridHostNetService();
        if (r4 == null) goto L18;
        com.bytedance.android.ec.hybrid.data.e r5 = (com.bytedance.android.ec.hybrid.data.e) this.this$0.k.getValue();
        List r6 = r5.a();
        if (r6 == null) goto L12;
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        r4.connect((String) r7.next());
    L12:
        List r8 = r5.b();
        if (r8 == null) goto L18;
        Iterator r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r4.connect((String) r9.next());
    L18:
        Lazy r10 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "DataEngineWrapper#domainConnect()@" + this.this$0.hashCode() + ", end, duration = " + (System.currentTimeMillis() - r1));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1446invoke();
        return Unit.INSTANCE;
    }
}
