package dw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470347b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f470346a, r101.f470346a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470347b, r101.f470347b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f470346a.hashCode() * 31) + this.f470347b.hashCode();
    }

    public final String toString() {
        return "AIChatConversationInfo(conversationId=" + this.f470346a + ", botId=" + this.f470347b + ')';
    }

    public i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "botId");
        this.f470346a = r100;
        this.f470347b = r101;
    }
}
