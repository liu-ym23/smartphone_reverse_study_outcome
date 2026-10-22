package i57;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f488315a;

    /* JADX INFO: renamed from: i57.a$a, reason: collision with other inner class name */
    public static final class C6231a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f488316a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C6231a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f488316a, ((C6231a) r100).f488316a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f488316a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Key(name=" + this.f488316a + ")";
        }

        public C6231a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f488316a = r100;
        }
    }

    public a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "contents");
        this.f488315a = r100;
    }

    public final <T> T a(C6231a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) this.f488315a.get(r100.f488316a);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }
}
