package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.message.IObricForegroundWidgetSyncService;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/messenger/stub/ObricForegroundWidgetSyncServiceImpl;", "Lcom/obric/assistant/spi/message/IObricForegroundWidgetSyncService;", "<init>", "()V", "awaitWidgetUpdatesBeforeConversationPull", "", "conversationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricForegroundWidgetSyncServiceImpl implements IObricForegroundWidgetSyncService {

    public static final class a {
    }

    static {
    }

    public ObricForegroundWidgetSyncServiceImpl() {
    }

    @Override // com.obric.assistant.spi.message.IObricForegroundWidgetSyncService
    public final Object a(String r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1) == false) goto L7;
        ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1 r102 = (ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L24
    L20:
        Boolean r108 = (Boolean) r104;     // Catch: Throwable -> L24
        if (r108 == null) goto L28;
        r107 = r108.booleanValue();     // Catch: Throwable -> L24
    L28:
        FLogger.f375446a.i("ObricForegroundWidgetSyncServiceImpl", "foreground widget sync finished before conversation pull, conversationId=" + r100 + ", success=" + r107);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$widgetSyncSucceeded$1 r109 = new ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$widgetSyncSucceeded$1(r100, null);     // Catch: Throwable -> L24
        r102.L$0 = r100;     // Catch: Throwable -> L24
        r102.label = 1;     // Catch: Throwable -> L24
        r104 = TimeoutKt.c(2000, r109, r102);     // Catch: Throwable -> L24
        if (r104 != r105) goto L20;
        return r105;
    L24:
        th = move-exception;
        if ((th instanceof CancellationException) == true) goto L30;
        FLogger.f375446a.e("ObricForegroundWidgetSyncServiceImpl", "foreground widget sync failed before conversation pull, conversationId=" + r100, th);
        goto L28
    L30:
        throw th;
    L7:
        r102 = new ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1(this, r101);
        goto L8
    }
}
