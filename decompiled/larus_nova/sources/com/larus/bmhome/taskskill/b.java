package com.larus.bmhome.taskskill;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f314251b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f314250a, r101.f314250a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314251b, r101.f314251b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f314250a.hashCode() * 31) + this.f314251b.hashCode();
    }

    public final String toString() {
        return "AuthorizationModeConversationKey(accountId=" + this.f314250a + ", conversationId=" + this.f314251b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "accountId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        this.f314250a = r100;
        this.f314251b = r101;
    }
}
