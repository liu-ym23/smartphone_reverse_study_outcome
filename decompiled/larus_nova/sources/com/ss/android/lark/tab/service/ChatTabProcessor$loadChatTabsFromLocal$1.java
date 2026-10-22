package com.ss.android.lark.tab.service;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.ChatTab;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/tab/service/ChatTabProcessor$loadChatTabsFromLocal$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/tab/service/entity/ChatTabsListResult;", "onSuccess", "", "result", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTabProcessor$loadChatTabsFromLocal$1 implements IGetDataCallback<p6c.c> {
    final /* synthetic */ IGetDataCallback<p6c.c> $callback;
    final /* synthetic */ d this$0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("ChatTabLoader", "sync chat tab failed " + r100.getDisplayMsg());
        IGetDataCallback<p6c.c> r101 = this.$callback;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void onSuccess(p6c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Iterator<T> r101 = r100.f527971b.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((ChatTab) r102).getType() != ChatTab.ChatTabType.PIN) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L12:
        if (r102 == null) goto L15;
        int r104 = d.f441146a;
        throw null;
    L15:
        int r105 = d.f441146a;
        throw null;
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((p6c.c) r100);
    }

    public ChatTabProcessor$loadChatTabsFromLocal$1(d r100, IGetDataCallback<p6c.c> r101) {
        this.$callback = r101;
    }
}
