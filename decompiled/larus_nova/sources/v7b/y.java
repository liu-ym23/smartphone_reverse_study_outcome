package v7b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<x> f553581a;

    public y() {
    }

    public final void a(List<x> r100) {
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.f553581a != null) goto L9;
        this.f553581a = new ArrayList();
    L9:
        if (this.f553581a.isEmpty() == false) goto L11;
        this.f553581a.addAll(r100);
        return;
    L11:
        int r101 = this.f553581a.size() - 1;
        x r102 = (x) ListProtector.get(this.f553581a, r101);
        x r103 = (x) ListProtector.get(r100, 0);
        int r104 = r102.f553578a;
        if (r104 != r103.f553578a) goto L16;
        int r105 = r102.f553579b;
        int r106 = r102.f553580c;
        if ((r105 + r106) != r103.f553579b) goto L16;
        ListProtector.set(this.f553581a, r101, new x(r104, r105, r106 + r103.f553580c));
        this.f553581a.addAll(r100.subList(1, r100.size()));
        return;
    L16:
        this.f553581a.addAll(r100);
    }

    public final void b(Iterable<? extends s> r100) {
        Iterator<? extends s> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        a(r101.next().j());
        goto L4
    }
}
