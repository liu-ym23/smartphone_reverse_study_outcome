package androidx.compose.foundation.text.contextmenu.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.view.textclassifier.TextClassification;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/TextClassificationHelperApi28;", "", "<init>", "()V", "sendPendingIntent", "", "pendingIntent", "Landroid/app/PendingIntent;", "sendLegacyIntent", "context", "Landroid/content/Context;", "textClassification", "Landroid/view/textclassifier/TextClassification;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextClassificationHelperApi28 {
    public static final int $stable = 0;
    public static final TextClassificationHelperApi28 INSTANCE = null;

    static {
        INSTANCE = new TextClassificationHelperApi28();
    }

    private TextClassificationHelperApi28() {
    }

    public final void sendPendingIntent(PendingIntent r3) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        TextClassificationHelper34.INSTANCE.sendIntentAllowBackgroundActivityStart(r3);
        return;
    L5:
        r3.send();
    }

    public final void sendLegacyIntent(Context r3, TextClassification r4) {
        String r0 = r4.getText();
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        sendPendingIntent(PendingIntent.getActivity(r3, r1, r4.getIntent(), 201326592));
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
