package re;

import com.bytedance.android.ec.adapter.impl.converter.j;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCoupon;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ShoppingCart;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.StartLivePreviewButton;
import kotlin.jvm.internal.Intrinsics;
import wd.f;
import xd.g;
import xd.i;
import xd.k;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements td.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveRoomViewHandler f537398a;

    @Override // td.d
    public final f F() {
        g r100 = g.f563267a;
        Intrinsics.checkNotNullParameter(r100, "id");
        ILiveRoomViewHandler r101 = this.f537398a;
        Intrinsics.checkNotNullParameter(r100, "$this$live");
        IExternalViewGroup r102 = r101.findViewGroupById(StartLivePreviewButton.INSTANCE);
        Intrinsics.checkNotNullParameter(r102, "$this$convert2EC");
        return j.f42786b.a(r102);
    }

    public d(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "realHandler");
        this.f537398a = r100;
    }

    @Override // td.d
    public final void C(ShoppingCart r100) {
        i r101 = i.f563269a;
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r101, "constraint");
        this.f537398a.removeToolbarButton(com.bytedance.android.ec.adapter.impl.converter.b.a(r100), com.bytedance.android.ec.adapter.impl.utils.c.a(r101));
    }

    @Override // td.d
    public final void D(EntryController.k r100) {
        Intrinsics.checkNotNullParameter(r100, "loadFilter");
        ILiveRoomViewHandler r101 = this.f537398a;
        NewToolbarButtonConstants.CommerceCart r102 = NewToolbarButtonConstants.CommerceCart.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Live");
        r101.registerToolbarLoadFilter(r102, com.bytedance.android.ec.adapter.impl.converter.c.j.f42779b.a(r100));
    }

    @Override // td.d
    public final void E(ShoppingCart r100) {
        i r101 = i.f563269a;
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r101, "constraint");
        this.f537398a.provideToolbarButton(com.bytedance.android.ec.adapter.impl.converter.b.a(r100), com.bytedance.android.ec.adapter.impl.utils.c.a(r101));
    }

    @Override // td.d
    public final void G(EntryController.j r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        this.f537398a.registerToolbarButtonView(com.bytedance.android.ec.adapter.impl.converter.b.a(r100));
    }

    @Override // td.d
    public final void H(ShortTouchLynxCoupon r100) {
        Intrinsics.checkNotNullParameter(r100, "iconModel");
        ILiveRoomViewHandler r101 = this.f537398a;
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Live");
        r101.loadIconModel(new com.bytedance.android.ec.adapter.impl.converter.c.e().a(r100));
    }

    @Override // td.d
    public final void a(wd.g r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f537398a.requestShow(com.bytedance.android.ec.adapter.impl.converter.b.b(r100));
        ECLiveEntranceMonitor.trace$default("requestShow: ".concat(r100.getClass().getName()), "LiveRoomViewHandlerAdapter", false, 4, null);
    }

    @Override // td.d
    public final void c(wd.g r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f537398a.requestDismiss(com.bytedance.android.ec.adapter.impl.converter.b.b(r100));
    }

    @Override // td.d
    public final void b(wd.g r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "constraint");
        this.f537398a.provideWidget(com.bytedance.android.ec.adapter.impl.converter.b.b(r100), com.bytedance.android.ec.adapter.impl.utils.c.a(r101));
        ECLiveEntranceMonitor.trace$default("provideWidget: ".concat(r100.getClass().getName()), "LiveRoomViewHandlerAdapter", false, 4, null);
    }
}
