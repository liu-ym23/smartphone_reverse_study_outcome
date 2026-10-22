package com.larus.commercemembership.impl.component;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.commercemembership.impl.h;
import com.larus.commercemembership.impl.k;
import com.larus.platform.api.d3;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u000f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/commercemembership/impl/component/ChatCommerceMembershipLogicComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "mainHandler", "Landroid/os/Handler;", "tryShowPcGuideRunnable", "Ljava/lang/Runnable;", "conversationChangeListener", "com/larus/commercemembership/impl/component/ChatCommerceMembershipLogicComponent$conversationChangeListener$1", "Lcom/larus/commercemembership/impl/component/ChatCommerceMembershipLogicComponent$conversationChangeListener$1;", "notificationSlotIdleListener", "Lcom/larus/platform/model/OnInnerNotificationSlotIdleListener;", WidgetCostModule.TYPE_ON_CREATE, "", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "scheduleTryShowPendingPcGuideInAppPush", "source", "", "tryShowPendingPcGuideInAppPush", "isMainBotPageForeground", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatCommerceMembershipLogicComponent extends ComponentFeature {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f325847m = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f325848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f325849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.commercemembership.impl.component.c f325850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f325851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f325852l;

    public static final class a {
    }

    public static final class b implements y.a<wc9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatCommerceMembershipLogicComponent f325853a;

        public b(ChatCommerceMembershipLogicComponent r100) {
            this.f325853a = r100;
        }

        @Override // com.larus.bmhome.chat.component.cvs.y.a
        public final void c(wc9.e r100) {
            Intrinsics.checkNotNullParameter(r100, "new");
            ChatCommerceMembershipLogicComponent r101 = this.f325853a;
            int r102 = ChatCommerceMembershipLogicComponent.f325847m;
            r101.F2("conversationChanged");
        }
    }

    public static final class c implements Function0<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f325854a;

        public c(AttachReceiver r100) {
            this.f325854a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.cvs.y, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final y invoke() {
            AttachReceiver r100 = this.f325854a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    /* JADX INFO: renamed from: com.larus.commercemembership.impl.component.ChatCommerceMembershipLogicComponent$onCreate$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes26.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercemembership.impl.component.ChatCommerceMembershipLogicComponent$onCreate$2", f = "ChatCommerceMembershipLogicComponent.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatCommerceMembershipLogicComponent this$0;

        /* JADX INFO: renamed from: com.larus.commercemembership.impl.component.ChatCommerceMembershipLogicComponent$onCreate$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", AiBotPollingAuthResult.STATUS_PENDING, "Lcom/larus/commercemembership/impl/PendingPcGuidePushBanner;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.commercemembership.impl.component.ChatCommerceMembershipLogicComponent$onCreate$2$1", f = "ChatCommerceMembershipLogicComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<k, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatCommerceMembershipLogicComponent this$0;

            public AnonymousClass1(ChatCommerceMembershipLogicComponent r100, Continuation<? super AnonymousClass1> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
                r102.L$0 = r100;
                return r102;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(k r100, Continuation<? super Unit> r101) {
                return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(k r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r100);
                if (((k) this.L$0) == null) goto L8;
                ChatCommerceMembershipLogicComponent r101 = this.this$0;
                int r102 = ChatCommerceMembershipLogicComponent.f325847m;
                r101.F2("pendingBanner");
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(ChatCommerceMembershipLogicComponent r100, Continuation<? super AnonymousClass2> r101) {
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
            b1 r103 = h.f325868f;
            AnonymousClass1 r104 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r103, r104, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        d3.f365092a.b(this.f325852l);
        y r100 = (y) this.f325848h.getValue();
        if (r100 == null) goto L5;
        r100.rh(new e(), this.f325851k);
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(this, null), 2, null);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f325849i.removeCallbacks(this.f325850j);
        d3.f365092a.a(this.f325852l);
        y r100 = (y) this.f325848h.getValue();
        if (r100 == null) goto L6;
        r100.lQ(this.f325851k);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        FLogger.f375446a.d("ChatCommerceMembershipComponent", "onResume triggerZlinkClipboardCheck");
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r100 = ICommerceMembershipService.a.a();
        if (r100 == null) goto L5;
        r100.f("", "ChatCommerceMembershipComponent_onResume");
    L5:
        F2("onResume");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.commercemembership.impl.component.c] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.commercemembership.impl.component.d] */
    public ChatCommerceMembershipLogicComponent() {
        this.f325848h = LazyKt.lazy(new c(this));
        this.f325849i = new Handler(Looper.getMainLooper());
        this.f325850j = new com.larus.commercemembership.impl.component.c(this);
        this.f325851k = new b(this);
        this.f325852l = new d(this);
    }

    public final void F2(String r100) {
        FLogger.f375446a.i("ChatCommerceMembershipComponent", "schedule try show pc guide push, source=".concat(r100));
        this.f325849i.removeCallbacks(this.f325850j);
        this.f325849i.postDelayed(this.f325850j, 200);
    }
}
