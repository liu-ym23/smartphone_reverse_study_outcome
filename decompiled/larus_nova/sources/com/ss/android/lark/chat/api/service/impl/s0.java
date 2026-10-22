package com.ss.android.lark.chat.api.service.impl;

import com.larksuite.framework.utils.AndroidThrottle;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class s0 implements AndroidThrottle.d<u0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<u0> f411639a;

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final void clear() {
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final Collection<u0> a() {
        List r100 = CollectionsKt.toList(this.f411639a);
        this.f411639a.clear();
        return r100;
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final int size() {
        return this.f411639a.size();
    }

    public s0() {
        this.f411639a = new HashSet();
    }

    @Override // com.larksuite.framework.utils.AndroidThrottle.d
    public final void put(u0 r100) {
        u0 r101 = r100;
        if (r101 == null) goto L6;
        this.f411639a.add(r101);
        return;
    }
}
