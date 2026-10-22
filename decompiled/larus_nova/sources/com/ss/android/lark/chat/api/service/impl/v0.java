package com.ss.android.lark.chat.api.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class v0 extends tcb.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewCache f411692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConcurrentHashMap<String, ArrayList<String>> f411693b;

    @Override // tcb.a
    public final Boolean a() {
        ConcurrentHashMap<tya.a, Object> r100 = this.f411692a.f411541e;
        ConcurrentHashMap<String, ArrayList<String>> r101 = this.f411693b;
        Iterator<Map.Entry<tya.a, Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r102.next().getKey().a(r101);
        goto L4
    L7:
        return Boolean.TRUE;
    }

    public v0(PreviewCache r100, ConcurrentHashMap<String, ArrayList<String>> r101) {
        this.f411692a = r100;
        this.f411693b = r101;
    }
}
