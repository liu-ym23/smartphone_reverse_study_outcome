package com.larus.bmhome.chat.manager.settings;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.IUserSettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.setting.bean.UserConfigPullReason;
import com.larus.bmhome.setting.SettingRepo;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.platform.model.UserConfigItem;
import hq9.y4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010#\u001a\u00020\u0017J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0017J\u0018\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\u0016\u00105\u001a\u00020\u00142\u0006\u00101\u001a\u00020-2\u0006\u00106\u001a\u00020\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R!\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\r\u001a\u0004\b3\u0010\u0019¨\u00067"}, d2 = {"Lcom/larus/bmhome/chat/manager/settings/SettingOptionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "settingRepo", "Lcom/larus/bmhome/setting/SettingRepo;", "botService", "Lcom/larus/im/service/IBotService;", "getBotService", "()Lcom/larus/im/service/IBotService;", "botService$delegate", "Lkotlin/Lazy;", "conversationService", "Lcom/larus/im/service/IConversationService;", "getConversationService", "()Lcom/larus/im/service/IConversationService;", "conversationService$delegate", "updateUserConfigs", "Lkotlinx/coroutines/Job;", "answerWithSuggestLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getAnswerWithSuggestLiveData", "()Landroidx/lifecycle/MutableLiveData;", "isPromptEnabled", "togglePromptEnabled", "toggle", "inputSuggestEnableLiveData", "getInputSuggestEnableLiveData", "isInputSuggestEnable", "setInputSuggestEnable", "highlightEngineEnableLiveData", "getHighlightEngineEnableLiveData", "isHighlightEnabled", "setHighlightEnable", "enable", "personalizedRecommendLiveData", "getPersonalizedRecommendLiveData", "isPersonalizedRecommendEnable", "togglePersonalizedRecommendEnable", "findConversation", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBot", "Lcom/larus/im/bean/bot/BotModel;", "botId", "messagePushLiveData", "getMessagePushLiveData", "messagePushLiveData$delegate", "updateMessagePush", "messagePush", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingOptionViewModel extends AndroidViewModel {
    private final MutableLiveData<Boolean> answerWithSuggestLiveData;
    private final Lazy botService$delegate;
    private final Lazy conversationService$delegate;
    private final MutableLiveData<Boolean> highlightEngineEnableLiveData;
    private final MutableLiveData<Boolean> inputSuggestEnableLiveData;
    private final Lazy messagePushLiveData$delegate;
    private final MutableLiveData<Boolean> personalizedRecommendLiveData;
    private final SettingRepo settingRepo;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$setHighlightEnable$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$setHighlightEnable$1", f = "SettingOptionViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        public AnonymousClass1(SettingOptionViewModel r100, boolean r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$enable = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$enable, r101);
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
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            boolean r103 = ((Boolean) r100).booleanValue();
            this.this$0.getHighlightEngineEnableLiveData().postValue(Boxing.boxBoolean(r103));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            SettingRepo r104 = SettingOptionViewModel.access$getSettingRepo$p(this.this$0);
            boolean r105 = this.$enable;
            this.label = 1;
            r100 = r104.l(r105, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$setInputSuggestEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$setInputSuggestEnable$1", f = "SettingOptionViewModel.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        Object L$0;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        public C108891(SettingOptionViewModel r100, boolean r101, Continuation<? super C108891> r102) {
            this.this$0 = r100;
            this.$toggle = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108891(this.this$0, this.$toggle, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108891) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            MutableLiveData r103 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(r100);
        L12:
            r103.postValue(r100);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableLiveData<Boolean> r104 = this.this$0.getInputSuggestEnableLiveData();
            SettingRepo r105 = SettingOptionViewModel.access$getSettingRepo$p(this.this$0);
            boolean r106 = this.$toggle;
            this.L$0 = r104;
            this.label = 1;
            Object r107 = r105.R(r106, this);
            if (r107 != r101) goto L11;
            return r101;
        L11:
            r103 = r104;
            r100 = r107;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$togglePersonalizedRecommendEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$togglePersonalizedRecommendEnable$1", f = "SettingOptionViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        Object L$0;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        public C108901(SettingOptionViewModel r100, boolean r101, Continuation<? super C108901> r102) {
            this.this$0 = r100;
            this.$toggle = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108901(this.this$0, this.$toggle, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108901) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            MutableLiveData r103 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(r100);
        L12:
            r103.postValue(r100);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableLiveData<Boolean> r104 = this.this$0.getPersonalizedRecommendLiveData();
            SettingRepo r105 = SettingOptionViewModel.access$getSettingRepo$p(this.this$0);
            boolean r106 = this.$toggle;
            this.L$0 = r104;
            this.label = 1;
            r105.getClass();
            Object r107 = UserSettingCacheManager.n(UserSettingCacheManager.f313814a, r106, this);
            if (r107 != r101) goto L11;
            return r101;
        L11:
            r103 = r104;
            r100 = r107;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$togglePromptEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$togglePromptEnabled$1", f = "SettingOptionViewModel.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $toggle;
        Object L$0;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        public C108911(SettingOptionViewModel r100, boolean r101, Continuation<? super C108911> r102) {
            this.this$0 = r100;
            this.$toggle = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108911(this.this$0, this.$toggle, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108911) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            MutableLiveData r103 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(r100);
        L12:
            r103.postValue(r100);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableLiveData<Boolean> r104 = this.this$0.getAnswerWithSuggestLiveData();
            SettingRepo r105 = SettingOptionViewModel.access$getSettingRepo$p(this.this$0);
            boolean r106 = this.$toggle;
            this.L$0 = r104;
            this.label = 1;
            Object r107 = r105.Q(r106, this);
            if (r107 != r101) goto L11;
            return r101;
        L11:
            r103 = r104;
            r100 = r107;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateMessagePush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateMessagePush$1", f = "SettingOptionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ boolean $messagePush;
        int label;
        final /* synthetic */ SettingOptionViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateMessagePush$1$a */
        public static final class a implements IIMCallback<uc9.t> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SettingOptionViewModel f306798a;

            @Override // com.larus.im.callback.IIMCallback
            public final boolean mustInMain() {
                return !y0.a();
            }

            public a(SettingOptionViewModel r100) {
                this.f306798a = r100;
            }

            @Override // com.larus.im.callback.IIMCallback
            public final void onFailure(IIMError r100) {
                Intrinsics.checkNotNullParameter(r100, "error");
                Intrinsics.checkNotNullParameter(r100, "error");
                this.f306798a.getMessagePushLiveData().postValue(Boolean.FALSE);
            }

            @Override // com.larus.im.callback.IIMCallback
            public final void onSuccess(uc9.t r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                this.f306798a.getMessagePushLiveData().postValue(Boolean.TRUE);
            }
        }

        public C108921(SettingOptionViewModel r100, String r101, boolean r102, Continuation<? super C108921> r103) {
            this.this$0 = r100;
            this.$botId = r101;
            this.$messagePush = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108921(this.this$0, this.$botId, this.$messagePush, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108921) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            SettingOptionViewModel.access$getBotService(this.this$0).modifyMessagePush(this.$botId, this.$messagePush, new a(this.this$0));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateUserConfigs$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.manager.settings.SettingOptionViewModel$updateUserConfigs$1", f = "SettingOptionViewModel.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    public static final class C108931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C108931(Continuation<? super C108931> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C108931(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C108931) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            y4 r103 = (y4) r100;
            if (r103 == null) goto L14;
            ArrayList<UserConfigItem> r104 = r103.a();
        L15:
            if (r104 == null) goto L18;
            UserSettingDelegate.f308901b.c(r104);
        L18:
            return Unit.INSTANCE;
        L14:
            r104 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            IUserSettingRepoService r105 = RepoDispatcherDelegate.f307737b.h();
            UserConfigKey.Companion.getClass();
            List<Integer> r106 = UserConfigKey.a.b();
            int r107 = UserConfigPullReason.STARTUP.getValue();
            this.label = 1;
            r100 = r105.e(r106, r107, "settings_page", this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    public static /* synthetic */ com.larus.im.service.o Mo() {
        return botService_delegate$lambda$0();
    }

    public static /* synthetic */ com.larus.im.service.r No() {
        return conversationService_delegate$lambda$1();
    }

    public static /* synthetic */ MutableLiveData yo() {
        return messagePushLiveData_delegate$lambda$2();
    }

    private final com.larus.im.service.o getBotService() {
        return (com.larus.im.service.o) this.botService$delegate.getValue();
    }

    private final com.larus.im.service.r getConversationService() {
        return (com.larus.im.service.r) this.conversationService$delegate.getValue();
    }

    private static final MutableLiveData messagePushLiveData_delegate$lambda$2() {
        return new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getMessagePushLiveData() {
        return (MutableLiveData) this.messagePushLiveData$delegate.getValue();
    }

    public final boolean isHighlightEnabled() {
        return this.settingRepo.o();
    }

    public final boolean isInputSuggestEnable() {
        return this.settingRepo.p();
    }

    public final boolean isPersonalizedRecommendEnable() {
        return this.settingRepo.R0();
    }

    public final boolean isPromptEnabled() {
        return this.settingRepo.i();
    }

    private static final com.larus.im.service.o botService_delegate$lambda$0() {
        return com.larus.im.d.a();
    }

    private static final com.larus.im.service.r conversationService_delegate$lambda$1() {
        return com.larus.im.d.d();
    }

    public final Job updateUserConfigs() {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C108931(null), 3, null);
    }

    public final MutableLiveData<Boolean> getAnswerWithSuggestLiveData() {
        return this.answerWithSuggestLiveData;
    }

    public final MutableLiveData<Boolean> getHighlightEngineEnableLiveData() {
        return this.highlightEngineEnableLiveData;
    }

    public final MutableLiveData<Boolean> getInputSuggestEnableLiveData() {
        return this.inputSuggestEnableLiveData;
    }

    public final MutableLiveData<Boolean> getPersonalizedRecommendLiveData() {
        return this.personalizedRecommendLiveData;
    }

    public SettingOptionViewModel(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        super(r100);
        RepoDispatcher.f307729a.getClass();
        this.settingRepo = RepoDispatcher.f307733e;
        this.botService$delegate = LazyKt.lazy(new q());
        this.conversationService$delegate = LazyKt.lazy(new r());
        this.answerWithSuggestLiveData = new MutableLiveData();
        this.inputSuggestEnableLiveData = new MutableLiveData();
        this.highlightEngineEnableLiveData = new MutableLiveData();
        this.personalizedRecommendLiveData = new MutableLiveData();
        this.messagePushLiveData$delegate = LazyKt.lazy(new s());
    }

    public static final /* synthetic */ com.larus.im.service.o access$getBotService(SettingOptionViewModel r100) {
        return r100.getBotService();
    }

    public static final /* synthetic */ SettingRepo access$getSettingRepo$p(SettingOptionViewModel r100) {
        return r100.settingRepo;
    }

    public final Job setHighlightEnable(boolean r100) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r100, null), 3, null);
    }

    public final Job setInputSuggestEnable(boolean r100) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C108891(this, r100, null), 3, null);
    }

    public final Job togglePersonalizedRecommendEnable(boolean r100) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C108901(this, r100, null), 3, null);
    }

    public final Job togglePromptEnabled(boolean r100) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C108911(this, r100, null), 3, null);
    }

    public final Object findBot(String r100, Continuation<? super BotModel> r110) {
        RepoDispatcher.f307729a.getClass();
        return IBotRepoService.b.a(RepoDispatcher.f307735g, r100, true, null, false, r110, 28);
    }

    public final Object findConversation(String r100, Continuation<? super wc9.e> r101) {
        RepoDispatcher.f307729a.getClass();
        return IConversationRepoService.a.c(RepoDispatcher.f307734f, r100, false, null, r101, 6);
    }

    public final Job updateMessagePush(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C108921(this, r100, r101, null), 2, null);
    }
}
