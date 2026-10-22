package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C4272a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionEvent f336792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f336793b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4272a) == true) goto L8;
            return false;
        L8:
            C4272a r101 = (C4272a) r100;
            if (this.f336792a == r101.f336792a) goto L12;
            return false;
        L12:
            if (this.f336793b == r101.f336793b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f336792a.hashCode() * 31) + this.f336793b;
        }

        public final String toString() {
            return "State(action=" + this.f336792a + ", type=" + this.f336793b + ')';
        }

        public final int getType() {
            return this.f336793b;
        }

        public C4272a(ActionEvent r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f336792a = r100;
            this.f336793b = r101;
        }
    }
}
