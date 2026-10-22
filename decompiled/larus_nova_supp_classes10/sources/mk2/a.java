package mk2;

import ak2.b;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.IECWidgetType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.room.api.e;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.f;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wd.c;
import xd.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends b implements f, IECWidgetType, IWidgetType {
    public final QUIManager a;
    public final e b;

    public final View getView() {
        return this.a.p();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.f
    public final void load() {
        this.b.L(this, j.a);
        this.b.O(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.f
    public final void onDestroy() {
        this.b.K(this);
        this.a.r(nk2.a.class);
    }

    @Override // ak2.b
    public final void onLoad() {
        this.a.c(nk2.a.class, null);
    }

    @Override // ak2.b
    public final void onUnload() {
        this.a.r(nk2.a.class);
    }

    @Override // ak2.b
    public final void onViewDetached() {
        int r0 = ph.b.a;
        ph.b.a(getView(), false);
    }

    public final IWidgetType.ExternalWidgetType getWidgetType() {
        return IWidgetType.ExternalWidgetType.ECOMMERCE_SIZE_COMPONENTS;
    }

    public final IECWidgetType.ECExternalWidgetType j() {
        return IECWidgetType.ECExternalWidgetType.ECOMMERCE_SIZE_COMPONENTS;
    }

    @Override // ak2.b
    public final void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        int r3 = ph.b.a;
        ph.b.a(getView(), true);
    }

    @Override // ak2.b
    public final void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        gk2.a.a(getView());
    }

    @Override // ak2.b
    public final void onViewAttached(c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        int r3 = ph.b.a;
        ph.b.a(getView(), true);
    }

    @Override // ak2.b
    public final void onViewWillAttach(c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        gk2.a.a(getView());
    }

    public a(Context r2, e r3, LiveRoomParams r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "iLiveRoomViewHandler");
        this.b = r3;
        QUIManager r5 = new QUIManager();
        r5.l(new nk2.a(r4), r2, true);
        Unit r6 = Unit.INSTANCE;
        this.a = r5;
    }
}
