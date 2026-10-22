package com.larus.im.internal.core.conversation.bot;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f347562a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f347562a, ((c) r100).f347562a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f347562a.hashCode();
    }

    public final String toString() {
        return "BatchGetBotRequest(conversationIdList=" + this.f347562a + ')';
    }

    public c(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationIdList");
        this.f347562a = r100;
    }
}
