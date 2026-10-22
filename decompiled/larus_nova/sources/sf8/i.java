package sf8;

import com.larus.im.bean.message.Message;
import ic8.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f541738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f541739f;

    @Override // xc8.b
    public final int d() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f541738e, ((i) r100).f541738e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f541738e.hashCode();
    }

    public final String toString() {
        return "DeepSearchCellState(myMessage=" + this.f541738e + ')';
    }

    public i(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "myMessage");
        super(r100);
        this.f541738e = r100;
        int r101 = p.f489247a;
        this.f541739f = p.a.a(this.f563233a.getContent());
    }
}
