package com.bytedance.lark.view_flow_wrapper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public abstract class u {

    public static final class a extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f254464a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f254464a, ((a) r100).f254464a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f254464a.hashCode();
        }

        public final String toString() {
            return "Event(deliveryPolicy=" + this.f254464a + ')';
        }

        public a() {
            g.d r100 = g.d.f254432a;
            Intrinsics.checkNotNullParameter(r100, "deliveryPolicy");
            this.f254464a = r100;
        }
    }

    public static final class b extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f254465a = null;

        static {
            f254465a = new b();
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
            return -1959000985;
        }

        public final String toString() {
            return "LiveQuery";
        }

        public b() {
        }
    }

    public static final class c extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f254466a = null;

        static {
            f254466a = new c();
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
            return 545319740;
        }

        public final String toString() {
            return "State";
        }

        public c() {
        }
    }

    public u() {
    }
}
