package dd5;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t1 implements Function<Set<String>, Boolean> {
    public final List<Document> a;

    public t1(List<Document> r1) {
        this.a = r1;
    }

    public final Object apply(Object r8) throws Exception {
        Set r9 = (Set) r8;
        boolean r1 = false;
        if (hu5.a.d(this.a) == true) goto L26;
        Iterator<Document> r0 = this.a.iterator();
        boolean r2 = false;
    L6:
        if (r0.hasNext() == false) goto L24;
        Document r3 = r0.next();
        if (r3.getType() == sbb.e.n.b) goto L9;
        if (r9.contains(r3.d) == false) goto L6;
        r3.w = true;
    L23:
        r2 = true;
        goto L6
    L9:
        int r4 = r3.y1;
        if (r4 != sbb.e.i.b) goto L12;
    L18:
        boolean r5 = false;
    L19:
        r3.x2 = r5;
        goto L23
    L12:
        if (r4 == sbb.e.m.b) goto L18;
        if (r9.contains(r3.d) == false) goto L18;
        if (r9.contains(r3.G1) == false) goto L18;
        r5 = true;
        goto L19
    L24:
        r1 = r2;
    L26:
        return Boolean.valueOf(r1);
    }
}
