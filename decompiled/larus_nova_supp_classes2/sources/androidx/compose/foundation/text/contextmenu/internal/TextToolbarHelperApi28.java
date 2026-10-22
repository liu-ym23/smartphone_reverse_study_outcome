package androidx.compose.foundation.text.contextmenu.internal;

import android.R;
import android.app.RemoteAction;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.textclassifier.TextClassification;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J&\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/TextToolbarHelperApi28;", "", "<init>", "()V", "addMenuItem", "", "menu", "Landroid/view/Menu;", "orderId", "", "context", "Landroid/content/Context;", "textClassification", "Landroid/view/textclassifier/TextClassification;", "index", "isPrimary", "", "remoteAction", "Landroid/app/RemoteAction;", "addLegacyMenuItem", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextToolbarHelperApi28 {
    public static final TextToolbarHelperApi28 INSTANCE = null;

    static {
        INSTANCE = new TextToolbarHelperApi28();
    }

    private TextToolbarHelperApi28() {
    }

    public static /* synthetic */ boolean a(Context r0, TextClassification r1, MenuItem r2) {
        return addLegacyMenuItem$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ boolean b(RemoteAction r0, MenuItem r1) {
        return addMenuItem$lambda$0(r0, r1);
    }

    private static final boolean addMenuItem$lambda$0(RemoteAction r0, MenuItem r1) {
        TextClassificationHelperApi28.INSTANCE.sendPendingIntent(r0.getActionIntent());
        return true;
    }

    private static final boolean addLegacyMenuItem$lambda$1(Context r0, TextClassification r1, MenuItem r2) {
        TextClassificationHelperApi28.INSTANCE.sendLegacyIntent(r0, r1);
        return true;
    }

    public final void addLegacyMenuItem(Menu r3, int r4, final Context r5, final TextClassification r6) {
        MenuItem r7 = r3.add(R.id.textAssist, R.id.textAssist, r4, r6.getLabel());
        r7.setShowAsAction(2);
        r7.setIcon(r6.getIcon());
        r7.setOnMenuItemClickListener(new l0(r5, r6));
    }

    public final void addMenuItem(Menu r5, int r6, Context r7, boolean r8, final RemoteAction r9) {
        int r0 = 0;
        if (r8 == false) goto L5;
        int r2 = R.id.textAssist;
    L6:
        MenuItem r10 = r5.add(R.id.textAssist, r2, r6, r9.getTitle());
        if (r8 == false) goto L9;
        r0 = 2;
    L9:
        r10.setShowAsAction(r0);
        if (r8 == false) goto L12;
    L13:
        r10.setIcon(r9.getIcon().loadDrawable(r7));
    L14:
        r10.setOnMenuItemClickListener(new k0(r9));
        return;
    L12:
        if (r9.shouldShowIcon() == false) goto L14;
    L5:
        r2 = 0;
        goto L6
    }

    public final void addMenuItem(Menu r8, int r9, Context r10, TextClassification r11, int r12) {
        if (r12 >= 0) goto L4;
        addLegacyMenuItem(r8, r9, r10, r11);
        return;
    L4:
        if (r12 != 0) goto L6;
        boolean r5 = true;
    L7:
        addMenuItem(r8, r9, r10, r5, (RemoteAction) ListProtector.get(r11.getActions(), r12));
        return;
    L6:
        r5 = false;
        goto L7
    }
}
