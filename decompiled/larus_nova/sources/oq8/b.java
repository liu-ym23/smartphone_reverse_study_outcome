package oq8;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Character> f524899a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f524899a, ((b) r100).f524899a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f524899a.hashCode();
    }

    public final String toString() {
        return "InlineTriggerConfig(triggerChars=" + this.f524899a + ')';
    }

    public b(Object r100) {
        Set<Character> r101 = SetsKt.setOf('@');
        Intrinsics.checkNotNullParameter(r101, "triggerChars");
        this.f524899a = r101;
    }
}
