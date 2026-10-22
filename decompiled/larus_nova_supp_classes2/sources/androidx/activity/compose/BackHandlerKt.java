package androidx.activity.compose;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\u0010\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u008a\u0084\u0002"}, d2 = {"BackHandler", "", "enabled", "", "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release", "currentOnBack"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackHandlerKt {
    private static final Function0<Unit> BackHandler$lambda$0(State<? extends Function0<Unit>> r0) {
        return (Function0) r0.getValue();
    }

    public static final /* synthetic */ Function0 access$BackHandler$lambda$0(State r0) {
        return BackHandler$lambda$0(r0);
    }

    public static final void BackHandler(final boolean r4, final Function0<Unit> r5, Composer r6, final int r7, final int r8) {
        Composer r9 = r6.startRestartGroup(-361453782);
        int r0 = r8 & 1;
        if (r0 == 0) goto L6;
        int r1 = r7 | 6;
    L14:
        if ((r8 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r1 & 91) == 18) goto L26;
    L29:
        if (r0 == 0) goto L31;
        r4 = true;
    L31:
        final State r2 = SnapshotStateKt.rememberUpdatedState(r5, r9, (r1 >> 3) & 14);
        r9.startReplaceableGroup(-3687241);
        Object r3 = r9.rememberedValue();
        Composer.Companion r10 = Composer.Companion;
        if (r3 != r10.getEmpty()) goto L34;
        r3 = new BackHandlerKt$BackHandler$backCallback$1$1(r4, r2);
        r9.updateRememberedValue(r3);
    L34:
        r9.endReplaceableGroup();
        final BackHandlerKt$BackHandler$backCallback$1$1 r11 = (BackHandlerKt$BackHandler$backCallback$1$1) r3;
        Boolean r12 = Boolean.valueOf(r4);
        r9.startReplaceableGroup(-3686552);
        boolean r13 = r9.changed(r11);
        boolean r14 = r9.changed(r12) | r13;
        Object r15 = r9.rememberedValue();
        if (r14 == false) goto L37;
    L38:
        r15 = new BackHandlerKt$BackHandler$1$1(r11, r4);
        r9.updateRememberedValue(r15);
    L39:
        r9.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) r15, r9, 0);
        OnBackPressedDispatcherOwner r16 = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(r9, 6);
        if (r16 == null) goto L48;
        final OnBackPressedDispatcher r17 = r16.getOnBackPressedDispatcher();
        final LifecycleOwner r18 = (LifecycleOwner) r9.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        EffectsKt.DisposableEffect(r18, r17, new AnonymousClass2(r17, r18, r11), r9, 72);
    L42:
        ScopeUpdateScope r19 = r9.endRestartGroup();
        if (r19 == null) goto L49;
        r19.updateScope(new AnonymousClass3(r4, r5, r7, r8));
        return;
    L49:
        return;
    L48:
        throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
    L37:
        if (r15 != r10.getEmpty()) goto L39;
    L26:
        if (r9.getSkipping() == false) goto L29;
        r9.skipToGroupEnd();
        goto L42
    L17:
        if ((r7 & 112) != 0) goto L24;
        if (r9.changed(r5) == false) goto L21;
        int r20 = 32;
    L22:
        r1 = r1 | r20;
        goto L24
    L21:
        r20 = 16;
        goto L22
    L6:
        if ((r7 & 14) == 0) goto L8;
        r1 = r7;
        goto L14
    L8:
        if (r9.changed(r4) == false) goto L10;
        int r21 = 4;
    L11:
        r1 = r21 | r7;
        goto L14
    L10:
        r21 = 2;
        goto L11
    }
}
