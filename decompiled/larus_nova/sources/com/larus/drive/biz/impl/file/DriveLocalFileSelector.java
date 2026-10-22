package com.larus.drive.biz.impl.file;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.drive.biz.impl.activity.DriveFileSelectProxyActivity;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.service.i2;
import com.larus.platform.service.n0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes27.dex */
public final class DriveLocalFileSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DriveLocalFileSelector f341191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<u> f341192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f341193c;

    static {
        f341191a = new DriveLocalFileSelector();
    }

    public DriveLocalFileSelector() {
    }

    public static Activity e() {
        AppHost.Companion r100 = AppHost.f326268a;
        Activity r101 = r100.a().getCurrentActivity();
        if ((r101 instanceof DriveFileSelectProxyActivity) == false) goto L6;
        FLogger r102 = FLogger.f375446a;
        r102.i("DriveLocalFileSelector", "getRealTopActivity: result is DriveFileSelectProxyActivity[" + r101 + ']');
        Activity r103 = r100.a().a(r101, null);
        r102.i("DriveLocalFileSelector", "getRealTopActivity: real result is DriveFileSelectProxyActivity[" + r103 + ']');
        return r103;
    L6:
        return r101;
    }

    public static void h(u r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        WeakReference<u> r101 = f341192b;
        if (r101 == null) goto L5;
        u r102 = r101.get();
    L7:
        if (Intrinsics.areEqual(r102, r100) == true) goto L9;
        return;
    L9:
        f341192b = null;
        return;
    L5:
        r102 = null;
        goto L7
    }

    public static void b(Fragment r100, Function0 r101) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), Dispatchers.getIO(), null, new DriveLocalFileSelector$checkStorageBeforeUpload$1(r100, r101, null), 2, null);
    }

    public static void d(Fragment r100, final Function0 r101) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        List r102 = CollectionsKt.mutableListOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
        i2 r103 = i2.f365748b;
        i2.q(r100, r102, new h(r101));
        return;
    L5:
        r101.invoke();
    }

    public static Pair g(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Cursor r102 = c(r100.getContentResolver(), r101, new String[]{"_display_name"});     // Catch: Throwable -> L22
        if (r102 == null) goto L31;
        Cursor r103 = r102;     // Catch: Throwable -> L22
        Cursor r104 = r103;     // Catch: Throwable -> L15
        int r105 = r104.getColumnIndex("_display_name");     // Catch: Throwable -> L15
        if (r105 >= 0) goto L9;
    L11:
        String r106 = null;
    L12:
        Pair r107 = new Pair(Boolean.TRUE, r106);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r103, null);     // Catch: Throwable -> L22
        return r107;
    L9:
        if (r104.moveToFirst() == false) goto L11;
        r106 = r104.getString(r105);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L31:
        return new Pair(Boolean.FALSE, null);
    L22:
        th = move-exception;
        FLogger.f375446a.e("DriveLocalFileSelector", "queryDisplayName failed", th);
        return new Pair(Boolean.FALSE, null);
    }

    public static Cursor c(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }

    public static final void a(DriveLocalFileSelector r110, final Context r111, List r112, int r113, u r114) {
        r110.getClass();
        List r115 = r112;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator r116 = r115.iterator();
    L4:
        if (r116.hasNext() == false) goto L73;
        Uri r101 = (Uri) r116.next();
        if (n0.f365775a.b() == true) goto L72;
        f341191a.getClass();
        Long r102 = null;
        String r103 = r101.getScheme();     // Catch: Throwable -> L66
        if (r103 == null) goto L11;
        String r104 = r103.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L66
    L13:
        if (Intrinsics.areEqual(r104, "content") == false) goto L47;
        Cursor r105 = c(r111.getContentResolver(), r101, new String[]{"_size"});     // Catch: Throwable -> L66
        if (r105 == null) goto L31;
        Cursor r106 = r105;     // Catch: Throwable -> L66
        Cursor r107 = r106;     // Catch: Throwable -> L26
        int r108 = r107.getColumnIndex("_size");     // Catch: Throwable -> L26
        if (r108 >= 0) goto L20;
    L23:
        Long r109 = null;
    L24:
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L66
    L32:
        if (r109 != null) goto L34;
    L36:
        AssetFileDescriptor r117 = ContentResolverWrapper.openAssetFileDescriptor(r111.getContentResolver(), r101, "r");     // Catch: Throwable -> L66
        if (r117 != null) goto L80;
    L68:
        if (r102 == null) goto L72;
        if (r102.longValue() <= 314572800) goto L72;
        FLogger.f375446a.i("DriveLocalFileSelector", "reject due to large file size: size[" + r102 + ']');
        new Handler(Looper.getMainLooper()).postDelayed(new a(r111), 500);
        r114.b(new Throwable("reject due to large file size: size[" + r102 + ']'));
        return;
    L80:
        Long r118 = Long.valueOf(r117.getLength());     // Catch: Throwable -> L41
        CloseableKt.closeFinally(r117, null);     // Catch: Throwable -> L66
        r102 = r118;
        goto L68
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        CloseableKt.closeFinally(r117, th);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L34:
        if (r109.longValue() < 0) goto L36;
    L65:
        r102 = r109;
        goto L68
    L20:
        if (r107.moveToFirst() == false) goto L23;
        r109 = Long.valueOf(r107.getLong(r108));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L31:
        r109 = null;
        goto L32
    L47:
        if (Intrinsics.areEqual(r104, "file") == false) goto L68;
        String r119 = r101.getPath();     // Catch: Throwable -> L66
        if (r119 != null) goto L51;
    L54:
        boolean r120 = true;
    L55:
        if (r120 == true) goto L68;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L59
        Object r122 = Result.m9449constructorimpl(Long.valueOf(new PolarisFileWrapper(r119).length()));     // Catch: Throwable -> L59
    L62:
        if (Result.m9455isFailureimpl(r122) == false) goto L64;
        r122 = null;
    L64:
        r109 = (Long) r122;     // Catch: Throwable -> L66
    L59:
        th = move-exception;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L66
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L66
        goto L62
    L51:
        if (r119.length() == 0) goto L54;
        r120 = false;
        goto L55
    L11:
        r104 = null;
    L66:
        th = move-exception;
        FLogger.f375446a.e("DriveLocalFileSelector", "queryFileSize failed", th);
    L72:
        f341191a.getClass();
        Pair r124 = g(r111, r101);
        r100.add(new i(r101, (String) r124.getSecond(), r111.getContentResolver().getType(r101), !((Boolean) r124.getFirst()).booleanValue()));
        goto L4
    L73:
        switch(r113) {
            case 41701: goto L76;
            case 41702: goto L75;
            default: goto L74;
        };
    L74:
        String r125 = "unknown";
    L77:
        r114.c(r125, r100);
        return;
    L75:
        r125 = "upload_file";
        goto L77
    L76:
        r125 = "upload_pic";
        goto L77
    }

    public static void f(Activity r100, int r101, int r110, Intent r111, long r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (r112 == f341193c) goto L5;
        return;
    L5:
        WeakReference<u> r113 = f341192b;
        if (r113 == null) goto L87;
        u r114 = r113.get();
        if (r114 != null) goto L11;
        return;
    L11:
        if (r101 == 41701) goto L16;
        if (r101 == 41702) goto L16;
        return;
    L16:
        if (r110 == (-1)) goto L72;
        r114.a();
        return;
    L72:
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L69
        if (r111 == null) goto L21;
        ArrayList r103 = r111.getParcelableArrayListExtra("result.uri.list");     // Catch: Throwable -> L69
    L23:
        if (r103 != null) goto L25;
    L33:
        if (r111 == null) goto L35;
        Uri r104 = r111.getData();     // Catch: Throwable -> L69
    L36:
        if (r111 == null) goto L38;
        ClipData r115 = r111.getClipData();     // Catch: Throwable -> L69
    L39:
        if (r115 == null) goto L50;
        int r105 = r115.getItemCount();     // Catch: Throwable -> L69
        int r106 = 0;
    L41:
        if (r106 >= r105) goto L50;
        ClipData.Item r107 = r115.getItemAt(r106);     // Catch: Throwable -> L69
        if (r107 == null) goto L45;
        Uri r108 = r107.getUri();     // Catch: Throwable -> L69
    L46:
        if (r108 == null) goto L48;
        r102.add(r108);     // Catch: Throwable -> L69
    L48:
        r106 = r106 + 1;     // Catch: Throwable -> L69
        goto L41
    L45:
        r108 = null;
    L50:
        if (r102.isEmpty() == false) goto L54;
        if (r104 == null) goto L54;
        r102.add(r104);     // Catch: Throwable -> L69
    L54:
        if (r102.isEmpty() == false) goto L56;
        r114.b(new IllegalStateException("No uri returned by picker"));     // Catch: Throwable -> L69
        return;
    L56:
        Lazy r116 = t.f341214a;     // Catch: Throwable -> L69
        if (t.h(r102.size()) == true) goto L59;
        new Handler(Looper.getMainLooper()).postDelayed(new b(), 500);     // Catch: Throwable -> L69
        return;
    L59:
        Iterator r117 = r102.iterator();     // Catch: Throwable -> L69
    L61:
        if (r117.hasNext() == false) goto L67;
        r100.getContentResolver().takePersistableUriPermission((Uri) r117.next(), 1);     // Catch: SecurityException -> L65 Throwable -> L69
    L65:
        e = move-exception;
        FLogger.f375446a.e("DriveLocalFileSelector", "takePersistableUriPermission failed", e);     // Catch: Throwable -> L69
        goto L61
    L67:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DriveLocalFileSelector$handleResult$4(r100, r102, r101, r114, null), 2, null);     // Catch: Throwable -> L69
        return;
    L38:
        r115 = null;
        goto L39
    L35:
        r104 = null;
        goto L36
    L25:
        if ((!r103.isEmpty()) == false) goto L33;
        ArrayList r118 = new ArrayList();     // Catch: Throwable -> L69
        Iterator r119 = r103.iterator();     // Catch: Throwable -> L69
    L28:
        if (r119.hasNext() == false) goto L32;
        Uri r109 = ((AlbumSelectItem) r119.next()).f365506a;     // Catch: Throwable -> L69
        if (r109 == null) goto L28;
        r118.add(r109);     // Catch: Throwable -> L69
        goto L28
    L32:
        r102.addAll(r118);     // Catch: Throwable -> L69
        goto L54
    L21:
        r103 = null;
    L69:
        th = move-exception;
        FLogger.f375446a.e("DriveLocalFileSelector", "handleResult failed", th);
        r114.b(th);
        return;
    }
}
