package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.passport.flow.core.router.FlowStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class j {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.passport.flow.mfa.b f437898a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f437898a, ((a) r100).f437898a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f437898a.hashCode();
        }

        public final String toString() {
            return "CodeApplied(result=" + this.f437898a + ')';
        }

        public a(com.ss.android.lark.passport.flow.mfa.b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f437898a = r100;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f437899a = null;

        static {
            f437899a = new b();
        }

        public b() {
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowMfaError f437900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f437901b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f437900a, r101.f437900a) == true) goto L12;
            return false;
        L12:
            if (this.f437901b == r101.f437901b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f437900a.hashCode() * 31;
            if (this.f437901b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Error(error=" + this.f437900a + ", terminal=" + this.f437901b + ')';
        }

        public c(FlowMfaError r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f437900a = r100;
            this.f437901b = r101;
        }
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowStep f437902a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f437902a, ((d) r100).f437902a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f437902a.hashCode();
        }

        public final String toString() {
            return "Route(step=" + this.f437902a + ')';
        }

        public d(FlowStep r100) {
            Intrinsics.checkNotNullParameter(r100, "step");
            this.f437902a = r100;
        }
    }

    public j() {
    }
}
