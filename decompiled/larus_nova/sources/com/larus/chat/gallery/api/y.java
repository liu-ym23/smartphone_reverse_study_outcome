package com.larus.chat.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class y {

    public static final class a extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f324192a = null;

        static {
            f324192a = new a();
        }

        public a() {
        }
    }

    public static final class b extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f324193a = null;

        static {
            f324193a = new b();
        }

        public b() {
        }
    }

    public static final class c extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f324194a = null;

        static {
            f324194a = new c();
        }

        public c() {
        }
    }

    public static final class d extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f324195a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f324195a, ((d) r100).f324195a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f324195a.hashCode();
        }

        public final String toString() {
            return "Renamed(newTitle=" + this.f324195a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "newTitle");
            this.f324195a = r100;
        }
    }

    public y() {
    }
}
