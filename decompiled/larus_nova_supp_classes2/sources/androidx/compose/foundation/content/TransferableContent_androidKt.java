package androidx.compose.foundation.content;

import android.content.ClipData;
import android.content.ClipDescription;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"consume", "Landroidx/compose/foundation/content/TransferableContent;", "predicate", "Lkotlin/Function1;", "Landroid/content/ClipData$Item;", "", "hasMediaType", "mediaType", "Landroidx/compose/foundation/content/MediaType;", "readPlainText", "", "Landroidx/compose/ui/platform/ClipEntry;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransferableContent_androidKt {
    public static final String readPlainText(ClipEntry r6) {
        int r0 = r6.getClipData().getItemCount();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r2 >= r0) goto L12;
        if (r3 == false) goto L7;
    L10:
        r3 = true;
    L11:
        r2 = r2 + 1;
        goto L4
    L7:
        if (r6.getClipData().getItemAt(r2).getText() != null) goto L10;
        r3 = false;
        goto L11
    L12:
        if (r3 == false) goto L22;
        StringBuilder r4 = new StringBuilder();
        int r5 = r6.getClipData().getItemCount();
        boolean r7 = false;
    L14:
        if (r1 >= r5) goto L30;
        CharSequence r8 = r6.getClipData().getItemAt(r1).getText();
        if (r8 == null) goto L20;
        if (r7 == false) goto L19;
        r4.append("\n");
    L19:
        r4.append(r8);
        r7 = true;
    L20:
        r1 = r1 + 1;
        goto L14
    L30:
        return r4.toString();
    L22:
        return null;
    }

    public static final TransferableContent consume(TransferableContent r13, Function1<? super ClipData.Item, Boolean> r14) {
        ClipData r0 = r13.getClipEntry().getClipData();
        boolean r2 = false;
        int r4 = 1;
        if (r0.getItemCount() == 1) goto L5;
        int r1 = r0.getItemCount();
        ArrayList r6 = null;
        int r5 = 0;
    L10:
        if (r5 >= r1) goto L17;
        ClipData.Item r7 = r0.getItemAt(r5);
        if (((Boolean) r14.invoke(r7)).booleanValue() == true) goto L16;
        if (r6 != null) goto L15;
        r6 = new ArrayList();
    L15:
        r6.add(r7);
    L16:
        r5 = r5 + 1;
        goto L10
    L17:
        if (r6 != null) goto L19;
    L20:
        r2 = true;
    L21:
        if (r2 == false) goto L24;
        return null;
    L24:
        if (r6.size() != r0.getItemCount()) goto L26;
        return r13;
    L26:
        ClipDescription r15 = new ClipDescription(r13.getClipMetadata().getClipDescription());
        ClipData r3 = new ClipData(r15, (ClipData.Item) CollectionsKt.first(r6));
        int r8 = r6.size();
    L27:
        if (r4 >= r8) goto L30;
        r3.addItem((ClipData.Item) ListProtector.get(r6, r4));
        r4 = r4 + 1;
        goto L27
    L30:
        return new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(r3), AndroidClipboardManager_androidKt.toClipMetadata(r15), r13.m456getSourcekB6V9T0(), r13.getPlatformTransferableContent(), null);
    L19:
        if (r6.isEmpty() == false) goto L21;
    L5:
        if ((!((Boolean) r14.invoke(r0.getItemAt(0))).booleanValue()) == false) goto L8;
        return r13;
    L8:
        return null;
    }

    public static final boolean hasMediaType(TransferableContent r0, MediaType r1) {
        return r0.getClipMetadata().getClipDescription().hasMimeType(r1.getRepresentation());
    }
}
