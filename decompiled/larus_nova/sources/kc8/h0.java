package kc8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final eh8.b f502493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Message, Boolean> f502494b;

    public h0() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f502493a, r101.f502493a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502494b, r101.f502494b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        eh8.b r100 = this.f502493a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<Message, Boolean> r104 = this.f502494b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LynxBlockConfig(ivyPluginViewPool=" + this.f502493a + ", getLotteryMsgCardShowIsStream=" + this.f502494b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(eh8.b r100, Function1<? super Message, Boolean> r101) {
        this.f502493a = r100;
        this.f502494b = r101;
    }
}
