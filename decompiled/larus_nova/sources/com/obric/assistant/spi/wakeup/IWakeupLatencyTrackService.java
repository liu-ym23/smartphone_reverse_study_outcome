package com.obric.assistant.spi.wakeup;

import com.obric.sva.sdk.utils.InteractConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0005H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/spi/wakeup/IWakeupLatencyTrackService;", "", "markActivationStart", "", "activationStartUptimeMillis", "", "launchMethod", "", "mainProcessReady", "", "markIpcStart", "scene", InteractConst.WAKEUP_SESSION_NAME, "ipcStartTime", "markMainProcessReceived", "timestamp", "markAssistantLaunchStart", "markRecordStart", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWakeupLatencyTrackService {

    public static final class a {
        public static /* synthetic */ void a(IWakeupLatencyTrackService r100) {
            r100.e(System.currentTimeMillis());
        }

        public static /* synthetic */ void b(ObricWakeupLatencyTrackService r100) {
            r100.c(System.currentTimeMillis());
        }
    }

    void a(long r100, String r101, boolean r102);

    void b(long r100);

    void c(long r100);

    void d(String r100, String r101, long r102);

    void e(long r100);
}
