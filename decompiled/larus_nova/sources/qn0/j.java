package qn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;
import sn0.l;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProducerResStep f534003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k.c f534004b;

    public j(k.c r100) {
        Intrinsics.checkNotNullParameter(r100, "createConfig");
        this.f534004b = r100;
        this.f534003a = ProducerResStep.LocalCache;
    }

    public final void b(pn0.d.a r100, String r101) {
        StringBuilder r102 = r100.f529918a;
        r102.append("\n");
        r102.append("OffsetLayoutConfig step: " + this.f534003a + ", content: " + r101);
    }

    @Override // sn0.l
    public final void a(pn0.d r100, pn0.g r101, sn0.a r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r102, "consumer");
        if (this.f534004b.f534013b.d().f529893a == false) goto L8;
        String r103 = this.f534004b.f534013b.c().c().b(r100, r101);
        LayoutConfigModel r104 = this.f534004b.f534012a.get(r103);
        if (r104 == null) goto L7;
        b(r100.e(), "tryLoadFromCache success, found in localCache, cacheKey = " + r103);
        r102.b(r100, r101, r104.a(), this.f534003a);
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
