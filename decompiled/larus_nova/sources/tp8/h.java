package tp8;

import com.larus.bmhome.interactionpanel.j;
import jc8.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Unit> f547060a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f547060a, ((h) r100).f547060a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f547060a.hashCode();
    }

    public final String toString() {
        return "QuickReplyInputPassData(onResult=" + this.f547060a + ')';
    }

    public h(j r100) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        this.f547060a = r100;
    }
}
