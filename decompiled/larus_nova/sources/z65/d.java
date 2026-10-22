package z65;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f570505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f570506b;

    /* JADX WARN: Type inference failed for: r0v1, types: [z65.c] */
    public d() {
        this.f570505a = new ArrayList();
        this.f570506b = new c();
    }

    public final void a(List<b> r100) {
        if (hu5.a.d(r100) == true) goto L12;
        Iterator<b> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L19;
        b r102 = r101.next();
        if (((ArrayList) this.f570505a).isEmpty() == true) goto L11;
        if (((ArrayList) this.f570505a).contains(r102) == true) goto L6;
    L11:
        ((ArrayList) this.f570505a).add(r102);
        goto L6
    L19:
        return;
    }

    public final int b(String r100) {
        if (r100 != null) goto L6;
        tt5.a.d("UpdateListTAG", "find position failed, key == null");
        return -1;
    L6:
        int r101 = 0;
    L8:
        if (r101 >= ((ArrayList) this.f570505a).size()) goto L16;
        if (r100.equals(((b) ListProtector.get(this.f570505a, r101)).f570500g) == true) goto L13;
        r101 = r101 + 1;
        goto L8
    L13:
        return r101;
    L16:
        return -1;
    }
}
