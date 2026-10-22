package com.bytedance.ies.argus.strategy;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f246155a;

    public String toString() {
        return MapsKt.toMap(this.f246155a).toString();
    }

    public a() {
        this.f246155a = new LinkedHashMap();
    }
}
