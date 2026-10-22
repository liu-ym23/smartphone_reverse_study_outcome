package up5;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f551047b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f551048a;

    public static final class a {
        public static b a() {
            return new b(null);
        }
    }

    static {
    }

    public b() {
        throw null;
    }

    public final T a() {
        T r100 = this.f551048a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NoSuchElementException("No value present");
    }

    public final boolean b() {
        if (this.f551048a != null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Object r100) {
        this.f551048a = r100;
    }
}
