package yn1;

import com.bytedance.android.livesdk.message.model.kj;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends o70.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kj f568521a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f568521a, ((e) r100).f568521a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        kj r100 = this.f568521a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "RemindMessageEvent(remindMessage=" + this.f568521a + ")";
    }

    public e(kj r100) {
        Intrinsics.checkNotNullParameter(r100, "remindMessage");
        this.f568521a = r100;
    }
}
