package com.bytedance.timonbase.scene;

import com.bytedance.timonbase.scene.silenceimpl.WindowManagerGlobalInfiltrator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class AppSilenceReferee {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Long> f270857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f270858b;

    public AppSilenceReferee(long r100) {
        this.f270858b = r100;
        WindowManagerGlobalInfiltrator.f270890b.getClass();
        WindowManagerGlobalInfiltrator.b();
        a r101 = ScenesDetector.f270869e;
        if (r101 == null) goto L5;
        r101.a(AnonymousClass1.INSTANCE);
    L5:
        this.f270857a = CollectionsKt.listOf(new Long[]{0L, 30000L, 600000L, 1200000L});
    }
}
