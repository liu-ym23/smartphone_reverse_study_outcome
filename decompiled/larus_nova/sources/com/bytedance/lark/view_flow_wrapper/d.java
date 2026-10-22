package com.bytedance.lark.view_flow_wrapper;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@JvmInline
public final class d<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f254422b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f254423a;

    public static final class a {
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f254424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f254425b;

        public final Throwable a() {
            if (this.f254425b == false) goto L8;
            T r100 = this.f254424a;
            if ((r100 instanceof Throwable) == true) goto L7;
            return null;
        L7:
            return (Throwable) r100;
        L8:
            return null;
        }

        public final T b() {
            if (this.f254425b == false) goto L6;
            return null;
        L6:
            return this.f254424a;
        }

        public final int hashCode() {
            T r100 = this.f254424a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            if (this.f254425b == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            if (this.f254425b == false) goto L5;
            StringBuilder r100 = new StringBuilder("Exception(");
        L6:
            r100.append(this.f254424a);
            r100.append(')');
            return r100.toString();
        L5:
            r100 = new StringBuilder("Failure(");
            goto L6
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == false) goto L9;
            b r101 = (b) r100;
            if (r101.f254425b != this.f254425b) goto L9;
            if (Intrinsics.areEqual(this.f254424a, r101.f254424a) == false) goto L9;
            return true;
        L9:
            return false;
        }

        public b(T r100, boolean r101) {
            this.f254424a = r100;
            this.f254425b = r101;
        }
    }

    static {
    }

    public final int hashCode() {
        Object r100 = this.f254423a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        Object r100 = this.f254423a;
        if ((r100 instanceof b) == false) goto L6;
        return ((b) r100).toString();
    L6:
        return "Success(" + r100 + ')';
    }

    public /* synthetic */ d(Object r100) {
        this.f254423a = r100;
    }

    public final boolean equals(Object r100) {
        Object r101 = this.f254423a;
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r101, ((d) r100).f254423a) == false) goto L11;
        return true;
    L11:
        return false;
    }
}
