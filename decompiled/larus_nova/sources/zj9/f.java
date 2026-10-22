package zj9;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.login.impl.e0;
import com.larus.login.impl.f0;
import com.larus.nova.R;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f572520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g> f572521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f572522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f572523d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f572520a == r101.f572520a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572521b, r101.f572521b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f572522c, r101.f572522c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f572523d, r101.f572523d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f572520a * 31) + this.f572521b.hashCode()) * 31) + this.f572522c.hashCode()) * 31) + this.f572523d.hashCode();
    }

    public final String toString() {
        return "LoginOptionsDialogModel(title=" + this.f572520a + ", itemList=" + this.f572521b + ", onShow=" + this.f572522c + ", onDismiss=" + this.f572523d + ')';
    }

    public f(List r100, e0 r101, f0 r102) {
        Intrinsics.checkNotNullParameter(r100, "itemList");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onShow);
        Intrinsics.checkNotNullParameter(r102, "onDismiss");
        this.f572520a = R.string.larus_login_different_method_note;
        this.f572521b = r100;
        this.f572522c = r101;
        this.f572523d = r102;
    }
}
