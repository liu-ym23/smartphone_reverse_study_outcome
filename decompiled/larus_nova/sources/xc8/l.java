package xc8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f563245e;

    @Override // xc8.b
    public final int d() {
        return -1;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f563245e, ((l) r100).f563245e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f563245e.hashCode();
    }

    public final String toString() {
        return "TimestampCellState(timeMessage=" + this.f563245e + ')';
    }

    public l(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "timeMessage");
        super(r100);
        this.f563245e = r100;
    }
}
