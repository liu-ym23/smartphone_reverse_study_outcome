package com.bytedance.push.settings;

import com.bytedance.push.settings.annotation.Settings;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Settings(storageKey = "push_multi_process_config", supportMultiProcess = true)
public interface AliveOnlineSettings extends ISettings {
    void c();

    void d();

    List<String> e();

    void f0();

    void g0();
}
