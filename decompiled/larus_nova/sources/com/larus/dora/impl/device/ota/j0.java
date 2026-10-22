package com.larus.dora.impl.device.ota;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface j0 {

    public static final class a implements j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334203a = null;

        static {
            f334203a = new a();
        }

        public a() {
        }
    }

    public static final class b implements j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f334204a = null;

        static {
            f334204a = new b();
        }

        public b() {
        }
    }

    public static final class c implements j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f334205a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f334205a, ((c) r100).f334205a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334205a.hashCode();
        }

        public final String toString() {
            return "ShowToast(title=" + this.f334205a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f334205a = r100;
        }
    }
}
