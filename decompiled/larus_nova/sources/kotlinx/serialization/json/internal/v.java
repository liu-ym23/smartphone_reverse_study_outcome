package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f505460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f505461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f505462c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f505463a = null;

        static {
            f505463a = new a();
        }

        public a() {
        }
    }

    public final String a() {
        StringBuilder r100 = new StringBuilder("$");
        int r101 = this.f505462c + 1;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L19;
        Object r103 = this.f505460a[r102];
        if ((r103 instanceof luc.f) == false) goto L15;
        luc.f r104 = (luc.f) r103;
        if (Intrinsics.areEqual(r104.getKind(), luc.p.b.f510878a) == true) goto L9;
        int r105 = this.f505461b[r102];
        if (r105 < 0) goto L17;
        r100.append(".");
        r100.append(r104.b(r105));
    L17:
        r102 = r102 + 1;
        goto L3
    L9:
        if (this.f505461b[r102] == (-1)) goto L17;
        r100.append("[");
        r100.append(this.f505461b[r102]);
        r100.append("]");
        goto L17
    L15:
        if (r103 == a.f505463a) goto L17;
        r100.append("['");
        r100.append(r103);
        r100.append("']");
        goto L17
    L19:
        return r100.toString();
    }

    public v() {
        this.f505460a = new Object[8];
        int[] r100 = new int[8];
        int r101 = 0;
    L4:
        if (r101 >= 8) goto L6;
        r100[r101] = -1;
        r101 = r101 + 1;
        goto L4
    L6:
        this.f505461b = r100;
        this.f505462c = -1;
    }

    public final String toString() {
        return a();
    }
}
