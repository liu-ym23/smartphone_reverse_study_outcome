package z65;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final List<b> a;
    public final c b;

    /* JADX WARN: Type inference failed for: r0v1, types: [z65.c] */
    public d() {
        this.a = new ArrayList();
        this.b = new c();
    }

    public final void a(List<b> r3) {
        if (hu5.a.d(r3) == true) goto L12;
        Iterator<b> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L19;
        b r0 = r4.next();
        if (((ArrayList) this.a).isEmpty() == true) goto L11;
        if (((ArrayList) this.a).contains(r0) == true) goto L6;
    L11:
        ((ArrayList) this.a).add(r0);
        goto L6
    L19:
        return;
    }

    public final int b(String r4) {
        if (r4 != null) goto L6;
        tt5.a.d("UpdateListTAG", "find position failed, key == null");
        return -1;
    L6:
        int r1 = 0;
    L8:
        if (r1 >= ((ArrayList) this.a).size()) goto L16;
        if (r4.equals(((b) ListProtector.get(this.a, r1)).g) == true) goto L13;
        r1 = r1 + 1;
        goto L8
    L13:
        return r1;
    L16:
        return -1;
    }
}
