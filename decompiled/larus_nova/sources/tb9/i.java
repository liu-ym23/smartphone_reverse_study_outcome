package tb9;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.home.impl.main.side_bar.data.j0;
import com.larus.home.impl.main.side_bar.feed.SideBarFeedCardType;
import com.larus.home.impl.main.side_bar.feed.cell.q;
import eb9.p;
import eb9.v;
import eb9.w;
import eb9.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i implements w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SideBarFeedCardType f545324d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Integer, j0, Unit> f545325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Integer, j0, Unit> f545326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SideBarFeedCardType f545327c;

    public static final class a {
    }

    @Override // eb9.w
    public final p c() {
        return null;
    }

    static {
        f545324d = SideBarFeedCardType.SHOW_ALL;
    }

    @Override // eb9.w
    public final x b() {
        return new q(this.f545325a, this.f545326b);
    }

    @Override // eb9.w
    public final v a() {
        return eb9.a.f471852a;
    }

    @Override // eb9.w
    public final SideBarFeedCardType getCardType() {
        return this.f545327c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function2<? super Integer, ? super j0, Unit> r100, Function2<? super Integer, ? super j0, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r101, "onItemShown");
        this.f545325a = r100;
        this.f545326b = r101;
        this.f545327c = f545324d;
    }
}
