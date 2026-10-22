package com.larus.bmhome.music.edit;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface v {

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f312841a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f312841a, ((a) r100).f312841a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f312841a.hashCode();
        }

        public final String toString() {
            return "Failure(msg=" + this.f312841a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f312841a = r100;
        }
    }

    public static final class b implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f312842a = null;

        static {
            f312842a = new b();
        }

        public b() {
        }
    }

    public static final class c implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f312843a = null;

        static {
            f312843a = new c();
        }

        public c() {
        }
    }
}
