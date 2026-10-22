package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class d2 implements ao4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f427848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<a, com.ss.android.lark.watermark.a> f427849b;

    public interface a {
    }

    @Override // ao4.f
    public final WatermarkInfo a() {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).z0(this.f427848a);
    }

    public d2() {
        this.f427848a = LarkContext.getApplication();
        this.f427849b = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.ss.android.lark.integrator.ccm.dependency.di.c2, java.lang.Object] */
    @Override // ao4.f
    public final void b(ra5.d r100) {
        final b2 r101 = new b2(r100);
        ?? r102 = new c2(r101);
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).U0(r102);
        ((ConcurrentHashMap) this.f427849b).put(r101, r102);
    }
}
