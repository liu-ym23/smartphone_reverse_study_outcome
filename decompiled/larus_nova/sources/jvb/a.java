package jvb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a {

    /* JADX INFO: renamed from: jvb.a$a, reason: collision with other inner class name */
    public static final class C6488a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f500590a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6488a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f500590a, ((C6488a) r100).f500590a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f500590a.hashCode();
        }

        public final String toString() {
            return "ObjectToken(value=" + this.f500590a + ')';
        }

        @Override // jvb.a
        public final String a() {
            return this.f500590a;
        }

        public C6488a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f500590a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f500591a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f500591a, ((b) r100).f500591a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f500591a.hashCode();
        }

        public final String toString() {
            return "RecordingId(value=" + this.f500591a + ')';
        }

        @Override // jvb.a
        public final String a() {
            return this.f500591a;
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f500591a = r100;
        }
    }

    public a() {
    }

    public abstract String a();
}
