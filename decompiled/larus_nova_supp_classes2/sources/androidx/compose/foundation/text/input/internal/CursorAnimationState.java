package androidx.compose.foundation.text.input.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "", "animate", "", "<init>", "(Z)V", "getAnimate", "()Z", "animationJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "Landroidx/compose/foundation/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "<set-?>", "", "cursorAlpha", "getCursorAlpha", "()F", "setCursorAlpha", "(F)V", "cursorAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "snapToVisibleAndAnimate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelAndHide", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CursorAnimationState {
    public static final int $stable = 8;
    private final boolean animate;
    private AtomicReference<Job> animationJob;
    private final MutableFloatState cursorAlpha$delegate;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2", f = "CursorAnimationState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CursorAnimationState this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1", f = "CursorAnimationState.kt", i = {}, l = {72, 77, 79, 81}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $oldJob;
            int label;
            final /* synthetic */ CursorAnimationState this$0;

            public AnonymousClass1(Job r1, CursorAnimationState r2, Continuation<? super AnonymousClass1> r3) {
                this.$oldJob = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.$oldJob, this.this$0, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0077 -> B:43:0x007a). Please report as a decompilation issue!!! */
            public final Object invokeSuspend(Object r12) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L17;
                if (r1 == 2) goto L13;
                if (r1 == 3) goto L12;
                if (r1 != 4) goto L11;
                ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
                AnonymousClass1 r13 = this;
            L43:
                CursorAnimationState.access$setCursorAlpha(r13.this$0, 1.0f);     // Catch: Throwable -> L39
            L31:
                r13.label = 3;     // Catch: Throwable -> L39
                if (DelayKt.delay(500, r13) != r0) goto L34;
                return r0;
            L34:
                CursorAnimationState.access$setCursorAlpha(r13.this$0, MenuKt.ClosedAlphaTarget);     // Catch: Throwable -> L39
                r13.label = 4;     // Catch: Throwable -> L39
                if (DelayKt.delay(500, r13) != r0) goto L43;
                return r0;
            L39:
                th = move-exception;
                AnonymousClass1 r2 = r13;
                th = th;
            L41:
                CursorAnimationState.access$setCursorAlpha(r2.this$0, MenuKt.ClosedAlphaTarget);
                throw th;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
                r13 = this;
                goto L34
            L13:
                ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
            L29:
                throw new KotlinNothingValueException();     // Catch: Throwable -> L15
            L17:
                ResultKt.throwOnFailure(r12);
            L23:
                CursorAnimationState.access$setCursorAlpha(this.this$0, 1.0f);     // Catch: Throwable -> L15
                if (this.this$0.getAnimate() == true) goto L30;
                this.label = 2;     // Catch: Throwable -> L15
                if (DelayKt.awaitCancellation(this) != r0) goto L29;
                return r0;
            L30:
                r13 = this;
                goto L31
            L18:
                ResultKt.throwOnFailure(r12);
                Job r14 = this.$oldJob;
                if (r14 == null) goto L23;
                this.label = 1;
                if (JobKt.cancelAndJoin(r14, this) != r0) goto L23;
                return r0;
            L15:
                th = th;
                r2 = this;
                goto L41
            }
        }

        public AnonymousClass2(CursorAnimationState r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r9);
            CoroutineScope r0 = (CoroutineScope) this.L$0;
            Job r10 = (Job) CursorAnimationState.access$getAnimationJob$p(this.this$0).getAndSet(null);
            AtomicReference r7 = CursorAnimationState.access$getAnimationJob$p(this.this$0);
            Job r11 = BuildersKt.launch$default(r0, null, null, new AnonymousClass1(r10, this.this$0, null), 3, null);
        L6:
            if (r7.compareAndSet(null, r11) == true) goto L7;
            if (r7.get() == null) goto L6;
            boolean r12 = false;
        L12:
            return Boxing.boxBoolean(r12);
        L7:
            r12 = true;
            goto L12
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void cancelAndHide() {
        Job r0 = this.animationJob.getAndSet(null);
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    public final float getCursorAlpha() {
        return this.cursorAlpha$delegate.getFloatValue();
    }

    public final boolean getAnimate() {
        return this.animate;
    }

    public CursorAnimationState(boolean r2) {
        this.animate = r2;
        this.animationJob = new AtomicReference(null);
        this.cursorAlpha$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
    }

    public static final /* synthetic */ AtomicReference access$getAnimationJob$p(CursorAnimationState r0) {
        return r0.animationJob;
    }

    private final void setCursorAlpha(float r2) {
        this.cursorAlpha$delegate.setFloatValue(r2);
    }

    public final Object snapToVisibleAndAnimate(Continuation<? super Unit> r3) {
        Object r4 = CoroutineScopeKt.coroutineScope(new AnonymousClass2(this, null), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$setCursorAlpha(CursorAnimationState r0, float r1) {
        r0.setCursorAlpha(r1);
    }
}
