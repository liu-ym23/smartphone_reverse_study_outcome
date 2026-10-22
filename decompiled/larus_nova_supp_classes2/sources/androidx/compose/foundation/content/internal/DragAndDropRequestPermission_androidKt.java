package androidx.compose.foundation.content.internal;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.core.view.DragAndDropPermissionsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"dragAndDropRequestPermission", "", "Landroidx/compose/ui/node/DelegatableNode;", "event", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "containsContentUri", "", "Landroid/content/ClipData;", "tryGetActivity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragAndDropRequestPermission_androidKt {
    private static final boolean containsContentUri(ClipData r5) {
        int r0 = r5.getItemCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        Uri r3 = r5.getItemAt(r2).getUri();
        if (r3 == null) goto L10;
        if (Intrinsics.areEqual(r3.getScheme(), "content") == false) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }

    private static final Activity tryGetActivity(View r1) {
        Context r2 = r1.getContext();
    L4:
        if ((r2 instanceof ContextWrapper) == false) goto L10;
        if ((r2 instanceof Activity) == true) goto L8;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L4
    L8:
        return (Activity) r2;
    L10:
        return null;
    }

    public static final void dragAndDropRequestPermission(DelegatableNode r2, DragAndDropEvent r3) {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        return;
    L6:
        if (containsContentUri(DragAndDrop_androidKt.toAndroidDragEvent(r3).getClipData()) == true) goto L9;
        return;
    L9:
        if (r2.getNode().isAttached() == false) goto L15;
        Activity r4 = tryGetActivity(DelegatableNode_androidKt.requireView(r2));
        if (r4 != null) goto L13;
        return;
    L13:
        DragAndDropPermissionsCompat.request(r4, DragAndDrop_androidKt.toAndroidDragEvent(r3));
        return;
    }
}
