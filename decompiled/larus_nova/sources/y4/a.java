package y4;

import com.bytedance.applet.model.floating.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Boolean, Boolean, Unit> f565908a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f565908a, ((a) r100).f565908a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f565908a.hashCode();
    }

    public final String toString() {
        return "ChatSpeakTipsAbility(switchStatus=" + this.f565908a + ')';
    }

    public a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "switchStatus");
        this.f565908a = r100;
    }
}
