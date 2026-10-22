package com.larus.bmhome.chat.layout.holder.answeraction;

import com.larus.im.bean.bot.MsgRegenMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MsgRegenMode f303505a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f303505a, ((b) r100).f303505a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f303505a.hashCode();
    }

    public final String toString() {
        return "RegenInstruction(regenMode=" + this.f303505a + ')';
    }

    public b(MsgRegenMode r100) {
        Intrinsics.checkNotNullParameter(r100, "regenMode");
        this.f303505a = r100;
    }
}
