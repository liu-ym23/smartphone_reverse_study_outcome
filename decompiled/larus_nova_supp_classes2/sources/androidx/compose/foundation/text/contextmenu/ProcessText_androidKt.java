package androidx.compose.foundation.text.contextmenu;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.foundation.text.contextmenu.data.ProcessTextKey;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.ui.text.TextRange;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import j.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"addProcessedTextContextMenuItems", "", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "context", "Landroid/content/Context;", "editable", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "addProcessedTextContextMenuItems-UAq72N0", "(Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;Landroid/content/Context;ZLjava/lang/CharSequence;J)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProcessText_androidKt {
    public static /* synthetic */ Unit a(Context r0, ResolveInfo r1, boolean r2, CharSequence r3, long r4, TextContextMenuSession r6) {
        return addProcessedTextContextMenuItems_UAq72N0$lambda$1$lambda$0(r0, r1, r2, r3, r4, r6);
    }

    /* JADX INFO: renamed from: addProcessedTextContextMenuItems-UAq72N0, reason: not valid java name */
    public static final void m1491addProcessedTextContextMenuItemsUAq72N0(TextContextMenuBuilderScope r19, final Context r20, final boolean r21, final CharSequence r22, final long r23) {
        if (ComposeFoundationFlags.isSmartSelectionEnabled == true) goto L5;
        return;
    L5:
        if (TextRange.getCollapsed-impl(r23) == true) goto L24;
        int r1 = 0;
        if (r22.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 23) goto L26;
        PackageManager r2 = r20.getPackageManager();
        List<ResolveInfo> r3 = ProcessTextApi23Impl.INSTANCE.queryProcessTextActivities(r20);
        if (r3.isEmpty() == false) goto L17;
        return;
    L17:
        r19.separator();
        int r11 = r3.size();
    L18:
        if (r1 >= r11) goto L20;
        final ResolveInfo r5 = (ResolveInfo) ListProtector.get(r3, r1);
        TextContextMenuBuilderScope_androidKt.item$default(r19, new ProcessTextKey(r1), r5.loadLabel(r2).toString(), 0, new c(r20, r5, r21, r22, r23), 4, null);
        r1 = r1 + 1;
        goto L18
    L20:
        r19.separator();
        return;
    L26:
        return;
    L9:
        r0 = false;
        goto L10
    }

    private static final Unit addProcessedTextContextMenuItems_UAq72N0$lambda$1$lambda$0(Context r7, ResolveInfo r8, boolean r9, CharSequence r10, long r11, TextContextMenuSession r13) {
        ProcessTextApi23Impl.INSTANCE.getOnClickProcessTextItem().invoke(r7, r8, Boolean.valueOf(r9), r10, TextRange.box-impl(r11));
        r13.close();
        return Unit.INSTANCE;
    }
}
