package com.bytedance.android.livesdk.livecommerce.userinfo.title.repository;

import bk2.c;
import com.bytedance.android.ec.common.api.jump.model.f;
import com.bytedance.android.ec.live.api.commerce.userinfo.b;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.userinfo.fragment.repository.AbsRepository;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jf.e;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECUserInfoRepository extends AbsRepository {
    public ll2.a a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$1", f = "ECUserInfoRepository.kt", i = {}, l = {h1.TYPE_LINKER_ENLARGE_UPDATE}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ECUserInfoRepository this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$1$a */
        public static final class a<T> implements Consumer {
            public final /* synthetic */ AnonymousClass1 a;

            public a(AnonymousClass1 r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                b r2 = (b) r1;
                this.a.this$0.getClass();
                throw null;
            }
        }

        public AnonymousClass1(ECUserInfoRepository r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Disposable r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            Observable r6 = (Observable) r5;
            if (r6 == null) goto L16;
            Disposable r7 = r6.subscribe(new a(this));
            if (r7 == null) goto L16;
            this.this$0.getClass();
            r2 = c.a(r7, null);
        L16:
            UtilityKotlinExtentionsKt.h(r2, AnonymousClass2.INSTANCE);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ECUserInfoRepository r8 = this.this$0;
            r8.getClass();
            this.label = 1;
            r5 = AbsRepository.b(r8, null, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$2", f = "ECUserInfoRepository.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ECUserInfoRepository this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.repository.ECUserInfoRepository$2$a */
        public static final class a<T> implements Consumer {
            public final /* synthetic */ AnonymousClass2 a;

            public a(AnonymousClass2 r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                this.a.this$0.getClass();
                ((com.bytedance.android.ec.live.api.commerce.userinfo.a) r2).getClass();
                throw null;
            }
        }

        public AnonymousClass2(ECUserInfoRepository r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass2(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Disposable r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            Function1<Observable<com.bytedance.android.ec.live.api.commerce.userinfo.a>, Unit> r3 = new AnonymousClass1(this);
            Lazy r4 = UtilityKotlinExtentionsKt.a;
            Intrinsics.checkNotNullParameter(r3, "block");
            if (r5 == null) goto L14;
            r3.invoke(r5);
        L14:
            Observable r6 = (Observable) r5;
            if (r6 == null) goto L19;
            Disposable r7 = r6.subscribe(new a(this));
            if (r7 == null) goto L19;
            this.this$0.getClass();
            r2 = c.a(r7, null);
        L19:
            UtilityKotlinExtentionsKt.h(r2, AnonymousClass3.INSTANCE);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ECUserInfoRepository r8 = this.this$0;
            r8.getClass();
            this.label = 1;
            r5 = AbsRepository.b(r8, null, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public static final class a {
    }

    static {
    }

    public ECUserInfoRepository() {
        throw null;
    }

    public final ll2.a c(String r14) {
        Intrinsics.checkNotNullParameter(r14, "btmPageId");
        ll2.a r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        r1.element = true;
        int r2 = RoomContextController.h;
        com.bytedance.android.ec.common.api.jump.model.b r3 = RoomContextController.a.b(null, null).l();
        UtilityKotlinExtentionsKt.h(r3, new ECUserInfoRepository$getUserInfoParams$result$1(r1));
        if (r3 != null) goto L8;
        r3 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L8:
        ll2.a r15 = (ll2.a) r3.buildParams(Reflection.getOrCreateKotlinClass(f.class), new f.a("c0.d0", r14, jf.b.m.b, e.g.b, null, null, null, 112)).buildParams(Reflection.getOrCreateKotlinClass(ll2.a.class), new ll2.a.C0151a(new ECUserInfoRepository$getUserInfoParams$result$2(this)));
        if (r1.element == false) goto L11;
        this.a = r15;
    L11:
        return r15;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0072 -> B:24:0x0075). Please report as a decompilation issue!!! */
    public final Object d(Continuation<? super Boolean> r18) {
        if ((r18 instanceof ECUserInfoRepository$onLiveRoomParamsReady$1) == false) goto L7;
        ECUserInfoRepository$onLiveRoomParamsReady$1 r1 = (ECUserInfoRepository$onLiveRoomParamsReady$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
        ECUserInfoRepository r3 = this;
    L8:
        Object r0 = r1.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r1.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L32:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r6 = r1.I$0;
        ECUserInfoRepository r10 = (ECUserInfoRepository) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L24:
        int r7 = RoomContextController.h;
        r10.getClass();
        RoomContextController r8 = RoomContextController.a.b(null, null);
        r6 = r6 + 1;
        dm.a.a("ECUserInfoRepository").i("onLiveRoomParamsReady while controller is fallback: " + r8.A().K + " retryCount " + r6);
    L18:
        if (r6 >= 5) goto L26;
        if (r8.A().K == false) goto L26;
        r1.L$0 = r10;
        r1.I$0 = r6;
        r1.label = 1;
        if (DelayKt.delay(((long) 100) + (((long) r6) * 100), r1) != r4) goto L24;
        return r4;
    L26:
        if (r8.A().K == false) goto L29;
        dm.a.a("ECUserInfoRepository").b("onLiveRoomParamsReady finally controller is fallback", null);
        return Boxing.boxBoolean(false);
    L29:
        r1.L$0 = null;
        r1.label = 2;
        r0 = r8.N(r1);
        if (r0 != r4) goto L32;
        return r4;
    L16:
        ResultKt.throwOnFailure(r0);
        int r9 = RoomContextController.h;
        r8 = RoomContextController.a.b(null, null);
        r10 = r3;
        r6 = 0;
    L7:
        r3 = this;
        r1 = new ECUserInfoRepository$onLiveRoomParamsReady$1(r3, r18);
        goto L8
    }
}
