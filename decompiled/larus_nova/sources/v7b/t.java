package v7b;

import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final class t implements Iterator<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f553574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f553575b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        s r100 = this.f553574a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100 == this.f553575b) goto L7;
        return true;
    }

    @Override // java.util.Iterator
    public final s next() {
        s r100 = this.f553574a;
        this.f553574a = r100.f553572h;
        return r100;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public t(s r100, s r101) {
        this.f553574a = r100;
        this.f553575b = r101;
    }
}
