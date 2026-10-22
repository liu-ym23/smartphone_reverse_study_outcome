package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ8\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnchorInfoController;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "monitorScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/CoroutineScope;)V", "monitorEnabled", "", "hasPendingImmediateRequest", "monitorJob", "Lkotlinx/coroutines/Job;", "includeInsertionMarker", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "androidMatrix", "Landroid/graphics/Matrix;", "requestUpdates", "", "cursorUpdateMode", "", "immediate", "monitor", "startOrStopMonitoring", "calculateCursorAnchorInfo", "Landroid/view/inputmethod/CursorAnchorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CursorAnchorInfoController {
    public static final int $stable = 8;
    private final Matrix androidMatrix;
    private final CursorAnchorInfo.Builder builder;
    private final ComposeInputMethodManager composeImm;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private final float[] matrix;
    private boolean monitorEnabled;
    private Job monitorJob;
    private final CoroutineScope monitorScope;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnchorInfoController$startOrStopMonitoring$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnchorInfoController$startOrStopMonitoring$1", f = "CursorAnchorInfoController.android.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CursorAnchorInfoController this$0;

        public AnonymousClass1(CursorAnchorInfoController r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public static /* synthetic */ CursorAnchorInfo a(CursorAnchorInfoController r0) {
            return invokeSuspend$lambda$0(r0);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final CursorAnchorInfo invokeSuspend$lambda$0(CursorAnchorInfoController r0) {
            return CursorAnchorInfoController.access$calculateCursorAnchorInfo(r0);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            final CursorAnchorInfoController r6 = this.this$0;
            kotlinx.coroutines.flow.v r7 = kotlinx.coroutines.flow.e.p(SnapshotStateKt.snapshotFlow(new w(r6)), 1);
            final CursorAnchorInfoController r3 = this.this$0;
            FlowCollector r2 = new AnonymousClass2(r3);
            this.label = 1;
            Object r8 = r7.collect(new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1.2(r2), this);
            if (r8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r8 = Unit.INSTANCE;
        L12:
            if (r8 != r0) goto L15;
            return r0;
        }
    }

    private final CursorAnchorInfo calculateCursorAnchorInfo() {
        LayoutCoordinates r1 = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (r1 != null) goto L5;
    L31:
        return null;
    L5:
        if (r1.isAttached() == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L31;
        LayoutCoordinates r3 = this.textLayoutState.getCoreNodeCoordinates();
        if (r3 == null) goto L31;
        if (r3.isAttached() == true) goto L16;
        r3 = null;
    L16:
        if (r3 == null) goto L31;
        LayoutCoordinates r4 = this.textLayoutState.getDecoratorNodeCoordinates();
        if (r4 == null) goto L31;
        if (r4.isAttached() == true) goto L24;
        r4 = null;
    L24:
        if (r4 == null) goto L31;
        TextLayoutResult r11 = this.textLayoutState.getLayoutResult();
        if (r11 != null) goto L29;
        return null;
    L29:
        TextFieldCharSequence r7 = this.textFieldState.getVisualText();
        androidx.compose.ui.graphics.Matrix.reset-impl(this.matrix);
        r1.transformToScreen-58bKbWc(this.matrix);
        AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(this.androidMatrix, this.matrix);
        Rect r2 = SelectionManagerKt.visibleBounds(r3);
        Offset.Companion r5 = Offset.Companion;
        return CursorAnchorInfoBuilder_androidKt.m1577buildvxqZcH0(this.builder, r7, r7.m1535getSelectiond9O1mEE(), r7.m1534getCompositionMzsxiRA(), r11, this.androidMatrix, r2.translate-k-4lQ0M(r1.localPositionOf-R5De75A(r3, r5.getZero-F1C5BW0())), SelectionManagerKt.visibleBounds(r4).translate-k-4lQ0M(r1.localPositionOf-R5De75A(r4, r5.getZero-F1C5BW0())), this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds);
    }

    private final void startOrStopMonitoring() {
        boolean r1 = true;
        if (this.monitorEnabled == false) goto L12;
        Job r0 = this.monitorJob;
        if (r0 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == true) goto L17;
        this.monitorJob = BuildersKt.launch$default(this.monitorScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, null), 1, null);
        return;
    L17:
        return;
    L7:
        if (r0.isActive() != true) goto L9;
    L12:
        Job r2 = this.monitorJob;
        if (r2 == null) goto L15;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L15:
        this.monitorJob = null;
    }

    public static final /* synthetic */ CursorAnchorInfo access$calculateCursorAnchorInfo(CursorAnchorInfoController r0) {
        return r0.calculateCursorAnchorInfo();
    }

    public static final /* synthetic */ ComposeInputMethodManager access$getComposeImm$p(CursorAnchorInfoController r0) {
        return r0.composeImm;
    }

    public final void requestUpdates(int r11) {
        boolean r1 = false;
        if ((r11 & 1) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r11 & 2) == 0) goto L9;
        boolean r5 = true;
    L10:
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 33) goto L13;
        boolean r6 = true;
        boolean r7 = true;
        boolean r8 = false;
        boolean r9 = false;
    L38:
        requestUpdates(r4, r5, r6, r7, r8, r9);
        return;
    L13:
        if ((r11 & 16) == 0) goto L15;
        boolean r3 = true;
    L17:
        if ((r11 & 8) == 0) goto L19;
        boolean r10 = true;
    L21:
        if ((r11 & 4) == 0) goto L23;
        boolean r12 = true;
    L25:
        if (r0 >= 34) goto L27;
    L29:
        if (r3 == true) goto L36;
        if (r10 == true) goto L36;
        if (r12 == true) goto L36;
        if (r1 == true) goto L36;
        if (r0 < 34) goto L35;
        r6 = true;
        r7 = true;
        r8 = true;
        r9 = true;
        goto L38
    L35:
        r9 = r1;
        r6 = true;
        r7 = true;
        r8 = true;
    L36:
        r9 = r1;
        r8 = r12;
        r7 = r10;
        r6 = r3;
        goto L38
    L27:
        if ((r11 & 32) == 0) goto L29;
        r1 = true;
        goto L29
    L23:
        r12 = false;
        goto L25
    L19:
        r10 = false;
        goto L21
    L15:
        r3 = false;
        goto L17
    L9:
        r5 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    public CursorAnchorInfoController(TransformedTextFieldState r1, TextLayoutState r2, ComposeInputMethodManager r3, CoroutineScope r4) {
        this.textFieldState = r1;
        this.textLayoutState = r2;
        this.composeImm = r3;
        this.monitorScope = r4;
        this.builder = new CursorAnchorInfo.Builder();
        this.matrix = androidx.compose.ui.graphics.Matrix.constructor-impl$default(null, 1, null);
        this.androidMatrix = new Matrix();
    }

    private final void requestUpdates(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6) {
        this.includeInsertionMarker = r3;
        this.includeCharacterBounds = r4;
        this.includeEditorBounds = r5;
        this.includeLineBounds = r6;
        if (r1 == false) goto L7;
        this.hasPendingImmediateRequest = true;
        CursorAnchorInfo r7 = calculateCursorAnchorInfo();
        if (r7 == null) goto L7;
        this.composeImm.updateCursorAnchorInfo(r7);
    L7:
        this.monitorEnabled = r2;
        startOrStopMonitoring();
    }
}
