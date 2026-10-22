package com.larus.settings.mainbot;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.larus.platform.model.mainbot.AoSettingsConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Settings(storageKey = "nova_settings")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0003H'J\b\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\bH'J\b\u0010\n\u001a\u00020\u0003H'J\b\u0010\u000b\u001a\u00020\u0003H'J\b\u0010\f\u001a\u00020\rH'J\b\u0010\u000e\u001a\u00020\u000fH'J\b\u0010\u0010\u001a\u00020\u0011H'J\b\u0010\u0012\u001a\u00020\u0013H'¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/mainbot/IMainBotSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "enableCreateMarkdownOnMain", "", "enableViewTagExtra", "enableBlockDiffDispatchFix", "disableDeepThinkCloseStatusFallback", "exposedSkillLoadingTime", "", "remoteFileAutoOpenTimeoutSeconds", "localPcUnavailableInteractionFallbackEnabled", "aiFloatChatSupportInteraction", "getTaskModeConfig", "Lcom/larus/settings/mainbot/TaskModeConfig;", "getElapsedBlockConfig", "Lcom/larus/settings/mainbot/ElapsedBlockConfig;", "getMessageInteractionBlockConfig", "Lcom/larus/settings/mainbot/MessageInteractionBlockConfig;", "getAoSettingsConfig", "Lcom/larus/platform/model/mainbot/AoSettingsConfig;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMainBotSettings extends ISettings {
    boolean aiFloatChatSupportInteraction();

    boolean disableDeepThinkCloseStatusFallback();

    boolean enableBlockDiffDispatchFix();

    boolean enableCreateMarkdownOnMain();

    boolean enableViewTagExtra();

    int exposedSkillLoadingTime();

    AoSettingsConfig getAoSettingsConfig();

    a getElapsedBlockConfig();

    p getMessageInteractionBlockConfig();

    r getTaskModeConfig();

    boolean localPcUnavailableInteractionFallbackEnabled();

    int remoteFileAutoOpenTimeoutSeconds();
}
