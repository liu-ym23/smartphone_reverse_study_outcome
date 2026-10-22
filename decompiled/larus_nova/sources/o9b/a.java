package o9b;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a {

    /* JADX INFO: renamed from: o9b.a$a, reason: collision with other inner class name */
    public static final class C7027a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f522508a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7027a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f522508a, ((C7027a) r100).f522508a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f522508a.hashCode();
        }

        public final String toString() {
            return "Empty(query=" + this.f522508a + ')';
        }

        public C7027a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "query");
            this.f522508a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f522509a = null;

        static {
            f522509a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<mtb.d> f522510a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f522510a, ((c) r100).f522510a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f522510a.hashCode();
        }

        public final String toString() {
            return "Results(items=" + this.f522510a + ')';
        }

        public c(List<mtb.d> r100) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f522510a = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f522511a = null;

        static {
            f522511a = new d();
        }

        public d() {
        }
    }

    public a() {
    }
}
