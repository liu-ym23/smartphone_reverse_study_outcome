package com.bytedance.locallife.live.goodsshelves.manager;

import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class TopBrandLynxViewManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Object> f259685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f259686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ? extends Object> f259687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f259688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f259689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveLocalLifeLynxView f259690g;

    public TopBrandLynxViewManager() {
        this("");
    }

    public TopBrandLynxViewManager(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        this.f259684a = r100;
        this.f259688e = LazyKt.lazy(new TopBrandLynxViewManager$listener$2(this));
        this.f259689f = com.bytedance.locallife.live.settings.c.m();
    }
}
