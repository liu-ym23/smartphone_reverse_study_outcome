package tb9;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.home.impl.main.side_bar.feed.SideBarFeedCardType;
import com.larus.home.impl.main.side_bar.feed.cell.m;
import eb9.p;
import eb9.v;
import eb9.w;
import eb9.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f545295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SideBarFeedCardType f545296b;

    @Override // eb9.w
    public final p c() {
        return null;
    }

    @Override // eb9.w
    public final x b() {
        return new com.larus.home.impl.main.side_bar.feed.cell.h(this.f545295a);
    }

    @Override // eb9.w
    public final v a() {
        return eb9.a.f471852a;
    }

    @Override // eb9.w
    public final SideBarFeedCardType getCardType() {
        return this.f545296b;
    }

    public c(m r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f545295a = r100;
        this.f545296b = SideBarFeedCardType.PROJECT_CONVERSATION_TITLE;
    }
}
