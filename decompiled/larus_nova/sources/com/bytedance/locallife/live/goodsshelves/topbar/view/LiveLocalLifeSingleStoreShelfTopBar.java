package com.bytedance.locallife.live.goodsshelves.topbar.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesResponse;
import com.bytedance.locallife.live.goodsshelves.bean.LiveLocalLifeCardBanner;
import com.bytedance.locallife.live.goodsshelves.bean.MemberSchema;
import com.bytedance.locallife.live.goodsshelves.bean.h0;
import com.bytedance.locallife.live.goodsshelves.manager.i;
import com.bytedance.locallife.live.goodsshelves.ui.GoodsShelvesContentFragment;
import com.bytedance.locallife.live.util.p;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001FB'\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010ER$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010%\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006G"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/topbar/view/LiveLocalLifeSingleStoreShelfTopBar;", "Lcom/bytedance/locallife/live/goodsshelves/topbar/view/BaseLiveLocalLifeSingleStoreShelfTopBar;", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "getPoiNameLayout", "()Landroid/widget/LinearLayout;", "setPoiNameLayout", "(Landroid/widget/LinearLayout;)V", "poiNameLayout", "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", "d", "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", "getPoiName", "()Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", "setPoiName", "(Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;)V", "poiName", "e", "getUserDistance", "setUserDistance", "userDistance", "f", "getPoiCity", "setPoiCity", "poiCity", "Landroid/view/View;", ce.f26391f, "Landroid/view/View;", "getSplitLine", "()Landroid/view/View;", "setSplitLine", "(Landroid/view/View;)V", "splitLine", "h", "getPoiDistrictTown", "setPoiDistrictTown", "poiDistrictTown", "Lcom/bytedance/locallife/live/goodsshelves/topbar/view/LiveLocalLifeTopBarFunctionView;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/locallife/live/goodsshelves/topbar/view/LiveLocalLifeTopBarFunctionView;", "getFuntionView", "()Lcom/bytedance/locallife/live/goodsshelves/topbar/view/LiveLocalLifeTopBarFunctionView;", "setFuntionView", "(Lcom/bytedance/locallife/live/goodsshelves/topbar/view/LiveLocalLifeTopBarFunctionView;)V", "funtionView", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;", ce.f26395j, "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;", "getCardBanner", "()Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;", "setCardBanner", "(Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;)V", "cardBanner", "Lcom/bytedance/locallife/live/goodsshelves/manager/i;", ce.f26396k, "Lcom/bytedance/locallife/live/goodsshelves/manager/i;", "getCouponMigrationInfo", "()Lcom/bytedance/locallife/live/goodsshelves/manager/i;", "setCouponMigrationInfo", "(Lcom/bytedance/locallife/live/goodsshelves/manager/i;)V", "couponMigrationInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeSingleStoreShelfTopBar extends BaseLiveLocalLifeSingleStoreShelfTopBar {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f259920l = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f259921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DmtTextView f259922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DmtTextView f259923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DmtTextView f259924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f259925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DmtTextView f259926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LiveLocalLifeTopBarFunctionView f259927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveLocalLifeCardBanner f259928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f259929k;

    public static final class a {
    }

    static {
    }

    public LiveLocalLifeSingleStoreShelfTopBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLocalLifeSingleStoreShelfTopBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final LiveLocalLifeCardBanner getCardBanner() {
        return this.f259928j;
    }

    public final i getCouponMigrationInfo() {
        return this.f259929k;
    }

    public final LiveLocalLifeTopBarFunctionView getFuntionView() {
        return this.f259927i;
    }

    public final DmtTextView getPoiCity() {
        return this.f259924f;
    }

    public final DmtTextView getPoiDistrictTown() {
        return this.f259926h;
    }

    public final DmtTextView getPoiName() {
        return this.f259922d;
    }

    public final LinearLayout getPoiNameLayout() {
        return this.f259921c;
    }

    public final View getSplitLine() {
        return this.f259925g;
    }

    public final DmtTextView getUserDistance() {
        return this.f259923e;
    }

    public final void setCardBanner(LiveLocalLifeCardBanner r100) {
        this.f259928j = r100;
    }

    public final void setCouponMigrationInfo(i r100) {
        this.f259929k = r100;
    }

    public final void setFuntionView(LiveLocalLifeTopBarFunctionView r100) {
        this.f259927i = r100;
    }

    public final void setPoiCity(DmtTextView r100) {
        this.f259924f = r100;
    }

    public final void setPoiDistrictTown(DmtTextView r100) {
        this.f259926h = r100;
    }

    public final void setPoiName(DmtTextView r100) {
        this.f259922d = r100;
    }

    public final void setPoiNameLayout(LinearLayout r100) {
        this.f259921c = r100;
    }

    public final void setSplitLine(View r100) {
        this.f259925g = r100;
    }

    public final void setUserDistance(DmtTextView r100) {
        this.f259923e = r100;
    }

    public LiveLocalLifeSingleStoreShelfTopBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.saas_poi_live_local_life_single_store_shelf_top_bar, this, true);
        this.f259921c = (LinearLayout) r103.findViewById(R.id.poi_name_layout);
        this.f259922d = (DmtTextView) r103.findViewById(R.id.poi_name);
        this.f259923e = (DmtTextView) r103.findViewById(R.id.user_distance);
        this.f259924f = (DmtTextView) r103.findViewById(R.id.poi_city);
        this.f259925g = r103.findViewById(R.id.split_line);
        this.f259926h = (DmtTextView) r103.findViewById(R.id.poi_district_town);
        this.f259927i = (LiveLocalLifeTopBarFunctionView) r103.findViewById(R.id.function_view);
        View r104 = r103.findViewById(R.id.poi_header);
        if (r104 == null) goto L5;
        r104.setOnClickListener(new d(this));
    L5:
        LinearLayout r105 = this.f259921c;
        if (r105 == null) goto L8;
        r105.setOnClickListener(new e(this));
    L8:
        this.f259928j = new LiveLocalLifeCardBanner();
    }

    @Override // com.bytedance.locallife.live.goodsshelves.topbar.view.BaseLiveLocalLifeSingleStoreShelfTopBar
    public final void a(LiveGoodsShelvesResponse r110, String r111, Fragment r112) {
        Intrinsics.checkNotNullParameter(r110, "liveGoodsShelvesResponse");
        Intrinsics.checkNotNullParameter(r111, "anchorId");
        Intrinsics.checkNotNullParameter(r112, WidgetService.PARAM_FRAGMENT);
        super.a(r110, r111, r112);
        setLiveLifeTopbarShowInfo(new h0());
        this.f259928j = r110.getCard_banner();
        LinearLayout r100 = this.f259921c;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
    L6:
        LiveLocalLifeCardBanner r101 = this.f259928j;
        GoodsShelvesContentFragment r102 = null;
        if (r101 == null) goto L9;
        String r103 = r101.getPoiName();
    L11:
        if (TextUtils.isEmpty(r103) == true) goto L20;
        LinearLayout r104 = this.f259921c;
        if (r104 == null) goto L16;
        r104.setVisibility(0);
    L16:
        h0 r105 = getLiveLifeTopbarShowInfo();
        if (r105 == null) goto L24;
        r105.f259600a = true;
    L24:
        DmtTextView r106 = this.f259922d;
        if (r106 == null) goto L32;
        LiveLocalLifeCardBanner r107 = this.f259928j;
        if (r107 == null) goto L30;
        String r108 = r107.getPoiName();
    L31:
        r106.setText(r108);
        goto L32
    L30:
        r108 = null;
    L32:
        DmtTextView r109 = this.f259923e;
        if (r109 == null) goto L40;
        LiveLocalLifeCardBanner r113 = this.f259928j;
        if (r113 == null) goto L38;
        String r114 = r113.getUserDistance();
    L39:
        r109.setText(r114);
        goto L40
    L38:
        r114 = null;
    L40:
        DmtTextView r115 = this.f259924f;
        if (r115 == null) goto L48;
        LiveLocalLifeCardBanner r116 = this.f259928j;
        if (r116 == null) goto L46;
        String r117 = r116.getPoiCity();
    L47:
        r115.setText(r117);
        goto L48
    L46:
        r117 = null;
    L48:
        DmtTextView r118 = this.f259926h;
        if (r118 == null) goto L63;
        StringBuilder r119 = new StringBuilder();
        LiveLocalLifeCardBanner r120 = this.f259928j;
        String r121 = "";
        if (r120 == null) goto L55;
        String r122 = r120.getPoiDistrict();
        if (r122 == null) goto L55;
    L56:
        r119.append(r122);
        r119.append(' ');
        LiveLocalLifeCardBanner r123 = this.f259928j;
        if (r123 == null) goto L62;
        String r124 = r123.getPoiTown();
        if (r124 == null) goto L62;
        r121 = r124;
    L62:
        r119.append(r121);
        r118.setText(r119.toString());
    L55:
        r122 = "";
    L63:
        LiveLocalLifeCardBanner r125 = this.f259928j;
        if (r125 != null) goto L66;
    L68:
        boolean r126 = false;
    L70:
        if (r126 == false) goto L87;
        DmtTextView r127 = this.f259924f;
        if (r127 == null) goto L75;
        r127.setVisibility(0);
    L75:
        View r128 = this.f259925g;
        if (r128 == null) goto L79;
        r128.setVisibility(8);
    L79:
        DmtTextView r129 = this.f259923e;
        if (r129 == null) goto L83;
        r129.setVisibility(8);
    L83:
        DmtTextView r130 = this.f259926h;
        if (r130 == null) goto L148;
        r130.setVisibility(8);
    L148:
        final LiveLocalLifeTopBarFunctionView r131 = this.f259927i;
        if (r131 == null) goto L213;
        h0 r132 = getLiveLifeTopbarShowInfo();
        Intrinsics.checkNotNullParameter(r110, "liveGoodsShelvesResponse");
        Intrinsics.checkNotNullParameter(r111, "anchorId");
        Intrinsics.checkNotNullParameter(r112, WidgetService.PARAM_FRAGMENT);
        r131.f259937f = r111;
        MemberSchema r133 = r110.getMember_schema();
        if (r133 == null) goto L153;
        String r134 = r133.getMember_schema_url();
    L154:
        r131.f259939h = r134;
        r131.f259940i = r132;
        Boolean r135 = r110.getHide_consult_btn();
        LinearLayout r136 = r131.f259932a;
        Boolean r137 = Boolean.TRUE;
        if (Intrinsics.areEqual(r135, r137) == false) goto L157;
        int r138 = 8;
    L158:
        r136.setVisibility(r138);
        if ((!Intrinsics.areEqual(r135, r137)) == false) goto L164;
        if (r132 == null) goto L163;
        r132.f259603d = true;
    L163:
        int r139 = 1;
    L165:
        Map<String, Object> r140 = r110.getLynx_topbar_data();
        if (r140 == null) goto L170;
        Object r141 = r140.get("order_center_url");
        if (r141 == null) goto L170;
        final String r142 = r141.toString();
    L171:
        r131.f259933b.setOnClickListener(new LiveLocalLifeTopBarFunctionView$bindOrder$1(r131, r142));
        if (r132 == null) goto L175;
        r132.f259602c = true;
    L175:
        int r143 = r139 + 1;
        MemberSchema r144 = r110.getMember_schema();
        int r145 = p.f260728a;
        Intrinsics.checkNotNullParameter(r112, WidgetService.PARAM_FRAGMENT);
        if ((r112 instanceof GoodsShelvesContentFragment) == false) goto L178;
        r102 = (GoodsShelvesContentFragment) r112;
    L178:
        if (r102 == null) goto L180;
        int r146 = r102.A;
    L181:
        r131.f259934c.setVisibility(8);
        if (r144 != null) goto L184;
        boolean r147 = false;
    L194:
        if (r147 == false) goto L200;
        if (r132 == null) goto L198;
        r132.f259604e = true;
    L198:
        r143 = r143 + 1;
    L200:
        if (r143 <= r131.f259941j) goto L211;
        r131.f259932a.setVisibility(8);
        r131.f259934c.setVisibility(8);
        r131.f259935d.setVisibility(0);
        h0 r148 = r131.f259940i;
        if (r148 == null) goto L205;
        r148.f259604e = false;
    L205:
        if (r148 == null) goto L208;
        r148.f259603d = false;
    L208:
        if (r148 == null) goto L215;
        r148.f259605f = true;
        return;
    L215:
        return;
    L211:
        r131.f259935d.setVisibility(8);
        return;
    L184:
        LinearLayout r149 = r131.f259934c;
        if (r144.getShow_member_entrance() == false) goto L187;
        int r150 = 0;
    L188:
        r149.setVisibility(r150);
        if (r144.getShow_member_entrance() == false) goto L193;
        if (r146 != 0) goto L192;
        LiveLocalLifeTopBarFunctionView.a("life_member_entrance_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", "livebroadcasting"), TuplesKt.to(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, "icon")}));
    L192:
        r131.f259934c.setOnClickListener(new f(r131, r144));
    L193:
        r147 = r144.getShow_member_entrance();
        goto L194
    L187:
        r150 = 8;
        goto L188
    L180:
        r146 = 0;
    L170:
        r142 = null;
        goto L171
    L164:
        r139 = 0;
        goto L165
    L157:
        r138 = 0;
        goto L158
    L153:
        r134 = null;
        goto L154
    L213:
        return;
    L87:
        LiveLocalLifeCardBanner r151 = this.f259928j;
        if (r151 != null) goto L90;
    L92:
        boolean r152 = false;
    L93:
        if (r152 == false) goto L110;
        DmtTextView r153 = this.f259924f;
        if (r153 == null) goto L98;
        r153.setVisibility(0);
    L98:
        View r154 = this.f259925g;
        if (r154 == null) goto L102;
        r154.setVisibility(8);
    L102:
        DmtTextView r155 = this.f259923e;
        if (r155 == null) goto L106;
        r155.setVisibility(8);
    L106:
        DmtTextView r156 = this.f259926h;
        if (r156 == null) goto L148;
        r156.setVisibility(8);
        goto L148
    L110:
        LiveLocalLifeCardBanner r157 = this.f259928j;
        if (r157 == null) goto L113;
        String r158 = r157.getUserDistance();
    L115:
        if (TextUtils.isEmpty(r158) == false) goto L132;
        DmtTextView r159 = this.f259924f;
        if (r159 == null) goto L120;
        r159.setVisibility(8);
    L120:
        DmtTextView r160 = this.f259923e;
        if (r160 == null) goto L124;
        r160.setVisibility(8);
    L124:
        View r161 = this.f259925g;
        if (r161 == null) goto L128;
        r161.setVisibility(8);
    L128:
        DmtTextView r162 = this.f259926h;
        if (r162 == null) goto L148;
        r162.setVisibility(0);
        goto L148
    L132:
        DmtTextView r163 = this.f259924f;
        if (r163 == null) goto L136;
        r163.setVisibility(8);
    L136:
        DmtTextView r164 = this.f259923e;
        if (r164 == null) goto L140;
        r164.setVisibility(0);
    L140:
        View r165 = this.f259925g;
        if (r165 == null) goto L144;
        r165.setVisibility(0);
    L144:
        DmtTextView r166 = this.f259926h;
        if (r166 == null) goto L148;
        r166.setVisibility(0);
        goto L148
    L113:
        r158 = null;
        goto L115
    L90:
        if (r151.getUserLocateScene() != 2) goto L92;
        r152 = true;
        goto L93
    L66:
        if (r125.getUserLocateScene() != 0) goto L68;
        r126 = true;
        goto L70
    L20:
        LinearLayout r167 = this.f259921c;
        if (r167 == null) goto L24;
        r167.setVisibility(8);
        goto L24
    L9:
        r103 = null;
        goto L11
    }

    public /* synthetic */ LiveLocalLifeSingleStoreShelfTopBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
