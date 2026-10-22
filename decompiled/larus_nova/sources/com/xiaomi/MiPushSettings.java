package com.xiaomi;

import com.bytedance.push.settings.ILocalSettings;
import com.bytedance.push.settings.annotation.Settings;

/* JADX INFO: loaded from: classes41.dex */
@Settings(storageKey = "push_multi_process_config", supportMultiProcess = true)
public interface MiPushSettings extends ILocalSettings {
    boolean hasUpgradeTo3616();

    void setUpgradeTo3616(boolean r100);
}
