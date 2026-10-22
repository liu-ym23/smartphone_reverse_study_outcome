package com.bytedance.sdk.bridge.auth;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.bridge.BridgeMethodInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<BridgeAuthFilter> f269564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f269565b;

    public a() {
        this.f269564a = new ArrayList();
        this.f269565b = 0;
    }

    public final boolean a(T r100, BridgeMethodInfo r101) {
        if (this.f269565b != ((ArrayList) this.f269564a).size()) goto L6;
        return false;
    L6:
        List<BridgeAuthFilter> r102 = this.f269564a;
        int r103 = this.f269565b;
        this.f269565b = r103 + 1;
        return ((BridgeAuthFilter) ListProtector.get(r102, r103)).doAuthFilter(r100, r101, this);
    }
}
