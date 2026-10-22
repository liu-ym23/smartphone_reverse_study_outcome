package com.larus.live.impl.bridge.request;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f355790h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f355791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f355792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f355793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f355794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f355795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public XReadableMap f355796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public XReadableMap f355797g;

    public static final class a {
    }

    static {
    }

    public final String a() {
        String r100 = this.f355792b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(com.alipay.sdk.m.p.e.f25671s);
        return null;
    }

    public final String getUrl() {
        String r100 = this.f355791a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("url");
        return null;
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"url", "addCommonParams", com.alipay.sdk.m.p.e.f25671s, ContainerPosition.BODY, "params", "header", "bodyType"});
    }

    public d() {
        this.f355793c = true;
    }
}
