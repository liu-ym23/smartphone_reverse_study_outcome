package com.larksuite.component.card.cardcontainer;

import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements ILynxContainerContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Object> f283224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OPTrace f283225b;

    @Override // com.ss.android.lark.lynxkit.container.ILynxContainerContext
    public final String getContainerType() {
        return "UniversalCard";
    }

    @Override // com.ss.android.lark.lynxkit.container.ILynxContainerContext
    public final Map<String, Object> getBizExtra() {
        this.f283224a.put("op_trace", this.f283225b);
        return this.f283224a;
    }

    public a() {
        this.f283224a = new HashMap();
        this.f283225b = gyb.a.a();
    }
}
