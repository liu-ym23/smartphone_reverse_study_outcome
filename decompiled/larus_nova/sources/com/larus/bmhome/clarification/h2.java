package com.larus.bmhome.clarification;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class h2 {

    public static final class a extends h2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f310537a;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f310537a, ((a) r100).f310537a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f310537a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Failure(reason=" + this.f310537a + ')';
        }

        public a(String r100) {
            this.f310537a = r100;
        }
    }

    public static final class b extends h2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f310538a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f310538a, ((b) r100).f310538a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f310538a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Pending(reason=" + this.f310538a + ')';
        }

        public b() {
            this.f310538a = null;
        }
    }

    public static final class c extends h2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f310539a = null;

        static {
            f310539a = new c();
        }

        public c() {
        }
    }

    public h2() {
    }
}
