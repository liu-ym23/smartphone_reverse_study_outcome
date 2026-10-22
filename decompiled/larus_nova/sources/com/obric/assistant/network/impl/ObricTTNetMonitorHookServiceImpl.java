package com.obric.assistant.network.impl;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.network.IObricTTNetMonitorHookService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0012J]\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/network/impl/ObricTTNetMonitorHookServiceImpl;", "Lcom/obric/assistant/common/spi/network/IObricTTNetMonitorHookService;", "<init>", "()V", "onMonitorApiError", "", "sendDuration", "", "sentTime", "sendUrl", "", "sendIp", "traceCode", "status", "", "extJson", "Lorg/json/JSONObject;", "networkRawLog", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lorg/json/JSONObject;Ljava/lang/String;)V", "onMonitorApiOk", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTTNetMonitorHookServiceImpl implements IObricTTNetMonitorHookService {
    public ObricTTNetMonitorHookServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.network.IObricTTNetMonitorHookService
    public final void a(Long r110, Long r111, String r112, String r113, String r114, Integer r115, JSONObject r116, String r117) {
        Iterator<T> r100 = wea.b.f559444a.iterator();     // Catch: Throwable -> L11
    L4:
        if (r100.hasNext() == false) goto L23;
        WeakReference r101 = (WeakReference) r100.next();     // Catch: Throwable -> L11
        if (r101 == null) goto L4;
        wea.a r102 = (wea.a) r101.get();     // Catch: Throwable -> L11
        if (r102 == null) goto L4;
        r102.a(r110, r111, r112, r113, r114, r115, r116, r117);     // Catch: Throwable -> L11
        goto L4
    L23:
        return;
    L11:
        th = move-exception;
        FLogger.f375446a.w("TTNetMonitorHook", "call monitorApiOk failed：" + th.getMessage());
    }

    @Override // com.obric.assistant.common.spi.network.IObricTTNetMonitorHookService
    public final void b(Long r110, Long r111, String r112, String r113, String r114, Integer r115, JSONObject r116, String r117) {
        Iterator<T> r100 = wea.b.f559444a.iterator();     // Catch: Throwable -> L11
    L4:
        if (r100.hasNext() == false) goto L23;
        WeakReference r101 = (WeakReference) r100.next();     // Catch: Throwable -> L11
        if (r101 == null) goto L4;
        wea.a r102 = (wea.a) r101.get();     // Catch: Throwable -> L11
        if (r102 == null) goto L4;
        r102.b(r110, r111, r112, r113, r114, r115, r116, r117);     // Catch: Throwable -> L11
        goto L4
    L23:
        return;
    L11:
        th = move-exception;
        FLogger.f375446a.w("TTNetMonitorHook", "call monitorApiError failed：" + th.getMessage());
    }
}
