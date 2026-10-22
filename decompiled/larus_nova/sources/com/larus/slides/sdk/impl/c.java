package com.larus.slides.sdk.impl;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.larus.office.OfficeInputParam;
import com.larus.office.h;
import com.larus.office.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c implements hk5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ an9.a f369765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f369766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OfficeInputParam f369767c;

    @Override // hk5.a
    public final void onOpenFailedBeforeHost() {
    }

    @Override // hk5.a
    public final void onAttachToHost(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        w r101 = new w();
        r101.f363627a = this.f369767c;
        r100.registerHostAbility(r101);
        r100.registerHostAbility(this.f369765a);
        r100.registerHostAbility(this.f369766b);
    }

    public c(an9.a r100, h r101, OfficeInputParam r102) {
        this.f369765a = r100;
        this.f369766b = r101;
        this.f369767c = r102;
    }
}
