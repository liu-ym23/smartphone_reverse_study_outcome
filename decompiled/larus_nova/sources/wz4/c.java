package wz4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public interface c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f561939a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f561939a, ((a) r100).f561939a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f561939a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "SnapShotOpenParams(title=" + this.f561939a + ')';
        }

        public a(String r100) {
            this.f561939a = r100;
        }
    }

    void onSnapshotFailed(String r100);

    void onSnapshotSuccess(String r100, float r101);

    void onStartShot(a r100);
}
