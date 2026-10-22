package v1a;

import kotlin.jvm.internal.Intrinsics;
import w1a.b;

/* JADX INFO: loaded from: classes31.dex */
public final class b<S extends w1a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f552651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a<S> f552652b;

    public static final class a<S extends w1a.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S f552653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f552654b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f552653a, ((a) r100).f552653a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f552653a.hashCode();
        }

        public final String toString() {
            return "StateWrapper(state=" + this.f552653a + ')';
        }

        public a(S r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f552653a = r100;
            this.f552654b = hashCode();
        }
    }

    public b(S r100) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        this.f552651a = r100;
        this.f552652b = new a(r100);
    }
}
