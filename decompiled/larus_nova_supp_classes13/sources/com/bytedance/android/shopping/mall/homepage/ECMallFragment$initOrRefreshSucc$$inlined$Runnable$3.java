package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$initOrRefreshSucc$$inlined$Runnable$3 implements Runnable {
    public final /* synthetic */ ECMallFragment a;
    public final /* synthetic */ HomePageDTO b;
    public final /* synthetic */ boolean c;

    public ECMallFragment$initOrRefreshSucc$$inlined$Runnable$3(ECMallFragment r1, HomePageDTO r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        HomePageBffDTO r0 = this.b.getBff();
        if (r0 == null) goto L5;
        ECHybridListDTO r1 = r0.getFeed();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.a.H0 == null) goto L99;
        Lazy r2 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.a.b, "initOrRefreshSucc, start handle feed");
        final boolean r9 = Intrinsics.areEqual(this.a.L, Boolean.TRUE);
        if (r9 == true) goto L21;
        ECMallFragment r3 = this.a;
        ECHybridListEngine r4 = r3.H0;
        if (r4 == null) goto L14;
        com.bytedance.android.ec.hybrid.list.entity.k r5 = r4.c.g;
    L15:
        if (r5 != null) goto L17;
    L18:
        DataEngineWrapper r6 = r3.L0;
        if (r6 == null) goto L21;
        r6.p(System.currentTimeMillis());
        goto L21
    L17:
        if (r3.e4 == false) goto L21;
    L14:
        r5 = null;
    L21:
        DataEngineWrapper r7 = this.a.L0;
        if (r7 == null) goto L24;
        r7.L(new ECMallFragment$initOrRefreshSucc$$inlined$Runnable$3$lambda$1(r9));
    L24:
        List r8 = r1.getSections();
        if (r8 == null) goto L36;
        Iterator r10 = r8.iterator();
    L28:
        if (r10.hasNext() == false) goto L36;
        ECHybridListSectionDTO r11 = (ECHybridListSectionDTO) r10.next();
        if (Intrinsics.areEqual(r11.getSectionId(), "favorite_section") == false) goto L28;
        ArrayList r12 = r11.getItems();
        if (r12 == null) goto L28;
        DataEngineWrapper r13 = this.a.L0;
        if (r13 == null) goto L28;
        r13.c(r12.size());
    L36:
        DataEngineWrapper r14 = this.a.L0;
        if (r14 == null) goto L44;
        HomePageDTO r15 = r14.t;
        if (r15 == null) goto L44;
        HomePageBffDTO r16 = r15.getBff();
        if (r16 == null) goto L44;
        com.bytedance.android.ec.hybrid.list.entity.k r17 = r16.getFeedVO();
        if (r17 == null) goto L44;
    L55:
        com.bytedance.android.ec.hybrid.list.entity.k r18 = r17;
    L57:
        HomePageBffDTO r19 = this.b.getBff();
        if (r19 == null) goto L77;
        ECHybridListDTO r20 = r19.getFeed();
        if (r20 == null) goto L77;
        List r21 = r20.getSections();
        if (r21 == null) goto L77;
        Iterator r22 = r21.iterator();
    L65:
        if (r22.hasNext() == false) goto L69;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r23).getSectionId(), "category_tab_section") == false) goto L65;
    L70:
        ECHybridListSectionDTO r24 = (ECHybridListSectionDTO) r23;
        if (r24 == null) goto L77;
        ArrayList r25 = r24.getItems();
        if (r25 == null) goto L77;
        ECHybridListItemDTO r26 = (ECHybridListItemDTO) CollectionsKt.firstOrNull(r25);
        if (r26 == null) goto L77;
        final Integer r27 = r26.getItemType();
    L78:
        DataEngineWrapper r28 = this.a.L0;
        if (r28 == null) goto L81;
        r28.L(new ECMallFragment$initOrRefreshSucc$$inlined$Runnable$3$lambda$2(r27, this));
    L81:
        ECMallFeed r29 = this.a.f;
        if (r29 == null) goto L84;
        r29.l0(true, this.b, r18, !this.c, r9);
    L84:
        this.a.xa0();
        this.a.L = null;
        int r30 = sf3.a.a;
        ECHybridListEngine r31 = this.a.H0;
        return;
    L69:
        r23 = null;
    L77:
        r27 = null;
    L44:
        HomePageBffDTO r32 = this.b.getBff();
        if (r32 == null) goto L56;
        ECHybridListDTO r33 = r32.getFeed();
        if (r33 == null) goto L56;
        ECHybridListDTO.a r34 = ECHybridListDTO.Companion;
        HomePageBffDTO r35 = this.b.getBff();
        if (r35 == null) goto L53;
        BffBizInfo r36 = r35.getBizInfo();
        if (r36 == null) goto L53;
        String r37 = r36.getEcSceneId();
    L54:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r38 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(1, r37, 190);
        r34.getClass();
        r17 = ECHybridListDTO.a.d(r33, false, r38);
    L53:
        r37 = null;
    L56:
        r18 = null;
        goto L57
    L99:
        return;
    L5:
        r1 = null;
        goto L6
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
}
