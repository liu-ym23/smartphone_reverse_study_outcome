package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface z {

    public static final class a implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LLMCallEvent f336835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f336836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f336837c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f336835a == r101.f336835a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f336836b, r101.f336836b) == true) goto L15;
            return false;
        L15:
            if (this.f336837c == r101.f336837c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f336835a.hashCode() * 31;
            Integer r101 = this.f336836b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f336837c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "State(state=" + this.f336835a + ", code=" + this.f336836b + ", ts=" + this.f336837c + ')';
        }

        public a(LLMCallEvent r100, Integer r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f336835a = r100;
            this.f336836b = r101;
            this.f336837c = r102;
        }
    }
}
