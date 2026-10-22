package com.larus.camera.impl.ui.component.result.general;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class n {

    public static final class a extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ix8.d f322319a;

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
            if (Intrinsics.areEqual(this.f322319a, ((a) r100).f322319a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            ix8.d r100 = this.f322319a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        @Override // com.larus.camera.impl.ui.component.result.general.n
        public final String toString() {
            return "Completed(detectResult=" + this.f322319a + ')';
        }

        public a(ix8.d r100) {
            this.f322319a = r100;
        }
    }

    public static final class b extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f322320a = null;

        static {
            f322320a = new b();
        }

        public b() {
        }
    }

    public static final class c extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f322321a = null;

        static {
            f322321a = new c();
        }

        public c() {
        }
    }

    public n() {
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
