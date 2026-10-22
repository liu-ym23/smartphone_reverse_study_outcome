package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.utils.h0;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.PromotionToutiao;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.SeckillInfo;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/shopping/card/ECMultiProCardVPAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class ECMultiProCardVPAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f196352f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<View> f196353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super DetailPromotion, ? super Integer, Unit> f196354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f196355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f196356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<View, Runnable> f196357e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f196358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECMultiProCardVPAdapter f196359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DetailPromotion f196360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f196361d;

        public b(View r100, ECMultiProCardVPAdapter r101, DetailPromotion r102, List r103) {
            this.f196358a = r100;
            this.f196359b = r101;
            this.f196360c = r102;
            this.f196361d = r103;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.awemeopen.apps.framework.utils.y.a(this.f196358a) == false) goto L5;
            return;
        L5:
            Function2<? super DetailPromotion, ? super Integer, Unit> r101 = this.f196359b.f196354b;
            if (r101 == null) goto L9;
            DetailPromotion r102 = this.f196360c;
            r101.invoke(r102, Integer.valueOf(this.f196361d.indexOf(r102) + 1));
            return;
        }
    }

    static {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "object");
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f196353a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final float getPageWidth(int r100) {
        if (this.f196353a.size() != 1) goto L6;
        return 1.0f;
    L6:
        return 0.8862069f;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        r100.addView((View) ListProtector.get(this.f196353a, r101));
        return ListProtector.get(this.f196353a, r101);
    }

    public ECMultiProCardVPAdapter(List<DetailPromotion> r310, Context r311, Map<String, String> r312) {
        Intrinsics.checkNotNullParameter(r310, "promotions");
        Intrinsics.checkNotNullParameter(r311, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f196353a = new ArrayList();
        this.f196355c = LazyKt.lazy(ECMultiProCardVPAdapter$gson$2.INSTANCE);
        this.f196356d = new Handler(Looper.getMainLooper());
        this.f196357e = new LinkedHashMap();
        LayoutInflater r110 = LayoutInflater.from(r311);
        if (r312 == null) goto L7;
        String r100 = r312.get("use_new_coupon_style");
        if (r100 == null) goto L7;
        boolean r111 = r100.equals("1");
    L8:
        String r101 = "coupon_amount";
        if (r312 == null) goto L15;
        String r102 = r312.get("coupon_amount");
        if (r102 == null) goto L15;
        if (r102.length() <= 0) goto L15;
        boolean r103 = true;
    L16:
        if (r111 == false) goto L22;
        if (r103 == true) goto L19;
    L21:
        int r104 = R.layout.aos_commerce_layout_commerce_multi_card_new;
    L23:
        Iterator<DetailPromotion> r112 = r310.iterator();
    L25:
        if (r112.hasNext() == false) goto L343;
        DetailPromotion r105 = r112.next();
        View r106 = r110.inflate(r104, null);
        long r113 = 0;
        if (r111 == false) goto L247;
        AoImageView r107 = (AoImageView) r106.findViewById(R.id.iv_product_image);
        DmtTextView r108 = (DmtTextView) r106.findViewById(R.id.tv_product_title);
        DmtTextView r109 = (DmtTextView) r106.findViewById(R.id.tv_product_tag_1);
        DmtTextView r114 = (DmtTextView) r106.findViewById(R.id.tv_product_tag_2);
        DmtTextView r115 = (DmtTextView) r106.findViewById(R.id.tv_price);
        View r116 = r106.findViewById(R.id.coupon_container);
        DmtTextView r117 = (DmtTextView) r106.findViewById(R.id.tv_coupon_amount);
        DmtTextView r118 = (DmtTextView) r106.findViewById(R.id.tv_coupon_desc);
        int r210 = r104;
        DmtTextView r119 = (DmtTextView) r106.findViewById(R.id.tv_coupon_title);
        LayoutInflater r211 = r110;
        DmtTextView r120 = (DmtTextView) r106.findViewById(R.id.tv_hour);
        DmtTextView r121 = (DmtTextView) r106.findViewById(R.id.tv_minute);
        DmtTextView r122 = (DmtTextView) r106.findViewById(R.id.tv_second);
        View r123 = r106.findViewById(R.id.countdown_timer);
        DmtTextView r124 = (DmtTextView) r106.findViewById(R.id.tv_remain_day);
        DmtTextView r125 = (DmtTextView) r106.findViewById(R.id.tv_countdown_suffix);
        DmtTextView r126 = (DmtTextView) r106.findViewById(R.id.tv_use_coupon);
        List r127 = com.bytedance.awemeopen.apps.framework.utils.a0.d(r105);
        if (r127 == null) goto L35;
        DmtTextView r313 = r124;
        t14.a r128 = (t14.a) CollectionsKt.getOrNull(r127, 0);
        if (r128 == null) goto L37;
        if (r107 == null) goto L37;
        com.bytedance.awemeopen.infra.base.image.b r129 = new com.bytedance.awemeopen.infra.base.image.b(r128.g());
        r106 = r106;
        Resources r130 = Resources.getSystem();
        r129.f198638s = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r130, r130.getDisplayMetrics())));
        r129.f198626g = null;
        r129.f198627h = R.drawable.aos_commerce_card_good_small_default_white;
        r129.f198629j = R.drawable.aos_commerce_card_good_small_default_white;
        r107.j(r129);
    L37:
        if (r108 == null) goto L40;
        r108.setText(com.bytedance.awemeopen.apps.framework.utils.a0.e(r105));
    L40:
        Gson r131 = (Gson) this.f196355c.getValue();
        String r132 = r105.getAnchorContent();
        if (r132 != null) goto L43;
        r132 = SliceInitService.DEFAULT_SWITCH;
    L43:
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.f r133 = (com.bytedance.awemeopen.bizmodels.feed.shopping.card.f) GsonProtectorUtils.fromJson(r131, r132, com.bytedance.awemeopen.bizmodels.feed.shopping.card.f.class);
        if (r133 == null) goto L105;
        List<com.bytedance.awemeopen.bizmodels.feed.shopping.card.d> r134 = r133.a();
        if (r134 == null) goto L51;
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.d r135 = (com.bytedance.awemeopen.bizmodels.feed.shopping.card.d) CollectionsKt.getOrNull(r134, 0);
        if (r135 == null) goto L51;
        String r136 = r135.a();
        if (r136 == null) goto L51;
    L52:
        String r137 = r133.b();
        if (r137 != null) goto L56;
        r137 = "";
    L56:
        if (r136.length() <= 0) goto L58;
        boolean r138 = true;
    L59:
        if (r138 == false) goto L66;
        if (r109 == null) goto L63;
        r109.setText(r136);
    L63:
        if (r109 == null) goto L70;
        r109.setVisibility(0);
    L70:
        if (r137.length() <= 0) goto L72;
        boolean r139 = true;
    L73:
        if (r139 == false) goto L80;
        if (r114 == null) goto L77;
        r114.setText(r137);
    L77:
        if (r114 == null) goto L84;
        r114.setVisibility(0);
    L84:
        if (r136.length() <= 0) goto L86;
        boolean r140 = true;
    L87:
        if (r140 == false) goto L97;
        if (r137.length() <= 0) goto L91;
        boolean r141 = true;
    L92:
        if (r141 == false) goto L97;
        if (r109 == null) goto L105;
        Resources r142 = Resources.getSystem();
        r109.setMaxWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 60, WindowDisplayMetricsOverride.apply(r142, r142.getDisplayMetrics()))));
        goto L105
    L91:
        r141 = false;
    L97:
        if (r136.length() <= 0) goto L99;
        boolean r143 = true;
    L100:
        if (r143 == false) goto L105;
        if (r109 == null) goto L105;
        r109.setMaxWidth(Integer.MAX_VALUE);
        goto L105
    L99:
        r143 = false;
        goto L100
    L86:
        r140 = false;
        goto L87
    L80:
        if (r114 == null) goto L84;
        r114.setVisibility(8);
        goto L84
    L72:
        r139 = false;
        goto L73
    L66:
        if (r109 == null) goto L70;
        r109.setVisibility(8);
        goto L70
    L58:
        r138 = false;
    L51:
        r136 = "";
    L105:
        if (com.bytedance.awemeopen.apps.framework.utils.a0.c(r105) == false) goto L113;
        if (r115 == null) goto L109;
        r115.setVisibility(0);
    L109:
        if (r115 == null) goto L134;
        r115.setText("¥" + com.bytedance.awemeopen.apps.framework.utils.n.b(r105.getMinPrice()));
    L134:
        if (r312 == null) goto L140;
        String r144 = r312.get(r101);
        if (r144 == null) goto L140;
        if (r144.length() <= 0) goto L140;
        boolean r145 = true;
    L141:
        if (r145 == false) goto L242;
        if (r312 == null) goto L148;
        String r146 = r312.get(r101);
        if (r146 == null) goto L148;
        Long r147 = StringsKt.toLongOrNull(r146);
        if (r147 == null) goto L148;
        long r148 = r147.longValue();
    L149:
        double r149 = r148 / 100.0d;
        if (r117 != null) goto L153;
    L157:
        if (r118 == null) goto L165;
        if (r312 == null) goto L163;
        String r150 = r312.get("coupon_desc");
        if (r150 == null) goto L163;
    L164:
        r118.setText(r150);
    L163:
        r150 = "";
    L165:
        if (r119 == null) goto L173;
        if (r312 == null) goto L171;
        String r151 = r312.get("coupon_title");
        if (r151 == null) goto L171;
    L172:
        r119.setText(r151);
    L171:
        r151 = "";
    L173:
        if (r126 == 0) goto L176;
        r126.setText("去使用");
    L176:
        if (r312 == null) goto L178;
        String r152 = r312.get("coupon_expired_time");
    L179:
        if (r152 != null) goto L181;
    L184:
        boolean r153 = true;
    L185:
        if (r153 == false) goto L346;
        r105 = r105;
        View r154 = r106;
        int r212 = r210;
        DmtTextView r155 = r313;
        String r213 = r101;
        Runnable r156 = (Runnable) ((LinkedHashMap) this.f196357e).get(r154);
        if (r156 == null) goto L223;
        this.f196356d.removeCallbacks(r156);
    L223:
        this.f196357e.remove(r154);
        if (r120 == null) goto L227;
        r120.setText("");
    L227:
        if (r121 == null) goto L230;
        r121.setText("");
    L230:
        if (r122 == null) goto L233;
        r122.setText("");
    L233:
        if (r155 == null) goto L236;
        r155.setVisibility(8);
    L236:
        if (r123 == null) goto L239;
        r123.setVisibility(8);
    L239:
        if (r125 == null) goto L246;
        r125.setVisibility(0);
    L246:
        View r157 = r154;
    L342:
        View r158 = r157;
        r158.setOnClickListener(new b(r158, this, r105, r310));
        this.f196353a.add(r158);
        r104 = r212;
        r101 = r213;
        r110 = r211;
        goto L25
    L346:
        Result.Companion r159 = Result.Companion;     // Catch: Throwable -> L200
        long r160 = CastLongProtector.parseLong(r152);     // Catch: Throwable -> L200
        View r161 = r106;
        Runnable r162 = (Runnable) ((LinkedHashMap) this.f196357e).get(r161);     // Catch: Throwable -> L197
        if (r162 == null) goto L192;
        this.f196356d.removeCallbacks(r162);     // Catch: Throwable -> L197
    L192:
        CharSequence r163 = "";
        int r164 = 8;
        r154 = r161;
        r105 = r105;
        r212 = r210;
        r213 = r101;
        c r165 = new c(r160, r313, r123, r120, r121, r122, this, r154);     // Catch: Throwable -> L195
        this.f196357e.put(r154, r165);     // Catch: Throwable -> L195
        Object r166 = Result.m9449constructorimpl(Boolean.valueOf(this.f196356d.post(r165)));     // Catch: Throwable -> L195
    L204:
        if (Result.m9452exceptionOrNullimpl(r166) == null) goto L239;
        if (r120 == null) goto L208;
        r120.setText(r163);
    L208:
        if (r121 == null) goto L211;
        r121.setText(r163);
    L211:
        if (r122 == null) goto L214;
        r122.setText(r163);
    L214:
        if (r313 == null) goto L217;
        r313.setVisibility(r164);
    L217:
        if (r123 == null) goto L239;
        r123.setVisibility(r164);
    L195:
        th = th;
    L202:
        Result.Companion r167 = Result.Companion;
        r166 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L197:
        th = th;
        r154 = r161;
    L199:
        r163 = "";
        r212 = r210;
        r164 = 8;
        r213 = r101;
    L200:
        th = th;
        r154 = r106;
        goto L199
    L181:
        if (r152.length() == 0) goto L184;
        r153 = false;
        goto L185
    L178:
        r152 = null;
        goto L179
    L153:
        if ((r148 % ((long) 100)) != 0) goto L155;
        String r168 = String.valueOf((long) r149);
    L156:
        r117.setText(r168);
        goto L157
    L155:
        StringCompanionObject r169 = StringCompanionObject.INSTANCE;
        r168 = StringsKt.trimEnd(StringsKt.trimEnd(String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r149)}, 1)), new char[]{'0'}), new char[]{'.'});
    L148:
        r148 = 0;
        goto L149
    L242:
        r105 = r105;
        r213 = r101;
        r154 = r106;
        r212 = r210;
        if (r116 == null) goto L246;
        r116.setVisibility(8);
    L140:
        r145 = false;
        goto L141
    L113:
        if (r105.getToutiao() == null) goto L131;
        if (r115 == null) goto L118;
        r115.setVisibility(0);
    L118:
        if (com.bytedance.awemeopen.apps.framework.utils.a0.a(r105) == false) goto L128;
        if (r115 == null) goto L134;
        StringBuilder r170 = new StringBuilder("¥");
        PromotionToutiao r171 = r105.getToutiao();
        if (r171 == null) goto L126;
        SeckillInfo r172 = r171.getSecKillInfo();
        if (r172 == null) goto L126;
        long r173 = r172.getSkuMinPrice();
    L127:
        r170.append(com.bytedance.awemeopen.apps.framework.utils.n.b(r173));
        r115.setText(r170.toString());
    L126:
        r173 = 0;
        goto L127
    L128:
        if (r115 == null) goto L134;
        r115.setText("¥" + com.bytedance.awemeopen.apps.framework.utils.n.b(r105.getMinPrice()));
        goto L134
    L131:
        if (r115 == null) goto L134;
        r115.setVisibility(8);
        goto L134
    L35:
        r313 = r124;
        goto L37
    L247:
        r157 = r106;
        r105 = r105;
        r212 = r104;
        r213 = r101;
        r211 = r110;
        AoImageView r174 = (AoImageView) r157.findViewById(R.id.pro_image);
        DmtTextView r175 = (DmtTextView) r157.findViewById(R.id.pro_title);
        LinearLayout r176 = (LinearLayout) r157.findViewById(R.id.market_exp_container);
        DmtTextView r177 = (DmtTextView) r157.findViewById(R.id.pro_discount);
        ImageView r178 = (ImageView) r157.findViewById(R.id.discount_timeliness_delimiter);
        final DmtTextView r179 = (DmtTextView) r157.findViewById(R.id.pro_timeliness);
        LinearLayout r180 = (LinearLayout) r157.findViewById(R.id.price_container);
        DmtTextView r181 = (DmtTextView) r157.findViewById(R.id.tt_coupon_text);
        DmtTextView r182 = (DmtTextView) r157.findViewById(R.id.pro_price);
        DmtTextView r183 = (DmtTextView) r157.findViewById(R.id.pro_price_desc);
        DmtTextView r184 = (DmtTextView) r157.findViewById(R.id.pro_price_suffix);
        List r185 = com.bytedance.awemeopen.apps.framework.utils.a0.d(r105);
        if (r185 == null) goto L253;
        String r214 = "";
        t14.a r186 = (t14.a) CollectionsKt.getOrNull(r185, 0);
        if (r186 == null) goto L255;
        com.bytedance.awemeopen.infra.base.image.b r187 = new com.bytedance.awemeopen.infra.base.image.b(r186.g());
        Resources r188 = Resources.getSystem();
        r178 = r178;
        r187.f198638s = MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r188, r188.getDisplayMetrics())));
        r187.f198626g = null;
        r187.f198627h = R.drawable.aos_commerce_card_good_small_default_white;
        r187.f198629j = R.drawable.aos_commerce_card_good_small_default_white;
        r174.j(r187);
    L255:
        r175.setText(com.bytedance.awemeopen.apps.framework.utils.a0.e(r105));
        if (com.bytedance.awemeopen.apps.framework.utils.a0.c(r105) == false) goto L259;
        r180.setVisibility(0);
        r182.setText(com.bytedance.awemeopen.apps.framework.utils.n.b(r105.getMinPrice()));
    L344:
        Result.Companion r189 = Result.Companion;     // Catch: Throwable -> L336
        if (r312 == null) goto L282;
        String r190 = r312.get("anchor_commondity_desc");     // Catch: Throwable -> L336
        if (r190 == null) goto L282;
        if (r190.length() <= 0) goto L278;
        boolean r191 = true;
    L280:
        if (r191 != true) goto L282;
        boolean r192 = true;
    L283:
        if (r192 == false) goto L285;
        r181.setText(r312.get("anchor_commondity_desc"));     // Catch: Throwable -> L336
        r181.setVisibility(0);     // Catch: Throwable -> L336
        boolean r193 = true;
    L286:
        Gson r194 = (Gson) this.f196355c.getValue();     // Catch: Throwable -> L336
        String r195 = r105.getAnchorContent();     // Catch: Throwable -> L336
        if (r195 != null) goto L289;
        r195 = SliceInitService.DEFAULT_SWITCH;
    L289:
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.f r196 = (com.bytedance.awemeopen.bizmodels.feed.shopping.card.f) r194.fromJson(r195, com.bytedance.awemeopen.bizmodels.feed.shopping.card.f.class);     // Catch: Throwable -> L336
        if (r196 == null) goto L333;
        String r197 = r196.c();     // Catch: Throwable -> L336
        if (r197 != null) goto L294;
    L297:
        boolean r198 = true;
    L298:
        if (r198 == true) goto L302;
        if (r193 == true) goto L302;
        r183.setVisibility(0);     // Catch: Throwable -> L336
        r183.setText(r196.c());     // Catch: Throwable -> L336
    L303:
        String r199 = r196.d();     // Catch: Throwable -> L336
        if (r199 != null) goto L306;
    L309:
        boolean r200 = true;
    L310:
        if (r200 == false) goto L312;
        r184.setVisibility(8);     // Catch: Throwable -> L336
    L313:
        List<com.bytedance.awemeopen.bizmodels.feed.shopping.card.d> r201 = r196.a();     // Catch: Throwable -> L336
        if (r201 == null) goto L319;
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.d r202 = (com.bytedance.awemeopen.bizmodels.feed.shopping.card.d) CollectionsKt.getOrNull(r201, 0);     // Catch: Throwable -> L336
        if (r202 == null) goto L319;
        String r203 = r202.a();     // Catch: Throwable -> L336
        if (r203 == null) goto L319;
    L320:
        boolean r204 = h0.a(r203);     // Catch: Throwable -> L336
        boolean r205 = h0.a(r196.b());     // Catch: Throwable -> L336
        if (r204 == true) goto L325;
        if (r205 == true) goto L325;
        r176.setVisibility(8);     // Catch: Throwable -> L336
        Object r206 = Unit.INSTANCE;     // Catch: Throwable -> L336
    L334:
        Object r207 = Result.m9449constructorimpl(r206);     // Catch: Throwable -> L336
    L339:
        if (Result.m9452exceptionOrNullimpl(r207) == null) goto L342;
        r183.setVisibility(8);
        r176.setVisibility(8);
        AoLogger.c("ECMultiProCardVPAdapter", new Object[]{"ECMultiProCardVPAdapter cardContent fromJson error"});
    L325:
        r176.setVisibility(0);     // Catch: Throwable -> L336
        if (r204 == false) goto L329;
        if (r205 == false) goto L329;
        r177.setVisibility(0);     // Catch: Throwable -> L336
        r177.setText(r203);     // Catch: Throwable -> L336
        r179.setText(r196.b());     // Catch: Throwable -> L336
        r179.setVisibility(4);     // Catch: Throwable -> L336
        final ImageView r208 = r178;
        r206 = Boolean.valueOf(r179.post(new com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.b(r179, r208)));     // Catch: Throwable -> L336
    L329:
        ImageView r209 = r178;
        if (r204 == false) goto L332;
        r177.setVisibility(0);     // Catch: Throwable -> L336
        r177.setText(r203);     // Catch: Throwable -> L336
        r209.setVisibility(8);     // Catch: Throwable -> L336
        r179.setVisibility(8);     // Catch: Throwable -> L336
        r206 = Unit.INSTANCE;     // Catch: Throwable -> L336
        goto L334
    L332:
        r177.setVisibility(8);     // Catch: Throwable -> L336
        r209.setVisibility(8);     // Catch: Throwable -> L336
        r179.setVisibility(0);     // Catch: Throwable -> L336
        r179.setText(r196.b());     // Catch: Throwable -> L336
        r206 = Unit.INSTANCE;     // Catch: Throwable -> L336
    L319:
        r203 = r214;
        goto L320
    L312:
        r184.setVisibility(0);     // Catch: Throwable -> L336
        r184.setText(r196.d());     // Catch: Throwable -> L336
        goto L313
    L306:
        if (r199.length() == 0) goto L309;
        r200 = false;
    L302:
        r183.setVisibility(8);     // Catch: Throwable -> L336
        goto L303
    L294:
        if (r197.length() == 0) goto L297;
        r198 = false;
        goto L298
    L333:
        r183.setVisibility(8);     // Catch: Throwable -> L336
        r176.setVisibility(8);     // Catch: Throwable -> L336
        r206 = Unit.INSTANCE;     // Catch: Throwable -> L336
        goto L334
    L285:
        r181.setVisibility(8);     // Catch: Throwable -> L336
        r193 = false;
        goto L286
    L278:
        r191 = false;
    L282:
        r192 = false;
    L336:
        th = move-exception;
        Result.Companion r215 = Result.Companion;
        r207 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L339
    L259:
        if (r105.getToutiao() == null) goto L269;
        r180.setVisibility(0);
        if (com.bytedance.awemeopen.apps.framework.utils.a0.a(r105) == false) goto L268;
        PromotionToutiao r216 = r105.getToutiao();
        if (r216 == null) goto L267;
        SeckillInfo r217 = r216.getSecKillInfo();
        if (r217 == null) goto L267;
        r113 = r217.getSkuMinPrice();
    L267:
        r182.setText(com.bytedance.awemeopen.apps.framework.utils.n.b(r113));
        goto L344
    L268:
        r182.setText(com.bytedance.awemeopen.apps.framework.utils.n.b(r105.getMinPrice()));
        goto L344
    L269:
        r180.setVisibility(8);
        goto L344
    L253:
        r214 = "";
        goto L255
    L343:
        return;
    L19:
        if (r310.size() > 1) goto L21;
        r104 = R.layout.aos_commerce_layout_commerce_multi_card_new_with_coupon;
        goto L23
    L22:
        r104 = R.layout.aos_commerce_layout_commerce_muti_card;
    L15:
        r103 = false;
    L7:
        r111 = false;
        goto L8
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        View r103 = (View) ListProtector.get(this.f196353a, r101);
        Runnable r104 = (Runnable) ((LinkedHashMap) this.f196357e).get(r103);
        if (r104 == null) goto L5;
        this.f196356d.removeCallbacks(r104);
    L5:
        this.f196357e.remove(r103);
        r100.removeView(r103);
    }
}
