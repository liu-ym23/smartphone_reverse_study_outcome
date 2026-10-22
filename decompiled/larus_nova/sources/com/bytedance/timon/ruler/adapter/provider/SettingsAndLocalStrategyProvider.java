package com.bytedance.timon.ruler.adapter.provider;

import android.content.Context;
import com.bytedance.ruler.strategy.provider.a;
import com.bytedance.ruler.strategy.utils.EventCenter;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SettingsAndLocalStrategyProvider implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JsonObject f270713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SettingsAndLocalStrategyProvider f270714c = null;

    public SettingsAndLocalStrategyProvider() {
    }

    @Override // com.bytedance.ruler.strategy.provider.a
    public final String name() {
        return "Keva缓存配置";
    }

    @Override // com.bytedance.ruler.strategy.provider.a
    public final int priority() {
        return 2;
    }

    static {
        f270714c = new SettingsAndLocalStrategyProvider();
        f270712a = LazyKt.lazy(SettingsAndLocalStrategyProvider$settingsStorage$2.INSTANCE);
    }

    @Override // com.bytedance.ruler.strategy.provider.a
    public final JsonObject a() {
        return f270713b;
    }

    public static void b(final Context r100, final String r101) {
        int r102 = EventCenter.f267745a;
        EventCenter.b(new SettingsAndLocalStrategyProvider$initContent$1(r100, r101), "com.ss.android.ugc.aweme.ruler_adapter_impl.SettingsAndLocalStrategyProvider.initContent");
    }
}
