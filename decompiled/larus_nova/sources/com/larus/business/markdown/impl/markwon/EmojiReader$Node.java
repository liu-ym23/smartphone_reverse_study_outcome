package com.larus.business.markdown.impl.markwon;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class EmojiReader$Node {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EmojiReader$Node) == true) goto L8;
        return false;
    L8:
        ((EmojiReader$Node) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "Node(startIndex=0, length=0, isEmoji=false, codePoint=" + CollectionsKt.joinToString$default(null, null, null, null, 0, null, EmojiReader$Node$toString$1.INSTANCE, 31, null) + ')';
    }
}
