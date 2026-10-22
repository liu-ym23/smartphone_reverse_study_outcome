package com.bytedance.platform.aio.channel.js.model;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f266603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f266604b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(f.class, "aioLink_message_deserialize_double_switch", "getAioLink_message_deserialize_double_switch()Z", 1))};
        f266603a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("aioLink_message_deserialize_double_switch", Boolean.TRUE, Boolean.TYPE, false);
        f266604b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
