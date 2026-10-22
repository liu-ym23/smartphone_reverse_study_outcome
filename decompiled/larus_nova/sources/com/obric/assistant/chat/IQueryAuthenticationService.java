package com.obric.assistant.chat;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.bean.message.Message;
import com.obric.assistant.AuthenticationType;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/chat/IQueryAuthenticationService;", "", "init", "", "isQueryMessageAuthorized", "", RemoteMessageConst.MSGID, "", "isQueryMessageAuthorizedV2", "Lkotlin/Pair;", "Lcom/obric/assistant/AuthenticationType;", "onReGenerate", "questionMsg", "Lcom/larus/im/bean/message/Message;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IQueryAuthenticationService {
    void b(Message r100);

    boolean c(String r100);

    Pair<Boolean, AuthenticationType> d(String r100);

    void init();
}
