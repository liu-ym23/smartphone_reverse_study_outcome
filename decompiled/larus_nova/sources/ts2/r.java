package ts2;

import com.bytedance.android.livesdk.room.state.WidgetLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WidgetLevel f547362a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f547362a, ((r) r100).f547362a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        WidgetLevel r100 = this.f547362a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "RoomWidgetLoadLevelData(level=" + this.f547362a + ")";
    }

    public final WidgetLevel a() {
        return this.f547362a;
    }

    public r(WidgetLevel r100) {
        Intrinsics.checkNotNullParameter(r100, "level");
        this.f547362a = r100;
    }
}
