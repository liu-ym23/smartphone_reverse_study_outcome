package wr7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes22.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f560860a;

    public final List<Integer> c() {
        return Collections.unmodifiableList(this.f560860a);
    }

    public r(List<Integer> r100) {
        zr7.a.c(r100, "Values must not be empty");
        List<Integer> r101 = r100;
        this.f560860a = r101;
        Collections.sort(r101);
    }

    public final j a(int r100) {
        ArrayList r101 = new ArrayList(this.f560860a);
        int r102 = 0;
        AtomicInteger r103 = new AtomicInteger(0);
        if (r101.contains(Integer.valueOf(r100)) == true) goto L13;
        Iterator r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Integer r105 = (Integer) r104.next();
        if (r105.intValue() <= r100) goto L6;
        int r106 = r101.indexOf(r105);
        int r107 = -1;
        boolean r108 = true;
    L11:
        if (r108 == true) goto L14;
        r103.incrementAndGet();
    L14:
        int r109 = ((Integer) ListProtector.get(r101, r106)).intValue();
    L15:
        if (r102 >= r107) goto L18;
        r109 = b(r101, r106 + 1, r103);
        r106 = r101.indexOf(Integer.valueOf(r109));
        r102 = r102 + 1;
        goto L15
    L18:
        return new j(r109, r103.get());
    L10:
        r106 = 0;
        r107 = 0;
        r108 = false;
        goto L11
    L13:
        r106 = r101.indexOf(Integer.valueOf(r100));
        r107 = 0;
        goto L14
    }

    public static int b(List r100, int r101, AtomicInteger r102) {
        zr7.a.c(r100, "List must not be empty");
        if (r101 >= 0) goto L6;
        int r103 = r101 + ((ArrayList) r100).size();
        r102.incrementAndGet();
        return b(r100, r103, r102);
    L6:
        ArrayList r104 = (ArrayList) r100;
        if (r101 < r104.size()) goto L11;
        int r105 = r101 - r104.size();
        r102.incrementAndGet();
        return b(r100, r105, r102);
    L11:
        return ((Integer) ListProtector.get(r100, r101)).intValue();
    }
}
