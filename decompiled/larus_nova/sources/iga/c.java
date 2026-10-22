package iga;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BotModel f489755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f489756b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f489755a, r101.f489755a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489756b, r101.f489756b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f489755a.hashCode() * 31) + this.f489756b.hashCode();
    }

    public final String toString() {
        return "ObricMainChatSnapshot(bot=" + this.f489755a + ", conversation=" + this.f489756b + ')';
    }

    public c(BotModel r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "bot");
        Intrinsics.checkNotNullParameter(r101, "conversation");
        this.f489755a = r100;
        this.f489756b = r101;
    }
}
