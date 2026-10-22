package jha;

import jha.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public interface q<S extends o> {

    public static final class a<S extends o> implements q<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p<S> f499150a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f499150a, ((a) r100).f499150a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f499150a.hashCode();
        }

        public final String toString() {
            return "End(envelope=" + this.f499150a + ')';
        }

        @Override // jha.q
        public final p<S> a() {
            return this.f499150a;
        }

        public a(p<S> r100) {
            Intrinsics.checkNotNullParameter(r100, "envelope");
            this.f499150a = r100;
        }
    }

    public static final class b<S extends o> implements q<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p<S> f499151a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f499151a, ((b) r100).f499151a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f499151a.hashCode();
        }

        public final String toString() {
            return "Start(envelope=" + this.f499151a + ')';
        }

        @Override // jha.q
        public final p<S> a() {
            return this.f499151a;
        }

        public b(p<S> r100) {
            Intrinsics.checkNotNullParameter(r100, "envelope");
            this.f499151a = r100;
        }
    }

    public static final class c<S extends o> implements q<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p<S> f499152a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f499152a, ((c) r100).f499152a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f499152a.hashCode();
        }

        public final String toString() {
            return "Update(envelope=" + this.f499152a + ')';
        }

        @Override // jha.q
        public final p<S> a() {
            return this.f499152a;
        }

        public c(p<S> r100) {
            Intrinsics.checkNotNullParameter(r100, "envelope");
            this.f499152a = r100;
        }
    }

    p<S> a();
}
