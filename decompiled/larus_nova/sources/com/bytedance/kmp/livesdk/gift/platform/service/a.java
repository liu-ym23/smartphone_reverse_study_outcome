package com.bytedance.kmp.livesdk.gift.platform.service;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f252433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f252434b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f252435c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_HARMONY_BIG_GIFT_DIALOG", "getLIVE_GIFT_HARMONY_BIG_GIFT_DIALOG()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "HARMONY_ENABLE_GIFT_COMBO_NEW_STYLE", "getHARMONY_ENABLE_GIFT_COMBO_NEW_STYLE()Z", 1))};
        f252433a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_harmony_big_gift_dialog", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_harmony%2Fpages%2Fbig_gift_combo_dialog%2Ftemplate.js&enable_canvas=1&enable_canvas_optmize=1", String.class, false);
        f252434b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("harmony_enable_gift_combo_new_style", Boolean.FALSE, Boolean.TYPE, false);
        f252435c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
    }
}
