package kc8;

import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Function1<? super BotModel, Unit>, Unit> f502495a;

    public i() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f502495a, ((i) r100).f502495a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Function1<Function1<? super BotModel, Unit>, Unit> r100 = this.f502495a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "BotReferenceTextConfig(observeNextBotChange=" + this.f502495a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function1<? super Function1<? super BotModel, Unit>, Unit> r100) {
        this.f502495a = r100;
    }
}
