package com.ss.android.lark.contact.base.contact_myqrcode;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.bytedance.lark.pb.settings.v1.PushWayToAddMeSetting;
import com.bytedance.lark.pb.settings.v1.WayToAddMeSetting;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;
import com.ss.android.lark.contact.base.service.d;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.g;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderLine;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001e2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/contact/base/contact_myqrcode/InviteExternalViewModelV2;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_loadState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/contact/base/contact_myqrcode/InviteExternalLoadState;", "loadState", "Landroidx/lifecycle/LiveData;", "getLoadState", "()Landroidx/lifecycle/LiveData;", "_invitationInfoGroup", "Lcom/ss/android/lark/contact/base/entity/bean/InvitationInfoGroup;", "invitationInfoGroup", "getInvitationInfoGroup", "_canAddWithToken", "", "canAddWithToken", "getCanAddWithToken", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "isLocalSuccess", "onCleared", "", "fetchInvitationInfo", "from", "realFetchInvitationInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchInvitationInfoRequest", "Lcom/ss/android/lark/contact/base/contact_myqrcode/Response;", RenderLine.STRATEGY_SERVER, "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateData", "result", "(Lcom/ss/android/lark/contact/base/contact_myqrcode/Response;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerPush", "unregisterPush", "Companion", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteExternalViewModelV2 extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "InviteExternalViewModelV2";
    private final MutableLiveData<Boolean> _canAddWithToken;
    private final MutableLiveData<z8b.a> _invitationInfoGroup;
    private final MutableLiveData<com.ss.android.lark.contact.base.contact_myqrcode.a> _loadState;
    private final LiveData<Boolean> canAddWithToken;
    private final Channel<String> channel;
    private final LiveData<z8b.a> invitationInfoGroup;
    private volatile boolean isLocalSuccess;
    private final LiveData<com.ss.android.lark.contact.base.contact_myqrcode.a> loadState;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$1", f = "InviteExternalViewModelV2.kt", i = {}, l = {49, 50}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        public AnonymousClass1(InviteExternalViewModelV2 r100, Continuation<? super AnonymousClass1> r101) {
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

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0060 -> B:12:0x0036). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ChannelIterator r103 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r100);
            ChannelIterator r104 = r103;
        L11:
            AnonymousClass1 r105 = this;
        L12:
            r105.L$0 = r104;
            r105.label = 1;
            Object r106 = r104.hasNext(r105);
            if (r106 != r101) goto L15;
            return r101;
        L15:
            AnonymousClass1 r107 = r105;
            ChannelIterator r108 = r104;
            r100 = r106;
            AnonymousClass1 r109 = r107;
        L17:
            if (((Boolean) r100).booleanValue() == false) goto L23;
            String r110 = (String) r108.next();
            InviteExternalViewModelV2 r111 = r109.this$0;
            r109.L$0 = r108;
            r109.label = 2;
            if (InviteExternalViewModelV2.access$realFetchInvitationInfo(r111, r110, r109) != r101) goto L21;
            return r101;
        L21:
            r104 = r108;
            r105 = r109;
            goto L12
        L23:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r108 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r100);
            r109 = this;
            goto L17
        L10:
            ResultKt.throwOnFailure(r100);
            r104 = InviteExternalViewModelV2.access$getChannel$p(this.this$0).iterator();
            goto L11
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InviteExternalViewModelV2 f418703a;

        public b(InviteExternalViewModelV2 r100) {
            this.f418703a = r100;
        }

        @Override // com.ss.android.lark.sdk.g.b
        public final void a(byte[] r110) {
            WayToAddMeSetting r111 = PushWayToAddMeSetting.ADAPTER.decode(r110).add_me_setting;     // Catch: IOException -> L9
            if (r111 == null) goto L6;
            Boolean r112 = r111.contact_token_setting;     // Catch: IOException -> L9
        L7:
            Log.i(InviteExternalViewModelV2.TAG, "on PUSH_WAY_TO_ADD_ME_SETTING, contactTokenSetting: " + r112);     // Catch: IOException -> L9
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.f418703a), null, null, new InviteExternalViewModelV2$registerPush$1$1(this.f418703a, r112, null), 3, null);     // Catch: IOException -> L9
            return;
        L6:
            r112 = null;
        L9:
            e = move-exception;
            Log.e(InviteExternalViewModelV2.TAG, "PUSH_WAY_TO_ADD_ME_SETTING error", e);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$fetchInvitationInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$fetchInvitationInfo$1", f = "InviteExternalViewModelV2.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class C118191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $from;
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        public C118191(InviteExternalViewModelV2 r100, String r101, Continuation<? super C118191> r102) {
            this.this$0 = r100;
            this.$from = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C118191(this.this$0, this.$from, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C118191) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            Channel r103 = InviteExternalViewModelV2.access$getChannel$p(this.this$0);
            String r104 = this.$from;
            this.label = 1;
            if (r103.send(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$realFetchInvitationInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2", f = "InviteExternalViewModelV2.kt", i = {0, 1, 2, 3, 4}, l = {75, 79, 80, 82, 83}, m = "realFetchInvitationInfo", n = {"from", "from", "from", "from", "from"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"})
    public static final class C118201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        public C118201(InviteExternalViewModelV2 r100, Continuation<? super C118201> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return InviteExternalViewModelV2.access$realFetchInvitationInfo(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$realFetchInvitationInfo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$realFetchInvitationInfo$2", f = "InviteExternalViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        public AnonymousClass2(InviteExternalViewModelV2 r100, Continuation<? super AnonymousClass2> r101) {
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            InviteExternalViewModelV2.access$get_loadState$p(this.this$0).setValue(com.ss.android.lark.contact.base.contact_myqrcode.a.b.f418704a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$updateData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$updateData$2", f = "InviteExternalViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C118212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.ss.android.lark.contact.base.contact_myqrcode.b<z8b.a> $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C118212(InviteExternalViewModelV2 r100, com.ss.android.lark.contact.base.contact_myqrcode.b<? extends z8b.a> r101, Continuation<? super C118212> r102) {
            this.this$0 = r100;
            this.$result = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C118212 r102 = new C118212(this.this$0, this.$result, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C118212) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r100);
            if (CoroutineScopeKt.isActive((CoroutineScope) this.L$0) == false) goto L7;
            InviteExternalViewModelV2.access$get_loadState$p(this.this$0).setValue(com.ss.android.lark.contact.base.contact_myqrcode.a.c.f418705a);
            InviteExternalViewModelV2.access$get_invitationInfoGroup$p(this.this$0).setValue(((com.ss.android.lark.contact.base.contact_myqrcode.b.C4926b) this.$result).f418707a);
            MutableLiveData r101 = InviteExternalViewModelV2.access$get_canAddWithToken$p(this.this$0);
            z8b.a r102 = (z8b.a) ((com.ss.android.lark.contact.base.contact_myqrcode.b.C4926b) this.$result).f418707a;
            r102.getClass();
            if (TextUtils.equals("qr_code", "qr_code") == false) goto L11;
            InvitationInfo r103 = r102.f570972a;
        L12:
            if (r103 == null) goto L14;
            Boolean r104 = Boxing.boxBoolean(r103.canSearchWithToken);
        L15:
            r101.setValue(r104);
            return Unit.INSTANCE;
        L14:
            r104 = Boxing.boxBoolean(true);
            goto L15
        L11:
            r103 = r102.f570973b;
            goto L12
        L7:
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$updateData$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$updateData$3", f = "InviteExternalViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.ss.android.lark.contact.base.contact_myqrcode.b<z8b.a> $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(InviteExternalViewModelV2 r100, com.ss.android.lark.contact.base.contact_myqrcode.b<? extends z8b.a> r101, Continuation<? super AnonymousClass3> r102) {
            this.this$0 = r100;
            this.$result = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass3 r102 = new AnonymousClass3(this.this$0, this.$result, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r100);
            if (CoroutineScopeKt.isActive((CoroutineScope) this.L$0) == false) goto L7;
            MutableLiveData r101 = InviteExternalViewModelV2.access$get_loadState$p(this.this$0);
            String r102 = ((com.ss.android.lark.contact.base.contact_myqrcode.b.a) this.$result).f418706a.getDisplayMsg();
            if (r102 != null) goto L11;
            r102 = "";
        L11:
            r101.setValue(new com.ss.android.lark.contact.base.contact_myqrcode.a.C4925a(r102));
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    private final void registerPush() {
        g.e.f439875a.b(Command.PUSH_WAY_TO_ADD_ME_SETTING, new b(this));
    }

    private final void unregisterPush() {
        g.e.f439875a.c(Command.PUSH_WAY_TO_ADD_ME_SETTING);
    }

    public InviteExternalViewModelV2() {
        MutableLiveData<com.ss.android.lark.contact.base.contact_myqrcode.a> r100 = new MutableLiveData(com.ss.android.lark.contact.base.contact_myqrcode.a.b.f418704a);
        this._loadState = r100;
        this.loadState = r100;
        MutableLiveData<z8b.a> r101 = new MutableLiveData();
        this._invitationInfoGroup = r101;
        this.invitationInfoGroup = r101;
        MutableLiveData<Boolean> r102 = new MutableLiveData();
        this._canAddWithToken = r102;
        this.canAddWithToken = r102;
        this.channel = ChannelKt.Channel$default(0, null, null, 6, null);
        registerPush();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        unregisterPush();
    }

    public final LiveData<Boolean> getCanAddWithToken() {
        return this.canAddWithToken;
    }

    public final LiveData<z8b.a> getInvitationInfoGroup() {
        return this.invitationInfoGroup;
    }

    public final LiveData<com.ss.android.lark.contact.base.contact_myqrcode.a> getLoadState() {
        return this.loadState;
    }

    public static final /* synthetic */ Channel access$getChannel$p(InviteExternalViewModelV2 r100) {
        return r100.channel;
    }

    public static final /* synthetic */ MutableLiveData access$get_canAddWithToken$p(InviteExternalViewModelV2 r100) {
        return r100._canAddWithToken;
    }

    public static final /* synthetic */ MutableLiveData access$get_invitationInfoGroup$p(InviteExternalViewModelV2 r100) {
        return r100._invitationInfoGroup;
    }

    public static final /* synthetic */ MutableLiveData access$get_loadState$p(InviteExternalViewModelV2 r100) {
        return r100._loadState;
    }

    public final void fetchInvitationInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Log.i(TAG, "[" + r100 + "]fetchInvitationInfo");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C118191(this, r100, null), 3, null);
    }

    private final Object realFetchInvitationInfo(String r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof C118201) == false) goto L7;
        C118201 r100 = (C118201) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L19;
        if (r103 == 4) goto L18;
        if (r103 != 5) goto L17;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L41:
        Log.i(TAG, "[" + r110 + "]realFetchInvitationInfo finish");
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L38:
        r100.L$0 = r110;
        r100.label = 5;
        if (updateData((com.ss.android.lark.contact.base.contact_myqrcode.b) r112, true, r100) != r102) goto L41;
        return r102;
    L19:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L35:
        r100.L$0 = r110;
        r100.label = 4;
        r112 = fetchInvitationInfoRequest(r110, true, r100);
        if (r112 != r102) goto L38;
        return r102;
    L20:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L32:
        r100.L$0 = r110;
        r100.label = 3;
        if (updateData((com.ss.android.lark.contact.base.contact_myqrcode.b) r112, false, r100) != r102) goto L35;
        return r102;
    L21:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L29:
        r100.L$0 = r110;
        r100.label = 2;
        r112 = fetchInvitationInfoRequest(r110, false, r100);
        if (r112 != r102) goto L32;
        return r102;
    L22:
        ResultKt.throwOnFailure(r112);
        Log.i(TAG, "[" + r110 + "]realFetchInvitationInfo start");
        if (Intrinsics.areEqual(this._loadState.getValue(), com.ss.android.lark.contact.base.contact_myqrcode.a.c.f418705a) == false) goto L26;
        Log.i(TAG, "[" + r110 + "]realFetchInvitationInfo cancel cause has success");
        return Unit.INSTANCE;
    L26:
        MainCoroutineDispatcher r113 = Dispatchers.getMain();
        AnonymousClass2 r104 = new AnonymousClass2(this, null);
        r100.L$0 = r110;
        r100.label = 1;
        if (BuildersKt.withContext(r113, r104, r100) != r102) goto L29;
        return r102;
    L7:
        r100 = new C118201(this, r111);
        goto L8
    }

    public static final /* synthetic */ Object access$realFetchInvitationInfo(InviteExternalViewModelV2 r100, String r101, Continuation r102) {
        return r100.realFetchInvitationInfo(r101, r102);
    }

    private final Object fetchInvitationInfoRequest(final String r100, final boolean r101, Continuation<? super com.ss.android.lark.contact.base.contact_myqrcode.b<? extends z8b.a>> r102) {
        final j r103 = new j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        Log.i(TAG, "[" + r100 + "]fetchInvitationInfoRequest start, fromServer: " + r101);
        IGetDataCallback<GetContactTokenResponse> r104 = new InviteExternalViewModelV2$fetchInvitationInfoRequest$2$callback$1(r100, r101, r103);
        if (r101 == false) goto L5;
        d.b(r104);
    L6:
        Object r105 = r103.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L9:
        return r105;
    L5:
        d.a(r104);
        goto L6
    }

    private final Object updateData(com.ss.android.lark.contact.base.contact_myqrcode.b<? extends z8b.a> r100, boolean r101, Continuation<? super Unit> r102) {
        if (r101 == true) goto L5;
        this.isLocalSuccess = r100 instanceof com.ss.android.lark.contact.base.contact_myqrcode.b.C4926b;
    L5:
        if ((r100 instanceof com.ss.android.lark.contact.base.contact_myqrcode.b.C4926b) == false) goto L12;
        Object r103 = BuildersKt.withContext(Dispatchers.getMain(), new C118212(this, r100, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r103;
    L10:
        return Unit.INSTANCE;
    L12:
        if ((r100 instanceof com.ss.android.lark.contact.base.contact_myqrcode.b.a) == false) goto L22;
        if (r101 == false) goto L22;
        if (this.isLocalSuccess == true) goto L22;
        Object r104 = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this, r100, null), r102);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r104;
    L20:
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$fetchInvitationInfoRequest(InviteExternalViewModelV2 r100, String r101, boolean r102, Continuation r103) {
        return r100.fetchInvitationInfoRequest(r101, r102, r103);
    }

    public static final /* synthetic */ Object access$updateData(InviteExternalViewModelV2 r100, com.ss.android.lark.contact.base.contact_myqrcode.b r101, boolean r102, Continuation r103) {
        return r100.updateData(r101, r102, r103);
    }
}
