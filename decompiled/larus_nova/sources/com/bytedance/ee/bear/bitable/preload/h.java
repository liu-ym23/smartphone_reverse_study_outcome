package com.bytedance.ee.bear.bitable.preload;

import com.bytedance.ee.bear.bitable.load.cache.CacheType;
import com.bytedance.lark.pb.bitable.v1.BitableDeleteResourceRequest;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements Function1<List<? extends String>, Unit> {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.bitable.preload.BitablePreloadCacheCleaner$invoke$rustCallback$1] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(List<? extends String> r100) {
        List<? extends String> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "type");
        ?? r102 = new BitablePreloadCacheCleaner$invoke$rustCallback$1();
        if (r101.contains("all") == false) goto L6;
        tt5.a.h("BitablePreloadCacheCleaner", "cleanPreloadCache: all");
        ((yr4.a) org.koin.java.a.c(yr4.a.class, null, null, 6)).i();
        com.bytedance.ee.bear.bitable.core.usercomponent.b.b(CacheType.MEMORY).clearAll();
        com.bytedance.ee.bear.bitable.rust.g.a(CollectionsKt.listOf(BitableDeleteResourceRequest.ResourceType.ALL), r102);
    L12:
        return Unit.INSTANCE;
    L6:
        if (r101.contains("render_data") == false) goto L9;
        tt5.a.h("BitablePreloadCacheCleaner", "cleanPreloadCache: render_data");
        ((yr4.a) org.koin.java.a.c(yr4.a.class, null, null, 6)).c();
        com.bytedance.ee.bear.bitable.core.usercomponent.b.b(CacheType.MEMORY).clearAll();
        com.bytedance.ee.bear.bitable.rust.g.a(CollectionsKt.listOf(new BitableDeleteResourceRequest.ResourceType[]{BitableDeleteResourceRequest.ResourceType.MainDocPage, BitableDeleteResourceRequest.ResourceType.MainDocBlockInfo, BitableDeleteResourceRequest.ResourceType.MainDocClientVars}), r102);
    L9:
        if (r101.contains("local_cs") == false) goto L12;
        tt5.a.h("BitablePreloadCacheCleaner", "cleanPreloadCache: local_cs");
        ((yr4.a) org.koin.java.a.c(yr4.a.class, null, null, 6)).e();
        com.bytedance.ee.bear.bitable.core.usercomponent.b.b(CacheType.MEMORY).clearAll();
        com.bytedance.ee.bear.bitable.rust.g.a(CollectionsKt.listOf(BitableDeleteResourceRequest.ResourceType.LocalCS), r102);
        goto L12
    }
}
