package zz;

import com.bytedance.android.live.broadcast.api.framework.common.LiveAVResourceIntent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveAVResourceRole;
import com.bytedance.android.live.broadcast.api.framework.common.LiveAVResourceType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveAVResourceType f574008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveAVResourceIntent f574009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveAVResourceRole f574010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f574011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f574012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f574013f;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f574008a, r101.f574008a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f574009b, r101.f574009b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f574010c, r101.f574010c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f574011d, r101.f574011d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f574012e, r101.f574012e) == true) goto L16;
        return false;
    L16:
        if (this.f574013f == r101.f574013f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        LiveAVResourceType r100 = this.f574008a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LiveAVResourceIntent r104 = this.f574009b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LiveAVResourceRole r107 = this.f574010c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f574011d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.f574012e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.f574013f;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return r114 + r116;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveAVResourceRequest(resourceType=" + this.f574008a + ", intent=" + this.f574009b + ", role=" + this.f574010c + ", source=" + this.f574011d + ", params=" + this.f574012e + ", needAction=" + this.f574013f + ')';
    }

    public a(LiveAVResourceType r100, LiveAVResourceIntent r101, LiveAVResourceRole r102, String r103, Map r104) {
        Intrinsics.checkNotNullParameter(r100, "resourceType");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r102, "role");
        Intrinsics.checkNotNullParameter(r103, "source");
        this.f574008a = r100;
        this.f574009b = r101;
        this.f574010c = r102;
        this.f574011d = r103;
        this.f574012e = r104;
        this.f574013f = true;
    }
}
