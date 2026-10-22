package ga9;

import com.larus.flowsdk.common.experiment.FlowABValueType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowABValueType f480603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f480604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f480605e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f480601a, r101.f480601a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f480602b, r101.f480602b) == true) goto L15;
        return false;
    L15:
        if (this.f480603c == r101.f480603c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f480604d, r101.f480604d) == true) goto L21;
        return false;
    L21:
        if (this.f480605e == r101.f480605e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f480601a.hashCode() * 31) + this.f480602b.hashCode()) * 31) + this.f480603c.hashCode()) * 31;
        T r101 = this.f480604d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f480605e == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowExperimentRegisterInfo(key=" + this.f480601a + ", owner=" + this.f480602b + ", valueType=" + this.f480603c + ", defaultValue=" + this.f480604d + ", stable=" + this.f480605e + ')';
    }

    public f(String r100, String r101, FlowABValueType r102, T r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r102, "valueType");
        this.f480601a = r100;
        this.f480602b = r101;
        this.f480603c = r102;
        this.f480604d = r103;
        this.f480605e = r104;
    }
}
