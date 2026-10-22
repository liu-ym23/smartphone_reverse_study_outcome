package com.larus.dora.impl.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f337876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f337878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f337879d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f337876a, r101.f337876a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337877b, r101.f337877b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f337878c, r101.f337878c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f337879d, r101.f337879d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f337876a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f337877b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f337878c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f337879d;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "InvalidResponse(code=" + this.f337876a + ", message=" + this.f337877b + ", dataJson=" + this.f337878c + ", payload=" + this.f337879d + ')';
        }

        public a(Long r100, String r101, String r102, String r103) {
            this.f337876a = r100;
            this.f337877b = r101;
            this.f337878c = r102;
            this.f337879d = r103;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f337880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f337882c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f337880a, r101.f337880a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337881b, r101.f337881b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f337882c, r101.f337882c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f337880a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f337881b.hashCode()) * 31;
            Throwable r104 = this.f337882c;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "RequestFailed(code=" + this.f337880a + ", errorType=" + this.f337881b + ", cause=" + this.f337882c + ')';
        }

        public b(Long r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r101, "errorType");
            this.f337880a = r100;
            this.f337881b = r101;
            this.f337882c = r102;
        }

        public /* synthetic */ b(String r100, Throwable r101, int r102) {
            if ((r102 & 4) == 0) goto L5;
            r101 = null;
        L5:
            this(null, r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f337883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f337885c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f337883a, r101.f337883a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337884b, r101.f337884b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f337885c, r101.f337885c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f337883a.hashCode() * 31) + this.f337884b.hashCode()) * 31;
            String r101 = this.f337885c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Success(snapshot=" + this.f337883a + ", dataJson=" + this.f337884b + ", payload=" + this.f337885c + ')';
        }

        public c(g r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            Intrinsics.checkNotNullParameter(r101, "dataJson");
            this.f337883a = r100;
            this.f337884b = r101;
            this.f337885c = r102;
        }
    }

    public h() {
    }
}
