package com.larus.office.plugins.inputv2.coordinator.runtime.integration;

import com.larus.office.plugins.inputv2.v0;
import com.larus.office.plugins.inputv2.w0;
import com.larus.office.plugins.inputv2.x0;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<com.larus.office.plugins.inputv2.adapter.g, Long, Unit> f362898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<com.larus.office.plugins.inputv2.adapter.g, String, Unit> f362899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ChameleonPluginHost, Unit> f362900c;

    public g(v0 r100, w0 r101, x0 r102) {
        Intrinsics.checkNotNullParameter(r100, "onAdapterBound");
        Intrinsics.checkNotNullParameter(r101, "onAdapterReleasing");
        Intrinsics.checkNotNullParameter(r102, "onIntegrated");
        this.f362898a = r100;
        this.f362899b = r101;
        this.f362900c = r102;
    }
}
