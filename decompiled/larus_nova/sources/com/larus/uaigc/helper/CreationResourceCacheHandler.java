package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/helper/CreationResourceCacheHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationResourceCacheHandler implements ResourceNodeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f372986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f372987b;

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final void getPriority() {
    }

    public CreationResourceCacheHandler() {
        this.f372986a = "creation_resource_cache";
        this.f372987b = "cache";
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final String a() {
        return this.f372987b;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final String getKey() {
        return this.f372986a;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final boolean b(com.larus.bmhome.resource.access.h0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a0.b(r100) == true) goto L5;
        return false;
    L5:
        if (r100.f313678h == null) goto L17;
        String r101 = r100.b().get("preprocess_result");
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
        goto L13
    L17:
        return false;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final Object c(com.larus.bmhome.resource.access.h0 r110, Continuation<? super com.larus.bmhome.resource.access.g> r111) {
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("cache_stage", CreationCacheStage.PREPROCESS_REUSE_CHECKED.getValue())), 63));
    }
}
