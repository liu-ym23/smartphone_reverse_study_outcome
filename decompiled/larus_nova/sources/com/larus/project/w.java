package com.larus.project;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface w {

    public static final class a implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f367067a = null;

        static {
            f367067a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return 103608798;
        }

        public final String toString() {
            return "Loading";
        }
    }

    public static final class b implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f367068a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f367068a, ((b) r100).f367068a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f367068a.hashCode();
        }

        public final String toString() {
            return "Project(data=" + this.f367068a + ')';
        }

        public b(i r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f367068a = r100;
        }
    }
}
