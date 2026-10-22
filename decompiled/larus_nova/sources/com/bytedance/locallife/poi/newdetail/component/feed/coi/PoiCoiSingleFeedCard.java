package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.lighten.core.ScaleType;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.model.poi.resp.SimplePoiInfoStruct;
import com.bytedance.locallife.poi.experiment.PoiBigFontExperiment;
import com.bytedance.locallife.poi.newdetail.widget.PoiRepeatTextureBgView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.coi.ADInfoData;
import com.ss.android.ugc.aweme.poi.coi.CoiCellTypeInfo;
import com.ss.android.ugc.aweme.poi.coi.CoiDisplayInfo;
import com.ss.android.ugc.aweme.poi.coi.LiveInfo;
import com.ss.android.ugc.aweme.poi.coi.RelationPoiCommonItem;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import df6.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/PoiCoiSingleFeedCard;", "Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/AbsCoiFeedView;", "Landroid/view/View;", "C", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", RootDescription.ROOT_ELEMENT, "", "D", "Ljava/lang/String;", "getCoiStyle", "()Ljava/lang/String;", "setCoiStyle", "(Ljava/lang/String;)V", "coiStyle", ExifInterface.LONGITUDE_EAST, "getCardClickEventName", "setCardClickEventName", "cardClickEventName", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiCoiSingleFeedCard extends AbsCoiFeedView {
    public final View C;
    public String D;
    public String E;
    public final PoiCoiImageView F;
    public final PoiCoiDynamicInfoView G;
    public final PoiRepeatTextureBgView H;
    public final FrameLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final View f263175J;
    public com.bytedance.locallife.poi.newdetail.k K;
    public final FrameLayout L;
    public final PoiCoiImageView M;
    public final SmartImageView N;
    public final DuxTextView O;
    public boolean P;

    public PoiCoiSingleFeedCard(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiCoiSingleFeedCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void f0() {
        boolean r100 = false;
        this.P = false;
        RelationPoiCommonItem r101 = getData();
        if (r101 == null) goto L7;
        CoiDisplayInfo r102 = r101.getDisplayInfo();
        if (r102 == null) goto L7;
        r100 = Intrinsics.areEqual(r102.isLive(), Boolean.TRUE);
    L7:
        if (r100 == false) goto L10;
        this.M.o();
        return;
    }

    @Override // com.bytedance.locallife.poi.newdetail.component.feed.coi.AbsCoiFeedView
    public final void a0() {
        RelationPoiCommonItem r100 = getData();
        if (r100 == null) goto L7;
        CoiDisplayInfo r101 = r100.getDisplayInfo();
        if (r101 == null) goto L7;
        boolean r102 = Intrinsics.areEqual(r101.isLive(), Boolean.TRUE);
    L8:
        String r103 = null;
        if (r102 == false) goto L37;
        PoiCoiImageView r104 = this.F;
        if (r104 == null) goto L14;
        r104.setVisibility(8);
    L14:
        FrameLayout r105 = this.L;
        if (r105 == null) goto L18;
        r105.setVisibility(0);
    L18:
        this.M.p(getData());
        FrameLayout r106 = this.L;
        r106.setOnClickListener(new m(r106, this));
        RelationPoiCommonItem r107 = getData();
        if (r107 == null) goto L27;
        CoiDisplayInfo r108 = r107.getDisplayInfo();
        if (r108 == null) goto L27;
        LiveInfo r109 = r108.getLiveInfo();
        if (r109 == null) goto L27;
        PoiImageUrlModel r110 = r109.getTagImage();
        if (r110 == null) goto L27;
        List<String> r111 = r110.getUrlList();
    L28:
        u r112 = df6.q.c(new ef6.a(r111));
        r112.f468288n = ScaleType.FIT_XY;
        r112.f468287m = Bitmap.Config.ARGB_8888;
        r112.f468294t = this.N;
        r112.d(new o(this));
        DuxTextView r113 = this.O;
        RelationPoiCommonItem r114 = getData();
        if (r114 == null) goto L35;
        CoiDisplayInfo r115 = r114.getDisplayInfo();
        if (r115 == null) goto L35;
        LiveInfo r116 = r115.getLiveInfo();
        if (r116 == null) goto L35;
        String r117 = r116.getTagText();
    L36:
        r113.setText(r117);
    L46:
        PoiCoiDynamicInfoView r118 = this.G;
        RelationPoiCommonItem r119 = getData();
        if (r119 == null) goto L49;
        CoiDisplayInfo r120 = r119.getDisplayInfo();
    L50:
        String r121 = "";
        if (r120 != null) goto L53;
        r118.setVisibility(8);
    L73:
        Function1<View, Unit> r122 = new PoiCoiSingleFeedCard$bindData$4$1(this);
        PoiCoiDynamicView r123 = r118.f263159b;
        r123.setOnClickListener(new e(r123, r122));
        Function1<View, Unit> r124 = new PoiCoiSingleFeedCard$bindData$4$2(this);
        PoiCoiDynamicView r125 = r118.f263160c;
        r125.setOnClickListener(new i(r125, r124));
        Function1<View, Unit> r126 = new PoiCoiSingleFeedCard$bindData$4$3(this);
        if (r118.f263168k == false) goto L76;
        PoiCoiDynamicView r127 = r118.f263162e;
        r127.setOnClickListener(new f(r127, r126));
    L76:
        Function1<View, Unit> r128 = new PoiCoiSingleFeedCard$bindData$4$4(this);
        PoiCoiDynamicView r129 = r118.f263164g;
        r129.setOnClickListener(new h(r129, r128));
        Function1<View, Unit> r130 = new PoiCoiSingleFeedCard$bindData$4$5(this);
        PoiCoiDynamicView r131 = r118.f263165h;
        r131.setOnClickListener(new g(r131, r130));
        RelationPoiCommonItem r132 = getData();
        if (r132 == null) goto L79;
        boolean r133 = Intrinsics.areEqual(r132.isAd(), Boolean.TRUE);
    L80:
        if (r133 == false) goto L94;
        RelationPoiCommonItem r134 = getData();
        if (r134 == null) goto L88;
        ADInfoData r135 = r134.getAdInfo();
        if (r135 == null) goto L88;
        boolean r136 = true;
        if (r135.getAdSourceType() != 1) goto L88;
    L89:
        if (r136 == false) goto L94;
        View r137 = this.f263175J;
        if (r137 == null) goto L98;
        r137.setVisibility(0);
    L98:
        setOnClickListener(new n(this, this));
        setOnLongClickListener(p.f263198a);
        this.G.setItemsLongClickListener(PoiCoiSingleFeedCard$bindData$7.INSTANCE);
        this.F.setOnLongClickListener(q.f263199a);
        View r138 = getRoot();
        RelationPoiCommonItem r139 = getData();
        if (r139 != null) goto L250;
    L248:
        r138.setContentDescription(r121);
        return;
    L250:
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L246
        StringBuilder r141 = new StringBuilder();     // Catch: Throwable -> L246
        SimplePoiInfoStruct r142 = r139.getPoiInfo();     // Catch: Throwable -> L246
        if (r142 == null) goto L105;
        String r143 = r142.getPoiName();     // Catch: Throwable -> L246
        if (r143 == null) goto L105;
    L106:
        r141.append(r143.concat(","));     // Catch: Throwable -> L246
        StringBuilder r144 = new StringBuilder();     // Catch: Throwable -> L246
        CoiDisplayInfo r145 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r145 == null) goto L120;
        List<CoiCellTypeInfo> r146 = r145.getRatingGroup();     // Catch: Throwable -> L246
        if (r146 == null) goto L120;
        ArrayList r147 = new ArrayList();     // Catch: Throwable -> L246
        Iterator<T> r148 = r146.iterator();     // Catch: Throwable -> L246
    L112:
        if (r148.hasNext() == false) goto L116;
        Object r149 = r148.next();     // Catch: Throwable -> L246
        if (Intrinsics.areEqual(((CoiCellTypeInfo) r149).getStyleType(), "evaluation_score") == false) goto L112;
        r147.add(r149);     // Catch: Throwable -> L246
        goto L112
    L116:
        CoiCellTypeInfo r150 = (CoiCellTypeInfo) ListProtector.get(r147, 0);     // Catch: Throwable -> L246
        if (r150 == null) goto L120;
        String r151 = r150.getTextContent();     // Catch: Throwable -> L246
        if (r151 == null) goto L120;
    L121:
        r144.append(g0(r151));     // Catch: Throwable -> L246
        r144.append(65292);     // Catch: Throwable -> L246
        r141.append(r144.toString());     // Catch: Throwable -> L246
        StringBuilder r152 = new StringBuilder();     // Catch: Throwable -> L246
        CoiDisplayInfo r153 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r153 == null) goto L135;
        List<CoiCellTypeInfo> r154 = r153.getRatingGroup();     // Catch: Throwable -> L246
        if (r154 == null) goto L135;
        ArrayList r155 = new ArrayList();     // Catch: Throwable -> L246
        Iterator<T> r156 = r154.iterator();     // Catch: Throwable -> L246
    L127:
        if (r156.hasNext() == false) goto L131;
        Object r157 = r156.next();     // Catch: Throwable -> L246
        if (Intrinsics.areEqual(((CoiCellTypeInfo) r157).getStyleType(), "evaluation_desc") == false) goto L127;
        r155.add(r157);     // Catch: Throwable -> L246
        goto L127
    L131:
        CoiCellTypeInfo r158 = (CoiCellTypeInfo) ListProtector.get(r155, 0);     // Catch: Throwable -> L246
        if (r158 == null) goto L135;
        String r159 = r158.getTextContent();     // Catch: Throwable -> L246
        if (r159 == null) goto L135;
    L136:
        r152.append(r159);     // Catch: Throwable -> L246
        r152.append(65292);     // Catch: Throwable -> L246
        r141.append(r152.toString());     // Catch: Throwable -> L246
        StringBuilder r160 = new StringBuilder();     // Catch: Throwable -> L246
        CoiDisplayInfo r161 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r161 == null) goto L150;
        List<CoiCellTypeInfo> r162 = r161.getRatingGroup();     // Catch: Throwable -> L246
        if (r162 == null) goto L150;
        ArrayList r163 = new ArrayList();     // Catch: Throwable -> L246
        Iterator<T> r164 = r162.iterator();     // Catch: Throwable -> L246
    L142:
        if (r164.hasNext() == false) goto L146;
        Object r165 = r164.next();     // Catch: Throwable -> L246
        if (Intrinsics.areEqual(((CoiCellTypeInfo) r165).getStyleType(), "evaluation_num") == false) goto L142;
        r163.add(r165);     // Catch: Throwable -> L246
        goto L142
    L146:
        CoiCellTypeInfo r166 = (CoiCellTypeInfo) ListProtector.get(r163, 0);     // Catch: Throwable -> L246
        if (r166 == null) goto L150;
        String r167 = r166.getTextContent();     // Catch: Throwable -> L246
        if (r167 == null) goto L150;
    L151:
        r160.append(r167);     // Catch: Throwable -> L246
        r160.append(65292);     // Catch: Throwable -> L246
        r141.append(r160.toString());     // Catch: Throwable -> L246
        StringBuilder r168 = new StringBuilder();     // Catch: Throwable -> L246
        CoiDisplayInfo r169 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r169 == null) goto L165;
        List<CoiCellTypeInfo> r170 = r169.getSubtitleGroup();     // Catch: Throwable -> L246
        if (r170 == null) goto L165;
        ArrayList r171 = new ArrayList();     // Catch: Throwable -> L246
        Iterator<T> r172 = r170.iterator();     // Catch: Throwable -> L246
    L157:
        if (r172.hasNext() == false) goto L161;
        Object r173 = r172.next();     // Catch: Throwable -> L246
        if (Intrinsics.areEqual(((CoiCellTypeInfo) r173).getStyleType(), "poi_type") == false) goto L157;
        r171.add(r173);     // Catch: Throwable -> L246
        goto L157
    L161:
        CoiCellTypeInfo r174 = (CoiCellTypeInfo) ListProtector.get(r171, 0);     // Catch: Throwable -> L246
        if (r174 == null) goto L165;
        String r175 = r174.getTextContent();     // Catch: Throwable -> L246
        if (r175 == null) goto L165;
    L166:
        r168.append(r175);     // Catch: Throwable -> L246
        r168.append(65292);     // Catch: Throwable -> L246
        r141.append(r168.toString());     // Catch: Throwable -> L246
        StringBuilder r176 = new StringBuilder();     // Catch: Throwable -> L246
        CoiDisplayInfo r177 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r177 == null) goto L180;
        List<CoiCellTypeInfo> r178 = r177.getSubtitleGroup();     // Catch: Throwable -> L246
        if (r178 == null) goto L180;
        ArrayList r179 = new ArrayList();     // Catch: Throwable -> L246
        Iterator<T> r180 = r178.iterator();     // Catch: Throwable -> L246
    L172:
        if (r180.hasNext() == false) goto L176;
        Object r181 = r180.next();     // Catch: Throwable -> L246
        if (Intrinsics.areEqual(((CoiCellTypeInfo) r181).getStyleType(), "poi_location") == false) goto L172;
        r179.add(r181);     // Catch: Throwable -> L246
        goto L172
    L176:
        CoiCellTypeInfo r182 = (CoiCellTypeInfo) ListProtector.get(r179, 0);     // Catch: Throwable -> L246
        if (r182 == null) goto L180;
        String r183 = r182.getTextContent();     // Catch: Throwable -> L246
        if (r183 == null) goto L180;
    L181:
        r176.append(r183);     // Catch: Throwable -> L246
        r176.append(65292);     // Catch: Throwable -> L246
        r141.append(r176.toString());     // Catch: Throwable -> L246
        StringBuilder r184 = new StringBuilder();     // Catch: Throwable -> L246
        CoiDisplayInfo r185 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r185 == null) goto L195;
        List<CoiCellTypeInfo> r186 = r185.getSubtitleGroup();     // Catch: Throwable -> L246
        if (r186 == null) goto L195;
        ArrayList r187 = new ArrayList();     // Catch: Throwable -> L246
        Iterator<T> r188 = r186.iterator();     // Catch: Throwable -> L246
    L187:
        if (r188.hasNext() == false) goto L191;
        Object r189 = r188.next();     // Catch: Throwable -> L246
        if (Intrinsics.areEqual(((CoiCellTypeInfo) r189).getStyleType(), "ave_price") == false) goto L187;
        r187.add(r189);     // Catch: Throwable -> L246
        goto L187
    L191:
        CoiCellTypeInfo r190 = (CoiCellTypeInfo) ListProtector.get(r187, 0);     // Catch: Throwable -> L246
        if (r190 == null) goto L195;
        String r191 = r190.getTextContent();     // Catch: Throwable -> L246
        if (r191 == null) goto L195;
    L196:
        r184.append(r191);     // Catch: Throwable -> L246
        r184.append(65292);     // Catch: Throwable -> L246
        r141.append(r184.toString());     // Catch: Throwable -> L246
        StringBuilder r192 = new StringBuilder();     // Catch: Throwable -> L246
        CoiDisplayInfo r193 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r193 == null) goto L200;
        Object r194 = r193.getSingleLocationInfo();     // Catch: Throwable -> L246
        if (r194 == null) goto L200;
    L201:
        r192.append(r194);     // Catch: Throwable -> L246
        r192.append(65292);     // Catch: Throwable -> L246
        r141.append(r192.toString());     // Catch: Throwable -> L246
        StringBuilder r195 = new StringBuilder();     // Catch: Throwable -> L246
        SimplePoiInfoStruct r196 = r139.getPoiInfo();     // Catch: Throwable -> L246
        if (r196 == null) goto L205;
        String r197 = r196.getPoiRankDesc();     // Catch: Throwable -> L246
        if (r197 == null) goto L205;
    L206:
        r195.append(r197);     // Catch: Throwable -> L246
        r195.append(65292);     // Catch: Throwable -> L246
        r141.append(r195.toString());     // Catch: Throwable -> L246
        CoiDisplayInfo r198 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r198 == null) goto L211;
        List<CoiCellTypeInfo> r199 = r198.getInfoGroup();     // Catch: Throwable -> L246
        if (r199 == null) goto L211;
        int r200 = r199.size();     // Catch: Throwable -> L246
    L212:
        if (r200 <= 0) goto L244;
        r141.append("团购");     // Catch: Throwable -> L246
        CoiDisplayInfo r201 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r201 == null) goto L227;
        List<CoiCellTypeInfo> r202 = r201.getInfoGroup();     // Catch: Throwable -> L246
        if (r202 == null) goto L227;
        ArrayList r203 = new ArrayList();     // Catch: Throwable -> L246
        Iterator<T> r204 = r202.iterator();     // Catch: Throwable -> L246
    L219:
        if (r204.hasNext() == false) goto L223;
        Object r205 = r204.next();     // Catch: Throwable -> L246
        if (Intrinsics.areEqual(((CoiCellTypeInfo) r205).getStyleType(), "spu_price") == false) goto L219;
        r203.add(r205);     // Catch: Throwable -> L246
        goto L219
    L223:
        CoiCellTypeInfo r206 = (CoiCellTypeInfo) ListProtector.get(r203, 0);     // Catch: Throwable -> L246
        if (r206 == null) goto L227;
        String r207 = r206.getTextContent();     // Catch: Throwable -> L246
        if (r207 == null) goto L227;
    L228:
        r141.append(r207);     // Catch: Throwable -> L246
        CoiDisplayInfo r208 = r139.getDisplayInfo();     // Catch: Throwable -> L246
        if (r208 == null) goto L242;
        List<CoiCellTypeInfo> r209 = r208.getInfoGroup();     // Catch: Throwable -> L246
        if (r209 == null) goto L242;
        ArrayList r210 = new ArrayList();     // Catch: Throwable -> L246
        Iterator<T> r211 = r209.iterator();     // Catch: Throwable -> L246
    L234:
        if (r211.hasNext() == false) goto L238;
        Object r212 = r211.next();     // Catch: Throwable -> L246
        if (Intrinsics.areEqual(((CoiCellTypeInfo) r212).getStyleType(), "spu_name") == false) goto L234;
        r210.add(r212);     // Catch: Throwable -> L246
        goto L234
    L238:
        CoiCellTypeInfo r213 = (CoiCellTypeInfo) ListProtector.get(r210, 0);     // Catch: Throwable -> L246
        if (r213 == null) goto L242;
        String r214 = r213.getTextContent();     // Catch: Throwable -> L246
        if (r214 == null) goto L242;
    L243:
        r141.append(r214);     // Catch: Throwable -> L246
    L242:
        r214 = "";
    L227:
        r207 = "";
    L244:
        r121 = r141.toString();     // Catch: Throwable -> L246
    L211:
        r200 = 0;
    L205:
        r197 = "";
    L200:
        r194 = "";
    L195:
        r191 = "";
    L180:
        r183 = "";
    L165:
        r175 = "";
    L150:
        r167 = "";
    L135:
        r159 = "";
    L120:
        r151 = "";
    L105:
        r143 = "";
    L246:
        th = move-exception;
        Result.Companion r215 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L88:
        r136 = false;
    L94:
        View r216 = this.f263175J;
        if (r216 == null) goto L98;
        r216.setVisibility(8);
        goto L98
    L79:
        r133 = false;
        goto L80
    L53:
        r118.setVisibility(0);
        r118.f263159b.a(r120.getTitleGroup(), r118.f263167j);
        r118.f263165h.a(r120.getRatingGroup(), r118.f263167j);
        r118.f263160c.a(r120.getSubtitleGroup(), r118.f263167j);
        r118.f263164g.a(r120.getInfoGroup(), r118.f263167j);
        PoiCoiDynamicView r217 = r118.f263162e;
        List<CoiCellTypeInfo> r218 = r120.getRecGroup();
        if (r218 == null) goto L60;
        CoiCellTypeInfo r219 = (CoiCellTypeInfo) CollectionsKt.firstOrNull(r218);
        if (r219 == null) goto L58;
        String r220 = r219.getType();
    L59:
        r118.f263168k = Intrinsics.areEqual(r220, CoiUIType.RANK.getType());
    L61:
        r217.a(r218, r118.f263167j);
        if (r118.f263166i == false) goto L73;
        DuxTextView r221 = r118.f263161d;
        List<String> r222 = r120.getSingleLocationInfo();
        if (r222 != null) goto L66;
    L70:
        r221.setText(r103);
        if (PoiBigFontExperiment.a() == false) goto L73;
        com.bytedance.dux.largefont.a.c(r118.f263161d, 12.0f);
        goto L73
    L66:
        if (CollectionsKt.getLastIndex(r222) < 0) goto L68;
        Object r223 = ListProtector.get(r222, 0);
    L69:
        r103 = (String) r223;
        goto L70
    L68:
        r223 = "";
        goto L69
    L58:
        r220 = null;
        goto L59
    L60:
        r218 = null;
        goto L61
    L49:
        r120 = null;
    L35:
        r117 = null;
    L27:
        r111 = null;
        goto L28
    L37:
        FrameLayout r224 = this.L;
        if (r224 == null) goto L41;
        r224.setVisibility(8);
    L41:
        this.M.o();
        PoiCoiImageView r225 = this.F;
        if (r225 == null) goto L45;
        r225.setVisibility(0);
    L45:
        PoiCoiImageView r226 = this.F;
        r226.p(getData());
        r226.setOnClickListener(new r(r226, this));
    L7:
        r102 = false;
        goto L8
    }

    @Override // com.bytedance.locallife.poi.newdetail.component.feed.coi.AbsCoiFeedView, com.bytedance.locallife.dito.core.BaseDitoView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.P = true;
        PoiCoiImageView r100 = this.M;
        com.bytedance.lighten.loader.e r101 = r100.f254702b;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        r100.setUserVisibleHint(true);
        r100.setAttached(true);
        r100.n();
        return;
    L11:
        return;
    L5:
        if (r101.f254728e == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.locallife.poi.newdetail.component.feed.coi.AbsCoiFeedView, com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        Object r100 = getDitoViewModel().A.get("skin_style");
        PoiRepeatTextureBgView.a r101 = null;
        if ((r100 instanceof com.bytedance.locallife.poi.newdetail.k) == false) goto L5;
        com.bytedance.locallife.poi.newdetail.k r102 = (com.bytedance.locallife.poi.newdetail.k) r100;
    L6:
        this.K = r102;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L25
        if (r102 == null) goto L12;
        com.bytedance.locallife.poi.newdetail.c r104 = r102.f263276c;     // Catch: Throwable -> L25
        if (r104 == null) goto L12;
        String r105 = r104.a();     // Catch: Throwable -> L25
    L14:
        if (TextUtils.isEmpty(r105) == false) goto L16;
        int r106 = ContextCompat.getColor(getContext(), R.color.POIBgPrimary);     // Catch: Throwable -> L25
    L23:
        this.I.setBackgroundColor(r106);     // Catch: Throwable -> L25
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        PoiRepeatTextureBgView r107 = this.H;
        com.bytedance.locallife.poi.newdetail.k r108 = this.K;
        if (r108 == null) goto L30;
        r101 = r108.f263279f;
    L30:
        r107.setManager(r101);
        return;
    L16:
        com.bytedance.locallife.poi.newdetail.k r109 = this.K;     // Catch: Throwable -> L25
        if (r109 == null) goto L21;
        com.bytedance.locallife.poi.newdetail.c r110 = r109.f263276c;     // Catch: Throwable -> L25
        if (r110 == null) goto L21;
        String r111 = r110.a();     // Catch: Throwable -> L25
    L22:
        r106 = Color.parseColor(r111);     // Catch: Throwable -> L25
    L21:
        r111 = null;
    L12:
        r105 = null;
    L25:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f0();
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onPause() {
        super.onPause();
        f0();
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onResume() {
        super.onResume();
        this.P = true;
        PoiCoiImageView r100 = this.M;
        com.bytedance.lighten.loader.e r101 = r100.f254702b;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        r100.setUserVisibleHint(true);
        r100.setAttached(true);
        r100.n();
        return;
    L11:
        return;
    L5:
        if (r101.f254728e == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.locallife.poi.newdetail.component.feed.coi.AbsCoiFeedView
    public String getCardClickEventName() {
        return this.E;
    }

    @Override // com.bytedance.locallife.poi.newdetail.component.feed.coi.AbsCoiFeedView
    public String getCoiStyle() {
        return this.D;
    }

    @Override // com.bytedance.locallife.poi.newdetail.component.feed.coi.AbsCoiFeedView
    public View getRoot() {
        return this.C;
    }

    public static String g0(String r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        if (CastDoubleProtector.parseDouble(r110) <= 0) goto L7;
        StringBuilder r101 = new StringBuilder("评分");     // Catch: Throwable -> L9
        List r111 = StringsKt.split$default(r110, new char[]{'.'}, false, 0, 6, null);     // Catch: Throwable -> L9
        r101.append((String) ListProtector.get(r111, 0));     // Catch: Throwable -> L9
        r101.append("点");     // Catch: Throwable -> L9
        r101.append((String) ListProtector.get(r111, 1));     // Catch: Throwable -> L9
        return r101.toString();
    L7:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return "";
    L9:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return "";
    }

    @Override // com.bytedance.locallife.poi.newdetail.component.feed.coi.AbsCoiFeedView
    public void setCardClickEventName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.E = r100;
    }

    @Override // com.bytedance.locallife.poi.newdetail.component.feed.coi.AbsCoiFeedView
    public void setCoiStyle(String r100) {
        this.D = r100;
    }

    public PoiCoiSingleFeedCard(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.C = LayoutInflater.from(r100).inflate(R.layout.saas_poi_card_coi_single_feed, this, false);
        this.D = "single_feed";
        this.E = "poi_coi_double_card_click";
        this.F = (PoiCoiImageView) getRoot().findViewById(R.id.poi_coi_single_feed_cover);
        this.G = (PoiCoiDynamicInfoView) getRoot().findViewById(R.id.poi_coi_single_feed_info_view);
        this.H = (PoiRepeatTextureBgView) getRoot().findViewById(R.id.texture_background);
        this.I = (FrameLayout) getRoot().findViewById(R.id.outside_container);
        this.f263175J = getRoot().findViewById(R.id.poi_coi_single_feed_ad);
        this.L = (FrameLayout) getRoot().findViewById(R.id.live_cover_container);
        this.M = (PoiCoiImageView) getRoot().findViewById(R.id.poi_coi_single_feed_cover_live);
        this.N = (SmartImageView) getRoot().findViewById(R.id.poi_coi_single_feed_tag_iv);
        this.O = (DuxTextView) getRoot().findViewById(R.id.poi_coi_single_feed_tag_text);
    }

    public /* synthetic */ PoiCoiSingleFeedCard(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
