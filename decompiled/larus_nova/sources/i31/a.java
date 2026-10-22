package i31;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PkBaseStateMachine.c f488083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBaseBattleSetting f488084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f488085c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f488083a, r101.f488083a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f488084b, r101.f488084b) == true) goto L10;
        return false;
    L10:
        if (this.f488085c == r101.f488085c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        PkBaseStateMachine.c r100 = this.f488083a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        IBaseBattleSetting r104 = this.f488084b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f488085c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiPkBeforeFinishData(pkStateBeforeFinish=" + this.f488083a + ", battleSetting=" + this.f488084b + ", timestamp=" + this.f488085c + ")";
    }

    public a(PkBaseStateMachine.c r100, IBaseBattleSetting r101) {
        i97.a r102 = i97.a.f488802a;
        long r103 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, "pkStateBeforeFinish");
        this.f488083a = r100;
        this.f488084b = r101;
        this.f488085c = r103;
    }
}
