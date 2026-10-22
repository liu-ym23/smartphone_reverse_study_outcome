package ed5;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final a a;
    public c b;

    public final void a() {
        c r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.t0(this.a.a);
        c r1 = this.b;
        a r2 = this.a;
        r2.getClass();
        r1.C0(new LinkedHashSet(r2.b));
    }

    public final void c() {
        a r0 = this.a;
        r0.a = false;
        r0.b.clear();
        r0.c.clear();
        a();
    }

    public b(a r1) {
        this.a = r1;
    }

    public final void b(Document r4) {
        a r0 = this.a;
        r0.a = true;
        r0.b.clear();
        r0.c.clear();
        if (r4 == null) goto L7;
        String r1 = a.a(r4);
        if (TextUtils.isEmpty(r1) == true) goto L7;
        r0.b.add(r1);
        r0.c.add(r4);
    L7:
        a();
    }

    public final void d(c r1) {
        this.b = r1;
        a();
    }

    public final void e(List r7) {
        a r0 = this.a;
        r0.d.clear();
        if (r7 == null) goto L6;
        r0.d.addAll(r7);
    L6:
        if (r0.a == false) goto L22;
        ArrayList r1 = new ArrayList();
        LinkedHashSet r2 = new LinkedHashSet();
        if (r7 == null) goto L18;
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L18;
        Document r3 = (Document) r8.next();
        String r4 = a.a(r3);
        if (TextUtils.isEmpty(r4) == true) goto L12;
        if (r0.b.contains(r4) == false) goto L12;
        r2.add(r4);
        r1.add(r3);
    L18:
        r0.b.clear();
        r0.b.addAll(r2);
        r0.c.clear();
        r0.c.addAll(r1);
        if (hu5.a.d(r0.b) == false) goto L21;
        r0.a = true;
        goto L22
    L21:
        r0.a = true;
    L22:
        a();
    }

    public final void f(Document r4) {
        a r0 = this.a;
        r0.getClass();
        String r1 = a.a(r4);
        if (TextUtils.isEmpty(r1) == true) goto L17;
        r0.a = true;
        if (r0.b.contains(r1) == false) goto L13;
        r0.b.remove(r1);
        int r5 = r0.c.size();
    L8:
        r5 = r5 - 1;
        if (r5 < 0) goto L15;
        if (TextUtils.equals(a.a((Document) ListProtector.get(r0.c, r5)), r1) == false) goto L8;
        ListProtector.remove(r0.c, r5);
    L15:
        if (hu5.a.d(r0.b) == false) goto L17;
        r0.a = false;
        r0.b.clear();
        r0.c.clear();
        goto L17
    L13:
        r0.b.add(r1);
        r0.c.add(r4);
    L17:
        a();
    }
}
