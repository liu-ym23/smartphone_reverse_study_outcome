package androidx.camera.core.internal.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import f06.b;
import f06.c;
import f06.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class VideoUtil {
    private static final String TAG = "VideoUtil";

    private VideoUtil() {
    }

    public static String getAbsolutePathFromUri(ContentResolver r8, Uri r9) {
        Cursor r1 = null;
        r1 = androidx_camera_core_internal_utils_VideoUtil_android_content_ContentResolver_query(r8, r9, new String[]{"_data"}, null, null, null);     // Catch: RuntimeException -> L11 Throwable -> L16
        Cursor r10 = (Cursor) Preconditions.checkNotNull(r1);     // Catch: RuntimeException -> L11 Throwable -> L16
        int r0 = r10.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L7 RuntimeException -> L9
        r10.moveToFirst();     // Catch: Throwable -> L7 RuntimeException -> L9
        String r11 = r10.getString(r0);     // Catch: Throwable -> L7 RuntimeException -> L9
        r10.close();
        return r11;
    L9:
        e = e;
        r1 = r10;
    L12:
        Logger.e(TAG, String.format("Failed in getting absolute path for Uri %s with Exception %s", new Object[]{r9.toString(), e.toString()}));     // Catch: Throwable -> L16
        if (r1 == null) goto L15;
        r1.close();
    L15:
        return "";
    L7:
        th = th;
        r1 = r10;
    L17:
        if (r1 == null) goto L19;
        r1.close();
    L19:
        throw th;
    L16:
        th = th;
    L11:
        e = e;
        goto L12
    }

    private static Cursor androidx_camera_core_internal_utils_VideoUtil_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        c r8 = new c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        b r10 = new b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
