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
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f197682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<z> f197683b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f197684c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f197685d;

    public static final class a extends ContentObserver {
        public a() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
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
        f197682a = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "snap", "截屏"};
        f197683b = new ArrayList();
        f197684c = new a();
    }

    public static final void a() {
        if ((System.currentTimeMillis() - f197685d) < 1000) goto L51;
        boolean r100 = false;
        AoLogger.g("ScreenShotHelper", new Object[]{"handleContentObserverChange"});
        ContentResolver r101 = y54.a.a().getContentResolver();
        Uri r102 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] r110 = {"_data", "date_added"};
        f06.c r111 = new f06.c();
        Object[] r112 = {r102, r110, null, null, "date_modified desc"};
        f06.b r113 = new f06.b();
        f06.d r114 = r111.b(240004, "android/content/ContentResolver", "query", r101, r112, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L8;
        r111.a(240004, "android/content/ContentResolver", "query", r101, r112, null, r113, false);
        Cursor r103 = (Cursor) r114.f474983b;
    L9:
        if (r103 == null) goto L42;
        Cursor r104 = r103;
        Cursor r105 = r104;     // Catch: Throwable -> L36
        if (r105.moveToFirst() == false) goto L34;
        String r106 = r105.getString(r105.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L36
        if (r106 == null) goto L16;
        String r107 = r106.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L36
    L17:
        long r108 = System.currentTimeMillis() - (r105.getLong(r105.getColumnIndexOrThrow("date_added")) * ((long) 1000));     // Catch: Throwable -> L36
        if (h0.a(r107) == false) goto L34;
        if (r108 <= 0) goto L34;
        if (r108 >= 10000) goto L34;
        String[] r109 = f197682a;     // Catch: Throwable -> L36
        int r115 = r109.length;     // Catch: Throwable -> L36
        int r116 = 0;
    L24:
        if (r116 >= r115) goto L29;
        if (StringsKt.contains$default(r107, r109[r116], false, 2, null) == true) goto L27;
        r116 = r116 + 1;     // Catch: Throwable -> L36
        goto L24
    L27:
        r100 = true;
    L29:
        if (r100 == false) goto L34;
        f197685d = System.currentTimeMillis();     // Catch: Throwable -> L36
        Iterator<z> r117 = f197683b.iterator();     // Catch: Throwable -> L36
    L32:
        if (r117.hasNext() == false) goto L34;
        r117.next().M00(r107);     // Catch: Throwable -> L36
        goto L32
    L16:
        r107 = null;
    L34:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r104, null);
        return;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L42:
        return;
    L8:
        Cursor r119 = r101.query(r102, r110, null, null, "date_modified desc");
        r111.a(240004, "android/content/ContentResolver", "query", r101, r112, r119, r113, true);
        r103 = r119;
        goto L9
    }

    public static void b(Context r100, z r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        ArrayList<z> r102 = f197683b;
        if (r102.contains(r101) == false) goto L5;
        return;
    L5:
        int r103 = Build.VERSION.SDK_INT;
        if (r103 >= 33) goto L8;
    L10:
        int r104 = ContextCompat.checkSelfPermission(r100, "android.permission.READ_EXTERNAL_STORAGE");
    L12:
        if (r104 != 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L18;
        return;
    L18:
        if (r102.isEmpty() == true) goto L29;
    L27:
        f197683b.add(r101);
        return;
    L29:
        ContentResolver r106 = r100.getApplicationContext().getContentResolver();     // Catch: Exception -> L25
        Uri r107 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L25
        if (r103 <= 28) goto L22;
        boolean r108 = true;
    L23:
        r106.registerContentObserver(r107, r108, f197684c);     // Catch: Exception -> L25
        goto L27
    L22:
        r108 = false;
    L25:
        e = move-exception;
        AoLogger.c("ScreenShotHelper", new Object[]{"registerScreenShotObserver error:" + e.getMessage()});
        goto L27
    L14:
        r105 = false;
        goto L15
    L8:
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L10;
        r104 = ContextCompat.checkSelfPermission(r100, BaseConstants.PERMISSION_READ_MEDIA_IMAGES);
        goto L12
    }

    public static void c(Context r100, z r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        ArrayList<z> r102 = f197683b;
        r102.remove(r101);
        if (r102.isEmpty() == false) goto L11;
        r100.getApplicationContext().getContentResolver().unregisterContentObserver(f197684c);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        AoLogger.c("ScreenShotHelper", new Object[]{"unRegisterScreenShotObserver error:" + e.getMessage()});
        return;
    }
}
