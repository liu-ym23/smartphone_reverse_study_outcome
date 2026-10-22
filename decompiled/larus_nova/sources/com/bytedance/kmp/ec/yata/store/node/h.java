package com.bytedance.kmp.ec.yata.store.node;

import com.bytedance.kmp.ec.yata.store.core.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f251797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f251798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<b> f251799g;

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final List<b> getChildren() {
        return this.f251799g;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.c, com.bytedance.kmp.ec.yata.store.node.b
    public final String getKey() {
        return this.f251797e;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final b getParent() {
        return this.f251798f;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final void g(b r100) {
        this.f251798f = r100;
    }

    public h(String r100, e r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "nodeInfo");
        Intrinsics.checkNotNullParameter(r102, "storeContext");
        super(r100, r101, r102);
        this.f251797e = r100;
        this.f251799g = new ArrayList();
    }
}
