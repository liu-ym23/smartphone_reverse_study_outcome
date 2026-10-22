package com.larus.bmhome.actionbar.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class w0 {

    public static final class a extends w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wa8.d1 f295535a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f295535a, ((a) r100).f295535a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f295535a.hashCode();
        }

        public final String toString() {
            return "Available(capability=" + this.f295535a + ')';
        }

        public a(wa8.d1 r100) {
            Intrinsics.checkNotNullParameter(r100, "capability");
            this.f295535a = r100;
        }
    }

    public static final class b extends w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f295536a = null;

        static {
            f295536a = new b();
        }

        public b() {
        }
    }

    public w0() {
    }
}
