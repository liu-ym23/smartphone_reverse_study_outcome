package com.larus.im.internal.jni.callback;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.flow.kmp.common.util.i;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMCallbackExt;
import com.larus.im.callback.IMError;
import com.larus.im.internal.jni.bean.OmniIMError;
import com.larus.im.internal.jni.converter.OmniIMErrorConverterKt;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015J\u0015\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/im/internal/jni/callback/NativeIMCallback;", "Receive", "Dispatch", "Lcom/larus/im/internal/jni/callback/OmniIMCallback;", "from", "", "reqLog", "cb", "Lcom/larus/im/callback/IIMCallback;", "converter", "Lkotlin/Function1;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/callback/IIMCallback;Lkotlin/jvm/functions/Function1;)V", DyPayConstant.KEY_START_TIME, "", "logTag", "logPrefix", "callback", "", "result", "block", "Lkotlin/Function0;", "onLocalFinish", "(Ljava/lang/Object;)V", "onSuccess", "onFailure", "error", "Lcom/larus/im/internal/jni/bean/OmniIMError;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NativeIMCallback<Receive, Dispatch> implements OmniIMCallback<Receive> {

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    private final IIMCallback<Dispatch> f348660cb;
    private final Function1<Receive, Dispatch> converter;
    private final String from;
    private final String logPrefix;
    private final String logTag;
    private final String reqLog;
    private final long startTime;

    /* JADX INFO: renamed from: com.larus.im.internal.jni.callback.NativeIMCallback$callback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.jni.callback.NativeIMCallback$callback$1", f = "NativeIMCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $block;
        final /* synthetic */ long $callBackStartTime;
        final /* synthetic */ String $result;
        final /* synthetic */ long $sdkCost;
        int label;
        final /* synthetic */ NativeIMCallback<Receive, Dispatch> this$0;

        public AnonymousClass1(long r100, NativeIMCallback<Receive, Dispatch> r101, String r102, long r103, Function0<Unit> r104, Continuation<? super AnonymousClass1> r105) {
            this.$callBackStartTime = r100;
            this.this$0 = r101;
            this.$result = r102;
            this.$sdkCost = r103;
            this.$block = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
            return new AnonymousClass1(this.$callBackStartTime, this.this$0, this.$result, this.$sdkCost, this.$block, r111);
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
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            long r101 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - this.$callBackStartTime;
            com.larus.im.internal.delegate.a.f348188b.i(NativeIMCallback.access$getLogTag$p(this.this$0), NativeIMCallback.access$getLogPrefix$p(this.this$0) + " result:" + this.$result + ",sdkCost:" + this.$sdkCost + ",switchCost:" + r101);
            this.$block.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Unit a(NativeIMCallback r100, Object r101) {
        return onSuccess$lambda$1(r100, r101);
    }

    public static /* synthetic */ Unit b(NativeIMCallback r100, IMError r101) {
        return onFailure$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit c(NativeIMCallback r100, Object r101) {
        return onLocalFinish$lambda$0(r100, r101);
    }

    public static final /* synthetic */ String access$getLogPrefix$p(NativeIMCallback r100) {
        return r100.logPrefix;
    }

    public static final /* synthetic */ String access$getLogTag$p(NativeIMCallback r100) {
        return r100.logTag;
    }

    @Override // com.larus.im.internal.jni.callback.OmniIMCallback
    public void onFailure(OmniIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        final IMError r101 = OmniIMErrorConverterKt.toIMError(r100);
        NativeIMReporter.INSTANCE.reportError(this.from, this.reqLog, r101);
        callback("onFailure=" + r100, new c(this, r101));
    }

    @Override // com.larus.im.internal.jni.callback.OmniIMCallback
    public void onLocalFinish(Receive r100) {
        if ((this.f348660cb instanceof IIMCallbackExt) == false) goto L6;
        final Dispatch r101 = this.converter.invoke(r100);
        callback("onLocalFinish", new a(this, r101));
        return;
    }

    @Override // com.larus.im.internal.jni.callback.OmniIMCallback
    public void onSuccess(Receive r100) {
        final Dispatch r101 = this.converter.invoke(r100);
        callback("onSuccess", new b(this, r101));
    }

    private static final Unit onFailure$lambda$2(NativeIMCallback r100, IMError r101) {
        IIMCallback<Dispatch> r102 = r100.f348660cb;
        if (r102 == null) goto L6;
        r102.onFailure(r101);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit onLocalFinish$lambda$0(NativeIMCallback r100, Object r101) {
        ((IIMCallbackExt) r100.f348660cb).onLocalFinish(r101);
        return Unit.INSTANCE;
    }

    private static final Unit onSuccess$lambda$1(NativeIMCallback r100, Object r101) {
        IIMCallback<Dispatch> r102 = r100.f348660cb;
        if (r102 == null) goto L6;
        r102.onSuccess(r101);
    L6:
        return Unit.INSTANCE;
    }

    public final void callback(String r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "result");
        Intrinsics.checkNotNullParameter(r111, "block");
        com.larus.im.internal.delegate.c r100 = com.larus.im.internal.delegate.c.f348197a;
        long r101 = r100.elapsedRealtime() - this.startTime;
        NativeIMReporter.INSTANCE.checkTimeOut(this.from, this.reqLog, r101);
        IIMCallback<Dispatch> r102 = this.f348660cb;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.mustInMain() != true) goto L7;
    L8:
        if (r103 == true) goto L10;
    L12:
        com.larus.im.internal.delegate.a.f348188b.i(this.logTag, this.logPrefix + " result:" + r110 + ",sdkCost:" + r101);
        r111.invoke();
        return;
    L10:
        if (com.flow.kmp.common.thread.a.a() == true) goto L12;
        CoroutineExtKt.b(new AnonymousClass1(r100.elapsedRealtime(), this, r110, r101, r111, null));
        return;
    L7:
        r103 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativeIMCallback(String r100, String r101, IIMCallback<Dispatch> r102, Function1<? super Receive, ? extends Dispatch> r103) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "reqLog");
        Intrinsics.checkNotNullParameter(r103, "converter");
        this.from = r100;
        this.reqLog = r101;
        this.f348660cb = r102;
        this.converter = r103;
        this.startTime = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        this.logTag = "@@@NativeIMCallback";
        String r104 = r100 + '_' + i.a();
        this.logPrefix = r104;
        int r105 = NativeIMReporter.INSTANCE.recordRequest(r100, r101);
        com.larus.im.internal.delegate.a.f348188b.i("@@@NativeIMCallback", r104 + " start, count:" + r105 + ",reqLog:" + r101);
    }
}
