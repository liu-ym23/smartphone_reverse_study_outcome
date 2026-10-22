package rn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import kotlin.jvm.internal.Intrinsics;
import pn0.g;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements sn0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f538656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LayoutConfigModel f538657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ProducerResStep f538658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ on0.a f538659d;

    @Override // sn0.a
    public final void c(pn0.d r100, g r110) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r110, "modifiedRequestParams");
        this.f538656a.e(r100, this.f538657b, null, r110, this.f538658c, this.f538659d);
    }

    public d(b r100, LayoutConfigModel r101, ProducerResStep r102, on0.a r103) {
        this.f538656a = r100;
        this.f538657b = r101;
        this.f538658c = r102;
        this.f538659d = r103;
    }

    @Override // sn0.a
    public final void b(pn0.d r100, g r101, LayoutConfigModel r110, ProducerResStep r111) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "modifiedRequestParams");
        Intrinsics.checkNotNullParameter(r110, "offsetLayoutConfigModel");
        Intrinsics.checkNotNullParameter(r111, "offsetStep");
        b r112 = this.f538656a;
        String r102 = r112.f538652g.f509970d.c().b(r100, r101);
        if (r112.f538651f.containsKey(r102) == true) goto L5;
        LayoutConfigModel r103 = r110.a();
        r112.f538651f.put(r102, r103);
    L5:
        zg0.a r113 = this.f538656a.f538652g.f509970d.c();
        LayoutConfigModel r104 = this.f538657b;
        r113.f(r100, r101, r104, r110);
        this.f538656a.e(r100, r104, r110, r101, this.f538658c, this.f538659d);
    }
}
