package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0003?@AB\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:J\u0006\u0010;\u001a\u000208J\u0006\u0010<\u001a\u000208J\b\u0010=\u001a\u000208H\u0014J\b\u0010>\u001a\u000208H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R \u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006B"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larksuite/rucket/core/base/ServiceModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/IChatPushService;", "messageService", "Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "<init>", "(Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", "getMessageService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;", "getFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "listener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel$FullDataChangeListener;", EventVerify.TYPE_LAUNCH, "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel$InitData;", "getLaunch", "()Landroidx/lifecycle/MutableLiveData;", "chatLiveData", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChatLiveData", "error", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getError", "initLiveData", "", "getInitLiveData", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "getItem", "()Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "setItem", "(Lcom/ss/android/lark/chat/vo/AbsMessageVO;)V", "initChat", "pageType", "Lcom/ss/android/lark/biz/im/extension/PageType;", "sequenceId", "", "fullScreenItemSupport", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenSupport;", "getFullScreenItemSupport", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenSupport;", "fullScreenItemSupport$delegate", "Lkotlin/Lazy;", "pushSourceJob", "Lcom/larksuite/rucket/job/RucketJob;", "Lcom/bytedance/lark/pb/basic/v1/Entity;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "parseArguments", "", "bundle", "Landroid/os/Bundle;", MapMonitorConst.EVENT_DESTROY, LynxTemplateRender.RENDER_PHASE_SETUP, "onCleared", "clear", "Companion", "FullDataChangeListener", "InitData", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageFullScreenViewModel extends ViewModel implements CoroutineScope {
    public static final a Companion = null;
    private static final String TAG = "MsgFullViewModel";
    private final MutableLiveData<Chat> chatLiveData;
    private final CoroutineContext coroutineContext;
    private final MutableLiveData<ErrorResult> error;
    private final jdb.g fgService;
    private final Lazy fullScreenItemSupport$delegate;
    private Chat initChat;
    private final MutableLiveData<Boolean> initLiveData;
    private y6b.a<?> item;
    private final MutableLiveData<c> launch;
    private b listener;
    private final com.ss.android.lark.im.sdk.service.p messageService;
    private PageType pageType;
    private RucketJob<Entity> pushSourceJob;
    private String sequenceId;

    public static final class a {
        public a() {
        }
    }

    public final class b extends com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.c {
        public b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C4829a r100) {
            Intrinsics.checkNotNullParameter(r100, "dataKey");
            super(r100);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageFullScreenLaunchData f413958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Message f413959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Chat f413960c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f413958a, r101.f413958a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413959b, r101.f413959b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f413960c, r101.f413960c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f413958a.hashCode() * 31;
            Message r101 = this.f413959b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f413960c.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "InitData(launchData=" + this.f413958a + ", message=" + this.f413959b + ", chat=" + this.f413960c + ')';
        }

        public c(MessageFullScreenLaunchData r100, Chat r101) {
            Intrinsics.checkNotNullParameter(r100, "launchData");
            Intrinsics.checkNotNullParameter(r101, "chat");
            this.f413958a = r100;
            this.f413959b = null;
            this.f413960c = r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel$parseArguments$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel$parseArguments$1", f = "MessageFullScreenViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Chat $chat;
        final /* synthetic */ MessageFullScreenLaunchData $launchData;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MessageFullScreenViewModel this$0;

        public AnonymousClass1(Chat r100, MessageFullScreenLaunchData r101, MessageFullScreenViewModel r102, Continuation<? super AnonymousClass1> r103) {
            this.$chat = r100;
            this.$launchData = r101;
            this.this$0 = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.$chat, this.$launchData, this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L25;
            ResultKt.throwOnFailure(r100);
            CoroutineScope r101 = (CoroutineScope) this.L$0;
            Chat r102 = this.$chat;
            if (r102 != null) goto L9;
            this.this$0.getError().postValue(new ErrorResult("launch chat is invalid"));
            return Unit.INSTANCE;
        L9:
            if (this.$launchData != null) goto L12;
            this.this$0.getError().postValue(new ErrorResult("launch data is invalid"));
            return Unit.INSTANCE;
        L12:
            MessageFullScreenViewModel.access$setInitChat$p(this.this$0, r102);
            this.this$0.getChatLiveData().postValue(this.$chat);
            MessageFullScreenViewModel.access$setPageType$p(this.this$0, this.$launchData.getPageType());
            MessageFullScreenViewModel.access$setSequenceId$p(this.this$0, this.$launchData.getSequenceId());
            ExecutorService r103 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.f413974a;
            String r104 = this.$chat.getId();
            PageType r105 = this.$launchData.getPageType();
            String r106 = MessageFullScreenViewModel.access$getSequenceId$p(this.this$0);
            if (r106 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("sequenceId");
            r106 = null;
        L15:
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C4829a r107 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C4829a(r104, r105, r106);
            String r108 = this.$launchData.getMessageId();
            Intrinsics.checkNotNullParameter(r107, "key");
            Intrinsics.checkNotNullParameter(r108, "messageId");
            if (((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.b) ((ConcurrentHashMap) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.f413975b).get(r107)) == null) goto L18;
            Intrinsics.checkNotNullParameter(r108, "messageId");
            Intrinsics.areEqual(null, r108);
        L18:
            this.this$0.setItem(null);
            StringBuilder r109 = new StringBuilder("parse data from memory center: messageId = ");
            r109.append(this.$launchData.getMessageId());
            r109.append(", vo valid: ");
            if (this.this$0.getItem() == null) goto L21;
            boolean r110 = true;
        L22:
            r109.append(r110);
            r109.append(", do valid: false");
            Log.i(MessageFullScreenViewModel.TAG, r109.toString());
            MutableLiveData<c> r111 = this.this$0.getLaunch();
            MessageFullScreenLaunchData r112 = this.$launchData;
            r112.setMessage(null);
            r111.postValue(new c(r112, this.$chat));
            this.this$0.getInitLiveData().postValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L21:
            r110 = false;
            goto L22
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel$setup$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel$setup$2", f = "MessageFullScreenViewModel.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ MessageFullScreenViewModel this$0;

        public AnonymousClass2(MessageFullScreenViewModel r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0053 -> B:16:0x0058). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<Entity>> r103 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r100);
            com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<Entity>> r104 = r103;
            Object r105 = r101;
            AnonymousClass2 r106 = this;
        L17:
            if (((Boolean) r100).booleanValue() == false) goto L28;
            com.larksuite.rucket.job.base.b r107 = r104.a();
            Chat r108 = null;
            Map<String, Chat> r109 = com.ss.android.lark.parser.internal.h.d(((Entity) r107.b()).chats, null, ((Entity) r107.b()).mail_setting);
            Chat r110 = MessageFullScreenViewModel.access$getInitChat$p(r106.this$0);
            if (r110 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("initChat");
        L22:
            HashMap r111 = (HashMap) r109;
            Chat r112 = (Chat) r111.get(r108.getId());
            if (r112 == null) goto L26;
            r106.this$0.getChatLiveData().postValue(r112);
        L26:
            AnonymousClass2 r113 = r106;
            r101 = r105;
            com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<Entity>> r114 = r104;
        L12:
            r113.L$0 = r114;
            r113.label = 1;
            Object r115 = r114.hasNext(r113);
            if (r115 != r101) goto L15;
            return r101;
        L15:
            Object r116 = r101;
            r106 = r113;
            r100 = r115;
            r104 = r114;
            r105 = r116;
            goto L17
        L21:
            r108 = r110;
            goto L22
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            RucketJob<Entity> r117 = ((f) b38.b.f17382a.create(f.class)).chatsPush();
            if (this.this$0.getFgService().isEnable("im.chat.memory.disable_push_cancel") == true) goto L11;
            MessageFullScreenViewModel.access$setPushSourceJob$p(this.this$0, r117);
        L11:
            r114 = r117.iterator();
            r113 = this;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    private final void clear() {
        b r100 = this.listener;
        if (r100 == null) goto L5;
        ExecutorService r101 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.f413974a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.f413977d).remove(r100);
    L5:
        ExecutorService r102 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.f413974a;
        Chat r103 = this.initChat;
        String r104 = null;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("initChat");
        r103 = null;
    L8:
        String r105 = r103.getId();
        PageType r106 = this.pageType;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        r106 = null;
    L11:
        String r107 = this.sequenceId;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("sequenceId");
    L15:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C4829a r108 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C4829a(r105, r106, r104);
        Intrinsics.checkNotNullParameter(r108, "key");
        ((ConcurrentHashMap) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.f413975b).remove(r108);
        ((ConcurrentHashMap) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.f413976c).remove(r108);
        return;
    L14:
        r104 = r107;
        goto L15
    }

    private final o getFullScreenItemSupport() {
        return (o) this.fullScreenItemSupport$delegate.getValue();
    }

    public final void destroy() {
        this.initLiveData.postValue(Boolean.FALSE);
        this.item = null;
        clear();
        this.listener = null;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Log.i(TAG, "clear data and listeners");
        clear();
        if (this.fgService.isEnable("im.chat.memory.disable_push_cancel") == true) goto L9;
        RucketJob<Entity> r100 = this.pushSourceJob;
        if (r100 == null) goto L7;
        r100.cancel();
    L7:
        this.pushSourceJob = null;
        return;
    }

    public final void setup() {
        Chat r100 = this.initChat;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initChat");
        r100 = null;
    L5:
        String r101 = r100.getId();
        PageType r102 = this.pageType;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        r102 = null;
    L8:
        String r103 = this.sequenceId;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("sequenceId");
        r103 = null;
    L11:
        b r104 = new b(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C4829a(r101, r102, r103));
        this.listener = r104;
        ExecutorService r105 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.f413974a;
        Intrinsics.checkNotNullParameter(r104, "listener");
        ((CopyOnWriteArrayList) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.f413977d).add(r104);
        BuildersKt.launch$default(this, null, null, new AnonymousClass2(this, null), 3, null);
    }

    public final MutableLiveData<Chat> getChatLiveData() {
        return this.chatLiveData;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final MutableLiveData<ErrorResult> getError() {
        return this.error;
    }

    public final jdb.g getFgService() {
        return this.fgService;
    }

    public final MutableLiveData<Boolean> getInitLiveData() {
        return this.initLiveData;
    }

    public final y6b.a<?> getItem() {
        return this.item;
    }

    public final MutableLiveData<c> getLaunch() {
        return this.launch;
    }

    public final com.ss.android.lark.im.sdk.service.p getMessageService() {
        return this.messageService;
    }

    public static final /* synthetic */ o access$getFullScreenItemSupport(MessageFullScreenViewModel r100) {
        return r100.getFullScreenItemSupport();
    }

    public static final /* synthetic */ Chat access$getInitChat$p(MessageFullScreenViewModel r100) {
        return r100.initChat;
    }

    public static final /* synthetic */ PageType access$getPageType$p(MessageFullScreenViewModel r100) {
        return r100.pageType;
    }

    public static final /* synthetic */ String access$getSequenceId$p(MessageFullScreenViewModel r100) {
        return r100.sequenceId;
    }

    public final void parseArguments(Bundle r110) {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 33) goto L7;
        if (r110 == null) goto L6;
        MessageFullScreenLaunchData r101 = (MessageFullScreenLaunchData) r110.getSerializable("key_message_full_screen_data", MessageFullScreenLaunchData.class);
    L12:
        if (r100 < 33) goto L16;
        if (r110 == null) goto L15;
        Chat r111 = (Chat) r110.getSerializable("key_chat", Chat.class);
    L21:
        if (r101 == null) goto L24;
        String r102 = r101.toString();
        if (r102 == null) goto L24;
    L25:
        Log.i(TAG, "parseData: launchData = ".concat(r102));
        BuildersKt.launch$default(this, getCoroutineContext(), null, new AnonymousClass1(r111, r101, this, null), 2, null);
        return;
    L24:
        r102 = "invalid";
        goto L25
    L15:
        r111 = null;
        goto L21
    L16:
        if (r110 == null) goto L18;
        Serializable r112 = r110.getSerializable("key_chat");
    L19:
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chat.Chat");
        r111 = (Chat) r112;
        goto L21
    L18:
        r112 = null;
        goto L19
    L6:
        r101 = null;
        goto L12
    L7:
        if (r110 == null) goto L9;
        Serializable r103 = r110.getSerializable("key_message_full_screen_data");
    L10:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData");
        r101 = (MessageFullScreenLaunchData) r103;
        goto L12
    L9:
        r103 = null;
        goto L10
    }

    public final void setItem(y6b.a<?> r100) {
        this.item = r100;
    }

    @Inject
    public MessageFullScreenViewModel(com.ss.android.lark.im.sdk.service.p r100, jdb.g r101) {
        Intrinsics.checkNotNullParameter(r100, "messageService");
        Intrinsics.checkNotNullParameter(r101, "fgService");
        this.messageService = r100;
        this.fgService = r101;
        this.launch = new MutableLiveData();
        this.chatLiveData = new MutableLiveData();
        this.error = new MutableLiveData();
        this.initLiveData = new MutableLiveData();
        this.fullScreenItemSupport$delegate = LazyKt.lazy(MessageFullScreenViewModel$fullScreenItemSupport$2.INSTANCE);
        this.coroutineContext = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain());
    }

    public static final /* synthetic */ void access$setInitChat$p(MessageFullScreenViewModel r100, Chat r101) {
        r100.initChat = r101;
    }

    public static final /* synthetic */ void access$setPageType$p(MessageFullScreenViewModel r100, PageType r101) {
        r100.pageType = r101;
    }

    public static final /* synthetic */ void access$setPushSourceJob$p(MessageFullScreenViewModel r100, RucketJob r101) {
        r100.pushSourceJob = r101;
    }

    public static final /* synthetic */ void access$setSequenceId$p(MessageFullScreenViewModel r100, String r101) {
        r100.sequenceId = r101;
    }
}
