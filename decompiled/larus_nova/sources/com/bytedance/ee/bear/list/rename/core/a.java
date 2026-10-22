package com.bytedance.ee.bear.list.rename.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.rename.core.a$a, reason: collision with other inner class name */
    public static final class C3280a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f229348a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3280a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f229348a, ((C3280a) r100).f229348a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f229348a.hashCode();
        }

        public final String toString() {
            return "Disabled(tips=" + this.f229348a + ')';
        }

        public C3280a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tips");
            this.f229348a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f229349a = null;

        static {
            f229349a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f229350a = null;

        static {
            f229350a = new c();
        }

        public c() {
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f229351a = null;

        static {
            f229351a = new d();
        }

        public d() {
        }
    }

    public a() {
    }
}
