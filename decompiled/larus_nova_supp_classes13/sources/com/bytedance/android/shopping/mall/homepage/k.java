package com.bytedance.android.shopping.mall.homepage;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.model.SingleCardData;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.android.shopping.mall.homepage.card.ECMallLoginGuideCard;
import com.bytedance.android.shopping.mall.homepage.component.ECMFTopBarComponent;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallLoginController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements com.bytedance.android.shopping.mall.feed.help.j {
    public final /* synthetic */ ECMallFragment a;
    public final /* synthetic */ ECMallFeed b;

    @Override // com.bytedance.android.shopping.mall.feed.help.j
    public final void e(boolean r12) {
        if (r12 == true) goto L55;
        ECMallFragment r13 = this.a;
        if (r13.H2 == true) goto L6;
    L10:
        boolean r14 = false;
    L11:
        if (r14 == false) goto L56;
        boolean r15 = com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostUserService().isLogin();
        if (this.a.I3 == true) goto L15;
        this.a.Na0(Boolean.valueOf(r15));
        this.a.I3 = true;
    L15:
        if (r15 == true) goto L57;
        ECMallFragment r16 = this.a;
        if (r16.L3 == true) goto L58;
        ECHybridListEngine r0 = r16.H0;
        if (r0 == null) goto L50;
        ECMallLoginGuideCard.a r4 = ECMallLoginGuideCard.t;
        String r5 = r16.M3;
        String r6 = r16.N3;
        String r17 = r16.O3;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "listEngine");
        com.bytedance.android.ec.hybrid.list.entity.i r7 = new com.bytedance.android.ec.hybrid.list.entity.i();
        r7.f = 1;
        r7.a = "ec_mall_login_guide_section";
        ArrayList r8 = new ArrayList();
        ECHybridListItemVO r9 = new ECHybridListItemVO();
        r9.c = Integer.valueOf(ECHybridListItemType.LOGIN_GUIDE_CARD.getType());
        JSONObject r10 = new JSONObject();
        if (r5 != null) goto L23;
    L25:
        if (r6 != null) goto L27;
    L29:
        if (r17 != null) goto L31;
    L33:
        Unit r18 = Unit.INSTANCE;
        r9.o(r10);
        r8.add(r9);
        r7.i = r8;
        com.bytedance.android.ec.hybrid.list.entity.k r19 = r0.c.g;
        if (r19 == null) goto L49;
        ArrayList r110 = r19.c;
        if (r110 == null) goto L49;
        Iterator r111 = r110.iterator();
    L39:
        if (r111.hasNext() == false) goto L43;
        Object r11 = r111.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r11).a, "favorite_section") == false) goto L39;
    L44:
        com.bytedance.android.ec.hybrid.list.entity.i r20 = (com.bytedance.android.ec.hybrid.list.entity.i) r11;
        if (r20 == null) goto L49;
        com.bytedance.android.ec.hybrid.list.entity.j r112 = r20.h;
        if (r112 == null) goto L49;
        com.bytedance.android.ec.hybrid.list.entity.j r21 = new com.bytedance.android.ec.hybrid.list.entity.j();
        r21.i = r112.i;
        r21.k = r112.k;
        Unit r113 = Unit.INSTANCE;
        r7.h = r21;
        goto L49
    L43:
        r11 = null;
    L49:
        com.bytedance.android.ec.hybrid.list.entity.k r114 = new com.bytedance.android.ec.hybrid.list.entity.k();
        r114.c = CollectionsKt.arrayListOf(new com.bytedance.android.ec.hybrid.list.entity.i[]{r7});
        r0.c(r114);
        goto L50
    L31:
        if ((!StringsKt.isBlank(r17)) != true) goto L33;
        r10.put("login_desc", r17);
        goto L33
    L27:
        if ((!StringsKt.isBlank(r6)) != true) goto L29;
        r10.put("theme_id", r6);
        goto L29
    L23:
        if ((!StringsKt.isBlank(r5)) != true) goto L25;
        r10.put("banner_url", r5);
    L50:
        ECMallFragment r115 = this.a;
        r115.M3 = null;
        r115.L3 = true;
        this.b.e0 = true;
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L6:
        if (r13.J2 == true) goto L10;
        if (r13.S1 == true) goto L10;
        r14 = true;
        goto L11
    }

    public k(ECMallFragment r1, ECMallFeed r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.j
    public final void c(List r22, int r23) {
        Intrinsics.checkNotNullParameter(GYLFetchType.LOAD_MORE, "fetchType");
        Intrinsics.checkNotNullParameter(r22, "apiKeyList");
        this.a.e.c(r22, r23);
        int r3 = 0;
        if (Intrinsics.areEqual(GYLFetchType.LOAD_MORE, GYLFetchType.LOAD_MORE) == false) goto L21;
        IHybridHostService r1 = com.bytedance.android.ec.hybrid.a.h();
        if (r1 == null) goto L21;
        yj.g r2 = r1.getHostAB();
        if (r2 == null) goto L21;
        com.bytedance.android.ec.hybrid.data.i r4 = r2.k();
        if (r4 == null) goto L21;
        if (r4.e <= 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L21;
        v93.a.c.getClass();
        Pair r6 = v93.a.a();
        if (r6 == null) goto L21;
        JSONObject r7 = (JSONObject) r6.getFirst();
        int r8 = -1;
        if (r7 == null) goto L20;
        r8 = r7.optInt("mall_scroll_mode", -1);
    L20:
        r4.a = r8;
        goto L21
    L13:
        r5 = false;
    L21:
        this.a.getClass();
        com.bytedance.android.shopping.api.mall.common.tools.h r9 = com.bytedance.android.shopping.api.mall.common.tools.h.b;
        boolean r10 = r9.getIHybridHostUserService().isLogin();
        this.a.Na0(Boolean.valueOf(r10));
        if (r10 == true) goto L74;
        ECMallFragment r11 = this.a;
        if (r11.P3 == true) goto L26;
        return;
    L26:
        if (r11.J3 == false) goto L28;
        return;
    L28:
        if (this.b.M != ((Number) r11.B3.getValue()).intValue()) goto L77;
        ECMallLoginController r12 = (ECMallLoginController) this.a.K3.getValue();
        if (r12 == null) goto L72;
        ECMallFragment r13 = this.a;
        String r14 = r13.N3;
        String r15 = r13.O3;
        Lazy r16 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L72;
        com.bytedance.android.shopping.mall.utils.a r17 = r12.a();
        r17.getClass();
        Intrinsics.checkNotNullParameter("last_open_half_screen_login_page_timestamp", "key");
        long r18 = -1;
        if (StringsKt.isBlank("last_open_half_screen_login_page_timestamp") == true) goto L38;
        r18 = r17.a().getLong("last_open_half_screen_login_page_timestamp", -1);
    L38:
        long r19 = System.currentTimeMillis();
        long r110 = r19 - r18;
        com.bytedance.android.shopping.mall.utils.a r20 = r12.a();
        r20.getClass();
        Intrinsics.checkNotNullParameter("total_open_half_screen_login_page_count", "key");
        if (StringsKt.isBlank("total_open_half_screen_login_page_count") == false) goto L41;
        int r21 = 0;
    L43:
        if (0 > r110) goto L50;
        if (86400000 < r110) goto L50;
        if (r21 < 1) goto L56;
    L59:
        if (r3 == 0) goto L72;
        Activity r111 = ECHybridExtensionsKt.a(r12.b);
        if (r111 == null) goto L72;
        yj.s r112 = r9.getIHybridHostUserService();
        Bundle r24 = new Bundle();
        r24.putBoolean("show_half_page", true);
        if (r14 == null) goto L67;
        String r25 = b0.k(r14);
        if (r25 == null) goto L67;
        r24.putString("themeId", r25);
    L67:
        if (r15 == null) goto L71;
        String r26 = b0.k(r15);
        if (r26 == null) goto L71;
        r24.putString("loginDesc", r26);
    L71:
        Unit r27 = Unit.INSTANCE;
        r112.e(r111, "legou_login_guide_slide", "legou_login_guide_slide", null, null);
        r12.a().c("last_open_half_screen_login_page_timestamp", Long.valueOf(r19));
        r12.a().c("total_open_half_screen_login_page_count", Integer.valueOf(r21 + 1));
    L56:
        r3 = r21;
    L58:
        r21 = r3;
        r3 = 1;
    L50:
        if (86400001 <= r110) goto L53;
    L57:
        r12.a().delete("last_open_half_screen_login_page_timestamp");
        r12.a().delete("total_open_half_screen_login_page_count");
        goto L58
    L53:
        if (2592000000L < r110) goto L57;
        if (r21 >= 3) goto L59;
    L41:
        r21 = r20.a().getInt("total_open_half_screen_login_page_count", 0);
    L72:
        this.a.J3 = true;
        return;
    L77:
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.j
    public final void d(String r2, boolean r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "fetchType");
        Intrinsics.checkNotNullParameter(r4, "apiKey");
        if (r5 == null) goto L13;
        String r6 = b0.k(r5);
        if (r6 == null) goto L14;
        if (r3 == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r4, "suggest_words") == false) goto L16;
        ECMFTopBarComponent r7 = this.a.e.d;
        if (r7 == null) goto L17;
        r7.s(r6);
        return;
    L17:
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.j
    public final void f(String r3, boolean r4, HomePageDTO r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "fetchType");
        if (r4 == false) goto L44;
        ECMallFragment r7 = this.a;
        int r8 = ECMallFragment.h4;
        r7.getClass();
        Lazy r9 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "handleLoadMoreSucc");
        int r10 = com.bytedance.forest.utils.h.a;
        String r11 = null;
        if (r5 == null) goto L11;
        HomePageBffDTO r0 = r5.getBff();
        if (r0 == null) goto L11;
        SingleCardData r1 = r0.getPopup();
        if (r1 == null) goto L11;
        String r2 = r1.getLynxData();
    L13:
        if (com.bytedance.forest.utils.h.a(r2) == false) goto L34;
        ECLynxCard r12 = r7.k1;
        if (r12 != null) goto L25;
        List<String> r13 = r7.h1;
        if (r5 == null) goto L23;
        HomePageBffDTO r14 = r5.getBff();
        if (r14 == null) goto L23;
        SingleCardData r15 = r14.getPopup();
        if (r15 == null) goto L23;
        String r16 = r15.getLynxData();
    L24:
        Intrinsics.checkNotNull(r16);
        ((ArrayList) r13).add(r16);
    L23:
        r16 = null;
        goto L24
    L25:
        int r17 = com.bytedance.android.ec.hybrid.card.api.d.e;
        if (r5 == null) goto L32;
        HomePageBffDTO r18 = r5.getBff();
        if (r18 == null) goto L32;
        SingleCardData r19 = r18.getPopup();
        if (r19 == null) goto L32;
        String r20 = r19.getLynxData();
    L33:
        Intrinsics.checkNotNull(r20);
        r12.e(com.bytedance.android.ec.hybrid.card.api.d.a.b(r20), true);
    L32:
        r20 = null;
    L34:
        ECMFTopBarComponent r21 = r7.e.d;
        if (r21 == null) goto L43;
        if (r5 == null) goto L42;
        HomePageBffDTO r22 = r5.getBff();
        if (r22 == null) goto L42;
        SingleCardData r23 = r22.getTopBar();
        if (r23 == null) goto L42;
        r11 = r23.getLynxData();
    L42:
        r21.x(r11);
    L43:
        r7.Na0(Boolean.valueOf(com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostUserService().isLogin()));
        this.a.H3 = 0;
        return;
    L11:
        r2 = null;
        goto L13
    L44:
        this.a.H3++;
    }
}
