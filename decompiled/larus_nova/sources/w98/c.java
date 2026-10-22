package w98;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final we9.e f558766a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f558766a, ((a) r100).f558766a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f558766a.hashCode();
        }

        public final String toString() {
            return "Ocr(model=" + this.f558766a + ')';
        }

        public a(we9.e r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            this.f558766a = r100;
            r100.getClass();
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tf9.a f558767a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f558767a, ((b) r100).f558767a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f558767a.hashCode();
        }

        public final String toString() {
            return "VideoFrame(frame=" + this.f558767a + ')';
        }

        public b(tf9.a r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            this.f558767a = r100;
            long r101 = r100.f545769c / ((long) 1000);
        }
    }
}
