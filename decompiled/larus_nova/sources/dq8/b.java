package dq8;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import cq8.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f469690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.a f469691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0 f469692c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f469690a, r101.f469690a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f469691b, r101.f469691b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f469692c, r101.f469692c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f469690a.hashCode() * 31) + this.f469691b.hashCode()) * 31) + this.f469692c.hashCode();
    }

    public final String toString() {
        return "ButtonRouterShowHostEvent(widgetId=" + this.f469690a + ", template=" + this.f469691b + ", trackingContext=" + this.f469692c + ')';
    }

    public b(String r100, com.larus.bmhome.actionbar.model.a r101, z0 r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r102, "trackingContext");
        this.f469690a = r100;
        this.f469691b = r101;
        this.f469692c = r102;
    }
}
