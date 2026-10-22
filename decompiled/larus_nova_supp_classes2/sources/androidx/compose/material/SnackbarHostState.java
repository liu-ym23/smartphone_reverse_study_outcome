package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/SnackbarHostState;", "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "<set-?>", "Landroidx/compose/material/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "showSnackbar", "Landroidx/compose/material/SnackbarResult;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final MutableState currentSnackbarData$delegate;
    private final kotlinx.coroutines.sync.a mutex;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material/SnackbarData;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material/SnackbarResult;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlinx/coroutines/CancellableContinuation;)V", "getMessage", "()Ljava/lang/String;", "getActionLabel", "getDuration", "()Landroidx/compose/material/SnackbarDuration;", "performAction", "", "dismiss", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SnackbarDataImpl implements SnackbarData {
        private final String actionLabel;
        private final kotlinx.coroutines.i<SnackbarResult> continuation;
        private final SnackbarDuration duration;
        private final String message;

        @Override // androidx.compose.material.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive() == false) goto L6;
            kotlinx.coroutines.i<SnackbarResult> r0 = this.continuation;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(SnackbarResult.Dismissed));
            return;
        }

        @Override // androidx.compose.material.SnackbarData
        public void performAction() {
            if (this.continuation.isActive() == false) goto L6;
            kotlinx.coroutines.i<SnackbarResult> r0 = this.continuation;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(SnackbarResult.ActionPerformed));
            return;
        }

        @Override // androidx.compose.material.SnackbarData
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material.SnackbarData
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material.SnackbarData
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SnackbarDataImpl(String r1, String r2, SnackbarDuration r3, kotlinx.coroutines.i<? super SnackbarResult> r4) {
            this.message = r1;
            this.actionLabel = r2;
            this.duration = r3;
            this.continuation = r4;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostState$showSnackbar$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SnackbarHostState", f = "SnackbarHost.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {367, 370}, m = "showSnackbar", n = {"message", "actionLabel", "duration", "$this$withLock_u24default$iv", "message", "actionLabel", "duration", "$this$withLock_u24default$iv", "$completion$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SnackbarHostState this$0;

        public AnonymousClass1(SnackbarHostState r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.showSnackbar(null, null, null, this);
        }
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    public SnackbarHostState() {
        this.mutex = kotlinx.coroutines.sync.b.a();
        this.currentSnackbarData$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private final void setCurrentSnackbarData(SnackbarData r2) {
        this.currentSnackbarData$delegate.setValue(r2);
    }

    public static final /* synthetic */ void access$setCurrentSnackbarData(SnackbarHostState r0, SnackbarData r1) {
        r0.setCurrentSnackbarData(r1);
    }

    public final Object showSnackbar(String r8, String r9, SnackbarDuration r10, Continuation<? super SnackbarResult> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r11;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        AnonymousClass1 r13 = (AnonymousClass1) r0.L$4;
        kotlinx.coroutines.sync.a r14 = (kotlinx.coroutines.sync.a) r0.L$3;
        SnackbarDuration r15 = (SnackbarDuration) r0.L$2;
        String r16 = (String) r0.L$1;
        String r17 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L29:
        setCurrentSnackbarData(null);     // Catch: Throwable -> L36
        r14.unlock(null);
        return r12;
    L15:
        th = th;
    L34:
        setCurrentSnackbarData(null);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r18 = (kotlinx.coroutines.sync.a) r0.L$3;
        r10 = (SnackbarDuration) r0.L$2;
        r9 = (String) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
        kotlinx.coroutines.sync.a r19 = r18;
        r8 = r4;
    L41:
        r0.L$0 = r8;     // Catch: Throwable -> L32
        r0.L$1 = r9;     // Catch: Throwable -> L32
        r0.L$2 = r10;     // Catch: Throwable -> L32
        r0.L$3 = r19;     // Catch: Throwable -> L32
        r0.L$4 = r0;     // Catch: Throwable -> L32
        r0.label = 2;     // Catch: Throwable -> L32
        kotlinx.coroutines.j r5 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L32
        r5.C();     // Catch: Throwable -> L32
        access$setCurrentSnackbarData(this, new SnackbarDataImpl(r8, r9, r10, r5));     // Catch: Throwable -> L32
        Object r20 = r5.B();     // Catch: Throwable -> L32
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L32
    L26:
        if (r20 != r2) goto L28;
        return r2;
    L28:
        kotlinx.coroutines.sync.a r6 = r19;
        r12 = r20;
        r14 = r6;
    L32:
        th = th;
        goto L34
    L20:
        ResultKt.throwOnFailure(r12);
        r19 = this.mutex;
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.L$2 = r10;
        r0.L$3 = r19;
        r0.label = 1;
        if (r19.a(null, r0) != r2) goto L41;
        return r2;
    L36:
        th = move-exception;
        r8.unlock(null);
        throw th;
    L7:
        r0 = new AnonymousClass1(this, r11);
        goto L8
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState r0, String r1, String r2, SnackbarDuration r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = SnackbarDuration.Short;
    L9:
        return r0.showSnackbar(r1, r2, r3, r4);
    }
}
