package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/k;", "Landroid/graphics/Rect;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<k<? super Rect>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View r1, Continuation<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> r2) {
        this.$view = r1;
        super(2, r2);
    }

    public static /* synthetic */ void a(k r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        invokeSuspend$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void c(k r0, View r1) {
        invokeSuspend$lambda$1(r0, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 r0 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((k) r1, (Continuation) r2);
    }

    public final Object invoke(k<? super Rect> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View$OnAttachStateChangeListener, androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1] */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        final k r9 = (k) this.L$0;
        final View.OnLayoutChangeListener r2 = new i(r9);
        final View r3 = this.$view;
        final ViewTreeObserver.OnScrollChangedListener r4 = new j(r9, r3);
        final ?? r5 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(r9, r3, r4, r2);
        if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view) == false) goto L11;
        r9.trySend-JP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(this.$view));
        this.$view.getViewTreeObserver().addOnScrollChangedListener(r4);
        this.$view.addOnLayoutChangeListener(r2);
    L11:
        this.$view.addOnAttachStateChangeListener(r5);
        final View r6 = this.$view;
        Function0<Unit> r7 = new AnonymousClass1(r6, r4, r2, r5);
        this.label = 1;
        if (ProduceKt.a(r9, r7, this) != r0) goto L15;
        return r0;
    }

    private static final void invokeSuspend$lambda$1(k r0, View r1) {
        r0.trySend-JP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r1));
    }

    private static final void invokeSuspend$lambda$0(k r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r2 != r6) goto L6;
        if (r4 != r8) goto L6;
        if (r3 != r7) goto L6;
        if (r5 != r9) goto L6;
        return;
    L6:
        r0.trySend-JP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r1));
    }
}
