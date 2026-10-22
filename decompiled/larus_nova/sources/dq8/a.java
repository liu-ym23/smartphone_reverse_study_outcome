package dq8;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import cq8.z;
import cq8.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f469685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.a f469686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f469687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z0 f469688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f469689e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f469685a, r101.f469685a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f469686b, r101.f469686b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f469687c, r101.f469687c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f469688d, r101.f469688d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f469689e, r101.f469689e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f469685a.hashCode() * 31) + this.f469686b.hashCode()) * 31;
        String r101 = this.f469687c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f469688d.hashCode()) * 31) + this.f469689e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ButtonRouterClickHostEvent(widgetId=" + this.f469685a + ", template=" + this.f469686b + ", selectedId=" + this.f469687c + ", trackingContext=" + this.f469688d + ", actionChannel=" + this.f469689e + ')';
    }

    public a(String r100, com.larus.bmhome.actionbar.model.a r101, String r102, z0 r103, com.larus.bmhome.instruction.core.impl.base.b.C4081b r104) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r103, "trackingContext");
        Intrinsics.checkNotNullParameter(r104, "actionChannel");
        this.f469685a = r100;
        this.f469686b = r101;
        this.f469687c = r102;
        this.f469688d = r103;
        this.f469689e = r104;
    }
}
