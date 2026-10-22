package com.larus.audio.autotest.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/larus/audio/autotest/api/IAudioAutotestService;", "", "init", "", "application", "Landroid/app/Application;", "canHook", "", "getPcmFileName", "", "getHookTestSetDirPath", "dispatchRealtimeCallAudioAutotest", "requestJson", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAudioAutotestService {
    boolean a();

    String b();

    String c();

    void init();
}
