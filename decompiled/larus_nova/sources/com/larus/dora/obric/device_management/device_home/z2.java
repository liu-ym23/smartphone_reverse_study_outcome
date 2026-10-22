package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface z2 {

    public static final class a implements z2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraObricGlassesMode f339402a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f339402a == ((a) r100).f339402a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f339402a.hashCode();
        }

        public final String toString() {
            return "ExternalModeChanged(mode=" + this.f339402a + ')';
        }

        public a(DoraObricGlassesMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            this.f339402a = r100;
        }
    }

    public static final class b implements z2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraObricGlassesMode f339403a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f339403a == ((b) r100).f339403a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f339403a.hashCode();
        }

        public final String toString() {
            return "SelectMode(mode=" + this.f339403a + ')';
        }

        public b(DoraObricGlassesMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            this.f339403a = r100;
        }
    }

    public static final class c implements z2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f339404a = null;

        static {
            f339404a = new c();
        }

        public c() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return 1586022282;
        }

        public final String toString() {
            return "Shutdown";
        }
    }
}
