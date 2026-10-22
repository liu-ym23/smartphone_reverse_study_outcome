package cvb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: cvb.a$a, reason: collision with other inner class name */
    public static final class C5595a extends a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5595a) == true) goto L8;
            return false;
        L8:
            ((C5595a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Failed(code=0, message=null, debugMessage=null)";
        }
    }

    public a() {
    }
}
