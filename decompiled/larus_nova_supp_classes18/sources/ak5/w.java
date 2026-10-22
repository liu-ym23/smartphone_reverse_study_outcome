package ak5;

import com.bytedance.ee.bear.net.CloudReqFun;
import io.reactivex.Flowable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w<T extends Serializable> {
    public final s<T> a;
    public final e b;
    public final h c;
    public final o d;
    public final boolean e;
    public final Map<String, String> f;
    public final List<y> g;

    public final Flowable a(x r5) {
        Flowable r0 = Flowable.just(r5).map(new t(this.e, this.f)).observeOn(fo5.d.c());
        h r1 = this.c;
        if (r1 == null) goto L6;
        r0 = r0.flatMap(new b(r1));
    L6:
        return r0.flatMap(new CloudReqFun(this.d, this.b)).map(new q()).map(new d(r5.a(), this.g)).map(new v()).map(new r(this.a)).observeOn(fo5.d.d());
    }

    public w(i r2, s<T> r3, e r4) {
        this.f = new HashMap();
        this.d = r2.c;
        this.a = r3;
        this.b = r4;
        this.c = r2.b;
        this.e = ((j.a) r2.a).b;
        this.g = r2.d;
    }
}
