package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class StartedWhileSubscribed implements g1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f504826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f504827c;

    public final String toString() {
        List r100 = CollectionsKt.createListBuilder(2);
        if (this.f504826b <= 0) goto L6;
        r100.add("stopTimeout=" + this.f504826b + "ms");
    L6:
        if (this.f504827c >= Long.MAX_VALUE) goto L9;
        r100.add("replayExpiration=" + this.f504827c + "ms");
    L9:
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default(CollectionsKt.build(r100), null, null, null, 0, null, null, 63, null) + ')';
    }

    public final int hashCode() {
        long r100 = this.f504826b;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f504827c;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    @Override // kotlinx.coroutines.flow.g1
    public final Flow<SharingCommand> a(i1<Integer> r100) {
        return e.n(new w(e.G(r100, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof StartedWhileSubscribed) == false) goto L9;
        StartedWhileSubscribed r101 = (StartedWhileSubscribed) r100;
        if (this.f504826b != r101.f504826b) goto L9;
        if (this.f504827c != r101.f504827c) goto L9;
        return true;
    L9:
        return false;
    }

    public StartedWhileSubscribed(long r100, long r101) {
        this.f504826b = r100;
        this.f504827c = r101;
        boolean r102 = true;
        if (r100 < 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L17;
        if (r101 >= 0) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException(("replayExpiration(" + r101 + " ms) cannot be negative").toString());
    L17:
        throw new IllegalArgumentException(("stopTimeout(" + r100 + " ms) cannot be negative").toString());
    L5:
        r103 = false;
        goto L7
    }
}
