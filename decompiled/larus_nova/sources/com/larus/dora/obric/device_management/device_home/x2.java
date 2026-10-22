package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface x2 {

    public static final class a implements x2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraObricGlassesMode f339385a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f339385a == ((a) r100).f339385a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f339385a.hashCode();
        }

        public final String toString() {
            return "ChangeMode(mode=" + this.f339385a + ')';
        }

        public a(DoraObricGlassesMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            this.f339385a = r100;
        }
    }

    public static final class b implements x2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f339386a = null;

        static {
            f339386a = new b();
        }

        public b() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return -425262599;
        }

        public final String toString() {
            return "Shutdown";
        }
    }
}
