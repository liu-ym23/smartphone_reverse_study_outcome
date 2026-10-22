package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$1", f = "CoreTextField.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
public final class CoreTextFieldKt$CoreTextField$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ LegacyTextFieldState $state;
    final /* synthetic */ TextInputService $textInputService;
    final /* synthetic */ State<Boolean> $writeable$delegate;
    int label;

    public CoreTextFieldKt$CoreTextField$2$1(LegacyTextFieldState r1, State<Boolean> r2, TextInputService r3, TextFieldSelectionManager r4, ImeOptions r5, Continuation<? super CoreTextFieldKt$CoreTextField$2$1> r6) {
        this.$state = r1;
        this.$writeable$delegate = r2;
        this.$textInputService = r3;
        this.$manager = r4;
        this.$imeOptions = r5;
        super(2, r6);
    }

    public static /* synthetic */ boolean a(State r0) {
        return invokeSuspend$lambda$0(r0);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CoreTextFieldKt$CoreTextField$2$1(this.$state, this.$writeable$delegate, this.$textInputService, this.$manager, this.$imeOptions, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    private static final boolean invokeSuspend$lambda$0(State r0) {
        return CoreTextFieldKt.access$CoreTextField$lambda$16(r0);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7
    L15:
        CoreTextFieldKt.access$endInputSession(this.$state);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r8);
        final State<Boolean> r9 = this.$writeable$delegate;     // Catch: Throwable -> L7
        Flow r10 = SnapshotStateKt.snapshotFlow(new m2(r9));     // Catch: Throwable -> L7
        final LegacyTextFieldState r3 = this.$state;     // Catch: Throwable -> L7
        final TextInputService r4 = this.$textInputService;     // Catch: Throwable -> L7
        final TextFieldSelectionManager r5 = this.$manager;     // Catch: Throwable -> L7
        final ImeOptions r6 = this.$imeOptions;     // Catch: Throwable -> L7
        FlowCollector r2 = new AnonymousClass2(r3, r4, r5, r6);     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r10.collect(r2, this) != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        CoreTextFieldKt.access$endInputSession(this.$state);
        throw th;
    }
}
