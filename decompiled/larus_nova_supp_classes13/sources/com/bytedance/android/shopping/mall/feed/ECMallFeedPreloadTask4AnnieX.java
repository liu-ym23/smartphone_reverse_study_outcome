package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
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
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedPreloadTask4AnnieX implements Runnable {
    public static final Lazy c = null;
    public final Context a;
    public final String b;

    public static final class a {
    }

    static {
        c = LazyKt.lazy(ECMallFeedPreloadTask4AnnieX$Companion$pageNameToConfigKeys$2.INSTANCE);
    }

    public final void a() {
        Object r0 = ((HashMap) c.getValue()).get(this.b);
        String r2 = (String) r0;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if ((!r3) == true) goto L13;
        r0 = null;
    L13:
        String r1 = (String) r0;
        if (r1 != null) goto L16;
        return;
    L16:
        int r4 = s93.c.a;
        Object r5 = new com.bytedance.android.shopping.mall.homepage.preload.j(null);
        IHybridHostService r6 = com.bytedance.android.ec.hybrid.a.h();
        if (r6 == null) goto L24;
        yj.g r7 = r6.getHostAB();
        if (r7 == null) goto L24;
        Object r8 = r7.a(r1, r5);
        if (r8 == null) goto L24;
        r5 = r8;
    L24:
        Lazy r9 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : " + r1 + ", Value: " + r5);
        com.bytedance.android.shopping.mall.homepage.preload.j r10 = (com.bytedance.android.shopping.mall.homepage.preload.j) r5;
        List<com.bytedance.android.shopping.mall.homepage.preload.i> r11 = r10.a();
        if (r11 != null) goto L27;
    L30:
        boolean r12 = true;
    L31:
        if (r12 == false) goto L34;
        boolean r13 = com.bytedance.android.ec.hybrid.monitor.f.a;
        com.bytedance.android.ec.hybrid.monitor.f.c("create", 0, "", 1, this.b);
        return;
    L34:
        LinkedHashMap r14 = new LinkedHashMap();
        if (Intrinsics.areEqual(this.b, MallPageName.X_TAB_MALL) == false) goto L37;
        String r15 = null;
    L38:
        String r16 = com.bytedance.android.shopping.mall.homepage.tools.q.a(this.a, r15);
        if (r16.length() <= 0) goto L41;
        boolean r17 = true;
    L42:
        if (r17 == true) goto L107;
    L51:
        HomePageDTO r18 = null;
    L52:
        if (r18 == null) goto L72;
        HomePageBffDTO r19 = r18.getBff();
        if (r19 == null) goto L72;
        ECHybridListDTO r20 = r19.getFeed();
        if (r20 == null) goto L72;
        List r21 = r20.getSections();
        if (r21 == null) goto L72;
        Iterator r22 = r21.iterator();
    L62:
        if (r22.hasNext() == false) goto L72;
        ArrayList r23 = ((ECHybridListSectionDTO) r22.next()).getItems();
        if (r23 == null) goto L62;
        Iterator r24 = r23.iterator();
    L67:
        if (r24.hasNext() == false) goto L62;
        ECHybridListItemDTO r25 = (ECHybridListItemDTO) r24.next();
        Integer r26 = r25.getItemType();
        String r27 = r25.getItemData();
        if (r26 == null) goto L67;
        if (r27 == null) goto L67;
        com.bytedance.android.shopping.api.mall.common.tools.b0.a(r14, Integer.valueOf(r26.intValue()), r27);
    L72:
        List<com.bytedance.android.shopping.mall.homepage.preload.i> r28 = r10.a();
        if (r28 == null) goto L104;
        Iterator<T> r29 = r28.iterator();
    L76:
        if (r29.hasNext() == false) goto L126;
        com.bytedance.android.shopping.mall.homepage.preload.i r30 = (com.bytedance.android.shopping.mall.homepage.preload.i) r29.next();
        Integer r31 = r30.a();
        if (r31 == null) goto L127;
        int r32 = r31.intValue();
        String r110 = r30.c();
        if (r110 == null) goto L128;
        Integer r33 = r30.a();
        if (r33 == null) goto L85;
        int r111 = r33.intValue();
    L86:
        Integer r34 = r30.b();
        if (r34 == null) goto L89;
        int r35 = r34.intValue();
    L90:
        int r112 = 0;
    L91:
        if (r112 >= r35) goto L76;
        Lazy r36 = ECLynxAnnieXService.a;
        Context r37 = this.a;
        List r38 = (List) r14.get(Integer.valueOf(r32));
        if (r38 == null) goto L99;
        Intrinsics.checkNotNullParameter(r38, "$this$firstAndRemove");
        if (r38.isEmpty() == false) goto L97;
        Object r39 = null;
    L98:
        String r113 = (String) r39;
    L100:
        Lazy r40 = MallBehaviorUtil.a;
        int r114 = r112;
        Pair r41 = ECLynxAnnieXService.e(new com.bytedance.android.ec.hybrid.card.cache.view.a(r37, r110, r113, MallBehaviorUtil.a(new MallBehaviorUtil.a(this.b, r110)), r111, this.b));
        if (r41 == null) goto L103;
        ECLynxAnnieXService.f(this.a, this.b, r41);
    L103:
        r112 = r114 + 1;
        goto L91
    L97:
        r39 = ListProtector.remove(r38, 0);
        goto L98
    L99:
        r113 = null;
        goto L100
    L89:
        r35 = 1;
        goto L90
    L85:
        r111 = 0;
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
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L49
        r18 = (HomePageDTO) new Gson().fromJson(r16, HomePageDTO.class);     // Catch: JSONException -> L46 Throwable -> L49
    L46:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L41:
        r17 = false;
        goto L42
    L37:
        r15 = this.b;
        goto L38
    L27:
        if (r11.isEmpty() == true) goto L30;
        r12 = false;
        goto L31
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L10
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

    public ECMallFeedPreloadTask4AnnieX(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pageName");
        this.a = r2;
        this.b = r3;
    }
}
