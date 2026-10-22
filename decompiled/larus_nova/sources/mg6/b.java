package mg6;

import com.bytedance.live.bizlink.api.platform.status.event.StatusEventCategory;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StatusEventCategory f513737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f513738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Object> f513739c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f513737a, r101.f513737a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f513738b, r101.f513738b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f513739c, r101.f513739c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        StatusEventCategory r100 = this.f513737a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c r104 = this.f513738b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, Object> r107 = this.f513739c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StatusEvent(eventCategory=" + this.f513737a + ", eventType=" + this.f513738b + ", eventInfo=" + this.f513739c + ")";
    }

    public b(StatusEventCategory r100, c r101, HashMap<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventCategory");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        this.f513737a = r100;
        this.f513738b = r101;
        this.f513739c = r102;
    }
}
