package com.bytedance.kmp.ec.yata.event.common;

import com.bytedance.kmp.ec.yata.chain.trigger.ChainStartSource;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.platform.o;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final YataStoreWrapper f251661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f251662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f251663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f251664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f251665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f251666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f251667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f251668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f251669i;

    public final List<com.bytedance.kmp.ec.yata.common.protocol.data.g> a() {
        YataStoreWrapper r100 = this.f251661a;
        String r101 = this.f251663c;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        com.bytedance.kmp.ec.yata.store.node.c r102 = r100.o(r101);
        if (r102 == null) goto L14;
        com.bytedance.kmp.ec.yata.store.node.e r103 = r102.f251782b;
        if (r103 == null) goto L14;
        p r104 = r103.f251788b;
        if (r104 == null) goto L14;
        Map<String, List<com.bytedance.kmp.ec.yata.common.protocol.data.g>> r105 = r104.e();
        if (r105 == null) goto L14;
        return r105.get(this.f251664d);
    L14:
        return null;
    }

    public f(YataStoreWrapper r100, o r101, String r102, String r103, Map<String, ? extends Object> r104, @ChainStartSource String r105, String r106, String r107, boolean r108, k r110) {
        Intrinsics.checkNotNullParameter(r100, "storeWrapper");
        Intrinsics.checkNotNullParameter(r105, "chainStartSource");
        Intrinsics.checkNotNullParameter(r107, "monitorTag");
        this.f251661a = r100;
        this.f251662b = r101;
        this.f251663c = r102;
        this.f251664d = r103;
        this.f251665e = r104;
        this.f251666f = r105;
        this.f251667g = r107;
        this.f251668h = r108;
        this.f251669i = r110;
    }
}
