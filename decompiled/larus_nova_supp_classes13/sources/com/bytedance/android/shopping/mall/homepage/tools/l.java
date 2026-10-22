package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.model.ChunkedSectionData;
import com.bytedance.android.shopping.api.mall.model.ChunkedTrackAndRec;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends com.bytedance.android.ec.hybrid.data.utils.a<HomePageDTO> {
    public static final /* synthetic */ int i = 0;

    public static final class a {
        public static void a(HomePageDTO r7, HomePageDTO r8) {
            Intrinsics.checkNotNullParameter(r7, "renderData");
            if (r8 == null) goto L67;
            List<ChunkedSectionData> r9 = r8.getChunkDataList();
            if (r9 == null) goto L114;
            Iterator<T> r10 = r9.iterator();
        L8:
            if (r10.hasNext() == false) goto L115;
            ChunkedSectionData r0 = (ChunkedSectionData) r10.next();
            if (r0.getChunkSectionId() == null) goto L8;
            String r1 = r0.getChunkSectionId();
            if (r1 == null) goto L8;
            int r2 = r1.hashCode();
            if (r2 != (-109885000)) goto L18;
            if (r1.equals("multi_in_one_section") == false) goto L8;
            List<ChunkedTrackAndRec> r3 = r0.getChunkInfo();
            if (r3 == null) goto L8;
            int r4 = l.i;
            if (r7.getChunkDataList() != null) goto L8;
            r7.setChunkDataList(CollectionsKt.listOf(new ChunkedSectionData("multi_in_one_section", r3)));
            goto L8
        L18:
            if (r2 != 612078402) goto L8;
            if (r1.equals("favorite_section") == false) goto L8;
            List<ChunkedTrackAndRec> r5 = r0.getChunkInfo();
            if (r5 == null) goto L8;
            int r6 = l.i;
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r5.iterator();
        L26:
            if (r12.hasNext() == false) goto L33;
            Object r13 = r12.next();
            if (((ChunkedTrackAndRec) r13).getId() == null) goto L30;
            boolean r14 = true;
        L31:
            if (r14 == false) goto L26;
            r11.add(r13);
            goto L26
        L30:
            r14 = false;
            goto L31
        L33:
            LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
            Iterator r16 = r11.iterator();
        L35:
            if (r16.hasNext() == false) goto L37;
            Object r17 = r16.next();
            String r18 = ((ChunkedTrackAndRec) r17).getId();
            Intrinsics.checkNotNull(r18);
            r15.put(r18, r17);
            goto L35
        L37:
            HomePageBffDTO r19 = r7.getBff();
            if (r19 == null) goto L8;
            ECHybridListDTO r20 = r19.getFeed();
            if (r20 == null) goto L8;
            List r21 = r20.getSections();
            if (r21 == null) goto L8;
            Iterator r22 = r21.iterator();
        L45:
            if (r22.hasNext() == false) goto L8;
            ECHybridListSectionDTO r23 = (ECHybridListSectionDTO) r22.next();
            if (Intrinsics.areEqual(r23.getSectionId(), "favorite_section") == false) goto L45;
            ArrayList r24 = r23.getItems();
            if (r24 == null) goto L45;
            Iterator r25 = r24.iterator();
        L52:
            if (r25.hasNext() == false) goto L45;
            ECHybridListItemDTO r26 = (ECHybridListItemDTO) r25.next();
            String r27 = r26.getItemId();
            if (r27 == null) goto L52;
            ChunkedTrackAndRec r28 = (ChunkedTrackAndRec) r15.get(r27);
            if (r28 == null) goto L52;
            r26.setRecommendInfoFromChunked(r28.getRecommendInfo());
            r26.setTrackData(r28.getTrackData());
            goto L52
        L115:
            return;
        L114:
            return;
        }
    }

    static {
    }

    public l() {
        super(HomePageDTO.class);
    }

    public final HomePageDTO c(List r7) {
        Intrinsics.checkNotNullParameter(r7, "dataList");
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "ECMallHomepageChunkedDataProcessor#mergeChunkedData()@" + hashCode() + ", start");
        List r8 = CollectionsKt.filterNotNull(r7);
        if ((!r8.isEmpty()) == true) goto L6;
        r8 = null;
    L6:
        if (r8 != null) goto L9;
        return null;
    L9:
        if (r8.size() == 2) goto L11;
        EnsureManager.ensureNotReachHere("ECMallHomepageChunkedDataProcessor#mergeChunkedData(), chunkedDataList#size = " + r8.size());
    L11:
        Iterator r9 = r8.iterator();
        HomePageDTO r1 = null;
        HomePageDTO r2 = null;
    L13:
        if (r9.hasNext() == false) goto L30;
        HomePageDTO r3 = (HomePageDTO) r9.next();
        if (r1 == null) goto L17;
    L24:
        if (r2 != null) goto L13;
        if (Intrinsics.areEqual(r3.getChunkedSection(), "tracking_data") == false) goto L13;
        if (r3.getChunkDataList() == null) goto L13;
        r2 = r3;
        goto L13
    L17:
        if (Intrinsics.areEqual(r3.getChunkedSection(), "rendering_data") == false) goto L24;
        HomePageBffDTO r4 = r3.getBff();
        if (r4 == null) goto L21;
        ECHybridListDTO r5 = r4.getFeed();
    L22:
        if (r5 == null) goto L24;
        r1 = r3;
        goto L24
    L21:
        r5 = null;
        goto L22
    L30:
        if (r1 != null) goto L32;
        EnsureManager.ensureNotReachHere("ECMallHomepageChunkedDataProcessor#mergeChunkedData(), draw data is null ");
        return null;
    L32:
        a.a(r1, r2);
        return r1;
    }

    public final HomePageDTO b(final ECHybridNetworkVO r2, final String r3, Object r4) {
        final HomePageDTO r5 = (HomePageDTO) r4;
        Intrinsics.checkNotNullParameter(r2, "networkVO");
        Intrinsics.checkNotNullParameter(r3, "result");
        if (r5 != null) goto L5;
        return null;
    L5:
        kk.d.c(new ECMallHomepageChunkedDataProcessor$handleChunkedData$1(r2, r3, r5));
        return r5;
    }
}
