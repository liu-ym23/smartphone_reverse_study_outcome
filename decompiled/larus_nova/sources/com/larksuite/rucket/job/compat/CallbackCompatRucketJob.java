package com.larksuite.rucket.job.compat;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.job.RucketJobImpl;
import com.larksuite.rucket.job.extension.EmptyResultException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\"\u0010\u0004\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0006J\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R*\u0010\u0004\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larksuite/rucket/job/compat/CallbackCompatRucketJob;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larksuite/rucket/job/RucketJobImpl;", "Lcom/larksuite/framework/callback/IGetDataCallback;", "callbackResolver", "Lkotlin/Function1;", "", "Lcom/larksuite/rucket/job/compat/IAsyncHandler;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "registerCallback", "onSuccess", "data", "(Ljava/lang/Object;)V", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "rucket_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CallbackCompatRucketJob<T> extends RucketJobImpl<T> implements IGetDataCallback<T> {
    private final Function1<IGetDataCallback<T>, Unit> callbackResolver;

    /* JADX INFO: renamed from: com.larksuite.rucket.job.compat.CallbackCompatRucketJob$onError$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.compat.CallbackCompatRucketJob$onError$1", f = "CallbackCompatRucketJob.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ErrorResult $err;
        int label;
        final /* synthetic */ CallbackCompatRucketJob<T> this$0;

        public AnonymousClass1(CallbackCompatRucketJob<T> r100, ErrorResult r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$err = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$err, r101);
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
            CallbackCompatRucketJob<T> r103 = this.this$0;
            ErrorResult r104 = this.$err;
            this.label = 1;
            if (r103.setError(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.compat.CallbackCompatRucketJob$onSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.compat.CallbackCompatRucketJob$onSuccess$1", f = "CallbackCompatRucketJob.kt", i = {}, l = {30, 32}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ T $data;
        int label;
        final /* synthetic */ CallbackCompatRucketJob<T> this$0;

        public C107781(T r100, CallbackCompatRucketJob<T> r101, Continuation<? super C107781> r102) {
            this.$data = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C107781(this.$data, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C107781) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L19:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r100);
            T r103 = this.$data;
            if (r103 == null) goto L15;
            CallbackCompatRucketJob<T> r104 = this.this$0;
            this.label = 1;
            if (r104.setResult(r103, this) != r101) goto L19;
            return r101;
        L15:
            CallbackCompatRucketJob<T> r105 = this.this$0;
            EmptyResultException r106 = new EmptyResultException();
            this.label = 2;
            if (r105.setError(r106, this) != r101) goto L19;
            return r101;
        }
    }

    public final void registerCallback() {
        this.callbackResolver.invoke(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackCompatRucketJob(Function1<? super IGetDataCallback<T>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callbackResolver");
        this.callbackResolver = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        BuildersKt.launch$default(this, null, null, new AnonymousClass1(this, r100, null), 3, null);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public void onSuccess(T r100) {
        BuildersKt.launch$default(this, null, null, new C107781(r100, this, null), 3, null);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }
}
