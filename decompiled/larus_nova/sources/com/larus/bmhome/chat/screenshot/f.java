package com.larus.bmhome.chat.screenshot;

import android.content.ContentUris;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.camera.core.RetryPolicy;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.huawei.hms.android.SystemUtils;
import com.larus.bmhome.chat.component.bottom.multimodal.latest.c0;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public class f extends ContentObserver {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f308584e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f308585f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f308586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f308587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f308588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f308589d;

    public static final class a {
        public static boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            String r101 = r100.toLowerCase(Locale.ROOT);
            FLogger.f375446a.d("ScreenCaptureUtils", "checkPath: ".concat(r100));
            String[] r102 = f.f308585f;
            int r103 = r102.length;
            int r104 = 0;
        L4:
            if (r104 >= r103) goto L9;
            if (StringsKt.contains$default(r101, r102[r104], false, 2, null) == true) goto L7;
            r104 = r104 + 1;
            goto L4
        L7:
            return true;
        L9:
            String r105 = Build.MANUFACTURER;
            if (r105 != null) goto L12;
        L14:
            boolean r106 = false;
        L15:
            if (r106 == true) goto L17;
        L24:
            return false;
        L17:
            if (StringsKt.contains$default(r100, "/dcim/camera/", false, 2, null) == false) goto L24;
            String[] r107 = f.f308584e;
            int r108 = r107.length;
            int r109 = 0;
        L19:
            if (r109 >= r108) goto L24;
            if (StringsKt.contains$default(r101, r107[r109], false, 2, null) == true) goto L22;
            r109 = r109 + 1;
            goto L19
        L22:
            return true;
        L12:
            if (StringsKt.contains$default(r105.toUpperCase(Locale.getDefault()), SystemUtils.PRODUCT_HUAWEI, false, 2, null) == false) goto L14;
            r106 = true;
            goto L15
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.larus.bmhome.chat.screenshot.b) r101).f308581a), Long.valueOf(((com.larus.bmhome.chat.screenshot.b) r100).f308581a));
        }
    }

    static {
        f308584e = new String[]{"tmp.png"};
        f308585f = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    }

    public void b() {
        f r100 = this;
        r100.f308588c = System.currentTimeMillis();
        Context r101 = r100.f308587b.get();
        if (r101 != null) goto L5;
        return;
    L5:
        String[] r102 = com.larus.bmhome.chat.screenshot.a.f308579a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("date_added", "sortOrder");
        ArrayList r103 = new ArrayList();
        Uri r104 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        int r105 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L73
        if (r105 < 30) goto L10;
        boolean r106 = true;
    L11:
        String[] r107 = com.larus.bmhome.chat.screenshot.a.f308579a;
        if (r106 == false) goto L15;
        Cursor r108 = com.larus.bmhome.chat.screenshot.a.a(r101.getContentResolver(), r104, r107, com.larus.bmhome.chat.screenshot.a.c());     // Catch: Throwable -> L73
    L14:
        Cursor r109 = r108;
        if (r109 != null) goto L84;
        ArrayList r110 = r103;
    L60:
        FLogger.f375446a.i("ScreenCaptureUtils", "onUserCaptureScreen ScreenCaptureObserver.onChange，imageCount=" + this.f308589d + ", images.size=" + r110.size());
        if (this.f308589d < r110.size()) goto L64;
        this.f308589d = r110.size();
        return;
    L64:
        this.f308589d = r110.size();
        com.larus.bmhome.chat.screenshot.b r111 = (com.larus.bmhome.chat.screenshot.b) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(r110, new b()));
        if (r111 != null) goto L67;
        return;
    L67:
        String r112 = r111.f308583c;
        if (r112 == null) goto L88;
        a(r112, r111.f308581a, r111.f308582b);
        return;
    L88:
        return;
    L84:
        int r113 = r109.getColumnIndexOrThrow(DBDefinition.ID);     // Catch: Throwable -> L71
        int r114 = r109.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L71
        int r115 = r109.getColumnIndexOrThrow("date_modified");     // Catch: Throwable -> L71
        int r116 = r109.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L71
        int r117 = r109.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L71
        int r118 = r109.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L71
        int r119 = r109.getColumnIndexOrThrow("width");     // Catch: Throwable -> L71
        int r120 = r109.getColumnIndexOrThrow("height");     // Catch: Throwable -> L71
        if (r105 < 29) goto L27;
        boolean r121 = true;
    L28:
        if (r121 == false) goto L30;
        int r122 = r109.getColumnIndexOrThrow(LynxEventReporter.PROP_NAME_RELATIVE_PATH);     // Catch: Throwable -> L71
    L31:
        int r123 = r109.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L71
        int r124 = (Environment.getExternalStorageDirectory().getPath() + '/').length();     // Catch: Throwable -> L71
    L32:
        if (r109.moveToNext() == false) goto L59;
        com.larus.bmhome.chat.screenshot.b r125 = new com.larus.bmhome.chat.screenshot.b();     // Catch: Throwable -> L57
        ArrayList r126 = r103;
        long r127 = r109.getLong(r113);     // Catch: Throwable -> L57
        r109.getString(r114);     // Catch: Throwable -> L57
        r109.getLong(r115);     // Catch: Throwable -> L57
        int r128 = r113;
        r125.f308581a = r109.getLong(r116);     // Catch: Throwable -> L57
        r109.getString(r117);     // Catch: Throwable -> L57
        r109.getLong(r118);     // Catch: Throwable -> L57
        r109.getInt(r119);     // Catch: Throwable -> L57
        r109.getInt(r120);     // Catch: Throwable -> L57
        if (Build.VERSION.SDK_INT < 29) goto L38;
        boolean r129 = true;
    L40:
        if (r129 == false) goto L51;
        String r130 = r109.getString(r122);     // Catch: Throwable -> L57
        if (r130 != null) goto L48;
        String r131 = r109.getString(r123);     // Catch: Throwable -> L57
        Intrinsics.checkNotNull(r131);     // Catch: Throwable -> L57
        String r132 = File.separator;     // Catch: Throwable -> L57
        int r210 = r116;
        int r211 = r122;
        String r133 = r131.substring(r124, StringsKt.lastIndexOf$default(r131, r132, 0, false, 6, null)) + r132;     // Catch: IndexOutOfBoundsException -> L47 Throwable -> L57
    L50:
        r125.f308583c = r133;     // Catch: Throwable -> L57
    L55:
        r125.f308582b = ContentUris.withAppendedId(r104, r127);     // Catch: Throwable -> L57
        r126.add(r125);     // Catch: Throwable -> L57
        r100 = this;
        r103 = r126;
        r113 = r128;
        r122 = r211;
        r116 = r210;
        goto L32
    L47:
        r125.f308583c = "";     // Catch: Throwable -> L57
    L49:
        r133 = r130;
        goto L50
    L48:
        r210 = r116;
        r211 = r122;
        goto L49
    L51:
        r210 = r116;
        r211 = r122;
        String r134 = r109.getString(r123);     // Catch: Throwable -> L57
        Intrinsics.checkNotNull(r134);     // Catch: Throwable -> L57
        String r135 = File.separator;     // Catch: Throwable -> L57
        r125.f308583c = r134.substring(r124, StringsKt.lastIndexOf$default(r134, r135, 0, false, 6, null)) + r135;     // Catch: IndexOutOfBoundsException -> L54 Throwable -> L57
    L54:
        r125.f308583c = "";     // Catch: Throwable -> L57
        goto L55
    L38:
        r129 = false;
    L57:
        th = th;
    L75:
        if (r109 == null) goto L77;
        r109.close();
    L77:
        throw th;
    L59:
        r110 = r103;
        r109.close();
        goto L60
    L30:
        r122 = 0;
        goto L31
    L27:
        r121 = false;
    L71:
        th = th;
        goto L75
    L15:
        if (r105 < 29) goto L17;
        boolean r136 = true;
    L18:
        if (r136 == false) goto L20;
        r108 = com.larus.bmhome.chat.screenshot.a.b(r101.getContentResolver(), r104, r107, "date_added");     // Catch: Throwable -> L73
        goto L14
    L20:
        r108 = com.larus.bmhome.chat.screenshot.a.b(r101.getContentResolver(), r104, com.larus.bmhome.chat.screenshot.a.f308580b, "date_added");     // Catch: Throwable -> L73
        goto L14
    L17:
        r136 = false;
        goto L18
    L10:
        r106 = false;
    L73:
        th = th;
        r109 = null;
        goto L75
    }

    public final WeakReference<Context> getContext() {
        return this.f308587b;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100) {
        super.onChange(r100);
        if (AppHost.f326268a.a().isAppBackground() == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 33) goto L8;
        String r101 = "android.permission.READ_EXTERNAL_STORAGE";
    L9:
        Context r102 = this.f308587b.get();
        if (r102 != null) goto L13;
        return;
    L13:
        if (ContextCompat.checkSelfPermission(r102, r101) == 0) goto L15;
        return;
    L15:
        b();
        return;
    L8:
        r101 = BaseConstants.PERMISSION_READ_MEDIA_IMAGES;
        goto L9
    }

    public f(Uri r100, WeakReference r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(null);
        this.f308586a = r100;
        this.f308587b = r101;
        this.f308588c = Long.MIN_VALUE;
        this.f308589d = -1;
    }

    public final void a(String r100, long r101, Uri r110) {
        Intrinsics.checkNotNullParameter(r100, "relativePath");
        long r102 = this.f308588c - (((long) 1000) * r101);
        if (r102 >= RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS) goto L5;
        boolean r103 = true;
    L6:
        boolean r104 = a.a(r100);
        FLogger.f375446a.i("ScreenCaptureUtils", "onUserCaptureScreen ScreenCaptureObserver.dispatchScreenCapture, relativePath=" + r100 + ", dateAdded=" + r101 + ", interval=" + r102 + ", matchDateAdded=" + r103 + ", matchPath=" + r104 + ", uri=" + r110);
        if (r103 == false) goto L16;
        if (r104 == false) goto L22;
        CopyOnWriteArraySet<String> r105 = c0.f299862a;
        String r106 = String.valueOf(r110);
        Intrinsics.checkNotNullParameter(r106, "uriString");
        c0.f299863b.add(r106);
        Iterator<WeakReference<d>> r107 = i.f308592c.iterator();
    L12:
        if (r107.hasNext() == false) goto L23;
        d r108 = r107.next().get();
        if (r108 == null) goto L12;
        r108.a();
        goto L12
    L23:
        return;
    L22:
        return;
    L16:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
