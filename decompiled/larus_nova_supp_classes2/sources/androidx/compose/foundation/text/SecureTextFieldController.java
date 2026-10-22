package androidx.compose.foundation.text;

import androidx.compose.foundation.BasicTooltipDefaults;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0015H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/SecureTextFieldController;", "", "obfuscationMaskState", "Landroidx/compose/runtime/State;", "", "<init>", "(Landroidx/compose/runtime/State;)V", "passwordInputTransformation", "Landroidx/compose/foundation/text/PasswordInputTransformation;", "getPasswordInputTransformation", "()Landroidx/compose/foundation/text/PasswordInputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "getCodepointTransformation", "()Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "focusChangeModifier", "Landroidx/compose/ui/Modifier;", "getFocusChangeModifier", "()Landroidx/compose/ui/Modifier;", "resetTimerSignal", "Lkotlinx/coroutines/channels/Channel;", "", "observeHideEvents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleHide", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SecureTextFieldController {
    public static final int $stable = 8;
    private final CodepointTransformation codepointTransformation;
    private final Modifier focusChangeModifier;
    private final State<Character> obfuscationMaskState;
    private final PasswordInputTransformation passwordInputTransformation;
    private final Channel<Unit> resetTimerSignal;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.SecureTextFieldController$observeHideEvents$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.SecureTextFieldController$observeHideEvents$2", f = "BasicSecureTextField.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SecureTextFieldController this$0;

        public AnonymousClass2(SecureTextFieldController r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Unit) r1, (Continuation) r2);
        }

        public final Object invoke(Unit r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            this.this$0.getPasswordInputTransformation().hide();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            if (DelayKt.delay(BasicTooltipDefaults.TooltipDuration, this) != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ int a(SecureTextFieldController r0, int r1, int r2) {
        return codepointTransformation$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(SecureTextFieldController r0, FocusState r1) {
        return focusChangeModifier$lambda$1(r0, r1);
    }

    private final void scheduleHide() {
        Object r0 = this.resetTimerSignal.trySend-JP2dKIU(Unit.INSTANCE);
        kotlinx.coroutines.channels.g.c r1 = kotlinx.coroutines.channels.g.b;
        if ((r0 instanceof kotlinx.coroutines.channels.g.c) == false) goto L6;
        this.passwordInputTransformation.hide();
        return;
    }

    public final CodepointTransformation getCodepointTransformation() {
        return this.codepointTransformation;
    }

    public final Modifier getFocusChangeModifier() {
        return this.focusChangeModifier;
    }

    public final PasswordInputTransformation getPasswordInputTransformation() {
        return this.passwordInputTransformation;
    }

    public SecureTextFieldController(State<Character> r3) {
        this.obfuscationMaskState = r3;
        this.passwordInputTransformation = new PasswordInputTransformation(new SecureTextFieldController$passwordInputTransformation$1(this));
        this.codepointTransformation = new f3(this);
        this.focusChangeModifier = FocusChangedModifierKt.onFocusChanged(Modifier.Companion, new g3(this));
        this.resetTimerSignal = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    public static final /* synthetic */ void access$scheduleHide(SecureTextFieldController r0) {
        r0.scheduleHide();
    }

    public final Object observeHideEvents(Continuation<? super Unit> r4) {
        Object r5 = kotlinx.coroutines.flow.e.i(kotlinx.coroutines.flow.e.l(this.resetTimerSignal), new AnonymousClass2(this, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit focusChangeModifier$lambda$1(SecureTextFieldController r0, FocusState r1) {
        if (r1.isFocused() == true) goto L6;
        r0.passwordInputTransformation.hide();
    L6:
        return Unit.INSTANCE;
    }

    private static final int codepointTransformation$lambda$0(SecureTextFieldController r1, int r2, int r3) {
        if (r2 != r1.passwordInputTransformation.getRevealCodepointIndex$foundation_release()) goto L6;
        return r3;
    L6:
        return ((Character) r1.obfuscationMaskState.getValue()).charValue();
    }
}
