package ym8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f568385a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f568385a, ((a) r100).f568385a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f568385a.hashCode();
    }

    public final String toString() {
        return "RealNameVerifiedVMData(message=" + this.f568385a + ')';
    }

    public a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f568385a = r100;
    }
}
