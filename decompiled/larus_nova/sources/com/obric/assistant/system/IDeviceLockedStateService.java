package com.obric.assistant.system;

import com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/obric/assistant/system/IDeviceLockedStateService;", "", "init", "", "isDeviceLocked", "", "getDeviceLockedTime", "", "registerDeviceLockedStateListener", "listener", "Lcom/obric/assistant/system/IDeviceLockedStateListener;", "unregisterDeviceLockedStateListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDeviceLockedStateService {
    void a(ClearContextInKeyguardServiceImpl.c r100);

    long b();

    void init();

    boolean isDeviceLocked();
}
