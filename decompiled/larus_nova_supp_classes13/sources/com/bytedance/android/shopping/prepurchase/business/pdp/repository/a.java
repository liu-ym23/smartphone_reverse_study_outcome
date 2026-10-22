package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.ec.model.ECCacheMonitorStruct;
import com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements d {
    public PackResponseDTO a;
    public PackResponseDTO b;
    public final String c;

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
        this.c = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.d
    public final void a(PackResponseDTO r7) {
        Intrinsics.checkNotNullParameter(r7, "packDTO");
        e73.b r1 = null;
        if (r7.hasMultipleChunks() == true) goto L5;
    L54:
        this.a = r7;
    L55:
        PackResponseDTO r8 = this.a;
        if (r8 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunkData");
    L59:
        if (r8.isChunk() == false) goto L120;
        PackResponseDTO r9 = this.a;
        if (r9 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunkData");
    L65:
        if (r9.hasMultipleChunks() == true) goto L67;
        r1 = this.a;
        if (r1 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunkData");
    L108:
        if (r1 == null) goto L116;
        com.bytedance.android.shopping.anchorv4.data.k r10 = AnchorV4DataManager.a;
        PdpPackRequestParam r11 = AnchorV4DataManager.k(this.c);
        ECCacheMonitorStruct r0 = com.bytedance.android.shopping.anchorv4.experiment.b.a;
        if (com.bytedance.android.shopping.anchorv4.experiment.b.a(Boolean.valueOf(AnchorV4DataManager.l(r11))) == false) goto L117;
        if (r11 != null) goto L113;
        return;
    L113:
        if (r1.isForbidCache() == true) goto L119;
        PackResponseDTO r2 = e73.f.b(r1);
        r2.setTimestamp(System.currentTimeMillis());
        AnchorV4DataManager.a.c(r11, r2);
        return;
    L119:
        return;
    L117:
        return;
    L116:
        return;
    L67:
        if (this.b == null) goto L108;
        PackResponseDTO r12 = this.a;
        if (r12 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunkData");
    L71:
        PackParsedDTO r13 = r12.getParsedDTO();
        if (r13 == null) goto L91;
        ArrayList r3 = new ArrayList();
        PackResponseDTO r4 = this.a;
        if (r4 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunkData");
    L76:
        PackParsedDTO r5 = r4.getParsedDTO();
        if (r5 == null) goto L81;
        List r6 = r5.getComponents();
        if (r6 == null) goto L81;
    L82:
        r3.addAll(r6);
        PackResponseDTO r14 = this.b;
        if (r14 == null) goto L89;
        PackParsedDTO r15 = r14.getParsedDTO();
        if (r15 == null) goto L89;
        List r16 = r15.getComponents();
        if (r16 == null) goto L89;
    L90:
        r3.addAll(r16);
        Unit r17 = Unit.INSTANCE;
        r13.setComponents(r3);
    L89:
        r16 = CollectionsKt.emptyList();
    L81:
        r6 = CollectionsKt.emptyList();
    L91:
        PackResponseDTO r18 = this.a;
        if (r18 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunkData");
    L94:
        PackParsedDTO r19 = r18.getParsedDTO();
        if (r19 == null) goto L102;
        PackResponseDTO r20 = this.b;
        if (r20 == null) goto L101;
        PackParsedDTO r21 = r20.getParsedDTO();
        if (r21 == null) goto L101;
        r1 = r21.getActionStorage();
    L101:
        r19.setActionStorage(r1);
    L102:
        r1 = this.a;
        if (r1 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunkData");
        goto L108
    L120:
        return;
    L5:
        if (r7.isFirstChunk() == true) goto L54;
        this.b = r7;
        PackResponseDTO r22 = this.a;
        if (r22 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunkData");
    L10:
        PackParsedDTO r23 = r22.getParsedDTO();
        if (r23 == null) goto L13;
        e73.b r24 = r23.getActionStorage();
    L14:
        if (r24 == null) goto L22;
        Map r25 = r24.a();
        if (r25 == null) goto L22;
        if ((!r25.isEmpty()) != true) goto L22;
        PackParsedDTO r26 = r7.getParsedDTO();
        if (r26 == null) goto L22;
        r26.setActionStorage(r24);
    L22:
        PackParsedDTO r27 = r22.getParsedDTO();
        if (r27 == null) goto L29;
        PageMeta r28 = r27.getPageMeta();
        if (r28 == null) goto L29;
        CommonMeta r29 = r28.getCommonMeta();
        if (r29 == null) goto L29;
        JsonObject r30 = r29.getPdpLynxData();
    L30:
        if (r30 == null) goto L38;
        PackParsedDTO r31 = r7.getParsedDTO();
        if (r31 == null) goto L38;
        PageMeta r32 = r31.getPageMeta();
        if (r32 == null) goto L38;
        CommonMeta r33 = r32.getCommonMeta();
        if (r33 == null) goto L38;
        r33.setPdpLynxData(r30);
    L38:
        PackParsedDTO r34 = r22.getParsedDTO();
        if (r34 == null) goto L45;
        PageMeta r35 = r34.getPageMeta();
        if (r35 == null) goto L45;
        CommonMeta r36 = r35.getCommonMeta();
        if (r36 == null) goto L45;
        String r37 = r36.getScreenShotParams();
    L46:
        if (r37 == null) goto L55;
        PackParsedDTO r38 = r7.getParsedDTO();
        if (r38 == null) goto L55;
        PageMeta r39 = r38.getPageMeta();
        if (r39 == null) goto L55;
        CommonMeta r40 = r39.getCommonMeta();
        if (r40 == null) goto L55;
        r40.setScreenShotParams(r37);
    L45:
        r37 = null;
    L29:
        r30 = null;
        goto L30
    L13:
        r24 = null;
        goto L14
    }
}
