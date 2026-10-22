package com.larus.dora.impl.onboarding.othersmart;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f337175a;

    public static final class a extends r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f337176b = null;

        static {
            f337176b = new a();
        }

        public a() {
            super("gesture_end_guidance");
        }
    }

    public static final class b extends r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z98.f f337177b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337177b, ((b) r100).f337177b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337177b.hashCode();
        }

        public final String toString() {
            return "QueryMusic(data=" + this.f337177b + ')';
        }

        public b(z98.f r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super("");
            this.f337177b = r100;
        }
    }

    public static final class c extends r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f337178b = null;

        static {
            f337178b = new c();
        }

        public c() {
            super("gesture_end_guidance");
        }
    }

    public static final class d extends r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f337179b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f337179b == ((d) r100).f337179b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f337179b == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "QueryTopic(isTTSPlayed=" + this.f337179b + ')';
        }

        public d(boolean r100) {
            super("first_conversation_guidance");
            this.f337179b = r100;
        }
    }

    public static final class e extends r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f337180b = null;

        static {
            f337180b = new e();
        }

        public e() {
            super("");
        }
    }

    public static final class f extends r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f337181b = null;

        static {
            f337181b = new f();
        }

        public f() {
            super("subsequent_conversation_guidance");
        }
    }

    public static final class g extends r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f337182b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.f337182b == ((g) r100).f337182b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f337182b == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Wakeup(isTTSPlayed=" + this.f337182b + ')';
        }

        public g(boolean r100) {
            super("voice_wakeup_guidance");
            this.f337182b = r100;
        }
    }

    public r0(String r100) {
        this.f337175a = r100;
    }
}
