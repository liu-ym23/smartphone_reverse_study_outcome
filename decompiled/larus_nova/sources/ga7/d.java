package ga7;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements v97.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Object> f480574a;

    @Override // v97.c
    public final v97.b a(String r100) {
        return null;
    }

    public d() {
        this.f480574a = new HashMap();
    }

    @Override // v97.c
    public final Object getValue(String r100) {
        if (this.f480574a.containsKey(r100) == true) goto L5;
        v97.d<?> r101 = e.f480575a.get(r100);
        if (r101 == null) goto L10;
        this.f480574a.put(r100, r101.getValue());
        return this.f480574a.get(r100);
    L10:
        v97.d<?> r102 = b.f480571a.get(r100);
        if (r102 == null) goto L14;
        this.f480574a.put(r100, r102.getValue());
        return this.f480574a.get(r100);
    L14:
        return null;
    L5:
        return this.f480574a.get(r100);
    }
}
