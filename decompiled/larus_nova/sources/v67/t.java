package v67;

import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public interface t {
    ConcurrentHashMap<String, WeakReference<com.bytedance.push.event.sync.b>> getBusinessExtraInfoProviderMap();

    com.bytedance.push.event.sync.d getISignalReporter();

    com.bytedance.push.event.sync.e getIUserExitsValidityChecker();

    void onHwScreenConfigDisable();

    void onNotificationDelete(long r100);

    void onReceiveSignal(Intent r100);

    void registerNotificationDeleteListener(com.bytedance.push.event.sync.c r100);

    void triggerSignalReport(String r100);
}
