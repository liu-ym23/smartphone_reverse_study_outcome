package com.larus.bmhome.actionbar.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f295501a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.bmhome.actionbar.model.v0$a$a, reason: collision with other inner class name */
        public static final class C4017a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4017a f295502a = null;

            static {
                f295502a = new C4017a();
            }

            public C4017a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f295503a = null;

            static {
                f295503a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final wa8.h1 f295504a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f295504a, ((c) r100).f295504a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f295504a.hashCode();
            }

            public final String toString() {
                return "Valid(rule=" + this.f295504a + ')';
            }

            public c(wa8.h1 r100) {
                Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276366p);
                this.f295504a = r100;
            }
        }

        public a() {
        }
    }

    static {
    }
}
