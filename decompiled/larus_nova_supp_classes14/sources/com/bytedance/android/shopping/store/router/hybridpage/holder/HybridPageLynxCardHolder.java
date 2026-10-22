package com.bytedance.android.shopping.store.router.hybridpage.holder;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.list.entity.f;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.view.ECPredictHeightLayout;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import com.bytedance.android.ec.store.window.ECShopHybridRoundedLinearLayout;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ln.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageLynxCardHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLynxCardHolder;", "Lln/c;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridPageLynxCardHolder extends ECLynxCardHolder implements ln.c {
    public static final /* synthetic */ int V0 = 0;
    public final com.bytedance.android.shopping.store.router.hybridpage.holder.a H0;
    public final ViewGroup L0;
    public final HybridPageViewModel P0;
    public boolean W;
    public float X;
    public String Y;
    public boolean Z;
    public ln.b k0;
    public String p0;

    public static final class a {
    }

    static {
    }

    public final void B() {
        this.Z = false;
        E4(PlayStatus.STOP);
    }

    public final Map<String, IDLXBridgeMethod> B4() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("shop.lynx.play", new LynxStatefulBridgeProxy(new HybridPageLynxCardHolder$suppleMentJsBridgeMap$1(this), "shop.lynx.play"))});
    }

    public final void R() {
        this.Z = true;
        E4(PlayStatus.PLAY);
    }

    public final Rect r() {
        return null;
    }

    public final void v() {
        E4(PlayStatus.PAUSE);
    }

    public final void o() {
        super.o();
        this.P0.setLynxCardEventListener(null);
    }

    public final void pausePlay() {
        v();
        M();
    }

    public final void startPlay() {
        R();
        x();
    }

    public final void stopPlay() {
        B();
        z();
    }

    public final void M() {
        ln.c.a.a(this);
    }

    public final PlayAbleType P() {
        return PlayAbleType.VIDEO;
    }

    public final boolean isPlaying() {
        return this.Z;
    }

    public final ln.b m() {
        return this.k0;
    }

    public final void x() {
        ln.c.a.b(this);
    }

    public final void z() {
        ln.c.a.c(this);
    }

    public final void E4(PlayStatus r4) {
        dm.a.a("作品播控").a("itemId:" + this.Y + ",status:" + r4.getStatus());
        JSONObject r0 = new JSONObject();
        r0.put("itemId", this.Y);
        r0.put("status", r4.getStatus());
        Unit r5 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("shop_lynx_play", "eventName");
        ECLynxCard r6 = ((ECLynxCardHolder) this).t;
        if (r6 == null) goto L6;
        r6.o("shop_lynx_play", r0);
        return;
    }

    public final List<ln.c> L(Rect r4) {
        Intrinsics.checkNotNullParameter(r4, "visibleArea");
        if (this.W == false) goto L5;
        String r0 = this.p0;
        View r1 = null;
        if (r0 == null) goto L15;
        ECLynxCard r2 = ((ECLynxCardHolder) this).t;
        if (r2 == null) goto L11;
        View r3 = r2.q(r0);
    L12:
        if (r3 == null) goto L15;
        r1 = r3;
    L18:
        if (r1 != null) goto L22;
        return CollectionsKt.emptyList();
    L22:
        if (this.Z == false) goto L24;
        float r5 = this.X;
    L26:
        if (e.a(r1, r4, r5) == true) goto L30;
        return CollectionsKt.emptyList();
    L30:
        return CollectionsKt.listOf(this);
    L24:
        r5 = 1.0f;
        goto L26
    L11:
        r3 = null;
    L15:
        ECLynxCard r6 = ((ECLynxCardHolder) this).t;
        if (r6 == null) goto L18;
        r1 = r6.i();
        goto L18
    L5:
        return CollectionsKt.emptyList();
    }

    public final void k1(nn.e.a r1) {
        this.k0 = r1;
    }

    public HybridPageLynxCardHolder(ECShopHybridRoundedLinearLayout r16, String r17, HybridPageViewModel r18) {
        Intrinsics.checkNotNullParameter(r16, "layout");
        Intrinsics.checkNotNullParameter(r17, "sceneId");
        Intrinsics.checkNotNullParameter(r18, "viewModel");
        super(r16, r17, null, null, null, null, null, null, false, false, 1020);
        this.L0 = r16;
        this.P0 = r18;
        this.X = 0.5f;
        this.H0 = new com.bytedance.android.shopping.store.router.hybridpage.holder.a(this);
    }

    public final void b4(Object r5, String r6, k.a r7) {
        Intrinsics.checkNotNullParameter(r6, "itemId");
        super.b4(r5, r6, r7);
        String r8 = null;
        if (r7 == null) goto L12;
        f r0 = r7.a;
        if (r0 == null) goto L12;
        double r1 = r0.b;
        ViewGroup r2 = this.L0;
        if ((r2 instanceof ECShopHybridRoundedLinearLayout) == true) goto L9;
        r2 = null;
    L9:
        ECShopHybridRoundedLinearLayout r3 = (ECShopHybridRoundedLinearLayout) r2;
        if (r3 == null) goto L12;
        int r4 = com.bytedance.android.ec.hybrid.list.util.c.a;
        ((ECPredictHeightLayout) r3).a = com.bytedance.android.ec.hybrid.list.util.c.d(Double.valueOf(r1));
        r3.requestLayout();
    L12:
        if (r7 == null) goto L16;
        f r9 = r7.a;
        if (r9 == null) goto L16;
        HashMap r10 = r9.d;
    L17:
        if (r10 == null) goto L23;
        String r11 = (String) r10.get("play_area_rate");
        if (r11 == null) goto L23;
        Float r12 = StringsKt.toFloatOrNull(r11);
        if (r12 == null) goto L23;
        float r13 = r12.floatValue();
    L24:
        this.X = r13;
        if (r10 == null) goto L29;
        String r14 = (String) r10.get("player_item_types");
        if (r14 == null) goto L29;
        Integer r15 = StringsKt.toIntOrNull(r14);
    L30:
        if (r15 == null) goto L35;
        boolean r16 = true;
        if (r15.intValue() != 1) goto L35;
    L36:
        this.W = r16;
        if (r10 == null) goto L39;
        r8 = (String) r10.get("play_name");
    L39:
        this.p0 = r8;
        this.Y = r6;
        this.P0.setLynxCardEventListener(this.H0);
        return;
    L35:
        r16 = false;
    L29:
        r15 = null;
    L23:
        r13 = this.X;
    L16:
        r10 = null;
        goto L17
    }
}
