package kw5;

import com.larus.audio.flow.client.kmp_com.AsrFileAudioDataProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f506395a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f506395a, ((a) r100).f506395a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f506395a.hashCode();
        }

        public final String toString() {
            return "Failure(error=" + this.f506395a + ')';
        }

        public a(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f506395a = r100;
        }
    }

    /* JADX INFO: renamed from: kw5.b$b, reason: collision with other inner class name */
    public static final class C6619b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f506396a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6619b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f506396a, ((C6619b) r100).f506396a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f506396a.hashCode();
        }

        public final String toString() {
            return "Success(stream=" + this.f506396a + ')';
        }

        public C6619b(AsrFileAudioDataProvider.a r100) {
            Intrinsics.checkNotNullParameter(r100, "stream");
            this.f506396a = r100;
        }
    }

    public b() {
    }
}
