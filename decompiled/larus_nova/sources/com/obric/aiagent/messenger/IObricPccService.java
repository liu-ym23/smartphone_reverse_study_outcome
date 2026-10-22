package com.obric.aiagent.messenger;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J \u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/messenger/IObricPccService;", "", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLaneType", "", "tryEncryptData", "", "messageId", "data", "", "(Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricPccService {
    Object a(String r100, byte[] r101, Continuation<? super String> r102);

    Object b(Continuation<? super Unit> r100);

    int c();
}
