package com.larus.sheet.sdk.impl;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.larus.office.OfficeInputParam;
import com.larus.office.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k implements hk5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ an9.a f369159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larus.office.h f369160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OfficeInputParam f369161c;

    @Override // hk5.a
    public final void onOpenFailedBeforeHost() {
    }

    @Override // hk5.a
    public final void onAttachToHost(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        w r101 = new w();
        r101.f363627a = this.f369161c;
        r100.registerHostAbility(r101);
        r100.registerHostAbility(this.f369159a);
        r100.registerHostAbility(this.f369160b);
    }

    public k(an9.a r100, com.larus.office.h r101, OfficeInputParam r102) {
        this.f369159a = r100;
        this.f369160b = r101;
        this.f369161c = r102;
    }
}
