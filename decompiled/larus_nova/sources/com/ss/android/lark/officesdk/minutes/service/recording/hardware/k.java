package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

/* JADX INFO: loaded from: classes37.dex */
public abstract class k {

    public static final class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f435570a = null;

        static {
            f435570a = new a();
        }

        public a() {
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f435571a = null;

        static {
            f435571a = new b();
        }

        public b() {
        }
    }

    public static final class c extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f435572a = null;

        static {
            f435572a = new c();
        }

        public c() {
        }
    }

    public static final class d extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f435573a = null;

        static {
            f435573a = new d();
        }

        public d() {
        }
    }

    public static final class e extends k {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            ((e) r100).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "SuspendForCallInterruption(interruptedPlaybackState=null)";
        }
    }

    public static final class f extends k {
        public f() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            ((f) r100).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "SuspendForInputUnavailable(reason=null)";
        }
    }

    public k() {
    }
}
