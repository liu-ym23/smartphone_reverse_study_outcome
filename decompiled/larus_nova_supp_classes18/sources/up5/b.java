package up5;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> {
    public static final /* synthetic */ int b = 0;
    public final T a;

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
        T r0 = this.a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NoSuchElementException("No value present");
    }

    public final boolean b() {
        if (this.a != null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Object r1) {
        this.a = r1;
    }
}
