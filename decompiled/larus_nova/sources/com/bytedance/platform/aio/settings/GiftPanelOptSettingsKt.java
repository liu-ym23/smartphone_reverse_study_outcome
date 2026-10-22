package com.bytedance.platform.aio.settings;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.bytedance.tools.kcp.ultrasettings.runtime.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes21.dex */
public final class GiftPanelOptSettingsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f266609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f266610b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f266611c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(GiftPanelOptSettingsKt.class, "liveHarmonyGiftPanelOptV1", "getLiveHarmonyGiftPanelOptV1()Z", 1))};
        f266609a = r100;
        a r101 = new a("live_harmony_gift_panel_opt_v1", Boolean.FALSE, Boolean.TYPE, false);
        f266610b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        f266611c = LazyKt.lazy(GiftPanelOptSettingsKt$currentLiveHarmonyGiftPanelOptV1$2.INSTANCE);
    }

    public static final boolean a() {
        return ((Boolean) f266611c.getValue()).booleanValue();
    }
}
