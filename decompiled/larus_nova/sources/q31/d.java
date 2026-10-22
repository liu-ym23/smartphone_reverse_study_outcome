package q31;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.transfer.e;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import k31.f;
import k31.l;
import k31.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m31.b f531492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f531493b;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final boolean a() {
        return false;
    }

    public d() {
        this.f531492a = new m31.b();
        this.f531493b = b03.c.b(134);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.transfer.e
    public final k31.c b(l31.a r100, boolean r101, Boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "param");
        if (r101 == true) goto L5;
    L10:
        int r104 = r100.f507224b;
        Integer r105 = o.a(r104, r100.a());
        if (r105 == null) goto L29;
        int r106 = r105.intValue();
        int r107 = this.f531493b + l.a(r100.f507230h, r100.f507226d);
        k31.a r108 = r100.f507231i;
        int r109 = 0;
        if (r108 == null) goto L15;
        int r110 = k31.b.a(r108);
    L16:
        int r111 = r107 + r110;
        if (r100.f507232j != UILayout.FULL.ordinal()) goto L26;
        b03.a r112 = b03.a.f16857a;
        r106 = s1.w();
        f r113 = r100.f507228f;
        if (r113 == null) goto L25;
        p0 r114 = r113.f501646b;
        if (r114 == null) goto L25;
        q0 r115 = r114.getCanvas();
        if (r115 == null) goto L25;
        r104 = (r115.b() * r106) / r115.a();
    L25:
        int r116 = (r100.f507224b - r104) / 2;
    L28:
        return new k31.c(r104, r106, r109, r116);
    L26:
        r109 = r111;
        r116 = 0;
        goto L28
    L15:
        r110 = 0;
        goto L16
    L29:
        return null;
    L5:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == false) goto L10;
        if (r100.f507224b <= r100.f507225c) goto L10;
        this.f531492a.getClass();
        return m31.b.a(r100);
    }
}
