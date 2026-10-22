package com.bytedance.android.livesdk.livecommerce.userinfo.rank.repository;

import androidx.lifecycle.MutableLiveData;
import bk2.c;
import com.bytedance.android.ec.live.api.commerce.userinfo.b;
import com.bytedance.android.livesdk.livecommerce.userinfo.fragment.repository.AbsRepository;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECRankRepository extends AbsRepository {
    public final MutableLiveData<b> a;
    public final MutableLiveData b;
    public final String c;
    public final String d;
    public final Function0<Observable<b>> e;
    public final bk2.b f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.rank.repository.ECRankRepository$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.userinfo.rank.repository.ECRankRepository$1", f = "ECRankRepository.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ECRankRepository this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.rank.repository.ECRankRepository$1$a */
        public static final class a<T> implements Consumer {
            public final /* synthetic */ AnonymousClass1 a;

            public a(AnonymousClass1 r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                MutableLiveData<b> r0 = this.a.this$0.a;
                r0.setValue((b) r2);
            }
        }

        public AnonymousClass1(ECRankRepository r1, Continuation r2) {
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

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            Observable r5 = (Observable) r4;
            if (r5 == null) goto L16;
            Disposable r6 = r5.subscribe(new a(this));
            if (r6 == null) goto L16;
            Disposable r7 = c.a(r6, this.this$0.f);
        L17:
            UtilityKotlinExtentionsKt.h(r7, AnonymousClass2.INSTANCE);
            return Unit.INSTANCE;
        L16:
            r7 = null;
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ECRankRepository r8 = this.this$0;
            Function0<Observable<b>> r2 = r8.e;
            this.label = 1;
            r4 = AbsRepository.b(r8, r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public static final class a {
    }

    static {
    }

    public ECRankRepository(String r2, String r3, Function0<? extends Observable<b>> r4, CoroutineScope r5, bk2.b r6) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r4, "userInfoObservable");
        Intrinsics.checkNotNullParameter(r5, "viewModelScope");
        Intrinsics.checkNotNullParameter(r6, "disposableContext");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r6;
        MutableLiveData<b> r7 = new MutableLiveData(null);
        this.a = r7;
        this.b = r7;
        BuildersKt.launch(r5, Dispatchers.getMain().getImmediate(), CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, null));
    }
}
