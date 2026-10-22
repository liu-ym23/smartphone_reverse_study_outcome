package com.larus.bmhome.chat.interceptor;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.bean.message.Message;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&JX\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H&¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/interceptor/IMessageRenderInterceptorService;", "", "updateMessageRenderState", "", RemoteMessageConst.MSGID, "", "state", "Lcom/larus/bmhome/chat/interceptor/MessageRenderState;", "message", "Lcom/larus/im/bean/message/Message;", "openMarkdownRenderCrashRecovery", "openMessageRenderWatcher", "", "effectiveThreshold", "", "portrayal", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", PushClientConstants.TAG_CLASS_NAME, "methodName", "errorType", "onMessageRenderException", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMessageRenderInterceptorService {
    void a(String r100, MessageRenderState r101, Message r102);

    void b(String r100, String r101, String r102);

    void c(int r100, HashMap r101);
}
