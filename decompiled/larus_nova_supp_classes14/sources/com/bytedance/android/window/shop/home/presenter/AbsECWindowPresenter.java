package com.bytedance.android.window.shop.home.presenter;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class AbsECWindowPresenter extends QPresenter {
    public static final /* synthetic */ int l = 0;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    static {
    }

    public final int G() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final ECWindowDialogFragment I() {
        return (ECWindowDialogFragment) this.h.getValue();
    }

    public final int K() {
        return ((Number) this.k.getValue()).intValue();
    }

    public final int N() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final ECWindowViewModel O() {
        return (ECWindowViewModel) this.e.getValue();
    }

    public AbsECWindowPresenter() {
        this.e = LazyKt.lazy(new AbsECWindowPresenter$viewModel$2(this));
        this.f = LazyKt.lazy(new AbsECWindowPresenter$screenHeight$2(this));
        this.g = LazyKt.lazy(new AbsECWindowPresenter$croppedHeight$2(this));
        this.h = LazyKt.lazy(new AbsECWindowPresenter$dialogFragment$2(this));
        this.i = LazyKt.lazy(new AbsECWindowPresenter$topBarHeight$2(this));
        this.j = LazyKt.lazy(new AbsECWindowPresenter$tabBarHeight$2(this));
        this.k = LazyKt.lazy(new AbsECWindowPresenter$liveHeight$2(this));
    }

    public final void D() {
        FragmentActivity r1 = null;
        if (O().isSplitStyle() == false) goto L13;
        nj.d r0 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r0 == null) goto L13;
        QContext r2 = u();
        FragmentActivity r3 = com.bytedance.android.ec.core.utils.l0.c(r2.c());
        if ((r3 instanceof FragmentActivity) == true) goto L9;
        r3 = null;
    L9:
        if (r3 != null) goto L11;
        r2.a();
    L11:
        r0.g();
    L13:
        if (O().getShopParam().isCroppedStyle() == false) goto L22;
        ECWindowDialogFragment r4 = I();
        if (r4 == null) goto L32;
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L33;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L33:
        return;
    L32:
        return;
    L22:
        QContext r6 = u();
        FragmentActivity r7 = com.bytedance.android.ec.core.utils.l0.c(r6.c());
        if ((r7 instanceof FragmentActivity) == false) goto L26;
        r1 = r7;
    L26:
        if (r1 != null) goto L28;
        r1 = r6.a();
    L28:
        r1.finish();
    }

    public float E() {
        if (F() == true) goto L5;
        return 1.0f;
    L5:
        Pair r0 = (Pair) O().getOffsetState().getValue();
        if (r0 != null) goto L10;
        return 0.0f;
    L10:
        return RangesKt.coerceAtMost(Math.abs(((Number) r0.getFirst()).intValue()) / W(), 1.0f);
    }

    public final boolean F() {
        return O().couldLive();
    }

    public final boolean Q() {
        ECWindowDialogFragment r0 = I();
        if (r0 != null) goto L12;
        Activity r1 = com.bytedance.android.ec.core.utils.l0.b(u().c());
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.isFinishing() != true) goto L10;
        return true;
    L12:
        return r0.isRemoving();
    }

    public final boolean T() {
        if (O().isCroppedStyle() == true) goto L5;
        return true;
    L5:
        Integer r0 = (Integer) O().getCroppedState().getValue();
        if (r0 != null) goto L9;
    L13:
        return false;
    L9:
        if (r0.intValue() != 2) goto L13;
        if (E() <= 0.75f) goto L13;
        return true;
    }

    public final LifecycleOwner U() {
        ECWindowDialogFragment r0 = I();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ECQuickUtilKt.a(u());
    }

    public final void V() {
        Function1<hp3.b, Boolean> r0 = O().getEventDeliverer();
        if (r0 != null) goto L5;
    L7:
        ECWindowParam r1 = O().getShopParam();
        JSONObject r2 = new JSONObject();
        if (r1.isEcShare() == false) goto L10;
        r2.put("is_ec_shopping", 1);
        r2.put("share_content", r1.getShareContent());
        r2.put("share_object", r1.getShareObject());
    L11:
        String r3 = r2.toString();
        com.bytedance.android.ec.core.utils.m0 r4 = new com.bytedance.android.ec.core.utils.m0("sslocal://goods/shop/search");
        r4.a("uid", r1.getAuthorId());
        r4.a("sec_uid", r1.getSecAuthorId());
        r4.a("enter_from", r1.getEnterFrom());
        r4.a("enter_method", r1.getEnterMethod());
        r4.a("which_account", r1.getWhichAccount());
        r4.a("share_params", r3);
        r4.a("search_hint", u().c().getString(2131895922));
        r4.a("store_source_page", r1.getStoreSourcePage());
        r4.a("store_source_method", r1.getStoreSourceMethod());
        r4.a("store_group_type", r1.getStoreGroupType());
        r4.a("search_params", r1.getSearchParams());
        r4.a("entrance_location", r1.getEntranceLocation());
        r4.a("tmp_id", r1.getTempId());
        r4.a("pass_through_api", (String) r1.getPassThroughParam("pass_through_api"));
        Map<String, Object> r5 = O().getMetaInfoWithoutKolId();
        r5.put("author_id", O().getShopParam().getAuthorId());
        Unit r6 = Unit.INSTANCE;
        r4.a("metaInfo", com.bytedance.android.ec.hybrid.list.util.k.d(r5));
        BtmSDK r7 = BtmSDK.INSTANCE;
        r4.a("source_btm_token", BtmSDK.createJumpSourceBtmToken$default(r7, "a1.b7635.c2240.d1027", PageFinder.via(y()), null, 4, null));
        com.bytedance.android.ec.sdk.helper.p r8 = com.bytedance.android.ec.sdk.helper.p.a;
        String r9 = r4.c();
        QContext r10 = u();
        Activity r11 = com.bytedance.android.ec.core.utils.l0.c(r10.c());
        if ((r11 instanceof FragmentActivity) == true) goto L14;
        r11 = null;
    L14:
        if (r11 != null) goto L16;
        r11 = r10.a();
    L16:
        r8.d(r9, r11);
        String r12 = r7.createBtmId(new BtmItemBuilder("a1.b7635.c2240.d1027", Boolean.TRUE).withView(y()).build());
        O().doEventAction("enter_search", new Pair[]{TuplesKt.to("enter_from", "search_window"), TuplesKt.to("author_id", O().getShopParam().getAuthorId()), TuplesKt.to("btm_id", r12)});
        boolean r13 = com.bytedance.android.ec.window.base.shop.j.a;
        com.bytedance.android.ec.window.base.shop.j.b("window_search_in_window", PostActionType.DO);
        return;
    L10:
        r2.put("is_ec_shopping", 0);
        goto L11
    L5:
        if (((Boolean) r0.invoke(lp3.c.b)).booleanValue() != true) goto L7;
    }

    public final int W() {
        return K() - N();
    }

    public final View X() {
        View r0 = y();
    L4:
        if (r0.getId() == 16908290) goto L12;
        if ((r0.getParent() instanceof View) == false) goto L12;
        Object r1 = r0.getParent();
        if (r1 == null) goto L11;
        r0 = (View) r1;
        goto L4
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L12:
        return r0;
    }

    public float Y(int r3) {
        Pair r0 = (Pair) O().getOffsetState().getValue();
        if (r0 == null) goto L12;
        int r1 = Math.abs(((Number) r0.getFirst()).intValue());
        if (F() == false) goto L14;
        if (r1 <= W()) goto L10;
        r1 = r1 - W();
        goto L14
    L10:
        r1 = 0;
    L14:
        return RangesKt.coerceAtMost(r1 / r3, 1.0f);
    L12:
        return 0.0f;
    }

    public static boolean S(float r0, float r1) {
        if (Math.abs(Math.abs(r0) - Math.abs(r1)) >= 1.0E-6f) goto L5;
        return true;
    L5:
        return false;
    }
}
