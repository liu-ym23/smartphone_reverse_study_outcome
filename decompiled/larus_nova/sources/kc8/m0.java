package kc8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Message, Boolean> f502528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f502529b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f502528a, r101.f502528a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502529b, r101.f502529b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f502528a.hashCode() * 31) + this.f502529b.hashCode();
    }

    public final String toString() {
        return "RelatedVideoBlockChatConfig(isLastVideoMessage=" + this.f502528a + ", lastVideoMessageId=" + this.f502529b + ')';
    }

    public m0(cb8.n r100, cb8.f r101) {
        Intrinsics.checkNotNullParameter(r100, "isLastVideoMessage");
        Intrinsics.checkNotNullParameter(r101, "lastVideoMessageId");
        this.f502528a = r100;
        this.f502529b = r101;
    }
}
