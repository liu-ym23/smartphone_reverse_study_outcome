package of8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f523117e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f523117e, ((i) r100).f523117e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f523117e.hashCode();
    }

    public final String toString() {
        return "BlockCellState(mMessage=" + this.f523117e + ')';
    }

    @Override // xc8.b
    public final int d() {
        if (this.f523117e.getContentType() != 8) goto L6;
        return 3;
    L6:
        if (this.f523117e.getContentType() != 100) goto L9;
    L7:
        return 0;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(this.f523117e) == false) goto L7;
        return 1;
    }

    public i(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "mMessage");
        super(r100);
        this.f523117e = r100;
    }
}
