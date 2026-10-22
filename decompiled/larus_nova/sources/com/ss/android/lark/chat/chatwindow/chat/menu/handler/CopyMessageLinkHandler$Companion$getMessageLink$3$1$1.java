package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.framework.callback.CancelableGetDataCallback;
import com.ss.android.lark.pb.messages.PutMessageLinkResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CopyMessageLinkHandler$Companion$getMessageLink$3$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancelableGetDataCallback<PutMessageLinkResponse> $cancelable;

    public CopyMessageLinkHandler$Companion$getMessageLink$3$1$1(CancelableGetDataCallback<PutMessageLinkResponse> r100) {
        this.$cancelable = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        this.$cancelable.cancel();
    }
}
