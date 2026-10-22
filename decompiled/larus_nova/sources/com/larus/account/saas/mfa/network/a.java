package com.larus.account.saas.mfa.network;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: com.larus.account.saas.mfa.network.a$a, reason: collision with other inner class name */
    public static final class C3944a<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f286445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f286446b;

        public C3944a() {
            throw null;
        }

        public final int hashCode() {
            int r100 = this.f286445a.hashCode() * 31;
            T r101 = this.f286446b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(error=" + this.f286445a + ", body=" + this.f286446b + ')';
        }

        public C3944a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f286445a = r100;
            this.f286446b = null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3944a) == true) goto L8;
            return false;
        L8:
            C3944a r101 = (C3944a) r100;
            if (Intrinsics.areEqual(this.f286445a, r101.f286445a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286446b, r101.f286446b) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f286447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f286448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f286449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, String> f286450d;

        public b() {
            throw null;
        }

        public final int hashCode() {
            int r100 = this.f286447a * 31;
            String r101 = this.f286448b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Throwable r105 = this.f286449c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Map<String, String> r108 = this.f286450d;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "FlowError(code=" + this.f286447a + ", tips=" + this.f286448b + ", exception=" + this.f286449c + ", ext=" + this.f286450d + ')';
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f286447a == r101.f286447a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286448b, r101.f286448b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f286449c, r101.f286449c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f286450d, r101.f286450d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public b(int r100, String r101) {
            this.f286447a = r100;
            this.f286448b = r101;
            this.f286449c = null;
            this.f286450d = null;
        }
    }

    public interface c {
    }

    public static final class d<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f286451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f286452b;

        public d() {
            throw null;
        }

        public final int hashCode() {
            T r100 = this.f286451a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f286452b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "Success(body=" + this.f286451a + ", error=" + this.f286452b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Object r100) {
            b r101 = new b(0, "OK");
            Intrinsics.checkNotNullParameter(r101, "error");
            this.f286451a = r100;
            this.f286452b = r101;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f286451a, r101.f286451a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286452b, r101.f286452b) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    public a() {
    }
}
