package com.larus.bmhome.chat.trace.api;

import com.larus.im.depend.ISDKPointCallback;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/trace/api/IChatImTraceService;", "", "onSdkReceiveEnd", "", "sendMsgId", "", "endMsg", "Lcom/larus/im/depend/ISDKPointCallback$EndMsg;", "onSdkRealSendMessage", "sendMsgLocalId", "onReceiveFirstPackage", "firstPackage", "Lcom/larus/im/depend/ISDKPointCallback$FirstPackageMsg;", "sdkTotalDuration", "", "onUpdateLocalMessageId", "localMessageId", "newLocalMessageId", "getTraceKey", "onReportEvent", "event", "jsonParams", "Lorg/json/JSONObject;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChatImTraceService {
    void a(String r100);

    void b(String r100, String r101);

    void c(String r100, ISDKPointCallback.a r101, long r102);

    void d(String r100, JSONObject r101);

    String e(String r100);

    void f(String r100, ISDKPointCallback.EndMsg r101);
}
