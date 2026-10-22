package wk9;

import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f560137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f560138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f560139c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f560137a, r101.f560137a) == true) goto L12;
        return false;
    L12:
        if (this.f560138b == r101.f560138b) goto L15;
        return false;
    L15:
        if (this.f560139c == r101.f560139c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f560137a.hashCode() * 31) + this.f560138b) * 31) + this.f560139c;
    }

    public final String toString() {
        return "MinorConfigModel(configs=" + this.f560137a + ", showTipsType=" + this.f560138b + ", maxShowTipsCounts=" + this.f560139c + ')';
    }

    public a(List<String> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        this.f560137a = r100;
        this.f560138b = r101;
        this.f560139c = r102;
    }
}
