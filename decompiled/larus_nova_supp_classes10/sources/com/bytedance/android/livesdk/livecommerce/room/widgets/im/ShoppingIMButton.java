package com.bytedance.android.livesdk.livecommerce.room.widgets.im;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.common.util.UriUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wd.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ShoppingIMButton extends ak2.a {
    public View a;
    public final Lazy b;
    public final Context c;
    public final Function0<Unit> d;
    public final Function1<JSONObject, Unit> e;
    public final String f;

    public static final class a {
    }

    static {
    }

    @Override // ak2.a
    public final View getButtonViewInMore() {
        return null;
    }

    public final String getTargetButtonName() {
        return "COMMERCE_IM";
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
        ECDraweeView r6 = new ECDraweeView(getContext(), null, 0, 6, null);
        r6.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.d(38), UtilityKotlinExtentionsKt.d(38)));
        JSONObject r0 = (JSONObject) this.b.getValue();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.optInt("icon_type"));
    L7:
        if (r1 != null) goto L10;
    L12:
        int r2 = 2131248049;
    L13:
        String r3 = UriUtil.getUriForResourceId(r2).toString();
        JSONObject r4 = (JSONObject) this.b.getValue();
        if (r4 == null) goto L19;
        String r5 = r4.optString("icon_url");
        if (r5 == null) goto L19;
        String r7 = a2.d(r5);
        if (r7 == null) goto L19;
    L20:
        List r8 = CollectionsKt.listOf(new String[]{r7, r3});
        int r9 = r.h;
        h0.f(r6, r8, r.a.b("ec_live_toolbar_im_image"), null, null, 120);
        this.a = r6;
        com.bytedance.android.livesdk.livecommerce.utils.a.a(r6, th.a.g(getContext(), 2131896498));
        f.c(r6, null, null, new ShoppingIMButton$onLoad$$inlined$also$lambda$1(this), 3);
        return;
    L19:
        r7 = r3;
        goto L20
    L10:
        if (r1.intValue() != 1) goto L12;
        r2 = 2131248035;
        goto L13
    L5:
        r1 = null;
        goto L7
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
        this.d.invoke();
    }

    @Override // ak2.a
    public final void setRealView(View r1) {
        this.a = r1;
    }

    public final void onViewAttached(c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        this.d.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShoppingIMButton(Context r2, Function0<Unit> r3, Function1<? super JSONObject, Unit> r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "showCallback");
        Intrinsics.checkNotNullParameter(r4, "clickCallback");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.b = LazyKt.lazy(new ShoppingIMButton$componentExtraObj$2(this));
    }
}
