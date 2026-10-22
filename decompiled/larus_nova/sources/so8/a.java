package so8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DeepThinkFoldStatus f542736a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f542736a == ((a) r100).f542736a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f542736a.hashCode();
    }

    public final String toString() {
        return "SupportContext(foldStatus=" + this.f542736a + ')';
    }

    public a() {
        this(DeepThinkFoldStatus.CompleteFold);
    }

    public a(DeepThinkFoldStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "foldStatus");
        this.f542736a = r100;
    }
}
