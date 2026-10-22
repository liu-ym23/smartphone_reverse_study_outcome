package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000¨\u0006\n"}, d2 = {"tapPressTextFieldModifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onTap", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldPressGestureFilterKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Function1<Offset, Unit> $onTap;

        public AnonymousClass1(Function1<? super Offset, Unit> r1, MutableInteractionSource r2) {
            this.$onTap = r1;
            this.$interactionSource = r2;
        }

        public static /* synthetic */ DisposableEffectResult a(MutableState r0, MutableInteractionSource r1, DisposableEffectScope r2) {
            return invoke$lambda$4$lambda$3(r0, r1, r2);
        }

        private static final DisposableEffectResult invoke$lambda$4$lambda$3(final MutableState r0, final MutableInteractionSource r1, DisposableEffectScope r2) {
            return new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$invoke$lambda$4$lambda$3$$inlined$onDispose$1(r0, r1);
        }

        public final Modifier invoke(Modifier r8, Composer r9, int r10) {
            r9.startReplaceGroup(-102778667);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-102778667, r10, -1, "androidx.compose.foundation.text.tapPressTextFieldModifier.<anonymous> (TextFieldPressGestureFilter.kt:40)");
        L5:
            Object r11 = r9.rememberedValue();
            Composer.Companion r12 = Composer.Companion;
            if (r11 != r12.getEmpty()) goto L8;
            r11 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r9);
            r9.updateRememberedValue(r11);
        L8:
            CoroutineScope r13 = (CoroutineScope) r11;
            Object r0 = r9.rememberedValue();
            if (r0 != r12.getEmpty()) goto L11;
            r0 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            r9.updateRememberedValue(r0);
        L11:
            final MutableState r1 = (MutableState) r0;
            State r2 = SnapshotStateKt.rememberUpdatedState(this.$onTap, r9, 0);
            MutableInteractionSource r3 = this.$interactionSource;
            boolean r4 = r9.changed(r3);
            final MutableInteractionSource r5 = this.$interactionSource;
            Object r6 = r9.rememberedValue();
            if (r4 == false) goto L14;
        L15:
            r6 = new w3(r1, r5);
            r9.updateRememberedValue(r6);
        L16:
            EffectsKt.DisposableEffect(r3, (Function1) r6, r9, 0);
            Modifier.Companion r7 = Modifier.Companion;
            MutableInteractionSource r14 = this.$interactionSource;
            boolean r15 = (r9.changedInstance(r13) | r9.changed(this.$interactionSource)) | r9.changed(r2);
            MutableInteractionSource r16 = this.$interactionSource;
            Object r17 = r9.rememberedValue();
            if (r15 == false) goto L19;
        L20:
            r17 = new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1(r13, r1, r16, r2);
            r9.updateRememberedValue(r17);
        L21:
            Modifier r18 = SuspendingPointerInputFilterKt.pointerInput(r7, r14, (PointerInputEventHandler) r17);
            if (ComposerKt.isTraceInProgress() == false) goto L24;
            ComposerKt.traceEventEnd();
        L24:
            r9.endReplaceGroup();
            return r18;
        L19:
            if (r17 != r12.getEmpty()) goto L21;
        L14:
            if (r6 != r12.getEmpty()) goto L16;
            goto L15
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Modifier) r1, (Composer) r2, ((Number) r3).intValue());
        }
    }

    public static final Modifier tapPressTextFieldModifier(Modifier r0, MutableInteractionSource r1, boolean r2, Function1<? super Offset, Unit> r3) {
        if (r2 == true) goto L4;
        return r0;
    L4:
        return ComposedModifierKt.composed$default(r0, null, new AnonymousClass1(r3, r1), 1, null);
    }

    public static /* synthetic */ Modifier tapPressTextFieldModifier$default(Modifier r0, MutableInteractionSource r1, boolean r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return tapPressTextFieldModifier(r0, r1, r2, r3);
    }
}
