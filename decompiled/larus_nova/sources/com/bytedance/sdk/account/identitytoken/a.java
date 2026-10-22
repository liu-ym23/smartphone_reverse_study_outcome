package com.bytedance.sdk.account.identitytoken;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.sdk.account.identitytoken.a$a, reason: collision with other inner class name */
    public static final class C3758a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f268918a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L13:
            return true;
        L5:
            if ((r100 instanceof C3758a) == true) goto L7;
        L12:
            return false;
        L7:
            if (this.f268918a != ((C3758a) r100).f268918a) goto L9;
            boolean r101 = true;
        L10:
            if (r101 == false) goto L12;
        L9:
            r101 = false;
            goto L10
        }

        public final int hashCode() {
            return this.f268918a;
        }

        public final String toString() {
            return "Fail(errorCode=" + this.f268918a + ")";
        }

        public C3758a(int r100) {
            this.f268918a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f268919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f268920b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L15:
            return true;
        L5:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f268919a, r101.f268919a) == false) goto L14;
            if (this.f268920b != r101.f268920b) goto L11;
            boolean r102 = true;
        L12:
            if (r102 == false) goto L14;
        L11:
            r102 = false;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            String r100 = this.f268919a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.f268920b;
            ?? r104 = r103;
            if (r103 == false) goto L10;
            r104 = 1;
        L10:
            return r102 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(identityToken=" + this.f268919a + ", isFromCache=" + this.f268920b + ")";
        }

        public b(String r100, boolean r101) {
            this.f268919a = r100;
            this.f268920b = r101;
        }
    }

    public a() {
    }
}
