package com.larus.dora.impl.onboarding.lite;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f337019a;

    public static final class a extends y0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f337020b = null;

        static {
            f337020b = new a();
        }

        public a() {
            super("gesture_end_guidance");
        }
    }

    public static final class b extends y0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z98.f f337021b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337021b, ((b) r100).f337021b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337021b.hashCode();
        }

        public final String toString() {
            return "QueryMusic(data=" + this.f337021b + ')';
        }

        public b(z98.f r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("");
            this.f337021b = r100;
        }
    }

    public static final class c extends y0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f337022b = null;

        static {
            f337022b = new c();
        }

        public c() {
            super("gesture_end_guidance");
        }
    }

    public static final class d extends y0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f337023b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f337023b == ((d) r100).f337023b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f337023b == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "QueryTopic(isTTSPlayed=" + this.f337023b + ')';
        }

        public d(boolean r100) {
            super("first_conversation_guidance");
            this.f337023b = r100;
        }
    }

    public static final class e extends y0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f337024b = null;

        static {
            f337024b = new e();
        }

        public e() {
            super("");
        }
    }

    public static final class f extends y0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f337025b = null;

        static {
            f337025b = new f();
        }

        public f() {
            super("subsequent_conversation_guidance");
        }
    }

    public static final class g extends y0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f337026b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.f337026b == ((g) r100).f337026b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f337026b == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Wakeup(isTTSPlayed=" + this.f337026b + ')';
        }

        public g(boolean r100) {
            super("voice_wakeup_guidance");
            this.f337026b = r100;
        }
    }

    public y0(String r100) {
        this.f337019a = r100;
    }
}
