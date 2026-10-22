package zj9;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.account.base.model.LoginPlatform;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f572524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LoginPlatform f572525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f572526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f572527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f572528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f572529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f572530g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f572524a, r101.f572524a) == true) goto L12;
        return false;
    L12:
        if (this.f572525b == r101.f572525b) goto L15;
        return false;
    L15:
        if (this.f572526c == r101.f572526c) goto L18;
        return false;
    L18:
        if (this.f572527d == r101.f572527d) goto L21;
        return false;
    L21:
        if (this.f572528e == r101.f572528e) goto L24;
        return false;
    L24:
        if (this.f572529f == r101.f572529f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f572530g, r101.f572530g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f572524a.hashCode() * 31) + this.f572525b.hashCode()) * 31) + this.f572526c) * 31) + this.f572527d) * 31) + this.f572528e) * 31) + this.f572529f) * 31) + this.f572530g.hashCode();
    }

    public final String toString() {
        return "LoginOptionsItemModel(channel=" + this.f572524a + ", loginPlatform=" + this.f572525b + ", iconRes=" + this.f572526c + ", textRes=" + this.f572527d + ", textColorRes=" + this.f572528e + ", buttonBgRes=" + this.f572529f + ", onClick=" + this.f572530g + ')';
    }

    public g(String r100, LoginPlatform r101, int r102, int r103, int r104, int r105, Function0<Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "loginPlatform");
        Intrinsics.checkNotNullParameter(r106, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f572524a = r100;
        this.f572525b = r101;
        this.f572526c = r102;
        this.f572527d = r103;
        this.f572528e = r104;
        this.f572529f = r105;
        this.f572530g = r106;
    }
}
