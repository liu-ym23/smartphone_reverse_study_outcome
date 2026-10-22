package qw5;

import com.obric.capabilitykit.common.ErrorCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f535008a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f535008a, ((d) r100).f535008a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        c r100 = this.f535008a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "KmpAudioRetransmitStrategy(data=" + this.f535008a + ')';
    }

    public d() {
        this(new c(true, new int[]{200, 400, 800, 1600, 3200, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT}));
    }

    public d(c r100) {
        this.f535008a = r100;
    }
}
