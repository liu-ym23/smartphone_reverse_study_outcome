package com.bytedance.timon.ruler.adapter.provider;

import android.content.Context;
import com.bytedance.ruler.strategy.provider.a;
import com.bytedance.ruler.strategy.utils.EventCenter;
import com.google.gson.JsonObject;
import java.util.Objects;

/* JADX INFO: loaded from: classes22.dex */
public final class LocalStrategyProvider implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f270708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JsonObject f270709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f270710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f270711d;

    @Override // com.bytedance.ruler.strategy.provider.a
    public final String name() {
        return "LocalStrategy";
    }

    @Override // com.bytedance.ruler.strategy.provider.a
    public final int priority() {
        return 0;
    }

    @Override // com.bytedance.ruler.strategy.provider.a
    public final JsonObject a() {
        if (this.f270708a == true) goto L5;
        System.nanoTime();
        this.f270708a = true;
        int r100 = EventCenter.f267745a;
        EventCenter.b(new LocalStrategyProvider$strategies$1(this), "com.ss.android.ugc.aweme.ruler_adapter_impl.provider.LocalStrategyProvider.strategies");
        System.nanoTime();
    L5:
        Objects.toString(this.f270709b);
        return this.f270709b;
    }

    public LocalStrategyProvider(Context r100, String r101) {
        this.f270710c = r100;
        this.f270711d = r101;
    }
}
