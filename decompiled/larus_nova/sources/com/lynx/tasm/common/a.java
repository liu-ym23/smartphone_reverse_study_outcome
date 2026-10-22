package com.lynx.tasm.common;

import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Map.Entry<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f383235a;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        Object r100 = this.f383235a.getKey();
        if (r100 != NullableConcurrentHashMap.access$000()) goto L6;
        return null;
    L6:
        return r100;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        Object r100 = this.f383235a.getValue();
        if (r100 != NullableConcurrentHashMap.access$000()) goto L6;
        return null;
    L6:
        return r100;
    }

    public a(Map.Entry r100) {
        this.f383235a = r100;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object r100) {
        Map.Entry r101 = this.f383235a;
        if (r100 != null) goto L6;
        r100 = NullableConcurrentHashMap.access$000();
    L6:
        return r101.setValue(r100);
    }
}
