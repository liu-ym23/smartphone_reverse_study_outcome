package com.larus.dora.api.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\bg\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH&J\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\"\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\bH&J$\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH&J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH&J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH&¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/api/config/IDoraPageConfig;", "", "registerConfigChangeListener", "", "listener", "Lcom/larus/dora/api/annotation/IPageConfigChangeListener;", "unRegisterConfigChangeListener", "containKey", "", "key", "", "containKeyWithUid", "removeKey", "removeKeyWithUid", "setSettingsEnable", "enable", "setSettingsEnableWithUid", "getSettingsEnable", "default", "getSettingsEnableWithUid", "setSettingsEnableWithUidAndDevice", "mac", "getSettingsEnableWithUidAndDevice", "removeSettingsWithUidAndDevice", "setSettingsString", "value", "setSettingsStringWithUid", "getSettingsString", "getSettingsStringWithUid", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraPageConfig {
    void a(String r100, boolean r101);

    boolean b(boolean r100);

    void c(String r100);

    boolean d(String r100, boolean r101);

    void e(String r100, String r101);

    String f(String r100, String r101);

    boolean g(String r100);

    void h(String r100);

    void i(boolean r100);
}
