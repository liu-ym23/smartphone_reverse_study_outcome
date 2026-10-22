package androidx.compose.foundation.draganddrop;

import androidx.camera.core.impl.ImageFormatConstants;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1", f = "AndroidDragAndDropSource.android.kt", i = {}, l = {ImageFormatConstants.INTERNAL_DEFINED_IMAGE_FORMAT_JPEG}, m = "invokeSuspend", n = {}, s = {})
public final class DragAndDropSourceDefaults$DefaultStartDetector$1 extends SuspendLambda implements Function2<DragAndDropStartDetectorScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DragAndDropSourceDefaults$DefaultStartDetector$1(Continuation<? super DragAndDropSourceDefaults$DefaultStartDetector$1> r2) {
        super(2, r2);
    }

    public static /* synthetic */ Unit a(DragAndDropStartDetectorScope r0, Offset r1) {
        return invokeSuspend$lambda$0(r0, r1);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DragAndDropSourceDefaults$DefaultStartDetector$1 r0 = new DragAndDropSourceDefaults$DefaultStartDetector$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(DragAndDropStartDetectorScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DragAndDropStartDetectorScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        final DragAndDropStartDetectorScope r3 = (DragAndDropStartDetectorScope) this.L$0;
        Function1 r5 = new c(r3);
        this.label = 1;
        if (TapGestureDetectorKt.detectTapGestures$default(r3, null, r5, null, null, this, 13, null) != r0) goto L12;
        return r0;
    }

    private static final Unit invokeSuspend$lambda$0(DragAndDropStartDetectorScope r2, Offset r3) {
        r2.mo497requestDragAndDropTransferk4lQ0M(r3.unbox-impl());
        return Unit.INSTANCE;
    }
}
