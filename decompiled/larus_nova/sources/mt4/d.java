package mt4;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridSetting;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f515637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f515638b;

    public d() {
        this.f515637a = new ArrayList();
        this.f515638b = new e();
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
        if (this.f515637a.contains(r100) == true) goto L6;
        this.f515637a.add(r100);
        return;
    }

    public final void b(int r100) {
        e r101 = this.f515638b;
        r101.c(r101.f515643e + r100);
        Iterator<b> r102 = this.f515637a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        b r103 = r102.next();
        e r104 = this.f515638b;
        r103.b(r104.f515644f, r104.f515643e, r100, r104.b(), this.f515638b.f515646h);
        goto L4
    }

    public final void c(int r100, GridSetting r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "gridSetting");
        e r103 = this.f515638b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "gridSetting");
        int[] r104 = r101.getForceColWidth();
        if (r104 == null) goto L5;
        r103.update(r104, r100);
    L13:
        if (r102 != (-1)) goto L15;
        r103.c(r101.getInitScrollX(r100));
        return;
    L15:
        r103.c(r102);
        return;
    L5:
        int r105 = r101.getColWidthInDp().length;
        int[] r106 = new int[r105];
        r103.f515645g = r101.getMaxFixedWidth(r100);
        r103.f515646h = r101.getMinFixedWidth(r100);
        int r107 = 0;
    L6:
        if (r107 >= r105) goto L11;
        if (r107 != 0) goto L9;
        int r108 = r101.getMaxFixedWidth(r100);
    L10:
        r106[r107] = r108;
        r107 = r107 + 1;
        goto L6
    L9:
        r108 = r101.getColWidthInDp()[r107];
        goto L10
    L11:
        r103.update(r106, r100);
        goto L13
    }
}
