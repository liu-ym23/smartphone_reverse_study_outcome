package com.miui.bugreport.logprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.feedback.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import w8a.a;

/* JADX INFO: loaded from: classes4.dex */
public class DumpLogProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PolarisFileWrapper f384375a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, File> f384376b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f384377c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f384378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Context f384379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<a> f384380f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile HashMap<String, File> f384381g;

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    static {
        f384375a = new PolarisFileWrapper(HTTP.URL_DEFAULT);
        f384376b = new HashMap();
        f384377c = new Object();
        f384378d = false;
        f384380f = new CopyOnWriteArrayList();
        f384381g = new HashMap();
    }

    public static void c() {
        if (f384378d == false) goto L5;
        return;
    L5:
        Object r100 = f384377c;
        monitor-enter(r100);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (f384378d == false) goto L11;
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L11:
        Context r101 = f384379e;     // Catch: Throwable -> L22
        if (r101 != null) goto L15;
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L15:
        e(r101, "com.miui.bugreport.DEFAULT_LOG_DIR");     // Catch: Throwable -> L22
        e(r101, "com.miui.bugreport.LOG_DIR");     // Catch: Throwable -> L22
        r101.getPackageName();     // Catch: Throwable -> L22
        HashMap<String, File> r102 = f384376b;     // Catch: Throwable -> L22
        r102.size();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, File>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L22
    L17:
        if (r103.hasNext() == false) goto L19;
        Map.Entry<String, File> r104 = r103.next();     // Catch: Throwable -> L22
        String r105 = r104.getKey();     // Catch: Throwable -> L22
        r104.getValue().getPath();     // Catch: Throwable -> L22
        goto L17
    L19:
        f384378d = true;     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r100 = getContext();
        if (r100 != null) goto L6;
        return false;
    L6:
        f384379e = r100.getApplicationContext();
        return true;
    }

    public DumpLogProvider() {
    }

    public static void a(e r100) {
        monitor-enter(DumpLogProvider.class);
        List<a> r101 = f384380f;     // Catch: Throwable -> L9
        if (((CopyOnWriteArrayList) r101).contains(r100) == true) goto L7;
        ((CopyOnWriteArrayList) r101).add(r100);     // Catch: Throwable -> L9
        ((CopyOnWriteArrayList) r101).size();     // Catch: Throwable -> L9
    L7:
        monitor-exit(DumpLogProvider.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
    L19:
        return false;
    L8:
        if (r101.canRead() == false) goto L19;
        if (r101.isFile() == false) goto L19;
        Iterator r102 = new HashMap(f384381g).entrySet().iterator();
    L14:
        if (r102.hasNext() == false) goto L19;
        if (r100.startsWith(((File) ((Map.Entry) r102.next()).getValue()).getPath()) == false) goto L14;
        return true;
    }

    public static void b(String r100, File r101) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return;
    L15:
        r101 = r101.getCanonicalFile();     // Catch: IOException -> L13
        Object r102 = f384377c;     // Catch: IOException -> L13
        monitor-enter(r102);     // Catch: IOException -> L13
        f384376b.put(r100, r101);     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
    L18:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: IOException -> L13
    L13:
        Objects.toString(r101);
    }

    public static void e(Context r100, String r101) {
        XmlResourceParser r102 = null;
        XmlResourceParser r103 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).loadXmlMetaData(r100.getPackageManager(), r101);     // Catch: Throwable -> L54 Exception -> L64
        if (r103 == null) goto L6;
    L9:
        int r104 = r103.next();     // Catch: Throwable -> L51 Exception -> L53
        if (r104 == 1) goto L50;
        if (r104 != 2) goto L9;
        String r105 = r103.getName();     // Catch: Throwable -> L51 Exception -> L53
        String r106 = r103.getAttributeValue(null, "name");     // Catch: Throwable -> L51 Exception -> L53
        String r107 = r103.getAttributeValue(null, "path");     // Catch: Throwable -> L51 Exception -> L53
        int r108 = 0;
        if ("root-path".equals(r105) == false) goto L17;
        File r109 = f384375a;     // Catch: Throwable -> L51 Exception -> L53
    L41:
        if (r109 == null) goto L9;
        String[] r110 = {r107};     // Catch: Throwable -> L51 Exception -> L53
    L43:
        if (r108 >= 1) goto L48;
        String r111 = r110[r108];     // Catch: Throwable -> L51 Exception -> L53
        if (r111 == null) goto L47;
        r109 = new PolarisFileWrapper(r109, r111);     // Catch: Throwable -> L51 Exception -> L53
    L47:
        r108 = r108 + 1;     // Catch: Throwable -> L51 Exception -> L53
        goto L43
    L48:
        b(r106, r109);     // Catch: Throwable -> L51 Exception -> L53
        goto L9
    L17:
        if ("files-path".equals(r105) == false) goto L20;
        r109 = r100.getFilesDir();     // Catch: Throwable -> L51 Exception -> L53
        goto L41
    L20:
        if ("cache-path".equals(r105) == false) goto L23;
        r109 = r100.getCacheDir();     // Catch: Throwable -> L51 Exception -> L53
        goto L41
    L23:
        if ("external-path".equals(r105) == false) goto L26;
        r109 = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L51 Exception -> L53
        goto L41
    L26:
        if ("external-files-path".equals(r105) == false) goto L31;
        File[] r112 = r100.getExternalFilesDirs(null);     // Catch: Throwable -> L51 Exception -> L53
        if (r112.length <= 0) goto L40;
        r109 = r112[0];     // Catch: Throwable -> L51 Exception -> L53
    L40:
        r109 = null;
        goto L41
    L31:
        if ("external-cache-path".equals(r105) == false) goto L36;
        File[] r113 = r100.getExternalCacheDirs();     // Catch: Throwable -> L51 Exception -> L53
        if (r113.length <= 0) goto L40;
        r109 = r113[0];     // Catch: Throwable -> L51 Exception -> L53
        goto L41
    L36:
        if ("external-media-path".equals(r105) == false) goto L40;
        File[] r114 = r100.getExternalMediaDirs();     // Catch: Throwable -> L51 Exception -> L53
        if (r114.length <= 0) goto L40;
        r109 = r114[0];     // Catch: Throwable -> L51 Exception -> L53
        goto L41
    L50:
        r103.close();
        return;
    L6:
        if (r103 == null) goto L79;
        r103.close();
        return;
    L79:
        return;
    L53:
        r102 = r103;
    L51:
        th = th;
    L61:
        if (r103 == null) goto L63;
        r103.close();
    L63:
        throw th;
    L54:
        th = th;
        r103 = r102;
    L56:
        if (r102 == null) goto L81;
        r102.close();
        return;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r100, String r101) throws FileNotFoundException {
        boolean r102 = false;
        if ((getContext().getPackageManager().getPackageInfo("com.miui.bugreport", 0).applicationInfo.flags & 1) == 0) goto L8;
        r102 = true;
    L8:
        if (r102 == true) goto L10;
        return null;
    L10:
        String r103 = UriProtector.parse(Uri.decode(r100.toString())).getPath();
        if (TextUtils.isEmpty(r103) == true) goto L20;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);     // Catch: IOException -> L18
        if (d(r104.getCanonicalPath()) == true) goto L17;
        return null;
    L17:
        return ParcelFileDescriptor.open(r104, 268435456);
    L18:
        return null;
    L20:
        throw new FileNotFoundException();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        boolean r105 = true;
        if ((getContext().getPackageManager().getPackageInfo("com.miui.bugreport", 0).applicationInfo.flags & 1) == 0) goto L7;
    L8:
        if (r105 == false) goto L66;
        if (Build.VERSION.SDK_INT < 23) goto L66;
        c();
        Object r106 = f384377c;
        monitor-enter(r106);
        HashMap<String, File> r107 = f384376b;     // Catch: Throwable -> L62
        HashMap<String, File> r108 = new HashMap(r107);     // Catch: Throwable -> L62
        r107.size();     // Catch: Throwable -> L62
        monitor-exit(r106);     // Catch: Throwable -> L62
        Iterator r109 = ((CopyOnWriteArrayList) f384380f).iterator();
    L18:
        if (r109.hasNext() == false) goto L36;
        a r110 = (a) r109.next();
        Map<String, File> r111 = r110.a();     // Catch: Exception -> L33 RuntimeException -> L34
        if (r111 == null) goto L18;
        Iterator<Map.Entry<String, File>> r112 = r111.entrySet().iterator();     // Catch: Exception -> L33 RuntimeException -> L34
    L25:
        if (r112.hasNext() == false) goto L18;
        Map.Entry<String, File> r113 = r112.next();     // Catch: Exception -> L33 RuntimeException -> L34
        String r114 = r113.getKey();     // Catch: Exception -> L33 RuntimeException -> L34
        File r115 = r113.getValue();     // Catch: Exception -> L33 RuntimeException -> L34
        if (TextUtils.isEmpty(r114) == true) goto L25;
        if (r115 == null) goto L25;
        r108.put(r114, r115.getCanonicalFile());     // Catch: IOException -> L31 Exception -> L33 RuntimeException -> L34
    L31:
        r108.put(r114, r115);     // Catch: Exception -> L33 RuntimeException -> L34
        goto L25
    L34:
        e = move-exception;
        r110.getClass();
        e.getMessage();
    L33:
        r110.getClass();
        goto L18
    L36:
        ((CopyOnWriteArrayList) f384380f).size();
        r108.size();
        f384381g = r108;
        LinkedList r116 = new LinkedList();
        ArrayList<String> r117 = new ArrayList();
        Iterator<Map.Entry<String, File>> r118 = r108.entrySet().iterator();
    L38:
        if (r118.hasNext() == false) goto L60;
        Map.Entry<String, File> r119 = r118.next();
        File r120 = r119.getValue();
        if (r120.exists() == false) goto L41;
        r116.offer(r120);
    L44:
        if (r116.size() == 0) goto L38;
        File r121 = (File) r116.poll();
        if (r121.isFile() == true) goto L47;
        File[] r122 = r121.listFiles();
        if (r122 == null) goto L50;
        int r123 = r122.length;
        int r124 = 0;
    L52:
        if (r124 >= r123) goto L44;
        File r125 = r122[r124];
        if (r125.isFile() == false) goto L57;
        r117.add(r125.getPath());
    L59:
        r124 = r124 + 1;
        goto L52
    L57:
        if (r125.isDirectory() == false) goto L59;
        r116.offer(r125);
        goto L59
    L50:
        r121.getPath();
        goto L44
    L47:
        r117.add(r121.getPath());
        goto L44
    L41:
        String r126 = r119.getKey();
        r120.getPath();
        goto L38
    L60:
        r117.size();
        MatrixCursor r127 = new MatrixCursor(new String[0]);
        Bundle r128 = new Bundle();
        r128.putStringArrayList("logDir", r117);
        r127.setExtras(r128);
        return r127;
    L62:
        th = move-exception;
        throw th;
    L66:
        return null;
    L7:
        r105 = false;
        goto L8
    }
}
