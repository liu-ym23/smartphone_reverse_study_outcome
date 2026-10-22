package com.larus.bmhome.taskskill;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BotModel f314277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BotModel f314278b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f314277a, r101.f314277a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314278b, r101.f314278b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        BotModel r100 = this.f314277a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f314278b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "BotChange(old=" + this.f314277a + ", new=" + this.f314278b + ')';
    }

    public d(BotModel r100, BotModel r101) {
        Intrinsics.checkNotNullParameter(r101, "new");
        this.f314277a = r100;
        this.f314278b = r101;
    }
}
