package te6;

import com.bytedance.lark.sdk.refactor.observer.ExecuteType;
import com.bytedance.lark.sdk.refactor.state.StateUpdateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateUpdateType f545577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecuteType f545578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f545579c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f545577a == r101.f545577a) goto L12;
        return false;
    L12:
        if (this.f545578b == r101.f545578b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f545579c, r101.f545579c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f545577a.hashCode() * 31) + this.f545578b.hashCode()) * 31;
        String r101 = this.f545579c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ExecuteMethodEvent(eventType=" + this.f545577a + ", executeType=" + this.f545578b + ", contextId=" + this.f545579c + ')';
    }

    public a(StateUpdateType r100, ExecuteType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "executeType");
        this.f545577a = r100;
        this.f545578b = r101;
        this.f545579c = r102;
    }
}
