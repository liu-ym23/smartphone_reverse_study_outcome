package com.larus.canvas.core.impl.sse;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class l {

    public static final class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f322990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<cy8.b> f322991b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f322990a, r101.f322990a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f322991b, r101.f322991b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f322990a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f322991b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "Blocks(sequenceId=" + this.f322990a + ", blocks=" + this.f322991b + ')';
        }

        public a(Long r100, List<cy8.b> r101) {
            Intrinsics.checkNotNullParameter(r101, "blocks");
            this.f322990a = r100;
            this.f322991b = r101;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f322992a = null;

        static {
            f322992a = new b();
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
            return -1422663030;
        }

        public final String toString() {
            return "Done";
        }

        public b() {
        }
    }

    public static final class c extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f322993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f322994b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f322993a == r101.f322993a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f322994b, r101.f322994b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f322993a * 31;
            String r101 = this.f322994b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(code=" + this.f322993a + ", message=" + this.f322994b + ')';
        }

        public c(int r100, String r101) {
            this.f322993a = r100;
            this.f322994b = r101;
        }
    }

    public static final class d extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f322995a = null;

        static {
            f322995a = new d();
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
            return 96878794;
        }

        public final String toString() {
            return "Ignored";
        }

        public d() {
        }
    }

    public l() {
    }
}
