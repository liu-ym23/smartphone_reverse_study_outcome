package io.github.alexzhirkevich.compottie;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010!\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\"J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080@¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR/\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0016\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001d\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b\u001f\u0010\u0018R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lio/github/alexzhirkevich/compottie/LottieCompositionResultImpl;", "Lio/github/alexzhirkevich/compottie/LottieCompositionResult;", "<init>", "()V", "compositionDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lio/github/alexzhirkevich/compottie/LottieComposition;", "<set-?>", "value", "getValue", "()Lio/github/alexzhirkevich/compottie/LottieComposition;", "setValue", "(Lio/github/alexzhirkevich/compottie/LottieComposition;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "", "error", "getError", "()Ljava/lang/Throwable;", "setError", "(Ljava/lang/Throwable;)V", "error$delegate", "isLoading", "", "()Z", "isLoading$delegate", "Landroidx/compose/runtime/State;", "isComplete", "isComplete$delegate", "isFailure", "isFailure$delegate", "isSuccess", "isSuccess$delegate", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", BitableAnalytic.SelectSceneClickType.COMPLETE, "", "composition", "complete$compottie_release", "(Lio/github/alexzhirkevich/compottie/LottieComposition;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeExceptionally", "completeExceptionally$compottie_release", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LottieCompositionResultImpl implements LottieCompositionResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableDeferred<LottieComposition> f490707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableState f490708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableState f490709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final State f490710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final State f490711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final State f490712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final State f490713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutexImpl f490714h;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.github.alexzhirkevich.compottie.LottieCompositionResult
    public final Throwable getError() {
        return (Throwable) this.f490709c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.State
    public final LottieComposition getValue() {
        return (LottieComposition) this.f490708b.getValue();
    }

    @Override // io.github.alexzhirkevich.compottie.LottieCompositionResult
    public final boolean isFailure() {
        return ((Boolean) this.f490712f.getValue()).booleanValue();
    }

    public LottieCompositionResultImpl() {
        this.f490707a = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.f490708b = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.f490709c = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.f490710d = SnapshotStateKt.derivedStateOf(new t(this));
        this.f490711e = SnapshotStateKt.derivedStateOf(new u(this));
        this.f490712f = SnapshotStateKt.derivedStateOf(new v(this));
        this.f490713g = SnapshotStateKt.derivedStateOf(new w(this));
        this.f490714h = kotlinx.coroutines.sync.b.a();
    }

    public final Object e(LottieComposition r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof LottieCompositionResultImpl$complete$1) == false) goto L7;
        LottieCompositionResultImpl$complete$1 r102 = (LottieCompositionResultImpl$complete$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$1;
        LottieComposition r108 = (LottieComposition) r102.L$0;
        ResultKt.throwOnFailure(r104);
        kotlinx.coroutines.sync.a r109 = r107;
        r100 = r108;
    L26:
    L23:
        th = move-exception;
        r109.unlock(null);
        throw th;
    L18:
        if (((Boolean) this.f490711e.getValue()).booleanValue() == true) goto L20;
        this.f490708b.setValue(r100);     // Catch: Throwable -> L23
        this.f490707a.complete(r100);     // Catch: Throwable -> L23
    L20:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r109.unlock(null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r109 = this.f490714h;
        r102.L$0 = r100;
        r102.L$1 = r109;
        r102.label = 1;
        if (r109.a(null, r102) != r105) goto L26;
        return r105;
    L7:
        r102 = new LottieCompositionResultImpl$complete$1(this, r101);
        goto L8
    }

    public final Object f(Throwable r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof LottieCompositionResultImpl$completeExceptionally$1) == false) goto L7;
        LottieCompositionResultImpl$completeExceptionally$1 r102 = (LottieCompositionResultImpl$completeExceptionally$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$1;
        Throwable r108 = (Throwable) r102.L$0;
        ResultKt.throwOnFailure(r104);
        kotlinx.coroutines.sync.a r109 = r107;
        r100 = r108;
    L26:
    L23:
        th = move-exception;
        r109.unlock(null);
        throw th;
    L18:
        if (((Boolean) this.f490711e.getValue()).booleanValue() == true) goto L20;
        this.f490709c.setValue(r100);     // Catch: Throwable -> L23
        this.f490707a.completeExceptionally(r100);     // Catch: Throwable -> L23
    L20:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r109.unlock(null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r109 = this.f490714h;
        r102.L$0 = r100;
        r102.L$1 = r109;
        r102.label = 1;
        if (r109.a(null, r102) != r105) goto L26;
        return r105;
    L7:
        r102 = new LottieCompositionResultImpl$completeExceptionally$1(this, r101);
        goto L8
    }
}
