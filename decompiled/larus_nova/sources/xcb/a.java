package xcb;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, UrlPreviewHangPoint> f563249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, UrlPreviewEntity> f563250b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f563249a, r101.f563249a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f563250b, r101.f563250b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f563249a.hashCode() * 31) + this.f563250b.hashCode();
    }

    public final String toString() {
        return "UrlPreviewEntityPbBundle(hangPointMap=" + this.f563249a + ", previewEntityMap=" + this.f563250b + ')';
    }

    public a(Map<String, UrlPreviewHangPoint> r100, Map<String, UrlPreviewEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "hangPointMap");
        Intrinsics.checkNotNullParameter(r101, "previewEntityMap");
        this.f563249a = r100;
        this.f563250b = r101;
    }
}
