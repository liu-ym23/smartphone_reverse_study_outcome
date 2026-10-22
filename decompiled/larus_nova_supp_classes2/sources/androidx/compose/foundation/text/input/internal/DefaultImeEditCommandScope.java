package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J!\u0010\u0017\u001a\u00020\u00132\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010\u000f\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u00140\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/DefaultImeEditCommandScope;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "batchDepth", "", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapFromTransformed-GEjPoXI", "(J)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "", "Lkotlin/ExtensionFunctionType;", "beginBatchEdit", "", "edit", "block", "endBatchEdit", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultImeEditCommandScope implements ImeEditCommandScope {
    public static final int $stable = 8;
    private int batchDepth;
    private final MutableVector<Function1<TextFieldBuffer, Unit>> editCommands;
    private final TransformedTextFieldState transformedTextFieldState;

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean beginBatchEdit() {
        this.batchDepth++;
        return true;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean endBatchEdit() {
        int r0 = this.batchDepth - 1;
        this.batchDepth = r0;
        if (r0 != 0) goto L14;
        if (this.editCommands.getSize() == 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L14;
        TransformedTextFieldState r2 = this.transformedTextFieldState;
        TextFieldState r3 = TransformedTextFieldState.access$getTextFieldState$p(r2);
        InputTransformation r4 = TransformedTextFieldState.access$getInputTransformation$p(r2);
        TextFieldEditUndoBehavior r5 = TextFieldEditUndoBehavior.MergeIfPossible;
        r3.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        TextFieldBuffer r6 = r3.getMainBuffer$foundation_release();
        MutableVector<Function1<TextFieldBuffer, Unit>> r7 = this.editCommands;
        Object[] r8 = r7.content;
        int r9 = r7.getSize();
        int r10 = 0;
    L10:
        if (r10 >= r9) goto L12;
        ((Function1) r8[r10]).invoke(r6);
        r10 = r10 + 1;
        goto L10
    L12:
        TransformedTextFieldState.access$updateWedgeAffinity(r2, r6);
        TextFieldState.access$commitEditAsUser(r3, r4, false, r5);
        this.editCommands.clear();
        goto L14
    L7:
        r1 = false;
    L14:
        if (this.batchDepth > 0) goto L19;
        return false;
    L19:
        return true;
    }

    public DefaultImeEditCommandScope(TransformedTextFieldState r3) {
        this.transformedTextFieldState = r3;
        this.editCommands = new MutableVector(new Function1[16], 0);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public void edit(Function1<? super TextFieldBuffer, Unit> r2) {
        beginBatchEdit();
        this.editCommands.add(r2);
        endBatchEdit();
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    /* JADX INFO: renamed from: mapFromTransformed-GEjPoXI */
    public long mo1566mapFromTransformedGEjPoXI(long r2) {
        return this.transformedTextFieldState.m1675mapFromTransformedGEjPoXI(r2);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    /* JADX INFO: renamed from: mapToTransformed-GEjPoXI */
    public long mo1567mapToTransformedGEjPoXI(long r2) {
        return this.transformedTextFieldState.m1677mapToTransformedGEjPoXI(r2);
    }
}
