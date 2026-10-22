package com.ss.android.lark.chatwindow.launcher;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chatwindow/launcher/ChatLauncherV2$openChat$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chatwindow/launcher/IChatLauncherV2$ChatWrapper;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatLauncherV2$openChat$1 implements IGetDataCallback<c.a> {
    final /* synthetic */ Function1<ErrorResult, Unit> $onError;
    final /* synthetic */ Function1<c.a, Unit> $onSuccess;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Function1<ErrorResult, Unit> r101 = this.$onError;
        if (r101 == null) goto L6;
        r101.invoke(r100);
        return;
    }

    public void onSuccess(c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Function1<c.a, Unit> r101 = this.$onSuccess;
        if (r101 == null) goto L6;
        r101.invoke(r100);
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((c.a) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatLauncherV2$openChat$1(Function1<? super c.a, Unit> r100, Function1<? super ErrorResult, Unit> r101) {
        this.$onSuccess = r100;
        this.$onError = r101;
    }
}
