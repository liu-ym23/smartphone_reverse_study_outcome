package ga7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements v97.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f480576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f480577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v97.c f480578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, ?> f480579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, v97.b> f480580e;

    public static final class a {
    }

    static {
    }

    @Override // v97.c
    public final v97.b a(String r100) {
        long r101 = System.nanoTime();
        v97.b r102 = this.f480578c.a(r100);
        if (r102 == null) goto L5;
        this.f480577b.add(r100);
    L6:
        this.f480576a += System.nanoTime() - r101;
        return r102;
    L5:
        r102 = this.f480580e.get(r100);
        goto L6
    }

    @Override // v97.c
    public final Object getValue(String r100) {
        long r101 = System.nanoTime();
        Object r102 = this.f480578c.getValue(r100);
        HashMap<String, Object> r103 = null;
        if (r102 == null) goto L5;
        this.f480577b.add(r100);
    L6:
        if (r102 != null) goto L15;
        r102 = this.f480579d.get(r100);
        if ((r102 instanceof v97.d) == false) goto L15;
        r102 = ((v97.d) r102).getValue();
        v97.c r104 = this.f480578c;
        if ((r104 instanceof d) == false) goto L13;
        r103 = ((d) r104).f480574a;
    L13:
        if ((r103 instanceof HashMap) == false) goto L15;
        r103.put(r100, r102);
    L15:
        this.f480576a += System.nanoTime() - r101;
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public f(d r100, Map r101, Map r102) {
        this.f480578c = r100;
        this.f480579d = r101;
        this.f480580e = r102;
        this.f480577b = new HashSet();
    }
}
