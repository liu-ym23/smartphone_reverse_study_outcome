package com.larus.home.impl.sdk;

import com.larus.platform.model.mainbot.AoSettingsConfig;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class h0 implements com.larus.platform.api.t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f346182a = null;

    static {
        f346182a = new h0();
    }

    public h0() {
    }

    @Override // com.larus.platform.api.t0
    public final boolean i() {
        return true;
    }

    @Override // com.larus.platform.api.t0
    public final boolean aiFloatChatSupportInteraction() {
        int r100 = com.larus.settings.mainbot.o.f368547a;
        return ((Boolean) com.larus.settings.mainbot.o.b(Boolean.FALSE, new com.larus.settings.mainbot.g())).booleanValue();
    }

    @Override // com.larus.platform.api.t0
    public final boolean d() {
        return ((com.larus.settings.mainbot.p) com.larus.settings.mainbot.o.b(new com.larus.settings.mainbot.p(0), new com.larus.settings.mainbot.m())).a();
    }

    @Override // com.larus.platform.api.t0
    public final boolean enableBlockDiffDispatchFix() {
        int r100 = com.larus.settings.mainbot.o.f368547a;
        return ((Boolean) com.larus.settings.mainbot.o.b(Boolean.FALSE, new com.larus.settings.mainbot.d())).booleanValue();
    }

    @Override // com.larus.platform.api.t0
    public final boolean enableCreateMarkdownOnMain() {
        int r100 = com.larus.settings.mainbot.o.f368547a;
        return ((Boolean) com.larus.settings.mainbot.o.b(Boolean.TRUE, new com.larus.settings.mainbot.c())).booleanValue();
    }

    @Override // com.larus.platform.api.t0
    public final boolean enableViewTagExtra() {
        int r100 = com.larus.settings.mainbot.o.f368547a;
        return ((Boolean) com.larus.settings.mainbot.o.b(Boolean.TRUE, new com.larus.settings.mainbot.n())).booleanValue();
    }

    @Override // com.larus.platform.api.t0
    public final int exposedSkillLoadingTime() {
        int r100 = com.larus.settings.mainbot.o.f368547a;
        return ((Number) com.larus.settings.mainbot.o.b(1500, new com.larus.settings.mainbot.f())).intValue();
    }

    @Override // com.larus.platform.api.t0
    public final AoSettingsConfig getAoSettingsConfig() {
        int r100 = com.larus.settings.mainbot.o.f368547a;
        return (AoSettingsConfig) com.larus.settings.mainbot.o.b(new AoSettingsConfig(false, false, 3, null), new com.larus.settings.mainbot.h());
    }

    @Override // com.larus.platform.api.t0
    public final boolean j() {
        int r100 = com.larus.settings.mainbot.o.f368547a;
        if (((com.larus.settings.mainbot.a) com.larus.settings.mainbot.o.b(new com.larus.settings.mainbot.a(0), new com.larus.settings.mainbot.i())).a() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.larus.platform.api.t0
    public final boolean localPcUnavailableInteractionFallbackEnabled() {
        int r100 = com.larus.settings.mainbot.o.f368547a;
        return ((Boolean) com.larus.settings.mainbot.o.b(Boolean.FALSE, new com.larus.settings.mainbot.l())).booleanValue();
    }

    @Override // com.larus.platform.api.t0
    public final int remoteFileAutoOpenTimeoutSeconds() {
        int r100 = com.larus.settings.mainbot.o.f368547a;
        return ((Number) com.larus.settings.mainbot.o.b(5, new com.larus.settings.mainbot.k())).intValue();
    }

    @Override // com.larus.platform.api.t0
    public final boolean a() {
        return com.larus.settings.mainbot.o.a().h();
    }

    @Override // com.larus.platform.api.t0
    public final boolean b() {
        return com.larus.settings.mainbot.o.a().a();
    }

    @Override // com.larus.platform.api.t0
    public final String c() {
        String r100 = com.larus.settings.mainbot.o.a().i();
        if (r100 != null) goto L6;
        return "2.24";
    L6:
        return r100;
    }

    @Override // com.larus.platform.api.t0
    public final boolean e() {
        return com.larus.settings.mainbot.o.a().c();
    }

    @Override // com.larus.platform.api.t0
    public final String f() {
        return com.larus.settings.mainbot.o.a().g();
    }

    @Override // com.larus.platform.api.t0
    public final boolean g() {
        return com.larus.settings.mainbot.o.a().d();
    }

    @Override // com.larus.platform.api.t0
    public final boolean h() {
        return com.larus.settings.mainbot.o.a().e();
    }

    @Override // com.larus.platform.api.t0
    public final List<String> k() {
        return com.larus.settings.mainbot.o.a().b();
    }

    @Override // com.larus.platform.api.t0
    public final int l() {
        return com.larus.settings.mainbot.o.a().j();
    }

    @Override // com.larus.platform.api.t0
    public final boolean m() {
        return com.larus.settings.mainbot.o.a().l();
    }

    @Override // com.larus.platform.api.t0
    public final boolean n() {
        return com.larus.settings.mainbot.o.a().f();
    }

    @Override // com.larus.platform.api.t0
    public final boolean o() {
        return com.larus.settings.mainbot.o.a().k();
    }
}
