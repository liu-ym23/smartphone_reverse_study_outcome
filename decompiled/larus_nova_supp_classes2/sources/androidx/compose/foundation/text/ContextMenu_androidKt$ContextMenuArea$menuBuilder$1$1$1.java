package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1", f = "ContextMenu.android.kt", i = {}, l = {110, 111, 112}, m = "invokeSuspend", n = {}, s = {})
public final class ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextContextMenuItems $item;
    final /* synthetic */ TextFieldSelectionState $this_contextMenuBuilder;
    int label;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TextContextMenuItems.values().length];
            r0[TextContextMenuItems.Cut.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[TextContextMenuItems.Copy.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[TextContextMenuItems.Paste.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[TextContextMenuItems.SelectAll.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[TextContextMenuItems.Autofill.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1(TextContextMenuItems r1, TextFieldSelectionState r2, Continuation<? super ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1> r3) {
        this.$item = r1;
        this.$this_contextMenuBuilder = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1(this.$item, this.$this_contextMenuBuilder, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L7;
        if (r1 == 3) goto L7;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        ResultKt.throwOnFailure(r6);
    L32:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r6);
        TextContextMenuItems r7 = this.$item;
        int r8 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L25;
        if (r8 != 3) goto L15;
        TextFieldSelectionState r9 = this.$this_contextMenuBuilder;
        this.label = 3;
        if (r9.paste(this) != r0) goto L32;
        return r0;
    L15:
        if (r8 != 4) goto L17;
        this.$this_contextMenuBuilder.selectAll();
        goto L32
    L17:
        if (r8 != 5) goto L20;
        this.$this_contextMenuBuilder.autofill();
        goto L32
    L20:
        throw new NoWhenBranchMatchedException();
    L25:
        TextFieldSelectionState r10 = this.$this_contextMenuBuilder;
        this.label = 2;
        if (r10.copy(false, this) != r0) goto L32;
        return r0;
    L28:
        TextFieldSelectionState r11 = this.$this_contextMenuBuilder;
        this.label = 1;
        if (r11.cut(this) != r0) goto L32;
        return r0;
    }
}
