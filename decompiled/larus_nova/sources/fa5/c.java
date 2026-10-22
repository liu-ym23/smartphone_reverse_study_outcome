package fa5;

/* JADX INFO: loaded from: classes16.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f476023a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f476023a == ((a) r100).f476023a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f476023a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ClickVideoEvent(isImmersive=" + this.f476023a + ')';
        }

        public a(boolean r100) {
            this.f476023a = r100;
        }
    }

    public c() {
    }
}
