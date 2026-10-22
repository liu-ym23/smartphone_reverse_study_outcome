package com.bytedance.lark.view_flow_wrapper;

/* JADX INFO: loaded from: classes20.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f254429a = null;

        static {
            f254429a = new a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return -1551938456;
        }

        public final String toString() {
            return "ConflateLatestAndDiscard";
        }

        public a() {
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f254430a = null;

        static {
            f254430a = new b();
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
            return -1154786388;
        }

        public final String toString() {
            return "DropIncomingAndDiscard";
        }

        public b() {
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f254431a = null;

        static {
            f254431a = new c();
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
            return -12912123;
        }

        public final String toString() {
            return "DropOldestAndDiscard";
        }

        public c() {
        }
    }

    public static final class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f254432a = null;

        static {
            f254432a = new d();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            d r101 = (d) r100;
            return true;
        }

        public final int hashCode() {
            return 656185753;
        }

        public final String toString() {
            return "Strict";
        }

        public d() {
        }
    }

    public g() {
    }
}
