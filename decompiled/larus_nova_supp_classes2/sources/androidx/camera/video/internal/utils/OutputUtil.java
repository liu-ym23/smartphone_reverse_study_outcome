package androidx.camera.video.internal.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.camera.core.Logger;
import f06.b;
import f06.c;
import f06.d;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class OutputUtil {
    private static final String TAG = "OutputUtil";

    private OutputUtil() {
    }

    public static boolean createParentFolder(File r1) {
        File r2 = r1.getParentFile();
        if (r2 != null) goto L7;
        return false;
    L7:
        if (r2.exists() == false) goto L10;
        return r2.isDirectory();
    L10:
        return r2.mkdirs();
    }

    public static String getAbsolutePathFromUri(ContentResolver r9, Uri r10, String r11) {
        Cursor r2 = null;
        Cursor r12 = androidx_camera_video_internal_utils_OutputUtil_android_content_ContentResolver_query(r9, r10, new String[]{r11}, null, null, null);     // Catch: Throwable -> L13 RuntimeException -> L15
        if (r12 != null) goto L26;
        if (r12 == null) goto L7;
        r12.close();
    L7:
        return null;
    L26:
        int r13 = r12.getColumnIndexOrThrow(r11);     // Catch: RuntimeException -> L11 Throwable -> L21
        r12.moveToFirst();     // Catch: RuntimeException -> L11 Throwable -> L21
        String r14 = r12.getString(r13);     // Catch: RuntimeException -> L11 Throwable -> L21
        r12.close();
        return r14;
    L11:
        e = e;
    L17:
        Logger.e(TAG, String.format("Failed in getting absolute path for Uri %s with Exception %s", new Object[]{r10.toString(), e.toString()}));     // Catch: Throwable -> L21
        if (r12 == null) goto L20;
        r12.close();
    L20:
        return null;
    L21:
        th = th;
        r2 = r12;
    L23:
        if (r2 == null) goto L25;
        r2.close();
    L25:
        throw th;
    L15:
        e = e;
        r12 = null;
    L13:
        th = th;
        goto L23
    }

    private static Cursor androidx_camera_video_internal_utils_OutputUtil_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
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
