package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a]\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032A\u0010\u0004\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f²\u0006E\u0010\u0010\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u008a\u0084\u0002"}, d2 = {"PredictiveBackHandler", "", "enabled", "", "onBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "progress", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release", "currentOnBack"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PredictiveBackHandlerKt {

    /* JADX INFO: renamed from: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$1", f = "PredictiveBackHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 $backCallBack;
        final /* synthetic */ boolean $enabled;
        int label;

        public AnonymousClass1(PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.$backCallBack = r1;
            this.$enabled = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$backCallBack, this.$enabled, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            setEnabled(this.$enabled);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final Function2<Flow<BackEventCompat>, Continuation<Unit>, Object> PredictiveBackHandler$lambda$0(State<? extends Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object>> r0) {
        return (Function2) r0.getValue();
    }

    public static final /* synthetic */ Function2 access$PredictiveBackHandler$lambda$0(State r0) {
        return PredictiveBackHandler$lambda$0(r0);
    }

    public static final void PredictiveBackHandler(final boolean r5, final Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object> r6, Composer r7, final int r8, final int r9) {
        Composer r10 = r7.startRestartGroup(-642000585);
        if ((r9 & 1) == 0) goto L5;
        r5 = true;
    L5:
        final State r0 = SnapshotStateKt.rememberUpdatedState(r6, r10, 8);
        r10.startReplaceableGroup(-723524056);
        r10.startReplaceableGroup(-3687241);
        Object r2 = r10.rememberedValue();
        Composer.Companion r3 = Composer.Companion;
        if (r2 != r3.getEmpty()) goto L8;
        CompositionScopedCoroutineScopeCanceller r4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r10));
        r10.updateRememberedValue(r4);
        r2 = r4;
    L8:
        r10.endReplaceableGroup();
        final CoroutineScope r11 = ((CompositionScopedCoroutineScopeCanceller) r2).getCoroutineScope();
        r10.endReplaceableGroup();
        r10.startReplaceableGroup(-3687241);
        Object r1 = r10.rememberedValue();
        if (r1 != r3.getEmpty()) goto L11;
        r1 = new PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1(r5, r11, r0);
        r10.updateRememberedValue(r1);
    L11:
        r10.endReplaceableGroup();
        final PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 r12 = (PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1) r1;
        EffectsKt.LaunchedEffect(Boolean.valueOf(r5), new AnonymousClass1(r12, r5, null), r10, (r8 & 14) | 64);
        OnBackPressedDispatcherOwner r13 = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(r10, 6);
        if (r13 == null) goto L19;
        final OnBackPressedDispatcher r14 = r13.getOnBackPressedDispatcher();
        final LifecycleOwner r15 = (LifecycleOwner) r10.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        EffectsKt.DisposableEffect(r15, r14, new AnonymousClass2(r14, r15, r12), r10, 72);
        ScopeUpdateScope r16 = r10.endRestartGroup();
        if (r16 == null) goto L20;
        r16.updateScope(new AnonymousClass3(r5, r6, r8, r9));
        return;
    L20:
        return;
    L19:
        throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
    }
}
