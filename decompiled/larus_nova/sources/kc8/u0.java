package kc8;

import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f502577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Message, Unit> f502578b;

    public u0() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.f502577a, r101.f502577a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502578b, r101.f502578b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f502577a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<Message, Unit> r104 = this.f502578b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskCardConfig(cotDetailDisableInput=" + this.f502577a + ", appendReferenceMessage=" + this.f502578b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u0(Boolean r100, Function1<? super Message, Unit> r101) {
        this.f502577a = r100;
        this.f502578b = r101;
    }
}
