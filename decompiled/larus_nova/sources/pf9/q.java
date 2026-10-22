package pf9;

import com.larus.im.service.audio.z0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class q implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<p> f528966a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f528966a, ((q) r100).f528966a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f528966a.hashCode();
    }

    public final String toString() {
        return "FlowLLMCommandReplyEvent(commandReply=" + this.f528966a + ')';
    }

    public q(List<p> r100) {
        Intrinsics.checkNotNullParameter(r100, "commandReply");
        this.f528966a = r100;
    }
}
