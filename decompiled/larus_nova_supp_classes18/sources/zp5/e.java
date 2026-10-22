package zp5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikiDocument;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetSpaceInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import mc5.b3;
import mc5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ ce5.a a;
    public final /* synthetic */ String b;

    public e(ce5.a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        Intrinsics.checkNotNullParameter((String) r4, "it");
        b3 r5 = ((j) this.a.a(j.class)).rc(this.b);
        if (r5 == null) goto L5;
        tt5.a.h("WikiSpaceRepository", "getWikiSpace, found cache, return. ");
        WikiDocument r0 = new WikiDocument();
        r0.m = r5.a;
        r0.O2 = r5.e;
        r0.a = r5.c;
        r0.q = r5.d;
        r0.P2 = r5.f;
        r0.z = r5.g;
        r0.l = r5.h;
        r0.Q2 = r5.i;
        r0.d = r5.k;
        r0.b = r5.j;
        r0.U2 = r5.q;
        r0.V2 = r5.s;
        DisplayTag r1 = new DisplayTag();
        r1.setTag_type(r5.t);
        r1.setTag_value(r5.u);
        r0.W2 = r1;
        WikiDocument.SpaceCover r2 = new WikiDocument.SpaceCover();
        r2.a = r5.l;
        r2.b = r5.m;
        r2.e = r5.p;
        r2.d = r5.o;
        r2.c = r5.n;
        r0.R2 = r2;
        Flowable r6 = Flowable.just(r0);
        Intrinsics.checkNotNull(r6);
        return r6;
    L5:
        Flowable r7 = l0.c((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).a(new GetSpaceInfoPuller.Params(this.b)).map(new d(this.b));
        Intrinsics.checkNotNull(r7);
        return r7;
    }
}
