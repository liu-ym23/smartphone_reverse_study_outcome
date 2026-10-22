package androidx.compose.foundation.text.input.internal;

import android.content.ClipDescription;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.content.MediaType;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÒ\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0000¨\u0006\u001c"}, d2 = {"textFieldDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "hintMediaTypes", "Lkotlin/Function0;", "", "Landroidx/compose/foundation/content/MediaType;", "onDrop", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/ClipEntry;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "clipEntry", "Landroidx/compose/ui/platform/ClipMetadata;", "clipMetadata", "", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "onStarted", "event", "onEntered", "onMoved", "Landroidx/compose/ui/geometry/Offset;", "position", "onChanged", "onExited", "onEnded", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDragAndDropNode_androidKt {
    public static /* synthetic */ boolean a(Function0 r0, DragAndDropEvent r1) {
        return textFieldDragAndDropNode$lambda$1(r0, r1);
    }

    private static final boolean textFieldDragAndDropNode$lambda$1(Function0 r4, DragAndDropEvent r5) {
        ClipDescription r6 = DragAndDrop_androidKt.toAndroidDragEvent(r5).getClipDescription();
        Iterable r7 = (Iterable) r4.invoke();
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L26;
        MediaType r0 = (MediaType) r8.next();
        if (Intrinsics.areEqual(r0, MediaType.Companion.getAll()) == false) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L9;
        return true;
    L13:
        if (r6.hasMimeType(r0.getRepresentation()) == true) goto L16;
        r1 = false;
        goto L17
    L26:
        return false;
    L5:
        if (((Collection) r7).isEmpty() == false) goto L7;
        return false;
    }

    public static final DragAndDropTargetModifierNode textFieldDragAndDropNode(final Function0<? extends Set<MediaType>> r11, final Function2<? super ClipEntry, ? super ClipMetadata, Boolean> r12, final Function1<? super DragAndDropEvent, Unit> r13, final Function1<? super DragAndDropEvent, Unit> r14, final Function1<? super DragAndDropEvent, Unit> r15, final Function1<? super Offset, Unit> r16, final Function1<? super DragAndDropEvent, Unit> r17, final Function1<? super DragAndDropEvent, Unit> r18, final Function1<? super DragAndDropEvent, Unit> r19) {
        return DragAndDropNodeKt.DragAndDropTargetModifierNode(new v1(r11), new AnonymousClass2(r13, r12, r14, r15, r16, r18, r17, r19));
    }

    public static /* synthetic */ DragAndDropTargetModifierNode textFieldDragAndDropNode$default(Function0 r12, Function2 r13, Function1 r14, Function1 r15, Function1 r16, Function1 r17, Function1 r18, Function1 r19, Function1 r20, int r21, Object r22) {
        if ((r21 & 8) == 0) goto L5;
        Function1 r6 = null;
    L7:
        if ((r21 & 16) == 0) goto L9;
        Function1 r7 = null;
    L11:
        if ((r21 & 32) == 0) goto L13;
        Function1 r8 = null;
    L15:
        if ((r21 & 64) == 0) goto L17;
        Function1 r9 = null;
    L19:
        if ((r21 & 128) == 0) goto L21;
        Function1 r10 = null;
    L23:
        if ((r21 & 256) == 0) goto L25;
        Function1 r11 = null;
    L27:
        return textFieldDragAndDropNode(r12, r13, r14, r6, r7, r8, r9, r10, r11);
    L25:
        r11 = r20;
        goto L27
    L21:
        r10 = r19;
        goto L23
    L17:
        r9 = r18;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }
}
