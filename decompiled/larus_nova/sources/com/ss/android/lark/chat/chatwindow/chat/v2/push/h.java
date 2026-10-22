package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.MessageUniversalPinExtra;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<Long, MessageUniversalPinExtra> f414586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatPinExtraPushHandler f414587b;

    public h(Map<Long, MessageUniversalPinExtra> r100, ChatPinExtraPushHandler r101) {
        this.f414586a = r100;
        this.f414587b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (CollectionUtils.isEmpty(this.f414586a) == true) goto L10;
        this.f414587b.f414547b.invoke(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.o(this.f414586a));     // Catch: Throwable -> L7
        return;
    }
}
