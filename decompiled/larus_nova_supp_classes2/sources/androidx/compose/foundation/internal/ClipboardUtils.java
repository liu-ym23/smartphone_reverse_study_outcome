package androidx.compose.foundation.internal;

import android.content.ClipData;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/internal/ClipboardUtils;", "", "<init>", "()V", "readText", "", "clipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "readAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "toClipEntry", "annotatedString", "hasText", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClipboardUtils {
    public static final int $stable = 0;
    public static final ClipboardUtils INSTANCE = null;

    static {
        INSTANCE = new ClipboardUtils();
    }

    private ClipboardUtils() {
    }

    @JvmStatic
    public static final boolean hasText(ClipEntry r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.getClipData().getDescription().hasMimeType("text/*");
    }

    @JvmStatic
    public static final AnnotatedString readAnnotatedString(ClipEntry r1) {
        ClipData.Item r2 = r1.getClipData().getItemAt(0);
        if (r2 == null) goto L7;
        CharSequence r3 = r2.getText();
        if (r3 == null) goto L7;
        return ClipboardUtils_androidKt.convertToAnnotatedString(r3);
    L7:
        return null;
    }

    @JvmStatic
    public static final String readText(ClipEntry r1) {
        ClipData.Item r2 = r1.getClipData().getItemAt(0);
        if (r2 == null) goto L7;
        CharSequence r3 = r2.getText();
        if (r3 == null) goto L7;
        return r3.toString();
    L7:
        return null;
    }

    @JvmStatic
    public static final ClipEntry toClipEntry(AnnotatedString r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new ClipEntry(ClipData.newPlainText("plain text", ClipboardUtils_androidKt.convertToCharSequence(r2)));
    }
}
