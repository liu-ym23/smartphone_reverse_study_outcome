package ut6;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f551651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f551652c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f551650a, r101.f551650a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f551651b, r101.f551651b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f551652c, r101.f551652c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f551650a.hashCode() * 31) + this.f551651b.hashCode()) * 31) + this.f551652c.hashCode();
    }

    public final String toString() {
        return "OptStrategyPreCacheModel(page=" + this.f551650a + ", name=" + this.f551651b + ", strategy=" + this.f551652c + ')';
    }

    public i(String r100, String r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f551650a = r100;
        this.f551651b = r101;
        this.f551652c = r102;
    }
}
