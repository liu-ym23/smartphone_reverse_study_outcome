package t39;

import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.IDoraService$Debug$ResourceConfigSyncStatus;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDoraService$Debug$ResourceConfigSyncStatus f544477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<DoraEnableScope> f544478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<DoraEnableScope> f544479c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f544477a == r101.f544477a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544478b, r101.f544478b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544479c, r101.f544479c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f544477a.hashCode() * 31) + this.f544478b.hashCode()) * 31) + this.f544479c.hashCode();
    }

    public final String toString() {
        return "ResourceConfigSyncResult(status=" + this.f544477a + ", updatedScopes=" + this.f544478b + ", skippedScopes=" + this.f544479c + ')';
    }

    public /* synthetic */ p(IDoraService$Debug$ResourceConfigSyncStatus r100) {
        this(r100, SetsKt.emptySet(), SetsKt.emptySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(IDoraService$Debug$ResourceConfigSyncStatus r100, Set<? extends DoraEnableScope> r101, Set<? extends DoraEnableScope> r102) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "updatedScopes");
        Intrinsics.checkNotNullParameter(r102, "skippedScopes");
        this.f544477a = r100;
        this.f544478b = r101;
        this.f544479c = r102;
    }
}
