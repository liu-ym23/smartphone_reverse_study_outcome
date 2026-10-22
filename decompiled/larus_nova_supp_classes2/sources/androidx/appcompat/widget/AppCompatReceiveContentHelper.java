package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import f06.b;
import f06.c;
import f06.d;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AppCompatReceiveContentHelper {
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    private static final String LOG_TAG = "ReceiveContent";

    public static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        public static boolean onDropForTextView(DragEvent r1, TextView r2, Activity r3) {
            r3.requestDragAndDropPermissions(r1);
            int r4 = r2.getOffsetForPosition(r1.getX(), r1.getY());
            r2.beginBatchEdit();
            Selection.setSelection((Spannable) r2.getText(), r4);     // Catch: Throwable -> L6
            ViewCompat.performReceiveContent(r2, new ContentInfoCompat.Builder(r1.getClipData(), 3).build());     // Catch: Throwable -> L6
            r2.endBatchEdit();
            return true;
        L6:
            th = move-exception;
            r2.endBatchEdit();
            throw th;
        }

        public static boolean onDropForView(DragEvent r1, View r2, Activity r3) {
            r3.requestDragAndDropPermissions(r1);
            ViewCompat.performReceiveContent(r2, new ContentInfoCompat.Builder(r1.getClipData(), 3).build());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    private static ClipData androidx_appcompat_widget_AppCompatReceiveContentHelper_android_content_ClipboardManager_getPrimaryClip(ClipboardManager r13) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        d r11 = r8.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r13, r9, "android.content.ClipData", r10);
        if (r11.a == false) goto L6;
        r8.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r13, r9, null, r10, false);
        return (ClipData) r11.b;
    L6:
        ClipData r12 = r13.getPrimaryClip();
        r8.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r13, r9, r12, r10, true);
        return r12;
    }

    public static InputConnectionCompat.OnCommitContentListener createOnCommitContentListener(final View r1) {
        return new AnonymousClass1(r1);
    }

    public static Activity tryGetActivity(View r1) {
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

    public static boolean maybeHandleDragEventViaPerformReceiveContent(View r4, DragEvent r5) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L24:
        return false;
    L5:
        if (r5.getLocalState() != null) goto L24;
        if (ViewCompat.getOnReceiveContentMimeTypes(r4) == null) goto L24;
        Activity r0 = tryGetActivity(r4);
        if (r0 != null) goto L14;
        Objects.toString(r4);
        return false;
    L14:
        if (r5.getAction() != 1) goto L18;
        return !(r4 instanceof TextView);
    L18:
        if (r5.getAction() != 3) goto L24;
        if ((r4 instanceof TextView) == false) goto L23;
        return OnDropApi24Impl.onDropForTextView(r5, (TextView) r4, r0);
    L23:
        return OnDropApi24Impl.onDropForView(r5, r4, r0);
    }

    public static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView r5, int r6) {
        int r0 = 0;
        if (r6 == 16908322) goto L7;
        if (r6 == 16908337) goto L7;
    L8:
        return false;
    L7:
        if (ViewCompat.getOnReceiveContentMimeTypes(r5) == null) goto L8;
        ClipboardManager r2 = (ClipboardManager) r5.getContext().getSystemService("clipboard");
        if (r2 != null) goto L12;
        ClipData r3 = null;
    L14:
        if (r3 != null) goto L16;
    L22:
        return true;
    L16:
        if (r3.getItemCount() <= 0) goto L22;
        ContentInfoCompat.Builder r4 = new ContentInfoCompat.Builder(r3, 1);
        if (r6 == 16908322) goto L21;
        r0 = 1;
    L21:
        ViewCompat.performReceiveContent(r5, r4.setFlags(r0).build());
        goto L22
    L12:
        r3 = androidx_appcompat_widget_AppCompatReceiveContentHelper_android_content_ClipboardManager_getPrimaryClip(r2);
        goto L14
    }
}
