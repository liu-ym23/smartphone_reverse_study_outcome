package ktc;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes41.dex */
public class b<K, V> extends ktc.a<K, V, C6610b<K>> {

    public class a extends ThreadLocal<C6610b<?>> {
        @Override // java.lang.ThreadLocal
        public final C6610b<?> initialValue() {
            return new C6610b();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: ktc.b$b, reason: collision with other inner class name */
    public static final class C6610b<K> {
        public C6610b() {
        }

        public final int hashCode() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof C6610b) == false) goto L7;
            ((C6610b) r100).getClass();
            return true;
        L7:
            if (((ktc.a.c) r100).get() == null) goto L11;
            return false;
        L11:
            return true;
        }
    }

    static {
        new a();
        new AtomicLong();
    }

    public b(ConcurrentMap r100) {
        super(r100);
    }
}
