package com.bytedance.lark.molten_livequery_wrapper.adapter;

import com.bytedance.lark.molten_livequery_wrapper.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements com.bytedance.lark.molten_livequery_wrapper.f<Object>, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveQuerySubscriber<Object> f253385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c<Object> f253386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f253387c;

    @Override // com.bytedance.lark.molten_livequery_wrapper.g
    public final void pause() {
        this.f253385a.pause();
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.g
    public final void release() {
        this.f253385a.release();
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.g
    public final void resume() {
        this.f253385a.resume();
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.f
    public final List<Object> h() {
        c<Object> r100 = this.f253386b;
        long r101 = this.f253387c;
        Map<Long, List<Object>> r102 = r100.f253388a.f253375l;
        if ((!r102.isEmpty()) == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L11;
        ArrayList r103 = new ArrayList(r102.size());
        Iterator<Map.Entry<Long, List<Object>>> r104 = r102.entrySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L12;
        r103.add(r104.next().getValue());
    L12:
        if (r103 != null) goto L14;
        return null;
    L14:
        return (List) CollectionsKt.getOrNull(r103, (int) r101);
    L11:
        r103 = null;
        goto L12
    }

    public b(c<Object> r100, long r101) {
        this.f253386b = r100;
        this.f253387c = r101;
        this.f253385a = r100.f253388a;
    }
}
