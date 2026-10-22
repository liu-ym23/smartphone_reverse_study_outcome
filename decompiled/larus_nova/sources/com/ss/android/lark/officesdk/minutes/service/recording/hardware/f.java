package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f435561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f435562b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f435561a == r101.f435561a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f435562b, r101.f435562b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f435561a * 31) + this.f435562b.hashCode();
        }

        public final String toString() {
            return "Failed(code=" + this.f435561a + ", message=" + this.f435562b + ')';
        }

        public a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "message");
            this.f435561a = r100;
            this.f435562b = r101;
        }
    }

    public static final class b extends f {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Success(recordingId=null)";
        }
    }

    public f() {
    }
}
