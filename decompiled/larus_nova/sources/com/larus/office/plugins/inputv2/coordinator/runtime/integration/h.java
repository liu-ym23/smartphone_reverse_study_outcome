package com.larus.office.plugins.inputv2.coordinator.runtime.integration;

import android.widget.FrameLayout;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.a1;
import com.larus.office.plugins.inputv2.b1;
import com.larus.office.plugins.inputv2.c1;
import com.larus.office.plugins.inputv2.e1;
import com.larus.office.plugins.inputv2.f1;
import com.larus.office.plugins.inputv2.p0;
import com.larus.office.plugins.inputv2.y0;
import com.larus.office.plugins.inputv2.z0;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ChameleonPluginHost> f362901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<FrameLayout> f362902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<com.larus.office.h> f362904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<com.bytedance.ee.bear.document.d> f362905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f362906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Integer> f362907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Boolean> f362908h;

    public h(p0 r100, y0 r101, z0 r102, a1 r103, b1 r104, c1 r105, e1 r106, f1 r107) {
        Intrinsics.checkNotNullParameter(r100, "hostProvider");
        Intrinsics.checkNotNullParameter(r101, "containerProvider");
        Intrinsics.checkNotNullParameter(r102, "paramsProvider");
        Intrinsics.checkNotNullParameter(r103, "hostAbilityProvider");
        Intrinsics.checkNotNullParameter(r104, "documentMetadataProvider");
        Intrinsics.checkNotNullParameter(r105, "embeddedSuppressedProvider");
        Intrinsics.checkNotNullParameter(r106, "foldedBackgroundColorProvider");
        Intrinsics.checkNotNullParameter(r107, "forceTaskModeProvider");
        this.f362901a = r100;
        this.f362902b = r101;
        this.f362903c = r102;
        this.f362904d = r103;
        this.f362905e = r104;
        this.f362906f = r105;
        this.f362907g = r106;
        this.f362908h = r107;
    }
}
