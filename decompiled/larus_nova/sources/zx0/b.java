package zx0;

import android.graphics.RectF;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f573868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sx0.a f573869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g90.b f573870c;

    public /* synthetic */ b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f573868a, r101.f573868a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f573869b, r101.f573869b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f573870c, r101.f573870c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        RectF r100 = this.f573868a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        sx0.a r104 = this.f573869b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        g90.b r107 = this.f573870c;
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
        return "LayoutDescriptor(grid=" + this.f573868a + ", visibleAreaRule=" + this.f573869b + ", bussinessData=" + this.f573870c + ")";
    }

    public b(RectF r100, sx0.a r101, g90.b r102) {
        Intrinsics.checkNotNullParameter(r100, GXViewKey.VIEW_TYPE_CONTAINER_GRID);
        Intrinsics.checkNotNullParameter(r101, "visibleAreaRule");
        this.f573868a = r100;
        this.f573869b = r101;
        this.f573870c = r102;
    }
}
