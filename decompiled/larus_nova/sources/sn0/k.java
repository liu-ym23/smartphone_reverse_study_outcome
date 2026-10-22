package sn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProducerResStep f542640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n.c f542641b;

    public k(n.c r100) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f542641b = r100;
        this.f542640a = ProducerResStep.LocalCache;
    }

    public final void b(pn0.d.a r100, String r101) {
        StringBuilder r102 = r100.f529918a;
        r102.append("\n");
        r102.append("step: " + this.f542640a + ", content: " + r101);
    }

    @Override // sn0.l
    public final void a(pn0.d r100, pn0.g r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r102, "consumer");
        if (this.f542641b.f542648b.d().f529893a == false) goto L8;
        String r103 = this.f542641b.f542648b.c().c().a(r100, r101);
        LayoutConfigModel r104 = this.f542641b.f542647a.get(r103);
        if (r104 == null) goto L7;
        b(r100.e(), "tryLoadFromCache success, found in localCache, cacheKey = " + r103);
        r102.b(r100, r101, r104.a(), this.f542640a);
        return;
    L7:
        b(r100.e(), "tryLoadFromCache success, not found in localCache!!! cacheKey = " + r103);
        r102.c(r100, r101);
        return;
    L8:
        b(r100.e(), "localCacheProducer is banned by setting!!!");
        r102.c(r100, r101);
    }
}
