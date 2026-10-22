package com.ss.android.lark.chat.export.entity.message.content;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f415405c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f415405c, ((c) r100).f415405c) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f415405c.hashCode();
    }

    public final String toString() {
        return "InviteAtChatters(chatters=" + this.f415405c + ')';
    }

    public c(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "chatters");
        super(2, true);
        this.f415405c = r100;
    }
}
