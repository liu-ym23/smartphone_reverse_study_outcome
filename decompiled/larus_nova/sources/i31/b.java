package i31;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseBattleSetting f488086a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f488086a, ((b) r100).f488086a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        IBaseBattleSetting r100 = this.f488086a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "MultiPkFinishEvent(battleSetting=" + this.f488086a + ")";
    }

    public b(IBaseBattleSetting r100) {
        this.f488086a = r100;
    }
}
