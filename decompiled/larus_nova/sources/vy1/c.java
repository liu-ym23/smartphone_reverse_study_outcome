package vy1;

import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentState;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.RegionId;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements ry1.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<? extends RegionId, j80.d> f557558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pair<? extends RegionId, j80.d> f557559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f557560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ GroupComponentState.Style f557561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f557562e;

    @Override // ry1.a.b
    public final void a(Pair<? extends RegionId, j80.d> r110) {
        this.f557559b = r110;
        Pair<? extends RegionId, j80.d> r111 = this.f557558a;
        ty1.c r100 = null;
        if (r111 == null) goto L5;
        RegionId r112 = r111.getFirst();
    L6:
        Pair<? extends RegionId, j80.d> r101 = this.f557559b;
        if (r101 == null) goto L9;
        RegionId r102 = r101.getFirst();
    L11:
        if (r112 != r102) goto L24;
        Pair<? extends RegionId, j80.d> r113 = this.f557558a;
        if (r113 == null) goto L15;
        j80.d r114 = r113.getSecond();
    L16:
        Pair<? extends RegionId, j80.d> r103 = this.f557559b;
        if (r103 == null) goto L19;
        j80.d r104 = r103.getSecond();
    L21:
        if ((!Intrinsics.areEqual(r114, r104)) == true) goto L24;
        boolean r115 = false;
    L25:
        if (r115 == false) goto L45;
        a r116 = this.f557560c;
        GroupComponentState.Style r105 = this.f557561d;
        int r106 = this.f557562e;
        FrameLayout r107 = r116.f557541k;
        if (r107 != null) goto L30;
    L41:
        if (r100 != null) goto L43;
        return;
    L43:
        this.f557560c.o(new com.bytedance.android.livesdk.gift.grouplive.component.b(r100, true));
        return;
    L30:
        if (r107.getWidth() == 0) goto L41;
        if (r107.getHeight() == 0) goto L41;
        if (r107.getVisibility() != 0) goto L41;
        float r108 = r107.getWidth();
        float r109 = r107.getHeight() / r108;
        float r117 = r108 / r116.q();
        float r118 = (r109 * r117) * 0.46182266f;
        if (r105 != GroupComponentState.Style.HORIZONTAL) goto L39;
        float r119 = r107.getY();
        int r120 = r116.f557538h.getHeight() - r106;
    L40:
        float r121 = r119 / r120;
        float r122 = r107.getX() / r116.f557538h.getWidth();
        float r123 = (r107.getY() + r107.getHeight()) / r116.f557538h.getHeight();
        float r124 = (r107.getX() + r107.getWidth()) / r116.f557538h.getWidth();
        ty1.c r125 = new ty1.c(0);
        r125.j(j80.a.a(r121, 4));
        r125.h(j80.a.a(r122, 4));
        r125.i(j80.a.a(r124, 4));
        r125.f(j80.a.a(r123, 4));
        r125.k(j80.a.a(r117, 4));
        r125.g(j80.a.a(r118, 4));
        r100 = r125;
        goto L41
    L39:
        r119 = r107.getY();
        r120 = r116.f557538h.getHeight();
        goto L40
    L45:
        return;
    L19:
        r104 = null;
        goto L21
    L15:
        r114 = null;
    L24:
        r115 = true;
        goto L25
    L9:
        r102 = null;
        goto L11
    L5:
        r112 = null;
        goto L6
    }

    @Override // ry1.a.b
    public final void b(Pair<? extends RegionId, j80.d> r100) {
        this.f557558a = r100;
        a r101 = this.f557560c;
        r101.s(r101.f557540j.getWidth());
    }

    @Override // ry1.a.b
    public final void c(RegionId r100) {
        Intrinsics.checkNotNullParameter(r100, "currentRegion");
        a r101 = this.f557560c;
        r101.r(r100, r101.f557540j.getWidth());
    }

    public c(a r100, GroupComponentState.Style r101, int r102) {
        this.f557560c = r100;
        this.f557561d = r101;
        this.f557562e = r102;
    }
}
