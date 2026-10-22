package eb9;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f471898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f471899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f471900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f471901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f471902e;

    public m() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f471898a, r101.f471898a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471899b, r101.f471899b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f471900c, r101.f471900c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f471901d, r101.f471901d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f471902e, r101.f471902e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f471898a.hashCode() * 31) + this.f471899b.hashCode()) * 31) + this.f471900c.hashCode()) * 31) + this.f471901d.hashCode()) * 31) + this.f471902e.hashCode();
    }

    public final String toString() {
        return "FlowFeedHostContext(host=" + this.f471898a + ", recyclerView=" + this.f471899b + ", config=" + this.f471900c + ", callback=" + this.f471901d + ", ext=" + this.f471902e + ')';
    }

    public m(Fragment r100, RecyclerView r101, l r102, y r103) {
        Map<String, Object> r104 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r104, "ext");
        this.f471898a = r100;
        this.f471899b = r101;
        this.f471900c = r102;
        this.f471901d = r103;
        this.f471902e = r104;
    }
}
