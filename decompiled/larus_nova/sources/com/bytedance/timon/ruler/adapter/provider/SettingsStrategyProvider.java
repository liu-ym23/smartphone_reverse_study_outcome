package com.bytedance.timon.ruler.adapter.provider;

import com.bytedance.ruler.strategy.provider.a;
import com.bytedance.ruler.strategy.utils.EventCenter;
import com.google.gson.JsonObject;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes22.dex */
public final class SettingsStrategyProvider implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<JsonObject> f270715a;

    @Override // com.bytedance.ruler.strategy.provider.a
    public final String name() {
        return "SettingsStrategy";
    }

    @Override // com.bytedance.ruler.strategy.provider.a
    public final int priority() {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.google.gson.JsonObject] */
    @Override // com.bytedance.ruler.strategy.provider.a
    public final JsonObject a() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();     // Catch: Throwable -> L4
        r100.element = new JsonObject();     // Catch: Throwable -> L4
        int r101 = EventCenter.f267745a;     // Catch: Throwable -> L4
        EventCenter.b(new SettingsStrategyProvider$strategies$1(this, r100), "com.ss.android.ugc.aweme.ruler_adapter_impl.provider.SettingsStrategyProvider.strategies");     // Catch: Throwable -> L4
        Objects.toString((JsonObject) r100.element);     // Catch: Throwable -> L4
        return (JsonObject) r100.element;
    L4:
        return null;
    }

    public SettingsStrategyProvider(Function0<JsonObject> r100) {
        this.f270715a = r100;
    }
}
