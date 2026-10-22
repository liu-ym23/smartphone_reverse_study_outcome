package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f434454a = null;

        static {
            f434454a = new a();
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
            return 411324219;
        }

        public final String toString() {
            return "DefaultToast";
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.b$b, reason: collision with other inner class name */
    public static final class C5171b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5171b f434455a = null;

        static {
            f434455a = new C5171b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5171b) == true) goto L9;
            return false;
        L9:
            C5171b r101 = (C5171b) r100;
            return true;
        }

        public final int hashCode() {
            return 609598462;
        }

        public final String toString() {
            return "NoKeyToast";
        }

        public C5171b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f434456a = null;

        static {
            f434456a = new c();
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
            return -767945971;
        }

        public final String toString() {
            return "None";
        }

        public c() {
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f434457a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f434457a == ((d) r100).f434457a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434457a;
        }

        public final String toString() {
            return "QuotaDialog(denyType=" + this.f434457a + ')';
        }

        public d(int r100) {
            this.f434457a = r100;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f434458a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f434458a, ((e) r100).f434458a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434458a.hashCode();
        }

        public final String toString() {
            return "ServerMessageToast(message=" + this.f434458a + ')';
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f434458a = r100;
        }
    }

    public b() {
    }
}
