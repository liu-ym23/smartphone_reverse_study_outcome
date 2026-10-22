package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import b38.b;
import c38.c;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetP2PChatUnfamiliarStrategyRequest;
import com.bytedance.lark.pb.im.v1.GetP2PChatUnfamiliarStrategyResponse;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.ChatReadable;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerBannerType;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerTagType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jdb.g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u000278B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0016J\b\u0010-\u001a\u00020)H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v1/viewmodel/ChatP2PReadableViewModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/BaseStrangerRelationViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larksuite/rucket/core/base/UserScopeServiceModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v1/viewmodel/IChatP2PReadableService;", "initChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "p2pChatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "rucket", "Lcom/larksuite/rucket/Rucket;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/Chatter;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;Lcom/larksuite/rucket/Rucket;)V", "chatReadableFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getChatReadableFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "chatChangeToReadable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getChatChangeToReadable", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "bannerFlow", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerBannerType;", "getBannerFlow", "tagFlow", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerTagType;", "getTagFlow", "closeBannerActionFlow", "", "getCloseBannerActionFlow", "chatReadableLiveData", "Landroidx/lifecycle/MutableLiveData;", "isInWhiteList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pushSourceJob", "Lcom/larksuite/rucket/job/RucketJob;", "Lcom/bytedance/lark/pb/basic/v1/Entity;", "create", "", "setupInitData", "setupPush", MapMonitorConst.EVENT_DESTROY, "onCleared", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "scopedRucket", "getScopedRucket", "()Lcom/larksuite/rucket/Rucket;", "setScopedRucket", "(Lcom/larksuite/rucket/Rucket;)V", "Companion", "P2PStrangerViewModelFactory", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatP2PReadableViewModel extends BaseStrangerRelationViewModel implements CoroutineScope, c<com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a> {
    public static final a Companion = null;
    private static final String TAG = "ChatP2PReadableViewModel";
    private final z0<StrangerBannerType> bannerFlow;
    private final MutableSharedFlow<Integer> chatChangeToReadable;
    private final z0<Integer> chatReadableFlow;
    private final MutableLiveData<Integer> chatReadableLiveData;
    private final MutableSharedFlow<Boolean> closeBannerActionFlow;
    private final CoroutineContext coroutineContext;
    private final g fgService;
    private final Chat initChat;
    private final AtomicBoolean isInWhiteList;
    private final Chatter p2pChatter;
    private RucketJob<Entity> pushSourceJob;
    private b scopedRucket;
    private final z0<StrangerTagType> tagFlow;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0014\u001a\u0002H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/v1/viewmodel/ChatP2PReadableViewModel$P2PStrangerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "rucket", "Lcom/larksuite/rucket/Rucket;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/Chatter;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;Lcom/larksuite/rucket/Rucket;)V", "getInitChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChatter", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "getFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "getRucket", "()Lcom/larksuite/rucket/Rucket;", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class P2PStrangerViewModelFactory implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Chat f414484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Chatter f414485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g f414486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f414487d;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            return new ChatP2PReadableViewModel(this.f414484a, this.f414485b, this.f414486c, this.f414487d);
        }

        public P2PStrangerViewModelFactory(Chat r100, Chatter r101, g r102, b r103) {
            Intrinsics.checkNotNullParameter(r100, "initChat");
            Intrinsics.checkNotNullParameter(r102, "fgService");
            Intrinsics.checkNotNullParameter(r103, "rucket");
            this.f414484a = r100;
            this.f414485b = r101;
            this.f414486c = r102;
            this.f414487d = r103;
        }
    }

    public static final class a {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public static void a(MutableLiveData r100, int r101, MutableSharedFlow r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Integer r104 = (Integer) r100.getValue();
            if (r104 != null) goto L6;
        L8:
            Integer r105 = (Integer) r100.getValue();
            if (r105 != null) goto L12;
        L15:
            Integer r106 = (Integer) r100.getValue();
            if (r106 != null) goto L19;
        L23:
            if (r103 == false) goto L25;
            r100.setValue(Integer.valueOf(r101));
            return;
        L25:
            r100.postValue(Integer.valueOf(r101));
            return;
        L19:
            if (r106.intValue() != 2) goto L23;
            if (r101 != 1) goto L23;
            if (r102 == null) goto L23;
            r102.tryEmit(-1);
            goto L23
        L12:
            if (r105.intValue() != 1) goto L15;
            if (r101 == 1) goto L15;
            return;
        L6:
            if (r104.intValue() != r101) goto L8;
        }

        public static /* synthetic */ void b(a r100, MutableLiveData r101, int r102, boolean r103) {
            r100.getClass();
            a(r101, r102, null, r103);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$create$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$create$1", f = "ChatP2PReadableViewModel.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatP2PReadableViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$create$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C48401<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ChatP2PReadableViewModel f414488a;

            public C48401(ChatP2PReadableViewModel r100) {
                this.f414488a = r100;
            }

            public final Object a(Integer r100, Continuation<? super Unit> r101) {
                if ((r101 instanceof ChatP2PReadableViewModel$create$1$1$emit$1) == false) goto L7;
                ChatP2PReadableViewModel$create$1$1$emit$1 r102 = (ChatP2PReadableViewModel$create$1$1$emit$1) r101;
                int r103 = r102.label;
                if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
                r102.label = r103 - Integer.MIN_VALUE;
            L8:
                Object r104 = r102.result;
                Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r106 = r102.label;
                if (r106 == 0) goto L14;
                if (r106 != 1) goto L13;
                StrangerBannerType r107 = (StrangerBannerType) r102.L$0;
                ResultKt.throwOnFailure(r104);
            L22:
                if (r107 != StrangerBannerType.NONE) goto L25;
                this.f414488a.getCloseBannerActionFlow().tryEmit(Boxing.boxBoolean(true));
            L25:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r104);
                Log.i(ChatP2PReadableViewModel.TAG, "chat readable live data update, try emit chat readable flow " + r100);
                z0<Integer> r108 = this.f414488a.getChatReadableFlow();
                Intrinsics.checkNotNull(r100);
                r108.tryEmit(r100);
                this.f414488a.getChatChangeToReadable().tryEmit(r100);
                if (r100.intValue() != 2) goto L17;
                r107 = StrangerBannerType.STRANGER;
            L18:
                z0<StrangerBannerType> r109 = this.f414488a.getBannerFlow();
                r102.L$0 = r107;
                r102.label = 1;
                if (r109.emit(r107, r102) != r105) goto L22;
                return r105;
            L17:
                r107 = StrangerBannerType.NONE;
            L7:
                r102 = new ChatP2PReadableViewModel$create$1$1$emit$1(this, r101);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
                return a((Integer) r100, r101);
            }
        }

        public AnonymousClass1(ChatP2PReadableViewModel r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Flow r103 = FlowLiveDataConversions.asFlow(ChatP2PReadableViewModel.access$getChatReadableLiveData$p(this.this$0));
            C48401 r104 = new C48401(this.this$0);
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$setupInitData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$setupInitData$1", f = "ChatP2PReadableViewModel.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    public static final class C117571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Chat $chat;
        int label;
        final /* synthetic */ ChatP2PReadableViewModel this$0;

        public C117571(ChatP2PReadableViewModel r100, Chat r101, Continuation<? super C117571> r102) {
            this.this$0 = r100;
            this.$chat = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C117571(this.this$0, this.$chat, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C117571) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            com.larksuite.rucket.job.base.b r103 = (com.larksuite.rucket.job.base.b) r100;
            if ((r103 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L19;
            Boolean r104 = ((GetP2PChatUnfamiliarStrategyResponse) ((com.larksuite.rucket.job.base.b.c) r103).f286079b).hit_strategy;
            AtomicBoolean r105 = ChatP2PReadableViewModel.access$isInWhiteList$p(this.this$0);
            Intrinsics.checkNotNull(r104);
            r105.set(r104.booleanValue());
            if (r104.booleanValue() == true) goto L17;
            a.b(ChatP2PReadableViewModel.Companion, ChatP2PReadableViewModel.access$getChatReadableLiveData$p(this.this$0), 1, false);
            return Unit.INSTANCE;
        L17:
            a r106 = ChatP2PReadableViewModel.Companion;
            MutableLiveData r107 = ChatP2PReadableViewModel.access$getChatReadableLiveData$p(this.this$0);
            ChatReadable.a r108 = ChatReadable.Companion;
            Chat r109 = this.$chat;
            r108.getClass();
            a.b(r106, r107, ChatReadable.a.a(r109), false);
        L27:
            return Unit.INSTANCE;
        L19:
            if ((r103 instanceof com.larksuite.rucket.job.base.b.C3939b) == false) goto L29;
            ErrorResult r110 = ((com.larksuite.rucket.job.base.b.C3939b) r103).a();
            if (r110 == null) goto L24;
            String r111 = r110.getMessage();
            if (r111 == null) goto L24;
        L25:
            Log.e(ChatP2PReadableViewModel.TAG, "fetch chat p2p white list failed ".concat(r111));
            a.b(ChatP2PReadableViewModel.Companion, ChatP2PReadableViewModel.access$getChatReadableLiveData$p(this.this$0), 1, false);
        L24:
            r111 = "unknown";
            goto L25
        L29:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            GetP2PChatUnfamiliarStrategyRequest r112 = new GetP2PChatUnfamiliarStrategyRequest.Builder().strategy(GetP2PChatUnfamiliarStrategyRequest.SyncStrategy.TRY_LOCAL).build();
            com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a r113 = (com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a) this.this$0.getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a.class);
            Intrinsics.checkNotNull(r112);
            RucketJob<GetP2PChatUnfamiliarStrategyResponse> r114 = r113.getP2PChatUnFamiliarStrategy(r112);
            this.label = 1;
            r100 = r114.awaitGet(this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$setupPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.ChatP2PReadableViewModel$setupPush$1", f = "ChatP2PReadableViewModel.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    public static final class C117581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ChatP2PReadableViewModel this$0;

        public C117581(ChatP2PReadableViewModel r100, Continuation<? super C117581> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C117581(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C117581) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0057 -> B:16:0x005c). Please report as a decompilation issue!!! */
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
            C117581 r106 = this;
        L17:
            if (((Boolean) r100).booleanValue() == false) goto L26;
            com.larksuite.rucket.job.base.b r107 = r104.a();
            Map<String, Chat> r108 = h.d(((Entity) r107.b()).chats, null, ((Entity) r107.b()).mail_setting);
            HashMap r109 = (HashMap) r108;
            Chat r110 = (Chat) r109.get(ChatP2PReadableViewModel.access$getInitChat$p(r106.this$0).getId());
            if (r110 != null) goto L22;
        L24:
            C117581 r111 = r106;
            r101 = r105;
            com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<Entity>> r112 = r104;
        L12:
            r111.L$0 = r112;
            r111.label = 1;
            Object r113 = r112.hasNext(r111);
            if (r113 != r101) goto L15;
            return r101;
        L15:
            Object r114 = r101;
            r106 = r111;
            r100 = r113;
            r104 = r112;
            r105 = r114;
            goto L17
        L22:
            if (ChatP2PReadableViewModel.access$isInWhiteList$p(r106.this$0).get() == false) goto L24;
            a r115 = ChatP2PReadableViewModel.Companion;
            MutableLiveData r116 = ChatP2PReadableViewModel.access$getChatReadableLiveData$p(r106.this$0);
            ChatReadable.Companion.getClass();
            int r117 = ChatReadable.a.a(r110);
            MutableSharedFlow<Integer> r118 = r106.this$0.getChatChangeToReadable();
            r115.getClass();
            a.a(r116, r117, r118, false);
            goto L24
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            RucketJob<Entity> r119 = ((com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a) this.this$0.getScopedRucket().create(com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v1.viewmodel.a.class)).chatsPush();
            if (ChatP2PReadableViewModel.access$getFgService$p(this.this$0).isEnable("im.chat.memory.disable_push_cancel") == true) goto L11;
            ChatP2PReadableViewModel.access$setPushSourceJob$p(this.this$0, r119);
        L11:
            r112 = r119.iterator();
            r111 = this;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    private final void setupPush() {
        BuildersKt.launch$default(this, null, null, new C117581(this, null), 3, null);
    }

    @JvmStatic
    public static final void updateChatReadableValue(MutableLiveData<Integer> r100, int r101, MutableSharedFlow<Integer> r102, boolean r103) {
        Companion.getClass();
        a.a(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.replyinthread.pages.base.SubViewModel
    public void destroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        RucketJob<Entity> r100 = this.pushSourceJob;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.pushSourceJob = null;
    }

    private final void setupInitData() {
        Chat r100 = this.initChat;
        if (r100.isP2PChat() == true) goto L5;
    L29:
        a.b(Companion, this.chatReadableLiveData, 1, true);
        return;
    L5:
        if (r100.isSecret() == true) goto L29;
        if (r100.isAIChat() == true) goto L29;
        Chatter r101 = this.p2pChatter;
        boolean r102 = false;
        if (r101 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L29;
        if (r100.isP2PChat() == false) goto L24;
        Chatter r104 = this.p2pChatter;
        if (r104 == null) goto L21;
        boolean r105 = r104.isBot();
    L22:
        if (r105 == false) goto L24;
        r102 = true;
        goto L24
    L21:
        r105 = false;
    L24:
        if (r102 == false) goto L27;
        a.b(Companion, this.chatReadableLiveData, 1, true);
        return;
    L27:
        BuildersKt.launch$default(this, Dispatchers.getIO(), null, new C117571(this, r100, null), 2, null);
        return;
    L11:
        if (r101.isDimission() != true) goto L13;
        r103 = true;
        goto L14
    }

    @Override // com.ss.android.lark.replyinthread.pages.base.SubViewModel
    public void create() {
        g r100 = this.fgService;
        int r101 = l4b.a.f507356a;
        Intrinsics.checkNotNullParameter(r100, "fgService");
        if (r100.isEnable("im.message.stranger") == false) goto L5;
        boolean r102 = false;
    L6:
        if (r102 == true) goto L9;
        return;
    L9:
        if (this.fgService.isEnable("im.chat.readable_update") == false) goto L11;
        MainCoroutineDispatcher r103 = Dispatchers.getMain();
    L12:
        BuildersKt.launch$default(this, r103, null, new AnonymousClass1(this, null), 2, null);
        setupInitData();
        setupPush();
        return;
    L11:
        r103 = Dispatchers.getMain().getImmediate();
        goto L12
    L5:
        r102 = r100.isEnable("im.message.strangerchat");
        goto L6
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        RucketJob<Entity> r100 = this.pushSourceJob;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.pushSourceJob = null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public z0<StrangerBannerType> getBannerFlow() {
        return this.bannerFlow;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public MutableSharedFlow<Integer> getChatChangeToReadable() {
        return this.chatChangeToReadable;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public z0<Integer> getChatReadableFlow() {
        return this.chatReadableFlow;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public MutableSharedFlow<Boolean> getCloseBannerActionFlow() {
        return this.closeBannerActionFlow;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // c38.c
    public b getScopedRucket() {
        return this.scopedRucket;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel
    public z0<StrangerTagType> getTagFlow() {
        return this.tagFlow;
    }

    public static final /* synthetic */ MutableLiveData access$getChatReadableLiveData$p(ChatP2PReadableViewModel r100) {
        return r100.chatReadableLiveData;
    }

    public static final /* synthetic */ g access$getFgService$p(ChatP2PReadableViewModel r100) {
        return r100.fgService;
    }

    public static final /* synthetic */ Chat access$getInitChat$p(ChatP2PReadableViewModel r100) {
        return r100.initChat;
    }

    public static final /* synthetic */ AtomicBoolean access$isInWhiteList$p(ChatP2PReadableViewModel r100) {
        return r100.isInWhiteList;
    }

    public void setScopedRucket(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scopedRucket = r100;
    }

    public static final /* synthetic */ void access$setPushSourceJob$p(ChatP2PReadableViewModel r100, RucketJob r101) {
        r100.pushSourceJob = r101;
    }

    public ChatP2PReadableViewModel(Chat r100, Chatter r101, g r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "initChat");
        Intrinsics.checkNotNullParameter(r102, "fgService");
        Intrinsics.checkNotNullParameter(r103, "rucket");
        this.initChat = r100;
        this.p2pChatter = r101;
        this.fgService = r102;
        this.chatReadableFlow = j1.a(0);
        this.chatChangeToReadable = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.bannerFlow = j1.a(StrangerBannerType.UNKNOWN);
        this.tagFlow = j1.a(StrangerTagType.NONE);
        this.closeBannerActionFlow = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.chatReadableLiveData = new MutableLiveData();
        this.isInWhiteList = new AtomicBoolean(false);
        this.coroutineContext = Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null));
        this.scopedRucket = r103;
    }
}
