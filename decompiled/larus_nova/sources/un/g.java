package un;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes44.dex */
public final class g extends un.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f550759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.ec.vlayout.a> f550760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.ec.vlayout.a> f550761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b[] f550762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f550763e;

    public class a implements Comparator<b> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(b r100, b r101) {
            return r100.a() - r101.a();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.ec.vlayout.a f550764a;

        public final int a() {
            return ((Integer) this.f550764a.f49095a.f550757a).intValue();
        }

        public b(com.bytedance.android.ec.vlayout.a r100) {
            this.f550764a = r100;
        }
    }

    public g() {
        this.f550759a = new LinkedList();
        this.f550760b = new LinkedList();
        this.f550761c = new LinkedList();
        this.f550762d = null;
        this.f550763e = new a();
    }

    @Override // un.a
    public final com.bytedance.android.ec.vlayout.a a(int r100) {
        b[] r101 = this.f550762d;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.length == 0) goto L38;
        int r102 = r101.length - 1;
        int r103 = 0;
    L8:
        if (r103 > r102) goto L20;
        int r104 = (r103 + r102) / 2;
        b r105 = this.f550762d[r104];
        if (r105.a() > r100) goto L11;
        if (((Integer) r105.f550764a.f49095a.f550758b).intValue() < r100) goto L14;
        if (r105.a() > r100) goto L8;
        if (((Integer) r105.f550764a.f49095a.f550758b).intValue() < r100) goto L8;
    L21:
        if (r105 != null) goto L24;
        return null;
    L24:
        return r105.f550764a;
    L14:
        r103 = r104 + 1;
        goto L8
    L11:
        r102 = r104 - 1;
        goto L8
    L20:
        r105 = null;
        goto L21
    L38:
        return null;
    }

    @Override // un.a
    public final void b(List<com.bytedance.android.ec.vlayout.a> r100) {
        ((LinkedList) this.f550760b).clear();
        ((LinkedList) this.f550761c).clear();
        ((LinkedList) this.f550759a).clear();
        ListIterator<com.bytedance.android.ec.vlayout.a> r101 = r100.listIterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        com.bytedance.android.ec.vlayout.a r102 = r101.next();
        ((LinkedList) this.f550760b).add(r102);
        List<b> r103 = this.f550759a;
        LinkedList r104 = (LinkedList) r103;
        r104.add(new b(r102));
    L7:
        if (r101.hasPrevious() == false) goto L9;
        List<com.bytedance.android.ec.vlayout.a> r105 = this.f550761c;
        LinkedList r106 = (LinkedList) r105;
        r106.add(r101.previous());
        goto L7
    L9:
        LinkedList r107 = (LinkedList) this.f550759a;
        b[] r108 = (b[]) r107.toArray(new b[r107.size()]);
        this.f550762d = r108;
        Arrays.sort(r108, this.f550763e);
    }
}
