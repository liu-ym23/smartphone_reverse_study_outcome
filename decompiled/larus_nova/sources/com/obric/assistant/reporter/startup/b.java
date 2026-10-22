package com.obric.assistant.reporter.startup;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f391406a = null;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f391407b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<String> f391408a;

        /* JADX INFO: renamed from: com.obric.assistant.reporter.startup.b$a$a, reason: collision with other inner class name */
        public static final class C4621a {
        }

        static {
        }

        public a(Set r100) {
            this.f391408a = r100;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.reporter.startup.b$b, reason: collision with other inner class name */
    public static final class C4622b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f391409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f391410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f391411c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4622b) == true) goto L8;
            return false;
        L8:
            C4622b r101 = (C4622b) r100;
            if (this.f391409a == r101.f391409a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f391410b, r101.f391410b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f391411c, r101.f391411c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f391409a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f391410b.hashCode()) * 31;
            String r102 = this.f391411c;
            if (r102 != null) goto L5;
            int r103 = 0;
        L7:
            return r101 + r103;
        L5:
            r103 = r102.hashCode();
            goto L7
        }

        public final String toString() {
            return "NormalizedStart(elapsedMs=" + this.f391409a + ", clock=" + this.f391410b + ", rejectionReason=" + this.f391411c + ')';
        }

        public C4622b(long r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "clock");
            this.f391409a = r100;
            this.f391410b = r101;
            this.f391411c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f391412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f391413b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f391412a, r101.f391412a) == true) goto L12;
            return false;
        L12:
            if (this.f391413b == r101.f391413b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f391412a.hashCode() * 31;
            if (this.f391413b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ProcessState(type=" + this.f391412a + ", inferred=" + this.f391413b + ')';
        }

        public final String getType() {
            return this.f391412a;
        }

        public c(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f391412a = r100;
            this.f391413b = r101;
        }
    }

    static {
        f391406a = SetsKt.setOf(new String[]{"elapsed_realtime", "uptime_converted_to_elapsed", "wall_converted_to_elapsed", "receiver_elapsed_fallback"});
    }

    public static C4622b a(long r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "requestedClock");
        if (f391406a.contains(r101) == true) goto L6;
        String r103 = "unsupported_clock";
    L15:
        if (r103 != null) goto L18;
        return new C4622b(r100, r101, null);
    L18:
        return new C4622b(r102, "receiver_elapsed_fallback", r103);
    L6:
        if (r100 > 0) goto L9;
        r103 = "non_positive";
        goto L15
    L9:
        if (r100 <= r102) goto L12;
        r103 = "future";
        goto L15
    L12:
        if ((r102 - r100) <= 60000) goto L14;
        r103 = "too_old";
        goto L15
    L14:
        r103 = null;
        goto L15
    }
}
