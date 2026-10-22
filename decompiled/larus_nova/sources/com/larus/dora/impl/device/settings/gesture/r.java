package com.larus.dora.impl.device.settings.gesture;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class r {

    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334485a = null;

        static {
            f334485a = new a();
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
            return 283760619;
        }

        public final String toString() {
            return "Failed";
        }

        public a() {
        }
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f334486a = null;

        static {
            f334486a = new b();
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
            return -281176318;
        }

        public final String toString() {
            return "Idle";
        }

        public b() {
        }
    }

    public static final class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LastSwitchSide f334487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<DoraGGestureSettings> f334488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<DoraGGestureSettings> f334489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<DoraGGestureSettings> f334490d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f334487a == r101.f334487a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f334488b, r101.f334488b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f334489c, r101.f334489c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f334490d, r101.f334490d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f334487a.hashCode() * 31) + this.f334488b.hashCode()) * 31) + this.f334489c.hashCode()) * 31) + this.f334490d.hashCode();
        }

        public final String toString() {
            return "Success(side=" + this.f334487a + ", mediaList=" + this.f334488b + ", callingList=" + this.f334489c + ", aiList=" + this.f334490d + ')';
        }

        public c(LastSwitchSide r100, List<DoraGGestureSettings> r101, List<DoraGGestureSettings> r102, List<DoraGGestureSettings> r103) {
            Intrinsics.checkNotNullParameter(r100, "side");
            Intrinsics.checkNotNullParameter(r101, "mediaList");
            Intrinsics.checkNotNullParameter(r102, "callingList");
            Intrinsics.checkNotNullParameter(r103, "aiList");
            this.f334487a = r100;
            this.f334488b = r101;
            this.f334489c = r102;
            this.f334490d = r103;
        }
    }

    public r() {
    }
}
