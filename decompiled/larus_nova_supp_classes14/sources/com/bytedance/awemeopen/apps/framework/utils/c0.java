package com.bytedance.awemeopen.apps.framework.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 {
    public static final String[] a = null;
    public static final ArrayList<z> b = null;
    public static final a c = null;
    public static long d;

    public static final class a extends ContentObserver {
        public a() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r4) {
            c0.a();     // Catch: SQLException -> L4
            return;
        L4:
            e = move-exception;
            AoLogger.c("ScreenShotHelper", new Object[]{"handleContentObserverChange error:" + e.getMessage()});
        }
    }

    public c0() {
    }

    static {
        a = new String[]{"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "snap", "截屏"};
        b = new ArrayList();
        c = new a();
    }

    public static final void a() {
        if ((System.currentTimeMillis() - d) < 1000) goto L51;
        boolean r3 = false;
        AoLogger.g("ScreenShotHelper", new Object[]{"handleContentObserverChange"});
        ContentResolver r1 = y54.a.a().getContentResolver();
        Uri r2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] r12 = {"_data", "date_added"};
        f06.c r16 = new f06.c();
        Object[] r11 = {r2, r12, null, null, "date_modified desc"};
        f06.b r17 = new f06.b();
        f06.d r13 = r16.b(240004, "android/content/ContentResolver", "query", r1, r11, "android.database.Cursor", r17);
        if (r13.a == false) goto L8;
        r16.a(240004, "android/content/ContentResolver", "query", r1, r11, null, r17, false);
        Cursor r4 = (Cursor) r13.b;
    L9:
        if (r4 == null) goto L42;
        Cursor r5 = r4;
        Cursor r6 = r5;     // Catch: Throwable -> L36
        if (r6.moveToFirst() == false) goto L34;
        String r7 = r6.getString(r6.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L36
        if (r7 == null) goto L16;
        String r9 = r7.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L36
    L17:
        long r8 = System.currentTimeMillis() - (r6.getLong(r6.getColumnIndexOrThrow("date_added")) * ((long) ECDraweeView.SQUARE));     // Catch: Throwable -> L36
        if (h0.a(r9) == false) goto L34;
        if (r8 <= 0) goto L34;
        if (r8 >= DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS) goto L34;
        String[] r10 = a;     // Catch: Throwable -> L36
        int r14 = r10.length;     // Catch: Throwable -> L36
        int r15 = 0;
    L24:
        if (r15 >= r14) goto L29;
        if (StringsKt.contains$default(r9, r10[r15], false, 2, null) == true) goto L27;
        r15 = r15 + 1;     // Catch: Throwable -> L36
        goto L24
    L27:
        r3 = true;
    L29:
        if (r3 == false) goto L34;
        d = System.currentTimeMillis();     // Catch: Throwable -> L36
        Iterator<z> r18 = b.iterator();     // Catch: Throwable -> L36
    L32:
        if (r18.hasNext() == false) goto L34;
        r18.next().M00(r9);     // Catch: Throwable -> L36
        goto L32
    L16:
        r9 = null;
    L34:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r5, null);
        return;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L42:
        return;
    L8:
        Cursor r20 = r1.query(r2, r12, null, null, "date_modified desc");
        r16.a(240004, "android/content/ContentResolver", "query", r1, r11, r20, r17, true);
        r4 = r20;
        goto L9
    }

    public static void b(Context r5, z r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "listener");
        ArrayList<z> r0 = b;
        if (r0.contains(r6) == false) goto L5;
        return;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 33) goto L8;
    L10:
        int r2 = ContextCompat.checkSelfPermission(r5, "android.permission.READ_EXTERNAL_STORAGE");
    L12:
        if (r2 != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == true) goto L18;
        return;
    L18:
        if (r0.isEmpty() == true) goto L29;
    L27:
        b.add(r6);
        return;
    L29:
        ContentResolver r7 = r5.getApplicationContext().getContentResolver();     // Catch: Exception -> L25
        Uri r4 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L25
        if (r1 <= 28) goto L22;
        boolean r8 = true;
    L23:
        r7.registerContentObserver(r4, r8, c);     // Catch: Exception -> L25
        goto L27
    L22:
        r8 = false;
    L25:
        e = move-exception;
        AoLogger.c("ScreenShotHelper", new Object[]{"registerScreenShotObserver error:" + e.getMessage()});
        goto L27
    L14:
        r3 = false;
        goto L15
    L8:
        if (r5.getApplicationInfo().targetSdkVersion < 33) goto L10;
        r2 = ContextCompat.checkSelfPermission(r5, "android.permission.READ_MEDIA_IMAGES");
        goto L12
    }

    public static void c(Context r2, z r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "listener");
        ArrayList<z> r0 = b;
        r0.remove(r3);
        if (r0.isEmpty() == false) goto L11;
        r2.getApplicationContext().getContentResolver().unregisterContentObserver(c);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        AoLogger.c("ScreenShotHelper", new Object[]{"unRegisterScreenShotObserver error:" + e.getMessage()});
        return;
    }
}
