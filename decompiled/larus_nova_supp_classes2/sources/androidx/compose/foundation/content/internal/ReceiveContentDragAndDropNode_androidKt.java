package androidx.compose.foundation.content.internal;

import android.view.DragEvent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0006H\u0000¨\u0006\n"}, d2 = {"ReceiveContentDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "toTransferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ReceiveContentDragAndDropNode_androidKt {
    private static final boolean ReceiveContentDragAndDropNode$lambda$0(DragAndDropEvent r0) {
        return true;
    }

    public static /* synthetic */ boolean a(DragAndDropEvent r0) {
        return ReceiveContentDragAndDropNode$lambda$0(r0);
    }

    public static final TransferableContent toTransferableContent(DragAndDropEvent r8) {
        DragEvent r9 = DragAndDrop_androidKt.toAndroidDragEvent(r8);
        return new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(r9.getClipData()), AndroidClipboardManager_androidKt.toClipMetadata(r9.getClipDescription()), TransferableContent.Source.Companion.m465getDragAndDropkB6V9T0(), null, 8, null);
    }

    public static final DragAndDropTargetModifierNode ReceiveContentDragAndDropNode(final ReceiveContentConfiguration r2, final Function1<? super DragAndDropEvent, Unit> r3) {
        return DragAndDropNodeKt.DragAndDropTargetModifierNode(new b(), new AnonymousClass2(r2, r3));
    }
}
