package ns9;

import com.larus.reach.api.ReachPageScope;
import com.larus.reach.api.ReachPosition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReachPosition f520358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReachPageScope f520359b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f520358a == ((a) r100).f520358a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f520358a.hashCode();
    }

    public final String toString() {
        return "GlobalReachTarget(position=" + this.f520358a + ')';
    }

    @Override // ns9.v
    public final ReachPageScope a() {
        return this.f520359b;
    }

    @Override // ns9.v
    public final ReachPosition b() {
        return this.f520358a;
    }

    public a(ReachPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        this.f520358a = r100;
        this.f520359b = ReachPageScope.Global;
    }

    public /* synthetic */ a(int r100) {
        this(ReachPosition.TOP);
    }
}
