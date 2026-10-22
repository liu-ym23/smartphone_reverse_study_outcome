package hn6;

import com.bytedance.locallife.biz.btm.btm_checker.interfaces.CheckType;
import com.ss.android.ugc.aweme.etkit.TrackModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrackModel f486112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CheckType f486113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f486114c;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f486112a, r101.f486112a) == true) goto L12;
        return false;
    L12:
        if (this.f486113b == r101.f486113b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486114c, r101.f486114c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f486112a.hashCode() * 31) + this.f486113b.hashCode()) * 31;
        Map<String, Object> r101 = this.f486114c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CheckReq(trackModel=" + this.f486112a + ", checkType=" + this.f486113b + ", extra=" + this.f486114c + ')';
    }

    public b(TrackModel r100, CheckType r101) {
        Intrinsics.checkNotNullParameter(r100, "trackModel");
        Intrinsics.checkNotNullParameter(r101, "checkType");
        this.f486112a = r100;
        this.f486113b = r101;
        this.f486114c = null;
    }
}
