package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0011\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0097\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u0017H\u0097\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u0014*\u00020\u0013H\u0097\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u001a\u001a\u00020\u0014*\u00020\u001dH\u0097\u0001¢\u0006\u0004\b\u001b\u0010\u001eJ\u0014\u0010\u001a\u001a\u00020\u0014*\u00020\u0017H\u0097\u0001¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010!\u001a\u00020\"*\u00020#H\u0097\u0001¢\u0006\u0004\b$\u0010%J\u0014\u0010&\u001a\u00020\u001d*\u00020\u0014H\u0097\u0001¢\u0006\u0004\b'\u0010\u001eJ\u0014\u0010&\u001a\u00020\u001d*\u00020\u0017H\u0097\u0001¢\u0006\u0004\b(\u0010 J\r\u0010)\u001a\u00020**\u00020+H\u0097\u0001J\u0014\u0010,\u001a\u00020#*\u00020\"H\u0097\u0001¢\u0006\u0004\b-\u0010%J\u0014\u0010.\u001a\u00020\u0017*\u00020\u0013H\u0097\u0001¢\u0006\u0004\b/\u00100J\u0014\u0010.\u001a\u00020\u0017*\u00020\u001dH\u0097\u0001¢\u0006\u0004\b/\u00101J\u0014\u0010.\u001a\u00020\u0017*\u00020\u0014H\u0097\u0001¢\u0006\u0004\b2\u00101R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b6\u00104¨\u00067"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "<init>", "(Landroidx/compose/ui/unit/Density;)V", "isReleased", "", "isCanceled", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "cancel", "", "release", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRelease", "tryAwaitRelease", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "getDensity", "()F", "fontScale", "getFontScale", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PressGestureScopeImpl implements PressGestureScope, Density {
    public static final int $stable = 0;
    private final /* synthetic */ Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;
    private final kotlinx.coroutines.sync.a mutex;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", i = {}, l = {533}, m = "awaitRelease", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PressGestureScopeImpl this$0;

        public AnonymousClass1(PressGestureScopeImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.awaitRelease(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", i = {}, l = {527}, m = "reset", n = {}, s = {})
    public static final class C01461 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PressGestureScopeImpl this$0;

        public C01461(PressGestureScopeImpl r1, Continuation<? super C01461> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.reset(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", i = {}, l = {540}, m = "tryAwaitRelease", n = {}, s = {})
    public static final class C01471 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PressGestureScopeImpl this$0;

        public C01471(PressGestureScopeImpl r1, Continuation<? super C01471> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.tryAwaitRelease(this);
        }
    }

    public final void cancel() {
        this.isCanceled = true;
        if (this.mutex.isLocked() == false) goto L6;
        this.mutex.unlock(null);
        return;
    }

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public final void release() {
        this.isReleased = true;
        if (this.mutex.isLocked() == false) goto L6;
        this.mutex.unlock(null);
        return;
    }

    /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public int m641roundToPxR2X_6o(long r2) {
        return this.$$delegate_0.roundToPx--R2X_6o(r2);
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
    public int m642roundToPx0680j_4(float r2) {
        return this.$$delegate_0.roundToPx-0680j_4(r2);
    }

    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    public float m643toDpGaN1DYA(long r2) {
        return this.$$delegate_0.toDp-GaN1DYA(r2);
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float m644toDpu2uoSUM(float r2) {
        return this.$$delegate_0.toDp-u2uoSUM(r2);
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float m645toDpu2uoSUM(int r2) {
        return this.$$delegate_0.toDp-u2uoSUM(r2);
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public long m646toDpSizekrfVVM(long r2) {
        return this.$$delegate_0.toDpSize-k-rfVVM(r2);
    }

    /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
    public float m647toPxR2X_6o(long r2) {
        return this.$$delegate_0.toPx--R2X_6o(r2);
    }

    /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
    public float m648toPx0680j_4(float r2) {
        return this.$$delegate_0.toPx-0680j_4(r2);
    }

    public Rect toRect(DpRect r2) {
        return this.$$delegate_0.toRect(r2);
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public long m649toSizeXkaWNTQ(long r2) {
        return this.$$delegate_0.toSize-XkaWNTQ(r2);
    }

    /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
    public long m650toSp0xMU5do(float r3) {
        return this.$$delegate_0.toSp-0xMU5do(r3);
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long m651toSpkPz2Gy4(float r3) {
        return this.$$delegate_0.toSp-kPz2Gy4(r3);
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long m652toSpkPz2Gy4(int r3) {
        return this.$$delegate_0.toSp-kPz2Gy4(r3);
    }

    public PressGestureScopeImpl(Density r2) {
        this.$$delegate_0 = r2;
        kotlinx.coroutines.internal.b0 r3 = kotlinx.coroutines.sync.b.a;
        this.mutex = new MutexImpl(false);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public Object awaitRelease(Continuation<? super Unit> r5) {
        if ((r5 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r5;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L18:
        if (((Boolean) r6).booleanValue() == false) goto L22;
        return Unit.INSTANCE;
    L22:
        throw new GestureCancellationException("The press gesture was canceled.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        r0.label = 1;
        r6 = tryAwaitRelease(r0);
        if (r6 != r2) goto L18;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r5);
        goto L8
    }

    public final Object reset(Continuation<? super Unit> r5) {
        if ((r5 instanceof C01461) == false) goto L7;
        C01461 r0 = (C01461) r5;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        this.isReleased = false;
        this.isCanceled = false;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.sync.a r7 = this.mutex;
        r0.label = 1;
        if (r7.a(null, r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new C01461(this, r5);
        goto L8
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public Object tryAwaitRelease(Continuation<? super Boolean> r6) {
        if ((r6 instanceof C01471) == false) goto L7;
        C01471 r0 = (C01471) r6;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L21:
        this.mutex.unlock(null);
    L23:
        return Boxing.boxBoolean(this.isReleased);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (this.isReleased == true) goto L23;
        if (this.isCanceled == true) goto L23;
        kotlinx.coroutines.sync.a r8 = this.mutex;
        r0.label = 1;
        if (r8.a(null, r0) != r2) goto L21;
        return r2;
    L7:
        r0 = new C01471(this, r6);
        goto L8
    }
}
