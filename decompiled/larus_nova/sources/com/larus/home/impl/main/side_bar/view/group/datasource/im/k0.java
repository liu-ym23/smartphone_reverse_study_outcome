package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public interface k0 {

    public static final class a implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f345356a = null;

        static {
            f345356a = new a();
        }

        public a() {
        }
    }

    public static final class b implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f345357a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f345357a, ((b) r100).f345357a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f345357a.hashCode();
        }

        public final String toString() {
            return "Owned(deviceId=" + this.f345357a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "deviceId");
            this.f345357a = r100;
        }
    }

    public static final class c implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f345358a = null;

        static {
            f345358a = new c();
        }

        public c() {
        }
    }
}
