package com.larus.canvas.service.internal.sse;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import tx9.n0;

/* JADX INFO: loaded from: classes26.dex */
public final class CanvasChunkReceiver implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ny8.c f323842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f323843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f323844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<CanvasBlock> f323845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f323846e;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/canvas/service/internal/sse/CanvasChunkReceiver$blockListType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/canvas/service/bean/CanvasBlock;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends CanvasBlock>> {
        public a() {
        }
    }

    @Override // com.larus.canvas.service.internal.sse.e
    public final void a(f r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        int r100 = r110.f323872a;
        if (r100 != 0) goto L5;
        BuildersKt.launch$default(this.f323843b, null, null, new CanvasChunkReceiver$end$1(this, r110, null), 3, null);
        return;
    L5:
        if (r100 == 2) goto L7;
        FLogger.f375446a.i(this.f323844c, "error: " + r110 + "  logid = " + r110.f323873b);
        BuildersKt.launch$default(this.f323843b, null, null, new CanvasChunkReceiver$end$3(this, r110, null), 3, null);
        return;
    L7:
        BuildersKt.launch$default(this.f323843b, null, null, new CanvasChunkReceiver$end$2(this, null), 3, null);
    }

    @Override // com.larus.canvas.service.internal.sse.e
    public final void b(b r110) {
        Intrinsics.checkNotNullParameter(r110, "chunkPackage");
        String r111 = r110.f323861c;
        if (r111.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        FLogger.f375446a.i(this.f323844c, "rawContent is null");
        return;
    L9:
        Gson r101 = n0.f547884a;
        com.larus.canvas.service.internal.sse.a r112 = (com.larus.canvas.service.internal.sse.a) GsonProtectorUtils.fromJson(r101, r111, com.larus.canvas.service.internal.sse.a.class);
        if (r112 == null) goto L12;
        String r102 = r112.content;
    L14:
        if (o0.d(r102) == true) goto L48;
        FLogger.f375446a.i(this.f323844c, "model content is null or empty");
        return;
    L48:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L17
        Object r113 = Result.m9449constructorimpl((List) r101.fromJson(r112.content, this.f323846e));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r113) == false) goto L22;
        r113 = null;
    L22:
        List r114 = (List) r113;
        if (r114 != null) goto L25;
        r114 = CollectionsKt.emptyList();
    L25:
        FLogger r104 = FLogger.f375446a;
        r104.i(this.f323844c, "onReceive model list = " + r114);
        List r115 = r114;
        if ((true ^ r115.isEmpty()) == false) goto L45;
        List r105 = CollectionsKt.toMutableList(this.f323845d);
        List r116 = CollectionsKt.toMutableList(r115);
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L29:
        if (r107.hasNext() == false) goto L44;
        CanvasBlock r108 = (CanvasBlock) r107.next();
        Iterator r109 = r116.iterator();
    L32:
        if (r109.hasNext() == false) goto L36;
        Object r117 = r109.next();
        if (Intrinsics.areEqual(r108.blockId, ((CanvasBlock) r117).blockId) == false) goto L32;
    L37:
        CanvasBlock r118 = (CanvasBlock) r117;
        if (r118 != null) goto L39;
        r106.add(r108);
        goto L29
    L39:
        r116.remove(r118);
        if (Intrinsics.areEqual(r108.blockType, r118.blockType) == true) goto L42;
        FLogger.f375446a.e(this.f323844c, "current block type != new block type block id = " + r108.blockId + "  current type = " + r108.blockType + "  new type = " + r118.blockType);
    L42:
        r106.add(r118);
        goto L29
    L36:
        r117 = null;
        goto L37
    L44:
        r106.addAll(r116);
        this.f323845d = r106;
        BuildersKt.launch$default(this.f323843b, null, null, new CanvasChunkReceiver$dispatch$1(this, CollectionsKt.toList(r106), null), 3, null);
        return;
    L45:
        r104.i(this.f323844c, "blocks is empty");
        return;
    L17:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L12:
        r102 = null;
        goto L14
    L5:
        r100 = false;
        goto L6
    }

    public CanvasChunkReceiver(List<CanvasBlock> r100, ny8.c r101, CoroutineScope r102) {
        Intrinsics.checkNotNullParameter(r100, "originBlocks");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "mainScope");
        this.f323842a = r101;
        this.f323843b = r102;
        this.f323844c = "CanvasChunkReceiver";
        this.f323845d = CollectionsKt.toMutableList(r100);
        this.f323846e = new a().getType();
    }
}
