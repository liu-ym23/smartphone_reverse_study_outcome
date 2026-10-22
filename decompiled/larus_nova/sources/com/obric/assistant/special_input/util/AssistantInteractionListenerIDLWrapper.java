package com.obric.assistant.special_input.util;

import android.os.IBinder;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/special_input/util/AssistantInteractionListenerIDLWrapper;", "Lcom/obric/aiagent/assistant/idl/IAssistantInteractionListenerIDL;", "iAssistantInteractionListenerIDL", "taskChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function0;", "", "<init>", "(Lcom/obric/aiagent/assistant/idl/IAssistantInteractionListenerIDL;Lkotlinx/coroutines/channels/Channel;)V", "asBinder", "Landroid/os/IBinder;", "onAssistantTakeOver", "onReply", "content", "", "onPanelCancel", "onPanelShow", "height", "", "onPanelHeightChanged", "requestToShowInputPanel", "requestToShowInputPanelWithMeta", "meta", "onAssistantDied", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantInteractionListenerIDLWrapper implements IAssistantInteractionListenerIDL {
    public static final a Companion = null;
    private static final String TAG = "SpecialInputAssistantInteractionListenerIDLWrapper";
    private final IAssistantInteractionListenerIDL iAssistantInteractionListenerIDL;
    private final Channel<Function0<Unit>> taskChannel;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit a(String r100, AssistantInteractionListenerIDLWrapper r101) {
        return requestToShowInputPanelWithMeta$lambda$27(r100, r101);
    }

    public static /* synthetic */ Unit b(AssistantInteractionListenerIDLWrapper r100) {
        return onAssistantTakeOver$lambda$3(r100);
    }

    public static /* synthetic */ Unit c(AssistantInteractionListenerIDLWrapper r100, int r101) {
        return onPanelShow$lambda$15(r100, r101);
    }

    public static /* synthetic */ Unit d(String r100, AssistantInteractionListenerIDLWrapper r101) {
        return onReply$lambda$7(r100, r101);
    }

    public static /* synthetic */ Unit e(AssistantInteractionListenerIDLWrapper r100) {
        return onPanelCancel$lambda$11(r100);
    }

    public static /* synthetic */ Unit f(AssistantInteractionListenerIDLWrapper r100, int r101) {
        return onPanelHeightChanged$lambda$19(r100, r101);
    }

    public static /* synthetic */ Unit g(AssistantInteractionListenerIDLWrapper r100) {
        return onAssistantDied$lambda$31(r100);
    }

    public static /* synthetic */ Unit h(AssistantInteractionListenerIDLWrapper r100) {
        return requestToShowInputPanel$lambda$23(r100);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.iAssistantInteractionListenerIDL.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantDied() {
        this.taskChannel.mo10962trySendJP2dKIU(new c(this));
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantTakeOver() {
        this.taskChannel.mo10962trySendJP2dKIU(new d(this));
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelCancel() {
        this.taskChannel.mo10962trySendJP2dKIU(new h(this));
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanel() {
        this.taskChannel.mo10962trySendJP2dKIU(new com.obric.assistant.special_input.util.a(this));
    }

    private static final Unit onAssistantDied$lambda$31(AssistantInteractionListenerIDLWrapper r100) {
        FLogger.f375446a.i(TAG, "onAssistantDied");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.iAssistantInteractionListenerIDL.onAssistantDied();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        FLogger.f375446a.w(TAG, "onAssistantDied failed: " + r103.getMessage(), r103);
    L11:
        if (Result.m9456isSuccessimpl(r102) == false) goto L14;
        Unit r104 = (Unit) r102;
        FLogger.f375446a.i(TAG, "onAssistantDied succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit onAssistantTakeOver$lambda$3(AssistantInteractionListenerIDLWrapper r100) {
        FLogger.f375446a.i(TAG, "onAssistantTakeOver");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.iAssistantInteractionListenerIDL.onAssistantTakeOver();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        FLogger.f375446a.w(TAG, "onAssistantTakeOver failed: " + r103.getMessage(), r103);
    L11:
        if (Result.m9456isSuccessimpl(r102) == false) goto L14;
        Unit r104 = (Unit) r102;
        FLogger.f375446a.i(TAG, "onAssistantTakeOver succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit onPanelCancel$lambda$11(AssistantInteractionListenerIDLWrapper r100) {
        FLogger.f375446a.i(TAG, "onPanelCancel");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.iAssistantInteractionListenerIDL.onPanelCancel();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        FLogger.f375446a.w(TAG, "onPanelCancel failed: " + r103.getMessage(), r103);
    L11:
        if (Result.m9456isSuccessimpl(r102) == false) goto L14;
        Unit r104 = (Unit) r102;
        FLogger.f375446a.i(TAG, "onPanelCancel succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit requestToShowInputPanel$lambda$23(AssistantInteractionListenerIDLWrapper r100) {
        FLogger.f375446a.i(TAG, "requestToShowInputPanel");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.iAssistantInteractionListenerIDL.requestToShowInputPanel();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        FLogger.f375446a.w(TAG, "requestToShowInputPanel failed: " + r103.getMessage(), r103);
    L11:
        if (Result.m9456isSuccessimpl(r102) == false) goto L14;
        Unit r104 = (Unit) r102;
        FLogger.f375446a.i(TAG, "requestToShowInputPanel succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelHeightChanged(final int r100) {
        this.taskChannel.mo10962trySendJP2dKIU(new g(this, r100));
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelShow(final int r100) {
        FLogger.f375446a.i(TAG, "onPanelShow: height = " + r100);
        this.taskChannel.mo10962trySendJP2dKIU(new b(this, r100));
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onReply(final String r100) {
        this.taskChannel.mo10962trySendJP2dKIU(new e(r100, this));
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanelWithMeta(final String r100) {
        this.taskChannel.mo10962trySendJP2dKIU(new f(r100, this));
    }

    public AssistantInteractionListenerIDLWrapper(IAssistantInteractionListenerIDL r100, Channel<Function0<Unit>> r101) {
        Intrinsics.checkNotNullParameter(r100, "iAssistantInteractionListenerIDL");
        Intrinsics.checkNotNullParameter(r101, "taskChannel");
        this.iAssistantInteractionListenerIDL = r100;
        this.taskChannel = r101;
    }

    private static final Unit onPanelHeightChanged$lambda$19(AssistantInteractionListenerIDLWrapper r100, int r101) {
        FLogger.f375446a.i(TAG, "onPanelHeightChanged");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        r100.iAssistantInteractionListenerIDL.onPanelHeightChanged(r101);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L11;
        FLogger.f375446a.w(TAG, "onPanelHeightChanged failed: " + r104.getMessage(), r104);
    L11:
        if (Result.m9456isSuccessimpl(r103) == false) goto L14;
        Unit r105 = (Unit) r103;
        FLogger.f375446a.i(TAG, "onPanelHeightChanged succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit onPanelShow$lambda$15(AssistantInteractionListenerIDLWrapper r100, int r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        r100.iAssistantInteractionListenerIDL.onPanelShow(r101);     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L10;
        FLogger.f375446a.w(TAG, "onPanelShow failed: " + r104.getMessage(), r104);
    L10:
        if (Result.m9456isSuccessimpl(r103) == false) goto L13;
        Unit r105 = (Unit) r103;
        FLogger.f375446a.i(TAG, "onPanelShow succeed");
    L13:
        return Unit.INSTANCE;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private static final Unit onReply$lambda$7(String r100, AssistantInteractionListenerIDLWrapper r101) {
        if (AppHost.f326268a.isDebugChannel() == false) goto L5;
        FLogger.f375446a.i(TAG, "onReply: content = " + r100);
    L18:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        r101.iAssistantInteractionListenerIDL.onReply(r100);     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L14;
        FLogger.f375446a.w(TAG, "onReply failed: " + r104.getMessage(), r104);
    L14:
        if (Result.m9456isSuccessimpl(r103) == false) goto L17;
        Unit r105 = (Unit) r103;
        FLogger.f375446a.i(TAG, "onReply succeed");
    L17:
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L5:
        FLogger.f375446a.i(TAG, "onReply");
        goto L18
    }

    private static final Unit requestToShowInputPanelWithMeta$lambda$27(String r100, AssistantInteractionListenerIDLWrapper r101) {
        FLogger.f375446a.i(TAG, "requestToShowInputPanelWithMeta: meta = " + r100);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        r101.iAssistantInteractionListenerIDL.requestToShowInputPanelWithMeta(r100);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L11;
        FLogger.f375446a.w(TAG, "requestToShowInputPanel failed: " + r104.getMessage(), r104);
    L11:
        if (Result.m9456isSuccessimpl(r103) == false) goto L14;
        Unit r105 = (Unit) r103;
        FLogger.f375446a.i(TAG, "requestToShowInputPanel succeed");
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
