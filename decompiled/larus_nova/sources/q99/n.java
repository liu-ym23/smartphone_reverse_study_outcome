package q99;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f532178a;

    public n() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f532178a, ((n) r100).f532178a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f532178a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "FlowMessageFeedbackResult(message=" + this.f532178a + ')';
    }

    public n(Message r100) {
        this.f532178a = r100;
    }
}
