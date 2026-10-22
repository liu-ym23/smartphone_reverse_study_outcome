package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f434588a = null;

        static {
            f434588a = new a();
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
            return 1456460203;
        }

        public final String toString() {
            return "DefaultToast";
        }

        public a() {
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f434589a = null;

        static {
            f434589a = new b();
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
            return -2021713298;
        }

        public final String toString() {
            return "NoKeyToast";
        }

        public b() {
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f434590a = null;

        static {
            f434590a = new c();
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
            return -1381563011;
        }

        public final String toString() {
            return "None";
        }

        public c() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.d$d, reason: collision with other inner class name */
    public static final class C5174d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f434591a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5174d) == true) goto L9;
            return false;
        L9:
            if (this.f434591a == ((C5174d) r100).f434591a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434591a;
        }

        public final String toString() {
            return "QuotaDialog(denyType=" + this.f434591a + ')';
        }

        public C5174d(int r100) {
            this.f434591a = r100;
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f434592a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f434592a, ((e) r100).f434592a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434592a.hashCode();
        }

        public final String toString() {
            return "ServerMessageToast(message=" + this.f434592a + ')';
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f434592a = r100;
        }
    }

    public d() {
    }
}
