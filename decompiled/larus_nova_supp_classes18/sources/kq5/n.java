package kq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.Flowable;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n {
    public final ce5.a a;
    public final boolean b;
    public final HashMap<String, Flowable<Pair<c, WikiRelation>>> c;

    public static final class a {
    }

    static {
    }

    public n(ce5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        this.a = r4;
        HashMap<String, Flowable<Pair<c, WikiRelation>>> r0 = new HashMap();
        this.c = r0;
        int r1 = qc5.a.a;
        this.b = qc5.a.m(new ce5.a());
        r0.put(m.a, lq5.e.a(r4));
        r0.put(m.b, oq5.c.b(r4));
        r0.put(m.c, nq5.e.a(r4));
        r0.put(m.d, mq5.d.b(r4));
    }
}
