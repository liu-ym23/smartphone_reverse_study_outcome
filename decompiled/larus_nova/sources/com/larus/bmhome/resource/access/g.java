package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface g {

    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i0 f313649a;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313649a, ((a) r100).f313649a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313649a.hashCode();
        }

        public final String toString() {
            return "Continue(update=" + this.f313649a + ')';
        }

        public a(i0 r100) {
            Intrinsics.checkNotNullParameter(r100, "update");
            this.f313649a = r100;
        }

        public a(int r100) {
            this(i0.f313680h);
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f313650a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313650a, ((b) r100).f313650a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313650a.hashCode();
        }

        public final String toString() {
            return "Failed(error=" + this.f313650a + ')';
        }

        public b(r r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f313650a = r100;
        }
    }

    public static final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f313651a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313651a, ((c) r100).f313651a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313651a.hashCode();
        }

        public final String toString() {
            return "Fallback(reason=" + this.f313651a + ')';
        }

        public c(r r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f313651a = r100;
        }
    }

    public static final class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f0 f313652a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313652a, ((d) r100).f313652a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313652a.hashCode();
        }

        public final String toString() {
            return "Ready(artifact=" + this.f313652a + ')';
        }

        public d(f0 r100) {
            Intrinsics.checkNotNullParameter(r100, "artifact");
            this.f313652a = r100;
        }
    }

    public static final class e implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f313653a = null;

        static {
            f313653a = new e();
        }

        public e() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            e r101 = (e) r100;
            return true;
        }

        public final int hashCode() {
            return 1686893568;
        }

        public final String toString() {
            return "Skip";
        }
    }
}
