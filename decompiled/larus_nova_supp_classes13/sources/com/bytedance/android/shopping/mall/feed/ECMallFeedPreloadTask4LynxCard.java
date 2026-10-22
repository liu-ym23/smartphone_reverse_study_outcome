package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import com.bytedance.android.ec.hybrid.card.service.KitViewCacheService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.common.tools.MallBehaviorUtil;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedPreloadTask4LynxCard implements Runnable {
    public static final Lazy e = null;
    public final Lazy a;
    public final Lazy b;
    public final Context c;
    public final String d;

    public static final class a {
    }

    static {
        e = LazyKt.lazy(ECMallFeedPreloadTask4LynxCard$Companion$pageNameToConfigKeys$2.INSTANCE);
    }

    public final void a() {
        Object r0 = ((HashMap) e.getValue()).get(this.d);
        String r2 = (String) r0;
        int r3 = 0;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        String r5 = null;
        if ((!r4) == true) goto L13;
        r0 = null;
    L13:
        String r1 = (String) r0;
        if (r1 != null) goto L16;
        return;
    L16:
        int r6 = s93.c.a;
        Object r7 = new com.bytedance.android.shopping.mall.homepage.preload.j(null);
        IHybridHostService r8 = com.bytedance.android.ec.hybrid.a.h();
        if (r8 == null) goto L24;
        yj.g r9 = r8.getHostAB();
        if (r9 == null) goto L24;
        Object r10 = r9.a(r1, r7);
        if (r10 == null) goto L24;
        r7 = r10;
    L24:
        Lazy r11 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : " + r1 + ", Value: " + r7);
        com.bytedance.android.shopping.mall.homepage.preload.j r12 = (com.bytedance.android.shopping.mall.homepage.preload.j) r7;
        List<com.bytedance.android.shopping.mall.homepage.preload.i> r13 = r12.a();
        if (r13 != null) goto L27;
    L30:
        boolean r14 = true;
    L31:
        if (r14 == false) goto L34;
        boolean r15 = com.bytedance.android.ec.hybrid.monitor.f.a;
        com.bytedance.android.ec.hybrid.monitor.f.c("create", 0, "", 1, this.d);
        return;
    L34:
        LinkedHashMap r16 = new LinkedHashMap();
        if (Intrinsics.areEqual(this.d, MallPageName.X_TAB_MALL) == false) goto L37;
        String r17 = null;
    L38:
        String r18 = com.bytedance.android.shopping.mall.homepage.tools.q.a(this.c, r17);
        if (r18.length() <= 0) goto L41;
        boolean r19 = true;
    L42:
        if (r19 == true) goto L107;
    L51:
        HomePageDTO r20 = null;
    L52:
        if (r20 == null) goto L72;
        HomePageBffDTO r21 = r20.getBff();
        if (r21 == null) goto L72;
        ECHybridListDTO r22 = r21.getFeed();
        if (r22 == null) goto L72;
        List r23 = r22.getSections();
        if (r23 == null) goto L72;
        Iterator r24 = r23.iterator();
    L62:
        if (r24.hasNext() == false) goto L72;
        ArrayList r25 = ((ECHybridListSectionDTO) r24.next()).getItems();
        if (r25 == null) goto L62;
        Iterator r26 = r25.iterator();
    L67:
        if (r26.hasNext() == false) goto L62;
        ECHybridListItemDTO r27 = (ECHybridListItemDTO) r26.next();
        Integer r28 = r27.getItemType();
        String r29 = r27.getItemData();
        if (r28 == null) goto L67;
        if (r29 == null) goto L67;
        com.bytedance.android.shopping.api.mall.common.tools.b0.a(r16, Integer.valueOf(r28.intValue()), r29);
    L72:
        List<com.bytedance.android.shopping.mall.homepage.preload.i> r30 = r12.a();
        if (r30 == null) goto L104;
        Iterator<T> r31 = r30.iterator();
    L76:
        if (r31.hasNext() == false) goto L126;
        com.bytedance.android.shopping.mall.homepage.preload.i r32 = (com.bytedance.android.shopping.mall.homepage.preload.i) r31.next();
        Integer r33 = r32.a();
        if (r33 == null) goto L127;
        int r34 = r33.intValue();
        String r110 = r32.c();
        if (r110 == null) goto L128;
        Integer r35 = r32.b();
        if (r35 == null) goto L85;
        int r111 = r35.intValue();
    L86:
        int r112 = 0;
    L87:
        if (r112 >= r111) goto L76;
        Integer r36 = r32.a();
        if (r36 == null) goto L91;
        int r113 = r36.intValue();
    L92:
        List r37 = (List) r16.get(Integer.valueOf(r34));
        if (r37 == null) goto L99;
        Intrinsics.checkNotNullParameter(r37, "$this$firstAndRemove");
        if (r37.isEmpty() == false) goto L97;
        Object r38 = r5;
    L98:
        String r114 = (String) r38;
    L100:
        com.bytedance.android.ec.hybrid.card.cache.view.b r115 = (com.bytedance.android.ec.hybrid.card.cache.view.b) this.a.getValue();
        Context r39 = this.c;
        Lazy r40 = MallBehaviorUtil.a;
        int r41 = r112;
        int r116 = r113;
        int r117 = r111;
        com.bytedance.android.ec.hybrid.card.api.a r42 = r115.a(new com.bytedance.android.ec.hybrid.card.cache.view.a(r39, r110, r114, MallBehaviorUtil.a(new MallBehaviorUtil.a(this.d, r110)), r116, this.d));
        if (r42 == null) goto L103;
        ((KitViewCacheService) this.b.getValue()).f(this.c, this.d, r42.k, r42);
    L103:
        r112 = r41 + 1;
        r111 = r117;
        r3 = 0;
        r5 = null;
        goto L87
    L97:
        r38 = ListProtector.remove(r37, r3);
        goto L98
    L99:
        r114 = r5;
        goto L100
    L91:
        r113 = 0;
        goto L92
    L85:
        r111 = 1;
        goto L86
    L128:
        return;
    L127:
        return;
    L126:
        return;
    L104:
        return;
    L107:
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L49
        r20 = (HomePageDTO) new Gson().fromJson(r18, HomePageDTO.class);     // Catch: JSONException -> L46 Throwable -> L49
    L46:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L41:
        r19 = false;
        goto L42
    L37:
        r17 = this.d;
        goto L38
    L27:
        if (r13.isEmpty() == true) goto L30;
        r14 = false;
        goto L31
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r4 = false;
        goto L9
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

    public ECMallFeedPreloadTask4LynxCard(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pageName");
        this.c = r2;
        this.d = r3;
        this.a = LazyKt.lazy(ECMallFeedPreloadTask4LynxCard$kitViewCreator$2.INSTANCE);
        this.b = LazyKt.lazy(ECMallFeedPreloadTask4LynxCard$cacheService$2.INSTANCE);
    }
}
