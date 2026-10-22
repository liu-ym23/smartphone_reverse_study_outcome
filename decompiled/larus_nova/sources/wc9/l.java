package wc9;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f559248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Message> f559249b;

    public l() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f559248a, r101.f559248a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559249b, r101.f559249b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        e r100 = this.f559248a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Message> r104 = this.f559249b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationRecentMessage(conversation=" + this.f559248a + ", messageBody=" + this.f559249b + ')';
    }

    public /* synthetic */ l(e r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public l(e r100, List<Message> r101) {
        this.f559248a = r100;
        this.f559249b = r101;
    }
}
