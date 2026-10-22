package com.larus.platform.service;

import com.larus.platform.model.mainbot.AoSettingsConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class p1 implements com.larus.platform.api.t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p1 f365785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365786b = null;

    public p1() {
    }

    static {
        f365785a = new p1();
        f365786b = LazyKt.lazy(new o1());
    }

    public static com.larus.platform.api.t0 p() {
        return (com.larus.platform.api.t0) f365786b.getValue();
    }

    @Override // com.larus.platform.api.t0
    public final boolean a() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.t0
    public final boolean aiFloatChatSupportInteraction() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.aiFloatChatSupportInteraction();
    }

    @Override // com.larus.platform.api.t0
    public final boolean b() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.b();
    }

    @Override // com.larus.platform.api.t0
    public final String c() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 == null) goto L6;
        String r101 = r100.c();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "2.24";
    }

    @Override // com.larus.platform.api.t0
    public final boolean d() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.d();
    }

    @Override // com.larus.platform.api.t0
    public final boolean e() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.e();
    }

    @Override // com.larus.platform.api.t0
    public final boolean enableBlockDiffDispatchFix() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.enableBlockDiffDispatchFix();
    }

    @Override // com.larus.platform.api.t0
    public final boolean enableCreateMarkdownOnMain() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.enableCreateMarkdownOnMain();
    }

    @Override // com.larus.platform.api.t0
    public final boolean enableViewTagExtra() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.enableViewTagExtra();
    }

    @Override // com.larus.platform.api.t0
    public final int exposedSkillLoadingTime() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return 1500;
    L7:
        return r100.exposedSkillLoadingTime();
    }

    @Override // com.larus.platform.api.t0
    public final String f() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f();
    }

    @Override // com.larus.platform.api.t0
    public final boolean g() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.g();
    }

    @Override // com.larus.platform.api.t0
    public final AoSettingsConfig getAoSettingsConfig() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 == null) goto L7;
        AoSettingsConfig r101 = r100.getAoSettingsConfig();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new AoSettingsConfig(false, false, 3, null);
    }

    @Override // com.larus.platform.api.t0
    public final boolean h() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.h();
    }

    @Override // com.larus.platform.api.t0
    public final boolean i() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.i();
    }

    @Override // com.larus.platform.api.t0
    public final boolean j() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.j();
    }

    @Override // com.larus.platform.api.t0
    public final List<String> k() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.k();
    }

    @Override // com.larus.platform.api.t0
    public final int l() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return 10;
    L7:
        return r100.l();
    }

    @Override // com.larus.platform.api.t0
    public final boolean localPcUnavailableInteractionFallbackEnabled() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.localPcUnavailableInteractionFallbackEnabled();
    }

    @Override // com.larus.platform.api.t0
    public final boolean m() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.m();
    }

    @Override // com.larus.platform.api.t0
    public final boolean n() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.n();
    }

    @Override // com.larus.platform.api.t0
    public final boolean o() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.o();
    }

    @Override // com.larus.platform.api.t0
    public final int remoteFileAutoOpenTimeoutSeconds() {
        com.larus.platform.api.t0 r100 = p();
        if (r100 != null) goto L7;
        return 5;
    L7:
        return r100.remoteFileAutoOpenTimeoutSeconds();
    }
}
