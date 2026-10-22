package zj9;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f572547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f572548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f572549c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f572547a, r101.f572547a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572548b, r101.f572548b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f572549c, r101.f572549c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f572547a.hashCode() * 31) + this.f572548b.hashCode()) * 31) + this.f572549c.hashCode();
    }

    public final String toString() {
        return "VerifyLongWaitLoginOptionsDialogModel(itemList=" + this.f572547a + ", onShow=" + this.f572548b + ", onDismiss=" + this.f572549c + ')';
    }

    public r(List<k> r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "itemList");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onShow);
        Intrinsics.checkNotNullParameter(r102, "onDismiss");
        this.f572547a = r100;
        this.f572548b = r101;
        this.f572549c = r102;
    }
}
