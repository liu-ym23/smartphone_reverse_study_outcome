package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.model.SingleCardData;
import com.facebook.imagepipeline.common.Priority;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DataEngineWrapper$prefetchImageInner$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HomePageDTO $homepage;
    final /* synthetic */ String $pageName;
    final /* synthetic */ boolean $prefetchToMemoryCache;
    final /* synthetic */ DataEngineWrapper this$0;

    public DataEngineWrapper$prefetchImageInner$1(DataEngineWrapper r1, HomePageDTO r2, String r3, boolean r4) {
        this.this$0 = r1;
        this.$homepage = r2;
        this.$pageName = r3;
        this.$prefetchToMemoryCache = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1453invoke() {
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "DataEngineWrapper#prefetchFirstScreenImagesFrom()@" + this.this$0.hashCode() + ", start");
        long r2 = System.currentTimeMillis();
        r r4 = r.a;
        boolean r5 = r4.a();
        int r6 = r4.b();
        HomePageBffDTO r7 = this.$homepage.getBff();
        if (r7 == null) goto L55;
        ECHybridListDTO r8 = r7.getFeed();
        if (r8 == null) goto L55;
        List r9 = r8.getSections();
        if (r9 == null) goto L55;
        if (r5 == false) goto L10;
        r9 = CollectionsKt.reversed(r9);
    L10:
        Iterator r10 = r9.iterator();
        int r11 = 0;
    L12:
        if (r10.hasNext() == false) goto L54;
        ECHybridListSectionDTO r12 = (ECHybridListSectionDTO) r10.next();
        if (Intrinsics.areEqual(r12.getSectionId(), "multi_in_one_section") == true) goto L15;
        if (Intrinsics.areEqual(r12.getSectionId(), "favorite_section") == false) goto L12;
        ArrayList r13 = r12.getItems();
        if (r13 == null) goto L38;
        int r14 = r13.size();
    L39:
        int r15 = RangesKt.coerceAtMost(r6, r14);
        int r16 = 0;
    L40:
        if (r16 >= r15) goto L12;
        ArrayList r17 = r12.getItems();
        if (r17 == null) goto L51;
        ECHybridListItemDTO r18 = (ECHybridListItemDTO) CollectionsKt.getOrNull(r17, r16);
        if (r18 == null) goto L51;
        ECNAMallCardExtra r19 = r18.getExtra();
        if (r19 == null) goto L51;
        Priority r110 = Priority.IMMEDIATE;
        com.bytedance.android.ec.hybrid.tools.b<String> r111 = this.this$0.e();
        String r112 = this.$pageName;
        if (r112 != null) goto L50;
        r112 = DataEngineWrapper.a(this.this$0);
    L50:
        int r20 = com.bytedance.android.ec.hybrid.list.entity.dto.c.b(r19, r110, r111, r112, this.$prefetchToMemoryCache);
    L52:
        r11 = r11 + r20;
        r16 = r16 + 1;
    L51:
        r20 = 0;
        goto L52
    L38:
        r14 = 0;
        goto L39
    L15:
        ArrayList r21 = r12.getItems();
        if (r21 == null) goto L12;
        Iterator r22 = r21.iterator();
    L19:
        if (r22.hasNext() == false) goto L12;
        ECHybridListItemDTO r113 = (ECHybridListItemDTO) r22.next();
        Integer r114 = r113.getItemType();
        int r115 = ECHybridListItemType.LYNX_CHIP_AREA_CARD.getType();
        if (r114 == null) goto L19;
        if (r114.intValue() != r115) goto L19;
        ECNAMallCardExtra r116 = r113.getExtra();
        if (r116 == null) goto L31;
        Priority r117 = Priority.IMMEDIATE;
        com.bytedance.android.ec.hybrid.tools.b<String> r118 = this.this$0.e();
        String r119 = this.$pageName;
        if (r119 != null) goto L30;
        r119 = DataEngineWrapper.a(this.this$0);
    L30:
        int r120 = com.bytedance.android.ec.hybrid.list.entity.dto.c.b(r116, r117, r118, r119, true);
    L32:
        r11 = r11 + r120;
        goto L19
    L31:
        r120 = 0;
        goto L32
    L54:
        int r23 = r11;
    L56:
        HomePageBffDTO r24 = this.$homepage.getBff();
        if (r24 == null) goto L68;
        SingleCardData r25 = r24.getPopup();
        if (r25 == null) goto L63;
        final String r26 = r25.getExtra();
        if (r26 == null) goto L63;
        final com.bytedance.android.ec.hybrid.tools.b<String> r27 = this.this$0.e();
        r23 = r23 + ((Number) kk.d.a(0, new DataEngineWrapper$handleImagePrefetchConfig$1(r26, r27))).intValue();
    L63:
        SingleCardData r28 = r24.getTopBar();
        if (r28 == null) goto L68;
        final String r29 = r28.getExtra();
        if (r29 == null) goto L68;
        final com.bytedance.android.ec.hybrid.tools.b<String> r30 = this.this$0.e();
        r23 = r23 + ((Number) kk.d.a(0, new DataEngineWrapper$handleImagePrefetchConfig$1(r29, r30))).intValue();
    L68:
        Lazy r31 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "DataEngineWrapper#prefetchFirstScreenImagesFrom()@" + this.this$0.hashCode() + ", end, prefetchedCount = " + r23 + ", duration = " + (System.currentTimeMillis() - r2));
        return;
    L55:
        r23 = 0;
        goto L56
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1453invoke();
        return Unit.INSTANCE;
    }
}
