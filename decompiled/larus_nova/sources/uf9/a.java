package uf9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: uf9.a$a, reason: collision with other inner class name */
    public static final class C7879a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f549958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f549959b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7879a) == true) goto L8;
            return false;
        L8:
            C7879a r101 = (C7879a) r100;
            if (Intrinsics.areEqual(this.f549958a, r101.f549958a) == true) goto L12;
            return false;
        L12:
            if (this.f549959b == r101.f549959b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f549958a.hashCode() * 31) + this.f549959b;
        }

        public final String toString() {
            return "Latest(conversationId=" + this.f549958a + ", limit=" + this.f549959b + ')';
        }

        public C7879a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f549958a = r100;
            this.f549959b = r101;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f549960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f549961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f549962c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f549960a, r101.f549960a) == true) goto L12;
            return false;
        L12:
            if (this.f549961b == r101.f549961b) goto L15;
            return false;
        L15:
            if (this.f549962c == r101.f549962c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f549960a.hashCode() * 31) + this.f549961b) * 31;
            long r101 = this.f549962c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "Newer(conversationId=" + this.f549960a + ", limit=" + this.f549961b + ", fromIndex=" + this.f549962c + ')';
        }

        public b(String r100, int r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f549960a = r100;
            this.f549961b = r101;
            this.f549962c = r102;
        }
    }

    public a() {
    }
}
