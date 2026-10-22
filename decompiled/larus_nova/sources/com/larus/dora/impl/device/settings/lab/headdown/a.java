package com.larus.dora.impl.device.settings.lab.headdown;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headdown.a$a, reason: collision with other inner class name */
    public static final class C4232a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334770a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4232a) == true) goto L9;
            return false;
        L9:
            if (this.f334770a == ((C4232a) r100).f334770a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334770a;
        }

        public final String toString() {
            return "Calibrating(remainingSeconds=" + this.f334770a + ')';
        }

        public C4232a(int r100) {
            this.f334770a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HeadDownCalibrationFailureReason f334771a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f334771a == ((b) r100).f334771a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334771a.hashCode();
        }

        public final String toString() {
            return "Failure(reason=" + this.f334771a + ')';
        }

        public b(HeadDownCalibrationFailureReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f334771a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f334772a = null;

        static {
            f334772a = new c();
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
            return -2122688393;
        }

        public final String toString() {
            return "Intro";
        }

        public c() {
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f334774b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f334773a == r101.f334773a) goto L12;
            return false;
        L12:
            if (this.f334774b == r101.f334774b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f334773a * 31) + this.f334774b;
        }

        public final String toString() {
            return "Preparing(remainingSeconds=" + this.f334773a + ", progress=" + this.f334774b + ')';
        }

        public d(int r100, int r101) {
            this.f334773a = r100;
            this.f334774b = r101;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f334775a = null;

        static {
            f334775a = new e();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            e r101 = (e) r100;
            return true;
        }

        public final int hashCode() {
            return 675273550;
        }

        public final String toString() {
            return "Success";
        }

        public e() {
        }
    }

    public a() {
    }
}
