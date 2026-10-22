package com.larus.bmhome.bot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class r5 {

    public static final class a extends r5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f296698a = null;

        static {
            f296698a = new a();
        }

        public a() {
        }
    }

    public static final class b extends r5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f296699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f296700b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f296699a, r101.f296699a) == true) goto L12;
            return false;
        L12:
            if (this.f296700b == r101.f296700b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f296699a.hashCode() * 31;
            if (this.f296700b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ToggleUpdateFailed(itemId=" + this.f296699a + ", oldValue=" + this.f296700b + ')';
        }

        public b(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "itemId");
            this.f296699a = r100;
            this.f296700b = r101;
        }
    }

    public r5() {
    }
}
