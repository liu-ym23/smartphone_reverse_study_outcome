package com.bytedance.ee.bear.list.rename.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f229357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f229358b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f229357a, r101.f229357a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f229358b, r101.f229358b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f229357a.hashCode() * 31;
            Throwable r101 = this.f229358b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failed(tips=" + this.f229357a + ", error=" + this.f229358b + ')';
        }

        public a(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "tips");
            this.f229357a = r100;
            this.f229358b = r101;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f229359a = null;

        static {
            f229359a = new b();
        }

        public b() {
        }
    }

    public c() {
    }
}
