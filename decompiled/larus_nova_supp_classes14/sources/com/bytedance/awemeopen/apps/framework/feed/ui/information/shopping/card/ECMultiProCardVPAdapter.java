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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/shopping/card/ECMultiProCardVPAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class ECMultiProCardVPAdapter extends PagerAdapter {
    public static final /* synthetic */ int f = 0;
    public final ArrayList<View> a;
    public Function2<? super DetailPromotion, ? super Integer, Unit> b;
    public final Lazy c;
    public final Handler d;
    public final Map<View, Runnable> e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ ECMultiProCardVPAdapter b;
        public final /* synthetic */ DetailPromotion c;
        public final /* synthetic */ List d;

        public b(View r1, ECMultiProCardVPAdapter r2, DetailPromotion r3, List r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (com.bytedance.awemeopen.apps.framework.utils.y.a(this.a) == false) goto L5;
            return;
        L5:
            Function2<? super DetailPromotion, ? super Integer, Unit> r4 = this.b.b;
            if (r4 == null) goto L9;
            DetailPromotion r0 = this.c;
            r4.invoke(r0, Integer.valueOf(this.d.indexOf(r0) + 1));
            return;
        }
    }

    static {
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "object");
        if (r2 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final float getPageWidth(int r2) {
        if (this.a.size() != 1) goto L6;
        return 1.0f;
    L6:
        return 0.8862069f;
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        r2.addView((View) ListProtector.get(this.a, r3));
        return ListProtector.get(this.a, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v7, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    /* JADX WARN: Type inference failed for: r14v15, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    /* JADX WARN: Type inference failed for: r15v6, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    /* JADX WARN: Type inference failed for: r4v32, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r4v34, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    public ECMultiProCardVPAdapter(List<DetailPromotion> r37, Context r38, Map<String, String> r39) {
        Intrinsics.checkNotNullParameter(r37, "promotions");
        Intrinsics.checkNotNullParameter(r38, "context");
        this.a = new ArrayList();
        this.c = LazyKt.lazy(ECMultiProCardVPAdapter$gson$2.INSTANCE);
        this.d = new Handler(Looper.getMainLooper());
        this.e = new LinkedHashMap();
        LayoutInflater r14 = LayoutInflater.from(r38);
        if (r39 == null) goto L7;
        String r0 = r39.get("use_new_coupon_style");
        if (r0 == null) goto L7;
        boolean r16 = r0.equals(CommentScene.COMMENTSCENE_NO_AWEME);
    L8:
        String r9 = "coupon_amount";
        if (r39 == null) goto L15;
        String r1 = r39.get("coupon_amount");
        if (r1 == null) goto L15;
        if (r1.length() <= 0) goto L15;
        boolean r2 = true;
    L16:
        if (r16 == false) goto L22;
        if (r2 == true) goto L19;
    L21:
        int r8 = 2131558602;
    L23:
        Iterator<DetailPromotion> r17 = r37.iterator();
    L25:
        if (r17.hasNext() == false) goto L343;
        DetailPromotion r7 = r17.next();
        View r6 = r14.inflate(r8, null);
        long r18 = 0;
        if (r16 == false) goto L247;
        AoImageView r5 = r6.findViewById(2131376507);
        AppCompatTextView r3 = (DmtTextView) r6.findViewById(2131391179);
        AppCompatTextView r4 = (DmtTextView) r6.findViewById(2131391177);
        AppCompatTextView r10 = (DmtTextView) r6.findViewById(2131391178);
        AppCompatTextView r11 = (DmtTextView) r6.findViewById(2131391147);
        View r15 = r6.findViewById(2131368064);
        AppCompatTextView r12 = (DmtTextView) r6.findViewById(2131390418);
        AppCompatTextView r13 = (DmtTextView) r6.findViewById(2131390419);
        int r24 = r8;
        AppCompatTextView r19 = (DmtTextView) r6.findViewById(2131390449);
        LayoutInflater r25 = r14;
        ?? r110 = (DmtTextView) r6.findViewById(2131390755);
        ?? r111 = (DmtTextView) r6.findViewById(2131390957);
        ?? r112 = (DmtTextView) r6.findViewById(2131391368);
        View r113 = r6.findViewById(2131368045);
        DmtTextView r114 = (DmtTextView) r6.findViewById(2131391273);
        AppCompatTextView r115 = (DmtTextView) r6.findViewById(2131390415);
        AppCompatTextView r116 = (DmtTextView) r6.findViewById(2131391665);
        List r117 = com.bytedance.awemeopen.apps.framework.utils.a0.d(r7);
        if (r117 == null) goto L35;
        DmtTextView r32 = r114;
        t14.a r118 = (t14.a) CollectionsKt.getOrNull(r117, 0);
        if (r118 == null) goto L37;
        if (r5 == null) goto L37;
        com.bytedance.awemeopen.infra.base.image.b r119 = new com.bytedance.awemeopen.infra.base.image.b(r118.g());
        r6 = r6;
        Resources r20 = Resources.getSystem();
        r119.s = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics())));
        r119.g = null;
        r119.h = 2131231403;
        r119.j = 2131231403;
        r5.j(r119);
    L37:
        if (r3 == null) goto L40;
        r3.setText(com.bytedance.awemeopen.apps.framework.utils.a0.e(r7));
    L40:
        Gson r21 = (Gson) this.c.getValue();
        String r22 = r7.getAnchorContent();
        if (r22 != null) goto L43;
        r22 = "{}";
    L43:
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.f r23 = (com.bytedance.awemeopen.bizmodels.feed.shopping.card.f) GsonProtectorUtils.fromJson(r21, r22, com.bytedance.awemeopen.bizmodels.feed.shopping.card.f.class);
        if (r23 == null) goto L105;
        List r26 = r23.a();
        if (r26 == null) goto L51;
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.d r27 = (com.bytedance.awemeopen.bizmodels.feed.shopping.card.d) CollectionsKt.getOrNull(r26, 0);
        if (r27 == null) goto L51;
        String r28 = r27.a();
        if (r28 == null) goto L51;
    L52:
        String r29 = r23.b();
        if (r29 != null) goto L56;
        r29 = "";
    L56:
        if (r28.length() <= 0) goto L58;
        boolean r30 = true;
    L59:
        if (r30 == false) goto L66;
        if (r4 == null) goto L63;
        r4.setText(r28);
    L63:
        if (r4 == null) goto L70;
        r4.setVisibility(0);
    L70:
        if (r29.length() <= 0) goto L72;
        boolean r31 = true;
    L73:
        if (r31 == false) goto L80;
        if (r10 == null) goto L77;
        r10.setText(r29);
    L77:
        if (r10 == null) goto L84;
        r10.setVisibility(0);
    L84:
        if (r28.length() <= 0) goto L86;
        boolean r33 = true;
    L87:
        if (r33 == false) goto L97;
        if (r29.length() <= 0) goto L91;
        boolean r34 = true;
    L92:
        if (r34 == false) goto L97;
        if (r4 == null) goto L105;
        Resources r35 = Resources.getSystem();
        r4.setMaxWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 60, WindowDisplayMetricsOverride.apply(r35, r35.getDisplayMetrics()))));
        goto L105
    L91:
        r34 = false;
    L97:
        if (r28.length() <= 0) goto L99;
        boolean r36 = true;
    L100:
        if (r36 == false) goto L105;
        if (r4 == null) goto L105;
        r4.setMaxWidth(Integer.MAX_VALUE);
        goto L105
    L99:
        r36 = false;
        goto L100
    L86:
        r33 = false;
        goto L87
    L80:
        if (r10 == null) goto L84;
        r10.setVisibility(8);
        goto L84
    L72:
        r31 = false;
        goto L73
    L66:
        if (r4 == null) goto L70;
        r4.setVisibility(8);
        goto L70
    L58:
        r30 = false;
    L51:
        r28 = "";
    L105:
        if (com.bytedance.awemeopen.apps.framework.utils.a0.c(r7) == false) goto L113;
        if (r11 == null) goto L109;
        r11.setVisibility(0);
    L109:
        if (r11 == null) goto L134;
        r11.setText("¥" + com.bytedance.awemeopen.apps.framework.utils.n.b(r7.getMinPrice()));
    L134:
        if (r39 == null) goto L140;
        String r40 = r39.get(r9);
        if (r40 == null) goto L140;
        if (r40.length() <= 0) goto L140;
        boolean r41 = true;
    L141:
        if (r41 == false) goto L242;
        if (r39 == null) goto L148;
        String r42 = r39.get(r9);
        if (r42 == null) goto L148;
        Long r43 = StringsKt.toLongOrNull(r42);
        if (r43 == null) goto L148;
        long r44 = r43.longValue();
    L149:
        double r120 = r44 / 100.0d;
        if (r12 != null) goto L153;
    L157:
        if (r13 == null) goto L165;
        if (r39 == null) goto L163;
        CharSequence r45 = (String) r39.get("coupon_desc");
        if (r45 == null) goto L163;
    L164:
        r13.setText(r45);
    L163:
        r45 = "";
    L165:
        if (r19 == null) goto L173;
        if (r39 == null) goto L171;
        CharSequence r46 = (String) r39.get("coupon_title");
        if (r46 == null) goto L171;
    L172:
        r19.setText(r46);
    L171:
        r46 = "";
    L173:
        if (r116 == 0) goto L176;
        r116.setText("去使用");
    L176:
        if (r39 == null) goto L178;
        String r47 = r39.get("coupon_expired_time");
    L179:
        if (r47 != null) goto L181;
    L184:
        boolean r48 = true;
    L185:
        if (r48 == false) goto L346;
        r7 = r7;
        View r121 = r6;
        int r210 = r24;
        ?? r49 = r32;
        String r211 = r9;
        Runnable r50 = (Runnable) ((LinkedHashMap) this.e).get(r121);
        if (r50 == null) goto L223;
        this.d.removeCallbacks(r50);
    L223:
        this.e.remove(r121);
        if (r110 == 0) goto L227;
        r110.setText("");
    L227:
        if (r111 == 0) goto L230;
        r111.setText("");
    L230:
        if (r112 == 0) goto L233;
        r112.setText("");
    L233:
        if (r49 == 0) goto L236;
        r49.setVisibility(8);
    L236:
        if (r113 == null) goto L239;
        r113.setVisibility(8);
    L239:
        if (r115 == null) goto L246;
        r115.setVisibility(0);
    L246:
        View r122 = r121;
    L342:
        View r51 = r122;
        r51.setOnClickListener(new b(r51, this, r7, r37));
        this.a.add(r51);
        r8 = r210;
        r9 = r211;
        r14 = r25;
        goto L25
    L346:
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L200
        long r53 = CastLongProtector.parseLong(r47);     // Catch: Throwable -> L200
        View r54 = r6;
        Runnable r55 = (Runnable) ((LinkedHashMap) this.e).get(r54);     // Catch: Throwable -> L197
        if (r55 == null) goto L192;
        this.d.removeCallbacks(r55);     // Catch: Throwable -> L197
    L192:
        CharSequence r123 = "";
        int r124 = 8;
        r121 = r54;
        r7 = r7;
        r210 = r24;
        r211 = r9;
        c r56 = new c(r53, r32, r113, r110, r111, r112, this, r121);     // Catch: Throwable -> L195
        this.e.put(r121, r56);     // Catch: Throwable -> L195
        Object r57 = Result.constructor-impl(Boolean.valueOf(this.d.post(r56)));     // Catch: Throwable -> L195
    L204:
        if (Result.exceptionOrNull-impl(r57) == null) goto L239;
        if (r110 == 0) goto L208;
        r110.setText(r123);
    L208:
        if (r111 == 0) goto L211;
        r111.setText(r123);
    L211:
        if (r112 == 0) goto L214;
        r112.setText(r123);
    L214:
        if (r32 == null) goto L217;
        r32.setVisibility(r124);
    L217:
        if (r113 == null) goto L239;
        r113.setVisibility(r124);
    L195:
        th = th;
    L202:
        Result.Companion r58 = Result.Companion;
        r57 = Result.constructor-impl(ResultKt.createFailure(th));
    L197:
        th = th;
        r121 = r54;
    L199:
        r123 = "";
        r210 = r24;
        r124 = 8;
        r211 = r9;
    L200:
        th = th;
        r121 = r6;
        goto L199
    L181:
        if (r47.length() == 0) goto L184;
        r48 = false;
        goto L185
    L178:
        r47 = null;
        goto L179
    L153:
        if ((r44 % ((long) 100)) != 0) goto L155;
        CharSequence r59 = String.valueOf((long) r120);
    L156:
        r12.setText(r59);
        goto L157
    L155:
        StringCompanionObject r60 = StringCompanionObject.INSTANCE;
        r59 = StringsKt.trimEnd(StringsKt.trimEnd(String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r120)}, 1)), new char[]{'0'}), new char[]{'.'});
    L148:
        r44 = 0;
        goto L149
    L242:
        r7 = r7;
        r211 = r9;
        r121 = r6;
        r210 = r24;
        if (r15 == null) goto L246;
        r15.setVisibility(8);
    L140:
        r41 = false;
        goto L141
    L113:
        if (r7.getToutiao() == null) goto L131;
        if (r11 == null) goto L118;
        r11.setVisibility(0);
    L118:
        if (com.bytedance.awemeopen.apps.framework.utils.a0.a(r7) == false) goto L128;
        if (r11 == null) goto L134;
        StringBuilder r61 = new StringBuilder("¥");
        PromotionToutiao r62 = r7.getToutiao();
        if (r62 == null) goto L126;
        SeckillInfo r63 = r62.getSecKillInfo();
        if (r63 == null) goto L126;
        long r64 = r63.getSkuMinPrice();
    L127:
        r61.append(com.bytedance.awemeopen.apps.framework.utils.n.b(r64));
        r11.setText(r61.toString());
    L126:
        r64 = 0;
        goto L127
    L128:
        if (r11 == null) goto L134;
        r11.setText("¥" + com.bytedance.awemeopen.apps.framework.utils.n.b(r7.getMinPrice()));
        goto L134
    L131:
        if (r11 == null) goto L134;
        r11.setVisibility(8);
        goto L134
    L35:
        r32 = r114;
        goto L37
    L247:
        r122 = r6;
        r7 = r7;
        r210 = r8;
        r211 = r9;
        r25 = r14;
        AoImageView r65 = r122.findViewById(2131383080);
        AppCompatTextView r66 = (DmtTextView) r122.findViewById(2131383087);
        LinearLayout r67 = (LinearLayout) r122.findViewById(2131379597);
        AppCompatTextView r68 = (DmtTextView) r122.findViewById(2131383079);
        ImageView r69 = (ImageView) r122.findViewById(2131369140);
        final ?? r70 = (DmtTextView) r122.findViewById(2131383086);
        LinearLayout r71 = (LinearLayout) r122.findViewById(2131383004);
        AppCompatTextView r72 = (DmtTextView) r122.findViewById(2131389438);
        AppCompatTextView r73 = (DmtTextView) r122.findViewById(2131383081);
        AppCompatTextView r74 = (DmtTextView) r122.findViewById(2131383082);
        AppCompatTextView r125 = (DmtTextView) r122.findViewById(2131383084);
        List r126 = com.bytedance.awemeopen.apps.framework.utils.a0.d(r7);
        if (r126 == null) goto L253;
        String r212 = "";
        t14.a r127 = (t14.a) CollectionsKt.getOrNull(r126, 0);
        if (r127 == null) goto L255;
        com.bytedance.awemeopen.infra.base.image.b r128 = new com.bytedance.awemeopen.infra.base.image.b(r127.g());
        Resources r129 = Resources.getSystem();
        r69 = r69;
        r128.s = MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r129, r129.getDisplayMetrics())));
        r128.g = null;
        r128.h = 2131231403;
        r128.j = 2131231403;
        r65.j(r128);
    L255:
        r66.setText(com.bytedance.awemeopen.apps.framework.utils.a0.e(r7));
        if (com.bytedance.awemeopen.apps.framework.utils.a0.c(r7) == false) goto L259;
        r71.setVisibility(0);
        r73.setText(com.bytedance.awemeopen.apps.framework.utils.n.b(r7.getMinPrice()));
    L344:
        Result.Companion r75 = Result.Companion;     // Catch: Throwable -> L336
        if (r39 == null) goto L282;
        String r76 = r39.get("anchor_commondity_desc");     // Catch: Throwable -> L336
        if (r76 == null) goto L282;
        if (r76.length() <= 0) goto L278;
        boolean r77 = true;
    L280:
        if (r77 != true) goto L282;
        boolean r78 = true;
    L283:
        if (r78 == false) goto L285;
        r72.setText(r39.get("anchor_commondity_desc"));     // Catch: Throwable -> L336
        r72.setVisibility(0);     // Catch: Throwable -> L336
        boolean r79 = true;
    L286:
        Gson r80 = (Gson) this.c.getValue();     // Catch: Throwable -> L336
        String r81 = r7.getAnchorContent();     // Catch: Throwable -> L336
        if (r81 != null) goto L289;
        r81 = "{}";
    L289:
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.f r82 = (com.bytedance.awemeopen.bizmodels.feed.shopping.card.f) r80.fromJson(r81, com.bytedance.awemeopen.bizmodels.feed.shopping.card.f.class);     // Catch: Throwable -> L336
        if (r82 == null) goto L333;
        String r83 = r82.c();     // Catch: Throwable -> L336
        if (r83 != null) goto L294;
    L297:
        boolean r84 = true;
    L298:
        if (r84 == true) goto L302;
        if (r79 == true) goto L302;
        r74.setVisibility(0);     // Catch: Throwable -> L336
        r74.setText(r82.c());     // Catch: Throwable -> L336
    L303:
        String r85 = r82.d();     // Catch: Throwable -> L336
        if (r85 != null) goto L306;
    L309:
        boolean r86 = true;
    L310:
        if (r86 == false) goto L312;
        r125.setVisibility(8);     // Catch: Throwable -> L336
    L313:
        List r87 = r82.a();     // Catch: Throwable -> L336
        if (r87 == null) goto L319;
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.d r88 = (com.bytedance.awemeopen.bizmodels.feed.shopping.card.d) CollectionsKt.getOrNull(r87, 0);     // Catch: Throwable -> L336
        if (r88 == null) goto L319;
        String r89 = r88.a();     // Catch: Throwable -> L336
        if (r89 == null) goto L319;
    L320:
        boolean r90 = h0.a(r89);     // Catch: Throwable -> L336
        boolean r91 = h0.a(r82.b());     // Catch: Throwable -> L336
        if (r90 == true) goto L325;
        if (r91 == true) goto L325;
        r67.setVisibility(8);     // Catch: Throwable -> L336
        Unit r92 = Unit.INSTANCE;     // Catch: Throwable -> L336
    L334:
        Object r93 = Result.constructor-impl(r92);     // Catch: Throwable -> L336
    L339:
        if (Result.exceptionOrNull-impl(r93) == null) goto L342;
        r74.setVisibility(8);
        r67.setVisibility(8);
        AoLogger.c("ECMultiProCardVPAdapter", new Object[]{"ECMultiProCardVPAdapter cardContent fromJson error"});
    L325:
        r67.setVisibility(0);     // Catch: Throwable -> L336
        if (r90 == false) goto L329;
        if (r91 == false) goto L329;
        r68.setVisibility(0);     // Catch: Throwable -> L336
        r68.setText(r89);     // Catch: Throwable -> L336
        r70.setText(r82.b());     // Catch: Throwable -> L336
        r70.setVisibility(4);     // Catch: Throwable -> L336
        final ImageView r94 = r69;
        r92 = Boolean.valueOf(r70.post(new com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.b(r70, r94)));     // Catch: Throwable -> L336
    L329:
        ImageView r95 = r69;
        if (r90 == false) goto L332;
        r68.setVisibility(0);     // Catch: Throwable -> L336
        r68.setText(r89);     // Catch: Throwable -> L336
        r95.setVisibility(8);     // Catch: Throwable -> L336
        r70.setVisibility(8);     // Catch: Throwable -> L336
        r92 = Unit.INSTANCE;     // Catch: Throwable -> L336
        goto L334
    L332:
        r68.setVisibility(8);     // Catch: Throwable -> L336
        r95.setVisibility(8);     // Catch: Throwable -> L336
        r70.setVisibility(0);     // Catch: Throwable -> L336
        r70.setText(r82.b());     // Catch: Throwable -> L336
        r92 = Unit.INSTANCE;     // Catch: Throwable -> L336
    L319:
        r89 = r212;
        goto L320
    L312:
        r125.setVisibility(0);     // Catch: Throwable -> L336
        r125.setText(r82.d());     // Catch: Throwable -> L336
        goto L313
    L306:
        if (r85.length() == 0) goto L309;
        r86 = false;
    L302:
        r74.setVisibility(8);     // Catch: Throwable -> L336
        goto L303
    L294:
        if (r83.length() == 0) goto L297;
        r84 = false;
        goto L298
    L333:
        r74.setVisibility(8);     // Catch: Throwable -> L336
        r67.setVisibility(8);     // Catch: Throwable -> L336
        r92 = Unit.INSTANCE;     // Catch: Throwable -> L336
        goto L334
    L285:
        r72.setVisibility(8);     // Catch: Throwable -> L336
        r79 = false;
        goto L286
    L278:
        r77 = false;
    L282:
        r78 = false;
    L336:
        th = move-exception;
        Result.Companion r96 = Result.Companion;
        r93 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L339
    L259:
        if (r7.getToutiao() == null) goto L269;
        r71.setVisibility(0);
        if (com.bytedance.awemeopen.apps.framework.utils.a0.a(r7) == false) goto L268;
        PromotionToutiao r97 = r7.getToutiao();
        if (r97 == null) goto L267;
        SeckillInfo r98 = r97.getSecKillInfo();
        if (r98 == null) goto L267;
        r18 = r98.getSkuMinPrice();
    L267:
        r73.setText(com.bytedance.awemeopen.apps.framework.utils.n.b(r18));
        goto L344
    L268:
        r73.setText(com.bytedance.awemeopen.apps.framework.utils.n.b(r7.getMinPrice()));
        goto L344
    L269:
        r71.setVisibility(8);
        goto L344
    L253:
        r212 = "";
        goto L255
    L343:
        return;
    L19:
        if (r37.size() > 1) goto L21;
        r8 = 2131558603;
        goto L23
    L22:
        r8 = 2131558604;
    L15:
        r2 = false;
    L7:
        r16 = false;
        goto L8
    }

    public final void destroyItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "object");
        View r5 = (View) ListProtector.get(this.a, r3);
        Runnable r6 = (Runnable) ((LinkedHashMap) this.e).get(r5);
        if (r6 == null) goto L5;
        this.d.removeCallbacks(r6);
    L5:
        this.e.remove(r5);
        r2.removeView(r5);
    }
}
