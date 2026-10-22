package com.bytedance.locallife.live.goodsshelves.viewholder;

import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.core.processing.util.GLUtils;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.live.api.Api;
import com.bytedance.locallife.live.goodsshelves.bean.DisplayControl;
import com.bytedance.locallife.live.goodsshelves.bean.ExecutionPlan;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import com.bytedance.locallife.live.goodsshelves.bean.LiveLocalLifeCardData;
import com.bytedance.locallife.live.goodsshelves.bean.LiveLocalLifeImageInfo;
import com.bytedance.locallife.live.goodsshelves.bean.MiniCardExtra;
import com.bytedance.locallife.live.goodsshelves.bean.PoiInfo;
import com.bytedance.locallife.live.goodsshelves.bean.TicketInfo;
import com.bytedance.locallife.live.goodsshelves.manager.ShelfDefaultTabManager;
import com.bytedance.locallife.live.goodsshelves.ui.GoodsShelvesDialogFragment;
import com.bytedance.locallife.live.goodsshelves.view.ButtonBuy;
import com.bytedance.locallife.live.goodsshelves.view.FlashSaleView;
import com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel;
import com.bytedance.locallife.live.model.GroupPurchaseFlashSale;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.util.c0;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.p;
import com.bytedance.locallife.live.util.r;
import com.bytedance.locallife.live.util.t;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.ttvideoengine.model.VideoRef;
import com.ttnet.org.chromium.base.BaseSwitches;
import df6.q;
import df6.u;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/viewholder/LiveLocalLifeGoodsShelvesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnAttachStateChangeListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeGoodsShelvesViewHolder extends RecyclerView.ViewHolder implements View.OnAttachStateChangeListener {
    public static final /* synthetic */ int T = 0;
    public final LinearLayout A;
    public final DmtTextView B;
    public final DmtTextView C;
    public final LinearLayout D;
    public final DmtTextView E;
    public final DmtTextView F;
    public final DmtTextView G;
    public final DmtTextView H;
    public final LinearLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final DmtTextView f260327J;
    public final ButtonBuy K;
    public LiveGoodsShelvesCard L;
    public LiveLocalLifeCardData M;
    public int N;
    public FragmentActivity O;
    public Boolean P;
    public boolean Q;
    public int R;
    public com.bytedance.locallife.live.goodsshelves.manager.i S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveGoodsShelvesViewModel f260328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f260329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f260330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f260331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f260332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DmtTextView f260333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SmartImageView f260334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f260335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LottieAnimationView f260336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DmtTextView f260337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SimpleDraweeView f260338k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f260339l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DmtTextView f260340m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final FlashSaleView f260341n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f260342o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DmtTextView f260343p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DmtTextView f260344q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DmtTextView f260345r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinearLayout f260346s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DmtTextView f260347t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f260348u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DmtTextView f260349v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final DmtTextView f260350w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LinearLayout f260351x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final DmtTextView f260352y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DmtTextView f260353z;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public final void V3() {
        LiveLocalLifeCardData r100 = this.M;
        String r101 = null;
        if (r100 == null) goto L7;
        PoiInfo r102 = r100.getPoi();
        if (r102 == null) goto L7;
        String r103 = r102.getPoiName();
    L8:
        int r104 = 8;
        boolean r105 = true;
        if (TextUtils.isEmpty(r103) == true) goto L11;
    L23:
        this.f260346s.setVisibility(0);
        if (this.N != 1) goto L39;
        com.bytedance.locallife.live.goodsshelves.manager.i r106 = this.S;
        if (r106 != null) goto L28;
    L30:
        boolean r107 = false;
    L31:
        if (r107 == false) goto L39;
        if (Intrinsics.areEqual(this.P, Boolean.FALSE) == false) goto L39;
        LiveLocalLifeCardData r108 = this.M;
        if (r108 == null) goto L44;
        PoiInfo r109 = r108.getPoi();
        if (r109 == null) goto L44;
        String r110 = r109.getDeliveryText();
    L46:
        if (TextUtils.isEmpty(r110) == false) goto L48;
        this.f260347t.setVisibility(8);
    L49:
        LiveLocalLifeCardData r111 = this.M;
        if (r111 == null) goto L54;
        PoiInfo r112 = r111.getPoi();
        if (r112 == null) goto L54;
        int r113 = r112.getStoreNumbers();
    L55:
        if (r113 <= 1) goto L71;
        LiveLocalLifeCardData r114 = this.M;
        if (r114 != null) goto L59;
    L61:
        boolean r115 = false;
    L62:
        if (r115 == true) goto L71;
        StringBuilder r116 = new StringBuilder("等");
        LiveLocalLifeCardData r117 = this.M;
        if (r117 == null) goto L69;
        PoiInfo r118 = r117.getPoi();
        if (r118 == null) goto L69;
        Integer r119 = Integer.valueOf(r118.getStoreNumbers());
    L70:
        r116.append(r119);
        r116.append("店通用");
        String r120 = r116.toString();
    L72:
        LiveLocalLifeCardData r121 = this.M;
        if (r121 == null) goto L77;
        PoiInfo r122 = r121.getPoi();
        if (r122 == null) goto L77;
        String r123 = r122.getPoiName();
    L79:
        if (TextUtils.isEmpty(r123) == false) goto L81;
    L98:
        this.f260349v.setVisibility(8);
        this.f260350w.setVisibility(8);
    L99:
        LinearLayout r124 = this.f260346s;
        if (this.f260349v.getVisibility() != 0) goto L102;
    L105:
        boolean r125 = true;
    L106:
        Intrinsics.checkNotNullParameter(r124, "<this>");
        if (r125 == false) goto L109;
        int r126 = 0;
    L110:
        r124.setVisibility(r126);
        View r127 = this.f260348u;
        if (this.f260349v.getVisibility() == 0) goto L113;
    L115:
        r105 = false;
    L116:
        Intrinsics.checkNotNullParameter(r127, "<this>");
        if (r105 == false) goto L119;
        r104 = 0;
    L119:
        r127.setVisibility(r104);
        return;
    L113:
        if (this.f260347t.getVisibility() != 0) goto L115;
    L109:
        r126 = 8;
        goto L110
    L102:
        if (this.f260347t.getVisibility() == 0) goto L105;
        r125 = false;
        goto L106
    L81:
        if (this.N != 1) goto L92;
        com.bytedance.locallife.live.goodsshelves.manager.i r128 = this.S;
        if (r128 != null) goto L85;
    L87:
        boolean r129 = false;
    L88:
        if (r129 == false) goto L92;
        if (Intrinsics.areEqual(this.P, Boolean.FALSE) == false) goto L92;
    L85:
        if (r128.b() == true) goto L87;
        r129 = true;
    L92:
        this.f260349v.setVisibility(0);
        this.f260350w.setVisibility(0);
        DmtTextView r130 = this.f260349v;
        LiveLocalLifeCardData r131 = this.M;
        if (r131 == null) goto L97;
        PoiInfo r132 = r131.getPoi();
        if (r132 == null) goto L97;
        r101 = r132.getPoiName();
    L97:
        r130.setText(r101);
        this.f260350w.setText(r120);
    L77:
        r123 = null;
    L69:
        r119 = null;
        goto L70
    L59:
        if (r114.getProductType() != 14) goto L61;
        r115 = true;
    L71:
        r120 = "";
    L54:
        r113 = 0;
        goto L55
    L48:
        this.f260347t.setVisibility(0);
        this.f260347t.setText(r110);
    L44:
        r110 = null;
        goto L46
    L28:
        if (r106.b() == true) goto L30;
        r107 = true;
    L39:
        LiveLocalLifeCardData r133 = this.M;
        if (r133 == null) goto L44;
        PoiInfo r134 = r133.getPoi();
        if (r134 == null) goto L44;
        r110 = r134.getPoiDistanceText();
        goto L46
    L11:
        if (this.N == 2) goto L21;
        com.bytedance.locallife.live.goodsshelves.manager.i r135 = this.S;
        if (r135 != null) goto L15;
    L17:
        boolean r136 = false;
    L18:
        if (r136 == true) goto L21;
        if (Intrinsics.areEqual(this.P, Boolean.TRUE) == false) goto L23;
    L15:
        if (r135.b() != true) goto L17;
        r136 = true;
    L21:
        this.f260346s.setVisibility(8);
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final void Y3() {
        int r100 = 0;
        this.itemView.measure(View.MeasureSpec.makeMeasureSpec(Math.min(c0.b(), c0.a()), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (this.I.getVisibility() == 8) goto L12;
        if (this.f260327J.getVisibility() == 8) goto L12;
        if (p.j(this.I) <= this.I.getMeasuredWidth()) goto L12;
        this.f260327J.setVisibility(8);
    L12:
        if (this.f260351x.getVisibility() == 8) goto L30;
        if (this.G.getVisibility() == 8) goto L30;
        if (p.j(this.f260351x) <= this.f260351x.getMeasuredWidth()) goto L30;
        Iterator r101 = CollectionsKt.listOf(new View[]{this.f260353z, this.f260352y, this.D, this.A}).iterator();
    L21:
        if (r101.hasNext() == false) goto L30;
        Object r102 = r101.next();
        int r103 = r100 + 1;
        if (r100 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        View r104 = (View) r102;
        if (r104.getVisibility() != 8) goto L27;
        r100 = r103;
        goto L21
    L27:
        r104.setVisibility(8);
    L30:
        if (((this.f260345r.getPaint().measureText(this.f260345r.getText().toString()) + this.f260345r.getPaddingLeft()) + this.f260345r.getPaddingRight()) <= this.f260345r.getMeasuredWidth()) goto L33;
        this.f260345r.setVisibility(8);
    L33:
        if (this.f260344q.getPaint().measureText(this.f260344q.getText().toString()) <= this.f260344q.getMeasuredWidth()) goto L38;
        this.f260344q.setVisibility(8);
        return;
    }

    public final HashMap<String, String> X3(LiveGoodsShelvesCard r110) {
        int r100 = t.f260731a;
        LiveGoodsShelvesViewModel r101 = this.f260328a;
        if (r101 == null) goto L6;
        String r102 = r101.getUniqueKey();
        if (r102 == null) goto L6;
    L7:
        String r103 = null;
        HashMap<String, String> r104 = t.b(r102, null);
        if (r110 == null) goto L11;
        String r105 = r110.getComponent_id();
        if (r105 == null) goto L11;
    L12:
        r104.put("product_id", r105);
        r104.put("detail_enter_page", "livebroadcasting");
        LiveGoodsShelvesViewModel r106 = this.f260328a;
        if (r106 == null) goto L16;
        String r107 = r106.getUniqueKey();
        if (r107 == null) goto L16;
    L17:
        int r108 = p.f260728a;
        r104.put("detail_enter_method", p.l(r107, r110, null, LiveGoodsShelvesViewModel.ShelfType.Normal));
        r104.put("is_recommend_product", "0");
        if (r110 == null) goto L21;
        String r109 = r110.getRequest_id();
        if (r109 == null) goto L21;
    L22:
        r104.put("spu_rec_req_id", r109);
        if (r110 == null) goto L26;
        String r111 = r110.getCli_extra();
        if (r111 == null) goto L26;
    L27:
        r104.put("server_parameter", r111);
        int r112 = p.f260728a;
        LiveGoodsShelvesViewModel r113 = this.f260328a;
        if (r113 == null) goto L31;
        String r114 = r113.getUniqueKey();
        if (r114 == null) goto L31;
    L32:
        com.bytedance.locallife.live.goodsshelves.manager.i r115 = this.S;
        int r116 = this.R;
        p.f(r114, r110, r104, r115, r116, p.s(r110, r116));
        p.h(r110, r104);
        com.bytedance.locallife.live.goodsshelves.manager.i r117 = this.S;
        if (r117 == null) goto L35;
        r103 = r117.f259723a;
    L35:
        p.a(r110, r104, r103, true);
        return r104;
    L31:
        r114 = "";
    L26:
        r111 = "";
    L21:
        r109 = "";
    L16:
        r107 = "";
    L11:
        r105 = "";
    L6:
        r102 = "";
        goto L7
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Set<String> r101 = gv6.c.f482831a;
        gv6.c.a(this.L);
    }

    public static final void T3(LiveLocalLifeGoodsShelvesViewHolder r110, LiveGoodsShelvesCard r111) {
        r110.getClass();
        if (r111 == null) goto L9;
        LiveLocalLifeCardData r100 = r111.getCard_data();
        if (r100 == null) goto L9;
        List<TicketInfo> r101 = r100.getTickets();
        if (r101 == null) goto L9;
        TicketInfo r102 = (TicketInfo) ListProtector.get(r101, 0);
    L10:
        if (r102 == null) goto L12;
        boolean r103 = Intrinsics.areEqual(r102.getSupportAutoCollect(), Boolean.TRUE);
    L13:
        if (r103 == false) goto L21;
        Api r104 = com.bytedance.locallife.live.api.a.f259156a;
        LiveGoodsShelvesViewModel r105 = r110.f260328a;
        if (r105 == null) goto L18;
        String r106 = r105.getUniqueKey();
        if (r106 == null) goto L18;
    L19:
        com.bytedance.locallife.live.api.a.a(r106, r102.getTicketMerchantId(), r102.getLaunchId(), r102.getAssignRecordId(), String.valueOf(r102.getCouponTypeNumber()), null, null, null, null, null, null, 2016).subscribe(new j(r110, r111, r102), new k(r110, r111, r102));
        return;
    L18:
        r106 = "";
        goto L19
    L21:
        if (r102 == null) goto L28;
        Integer r107 = r102.getCouponStatus();
        if (r107 == null) goto L28;
        if (r107.intValue() != 2) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == false) goto L31;
        r110.W3(r111, true);
        return;
    L31:
        r110.W3(r111, false);
        return;
    L28:
        r108 = false;
        goto L29
    L12:
        r103 = false;
    L9:
        r102 = null;
        goto L10
    }

    public final void W3(LiveGoodsShelvesCard r210, boolean r211) {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        LiveGoodsShelvesViewModel r101 = this.f260328a;
        if (r101 == null) goto L6;
        String r102 = r101.getUniqueKey();
        if (r102 == null) goto L6;
    L7:
        r100.getClass();
        LiveLocalLifeViewModel r103 = LiveLocalLifeViewModel.Companion.a(r102);
        if (r103 == null) goto L113;
        r103.setNeedRefreshWhenOnResume(r211);
    L113:
        String r104 = null;
        if (com.bytedance.locallife.live.settings.c.o() == false) goto L15;
        if (r210 == null) goto L18;
        String r105 = r210.getWeb_url();     // Catch: Exception -> L112
    L17:
        String r110 = r105;
    L20:
        if (r210 != null) goto L22;
    L24:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L47;
        Map r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to("detail_enter_page", "livebroadcasting"), TuplesKt.to("detail_enter_method", "click_shelf_card_mini")});     // Catch: Exception -> L112
        int r107 = p.f260728a;     // Catch: Exception -> L112
        LiveGoodsShelvesViewModel r108 = this.f260328a;     // Catch: Exception -> L112
        if (r108 == null) goto L31;
        String r109 = r108.getUniqueKey();     // Catch: Exception -> L112
        if (r109 == null) goto L31;
    L32:
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");     // Catch: Exception -> L112
        com.bytedance.locallife.live.goodsshelves.manager.i r112 = this.S;     // Catch: Exception -> L112
        int r113 = this.R;     // Catch: Exception -> L112
        p.f(r109, r210, (HashMap) r111, r112, r113, p.s(r210, r113));     // Catch: Exception -> L112
        int r114 = r.f260730a;     // Catch: Exception -> L112
        LiveGoodsShelvesViewModel r115 = this.f260328a;     // Catch: Exception -> L112
        if (r115 == null) goto L38;
        String r116 = r115.getUniqueKey();     // Catch: Exception -> L112
        if (r116 == null) goto L38;
        String r117 = r116;
    L39:
        FragmentActivity r118 = this.O;     // Catch: Exception -> L112
        String r119 = r210.getComponent_id();     // Catch: Exception -> L112
        MiniCardExtra r120 = r210.getMini_card_extra();     // Catch: Exception -> L112
        if (r120 == null) goto L42;
        String r121 = r120.getApp_id();     // Catch: Exception -> L112
    L43:
        MiniCardExtra r122 = r210.getMini_card_extra();     // Catch: Exception -> L112
        if (r122 == null) goto L46;
        r104 = r122.getApp_name();     // Catch: Exception -> L112
    L46:
        r.h(r117, r118, r110, "shelf_card", r119, BrowserDependency.UrlClickType.CARD, r121, r104, r111);     // Catch: Exception -> L112
        return;
    L42:
        r121 = null;
    L38:
        r117 = "";
    L31:
        r109 = "";
        goto L32
    L47:
        if (r210 == null) goto L49;
        LiveLocalLifeCardData r123 = r210.getCard_data();     // Catch: Exception -> L112
    L50:
        int r124 = r.f260730a;     // Catch: Exception -> L112
        if (r123 == null) goto L53;
        GroupPurchaseFlashSale r125 = r123.getFlashSale();     // Catch: Exception -> L112
    L54:
        if (r210 == null) goto L56;
        String r126 = r210.getCardId();     // Catch: Exception -> L112
    L57:
        String r127 = r.b(r110, r125, r126).toString();     // Catch: Exception -> L112
        int r128 = t.f260731a;     // Catch: Exception -> L112
        LiveGoodsShelvesViewModel r129 = this.f260328a;     // Catch: Exception -> L112
        if (r129 == null) goto L61;
        String r130 = r129.getUniqueKey();     // Catch: Exception -> L112
        if (r130 == null) goto L61;
    L62:
        if (r210 == null) goto L66;
        LiveLocalLifeCardData r131 = r210.getCard_data();     // Catch: Exception -> L112
        if (r131 == null) goto L66;
        String r132 = r131.getGrouponId();     // Catch: Exception -> L112
    L67:
        if (r210 == null) goto L71;
        LiveLocalLifeCardData r133 = r210.getCard_data();     // Catch: Exception -> L112
        if (r133 == null) goto L71;
        String r134 = r133.getActualAmount();     // Catch: Exception -> L112
    L72:
        t.e(r130, r132, r134);     // Catch: Exception -> L112
        LiveGoodsShelvesViewModel r135 = this.f260328a;     // Catch: Exception -> L112
        if (r135 == null) goto L76;
        String r136 = r135.getUniqueKey();     // Catch: Exception -> L112
        if (r136 == null) goto L76;
    L77:
        LiveLocalLifeViewModel r137 = LiveLocalLifeViewModel.Companion.a(r136);     // Catch: Exception -> L112
        if (r137 == null) goto L80;
        GoodsShelvesDialogFragment r138 = r137.getLastShelfDialogFragment();     // Catch: Exception -> L112
    L81:
        LiveGoodsShelvesViewModel r139 = this.f260328a;     // Catch: Exception -> L112
        if (r139 == null) goto L85;
        String r140 = r139.getUniqueKey();     // Catch: Exception -> L112
        if (r140 == null) goto L85;
    L86:
        LiveLocalLifeRoomInfo r141 = LiveLocalLifeUtil.e(r140);     // Catch: Exception -> L112
        if (r138 == null) goto L94;
        Pair[] r142 = new Pair[5];     // Catch: Exception -> L112
        r142[0] = TuplesKt.to("life_req_id", r141.getRequestId());     // Catch: Exception -> L112
        r142[1] = TuplesKt.to("life_room_id", r141.getRoomId());     // Catch: Exception -> L112
        if (r210 == null) goto L92;
        String r143 = r210.getComponent_id();     // Catch: Exception -> L112
        if (r143 == null) goto L92;
    L93:
        r142[2] = TuplesKt.to("life_product_id", r143);     // Catch: Exception -> L112
        r142[3] = TuplesKt.to("enter_from", r141.getEnterFromMerge());     // Catch: Exception -> L112
        r142[4] = TuplesKt.to("enter_method", r141.getEnterMethod());     // Catch: Exception -> L112
        String r144 = com.bytedance.locallife.biz.btm.c.d(r138, "c7378.d1113", MapsKt.mutableMapOf(r142));     // Catch: Exception -> L112
    L95:
        int r145 = com.bytedance.locallife.live.util.f.f260701a;     // Catch: Exception -> L112
        LiveGoodsShelvesViewModel r146 = this.f260328a;     // Catch: Exception -> L112
        if (r146 == null) goto L101;
        String r147 = r146.getUniqueKey();     // Catch: Exception -> L112
        if (r147 == null) goto L101;
        String r148 = r147;
    L102:
        FragmentActivity r149 = this.O;     // Catch: Exception -> L112
        if (r210 == null) goto L105;
        r104 = r210.getLynx_url();     // Catch: Exception -> L112
    L105:
        String r150 = r104;
        String r151 = t.a(X3(r210));     // Catch: Exception -> L112
        LiveGoodsShelvesViewModel r152 = this.f260328a;     // Catch: Exception -> L112
        if (r152 == null) goto L110;
        List<String> r153 = r152.getSessionIds();     // Catch: Exception -> L112
        if (r153 == null) goto L110;
        r153.add(r151);     // Catch: Exception -> L112
    L110:
        com.bytedance.locallife.live.util.f.a(r148, r149, r150, r127, r151, true, com.bytedance.locallife.live.goodsshelves.manager.j.a(this.S), null, r144, false, 640);     // Catch: Exception -> L112
        return;
    L101:
        r148 = "";
    L92:
        r143 = "";
        goto L93
    L94:
        r144 = null;
    L85:
        r140 = "";
        goto L86
    L80:
        r138 = null;
    L76:
        r136 = "";
    L71:
        r134 = null;
    L66:
        r132 = null;
    L61:
        r130 = "";
        goto L62
    L56:
        r126 = null;
        goto L57
    L53:
        r125 = null;
        goto L54
    L49:
        r123 = null;
        goto L50
    L22:
        if (r210.getLive_card_type() != 20) goto L24;
        r106 = true;
    L18:
        r110 = null;
        goto L20
    L15:
        if (r210 == null) goto L18;
        r105 = r210.getLynx_url();     // Catch: Exception -> L112
        goto L17
    L115:
        return;
    L6:
        r102 = "";
        goto L7
    }

    public LiveLocalLifeGoodsShelvesViewHolder(View r100, boolean r101, LiveGoodsShelvesViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f260328a = r102;
        this.f260329b = (LinearLayout) r100.findViewById(R.id.card_explaining_area);
        this.f260330c = (ViewGroup) r100.findViewById(R.id.card_label_layout);
        LinearLayout r103 = (LinearLayout) r100.findViewById(R.id.card_price_layout);
        this.f260331d = (SimpleDraweeView) r100.findViewById(R.id.poi_live_goods_shelves_image);
        this.f260332e = (ViewGroup) r100.findViewById(R.id.poi_live_goods_shelves_serial_number_layout);
        this.f260333f = (DmtTextView) r100.findViewById(R.id.poi_live_goods_shelves_serial_number);
        this.f260334g = (SmartImageView) r100.findViewById(R.id.poi_live_goods_shelves_image_tag);
        this.f260335h = (LinearLayout) r100.findViewById(R.id.explaining_layout);
        this.f260336i = (LottieAnimationView) r100.findViewById(R.id.explaining_lottie);
        this.f260337j = (DmtTextView) r100.findViewById(R.id.poi_live_goods_shelves_status);
        this.f260338k = (SimpleDraweeView) r100.findViewById(R.id.card_title_execution_plan_image);
        this.f260339l = (TextView) r100.findViewById(R.id.card_title_text);
        this.f260340m = (DmtTextView) r100.findViewById(R.id.price_scene_text);
        this.f260341n = (FlashSaleView) r100.findViewById(R.id.flash_sale_view);
        this.f260342o = (TextView) r100.findViewById(R.id.price_real);
        this.f260343p = (DmtTextView) r100.findViewById(R.id.tv_frequency);
        this.f260344q = (DmtTextView) r100.findViewById(R.id.origin_price);
        this.f260345r = (DmtTextView) r100.findViewById(R.id.discount_tag);
        this.f260346s = (LinearLayout) r100.findViewById(R.id.store_info_new_non_click_layout);
        this.f260347t = (DmtTextView) r100.findViewById(R.id.user_distance);
        this.f260348u = r100.findViewById(R.id.split_line);
        this.f260349v = (DmtTextView) r100.findViewById(R.id.poi_name);
        this.f260350w = (DmtTextView) r100.findViewById(R.id.poi_store_number);
        this.f260351x = (LinearLayout) r100.findViewById(R.id.service_information_layout);
        this.f260352y = (DmtTextView) r100.findViewById(R.id.service_info1);
        this.f260353z = (DmtTextView) r100.findViewById(R.id.service_info2);
        this.A = (LinearLayout) r100.findViewById(R.id.ticket_info_1_layout);
        this.B = (DmtTextView) r100.findViewById(R.id.coupon_type_1);
        this.C = (DmtTextView) r100.findViewById(R.id.ticket_info_1);
        this.D = (LinearLayout) r100.findViewById(R.id.ticket_info_2_layout);
        this.E = (DmtTextView) r100.findViewById(R.id.coupon_type_2);
        this.F = (DmtTextView) r100.findViewById(R.id.ticket_info_2);
        this.G = (DmtTextView) r100.findViewById(R.id.tickets_sold_label);
        this.H = (DmtTextView) r100.findViewById(R.id.sold_label_non_flash_and_tickets);
        this.I = (LinearLayout) r100.findViewById(R.id.flash_info_layout);
        this.f260327J = (DmtTextView) r100.findViewById(R.id.flash_sold_label);
        this.K = (ButtonBuy) r100.findViewById(R.id.btn_buy);
        this.P = Boolean.FALSE;
        this.R = ShelfDefaultTabManager.b();
        if (r101 == false) goto L6;
        r100.addOnAttachStateChangeListener(this);
        return;
    }

    public final void U3(final LiveGoodsShelvesCard r310, FragmentActivity r311, int r312, int r313, boolean r314, com.bytedance.locallife.live.goodsshelves.manager.i r315, Boolean r316) {
        this.L = r310;
        if (r310 == null) goto L5;
        LiveLocalLifeCardData r100 = r310.getCard_data();
    L6:
        this.M = r100;
        this.O = r311;
        this.N = r312;
        this.R = r313;
        this.S = r315;
        this.P = r316;
        if (r100 == null) goto L11;
        List<LiveLocalLifeImageInfo> r101 = r100.getImageInfos();
        if (r101 == null) goto L11;
        r101.size();
    L11:
        LiveLocalLifeCardData r102 = this.M;
        if (r102 == null) goto L20;
        List<LiveLocalLifeImageInfo> r103 = r102.getImageInfos();
        if (r103 == null) goto L20;
        LiveLocalLifeImageInfo r104 = (LiveLocalLifeImageInfo) ListProtector.get(r103, 0);
        if (r104 == null) goto L20;
        String r105 = r104.getWebUrl();
        if (r105 == null) goto L20;
        Ref.LongRef r106 = new Ref.LongRef();
        r106.element = SystemClock.elapsedRealtime();
        this.f260331d.setController(Fresco.newDraweeControllerBuilder().setControllerListener(new i(r106, this)).setUri(r105).build());
    L20:
        this.f260332e.setVisibility(0);
        DmtTextView r107 = this.f260333f;
        LiveGoodsShelvesCard r108 = this.L;
        if (r108 == null) goto L23;
        String r109 = Integer.valueOf(r108.getLocalOrder()).toString();
    L24:
        r107.setText(r109);
        this.f260333f.setBackgroundResource(R.drawable.bg_live_local_life_order);
        LiveLocalLifeCardData r110 = this.M;
        if (r110 == null) goto L27;
        String r111 = r110.getImageTagUrl();
    L29:
        if (TextUtils.isEmpty(r111) == true) goto L35;
        this.f260334g.setVisibility(0);
        LiveLocalLifeCardData r112 = this.M;
        if (r112 == null) goto L33;
        String r113 = r112.getImageTagUrl();
    L34:
        u r114 = q.d(r113);
        r114.b("LiveLocalLifeGoodsShelvesViewHolder");
        r114.f468294t = this.f260334g;
        r114.d(new h(this));
    L36:
        int r115 = getPosition();
        int r116 = this.R;
        LiveGoodsShelvesCard r117 = this.L;
        if (r117 != null) goto L39;
    L41:
        boolean r118 = false;
    L43:
        if (r118 == false) goto L49;
        if (r116 == 2) goto L49;
        this.f260336i.setAnimation("poi_live_goods_shelves_explaining.json");
        this.f260336i.playAnimation();
        this.f260336i.loop(true);
        this.f260335h.setVisibility(0);
        if (r115 != 0) goto L48;
        this.f260329b.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.live_life_shelf_explaining_area));
    L51:
        if (p.w(this.M) == true) goto L54;
        this.f260337j.setVisibility(0);
        this.f260337j.setText("- 即将开售 -");
    L89:
        LiveLocalLifeCardData r119 = this.M;
        if (r119 == null) goto L94;
        ExecutionPlan r120 = r119.getExecutionPlan();
        if (r120 == null) goto L94;
        String r121 = r120.getTagUrl();
    L96:
        if (TextUtils.isEmpty(r121) == true) goto L104;
        PipelineDraweeControllerBuilder r122 = Fresco.newDraweeControllerBuilder().setOldController(this.f260338k.getController()).setControllerListener(new e(this));
        LiveLocalLifeCardData r123 = this.M;
        if (r123 == null) goto L102;
        ExecutionPlan r124 = r123.getExecutionPlan();
        if (r124 == null) goto L102;
        String r125 = r124.getTagUrl();
    L103:
        this.f260338k.setController(r122.setUri(r125).build());
        this.f260338k.setVisibility(0);
    L105:
        TextView r126 = this.f260339l;
        LiveLocalLifeCardData r127 = this.M;
        if (r127 == null) goto L108;
        String r128 = r127.getCardTitle();
    L109:
        r126.setText(r128);
        com.bytedance.locallife.live.goodsshelves.manager.i r129 = this.S;
        if (r129 != null) goto L112;
    L114:
        boolean r130 = false;
    L115:
        if (r130 == true) goto L117;
    L121:
        if (r129 != null) goto L123;
    L125:
        boolean r131 = false;
    L126:
        if (r131 == false) goto L128;
    L133:
        V3();
    L134:
        LiveLocalLifeCardData r132 = this.M;
        if (r132 == null) goto L137;
        List<TicketInfo> r133 = r132.getTickets();
    L138:
        LiveLocalLifeCardData r134 = this.M;
        if (r134 == null) goto L141;
        List<TicketInfo> r135 = r134.getTickets();
    L142:
        if (r135 == null) goto L163;
        LiveLocalLifeCardData r136 = this.M;
        if (r136 == null) goto L150;
        List<TicketInfo> r137 = r136.getTickets();
        if (r137 == null) goto L150;
        if (r137.size() != 0) goto L150;
        boolean r138 = true;
    L151:
        if (r138 == true) goto L162;
        LiveLocalLifeCardData r139 = this.M;
        if (r139 == null) goto L159;
        List<TicketInfo> r140 = r139.getTickets();
        if (r140 == null) goto L159;
        TicketInfo r141 = (TicketInfo) ListProtector.get(r140, 0);
        if (r141 == null) goto L159;
        String r142 = r141.getPostTicketPrice();
    L161:
        if (TextUtils.isEmpty(r142) == false) goto L163;
    L159:
        r142 = null;
    L162:
        r133 = null;
    L150:
        r138 = false;
    L163:
        if (r133 != null) goto L177;
        LiveLocalLifeCardData r143 = this.M;
        if (r143 == null) goto L167;
        List<String> r144 = r143.getRightList();
    L168:
        List<String> r145 = r144;
        if (r145 != null) goto L171;
    L174:
        boolean r146 = true;
    L175:
        if (r146 == false) goto L177;
        this.f260351x.setVisibility(8);
    L352:
        LiveLocalLifeCardData r147 = this.M;
        if (r147 == null) goto L355;
        String r148 = r147.getSoldCount();
    L356:
        String r149 = "";
        if (TextUtils.isEmpty(r148) == false) goto L359;
        this.G.setText("");
    L364:
        LiveLocalLifeCardData r150 = this.M;
        if (r150 == null) goto L367;
        String r151 = r150.getSoldCount();
    L369:
        if (TextUtils.isEmpty(r151) == false) goto L371;
        this.f260327J.setText("");
    L377:
        if (p.v(this.M) == false) goto L383;
        this.I.setVisibility(0);
        this.f260351x.setVisibility(8);
        FlashSaleView r152 = this.f260341n;
        LiveLocalLifeCardData r153 = this.M;
        if (r153 == null) goto L381;
        GroupPurchaseFlashSale r154 = r153.getFlashSale();
    L382:
        r152.a(r154);
    L385:
        if (this.f260351x.getVisibility() == 8) goto L387;
    L400:
        this.H.setVisibility(8);
    L401:
        this.f260339l.getViewTreeObserver().addOnPreDrawListener(new g(this));
        LiveLocalLifeCardData r155 = this.M;
        if (r155 == null) goto L406;
        DisplayControl r156 = r155.getDisplayControl();
        if (r156 == null) goto L406;
        String r157 = r156.getPrefixPrice();
    L408:
        if (TextUtils.isEmpty(r157) == true) goto L416;
        this.f260340m.setVisibility(0);
        DmtTextView r158 = this.f260340m;
        LiveLocalLifeCardData r159 = this.M;
        if (r159 == null) goto L414;
        DisplayControl r160 = r159.getDisplayControl();
        if (r160 == null) goto L414;
        String r161 = r160.getPrefixPrice();
    L415:
        r158.setText(r161);
    L417:
        LiveLocalLifeCardData r162 = this.M;
        if (r162 == null) goto L424;
        String r163 = r162.getActualAmount();
        if (r163 == null) goto L424;
        String r210 = StringsKt.replace$default(r163, "￥", "", false, 4, null);
        if (r210 == null) goto L424;
        String r164 = StringsKt.replace$default(r210, "¥", "", false, 4, null);
    L425:
        LiveLocalLifeCardData r165 = this.M;
        if (r165 == null) goto L428;
        List<TicketInfo> r166 = r165.getTickets();
    L429:
        if (r166 == null) goto L438;
        LiveLocalLifeCardData r167 = this.M;
        if (r167 == null) goto L435;
        List<TicketInfo> r168 = r167.getTickets();
        if (r168 == null) goto L435;
        int r169 = r168.size();
    L436:
        if (r169 <= 0) goto L438;
        boolean r170 = true;
    L439:
        if (r170 == false) goto L463;
        LiveLocalLifeCardData r171 = this.M;
        if (r171 == null) goto L447;
        List<TicketInfo> r172 = r171.getTickets();
        if (r172 == null) goto L447;
        TicketInfo r173 = (TicketInfo) ListProtector.get(r172, 0);
        if (r173 == null) goto L447;
        String r174 = r173.getPostTicketPrice();
    L449:
        if (TextUtils.isEmpty(r174) == true) goto L463;
        LiveLocalLifeCardData r175 = this.M;
        if (r175 == null) goto L461;
        List<TicketInfo> r176 = r175.getTickets();
        if (r176 == null) goto L461;
        TicketInfo r177 = (TicketInfo) ListProtector.get(r176, 0);
        if (r177 == null) goto L461;
        String r178 = r177.getPostTicketPrice();
        if (r178 == null) goto L461;
        String r211 = StringsKt.replace$default(r178, "￥", "", false, 4, null);
        if (r211 == null) goto L461;
        r164 = StringsKt.replace$default(r211, "¥", "", false, 4, null);
    L497:
        if (r164 == null) goto L506;
        String r179 = this.itemView.getContext().getResources().getString(R.string.live_local_life_shelf_card_price_label);
        StringBuilder r180 = new StringBuilder();
        r180.append(r179);
        r180.append(r164);
        SpannableString r181 = new SpannableString(r180);
        int r182 = r180.indexOf(r179);
        int r183 = r180.indexOf(".");
        if (r182 < 0) goto L502;
        r181.setSpan(new AbsoluteSizeSpan(j0.c(13)), 0, r182 + 1, 33);     // Catch: Exception -> L640
    L505:
        this.f260342o.setVisibility(0);
        this.f260342o.setText(r181);
    L502:
        if (r183 < 0) goto L504;
        r181.setSpan(new AbsoluteSizeSpan(j0.c(17)), r182 + 1, r183, 33);     // Catch: Exception -> L640
        r181.setSpan(new AbsoluteSizeSpan(j0.c(13)), r183 + 1, r180.length(), 33);     // Catch: Exception -> L640
        goto L505
    L504:
        r181.setSpan(new AbsoluteSizeSpan(j0.c(17)), r182 + 1, r180.length(), 33);     // Catch: Exception -> L640
    L506:
        DmtTextView r184 = this.f260343p;
        LiveGoodsShelvesCard r185 = this.L;
        if (r185 == null) goto L513;
        LiveLocalLifeCardData r186 = r185.getCard_data();
        if (r186 == null) goto L513;
        if (r186.getProductType() != 15) goto L513;
        boolean r187 = true;
    L514:
        if (r187 == false) goto L523;
        LiveGoodsShelvesCard r188 = this.L;
        if (r188 == null) goto L520;
        LiveLocalLifeCardData r189 = r188.getCard_data();
        if (r189 == null) goto L520;
        int r190 = r189.getConsumptionTimes();
    L521:
        if (r190 <= 0) goto L523;
        int r191 = 0;
    L524:
        r184.setVisibility(r191);
        DmtTextView r192 = this.f260343p;
        StringBuilder r193 = new StringBuilder(HTTP.URL_DEFAULT);
        LiveGoodsShelvesCard r194 = this.L;
        if (r194 == null) goto L529;
        LiveLocalLifeCardData r195 = r194.getCard_data();
        if (r195 == null) goto L529;
        Integer r196 = Integer.valueOf(r195.getConsumptionTimes());
    L530:
        r193.append(r196);
        r193.append(27425);
        r192.setText(r193.toString());
        LiveLocalLifeCardData r197 = this.M;
        if (r197 == null) goto L535;
        String r198 = r197.getOriginAmount();
        if (r198 == null) goto L535;
        int r199 = r198.length();
    L537:
        if (r199 <= 1) goto L555;
        if (r164 == null) goto L552;
        LiveLocalLifeCardData r200 = this.M;
        if (r200 == null) goto L548;
        String r201 = r200.getOriginAmount();
        if (r201 == null) goto L548;
        int r202 = r201.length();
        LiveLocalLifeCardData r203 = this.M;
        if (r203 == null) goto L548;
        String r204 = r203.getOriginAmount();
        if (r204 == null) goto L548;
        String r205 = r204.substring(1, r202);
    L550:
        if (r164.equals(r205) != true) goto L552;
        boolean r206 = true;
    L553:
        if (r206 == false) goto L555;
        this.f260344q.setVisibility(8);
    L588:
        int r207 = 8;
    L591:
        if (this.Q == false) goto L593;
        this.f260345r.setVisibility(r207);
    L638:
        this.itemView.setOnClickListener(new f(this, r311, r310, r312, r315, r316, r314, r313));
        this.K.y(this.M, r310, new LiveLocalLifeGoodsShelvesViewHolder$bind$2(this, r310), qv6.d.m(r310, r312, r315, r316), r314, r313, r315, this.f260328a);
        Y3();
        return;
    L593:
        LiveLocalLifeCardData r208 = this.M;
        if (r208 == null) goto L598;
        String r209 = r208.getOriginAmount();
        if (r209 == null) goto L598;
        int r212 = r209.length();
    L600:
        if (r212 <= 1) goto L619;
        if (r164 == null) goto L615;
        LiveLocalLifeCardData r213 = this.M;
        if (r213 == null) goto L611;
        String r214 = r213.getOriginAmount();
        if (r214 == null) goto L611;
        int r215 = r214.length();
        LiveLocalLifeCardData r216 = this.M;
        if (r216 == null) goto L611;
        String r217 = r216.getOriginAmount();
        if (r217 == null) goto L611;
        String r218 = r217.substring(1, r215);
    L613:
        if (r164.equals(r218) != true) goto L615;
        boolean r219 = true;
    L616:
        if (r219 == false) goto L619;
        this.f260345r.setVisibility(8);
    L611:
        r218 = null;
    L615:
        r219 = false;
    L619:
        if (this.f260340m.getVisibility() != 0) goto L621;
        this.f260345r.setVisibility(8);
        goto L638
    L621:
        DmtTextView r220 = this.f260345r;
        LiveGoodsShelvesCard r221 = this.L;
        if (r221 == null) goto L626;
        LiveLocalLifeCardData r222 = r221.getCard_data();
        if (r222 == null) goto L626;
        String r223 = r222.getDiscount();
    L627:
        r220.setText(r223);
        DmtTextView r224 = this.f260345r;
        LiveGoodsShelvesCard r225 = this.L;
        if (r225 == null) goto L632;
        LiveLocalLifeCardData r226 = r225.getCard_data();
        if (r226 == null) goto L632;
        String r1100 = r226.getDiscount();
    L634:
        if (TextUtils.isEmpty(r1100) == false) goto L636;
        int r227 = 8;
    L637:
        r224.setVisibility(r227);
        goto L638
    L636:
        r227 = 0;
    L632:
        r1100 = null;
    L626:
        r223 = null;
    L598:
        r212 = 0;
    L548:
        r205 = null;
    L552:
        r206 = false;
    L555:
        TextPaint r228 = this.f260344q.getPaint();
        if (r228 == null) goto L566;
        LiveLocalLifeCardData r229 = this.M;
        if (r229 == null) goto L565;
        String r230 = r229.getOriginAmount();
        if (r230 == null) goto L565;
        String r231 = j0.d(r230);
        if (r231 == null) goto L565;
        r149 = r231;
    L565:
        Float r232 = Float.valueOf(r228.measureText(r149));
    L567:
        this.f260340m.measure(0, 0);
        this.f260342o.measure(0, 0);
        this.f260343p.measure(0, 0);
        float r233 = ((((c0.b() - j0.c(VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2)) - this.f260340m.getMeasuredWidth()) - this.f260342o.getMeasuredWidth()) - this.f260343p.getMeasuredWidth()) - j0.c(4);
        if (r232 == null) goto L570;
        float r234 = r232.floatValue();
    L572:
        if ((r233 - r234) <= 0) goto L589;
        DmtTextView r235 = this.f260344q;
        LiveLocalLifeCardData r236 = this.M;
        if (r236 == null) goto L576;
        String r237 = r236.getOriginAmount();
    L578:
        if (TextUtils.isEmpty(r237) == false) goto L580;
        int r238 = 8;
    L581:
        r235.setVisibility(r238);
        DmtTextView r239 = this.f260344q;
        LiveLocalLifeCardData r240 = this.M;
        if (r240 == null) goto L586;
        String r241 = r240.getOriginAmount();
        if (r241 == null) goto L586;
        String r242 = j0.d(r241);
    L587:
        r239.setText(r242);
        this.f260344q.setPaintFlags(16);
        this.Q = false;
    L586:
        r242 = null;
        goto L587
    L580:
        r238 = 0;
        goto L581
    L576:
        r237 = null;
        goto L578
    L589:
        r207 = 8;
        this.f260344q.setVisibility(8);
        this.Q = true;
        goto L591
    L570:
        r234 = 0.0f;
        goto L572
    L566:
        r232 = null;
    L535:
        r199 = 0;
    L529:
        r196 = null;
    L520:
        r190 = 0;
    L523:
        r191 = 8;
    L513:
        r187 = false;
    L461:
        r164 = null;
    L447:
        r174 = null;
    L463:
        if (p.t(this.M) == false) goto L497;
        LiveLocalLifeCardData r243 = this.M;
        if (r243 == null) goto L469;
        GroupPurchaseFlashSale r244 = r243.getFlashSale();
        if (r244 == null) goto L469;
        Float r245 = Float.valueOf(r244.getFlashSalePrice() / 100.0f);
    L470:
        if (r245 != null) goto L472;
        String r1101 = "";
    L496:
        r164 = StringsKt.replace$default(r1101, "￥", "", false, 4, null);
        goto L497
    L472:
        if (r245.floatValue() >= 10000) goto L487;
        String r246 = new DecimalFormat("0.00").format(r245);
        if (StringsKt.indexOf$default(r246, ".00", 0, false, 6, null) == (-1)) goto L477;
        r246 = StringsKt.replace$default(r246, ".00", "", false, 4, null);
    L486:
        String r247 = "￥" + r246;
    L494:
        r1101 = r247;
        goto L496
    L477:
        if (StringsKt.indexOf$default(r246, ".", 0, false, 6, null) == (-1)) goto L486;
        if (r246.charAt(r246.length() - 1) != '0') goto L486;
        if (r246.length() <= 0) goto L483;
        boolean r248 = true;
    L484:
        if (r248 == false) goto L486;
        r246 = r246.substring(0, r246.length() - 1);
        goto L486
    L483:
        r248 = false;
        goto L484
    L487:
        LiveLocalLifeCardData r249 = this.M;
        if (r249 == null) goto L492;
        GroupPurchaseFlashSale r250 = r249.getFlashSale();
        if (r250 == null) goto L492;
        Float r251 = Float.valueOf(r250.getFlashSalePrice() / 1000000.0f);
    L493:
        r247 = "￥" + new DecimalFormat(GLUtils.VERSION_UNKNOWN).format(r251) + 19975;
    L492:
        r251 = null;
    L469:
        r245 = null;
    L435:
        r169 = 0;
    L438:
        r170 = false;
        goto L439
    L428:
        r166 = null;
    L424:
        r164 = null;
    L414:
        r161 = null;
        goto L415
    L416:
        this.f260340m.setVisibility(8);
        this.f260340m.setText("");
    L406:
        r157 = null;
        goto L408
    L387:
        if (this.I.getVisibility() != 8) goto L400;
        this.H.setVisibility(0);
        LiveLocalLifeCardData r252 = this.M;
        if (r252 == null) goto L391;
        String r253 = r252.getSoldCount();
    L393:
        if (TextUtils.isEmpty(r253) == false) goto L395;
        this.H.setText("");
        goto L401
    L395:
        DmtTextView r254 = this.H;
        StringBuilder r255 = new StringBuilder("已售");
        LiveLocalLifeCardData r256 = this.M;
        if (r256 == null) goto L398;
        String r257 = r256.getSoldCount();
    L399:
        r255.append(r257);
        r254.setText(r255.toString());
        goto L401
    L398:
        r257 = null;
        goto L399
    L391:
        r253 = null;
        goto L393
    L381:
        r154 = null;
        goto L382
    L383:
        this.I.setVisibility(8);
        goto L385
    L371:
        DmtTextView r258 = this.f260327J;
        StringBuilder r259 = new StringBuilder("已售");
        LiveLocalLifeCardData r260 = this.M;
        if (r260 == null) goto L374;
        String r261 = r260.getSoldCount();
    L375:
        r259.append(r261);
        r258.setText(r259.toString());
        goto L377
    L374:
        r261 = null;
        goto L375
    L367:
        r151 = null;
        goto L369
    L359:
        DmtTextView r262 = this.G;
        StringBuilder r263 = new StringBuilder("已售");
        LiveLocalLifeCardData r264 = this.M;
        if (r264 == null) goto L362;
        String r265 = r264.getSoldCount();
    L363:
        r263.append(r265);
        r262.setText(r263.toString());
        goto L364
    L362:
        r265 = null;
        goto L363
    L355:
        r148 = null;
        goto L356
    L171:
        if (r145.isEmpty() == true) goto L174;
        r146 = false;
        goto L175
    L167:
        r144 = null;
    L177:
        if (r133 == null) goto L314;
        int r266 = this.N;
        if (r266 == 1) goto L237;
        if (r266 == 2) goto L237;
        this.f260352y.setVisibility(8);
        this.f260353z.setVisibility(8);
        if (r133.size() != 1) goto L202;
        this.f260351x.setVisibility(0);
        this.A.setVisibility(0);
        this.D.setVisibility(8);
        DmtTextView r267 = this.B;
        LiveLocalLifeCardData r268 = this.M;
        if (r268 == null) goto L191;
        List<TicketInfo> r269 = r268.getTickets();
        if (r269 == null) goto L191;
        TicketInfo r270 = (TicketInfo) ListProtector.get(r269, 0);
        if (r270 == null) goto L191;
        String r271 = r270.getCouponType();
    L192:
        r267.setText(r271);
        DmtTextView r272 = this.C;
        LiveLocalLifeCardData r273 = this.M;
        if (r273 == null) goto L199;
        List<TicketInfo> r274 = r273.getTickets();
        if (r274 == null) goto L199;
        TicketInfo r275 = (TicketInfo) ListProtector.get(r274, 0);
        if (r275 == null) goto L199;
        String r276 = r275.getCouponRule();
    L200:
        r272.setText(r276);
    L199:
        r276 = null;
    L191:
        r271 = null;
        goto L192
    L202:
        if (r133.size() < 2) goto L352;
        this.f260351x.setVisibility(0);
        this.A.setVisibility(0);
        this.D.setVisibility(0);
        DmtTextView r277 = this.B;
        LiveLocalLifeCardData r278 = this.M;
        if (r278 == null) goto L210;
        List<TicketInfo> r279 = r278.getTickets();
        if (r279 == null) goto L210;
        TicketInfo r280 = (TicketInfo) ListProtector.get(r279, 0);
        if (r280 == null) goto L210;
        String r281 = r280.getCouponType();
    L211:
        r277.setText(r281);
        DmtTextView r282 = this.C;
        LiveLocalLifeCardData r283 = this.M;
        if (r283 == null) goto L218;
        List<TicketInfo> r284 = r283.getTickets();
        if (r284 == null) goto L218;
        TicketInfo r285 = (TicketInfo) ListProtector.get(r284, 0);
        if (r285 == null) goto L218;
        String r286 = r285.getCouponRule();
    L219:
        r282.setText(r286);
        DmtTextView r287 = this.E;
        LiveLocalLifeCardData r288 = this.M;
        if (r288 == null) goto L226;
        List<TicketInfo> r289 = r288.getTickets();
        if (r289 == null) goto L226;
        TicketInfo r290 = (TicketInfo) ListProtector.get(r289, 1);
        if (r290 == null) goto L226;
        String r291 = r290.getCouponType();
    L227:
        r287.setText(r291);
        DmtTextView r292 = this.F;
        LiveLocalLifeCardData r293 = this.M;
        if (r293 == null) goto L234;
        List<TicketInfo> r294 = r293.getTickets();
        if (r294 == null) goto L234;
        TicketInfo r295 = (TicketInfo) ListProtector.get(r294, 1);
        if (r295 == null) goto L234;
        String r296 = r295.getCouponRule();
    L235:
        r292.setText(r296);
    L234:
        r296 = null;
    L226:
        r291 = null;
    L218:
        r286 = null;
    L210:
        r281 = null;
    L237:
        if (r133.size() != 1) goto L280;
        this.f260351x.setVisibility(0);
        this.A.setVisibility(0);
        this.D.setVisibility(8);
        DmtTextView r297 = this.B;
        LiveLocalLifeCardData r298 = this.M;
        if (r298 == null) goto L245;
        List<TicketInfo> r299 = r298.getTickets();
        if (r299 == null) goto L245;
        TicketInfo r300 = (TicketInfo) ListProtector.get(r299, 0);
        if (r300 == null) goto L245;
        String r301 = r300.getCouponType();
    L246:
        r297.setText(r301);
        DmtTextView r302 = this.C;
        LiveLocalLifeCardData r303 = this.M;
        if (r303 == null) goto L253;
        List<TicketInfo> r304 = r303.getTickets();
        if (r304 == null) goto L253;
        TicketInfo r305 = (TicketInfo) ListProtector.get(r304, 0);
        if (r305 == null) goto L253;
        String r306 = r305.getCouponRule();
    L254:
        r302.setText(r306);
        LiveLocalLifeCardData r307 = this.M;
        if (r307 == null) goto L257;
        List<String> r308 = r307.getRightList();
    L258:
        if (r308 == null) goto L273;
        LiveLocalLifeCardData r309 = this.M;
        if (r309 == null) goto L264;
        List<String> r317 = r309.getRightList();
        if (r317 == null) goto L264;
        int r318 = r317.size();
    L265:
        if (r318 <= 0) goto L273;
        this.f260352y.setVisibility(0);
        this.f260353z.setVisibility(8);
        DmtTextView r319 = this.f260352y;
        LiveLocalLifeCardData r320 = this.M;
        if (r320 == null) goto L271;
        List<String> r321 = r320.getRightList();
        if (r321 == null) goto L271;
        String r322 = (String) ListProtector.get(r321, 0);
    L272:
        r319.setText(r322);
    L271:
        r322 = null;
    L264:
        r318 = 0;
    L273:
        LiveLocalLifeCardData r323 = this.M;
        if (r323 == null) goto L276;
        List<String> r324 = r323.getRightList();
    L277:
        if (r324 != null) goto L352;
        this.f260352y.setVisibility(8);
        this.f260353z.setVisibility(8);
        goto L352
    L276:
        r324 = null;
        goto L277
    L257:
        r308 = null;
    L253:
        r306 = null;
    L245:
        r301 = null;
        goto L246
    L280:
        if (r133.size() < 2) goto L352;
        this.f260351x.setVisibility(0);
        this.A.setVisibility(0);
        this.D.setVisibility(0);
        DmtTextView r325 = this.B;
        LiveLocalLifeCardData r326 = this.M;
        if (r326 == null) goto L288;
        List<TicketInfo> r327 = r326.getTickets();
        if (r327 == null) goto L288;
        TicketInfo r328 = (TicketInfo) ListProtector.get(r327, 0);
        if (r328 == null) goto L288;
        String r329 = r328.getCouponType();
    L289:
        r325.setText(r329);
        DmtTextView r330 = this.C;
        LiveLocalLifeCardData r331 = this.M;
        if (r331 == null) goto L296;
        List<TicketInfo> r332 = r331.getTickets();
        if (r332 == null) goto L296;
        TicketInfo r333 = (TicketInfo) ListProtector.get(r332, 0);
        if (r333 == null) goto L296;
        String r334 = r333.getCouponRule();
    L297:
        r330.setText(r334);
        DmtTextView r335 = this.E;
        LiveLocalLifeCardData r336 = this.M;
        if (r336 == null) goto L304;
        List<TicketInfo> r337 = r336.getTickets();
        if (r337 == null) goto L304;
        TicketInfo r338 = (TicketInfo) ListProtector.get(r337, 1);
        if (r338 == null) goto L304;
        String r339 = r338.getCouponType();
    L305:
        r335.setText(r339);
        DmtTextView r340 = this.F;
        LiveLocalLifeCardData r341 = this.M;
        if (r341 == null) goto L312;
        List<TicketInfo> r342 = r341.getTickets();
        if (r342 == null) goto L312;
        TicketInfo r343 = (TicketInfo) ListProtector.get(r342, 1);
        if (r343 == null) goto L312;
        String r344 = r343.getCouponRule();
    L313:
        r340.setText(r344);
        this.f260352y.setVisibility(8);
        this.f260353z.setVisibility(8);
    L312:
        r344 = null;
    L304:
        r339 = null;
    L296:
        r334 = null;
    L288:
        r329 = null;
        goto L289
    L314:
        LiveLocalLifeCardData r345 = this.M;
        if (r345 == null) goto L317;
        List<String> r346 = r345.getRightList();
    L318:
        List<String> r347 = r346;
        if (r347 != null) goto L321;
    L324:
        boolean r348 = true;
    L325:
        if (r348 == true) goto L352;
        int r349 = this.N;
        if (r349 == 1) goto L331;
        if (r349 == 2) goto L331;
        this.f260351x.setVisibility(8);
    L331:
        this.A.setVisibility(8);
        this.D.setVisibility(8);
        this.f260351x.setVisibility(0);
        DmtTextView r350 = this.f260352y;
        LiveLocalLifeCardData r351 = this.M;
        if (r351 == null) goto L336;
        List<String> r352 = r351.getRightList();
        if (r352 == null) goto L336;
        String r353 = (String) ListProtector.get(r352, 0);
    L337:
        r350.setText(r353);
        this.f260352y.setVisibility(0);
        LiveLocalLifeCardData r354 = this.M;
        if (r354 == null) goto L342;
        List<String> r355 = r354.getRightList();
        if (r355 == null) goto L342;
        int r356 = r355.size();
    L343:
        if (r356 <= 1) goto L351;
        DmtTextView r357 = this.f260353z;
        LiveLocalLifeCardData r358 = this.M;
        if (r358 == null) goto L349;
        List<String> r359 = r358.getRightList();
        if (r359 == null) goto L349;
        String r360 = (String) ListProtector.get(r359, 1);
    L350:
        r357.setText(r360);
        this.f260353z.setVisibility(0);
    L349:
        r360 = null;
        goto L350
    L351:
        this.f260353z.setVisibility(8);
    L342:
        r356 = 0;
    L336:
        r353 = null;
        goto L337
    L321:
        if (r347.isEmpty() == true) goto L324;
        r348 = false;
        goto L325
    L317:
        r346 = null;
        goto L318
    L141:
        r135 = null;
        goto L142
    L137:
        r133 = null;
        goto L138
    L128:
        if (Intrinsics.areEqual(this.P, Boolean.TRUE) == true) goto L133;
        if (this.N == 2) goto L133;
        this.f260346s.setVisibility(8);
        goto L134
    L123:
        if (r129.b() != true) goto L125;
        r131 = true;
        goto L126
    L117:
        if (Intrinsics.areEqual(this.P, Boolean.FALSE) == false) goto L121;
        if (this.N != 1) goto L121;
        V3();
        goto L134
    L112:
        if (r129.b() == true) goto L114;
        r130 = true;
        goto L115
    L108:
        r128 = null;
    L102:
        r125 = null;
        goto L103
    L104:
        this.f260338k.setVisibility(8);
    L94:
        r121 = null;
        goto L96
    L54:
        if (p.t(this.M) == false) goto L77;
        LiveLocalLifeCardData r361 = this.M;
        if (r361 == null) goto L63;
        Long r362 = r361.getStock();
        if (r362 == null) goto L63;
        if (r362.longValue() != 0) goto L63;
        boolean r363 = true;
    L64:
        if (r363 == true) goto L76;
        LiveLocalLifeCardData r364 = this.M;
        if (r364 == null) goto L72;
        GroupPurchaseFlashSale r365 = r364.getFlashSale();
        if (r365 == null) goto L72;
        if (r365.getLeftQuantity() != 0) goto L72;
        boolean r366 = true;
    L73:
        if (r366 == true) goto L76;
        this.f260337j.setVisibility(8);
    L72:
        r366 = false;
    L76:
        this.f260337j.setVisibility(0);
        this.f260337j.setText("- 已抢光 -");
    L63:
        r363 = false;
        goto L64
    L77:
        LiveLocalLifeCardData r367 = this.M;
        if (r367 == null) goto L85;
        Long r368 = r367.getStock();
        if (r368 == null) goto L85;
        if (r368.longValue() != 0) goto L85;
        boolean r369 = true;
    L86:
        if (r369 == false) goto L88;
        this.f260337j.setVisibility(0);
        this.f260337j.setText("- 已抢光 -");
        goto L89
    L88:
        this.f260337j.setVisibility(8);
    L85:
        r369 = false;
        goto L86
    L48:
        this.f260329b.setBackgroundColor(-1);
    L49:
        this.f260335h.setVisibility(8);
        this.f260329b.setBackgroundColor(-1);
        goto L51
    L39:
        if (r117.is_showing() != true) goto L41;
        r118 = true;
        goto L43
    L33:
        r113 = null;
        goto L34
    L35:
        this.f260334g.setVisibility(8);
        goto L36
    L27:
        r111 = null;
        goto L29
    L23:
        r109 = null;
        goto L24
    L5:
        r100 = null;
        goto L6
    }
}
