package pf9;

import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c0 implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f528895a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f528895a, ((c0) r100).f528895a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f528895a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "FlowLLMQueryUpdateEvent(asrResult=" + this.f528895a + ')';
    }

    public c0(a r100) {
        this.f528895a = r100;
    }
}
