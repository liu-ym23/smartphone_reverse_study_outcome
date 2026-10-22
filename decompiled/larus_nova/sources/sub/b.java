package sub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio.ExternalAudioSourceMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f543605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f543606b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f543605a == r101.f543605a) goto L12;
            return false;
        L12:
            if (this.f543606b == r101.f543606b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f543605a * 31) + this.f543606b;
        }

        public final String toString() {
            return "AudioFormatRequest(sampleRate=" + this.f543605a + ", channel=" + this.f543606b + ')';
        }

        public a(int r100, int r101) {
            this.f543605a = r100;
            this.f543606b = r101;
        }
    }

    /* JADX INFO: renamed from: sub.b$b, reason: collision with other inner class name */
    public static final class C7658b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f543607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f543608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f543609c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7658b) == true) goto L8;
            return false;
        L8:
            C7658b r101 = (C7658b) r100;
            if (this.f543607a == r101.f543607a) goto L12;
            return false;
        L12:
            if (this.f543608b == r101.f543608b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f543609c, r101.f543609c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f543607a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + this.f543608b) * 31;
            String r102 = this.f543609c;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "InitResult(success=" + this.f543607a + ", bufferSize=" + this.f543608b + ", errorMessage=" + this.f543609c + ')';
        }

        public C7658b(boolean r100, int r101, String r102) {
            this.f543607a = r100;
            this.f543608b = r101;
            this.f543609c = r102;
        }

        public /* synthetic */ C7658b(boolean r100, int r101, String r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this(r100, r101, r102);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f543610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f543611b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f543610a == r101.f543610a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f543611b, r101.f543611b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f543610a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f543611b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "StartResult(success=" + this.f543610a + ", errorMessage=" + this.f543611b + ')';
        }

        public c(boolean r100, String r101) {
            this.f543610a = r100;
            this.f543611b = r101;
        }
    }

    void a();

    ExternalAudioSourceMode b();

    void c();

    void close();

    C7658b d(a r100);

    void pause();

    int read(byte[] r100, int r101);

    c startCapture();
}
