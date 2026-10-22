package com.bytedance.android.shopping.card_list.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.container.CardListDialogFragment;
import com.bytedance.android.shopping.card_list.container.CardListFragment;
import com.bytedance.android.shopping.card_list.container.init.BaseCardListContainer;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.card_list.perf.cache.CardListCacheManager;
import com.bytedance.android.shopping.card_list.utils.CardListCommonLog;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.android.shopping.card_list.utils.h;
import com.bytedance.android.shopping.card_list.utils.i;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements sc3.d {
    public static long a;
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static void c(Context r19, Uri r20, Map r21) {
        String r3 = UUID.randomUUID().toString();
        String r5 = UriProtector.getQueryParameter(r20, "new_source_type");
        String r6 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        Map<String, Map<String, Long>> r7 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a(r3, r5, CardListExtentionsKt.f(r21, PdpOpenThirdParam.KEY_PAGE_NAME, ""));
        int r8 = CardListKitStarter.i;
        final CardListKitStarter r9 = CardListKitStarter.a.a(r3, r21);
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "uri");
        ph.a.a(r19);
        String r10 = UriProtector.getQueryParameter(r20, "history_path");
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        if (((Boolean) r9.b.getValue()).booleanValue() == true) goto L16;
        int r11 = k.r(UriProtector.getQueryParameter(r20, "cart_height_percent"), 0);
        if (1 > r11) goto L15;
        if (99 >= r11) goto L16;
    L15:
        String r12 = "CardListActivity";
    L17:
        r9.c(r10, r12);
        String r4 = UriProtector.getQueryParameter(r20, "new_source_type");
        if (r4 == null) goto L21;
        r6 = r4;
    L21:
        r9.a = r6;
        if (CardListExtentionsKt.c(r9.h, "opt_preload_layout", false) == false) goto L24;
        int r13 = cb3.a.a;
        Intrinsics.checkNotNullParameter(r19, "context");
        Map r14 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r19).a().a(2131559260, 1).a(2131559255, 1).commit();
    L24:
        new CardListCacheManager(r9.g, r9.a, r9.e, r9.h).a();
        com.bytedance.android.shopping.card_list.container.init.f r15 = (com.bytedance.android.shopping.card_list.container.init.f) r9.d.getValue();
        if (r15 == null) goto L27;
        r15.d(r19);
    L27:
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r9.g, "ParseRouterUri");
        CardPassThroughData r16 = r9.b(j1.a(r20));
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r9.g, "LaunchCardListActivity");
        CardListContainerConfig.a r17 = CardListContainerConfig.Companion;
        Map<String, Object> r18 = r9.h;
        r17.getClass();
        CardListContainerConfig r22 = CardListContainerConfig.a.a(r18);
        Boolean r23 = Boolean.FALSE;
        int r24 = h.a;
        Intrinsics.checkNotNullParameter(r19, "context");
        nj.d r25 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r25 == null) goto L32;
        r25.l();
    L32:
        if ((!Intrinsics.areEqual(r23, Boolean.TRUE)) == false) goto L74;
        Context r26 = null;
        r16.setSplitActivityScene(null);
        CartPassThroughData r27 = r16.getCartSchemaData();
        if (r27 == null) goto L36;
        r27.setHeightPercent(k.r(UriProtector.getQueryParameter(r20, "cart_height_percent"), 0));
    L36:
        CartPassThroughData r28 = r16.getCartSchemaData();
        if (r28 != null) goto L39;
    L40:
        HashMap<String, String> r29 = r16.getSchemaParams();
        if (r29 == null) goto L48;
        CartPassThroughData r30 = r16.getCartSchemaData();
        if (r30 == null) goto L45;
        Integer r31 = Integer.valueOf(r30.getHeightPercent());
    L46:
        String r32 = r29.put("cart_height_percent", String.valueOf(r31));
        goto L48
    L45:
        r31 = null;
    L48:
        if (((Boolean) r9.b.getValue()).booleanValue() == true) goto L56;
        int r33 = k.r(UriProtector.getQueryParameter(r20, "cart_height_percent"), 0);
        if (1 <= r33) goto L53;
    L55:
        r22.setPageType("CardListActivity");
        int r34 = BaseCardListContainer.y;
        BaseCardListContainer.a.a(r19, r16, r9.g, r22);
        goto L74
    L53:
        if (99 < r33) goto L55;
    L56:
        Lazy r35 = CardListCommonLog.a;
        CardListCommonLog.a("CardListKitStarter", new CardListKitStarter$openDirectly$2(r9));
        int r36 = BaseCardListContainer.y;
        CardListDialogFragment r37 = BaseCardListContainer.a.b(r16, r9.g, r22);
        if ((r19 instanceof FragmentActivity) == false) goto L60;
        r26 = r19;
    L60:
        FragmentActivity r38 = (FragmentActivity) r26;
        if (r38 != null) goto L63;
        BaseCardListContainer.a.a(r19, r16, r9.g, r22);
        goto L74
    L63:
        if (r38.isDestroyed() == false) goto L65;
    L72:
        r22.setPageType("CardListActivity");
        BaseCardListContainer.a.a(r19, r16, r9.g, r22);
        goto L74
    L65:
        if (r38.isFinishing() == true) goto L72;
        r22.setPageType("CardListDialogFragment");
        FragmentManager r39 = r38.getSupportFragmentManager();
        r39.beginTransaction().remove(r37).commitAllowingStateLoss();
        LandscapeRestrictionOperation r40 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r37, "CardListDialogFragment", r40);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r39, r37, r40) == true) goto L74;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L84
    L71:
        r37.show(r39, "CardListDialogFragment");
        goto L74
    L39:
        if (r28.getHeightPercent() == 0) goto L48;
    L74:
        String r41 = com.bytedance.android.shopping.card_list.monitor.a.a;
        ConcurrentHashMap<String, String> r42 = com.bytedance.android.shopping.base.event.a.a;
        com.bytedance.android.shopping.base.event.a.d(com.bytedance.android.shopping.card_list.monitor.a.a, "schema_parse", "end", null, false, null, 56);
        if (((Boolean) r9.c.getValue()).booleanValue() == false) goto L79;
        Map<String, Map<String, Long>> r43 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r9.g, "FirstQuery");
        com.bytedance.android.shopping.card_list.container.init.f r44 = (com.bytedance.android.shopping.card_list.container.init.f) r9.d.getValue();
        if (r44 == null) goto L79;
        r44.b(r16, new CardListKitStarter$queryData$1(r9, r16, r22));
    L79:
        Map<String, Map<String, Long>> r45 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r9.g, "OpenDirectlyEnd");
        if (CardListExtentionsKt.d(r21, "biz_type", 0) != LauncherBizType.CART.ordinal()) goto L82;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r3, "CheckParams");
        t.b(new c(r19, r20));
    L82:
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r3, "RouterOpenEnd");
        return;
    L16:
        r12 = "CardListDialogFragment";
        goto L17
    }

    @Override // sc3.d
    public final CardListFragment a(Context r11, Map r12, Map r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "pageConfig");
        Intrinsics.checkNotNullParameter(r13, "params");
        Integer r3 = CardListExtentionsKt.b(((LinkedHashMap) r12).get("biz_type"));
        if (r3 == null) goto L18;
        int r4 = r3.intValue();
        LauncherBizType[] r5 = LauncherBizType.values();
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L13;
        LauncherBizType r8 = r5[r7];
        if (r8.ordinal() != r4) goto L9;
        boolean r9 = true;
    L10:
        if (r9 == true) goto L14;
        r7 = r7 + 1;
    L14:
        if (r8 == null) goto L17;
        com.bytedance.android.shopping.card_list.monitor.a.b(r8);
        goto L18
    L17:
        throw new IllegalArgumentException("Invalid enum value: " + r4);
    L9:
        r9 = false;
        goto L10
    L13:
        r8 = null;
    L18:
        LinkedHashMap r10 = (LinkedHashMap) r13;
        String r14 = (String) r10.get("new_source_type");
        if (r14 != null) goto L21;
        r14 = "";
    L21:
        String r15 = UUID.randomUUID().toString();
        Map<String, Map<String, Long>> r16 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a(r15, r14, CardListExtentionsKt.f(r12, PdpOpenThirdParam.KEY_PAGE_NAME, ""));
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r15, "RouterOpenEnd");
        int r17 = CardListKitStarter.i;
        CardListKitStarter r18 = CardListKitStarter.a.a(r15, r12);
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "params");
        ph.a.a(r11);
        String r0 = (String) r10.get("history_path");
        if (r0 != null) goto L24;
        r0 = (String) r10.get("previous_page");
    L24:
        r18.c(r0, "CardListFragment");
        r18.a = (String) r10.get("new_source_type");
        new CardListCacheManager(r18.g, r18.a, r18.e, r18.h).a();
        com.bytedance.android.shopping.card_list.container.init.f r1 = (com.bytedance.android.shopping.card_list.container.init.f) r18.d.getValue();
        if (r1 == null) goto L27;
        r1.d(r11);
    L27:
        HashMap<String, String> r19 = new HashMap();
        r19.putAll(r13);
        Unit r110 = Unit.INSTANCE;
        CardPassThroughData r111 = r18.b(r19);
        CardListContainerConfig.a r112 = CardListContainerConfig.Companion;
        Map<String, Object> r2 = r18.h;
        r112.getClass();
        CardListContainerConfig r113 = CardListContainerConfig.a.a(r2);
        r113.setPageType("CardListFragment");
        String r20 = com.bytedance.android.shopping.card_list.monitor.a.a;
        ConcurrentHashMap<String, String> r21 = com.bytedance.android.shopping.base.event.a.a;
        com.bytedance.android.shopping.base.event.a.d(com.bytedance.android.shopping.card_list.monitor.a.a, "schema_parse", "end", null, false, null, 56);
        if (((Boolean) r18.c.getValue()).booleanValue() == false) goto L32;
        com.bytedance.android.shopping.card_list.container.init.f r22 = (com.bytedance.android.shopping.card_list.container.init.f) r18.d.getValue();
        if (r22 == null) goto L32;
        r22.b(r111, new CardListKitStarter$queryData$1(r18, r111, r113));
    L32:
        int r23 = BaseCardListContainer.y;
        String r114 = r18.g;
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r114, "sessionId");
        Intrinsics.checkNotNullParameter(r113, "pageConfig");
        CardListFragment r24 = new CardListFragment();
        Bundle r25 = new Bundle();
        r25.putSerializable("pass_through_data", r111);
        r25.putString("PrefetchSessionId", r114);
        r25.putSerializable("page_config", r113);
        r24.setArguments(r25);
        return r24;
    }

    @Override // sc3.d
    public final boolean b(final Context r13, String r14, final Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "schema");
        Intrinsics.checkNotNullParameter(r15, "pageConfig");
        if ((System.currentTimeMillis() - a) >= 1500) goto L6;
        return false;
    L6:
        if (r14.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        Integer r3 = CardListExtentionsKt.b(((LinkedHashMap) r15).get("biz_type"));
        Context r4 = null;
        if (r3 == null) goto L27;
        int r5 = r3.intValue();
        LauncherBizType[] r7 = LauncherBizType.values();
        int r8 = r7.length;
        int r9 = 0;
    L14:
        if (r9 >= r8) goto L22;
        LauncherBizType r10 = r7[r9];
        if (r10.ordinal() != r5) goto L18;
        boolean r11 = true;
    L19:
        if (r11 == true) goto L23;
        r9 = r9 + 1;
    L23:
        if (r10 == null) goto L26;
        com.bytedance.android.shopping.card_list.monitor.a.b(r10);
        goto L27
    L26:
        throw new IllegalArgumentException("Invalid enum value: " + r5);
    L18:
        r11 = false;
        goto L19
    L22:
        r10 = null;
    L27:
        a = System.currentTimeMillis();
        final Uri r12 = UriProtector.parse(r14);
        if (CardListExtentionsKt.c(r15, "need_check_login", false) == false) goto L39;
        String r0 = UriProtector.getQueryParameter(r12, "new_source_type");
        if (r0 != null) goto L32;
        r0 = "";
    L32:
        final String r16 = r0;
        if ((r13 instanceof Activity) == false) goto L36;
        r4 = r13;
    L36:
        Activity r17 = (Activity) r4;
        if (r17 == null) goto L40;
        int r1 = i.a;
        i.a(r17, r16, new CardListKitPublicService$checkLoginAndOpen$$inlined$let$lambda$1(this, r16, r13, r12, r15), CardListKitPublicService$checkLoginAndOpen$1$2.INSTANCE);
    L40:
        return true;
    L39:
        c(r13, r12, r15);
        goto L40
    L8:
        r2 = false;
        goto L9
    }
}
