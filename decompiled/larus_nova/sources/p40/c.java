package p40;

import com.bytedance.android.live.componentsmarket.api.draggable.DraggableComponentState;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.RegionId;
import k40.g;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements q40.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<? extends RegionId, g> f527639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pair<? extends RegionId, g> f527640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f527641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DraggableComponentState.Style f527642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f527643e;

    @Override // q40.a.b
    public final void a(Pair<? extends RegionId, g> r100) {
        this.f527640b = r100;
        Pair<? extends RegionId, g> r101 = this.f527639a;
        g r102 = null;
        if (r101 == null) goto L5;
        RegionId r103 = r101.getFirst();
    L6:
        Pair<? extends RegionId, g> r104 = this.f527640b;
        if (r104 == null) goto L9;
        RegionId r105 = r104.getFirst();
    L10:
        boolean r106 = true;
        if (r103 != r105) goto L23;
        Pair<? extends RegionId, g> r107 = this.f527639a;
        if (r107 == null) goto L15;
        g r108 = r107.getSecond();
    L16:
        Pair<? extends RegionId, g> r109 = this.f527640b;
        if (r109 == null) goto L20;
        r102 = r109.getSecond();
    L20:
        if ((!Intrinsics.areEqual(r108, r102)) == true) goto L23;
        r106 = false;
        goto L23
    L15:
        r108 = null;
    L23:
        if (r106 == false) goto L29;
        l40.a r110 = this.f527641c.q(this.f527642d, this.f527643e);
        if (r110 != null) goto L27;
        return;
    L27:
        this.f527641c.o(new k40.b(r110));
        return;
    L29:
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // q40.a.b
    public final void b(Pair<? extends RegionId, g> r100) {
        this.f527639a = r100;
        a r101 = this.f527641c;
        r101.t(r101.f527624j.getWidth());
    }

    @Override // q40.a.b
    public final void c(RegionId r100) {
        Intrinsics.checkNotNullParameter(r100, "currentRegion");
        a r101 = this.f527641c;
        r101.s(r100, r101.f527624j.getWidth());
    }

    public c(a r100, DraggableComponentState.Style r101, int r102) {
        this.f527641c = r100;
        this.f527642d = r101;
        this.f527643e = r102;
    }
}
