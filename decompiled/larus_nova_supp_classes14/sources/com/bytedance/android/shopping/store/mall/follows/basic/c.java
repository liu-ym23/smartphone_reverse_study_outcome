package com.bytedance.android.shopping.store.mall.follows.basic;

import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.shopping.store.mall.follows.FollowStoreResponse;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.moments.dto.ItemDTO;
import com.bytedance.android.shopping.store.moments.dto.SectionDTO;
import com.bytedance.android.shopping.store.moments.dto.StyleDTO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ BaseFollowStoreListBgPresenter a;

    public c(BaseFollowStoreListBgPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        FollowStoreResponse r7 = (FollowStoreResponse) r6;
        if (r7.isFirstFrame() == false) goto L27;
        HybridListDTO r0 = r7.getHybridList();
        if (r0 == null) goto L18;
        List<SectionDTO> r1 = r0.getSections();
        if (r1 == null) goto L18;
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        SectionDTO r3 = (SectionDTO) r2.next();
        if (Intrinsics.areEqual(r3.getSectionId(), "feed_section") == false) goto L10;
        BaseFollowStoreListBgPresenter r4 = this.a;
        StyleDTO r5 = r3.getSectionStyle();
        if (r5 == null) goto L16;
        float r8 = (float) r5.getMarginTop();
    L17:
        r4.i = r8;
        goto L10
    L16:
        r8 = 0.0f;
    L18:
        ECHybridListContainer r9 = this.a.h;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
    L21:
        ECHybridListEngine r10 = r9.getEngine();
        if (r10 == null) goto L27;
        ECHybridListContainer r11 = this.a.h;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
    L26:
        r11.post(new b(r10, this));
    L27:
        BaseFollowStoreListBgPresenter r12 = this.a;
        r12.getClass();
        if (r7.isFirstFrame() == false) goto L56;
        ViewGroup r13 = r12.f;
        if (r13 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("headerLiveBg");
    L32:
        HybridListDTO r14 = r7.getHybridList();
        int r15 = 0;
        if (r14 == null) goto L45;
        List<SectionDTO> r16 = r14.getSections();
        if (r16 == null) goto L45;
        SectionDTO r17 = (SectionDTO) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L45;
        ArrayList<ItemDTO> r18 = r17.getItems();
        if (r18 == null) goto L45;
        ItemDTO r19 = (ItemDTO) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L45;
        if (r19.getItemType() != 50103) goto L45;
        boolean r20 = true;
    L46:
        if (r20 == true) goto L49;
        r15 = 8;
    L49:
        r13.setVisibility(r15);
        return;
    L45:
        r20 = false;
        goto L46
    }
}
