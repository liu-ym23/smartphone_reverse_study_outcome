package com.larus.dora.obric.onboarding;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.a$a, reason: collision with other inner class name */
    public static final class C4295a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionEvent f340814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f340815b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4295a) == true) goto L8;
            return false;
        L8:
            C4295a r101 = (C4295a) r100;
            if (this.f340814a == r101.f340814a) goto L12;
            return false;
        L12:
            if (this.f340815b == r101.f340815b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f340814a.hashCode() * 31) + this.f340815b;
        }

        public final String toString() {
            return "State(action=" + this.f340814a + ", type=" + this.f340815b + ')';
        }

        public final int getType() {
            return this.f340815b;
        }

        public C4295a(ActionEvent r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f340814a = r100;
            this.f340815b = r101;
        }
    }
}
