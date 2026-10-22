package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f252278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f252279b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_HARMONY_FINISH_GIFT_TRANSACTION_WHEN_GIFT_PANEL_CLOSED", "getLIVE_HARMONY_FINISH_GIFT_TRANSACTION_WHEN_GIFT_PANEL_CLOSED()Z", 1))};
        f252278a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_finish_gift_transaction_when_gift_panel_closed", Boolean.TRUE, Boolean.TYPE, false);
        f252279b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
