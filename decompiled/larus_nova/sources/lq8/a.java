package lq8;

import com.larus.bmhome.interactionpanel.o;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: lq8.a$a, reason: collision with other inner class name */
    public static final class C6728a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<o> f510309a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6728a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f510309a, ((C6728a) r100).f510309a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f510309a.hashCode();
        }

        public final String toString() {
            return "Hide(keys=" + this.f510309a + ')';
        }

        public C6728a(List<o> r100) {
            Intrinsics.checkNotNullParameter(r100, "keys");
            this.f510309a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d> f510310a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f510310a, ((b) r100).f510310a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f510310a.hashCode();
        }

        public final String toString() {
            return "Upsert(inputs=" + this.f510310a + ')';
        }

        public b(List<d> r100) {
            Intrinsics.checkNotNullParameter(r100, "inputs");
            this.f510310a = r100;
        }
    }

    public a() {
    }
}
