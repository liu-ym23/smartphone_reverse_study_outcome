package com.larus.bmhome.taskskill.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface k {

    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f314452a = null;

        static {
            f314452a = new a();
        }

        public a() {
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
            return -1436327194;
        }

        public final String toString() {
            return "BrowserTakeoverOpened";
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f314453a;

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f314453a, ((b) r100).f314453a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f314453a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Failure(reason=" + this.f314453a + ')';
        }

        public b(String r100) {
            this.f314453a = r100;
        }
    }

    public static final class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f314454a = null;

        static {
            f314454a = new c();
        }

        public c() {
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
            return 632741084;
        }

        public final String toString() {
            return "PcGuideConfirmed";
        }
    }

    public static final class d implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f314455a = null;

        static {
            f314455a = new d();
        }

        public d() {
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
            return 1596317222;
        }

        public final String toString() {
            return "PcGuideDismissed";
        }
    }

    public static final class e implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f314456a = null;

        static {
            f314456a = new e();
        }

        public e() {
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
            return 1455711502;
        }

        public final String toString() {
            return "PcGuideShown";
        }
    }

    public static final class f implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f314457a = null;

        static {
            f314457a = new f();
        }

        public f() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            f r101 = (f) r100;
            return true;
        }

        public final int hashCode() {
            return -1545128776;
        }

        public final String toString() {
            return "RequestStarted";
        }
    }

    public static final class g implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f314458a = null;

        static {
            f314458a = new g();
        }

        public g() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            g r101 = (g) r100;
            return true;
        }

        public final int hashCode() {
            return 1968037034;
        }

        public final String toString() {
            return "ResultAccepted";
        }
    }

    public interface h extends k {
    }

    public static final class i implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f314459a = null;

        static {
            f314459a = new i();
        }

        public i() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            i r101 = (i) r100;
            return true;
        }

        public final int hashCode() {
            return 1838148143;
        }

        public final String toString() {
            return "Unsupported";
        }
    }
}
