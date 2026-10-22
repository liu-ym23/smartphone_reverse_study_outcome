package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a.\u0010\u0003\u001a\u00020\u00012\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"ReportDrawn", "", "(Landroidx/compose/runtime/Composer;I)V", "ReportDrawnAfter", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ReportDrawnWhen", "predicate", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ReportDrawnKt {

    /* JADX INFO: renamed from: androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$1", f = "ReportDrawn.kt", i = {0}, l = {182}, m = "invokeSuspend", n = {"$this$reportWhenComplete$iv"}, s = {"L$0"})
    public static final class C00801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ FullyDrawnReporter $fullyDrawnReporter;
        Object L$0;
        int label;

        public C00801(FullyDrawnReporter r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super C00801> r3) {
            this.$fullyDrawnReporter = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C00801(this.$fullyDrawnReporter, this.$block, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            FullyDrawnReporter r2 = (FullyDrawnReporter) this.L$0;
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L8
        L19:
            r2.removeReporter();
        L21:
            return Unit.INSTANCE;
        L8:
            Throwable th = th;
        L24:
            r2.removeReporter();
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r6);
            FullyDrawnReporter r7 = this.$fullyDrawnReporter;
            Function1<Continuation<? super Unit>, Object> r3 = this.$block;
            r7.addReporter();
            if (r7.isFullyDrawnReported() == true) goto L21;
            this.L$0 = r7;     // Catch: Throwable -> L22
            this.label = 1;     // Catch: Throwable -> L22
            if (r3.invoke(this) != r0) goto L18;
            return r0;
        L18:
            r2 = r7;
        L22:
            th = move-exception;
            r2 = r7;
            th = th;
            goto L24
        }
    }

    public static final void ReportDrawn(Composer r2, final int r3) {
        Composer r4 = r2.startRestartGroup(-1357012904);
        if (r3 == 0) goto L5;
    L8:
        ReportDrawnWhen(AnonymousClass1.INSTANCE, r4, 6);
    L9:
        ScopeUpdateScope r5 = r4.endRestartGroup();
        if (r5 == null) goto L14;
        r5.updateScope(new AnonymousClass2(r3));
        return;
    L14:
        return;
    L5:
        if (r4.getSkipping() == false) goto L8;
        r4.skipToGroupEnd();
        goto L9
    }

    public static final void ReportDrawnAfter(final Function1<? super Continuation<? super Unit>, ? extends Object> r3, Composer r4, final int r5) {
        Composer r6 = r4.startRestartGroup(945311272);
        FullyDrawnReporterOwner r0 = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(r6, 6);
        if (r0 == null) goto L12;
        FullyDrawnReporter r1 = r0.getFullyDrawnReporter();
        if (r1 == null) goto L12;
        EffectsKt.LaunchedEffect(r3, r1, new C00801(r1, r3, null), r6, 584);
        ScopeUpdateScope r7 = r6.endRestartGroup();
        if (r7 == null) goto L17;
        r7.updateScope(new C00812(r3, r5));
        return;
    L17:
        return;
    L12:
        ScopeUpdateScope r8 = r6.endRestartGroup();
        if (r8 == null) goto L18;
        r8.updateScope(new ReportDrawnKt$ReportDrawnAfter$fullyDrawnReporter$1(r3, r5));
        return;
    }

    public static final void ReportDrawnWhen(final Function0<Boolean> r3, Composer r4, final int r5) {
        Composer r6 = r4.startRestartGroup(-2047119994);
        if ((r5 & 14) == 0) goto L5;
        int r0 = r5;
    L11:
        if ((r0 & 11) == 2) goto L13;
    L16:
        FullyDrawnReporterOwner r1 = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(r6, 6);
        if (r1 == null) goto L27;
        final FullyDrawnReporter r2 = r1.getFullyDrawnReporter();
        if (r2 == null) goto L27;
        EffectsKt.DisposableEffect(r2, r3, new C00821(r2, r3), r6, ((r0 << 3) & 112) | 8);
    L22:
        ScopeUpdateScope r7 = r6.endRestartGroup();
        if (r7 == null) goto L32;
        r7.updateScope(new C00832(r3, r5));
        return;
    L32:
        return;
    L27:
        ScopeUpdateScope r8 = r6.endRestartGroup();
        if (r8 == null) goto L33;
        r8.updateScope(new ReportDrawnKt$ReportDrawnWhen$fullyDrawnReporter$1(r3, r5));
        return;
    L33:
        return;
    L13:
        if (r6.getSkipping() == false) goto L16;
        r6.skipToGroupEnd();
        goto L22
    L5:
        if (r6.changed(r3) == false) goto L7;
        int r9 = 4;
    L8:
        r0 = r9 | r5;
        goto L11
    L7:
        r9 = 2;
        goto L8
    }
}
