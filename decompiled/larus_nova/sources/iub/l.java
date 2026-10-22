package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class l {

    public static final class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f495853a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f495853a, ((a) r100).f495853a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f495853a.hashCode();
        }

        public final String toString() {
            return "MmRecordingFirstSubtitleEvent(recordingId=" + this.f495853a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "recordingId");
            this.f495853a = r100;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f495854a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f495854a, ((b) r100).f495854a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f495854a.hashCode();
        }

        public final String toString() {
            return "MmRecordingPageShownEvent(recordingId=" + this.f495854a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "recordingId");
            this.f495854a = r100;
        }
    }

    public l() {
    }
}
