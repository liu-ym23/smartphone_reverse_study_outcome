package androidx.compose.material3;

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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/SnackbarHostState;", "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "<set-?>", "Landroidx/compose/material3/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material3/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material3/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "showSnackbar", "Landroidx/compose/material3/SnackbarResult;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarVisualsImpl", "SnackbarDataImpl", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final MutableState currentSnackbarData$delegate;
    private final kotlinx.coroutines.sync.a mutex;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material3/SnackbarData;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material3/SnackbarResult;", "<init>", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlinx/coroutines/CancellableContinuation;)V", "getVisuals", "()Landroidx/compose/material3/SnackbarVisuals;", "performAction", "", "dismiss", "equals", "", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SnackbarDataImpl implements SnackbarData {
        private final kotlinx.coroutines.i<SnackbarResult> continuation;
        private final SnackbarVisuals visuals;

        @Override // androidx.compose.material3.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive() == false) goto L6;
            kotlinx.coroutines.i<SnackbarResult> r0 = this.continuation;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(SnackbarResult.Dismissed));
            return;
        }

        @Override // androidx.compose.material3.SnackbarData
        public void performAction() {
            if (this.continuation.isActive() == false) goto L6;
            kotlinx.coroutines.i<SnackbarResult> r0 = this.continuation;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(SnackbarResult.ActionPerformed));
            return;
        }

        public int hashCode() {
            return (getVisuals().hashCode() * 31) + this.continuation.hashCode();
        }

        @Override // androidx.compose.material3.SnackbarData
        public SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (SnackbarDataImpl.class != r5.getClass()) goto L17;
            SnackbarDataImpl r6 = (SnackbarDataImpl) r5;
            if (Intrinsics.areEqual(getVisuals(), r6.getVisuals()) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.continuation, r6.continuation) == true) goto L16;
            return false;
        L16:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SnackbarDataImpl(SnackbarVisuals r1, kotlinx.coroutines.i<? super SnackbarResult> r2) {
            this.visuals = r1;
            this.continuation = r2;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarVisualsImpl;", "Landroidx/compose/material3/SnackbarVisuals;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;)V", "getMessage", "()Ljava/lang/String;", "getActionLabel", "getWithDismissAction", "()Z", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "equals", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SnackbarVisualsImpl implements SnackbarVisuals {
        private final String actionLabel;
        private final SnackbarDuration duration;
        private final String message;
        private final boolean withDismissAction;

        public int hashCode() {
            int r0 = getMessage().hashCode() * 31;
            String r1 = getActionLabel();
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L6:
            int r3 = (r0 + r2) * 31;
            if (getWithDismissAction() == false) goto L9;
            int r4 = 1231;
        L11:
            return ((r3 + r4) * 31) + getDuration().hashCode();
        L9:
            r4 = 1237;
            goto L11
        L5:
            r2 = 0;
            goto L6
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L23:
            return false;
        L8:
            if (SnackbarVisualsImpl.class != r5.getClass()) goto L23;
            SnackbarVisualsImpl r6 = (SnackbarVisualsImpl) r5;
            if (Intrinsics.areEqual(getMessage(), r6.getMessage()) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(getActionLabel(), r6.getActionLabel()) == true) goto L17;
            return false;
        L17:
            if (getWithDismissAction() == r6.getWithDismissAction()) goto L20;
            return false;
        L20:
            if (getDuration() == r6.getDuration()) goto L22;
            return false;
        L22:
            return true;
        }

        public SnackbarVisualsImpl(String r1, String r2, boolean r3, SnackbarDuration r4) {
            this.message = r1;
            this.actionLabel = r2;
            this.withDismissAction = r3;
            this.duration = r4;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnackbarHostState$showSnackbar$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SnackbarHostState", f = "SnackbarHost.kt", i = {0, 0, 1, 1, 1}, l = {428, 431}, m = "showSnackbar", n = {"visuals", "$this$withLock_u24default$iv", "visuals", "$this$withLock_u24default$iv", "$completion$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SnackbarHostState this$0;

        public AnonymousClass2(SnackbarHostState r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.showSnackbar(null, this);
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

    public final Object showSnackbar(SnackbarVisuals r8, Continuation<? super SnackbarResult> r9) {
        if ((r9 instanceof AnonymousClass2) == false) goto L7;
        AnonymousClass2 r0 = (AnonymousClass2) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        AnonymousClass2 r11 = (AnonymousClass2) r0.L$2;
        kotlinx.coroutines.sync.a r12 = (kotlinx.coroutines.sync.a) r0.L$1;
        SnackbarVisuals r4 = (SnackbarVisuals) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L29:
        setCurrentSnackbarData(null);     // Catch: Throwable -> L36
        r12.unlock(null);
        return r10;
    L15:
        Throwable th = th;
    L34:
        setCurrentSnackbarData(null);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r0.L$1;
        SnackbarVisuals r5 = (SnackbarVisuals) r0.L$0;
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.sync.a r14 = r13;
        r8 = r5;
    L40:
        r0.L$0 = r8;     // Catch: Throwable -> L32
        r0.L$1 = r14;     // Catch: Throwable -> L32
        r0.L$2 = r0;     // Catch: Throwable -> L32
        r0.label = 2;     // Catch: Throwable -> L32
        kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L32
        r6.C();     // Catch: Throwable -> L32
        access$setCurrentSnackbarData(this, new SnackbarDataImpl(r8, r6));     // Catch: Throwable -> L32
        Object r15 = r6.B();     // Catch: Throwable -> L32
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L32
    L26:
        if (r15 != r2) goto L28;
        return r2;
    L28:
        kotlinx.coroutines.sync.a r7 = r14;
        r10 = r15;
        r12 = r7;
    L32:
        th = move-exception;
        th = th;
        goto L34
    L20:
        ResultKt.throwOnFailure(r10);
        r14 = this.mutex;
        r0.L$0 = r8;
        r0.L$1 = r14;
        r0.label = 1;
        if (r14.a(null, r0) != r2) goto L40;
        return r2;
    L36:
        th = move-exception;
        r8.unlock(null);
        throw th;
    L7:
        r0 = new AnonymousClass2(this, r9);
        goto L8
    }

    public final Object showSnackbar(String r2, String r3, boolean r4, SnackbarDuration r5, Continuation<? super SnackbarResult> r6) {
        return showSnackbar(new SnackbarVisualsImpl(r2, r3, r4, r5), r6);
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState r6, String r7, String r8, boolean r9, SnackbarDuration r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = null;
    L5:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        boolean r3 = false;
    L10:
        if ((r12 & 8) == 0) goto L16;
        if (r2 != null) goto L13;
        SnackbarDuration r14 = SnackbarDuration.Short;
    L14:
        r10 = r14;
        goto L16
    L13:
        r14 = SnackbarDuration.Indefinite;
    L16:
        return r6.showSnackbar(r7, r2, r3, r10, r11);
    L8:
        r3 = r9;
        goto L10
    }
}
