package tb9;

import com.larus.home.impl.main.side_bar.feed.SideBarFeedCardType;
import com.larus.home.impl.main.side_bar.view.group.render.l;
import eb9.p;
import eb9.v;
import eb9.w;
import eb9.x;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SideBarFeedCardType f545288g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb9.c f545289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<List<eb9.d>> f545290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<l, Unit> f545291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f545292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<l, Unit> f545293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SideBarFeedCardType f545294f;

    public static final class a {
    }

    @Override // eb9.w
    public final p c() {
        return null;
    }

    static {
        f545288g = SideBarFeedCardType.DATE_HEADER;
    }

    @Override // eb9.w
    public final x b() {
        return new com.larus.home.impl.main.side_bar.feed.cell.f(this.f545289a, this.f545290b, this.f545291c, this.f545292d, this.f545293e);
    }

    @Override // eb9.w
    public final v a() {
        return eb9.a.f471852a;
    }

    @Override // eb9.w
    public final SideBarFeedCardType getCardType() {
        return this.f545294f;
    }

    public b(fb9.c r100, Function0 r101, Function1 r102, Function0 r103, com.larus.home.impl.main.side_bar.view.group.render.e r104) {
        Intrinsics.checkNotNullParameter(r100, "actionAbility");
        Intrinsics.checkNotNullParameter(r101, "actionItems");
        Intrinsics.checkNotNullParameter(r102, "onToggle");
        Intrinsics.checkNotNullParameter(r103, "onActionMenuShow");
        Intrinsics.checkNotNullParameter(r104, "onShown");
        this.f545289a = r100;
        this.f545290b = r101;
        this.f545291c = r102;
        this.f545292d = r103;
        this.f545293e = r104;
        this.f545294f = f545288g;
    }
}
