package nh0;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.TrackerUpdateType;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrackerUpdateType f519153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<String, String>> f519154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f519155c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L12;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f519153a, r101.f519153a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f519154b, r101.f519154b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f519155c, r101.f519155c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        TrackerUpdateType r100 = this.f519153a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Map<String, String>> r104 = this.f519154b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f519155c;
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
        return "TrackerExtraObject(type=" + this.f519153a + ", addExtra=" + this.f519154b + ", removeExtra=" + this.f519155c + ")";
    }

    public final TrackerUpdateType getType() {
        return this.f519153a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(TrackerUpdateType r100, Map<String, ? extends Map<String, String>> r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f519153a = r100;
        this.f519154b = r101;
        this.f519155c = r102;
    }
}
