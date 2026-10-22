package t48;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f544600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f544601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f544602c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f544600a == r101.f544600a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544601b, r101.f544601b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544602c, r101.f544602c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f544600a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f544601b.hashCode()) * 31) + this.f544602c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "AboutAppHostConfig(isOversea=" + this.f544600a + ", itemLinkMap=" + this.f544601b + ", disabledActionItems=" + this.f544602c + ')';
    }

    public /* synthetic */ a(int r100) {
        this(false, MapsKt.emptyMap(), SetsKt.emptySet());
    }

    public a(boolean r100, Map<String, String> r101, Set<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "itemLinkMap");
        Intrinsics.checkNotNullParameter(r102, "disabledActionItems");
        this.f544600a = r100;
        this.f544601b = r101;
        this.f544602c = r102;
    }
}
