package com.larus.bmhome.chat.component.bottom;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.feishu.office.im.impl.base.FeishuInputAdapterComponent;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001VB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0095\u0001\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u0010\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010&JK\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\b\u0010.\u001a\u0004\u0018\u00010\u00132\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u00100J0\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010)2\u0006\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u00106J\"\u00107\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0016\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020!H\u0096@¢\u0006\u0002\u0010:Jk\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\u00132\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00172\u0006\u0010?\u001a\u00020\u00192\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u00192\b\u0010E\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010FJ \u0010G\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020JH\u0016J\u001e\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u00132\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00100NH\u0002J4\u0010O\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u00132\u001c\u0010M\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100Q\u0012\u0006\u0012\u0004\u0018\u00010R0PH\u0082@¢\u0006\u0002\u0010SJ\u0012\u0010T\u001a\u00020\u00102\b\u0010U\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/ChatMessageComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "<init>", "()V", "chatMessageViewModel", "Lcom/larus/bmhome/chat/component/bottom/ChatMessageViewModel;", "getChatMessageViewModel", "()Lcom/larus/bmhome/chat/component/bottom/ChatMessageViewModel;", "chatMessageViewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "messageSendDelegate", "Lcom/larus/bmhome/chat/component/IMessageSendDelegate;", "currentChatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "onAttach", "", "sendText", "conversationId", "", "content", "scene", "extra", "", "isAutoInterrupt", "", "status", "Lcom/larus/im/bean/message/MessageStatus;", "referenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "creationSendTraceId", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/message/Message;", "Lcom/larus/im/callback/IIMError;", "sendClickTimestamp", "", "restoreInputOnCancel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLcom/larus/im/bean/message/MessageStatus;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/lang/Long;Z)V", "sendFileAndTxt", "conversationLiveData", "Lcom/larus/im/bean/conversation/Conversation;", "txtScene", "strategyList", "", "Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;", "fromScene", "sameScene", "(Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V", "resendMessage", "conversation", "replyMessage", "traceScene", "resendScene", "(Lcom/larus/im/bean/conversation/Conversation;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSearch", "deleteOnModifySendBeforeAck", "msg", "(Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceMsgOnModifySendAfterAck", "message", "replaceText", "extras", "needReplaceTxtAndFile", "newAttachmentInfo", "Lcom/larus/bmhome/view/AttachmentInfo;", "newNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "location", "attachmentEntityLocalMsgId", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/util/Map;ZLcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/im/bean/message/NestedFileContent;ZLjava/lang/String;Ljava/lang/Long;)V", "breakAllMsg", "breakReason", "breakReasonCode", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "runSafely", "functionName", "block", "Lkotlin/Function0;", "runSuspendSafely", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMessageSendDelegate", "delegate", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatMessageComponent extends ComponentFeature implements gd8.g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f297982j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.ui.arch.vm.internal.l f297983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gd8.h f297984i;

    public static final class a {
    }

    public static final class b implements Function0<LifecycleOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f297985a;

        public b(ComponentFeature r100) {
            this.f297985a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            return this.f297985a;
        }
    }

    public static final class c implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f297986a;

        public c(ComponentFeature r100) {
            this.f297986a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return s1a.a.c(this.f297986a);
        }
    }

    public static final class d implements Function0<ViewModelProvider.Factory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f297987a = null;

        static {
            f297987a = new d();
        }

        public d() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final ChatPageContext F2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return (ChatPageContext) s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(ChatPageContext.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ChatMessageViewModel L2() {
        return (ChatMessageViewModel) this.f297983h.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        N2("onAttach", new i1(this));
    }

    public ChatMessageComponent() {
        this.f297983h = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(ChatMessageViewModel.class), Reflection.getOrCreateKotlinClass(ChatMessageComponentState.class), new b(this), new c(this), d.f297987a);
    }

    @Override // gd8.g
    public final void MU(FeishuInputAdapterComponent.e r100) {
        FLogger.f375446a.i("ChatMessageComponent", "[setMessageSendDelegate] delegate:".concat("custom"));
        this.f297984i = r100;
    }

    public static void N2(String r100, Function0 r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        r101.invoke();     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L12;
        FLogger.f375446a.e("ChatMessageComponent", r100 + ' ' + r104);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // gd8.g
    public final Unit CQ(wc9.e r110, Message r111) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatMessageComponent$resendMessage$2(this, r110, r111, "regenerate", "nested_file_parse_regen", null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // gd8.g
    public final Object hi(Message r100, Continuation<? super Unit> r101) {
        Object r102 = P2("deleteOnModifySendBeforeAck", new ChatMessageComponent$deleteOnModifySendBeforeAck$2(this, r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // gd8.g
    public final void ou(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter("action_search", "scene");
        N2("sendSearch", new k1(this, r100, r101));
    }

    public final Object P2(String r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof ChatMessageComponent$runSuspendSafely$1) == false) goto L7;
        ChatMessageComponent$runSuspendSafely$1 r103 = (ChatMessageComponent$runSuspendSafely$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L22
    L20:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L28;
        FLogger.f375446a.e("ChatMessageComponent", r100 + ' ' + r109);
    L28:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L22
        r103.L$0 = r100;     // Catch: Throwable -> L22
        r103.label = 1;     // Catch: Throwable -> L22
        if (r101.invoke(r103) != r106) goto L20;
        return r106;
    L22:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new ChatMessageComponent$runSuspendSafely$1(this, r102);
        goto L8
    }

    @Override // gd8.g
    public final void mh(final String r100, final String r101, final OmniBreakReason r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "breakReason");
        Intrinsics.checkNotNullParameter(r102, "breakReasonCode");
        N2("breakAllMsg", new h1(this, r100, r101, r102));
    }

    @Override // gd8.g
    public final void sW(final wc9.e r110, final String r111, final List<? extends ic8.w> r112, final String r113, final Boolean r114, final Long r115) {
        Intrinsics.checkNotNullParameter(r111, "txtScene");
        Intrinsics.checkNotNullParameter(r112, "strategyList");
        N2("sendFileAndTxt", new g1(this, r112, r110, r111, r113, r114, r115));
    }

    @Override // gd8.g
    public final void J00(final Message r110, final String r111, final Map<String, String> r112, final boolean r113, final AttachmentInfo r114, final NestedFileContent r115, final boolean r116, final String r210, final Long r211) {
        Intrinsics.checkNotNullParameter(r110, "message");
        Intrinsics.checkNotNullParameter(r111, "replaceText");
        N2("replaceMsgOnModifySendAfterAck", new l1(this, r110, r111, r112, r113, r114, r115, r116, r210, r211));
    }

    @Override // gd8.g
    public final void sd(final String r110, final String r111, final String r112, final Map<String, String> r113, final boolean r114, final MessageStatus r210, final ReferenceInfo r211, final String r212, final Function2<? super Message, ? super IIMError, Unit> r213, final Long r214, final boolean r215) {
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r112, "scene");
        N2("sendText", new j1(this, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215));
    }
}
