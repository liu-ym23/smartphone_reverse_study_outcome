package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f435050a = null;

        static {
            f435050a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b$b, reason: collision with other inner class name */
    public static final class C5188b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f435051a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5188b) == true) goto L9;
            return false;
        L9:
            if (this.f435051a == ((C5188b) r100).f435051a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f435051a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "PhoneCall(isCalling=" + this.f435051a + ')';
        }

        public C5188b(boolean r100) {
            this.f435051a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f435052a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f435052a == ((c) r100).f435052a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f435052a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SubtitleFailed(isFailed=" + this.f435052a + ')';
        }

        public c(boolean r100) {
            this.f435052a = r100;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f435053a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f435053a == ((d) r100).f435053a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f435053a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "WeakNetwork(isWeak=" + this.f435053a + ')';
        }

        public d(boolean r100) {
            this.f435053a = r100;
        }
    }

    public b() {
    }
}
