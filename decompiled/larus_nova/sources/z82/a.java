package z82;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.e5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f570890a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f570890a, ((a) r100).f570890a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        c r100 = this.f570890a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "pkProgressBarOption = " + this.f570890a;
    }

    public static int a() {
        if (e5.n() == false) goto L6;
        return 0;
    L6:
        return UtilityKotlinExtentionsKt.i(16);
    }

    public a(c r100) {
        this.f570890a = r100;
    }
}
