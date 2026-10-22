package com.bytedance.android.window.shop.home.tab.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.i2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowSourceMethod;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowStoreType;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBaseFragmentPresenter;
import com.bytedance.android.window.shop.home.tab.WindowTabViewModelDeprecated;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.repository.tab.entity.o0;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ECWindowVideoCardPresenter extends ECWindowHolderBaseFragmentPresenter implements View.OnClickListener {
    public static final /* synthetic */ int l = 0;
    public final Lazy i;
    public o0 j;
    public final Lazy k;

    public static final class a {
    }

    static {
    }

    public ECWindowVideoCardPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.i = LazyKt.lazy(new ECWindowVideoCardPresenter$tabViewModel$2(this));
        this.k = LazyKt.lazy(ECWindowVideoCardPresenter$imageCallerContext$2.INSTANCE);
    }

    public final void b0(QModel r20) {
        QModel r1 = r20;
        if ((r1 instanceof o0) == true) goto L5;
        r1 = null;
    L5:
        o0 r2 = (o0) r1;
        if (r2 == null) goto L123;
        this.j = r2;
        ECUrlModel r3 = r2.j;
        if (r3 == null) goto L17;
        List r4 = r3.getUrlList();
        if (r4 == null) goto L17;
        if ((!r4.isEmpty()) == false) goto L14;
        List r11 = r4;
    L15:
        if (r11 == null) goto L17;
        GenericDraweeView r10 = Z().b(2131386358).f();
        h0.f(r10, r11, (com.bytedance.android.ec.core.imagex.r) this.k.getValue(), Integer.valueOf(r10.getWidth()), Integer.valueOf((r10.getWidth() * 4) / 3), 96);
        goto L17
    L14:
        r11 = null;
    L17:
        o0 r5 = this.j;
        if (r5 != null) goto L20;
    L22:
        if (r5 == null) goto L26;
        Long r6 = r5.l;
        if (r6 == null) goto L26;
        ((TextView) Z().b(2131386357).f()).setText(i2.a(r6.longValue()));
        Z().b(2131386355).f().setBackgroundResource(2131234777);
    L27:
        ECWindowProductSharePresenter r7 = (ECWindowProductSharePresenter) this;
        LinearLayout r9 = (LinearLayout) r7.Z().b(2131386351).f();
        r9.setVisibility(0);
        o0 r12 = r7.j;
        if ((r12 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L30;
        r12 = null;
    L30:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r13 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r12;
        if (r13 == null) goto L43;
        List<? extends WindowV2ProductItemVO> r14 = r13.q;
        if (r14 == null) goto L43;
        final WindowV2ProductItemVO r15 = (WindowV2ProductItemVO) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L43;
        List r16 = r15.h;
        if ((!r16.isEmpty()) == false) goto L39;
        List r17 = r16;
    L40:
        if (r17 == null) goto L42;
        h0.f(r7.Z().b(2131386352).f(), r17, r7.d0().getImageCallerContext(), Integer.valueOf(r7.Z().b(2131386352).f().getWidth()), Integer.valueOf((r7.Z().b(2131386352).f().getWidth() * 4) / 3), 96);
    L42:
        r7.Z().b(2131386353).f().C(new ECWindowProductSharePresenter$initSmallProductCard$1$3(r15));
    L44:
        r9.setOnClickListener(new l(r7, r9));
        o0 r18 = r7.j;
        if ((r18 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L47;
        r18 = null;
    L47:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r19 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r18;
        if (r19 == null) goto L73;
        List<? extends WindowV2ProductItemVO> r21 = r19.q;
        if (r21 == null) goto L73;
        WindowV2ProductItemVO r22 = (WindowV2ProductItemVO) CollectionsKt.firstOrNull(r21);
        if (r22 == null) goto L73;
        StringBuilder r110 = new StringBuilder("c3129.d42889_i");
        o0 r111 = r7.j;
        if ((r111 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L57;
        r111 = null;
    L57:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r112 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r111;
        if (r112 == null) goto L61;
        Object r113 = r112.n;
        if (r113 == null) goto L61;
    L62:
        r110.append(r113);
        String r114 = r110.toString();
        BtmItemBuilder r115 = new BtmItemBuilder(r114, Boolean.FALSE).withBtmPage(r7.m.getValue());
        Map<String, String> r116 = r7.j0();
        int r117 = WindowBstReport.a;
        View r118 = r7.a0();
        k r119 = new k(r7, r116, r116);
        Intrinsics.checkNotNullParameter(r118, "view");
        Intrinsics.checkNotNullParameter(r114, "btm");
        Intrinsics.checkNotNullParameter(r115, "btmItemBuilder");
        Intrinsics.checkNotNullParameter(r22, "item");
        Intrinsics.checkNotNullParameter(r119, "reporter");
        String r120 = r22.b;
        if (r120 != null) goto L66;
        r120 = r22.a;
    L66:
        if (r114.length() != 0) goto L68;
        boolean r23 = true;
    L69:
        if (r23 == false) goto L72;
        if (r115 != null) goto L72;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L72:
        com.bytedance.android.bst.api.d r24 = new com.bytedance.android.bst.api.d(r118);
        r24.a = r114;
        r24.b = "show_product";
        r24.c = r120;
        r24.d = "shopping";
        r24.e = -1;
        r24.f = r119;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.a(r24);
        goto L73
    L68:
        r23 = false;
    L61:
        r113 = "unknow";
    L73:
        TextView r25 = (TextView) r7.Z().b(2131386354).f();
        r25.setVisibility(0);
        o0 r121 = r7.j;
        if ((r121 instanceof com.bytedance.android.window.shop.repository.tab.entity.t) == true) goto L76;
        o0 r122 = null;
    L77:
        com.bytedance.android.window.shop.repository.tab.entity.t r123 = (com.bytedance.android.window.shop.repository.tab.entity.t) r122;
        if (r123 == null) goto L80;
        String r124 = r123.t;
    L81:
        if (r124 == null) goto L84;
    L122:
        r25.setText(r124);
        a0().setOnClickListener(this);
        goto L123
    L84:
        if ((r121 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L86;
        r121 = null;
    L86:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r125 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r121;
        if (r125 == null) goto L101;
        List<String> r126 = r125.r;
        if (r126 == null) goto L101;
        Iterator<T> r127 = r126.iterator();
    L92:
        if (r127.hasNext() == false) goto L99;
        Object r128 = r127.next();
        if (((String) r128).length() <= 0) goto L96;
        boolean r129 = true;
    L97:
        if (r129 == false) goto L92;
    L100:
        r124 = (String) r128;
    L102:
        if (r124 != null) goto L122;
        o0 r8 = r7.j;
        if ((r8 instanceof com.bytedance.android.window.shop.repository.tab.entity.c0) == true) goto L107;
        r8 = null;
    L107:
        com.bytedance.android.window.shop.repository.tab.entity.c0 r26 = (com.bytedance.android.window.shop.repository.tab.entity.c0) r8;
        if (r26 == null) goto L114;
        List<? extends WindowV2ProductItemVO> r27 = r26.q;
        if (r27 == null) goto L114;
        WindowV2ProductItemVO r28 = (WindowV2ProductItemVO) CollectionsKt.firstOrNull(r27);
        if (r28 == null) goto L114;
        String r29 = r28.d;
    L116:
        if (com.bytedance.android.shopping.extensions.k.c(r29) == false) goto L118;
        r124 = r29;
    L119:
        if (r124 != null) goto L122;
        r124 = "Ta推荐了这个宝贝";
        goto L122
    L118:
        r124 = null;
    L114:
        r29 = null;
        goto L116
    L96:
        r129 = false;
        goto L97
    L99:
        r128 = null;
    L101:
        r124 = null;
        goto L102
    L80:
        r124 = null;
        goto L81
    L76:
        r122 = r121;
        goto L77
    L39:
        r17 = null;
    L43:
        r9.setVisibility(8);
    L26:
        Z().b(2131386356).f().setVisibility(8);
        goto L27
    L20:
        if (r5.p != 203) goto L22;
        Z().b(2131386355).f().setBackgroundResource(2131234776);
        ((TextView) Z().b(2131386357).f()).setText(ag4.a.d(2131896814));
    L123:
        ECWindowViewModel r30 = d0();
        Pair[] r31 = new Pair[9];
        r31[0] = TuplesKt.to("author_id", d0().getShopParam().getAuthorId());
        r31[1] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r31[2] = TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation());
        r31[3] = TuplesKt.to("enter_from", "store_page");
        r31[4] = TuplesKt.to("store_type", "window");
        o0 r130 = this.j;
        if (r130 == null) goto L126;
        Integer r131 = r130.n;
    L127:
        r31[5] = TuplesKt.to("item_order", String.valueOf(r131));
        o0 r132 = this.j;
        if (r132 == null) goto L130;
        Integer r133 = Integer.valueOf(r132.p);
    L131:
        String r134 = "";
        if (r133 != null) goto L135;
    L137:
        if (r133 != null) goto L140;
    L142:
        if (r133 != null) goto L145;
    L147:
        if (r133 != null) goto L150;
    L152:
        if (r133 != null) goto L155;
    L157:
        if (r133 != null) goto L160;
    L162:
        String r32 = "";
    L163:
        r31[6] = TuplesKt.to("content_type", r32);
        o0 r33 = this.j;
        if (r33 == null) goto L166;
        String r34 = r33.k;
    L167:
        r31[7] = TuplesKt.to("group_id", r34);
        int r35 = com.bytedance.android.ec.window.base.utils.i.a;
        r31[8] = com.bytedance.android.ec.window.base.utils.i.a("c3129.d03542", false);
        r30.doEventAction("video_show", r31);
        ECWindowViewModel r36 = d0();
        Pair[] r37 = new Pair[4];
        r37[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r37[1] = TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation());
        Integer r38 = d0().getShopParam().getFollowStatus();
        if (r38 == null) goto L171;
        String r39 = String.valueOf(r38.intValue());
        if (r39 == null) goto L171;
    L172:
        r37[2] = TuplesKt.to("follow_status", r39);
        o0 r40 = this.j;
        if (r40 == null) goto L175;
        r134 = String.valueOf(r40.p);
    L175:
        r37[3] = TuplesKt.to("card_type", r134);
        r36.doEventAction("window_video_card_show", r37);
        return;
    L171:
        r39 = "";
        goto L172
    L166:
        r34 = null;
        goto L167
    L160:
        if (r133.intValue() != 204) goto L162;
    L161:
        r32 = "ecom_video";
        goto L163
    L155:
        if (r133.intValue() != 201) goto L157;
    L150:
        if (r133.intValue() != 205) goto L152;
    L151:
        r32 = "ecom_intent";
        goto L163
    L145:
        if (r133.intValue() != 202) goto L147;
    L140:
        if (r133.intValue() != 206) goto L142;
    L141:
        r32 = "replay";
        goto L163
    L135:
        if (r133.intValue() != 203) goto L137;
    L130:
        r133 = null;
        goto L131
    L126:
        r131 = null;
        goto L127
    }

    public final void i0(boolean r6) {
        ECWindowViewModel r0 = d0();
        Pair[] r1 = new Pair[5];
        r1[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r1[1] = TuplesKt.to("entrance_location", d0().getShopParam().getEntranceLocation());
        Integer r2 = d0().getShopParam().getFollowStatus();
        String r3 = "";
        if (r2 == null) goto L6;
        String r4 = String.valueOf(r2.intValue());
        if (r4 == null) goto L6;
    L7:
        r1[2] = TuplesKt.to("follow_status", r4);
        o0 r5 = this.j;
        if (r5 == null) goto L10;
        r3 = String.valueOf(r5.p);
    L10:
        r1[3] = TuplesKt.to("card_type", r3);
        if (r6 == false) goto L13;
        String r7 = "102";
    L14:
        r1[4] = TuplesKt.to("click_type", r7);
        r0.doEventAction("window_video_card_click", r1);
        return;
    L13:
        r7 = "100";
    L6:
        r4 = "";
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r27) {
        Intrinsics.checkNotNullParameter(r27, "v");
        int r0 = rp.a.a;
        if (rp.a.a(r27.getId()) == false) goto L5;
        return;
    L5:
        dm.a.b r2 = dm.a.a("WINDOW");
        StringBuilder r3 = new StringBuilder("[click video card]videoId:");
        o0 r4 = this.j;
        if (r4 == null) goto L8;
        String r5 = r4.k;
    L9:
        r3.append(r5);
        r2.i(r3.toString());
        dm.a.a("WINDOW").i("[click video card]secAuthorId:" + d0().getShopParam().getSecAuthorId());
        o0 r1 = this.j;
        if (r1 == null) goto L12;
        String r6 = r1.m;
    L14:
        if (r6 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == true) goto L248;
        d0().getLiveManager().c();
        o0 r8 = this.j;
        if (r8 == null) goto L25;
        String r9 = r8.m;
    L26:
        String r10 = "";
        if (r9 != null) goto L29;
        r9 = "";
    L29:
        int r11 = p0.a;
        String r12 = p0.g(r9, "enter_from", "store_window_video_tab_" + d0().getShopParam().getAuthorId());
        o0 r13 = this.j;
        if (r13 != null) goto L32;
    L33:
        if (r13 != null) goto L35;
    L40:
        int r14 = xp3.a.a;
        int r15 = yq3.a.a;
        int r16 = com.bytedance.android.ec.core.opt.ab.m.a;
        Object r17 = 0;
        boolean r18 = ECServiceManager.a;
        s83.g r19 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r19 == null) goto L46;
        s83.a r20 = r19.q();
        if (r20 == null) goto L46;
        Object r21 = r20.e("window_use_videolist_innerflow");
        if (r21 == null) goto L46;
    L211:
        if (((Number) r21).intValue() != 1) goto L213;
        boolean r22 = true;
    L214:
        if (r22 == false) goto L230;
        List<Long> r23 = ((WindowTabViewModelDeprecated) this.i.getValue()).getVideoIdCache();
        if (r23 == null) goto L230;
        o0 r24 = this.j;
        if (r24 == null) goto L220;
        Long r25 = r24.o;
    L221:
        if (r25 == null) goto L230;
        if (r24 == null) goto L224;
        Long r26 = r24.o;
    L225:
        long r110 = com.bytedance.android.shopping.extensions.k.h(r26);
        if (r23.size() <= 20) goto L229;
        int r28 = Math.min(r23.indexOf(Long.valueOf(r110)) + 20, r23.size());
        r23 = r23.subList(r28 - 20, r28);
    L229:
        r12 = p0.g(r12, "ids", CollectionsKt.joinToString$default(r23, null, null, null, 0, null, null, 63, null));
        goto L230
    L224:
        r26 = null;
        goto L225
    L220:
        r25 = null;
    L230:
        xn.b r29 = xn.b.f;
        Activity r30 = l0.b(Y().c());
        com.bytedance.android.ec.window.base.common.starter.h r31 = new com.bytedance.android.ec.window.base.common.starter.h(ECWindowStoreType.STORE, ECWindowSourceMethod.STORE_VIDEO_CARD);
        r29.getClass();
        Intrinsics.checkNotNullParameter(r12, "schema");
        Intrinsics.checkNotNullParameter(r31, "require");
        r29.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "schema");
        Intrinsics.checkNotNullParameter(r31, "require");
        if (r30 != null) goto L233;
    L232:
        String r32 = r10;
        int r33 = zq3.f.a;
        QContext r34 = Y();
        Context r35 = l0.c(r34.c());
        if ((r35 instanceof FragmentActivity) == true) goto L244;
        Context r36 = null;
    L245:
        if (r36 != null) goto L247;
        r36 = r34.a();
    L247:
        zq3.f.b(r36, d0(), r32, "c3129.d03542", PageFinder.via(((QFragmentPresenter) this).e), null);
        goto L248
    L244:
        r36 = r35;
        goto L245
    L233:
        JSONObject r37 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d("store_type", r31.a.getDes()), JsonDslUtilKt.d("source_method", r31.b.getDes())});
        xn.c.b(r37, l0.b(r30));
        String r38 = r37.toString();
        m0 r39 = new m0(r12);
        r39.b("enter_from", "store_page");
        r39.b("enter_method", PinchEnterMethod.CLICK);
        Activity r40 = l0.b(r30);
        if (r40 == null) goto L239;
        Intrinsics.checkNotNullParameter(r40, "$this$readInEntranceInfoAsString");
        Intrinsics.checkNotNullParameter("entrance_location", "key");
        JSONObject r41 = xn.c.c(r40);
        if (r41 != null) goto L238;
        r41 = new JSONObject();
    L238:
        String r42 = r41.optString("entrance_location");
    L240:
        r39.b(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r42);
        r39.b("tracker", r38);
        r10 = r39.c();
        goto L232
    L239:
        r42 = null;
        goto L240
    L213:
        r22 = false;
    L46:
        int r43 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r44 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L201
        Object r46 = com.bytedance.android.ec.base.settings.d.c.get("window_use_videolist_innerflow");     // Catch: Throwable -> L97
        if (r46 != null) goto L52;
    L94:
        Object r47 = null;
    L95:
        Object r48 = Result.constructor-impl(r47);     // Catch: Throwable -> L97
    L99:
        Throwable r49 = Result.exceptionOrNull-impl(r48);     // Catch: Throwable -> L201
        if (r49 == null) goto L103;
        EnsureManager.ensureNotReachHere(r49);     // Catch: Throwable -> L201
    L103:
        if (Result.isFailure-impl(r48) == false) goto L106;
        r48 = null;
    L106:
        if ((r48 instanceof Integer) == true) goto L108;
        r48 = null;
    L108:
        r21 = (Integer) r48;     // Catch: Throwable -> L201
        if (r21 != null) goto L115;
        Object r50 = com.bytedance.android.ec.base.settings.d.a.get("window_use_videolist_innerflow");     // Catch: Throwable -> L201
        if ((r50 instanceof Integer) == true) goto L114;
        r50 = null;
    L114:
        r21 = (Integer) r50;     // Catch: Throwable -> L201
    L115:
        if (r21 != null) goto L211;
        int r51 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L201
        Object r52 = com.bytedance.android.ec.base.settings.d.c.get("window_use_videolist_innerflow");     // Catch: Throwable -> L167
        if (r52 != null) goto L122;
    L164:
        Object r53 = null;
    L165:
        Object r54 = Result.constructor-impl(r53);     // Catch: Throwable -> L167
    L169:
        Throwable r55 = Result.exceptionOrNull-impl(r54);     // Catch: Throwable -> L192
        if (r55 == null) goto L173;
        EnsureManager.ensureNotReachHere(r55);     // Catch: Throwable -> L192
    L173:
        if (Result.isFailure-impl(r54) == false) goto L176;
        r54 = null;
    L176:
        if ((r54 instanceof Integer) == true) goto L178;
        r54 = null;
    L178:
        r21 = (Integer) r54;     // Catch: Throwable -> L192
        if (r21 != null) goto L199;
        IHybridHostService r56 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L192
        if (r56 == null) goto L184;
        Object r57 = r56.getHostABValue("window_use_videolist_innerflow", r17);     // Catch: Throwable -> L192
    L185:
        if (r57 != null) goto L187;
    L198:
        r21 = r17;
        goto L199
    L187:
        if ((r57 instanceof Integer) == true) goto L189;
        r57 = null;
    L189:
        r21 = (Integer) r57;     // Catch: Throwable -> L192
        if (r21 != null) goto L199;
    L192:
        th = move-exception;
        Result.Companion r58 = Result.Companion;     // Catch: Throwable -> L201
        r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L201
        Throwable r59 = Result.exceptionOrNull-impl(r21);     // Catch: Throwable -> L201
        if (r59 == null) goto L197;
        EnsureManager.ensureNotReachHere(r59);     // Catch: Throwable -> L201
    L197:
        if (Result.isFailure-impl(r21) == false) goto L199;
    L184:
        r57 = null;
    L199:
        com.bytedance.android.ec.base.settings.d.d("window_use_videolist_innerflow", r21);     // Catch: Throwable -> L201
        goto L211
    L122:
        if ((r52 instanceof Integer) == true) goto L124;
        Object r60 = null;
    L125:
        r53 = (Integer) r60;     // Catch: Throwable -> L167
        if (r53 != null) goto L165;
        if ((r52 instanceof Number) == false) goto L152;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L137;
        Float r61 = Float.valueOf(((Number) r52).floatValue());     // Catch: Throwable -> L167
        if ((r61 instanceof Integer) == true) goto L135;
        r61 = null;
    L135:
        r53 = (Integer) r61;     // Catch: Throwable -> L167
        goto L165
    L137:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L143;
        Double r62 = Double.valueOf(((Number) r52).doubleValue());     // Catch: Throwable -> L167
        if ((r62 instanceof Integer) == true) goto L141;
        r62 = null;
    L141:
        r53 = (Integer) r62;     // Catch: Throwable -> L167
        goto L165
    L143:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L146;
        r53 = Integer.valueOf(((Number) r52).intValue());     // Catch: Throwable -> L167
        goto L165
    L146:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L152;
        Long r63 = Long.valueOf(((Number) r52).longValue());     // Catch: Throwable -> L167
        if ((r63 instanceof Integer) == true) goto L150;
        r63 = null;
    L150:
        r53 = (Integer) r63;     // Catch: Throwable -> L167
    L152:
        if ((r52 instanceof JSONObject) == false) goto L154;
    L260:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L160
        Object r64 = SDKSettingsCacheManager.a().fromJson(r52.toString(), Integer.class);     // Catch: Throwable -> L160
        if ((r64 instanceof Integer) == true) goto L158;
        r64 = null;
    L158:
        Object r65 = Result.constructor-impl((Integer) r64);     // Catch: Throwable -> L160
    L162:
        r53 = r65;
        if (Result.isFailure-impl(r53) == false) goto L165;
    L160:
        th = move-exception;
        Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L167
        r65 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        goto L162
    L154:
        if ((r52 instanceof JSONArray) == false) goto L164;
    L124:
        r60 = r52;
    L167:
        th = move-exception;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L192
        r54 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L192
        goto L169
    L52:
        if ((r46 instanceof Integer) == true) goto L54;
        Object r68 = null;
    L55:
        r47 = (Integer) r68;     // Catch: Throwable -> L97
        if (r47 != null) goto L95;
        if ((r46 instanceof Number) == false) goto L82;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L67;
        Float r69 = Float.valueOf(((Number) r46).floatValue());     // Catch: Throwable -> L97
        if ((r69 instanceof Integer) == true) goto L65;
        r69 = null;
    L65:
        r47 = (Integer) r69;     // Catch: Throwable -> L97
        goto L95
    L67:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L73;
        Double r70 = Double.valueOf(((Number) r46).doubleValue());     // Catch: Throwable -> L97
        if ((r70 instanceof Integer) == true) goto L71;
        r70 = null;
    L71:
        r47 = (Integer) r70;     // Catch: Throwable -> L97
        goto L95
    L73:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L76;
        r47 = Integer.valueOf(((Number) r46).intValue());     // Catch: Throwable -> L97
        goto L95
    L76:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L82;
        Long r71 = Long.valueOf(((Number) r46).longValue());     // Catch: Throwable -> L97
        if ((r71 instanceof Integer) == true) goto L80;
        r71 = null;
    L80:
        r47 = (Integer) r71;     // Catch: Throwable -> L97
    L82:
        if ((r46 instanceof JSONObject) == false) goto L84;
    L258:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L90
        Object r72 = SDKSettingsCacheManager.a().fromJson(r46.toString(), Integer.class);     // Catch: Throwable -> L90
        if ((r72 instanceof Integer) == true) goto L88;
        r72 = null;
    L88:
        Object r73 = Result.constructor-impl((Integer) r72);     // Catch: Throwable -> L90
    L92:
        r47 = r73;
        if (Result.isFailure-impl(r47) == false) goto L95;
    L90:
        th = move-exception;
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L97
        r73 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L97
        goto L92
    L84:
        if ((r46 instanceof JSONArray) == false) goto L94;
    L54:
        r68 = r46;
    L97:
        th = move-exception;
        Result.Companion r75 = Result.Companion;     // Catch: Throwable -> L201
        r48 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L201
    L201:
        th = move-exception;
        Result.Companion r76 = Result.Companion;
        Object r77 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r78 = Result.exceptionOrNull-impl(r77);
        if (r78 == null) goto L206;
        EnsureManager.ensureNotReachHere(r78);
    L206:
        if (Result.isFailure-impl(r77) == true) goto L209;
        r17 = r77;
    L209:
        r21 = r17;
        goto L211
    L35:
        if (r13.p != 206) goto L40;
    L36:
        xn.b r79 = xn.b.f;
        Activity r80 = l0.b(Y().c());
        com.bytedance.android.ec.window.base.common.starter.g r81 = new com.bytedance.android.ec.window.base.common.starter.g(ECWindowStoreType.STORE, ECWindowSourceMethod.STORE_VIDEO_CARD);
        r79.getClass();
        Intrinsics.checkNotNullParameter(r12, "schema");
        Intrinsics.checkNotNullParameter(r81, "require");
        r79.b.getClass();
        Intrinsics.checkNotNullParameter(r12, "schema");
        Intrinsics.checkNotNullParameter(r81, "require");
        if (r80 == null) goto L248;
        JSONObject r82 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d("carrier_source", "store_page"), JsonDslUtilKt.d("store_type", r81.a.getDes()), JsonDslUtilKt.d("source_method", r81.b.getDes()), JsonDslUtilKt.d("enter_method", r81.b.getDes()), JsonDslUtilKt.d("carrier_type", r81.c), JsonDslUtilKt.d("source_page", r81.d), JsonDslUtilKt.d("ecom_group_type", r81.e), JsonDslUtilKt.d("enter_from_merge", "store_page")});
        xn.c.b(r82, l0.b(r80));
        String r83 = r82.toString();
        m0 r84 = new m0(r12);
        r84.b("enter_method", r81.b.getDes());
        r84.b("enter_from_merge", "store_page");
        r84.b("source_method", r81.b.getDes());
        r84.b("store_type", r81.a.getDes());
        r84.b("entrance_info", r83);
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r80, r84.c());
        goto L248
    L32:
        if (r13.p == 203) goto L36;
    L25:
        r9 = null;
    L248:
        i0(false);
        return;
    L16:
        if (r6.length() == 0) goto L19;
        r7 = false;
        goto L20
    L12:
        r6 = null;
        goto L14
    L8:
        r5 = null;
        goto L9
    }
}
