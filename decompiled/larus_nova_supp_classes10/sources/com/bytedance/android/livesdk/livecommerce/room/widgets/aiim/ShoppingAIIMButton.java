package com.bytedance.android.livesdk.livecommerce.room.widgets.aiim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sg2.v;
import wd.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ShoppingAIIMButton extends ak2.a {
    public static final /* synthetic */ int f = 0;
    public View a;
    public final Lazy b;
    public final Context c;
    public final com.bytedance.android.livesdk.livecommerce.room.controller.business.a d;
    public final String e;

    public static final class a {
    }

    static {
    }

    @Override // ak2.a
    public final View getButtonViewInMore() {
        return null;
    }

    public final String getTargetButtonName() {
        return "COMMERCE_AI_IM";
    }

    @Override // ak2.a
    public final boolean onTriggerAnimation(long r1) {
        return false;
    }

    @Override // ak2.a
    public final void onUnload() {
    }

    @Override // ak2.a
    public final void onViewWillDetach() {
    }

    public final View getView() {
        View r0 = this.a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // ak2.a
    public final void onLoad() {
        View r0 = new View(getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.d(38), UtilityKotlinExtentionsKt.d(38)));
        r0.setBackground(th.a.b(getContext(), 2131248035));
        this.a = r0;
        com.bytedance.android.livesdk.livecommerce.utils.a.a(r0, th.a.g(getContext(), 2131896307));
        f.c(r0, null, null, new ShoppingAIIMButton$onLoad$$inlined$also$lambda$1(this), 3);
    }

    public final void onViewAttachedInner() {
        LiveRoomParams r0 = this.d.A().m.l();
        if (r0 == null) goto L15;
        BtmSDK r1 = BtmSDK.INSTANCE;
        View r2 = this.a;
        Map r3 = null;
        if (r2 == null) goto L7;
        PageFinder r4 = PageFinder.via(r2);
    L8:
        String r5 = r1.getPageId(r4);
        JSONObject r6 = (JSONObject) this.b.getValue();
        if (r6 == null) goto L13;
        JSONObject r7 = r6.optJSONObject("track_param");
        if (r7 == null) goto L13;
        r3 = z1.j(r7);
    L13:
        v r8 = new v("format_entrance_show", r0);
        r8.c("enter_from", "live_detail");
        r8.c("enter_method", "live_toolbar_icon");
        r8.c("is_ecom_live", "1");
        r8.c("live_room_id", r0.getRoomId());
        r8.d(r3);
        r8.j("c9398.d101095", r5);
        v r9 = new v("livesdk_ecom_ai_im_entrance_show", r0);
        r9.d(r3);
        r9.e(r5);
        r9.j("c9398.d101095", r5);
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // ak2.a
    public Context getContext() {
        return this.c;
    }

    @Override // ak2.a
    public final View getRealView() {
        return this.a;
    }

    public final void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        onViewAttachedInner();
    }

    @Override // ak2.a
    public final void setRealView(View r1) {
        this.a = r1;
    }

    public final void onViewAttached(c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        onViewAttachedInner();
    }

    public ShoppingAIIMButton(Context r2, com.bytedance.android.livesdk.livecommerce.room.controller.business.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "controller");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.b = LazyKt.lazy(new ShoppingAIIMButton$componentExtraObj$2(this));
    }
}
