package com.bytedance.flow_audio.impl.business.tts;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f244089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TtsResultFailureSource f244090b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f244089a, r101.f244089a) == true) goto L12;
            return false;
        L12:
            if (this.f244090b == r101.f244090b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f244089a.hashCode() * 31) + this.f244090b.hashCode();
        }

        public final String toString() {
            return "Failure(throwable=" + this.f244089a + ", source=" + this.f244090b + ')';
        }

        public a(Throwable r100, TtsResultFailureSource r101) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            Intrinsics.checkNotNullParameter(r101, "source");
            this.f244089a = r100;
            this.f244090b = r101;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f244091a = null;

        static {
            f244091a = new b();
        }

        public b() {
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
            return -630073613;
        }

        public final String toString() {
            return "Success";
        }
    }
}
