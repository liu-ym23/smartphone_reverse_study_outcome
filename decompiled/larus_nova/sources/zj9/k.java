package zj9;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f572538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f572539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f572540c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f572538a == r101.f572538a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572539b, r101.f572539b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f572540c, r101.f572540c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f572538a * 31) + this.f572539b.hashCode()) * 31) + this.f572540c.hashCode();
    }

    public final String toString() {
        return "VerifyLongWaitLoginOptionItemModel(iconRes=" + this.f572538a + ", title=" + this.f572539b + ", onClick=" + this.f572540c + ')';
    }

    public k(int r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f572538a = r100;
        this.f572539b = r101;
        this.f572540c = r102;
    }
}
