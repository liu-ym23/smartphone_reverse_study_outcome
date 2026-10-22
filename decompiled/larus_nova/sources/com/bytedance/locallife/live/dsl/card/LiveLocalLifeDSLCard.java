package com.bytedance.locallife.live.dsl.card;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.gaiax.api.GXIEventListener;
import com.alibaba.gaiax.api.IGXTemplateEngine;
import com.alibaba.gaiax.model.GXAnimation;
import com.alibaba.gaiax.model.GXGesture;
import com.alibaba.gaiax.model.GXScroll;
import com.alibaba.gaiax.model.GXTemplateData;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.locallife.live.card.LiveLocalLifeBaseCard;
import com.bytedance.locallife.live.dsl.LiveLocalLifeDSLEngine;
import com.bytedance.locallife.live.dsl.h;
import com.bytedance.locallife.live.experiment.LiveLocalLifeDslCardPreloadExperiment;
import com.bytedance.locallife.live.experiment.e;
import com.bytedance.locallife.live.experiment.f;
import com.bytedance.locallife.live.model.GroupPurchaseFlashSale;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.live.msgcenter.MsgCenter;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.util.a0;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.w;
import com.bytedance.locallife.live.view.LiveLifeSellAtmosphereView;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import nv6.m0;
import nv6.n;
import nv6.n0;
import nv6.p;
import nv6.s;
import nv6.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/live/dsl/card/LiveLocalLifeDSLCard;", "Lcom/bytedance/locallife/live/card/LiveLocalLifeBaseCard;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeDSLCard extends LiveLocalLifeBaseCard {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f259435z = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Activity f259436n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.locallife.live.card.a f259437o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final IRoomState f259438p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LiveLocalLifeBaseCard.b f259439q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinearLayout f259440r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.locallife.live.dsl.card.c f259441s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LiveLifeSellAtmosphereView f259442t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f259443u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f259444v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f259445w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.locallife.live.msgcenter.b f259446x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bytedance.locallife.live.msgcenter.b f259447y;

    public static final class a implements pv6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeDSLCard f259448a;

        public a(LiveLocalLifeDSLCard r100) {
            this.f259448a = r100;
        }

        @Override // pv6.c
        public final void a(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            String r103 = null;
            if (r101 == null) goto L5;
            Object r104 = r101.get("data");
        L7:
            if ((r104 instanceof Map) == false) goto L9;
            Map r105 = (Map) r104;
        L10:
            if (r105 != null) goto L12;
        L15:
            boolean r106 = true;
        L16:
            if (r106 == false) goto L18;
            return;
        L18:
            Gson r107 = LiveLifeSaaSUtil.r();
            LiveLocalLifeDSLCard r108 = this.f259448a;
            n0 r109 = (n0) GsonProtectorUtils.fromJson(r107, GsonProtectorUtils.toJson(r107, r105), n0.class);
            if (r109 == null) goto L21;
            m0 r110 = r109.a();
        L22:
            n r111 = r108.k();
            if (r111 == null) goto L28;
            p r112 = r111.a();
            if (r112 == null) goto L28;
            String r113 = r112.q();
            if (r113 == null) goto L28;
        L29:
            if (r110 == null) goto L32;
            r103 = r110.b();
        L32:
            if (TextUtils.equals(r113, r103) == false) goto L38;
            if (r110 == null) goto L37;
            r108.f259442t.setAtmosphereUiData(r110);
            return;
        L37:
            return;
        L38:
            return;
        L28:
            r113 = "";
            goto L29
        L21:
            r110 = null;
            goto L22
        L12:
            if (r105.isEmpty() == true) goto L15;
            r106 = false;
            goto L16
        L9:
            r105 = null;
            goto L10
        L5:
            r104 = null;
            goto L7
        }
    }

    public static final class b implements GXIEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeDSLCard f259449a;

        public b(LiveLocalLifeDSLCard r100) {
            this.f259449a = r100;
        }

        @Override // com.alibaba.gaiax.api.GXIEventListener
        public final void onAnimationEvent(GXAnimation r100) {
            GXIEventListener.DefaultImpls.onAnimationEvent(this, r100);
        }

        @Override // com.alibaba.gaiax.api.GXIEventListener
        public final void onGestureEvent(GXGesture r100) {
            Intrinsics.checkNotNullParameter(r100, "gxGesture");
            LiveLocalLifeDSLCard.A(this.f259449a, r100.getNodeId(), r100.getGestureType(), r100.getEventParams());
        }

        @Override // com.alibaba.gaiax.api.GXIEventListener
        public final void onScrollEvent(GXScroll r100) {
            GXIEventListener.DefaultImpls.onScrollEvent(this, r100);
        }
    }

    public static final class c implements pv6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeDSLCard f259450a;

        public c(LiveLocalLifeDSLCard r100) {
            this.f259450a = r100;
        }

        @Override // pv6.c
        public final void a(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Map<?, ?> r103 = null;
            if (r101 == null) goto L5;
            Object r104 = r101.get("data");
        L7:
            if ((r104 instanceof Map) == false) goto L9;
            Map r105 = (Map) r104;
        L10:
            if (r105 == null) goto L12;
            Object r106 = r105.get("display_data");
        L14:
            if ((r106 instanceof Map) == false) goto L16;
            Map r107 = (Map) r106;
        L17:
            if (r107 == null) goto L19;
            Object r108 = r107.get("expound_card_UI");
        L21:
            if ((r108 instanceof Map) == false) goto L23;
            r103 = (Map) r108;
        L23:
            if (r103 != null) goto L25;
        L28:
            boolean r109 = true;
        L29:
            if (r109 == false) goto L31;
            return;
        L31:
            LiveLocalLifeDSLCard r110 = this.f259450a;
            int r111 = LiveLocalLifeDSLCard.f259435z;
            r110.B(r103);
            return;
        L25:
            if (r103.isEmpty() == true) goto L28;
            r109 = false;
            goto L29
        L19:
            r108 = null;
            goto L21
        L16:
            r107 = null;
            goto L17
        L12:
            r106 = null;
            goto L14
        L9:
            r105 = null;
            goto L10
        L5:
            r104 = null;
            goto L7
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeDSLCard f259451a;

        public d(LiveLocalLifeDSLCard r100) {
            this.f259451a = r100;
        }

        public final void a() {
            Rect r100 = new Rect();
            int r101 = j0.c(13);
            this.f259451a.f259440r.getHitRect(r100);
            r100.right += r101;
            TouchDelegate r102 = new TouchDelegate(r100, this.f259451a.f259440r);
            Object r103 = this.f259451a.f259440r.getParent();
            View r104 = null;
            if ((r103 instanceof View) == false) goto L5;
            View r105 = (View) r103;
        L6:
            if (r105 == null) goto L14;
            r105.setTouchDelegate(r102);
            Rect r106 = new Rect();
            r105.getHitRect(r106);
            r106.right += r101;
            TouchDelegate r107 = new TouchDelegate(r106, r105);
            Object r108 = r105.getParent();
            if ((r108 instanceof View) == false) goto L10;
            r104 = (View) r108;
        L10:
            if (r104 == null) goto L15;
            r104.setTouchDelegate(r107);
            return;
        L15:
            return;
        L14:
            return;
        L5:
            r105 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final String D() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259162a;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L12;
        LiveLocalLifeCardDSLEngine r103 = r102.getDslExpoundCardEngine();
        if (r103 == null) goto L12;
        if (Intrinsics.areEqual(r103.f259431k, "-1") == false) goto L9;
        r103.f259431k = h.c();
    L9:
        String r104 = r103.f259431k;
        if (r104 == null) goto L12;
        return r104;
    L12:
        return h.c();
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final void f() {
        if (this.f259170i == false) goto L5;
        return;
    L5:
        com.bytedance.locallife.live.card.a r100 = this.f259437o;
        if (r100 == null) goto L8;
        String r101 = r100.f259218g;
    L10:
        if (Intrinsics.areEqual(r101, "update") == true) goto L12;
        E();
        return;
    L12:
        qv6.d.o("206");
        return;
    L8:
        r101 = null;
        goto L10
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final void w() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259162a;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.isPreview() != true) goto L7;
    L8:
        if (r103 == true) goto L11;
        F(false);
        Lazy r104 = MsgCenter.f260620a;
        MsgCenter.h(this.f259446x);
        MsgCenter.h(this.f259447y);
        return;
    L11:
        return;
    L7:
        r103 = false;
        goto L8
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final void x() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259162a;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L13;
        Lazy r104 = MsgCenter.f260620a;
        MsgCenter.g(this.f259446x);
        MsgCenter.g(this.f259447y);
        F(true);
        if (f.a() == false) goto L14;
        this.f259440r.post(new d(this));
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r102.isPreview() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final void y() {
        j0.a(this.f259441s);
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259162a;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L21;
        av6.a r103 = r102.getExpoundCardPreloadManager();
        if (r103 == null) goto L22;
        com.bytedance.locallife.live.dsl.card.c r104 = this.f259441s;
        Intrinsics.checkNotNullParameter(r104, "cardView");
        av6.a.C0236a r105 = r103.f16373b;
        if (r105 == null) goto L23;
        Intrinsics.checkNotNullParameter(r104, "cardView");
        if (((Number) LiveLocalLifeDslCardPreloadExperiment.f259492a.getValue()).intValue() <= 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == true) goto L15;
        return;
    L15:
        if ((r104 instanceof com.bytedance.locallife.live.dsl.card.c) == true) goto L18;
        return;
    L18:
        if (r105.f16376c != null) goto L24;
        LiveLifeSaaSUtil.t().i("DSLCardCachedViewInfo", "recycle dsl card " + r104);
        r105.f16376c = r104;
        return;
    L24:
        return;
    L11:
        r106 = false;
        goto L12
    L23:
        return;
    L22:
        return;
    }

    public final void E() {
        p r100 = null;
        if (com.bytedance.locallife.live.settings.c.j() == true) goto L14;
        boolean r101 = LiveLocalLifeUtil.f260684b;
        jt6.a r102 = LiveLifeSaaSUtil.x();
        IRoomState r103 = this.f259438p;
        if (r103 == null) goto L8;
        String r104 = r103.getRoomId();
        if (r104 == null) goto L8;
    L9:
        r102.e(r104, "othershow", null);
        Map<String, String> r105 = C("c2627.d0", null);
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("btm_info", r105);
        LiveLocalLifeViewModel.Companion r107 = LiveLocalLifeViewModel.Companion;
        String r108 = this.f259162a;
        r107.getClass();
        LiveLocalLifeViewModel r109 = LiveLocalLifeViewModel.Companion.a(r108);
        if (r109 == null) goto L60;
        LiveLocalLifeCardDSLEngine r110 = r109.getDslExpoundCardEngine();
        if (r110 == null) goto L60;
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("should_disable_show_tracker", Boolean.FALSE);
        r111.put("track_info", r106);
        Unit r112 = Unit.INSTANCE;
        r110.d("expoundCardDidAppear", CollectionsKt.listOf(r111));
    L60:
        LiveLocalLifeViewModel.Companion r113 = LiveLocalLifeViewModel.Companion;
        String r114 = this.f259162a;
        r113.getClass();
        LiveLocalLifeViewModel r115 = LiveLocalLifeViewModel.Companion.a(r114);
        if (r115 == null) goto L65;
        boolean r116 = true;
        if (r115.isPreview() != true) goto L65;
    L66:
        if (r116 == false) goto L71;
        HashMap r117 = new HashMap();
        r117.put("module_name", "life_info_card");
        com.bytedance.locallife.live.card.f r118 = this.f259166e;
        if (r118 == null) goto L72;
        r118.sendLogger("livesdk_preview_guide_show", r117);
        return;
    L72:
        return;
    L71:
        return;
    L65:
        r116 = false;
    L8:
        r104 = "";
        goto L9
    L14:
        LiveLocalLifeViewModel.Companion r119 = LiveLocalLifeViewModel.Companion;
        String r120 = this.f259162a;
        r119.getClass();
        LiveLocalLifeViewModel r121 = LiveLocalLifeViewModel.Companion.a(r120);
        if (r121 == null) goto L32;
        qv6.h r122 = r121.getLiveLocalLifeCardTracker();
        if (r122 == null) goto L32;
        IRoomState r123 = this.f259438p;
        Activity r124 = this.f259436n;
        if ((r124 instanceof FragmentActivity) == false) goto L21;
        FragmentActivity r125 = (FragmentActivity) r124;
    L22:
        n r126 = k();
        if (r126 == null) goto L25;
        p r127 = r126.a();
    L26:
        LinearLayout r128 = this.f259440r;
        com.bytedance.locallife.live.card.a r129 = this.f259437o;
        if (r129 == null) goto L29;
        t r130 = r129.f259214c;
    L30:
        r122.i(r123, r125, r127, null, r128, r130);
        goto L32
    L29:
        r130 = null;
        goto L30
    L25:
        r127 = null;
        goto L26
    L21:
        r125 = null;
    L32:
        if (p() == false) goto L47;
        LiveLocalLifeViewModel r131 = LiveLocalLifeViewModel.Companion.a(this.f259162a);
        if (r131 == null) goto L47;
        qv6.h r132 = r131.getLiveLocalLifeCardTracker();
        if (r132 == null) goto L47;
        Activity r133 = this.f259436n;
        if ((r133 instanceof FragmentActivity) == false) goto L40;
        FragmentActivity r134 = (FragmentActivity) r133;
    L41:
        n r135 = k();
        if (r135 == null) goto L44;
        p r136 = r135.a();
    L45:
        r132.h(r134, r136);
        goto L47
    L44:
        r136 = null;
        goto L45
    L40:
        r134 = null;
    L47:
        if (o() == false) goto L60;
        LiveLocalLifeViewModel r137 = LiveLocalLifeViewModel.Companion.a(this.f259162a);
        if (r137 == null) goto L60;
        qv6.h r138 = r137.getLiveLocalLifeCardTracker();
        if (r138 == null) goto L60;
        Activity r139 = this.f259436n;
        if ((r139 instanceof FragmentActivity) == false) goto L55;
        FragmentActivity r140 = (FragmentActivity) r139;
    L56:
        n r141 = k();
        if (r141 == null) goto L59;
        r100 = r141.a();
    L59:
        r138.g(r140, r100, "life_member_entrance_show");
        goto L60
    L55:
        r140 = null;
        goto L56
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final void v() {
        if (f.a() == false) goto L23;
        Object r100 = this.f259440r.getParent();
        if ((r100 instanceof View) == false) goto L7;
        View r101 = (View) r100;
    L8:
        if (r101 == null) goto L11;
        r101.setTouchDelegate(null);
    L11:
        ViewParent r102 = this.f259440r.getParent();
        if (r102 == null) goto L14;
        Object r103 = r102.getParent();
    L16:
        if ((r103 instanceof View) == false) goto L18;
        View r104 = (View) r103;
    L19:
        if (r104 == null) goto L24;
        r104.setTouchDelegate(null);
        return;
    L24:
        return;
    L18:
        r104 = null;
        goto L19
    L14:
        r103 = null;
        goto L16
    L7:
        r101 = null;
        goto L8
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final void z() {
        super.z();
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259162a;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.isPreview() != true) goto L7;
    L8:
        if (r103 == true) goto L11;
        F(false);
        Lazy r104 = MsgCenter.f260620a;
        MsgCenter.h(this.f259446x);
        MsgCenter.h(this.f259447y);
        return;
    L11:
        return;
    L7:
        r103 = false;
        goto L8
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final com.bytedance.locallife.live.card.a g() {
        return this.f259437o;
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final LinearLayout h() {
        return this.f259440r;
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final long j() {
        return this.f259444v;
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final long l() {
        return this.f259443u;
    }

    public final void B(Map<?, ?> r110) {
        boolean r100 = LiveLocalLifeDSLEngine.f259406a;
        IGXTemplateEngine r101 = LiveLocalLifeDSLEngine.f259407b;
        if (r101 == null) goto L6;
        View r102 = this.f259441s.getTemplateView();
        GXTemplateData r103 = new GXTemplateData(new JSONObject(r110));
        r103.setEventListener(new b(this));
        Unit r111 = Unit.INSTANCE;
        IGXTemplateEngine.DefaultImpls.bindData$default(r101, r102, r103, null, false, null, 28, null);
        return;
    }

    public final void F(boolean r100) {
        if (r100 == false) goto L4;
        this.f259445w = UUID.randomUUID().toString();
    L4:
        n r101 = k();
        String r102 = "";
        if (r101 == null) goto L10;
        p r103 = r101.a();
        if (r103 == null) goto L10;
        String r104 = r103.q();
        if (r104 == null) goto L10;
    L11:
        if (r100 == false) goto L13;
        String r105 = "show";
    L14:
        LiveLocalLifeRoomInfo r106 = LiveLocalLifeUtil.e(this.f259162a);
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("product_id", r104);
        r107.put("show_type", r105);
        r107.put("room_info", w.h(r106));
        String r108 = this.f259445w;
        if (r108 == null) goto L18;
        r102 = r108;
    L18:
        r107.put(ST.UUID_DEVICE, r102);
        Lazy r109 = MsgCenter.f260620a;
        MsgCenter.f(new com.bytedance.locallife.live.msgcenter.a("live_life_expound_card_life_cycle", r107, null, 4));
        return;
    L13:
        r105 = "hide";
    L10:
        r104 = "";
        goto L11
    }

    public final void G(String r110) {
        if (com.bytedance.locallife.live.settings.c.j() == false) goto L21;
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259162a;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L34;
        qv6.h r103 = r102.getLiveLocalLifeCardTracker();
        if (r103 == null) goto L34;
        Activity r104 = this.f259436n;
        if ((r104 instanceof FragmentActivity) == false) goto L11;
        FragmentActivity r105 = (FragmentActivity) r104;
    L12:
        n r106 = k();
        if (r106 == null) goto L15;
        p r107 = r106.a();
    L16:
        IRoomState r108 = this.f259438p;
        boolean r109 = n();
        boolean r111 = q();
        LinearLayout r112 = this.f259440r;
        com.bytedance.locallife.live.card.a r113 = this.f259437o;
        if (r113 == null) goto L19;
        t r114 = r113.f259214c;
    L20:
        r103.d(r110, r105, r107, r108, r109, null, r111, r112, r114);
        goto L34
    L19:
        r114 = null;
        goto L20
    L15:
        r107 = null;
        goto L16
    L11:
        r105 = null;
    L34:
        LiveLocalLifeViewModel.Companion r115 = LiveLocalLifeViewModel.Companion;
        String r116 = this.f259162a;
        r115.getClass();
        LiveLocalLifeViewModel r117 = LiveLocalLifeViewModel.Companion.a(r116);
        if (r117 == null) goto L39;
        boolean r118 = true;
        if (r117.isPreview() != true) goto L39;
    L40:
        if (r118 == false) goto L45;
        HashMap r119 = new HashMap();
        r119.put("module_name", "life_info_card");
        com.bytedance.locallife.live.card.f r120 = this.f259166e;
        if (r120 == null) goto L46;
        r120.sendLogger("livesdk_preview_guide_click", r119);
        return;
    L46:
        return;
    L45:
        return;
    L39:
        r118 = false;
        goto L40
    L21:
        boolean r121 = LiveLocalLifeUtil.f260684b;
        jt6.a r122 = LiveLifeSaaSUtil.x();
        IRoomState r123 = this.f259438p;
        if (r123 == null) goto L25;
        String r124 = r123.getRoomId();
        if (r124 == null) goto L25;
    L26:
        JSONObject r125 = new JSONObject();
        n r126 = k();
        if (r126 == null) goto L33;
        p r127 = r126.a();
        if (r127 == null) goto L33;
        String r128 = r127.q();
        if (r128 == null) goto L33;
        r125.put("groupon_id", r128);
    L33:
        Unit r129 = Unit.INSTANCE;
        r122.e(r124, "live_life_card_click", r125);
    L25:
        r124 = "";
        goto L26
    }

    public final Map<String, String> C(String r100, Boolean r101) {
        com.bytedance.locallife.biz.btm.b.a r102 = new com.bytedance.locallife.biz.btm.b.a(r100, r101);
        r102.b(this.f259440r);
        r102.f256558c.setAddBtmChain(true);
        LinkedHashMap r103 = new LinkedHashMap();
        if (com.bytedance.locallife.live.settings.c.e() == true) goto L5;
        int r104 = com.bytedance.locallife.biz.btm.b.f256555a;
        com.bytedance.locallife.biz.btm.b.C3644b.a(r103, r102);
    L5:
        return r103;
    }

    @Override // com.bytedance.locallife.live.card.LiveLocalLifeBaseCard
    public final void a(n r110, int r111) {
        this.f259173l = r110;
        LiveLocalLifeViewModel.Companion r112 = LiveLocalLifeViewModel.Companion;
        String r100 = this.f259162a;
        r112.getClass();
        LiveLocalLifeViewModel r113 = LiveLocalLifeViewModel.Companion.a(r100);
        p r101 = null;
        if (r113 == null) goto L18;
        MutableLiveData<com.bytedance.locallife.live.goodsshelves.bean.c> r114 = r113.getLynxDslExpoundCardResponse();
        if (r114 == null) goto L18;
        com.bytedance.locallife.live.goodsshelves.bean.c r115 = r114.getValue();
        if (r115 == null) goto L18;
        if (r115.f259594d == null) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L17;
        Map r116 = r115.f259594d;
        if (r116 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("expoundCardData");
    L19:
        if (r116 != null) goto L21;
        return;
    L21:
        if (r116.get("expound_card_UI") != null) goto L23;
        return;
    L23:
        if (this.f259441s.getTemplateView() == null) goto L146;
        Object r103 = r116.get("expound_card_UI");
        Map<String, Object> r104 = w.d(r116, "expound_card_session");
        if (r104 == null) goto L39;
        Iterator<Map.Entry<String, Object>> r105 = r104.entrySet().iterator();
    L29:
        if (r105.hasNext() == false) goto L39;
        Map.Entry<String, Object> r106 = r105.next();
        String r107 = r106.getKey();
        Object r108 = r106.getValue();
        LiveLocalLifeViewModel.Companion r109 = LiveLocalLifeViewModel.Companion;
        String r117 = this.f259162a;
        r109.getClass();
        LiveLocalLifeViewModel r118 = LiveLocalLifeViewModel.Companion.a(r117);
        if (r118 == null) goto L29;
        MutableLiveData<com.bytedance.locallife.live.goodsshelves.bean.c> r119 = r118.getLynxDslExpoundCardResponse();
        if (r119 == null) goto L29;
        com.bytedance.locallife.live.goodsshelves.bean.c r120 = r119.getValue();
        if (r120 == null) goto L29;
        Map<String, String> r121 = r120.f259595e;
        if (r121 == null) goto L29;
        String r122 = r121.put(r107, r108.toString());
    L39:
        Map<String, Object> r123 = w.d(r116, "expound_card_track");
        if (r123 == null) goto L53;
        Iterator<Map.Entry<String, Object>> r124 = r123.entrySet().iterator();
    L43:
        if (r124.hasNext() == false) goto L53;
        Map.Entry<String, Object> r125 = r124.next();
        String r126 = r125.getKey();
        Object r127 = r125.getValue();
        LiveLocalLifeViewModel.Companion r128 = LiveLocalLifeViewModel.Companion;
        String r129 = this.f259162a;
        r128.getClass();
        LiveLocalLifeViewModel r130 = LiveLocalLifeViewModel.Companion.a(r129);
        if (r130 == null) goto L43;
        MutableLiveData<com.bytedance.locallife.live.goodsshelves.bean.c> r131 = r130.getLynxDslExpoundCardResponse();
        if (r131 == null) goto L43;
        com.bytedance.locallife.live.goodsshelves.bean.c r132 = r131.getValue();
        if (r132 == null) goto L43;
        Map<String, String> r133 = r132.f259596f;
        if (r133 == null) goto L43;
        String r134 = r133.put(r126, r127.toString());
    L53:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        B((Map) r103);
        n r135 = k();
        if (r135 == null) goto L74;
        p r136 = r135.a();
        if (r136 == null) goto L74;
        GroupPurchaseFlashSale r137 = r136.p();
        long r138 = 0;
        if (r137 == null) goto L64;
        String r139 = r137.getStartTime();
        if (r139 == null) goto L64;
        Long r140 = a0.b(r139, "DSLCard#startTime", 3);
        if (r140 == null) goto L64;
        long r141 = r140.longValue();
    L65:
        long r142 = 1000;
        this.f259443u = r141 * r142;
        GroupPurchaseFlashSale r143 = r136.p();
        if (r143 == null) goto L72;
        String r144 = r143.getEndTime();
        if (r144 == null) goto L72;
        Long r145 = a0.b(r144, "DslCard#endTime", 3);
        if (r145 == null) goto L72;
        r138 = r145.longValue();
    L72:
        this.f259444v = r138 * r142;
    L64:
        r141 = 0;
    L74:
        if (r111 != 2) goto L84;
        com.bytedance.locallife.live.card.a r146 = this.f259437o;
        if (r146 == null) goto L78;
        String r147 = r146.f259218g;
    L80:
        if (Intrinsics.areEqual(r147, "update") == true) goto L82;
        E();
        goto L84
    L82:
        qv6.d.o("206");
        goto L84
    L78:
        r147 = null;
    L84:
        if (n() == true) goto L86;
    L104:
        n r148 = k();
        if (r148 == null) goto L108;
        r148.a();
    L108:
        if (k() != null) goto L111;
        this.f259439q.a();
        return;
    L111:
        LiveLocalLifeViewModel.Companion r149 = LiveLocalLifeViewModel.Companion;
        String r150 = this.f259162a;
        r149.getClass();
        LiveLocalLifeViewModel r151 = LiveLocalLifeViewModel.Companion.a(r150);
        if (r151 == null) goto L144;
        LiveLocalLifeCardDSLEngine r152 = r151.getDslExpoundCardEngine();
        if (r152 == null) goto L145;
        Intrinsics.checkNotNullParameter(this, BrowserDependency.UrlClickType.CARD);
        LiveLifeSaaSUtil.t().i("LiveLocalLifeCardDSLEngine", "registerCardRef " + r152.f259421a);
        if (com.bytedance.locallife.live.experiment.w.a() == false) goto L147;
        r152.f259429i = new WeakReference(this);
        return;
    L147:
        return;
    L145:
        return;
    L144:
        return;
    L86:
        if (com.bytedance.locallife.live.settings.c.j() == true) goto L92;
        LiveLocalLifeViewModel.Companion r153 = LiveLocalLifeViewModel.Companion;
        String r154 = this.f259162a;
        r153.getClass();
        LiveLocalLifeViewModel r155 = LiveLocalLifeViewModel.Companion.a(r154);
        if (r155 == null) goto L104;
        LiveLocalLifeCardDSLEngine r156 = r155.getDslExpoundCardEngine();
        if (r156 == null) goto L104;
        r156.d("expoundCardSeckillShowTracker", null);
        goto L104
    L92:
        LiveLocalLifeViewModel.Companion r157 = LiveLocalLifeViewModel.Companion;
        String r158 = this.f259162a;
        r157.getClass();
        LiveLocalLifeViewModel r159 = LiveLocalLifeViewModel.Companion.a(r158);
        if (r159 == null) goto L104;
        qv6.h r160 = r159.getLiveLocalLifeCardTracker();
        if (r160 == null) goto L104;
        Activity r161 = this.f259436n;
        if ((r161 instanceof FragmentActivity) == false) goto L99;
        FragmentActivity r162 = (FragmentActivity) r161;
    L100:
        n r163 = k();
        if (r163 == null) goto L103;
        r101 = r163.a();
    L103:
        r160.f(r162, r101, q());
        goto L104
    L99:
        r162 = null;
        goto L100
    L146:
        return;
    L17:
        r116 = new LinkedHashMap();
        goto L19
    L11:
        r102 = false;
    L18:
        r116 = null;
        goto L19
    }

    public static final void A(LiveLocalLifeDSLCard r100, String r101, String r102, JSONObject r103) {
        r100.getClass();
        if (Intrinsics.areEqual(r101, "live_life_expound_card") == false) goto L6;
        String r104 = "c2627.d4434";
    L9:
        Map<String, String> r105 = r100.C(r104, Boolean.TRUE);
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("btm_info", r105);
        LiveLocalLifeViewModel.Companion r107 = LiveLocalLifeViewModel.Companion;
        String r108 = r100.f259162a;
        r107.getClass();
        LiveLocalLifeViewModel r109 = LiveLocalLifeViewModel.Companion.a(r108);
        if (r109 == null) goto L15;
        LiveLocalLifeCardDSLEngine r110 = r109.getDslExpoundCardEngine();
        if (r110 == null) goto L16;
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put(BitableResourceData.KEY_VIEW_ID, r101);
        r111.put("type", r102);
        r111.put("event_params", r103);
        r111.put("event_type", Integer.valueOf(!com.bytedance.locallife.live.settings.c.j() ? 1 : 0));
        r111.put("track_info", r106);
        Unit r112 = Unit.INSTANCE;
        r110.d("expoundCardModuleClickEvent", CollectionsKt.listOf(r111));
        return;
    L16:
        return;
    L15:
        return;
    L6:
        if (Intrinsics.areEqual(r101, "buy_button_container") == false) goto L8;
        r104 = "c2627.d6587";
        goto L9
    L8:
        r104 = "";
        goto L9
    }

    public LiveLocalLifeDSLCard(String r100, Activity r101, com.bytedance.locallife.live.card.a r110, IRoomState r111, LiveLocalLifeBaseCard.b r112, com.bytedance.locallife.live.card.f r113) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r112, "closeListener");
        super(r100, r101, r110, r111, r112, r113);
        this.f259436n = r101;
        this.f259437o = r110;
        this.f259438p = r111;
        this.f259439q = r112;
        Object r114 = null;
        View r115 = View.inflate(r101, R.layout.saas_poi_live_local_life_dsl_expound_card, null);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r116 = (LinearLayout) r115;
        this.f259440r = r116;
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r100);
        boolean r103 = false;
        if (r102 == null) goto L28;
        av6.a r104 = r102.getExpoundCardPreloadManager();
        if (r104 == null) goto L28;
        String r105 = D();
        Intrinsics.checkNotNullParameter(r105, GXTemplateKey.GAIAX_TEMPLATE_VERSION);
        av6.a.C0236a r106 = r104.f16373b;
        if (r106 == null) goto L26;
        Intrinsics.checkNotNullParameter(r105, GXTemplateKey.GAIAX_TEMPLATE_VERSION);
        if (((Number) LiveLocalLifeDslCardPreloadExperiment.f259492a.getValue()).intValue() <= 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L26;
        com.bytedance.locallife.live.dsl.card.c r108 = r106.f16376c;
        r106.f16376c = null;
        if (r108 == null) goto L17;
        String r109 = r108.getTemplateVersion();
    L19:
        if (Intrinsics.areEqual(r105, r109) == false) goto L21;
        LiveLifeSaaSUtil.t().i("DSLCardCachedViewInfo", "get dsl cached view " + r108);
    L27:
        if (r108 == null) goto L28;
    L29:
        this.f259441s = r108;
        LiveLifeSellAtmosphereView r117 = (LiveLifeSellAtmosphereView) r116.findViewById(R.id.view_atmoshere);
        this.f259442t = r117;
        n r118 = k();
        if (r118 == null) goto L32;
        p r119 = r118.a();
    L33:
        if (r119 == null) goto L62;
        n r120 = k();
        if (r120 == null) goto L37;
        s r121 = r120.b();
    L38:
        if (r121 == null) goto L62;
        super.m();
        r108.setLayoutParams(new FrameLayout.LayoutParams((int) j0.b(112.0f), (int) j0.b(175.0f)));
        r108.setBackgroundResource(R.drawable.live_bg_group_purchase_card_update);
        r116.addView(r108);
        r117.setPosition(BrowserDependency.UrlClickType.CARD);
        int r122 = e.f259500a;
        Class r123 = Integer.TYPE;     // Catch: Throwable -> L55
        if (LiveLifeSaaSUtil.y().containsKey("live_life_card_atmosphere_area_click") == false) goto L50;
        Object r124 = LiveLifeSaaSUtil.y().get("live_life_card_atmosphere_area_click");     // Catch: Throwable -> L55
        if (r124 != null) goto L47;
    L51:
        Integer r125 = (Integer) r114;     // Catch: Throwable -> L55
        if (r125 == null) goto L56;
        int r126 = r125.intValue();     // Catch: Throwable -> L55
    L57:
        if (1 != r126) goto L59;
        r103 = true;
    L59:
        if (r103 == false) goto L61;
        LinearLayout r127 = this.f259440r;
        r127.setOnClickListener(new com.bytedance.locallife.live.dsl.card.b(r127, this));
    L61:
        a(k(), 1);
    L63:
        LinkedHashMap r128 = new LinkedHashMap();
        r128.put("data_name", "atmosphere_info_ui_data");
        Unit r129 = Unit.INSTANCE;
        this.f259446x = new com.bytedance.locallife.live.msgcenter.b("live_life_listen_data", r128, new a(this));
        LinkedHashMap r130 = new LinkedHashMap();
        r130.put("data_name", "expound_card_ui_data");
        this.f259447y = new com.bytedance.locallife.live.msgcenter.b("live_life_listen_data", r130, new c(this));
        return;
    L47:
        if ((r124 instanceof Integer) == true) goto L49;
        r114 = LiveLifeSaaSUtil.a("live_life_card_atmosphere_area_click", r123, 0);     // Catch: Throwable -> L55
        goto L51
    L49:
        r114 = (Integer) r124;     // Catch: Throwable -> L55
        goto L51
    L50:
        r114 = LiveLifeSaaSUtil.a("live_life_card_atmosphere_area_click", r123, 0);     // Catch: Throwable -> L55
    L56:
        r126 = 0;
        goto L57
    L37:
        r121 = null;
    L62:
        r112.a();
        goto L63
    L32:
        r119 = null;
        goto L33
    L21:
        qs6.b r131 = LiveLifeSaaSUtil.t();
        StringBuilder r132 = new StringBuilder("miss cache due to version not match ");
        r132.append(r105);
        r132.append(' ');
        if (r108 == null) goto L24;
        String r133 = r108.getTemplateVersion();
    L25:
        r132.append(r133);
        r131.i("DSLCardCachedViewInfo", r132.toString());
        Map r134 = MapsKt.mapOf(TuplesKt.to("error_code", "-92"));
        int r135 = qv6.e.f534905a;
        qv6.e.a("live_life_dsl_expound_card_error", r134, false, r106.f16374a);
        goto L26
    L24:
        r133 = null;
        goto L25
    L17:
        r109 = null;
        goto L19
    L11:
        r107 = false;
    L26:
        r108 = null;
    L28:
        r108 = new com.bytedance.locallife.live.dsl.card.c(r101, D());
        goto L29
    }
}
