package com.obric.assistant.common.spi.network;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J]\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\u0010J]\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/common/spi/network/IObricTTNetMonitorHookService;", "", "onMonitorApiError", "", "sendDuration", "", "sentTime", "sendUrl", "", "sendIp", "traceCode", "status", "", "extJson", "Lorg/json/JSONObject;", "networkRawLog", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lorg/json/JSONObject;Ljava/lang/String;)V", "onMonitorApiOk", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricTTNetMonitorHookService {
    void a(Long r100, Long r101, String r102, String r103, String r104, Integer r105, JSONObject r106, String r107);

    void b(Long r100, Long r101, String r102, String r103, String r104, Integer r105, JSONObject r106, String r107);
}
