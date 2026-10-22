package com.larus.platform.api;

import com.larus.platform.model.mainbot.AoSettingsConfig;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface t0 {
    boolean a();

    boolean aiFloatChatSupportInteraction();

    boolean b();

    String c();

    boolean d();

    boolean e();

    boolean enableBlockDiffDispatchFix();

    boolean enableCreateMarkdownOnMain();

    boolean enableViewTagExtra();

    int exposedSkillLoadingTime();

    String f();

    boolean g();

    AoSettingsConfig getAoSettingsConfig();

    boolean h();

    boolean i();

    boolean j();

    List<String> k();

    int l();

    boolean localPcUnavailableInteractionFallbackEnabled();

    boolean m();

    boolean n();

    boolean o();

    int remoteFileAutoOpenTimeoutSeconds();
}
