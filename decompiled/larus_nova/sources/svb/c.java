package svb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class c implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends c {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ShowToast(event=null)";
        }
    }

    public c() {
    }
}
