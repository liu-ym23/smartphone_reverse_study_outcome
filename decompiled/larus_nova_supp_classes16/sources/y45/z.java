package y45;

import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z implements Function<Boolean, Publisher<Boolean>> {
    public final /* synthetic */ f85.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.ee.bear.drive.cache.t c;
    public final /* synthetic */ a95.a d;

    public final Object apply(Object r5) throws Exception {
        f85.a.C0229a r0 = (f85.a.C0229a) this.a.a;
        v85.c.a r1 = new v85.c.a();
        r1.a = 0;
        r1.b = this.b;
        r1.c = r0.a;
        r1.d = r0.b;
        r1.c(this.a.a());
        r1.d(this.a.b());
        r1.g = this.a.r;
        r1.h = r0.p;
        r1.i = r0.k;
        f85.a r2 = this.a;
        r1.j = r2.f;
        r1.k = "";
        r1.l = DiagramData$RESULT.SUCCESS;
        r1.n = r0.g;
        r1.o = r2.e();
        v85.c r3 = new v85.c(r1);
        Flowable<Boolean> r4 = this.c.m(r3, this.d.b);
        Flowable r6 = Flowable.just(Boolean.FALSE);
        if (((Boolean) r5).booleanValue() == false) goto L6;
        return r4;
    L6:
        return r6;
    }

    public z(f85.a r1, String r2, com.bytedance.ee.bear.drive.cache.t r3, a95.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
