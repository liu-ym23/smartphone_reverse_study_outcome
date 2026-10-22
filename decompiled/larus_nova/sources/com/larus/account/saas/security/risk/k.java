package com.larus.account.saas.security.risk;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class k<T> {

    public static final class a<T> extends k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f286535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f286536b;

        public a() {
            throw null;
        }

        public final int hashCode() {
            int r100 = this.f286535a.hashCode() * 31;
            T r101 = this.f286536b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(error=" + this.f286535a + ", body=" + this.f286536b + ')';
        }

        public a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f286535a = r100;
            this.f286536b = null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f286535a, r101.f286535a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286536b, r101.f286536b) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f286537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f286538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f286539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, String> f286540d;

        public b() {
            throw null;
        }

        public final int hashCode() {
            int r100 = this.f286537a * 31;
            String r101 = this.f286538b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Throwable r105 = this.f286539c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Map<String, String> r108 = this.f286540d;
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
            return "FlowError(code=" + this.f286537a + ", tips=" + this.f286538b + ", exception=" + this.f286539c + ", ext=" + this.f286540d + ')';
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f286537a == r101.f286537a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286538b, r101.f286538b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f286539c, r101.f286539c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f286540d, r101.f286540d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public b(int r100, String r101, Throwable r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this.f286537a = r100;
            this.f286538b = r101;
            this.f286539c = r102;
            this.f286540d = null;
        }
    }

    public interface c {
    }

    public static final class d<T> extends k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f286541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f286542b;

        public d() {
            throw null;
        }

        public final int hashCode() {
            T r100 = this.f286541a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f286542b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "Success(body=" + this.f286541a + ", error=" + this.f286542b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Object r100) {
            b r101 = new b(0, "OK", null, 12);
            Intrinsics.checkNotNullParameter(r101, "error");
            this.f286541a = r100;
            this.f286542b = r101;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f286541a, r101.f286541a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286542b, r101.f286542b) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    public k() {
    }
}
