package com.bytedance.android.livesdk.livecommerce.userinfo.title;

import bk2.b;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.ec.live.api.commerce.userinfo.ECAuthorArea;
import com.bytedance.android.ec.live.api.commerce.userinfo.e;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.state.ECUserInfoState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u001f\u0012\u0006\u0010)\u001a\u00020\u0012\u0012\u0006\u0010-\u001a\u00020\u0012\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b1\u00102J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0010H\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0005H\u0007R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0017\u0010)\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010*R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/ECUserInfoViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState;", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;", "userInfo", "", "onUserInfoChanged", "", "isFollow", "onFollowStateChanged", "(Ljava/lang/Boolean;)V", "updateBackground", "Lml2/a$a;", "event", "onClickUserInfo", "updateLogStatus", "Lml2/a$b;", "onFollowAnimSuccess", "", "btmPageId", "Lll2/a;", "getUserInfoParams", "eventName", "Lorg/json/JSONObject;", "eventParams", "onWidgetEvent", "onDestroy", "Lbk2/b;", "disposableContext", "Lbk2/b;", "Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/repository/ECUserInfoRepository;", "repository", "Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/repository/ECUserInfoRepository;", "Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/utils/a;", "eventHelper", "Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/utils/a;", "getEventHelper", "()Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/utils/a;", "roomVisible", "Z", "liveRoomParamsReady", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "roomUniqueKey", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/e;", "ability", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/e;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/live/api/commerce/userinfo/e;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUserInfoViewModel extends QStateViewModel<ECUserInfoState> {
    public static final a Companion = null;
    private static final String TAG = "ECUserInfoViewModel";
    private final e ability;
    private final b disposableContext;
    private final com.bytedance.android.livesdk.livecommerce.userinfo.title.utils.a eventHelper;
    private boolean liveRoomParamsReady;
    private final ECUserInfoRepository repository;
    private final String roomId;
    private final String roomUniqueKey;
    private boolean roomVisible;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.ECUserInfoViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;", "p1", "", "invoke", "(Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.ec.live.api.commerce.userinfo.b, Unit> {
        public AnonymousClass1(ECUserInfoViewModel r8) {
            super(1, r8, ECUserInfoViewModel.class, "onUserInfoChanged", "onUserInfoChanged(Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECUserInfo;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.ec.live.api.commerce.userinfo.b) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(com.bytedance.android.ec.live.api.commerce.userinfo.b r2) {
            ECUserInfoViewModel.access$onUserInfoChanged((ECUserInfoViewModel) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.ECUserInfoViewModel$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(ECUserInfoViewModel r8) {
            super(1, r8, ECUserInfoViewModel.class, "onFollowStateChanged", "onFollowStateChanged(Ljava/lang/Boolean;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Boolean) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(Boolean r2) {
            ECUserInfoViewModel.access$onFollowStateChanged((ECUserInfoViewModel) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.ECUserInfoViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lml2/a$a;", "p1", "", "invoke", "(Lml2/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ml2.a.C0155a, Unit> {
        public AnonymousClass3(ECUserInfoViewModel r8) {
            super(1, r8, ECUserInfoViewModel.class, "onClickUserInfo", "onClickUserInfo(Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoEvent$ClickUserInfo;)V", 0);
        }

        public final void invoke(ml2.a.C0155a r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECUserInfoViewModel.access$onClickUserInfo((ECUserInfoViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((ml2.a.C0155a) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.ECUserInfoViewModel$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lml2/a$b;", "p1", "", "invoke", "(Lml2/a$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<ml2.a.b, Unit> {
        public AnonymousClass4(ECUserInfoViewModel r8) {
            super(1, r8, ECUserInfoViewModel.class, "onFollowAnimSuccess", "onFollowAnimSuccess(Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoEvent$FollowAnimSuccess;)V", 0);
        }

        public final void invoke(ml2.a.b r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ECUserInfoViewModel.access$onFollowAnimSuccess((ECUserInfoViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((ml2.a.b) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.ECUserInfoViewModel$5, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.userinfo.title.ECUserInfoViewModel$5", f = "ECUserInfoViewModel.kt", i = {}, l = {h1.TYPE_UPDATE_WAITING_USER_OFFSET}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ECUserInfoViewModel this$0;

        public AnonymousClass5(ECUserInfoViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass5(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            boolean r5 = ((Boolean) r4).booleanValue();
            if (r5 == false) goto L14;
            ECUserInfoViewModel.access$setLiveRoomParamsReady$p(this.this$0, true);
            ECUserInfoViewModel.access$updateLogStatus(this.this$0);
        L14:
            dm.a.a(ECUserInfoViewModel.TAG).i("liveRoomParamsReady = " + r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ECUserInfoRepository r6 = ECUserInfoViewModel.access$getRepository$p(this.this$0);
            this.label = 1;
            r4 = r6.d(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.ECUserInfoViewModel$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;", "p1", "", "invoke", "(Lcom/bytedance/android/ec/live/api/commerce/userinfo/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class C03381 extends FunctionReferenceImpl implements Function1<com.bytedance.android.ec.live.api.commerce.userinfo.b, Unit> {
        public C03381(ECUserInfoViewModel r8) {
            super(1, r8, ECUserInfoViewModel.class, "onUserInfoChanged", "onUserInfoChanged(Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECUserInfo;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.ec.live.api.commerce.userinfo.b) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(com.bytedance.android.ec.live.api.commerce.userinfo.b r2) {
            ECUserInfoViewModel.access$onUserInfoChanged((ECUserInfoViewModel) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.ECUserInfoViewModel$onDestroy$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class C03392 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public C03392(ECUserInfoViewModel r8) {
            super(1, r8, ECUserInfoViewModel.class, "onFollowStateChanged", "onFollowStateChanged(Ljava/lang/Boolean;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Boolean) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(Boolean r2) {
            ECUserInfoViewModel.access$onFollowStateChanged((ECUserInfoViewModel) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.ECUserInfoViewModel$updateBackground$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class C03431 extends Lambda implements Function1<ECUserInfoState, ECUserInfoState> {
        final /* synthetic */ Integer $backgroundColor;

        public C03431(Integer r1) {
            this.$backgroundColor = r1;
            super(1);
        }

        public final ECUserInfoState invoke(ECUserInfoState r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            ECUserInfoState.c r0 = r10.c;
            Integer r1 = this.$backgroundColor;
            r0.getClass();
            return ECUserInfoState.a(r10, null, null, new ECUserInfoState.c(r1), null, null, false, 59);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((ECUserInfoState) r1);
        }
    }

    static {
        Companion = new a();
    }

    private final void updateLogStatus() {
        if (this.roomVisible == false) goto L6;
        boolean r0 = this.liveRoomParamsReady;
    L6:
        throw null;
    }

    public final void onDestroy() {
        dm.a.a(TAG).i("onDestroy");
        onCleared();
        if (this.roomVisible == false) goto L5;
        throw null;
    L5:
        throw null;
    }

    public final com.bytedance.android.livesdk.livecommerce.userinfo.title.utils.a getEventHelper() {
        return this.eventHelper;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public static final /* synthetic */ e access$getAbility$p(ECUserInfoViewModel r0) {
        r0.getClass();
        return null;
    }

    public static final /* synthetic */ boolean access$getLiveRoomParamsReady$p(ECUserInfoViewModel r0) {
        return r0.liveRoomParamsReady;
    }

    public static final /* synthetic */ ECUserInfoRepository access$getRepository$p(ECUserInfoViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ void access$updateLogStatus(ECUserInfoViewModel r0) {
        r0.updateLogStatus();
    }

    private final void onClickUserInfo(ml2.a.C0155a r3) {
        dm.a.b r0 = dm.a.a(TAG);
        r3.getClass();
        r0.a("onClickUserInfo btmPageId: null");
        ECAuthorArea r1 = (ECAuthorArea) getUserInfoParams(null).a.invoke();
        throw null;
    }

    private final void onFollowAnimSuccess(ml2.a.b r1) {
        setState(C03401.INSTANCE);
    }

    private final void onFollowStateChanged(Boolean r5) {
        dm.a.b r0 = dm.a.a(TAG);
        StringBuilder r1 = new StringBuilder("onFollowStateChanged isFollow: ");
        Boolean r2 = Boolean.TRUE;
        r1.append(Intrinsics.areEqual(r5, r2));
        r0.a(r1.toString());
        updateBackground(Intrinsics.areEqual(r5, r2));
    }

    private final void onUserInfoChanged(com.bytedance.android.ec.live.api.commerce.userinfo.b r3) {
        final ECAuthorArea r0 = null;
        if (r3 != null) goto L6;
        dm.a.a(TAG).w("onUserInfoChanged authorArea is null", null);
        setState(new C03411(r0));
        this.repository.getClass();
        throw null;
    L6:
        throw null;
    }

    private final void updateBackground(boolean r1) {
        this.repository.getClass();
        throw null;
    }

    public final ll2.a getUserInfoParams(String r2) {
        Intrinsics.checkNotNullParameter(r2, "btmPageId");
        return this.repository.c(r2);
    }

    public static final /* synthetic */ void access$onClickUserInfo(ECUserInfoViewModel r0, ml2.a.C0155a r1) {
        r0.onClickUserInfo(r1);
    }

    public static final /* synthetic */ void access$onFollowAnimSuccess(ECUserInfoViewModel r0, ml2.a.b r1) {
        r0.onFollowAnimSuccess(r1);
    }

    public static final /* synthetic */ void access$onFollowStateChanged(ECUserInfoViewModel r0, Boolean r1) {
        r0.onFollowStateChanged(r1);
    }

    public static final /* synthetic */ void access$onUserInfoChanged(ECUserInfoViewModel r0, com.bytedance.android.ec.live.api.commerce.userinfo.b r1) {
        r0.onUserInfoChanged(r1);
    }

    public static final /* synthetic */ void access$setLiveRoomParamsReady$p(ECUserInfoViewModel r0, boolean r1) {
        r0.liveRoomParamsReady = r1;
    }

    public final void onWidgetEvent(String r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, "eventParams");
        dm.a.a(TAG).a("onWidgetEvent eventName: " + r7 + ", eventParams: " + r8);
        this.repository.getClass();
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, "eventParams");
        int r9 = r7.hashCode();
        if (r9 == 515869186) goto L11;
        if (r9 == 1028025111) goto L8;
        return;
    L8:
        if (r7.equals("roomVisible") == false) goto L14;
        dm.a.a(TAG).i("onWidgetEvent roomVisible");
        this.roomVisible = true;
        updateLogStatus();
        return;
    L14:
        return;
    L11:
        if (r7.equals("AnchorWidgetTranslationEvent") == false) goto L16;
        setState(C03421.INSTANCE);
        return;
    }

    public ECUserInfoViewModel(String r3, String r4, e r5) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r5, "ability");
        Companion.getClass();
        if (r5.getUserInfo() != null) goto L6;
        super(new ECUserInfoState(0));
        this.roomId = r3;
        this.roomUniqueKey = r4;
        this.disposableContext = new b();
        new ECUserInfoViewModel$repository$1(this);
        new ECUserInfoViewModel$repository$2(this);
        throw null;
    L6:
        throw null;
    }
}
