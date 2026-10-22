package ak2;

import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCoupon;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCouponV2;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ShoppingCart;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.StartLivePreviewButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements com.bytedance.android.livesdk.livecommerce.room.api.e {
    public final Object a;

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void B() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void I(com.bytedance.android.livesdk.livecommerce.room.controller.business.q.b r2) {
        Intrinsics.checkNotNullParameter(r2, "loadFilter");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void J(com.bytedance.android.livesdk.livecommerce.room.controller.business.a.d r2) {
        Intrinsics.checkNotNullParameter(r2, "loadFilter");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final g F() {
        xd.g r0 = xd.g.a;
        Intrinsics.checkNotNullParameter(r0, "id");
        Object r1 = this.a;
        if ((r1 instanceof td.d) == false) goto L7;
        return new g(((td.d) r1).F());
    L7:
        if ((r1 instanceof ILiveRoomViewHandler) == false) goto L11;
        Intrinsics.checkNotNullParameter(r0, "$this$live");
        return new g(((ILiveRoomViewHandler) r1).findViewGroupById(StartLivePreviewButton.INSTANCE));
    L11:
        throw new IllegalArgumentException("handler is not IECLiveRoomViewHandler or ILiveRoomViewHandler");
    }

    public j(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void C(ShoppingCart r4) {
        xd.i r0 = xd.i.a;
        Intrinsics.checkNotNullParameter(r4, "button");
        Intrinsics.checkNotNullParameter(r0, "constraint");
        Object r1 = this.a;
        if ((r1 instanceof td.d) == false) goto L6;
        ((td.d) r1).C(r4);
        return;
    L6:
        if ((r1 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r1).removeToolbarButton(r4, ControllerExtensionsKt.a(r0));
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void D(EntryController.k r3) {
        Intrinsics.checkNotNullParameter(r3, "loadFilter");
        Object r0 = this.a;
        if ((r0 instanceof td.d) == false) goto L6;
        ((td.d) r0).D(r3);
        return;
    L6:
        if ((r0 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r0).registerToolbarLoadFilter(NewToolbarButtonConstants.CommerceCart.INSTANCE, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void E(ShoppingCart r4) {
        xd.i r0 = xd.i.a;
        Intrinsics.checkNotNullParameter(r4, "button");
        Intrinsics.checkNotNullParameter(r0, "constraint");
        Object r1 = this.a;
        if ((r1 instanceof td.d) == false) goto L6;
        ((td.d) r1).E(r4);
        return;
    L6:
        if ((r1 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r1).provideToolbarButton(r4, ControllerExtensionsKt.a(r0));
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void G(EntryController.j r3) {
        Intrinsics.checkNotNullParameter(r3, "viewProvider");
        Object r0 = this.a;
        if ((r0 instanceof td.d) == false) goto L6;
        ((td.d) r0).G(r3);
        return;
    L6:
        if ((r0 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r0).registerToolbarButtonView(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void H(ShortTouchLynxCoupon r3) {
        Intrinsics.checkNotNullParameter(r3, "iconModel");
        Object r0 = this.a;
        if ((r0 instanceof td.d) == false) goto L6;
        ((td.d) r0).H(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void K(q r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        Object r0 = this.a;
        if ((r0 instanceof td.d) == false) goto L6;
        ((td.d) r0).c(r3);
        return;
    L6:
        if ((r0 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r0).requestDismiss(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void M(q r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Object r3 = this.a;
        if ((r3 instanceof td.d) == true) goto L7;
        boolean r4 = r3 instanceof ILiveRoomViewHandler;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void N(ShortTouchLynxCouponV2 r3) {
        Intrinsics.checkNotNullParameter(r3, "iconModel");
        Object r0 = this.a;
        if ((r0 instanceof ILiveRoomViewHandler) == false) goto L6;
        ((ILiveRoomViewHandler) r0).loadIconModel(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void O(q r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        Object r0 = this.a;
        if ((r0 instanceof td.d) == false) goto L6;
        ((td.d) r0).a(r3);
        return;
    L6:
        if ((r0 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r0).requestShow(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void L(q r3, xd.k r4) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        Intrinsics.checkNotNullParameter(r4, "constraint");
        Object r0 = this.a;
        if ((r0 instanceof td.d) == false) goto L6;
        ((td.d) r0).b(r3, r4);
        return;
    L6:
        if ((r0 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r0).provideWidget(r3, ControllerExtensionsKt.a(r4));
        return;
    }
}
