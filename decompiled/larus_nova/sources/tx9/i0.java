package tx9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f547875c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f547873a, r101.f547873a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547874b, r101.f547874b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f547875c, r101.f547875c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f547873a.hashCode() * 31) + this.f547874b.hashCode()) * 31;
        Long r101 = this.f547875c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ConversationForkTraceSource(conversationId=" + this.f547873a + ", messageId=" + this.f547874b + ", forkIndex=" + this.f547875c + ')';
    }

    public i0(String r100, String r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        this.f547873a = r100;
        this.f547874b = r101;
        this.f547875c = r102;
    }
}
