package com.larus.avlink.gallery;

import android.os.Environment;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f292493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f292494b = null;

    public e() {
    }

    public static void a() {
        Iterator r100 = CollectionsKt.listOf(new File[]{c(), g(), f(), e(), d(), new PolarisFileWrapper(b(), "failed")}).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        File r101 = (File) r100.next();
        if (r101.exists() == true) goto L4;
        r101.mkdirs();
        goto L4
    }

    static {
        f292493a = new e();
        f292494b = LazyKt.lazy(new d());
    }

    public static PolarisFileWrapper b() {
        return new PolarisFileWrapper(AppHost.f326268a.getApplication().getFilesDir(), m());
    }

    public static PolarisFileWrapper c() {
        return new PolarisFileWrapper(b(), "downloads");
    }

    public static PolarisFileWrapper d() {
        return new PolarisFileWrapper(b(), "final");
    }

    public static PolarisFileWrapper e() {
        return new PolarisFileWrapper(b(), "processed");
    }

    public static PolarisFileWrapper f() {
        return new PolarisFileWrapper(b(), "processing");
    }

    public static PolarisFileWrapper g() {
        return new PolarisFileWrapper(b(), "temp");
    }

    public static boolean i() {
        return ((Boolean) f292494b.getValue()).booleanValue();
    }

    public static String m() {
        String r100 = IApplog.f287053a.getUserID();
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length();
        boolean r103 = false;
        int r104 = 0;
    L3:
        boolean r105 = true;
        if (r104 >= r102) goto L16;
        char r106 = r100.charAt(r104);
        if (Character.isLetterOrDigit(r106) == false) goto L8;
    L13:
        if (r105 == false) goto L15;
        r101.append(r106);
    L15:
        r104 = r104 + 1;
        goto L3
    L8:
        if (r106 == '-') goto L13;
        if (r106 == '_') goto L13;
        r105 = false;
        goto L13
    L16:
        String r107 = r101.toString();
        if (r107.length() != 0) goto L19;
        r103 = true;
    L19:
        if (r103 == false) goto L22;
        r107 = "0";
    L22:
        return "doraG/".concat(r107);
    }

    public static String k() {
        if (i() == false) goto L6;
        return Environment.DIRECTORY_PICTURES + '/' + StringsKt.substringAfterLast$default(AppHost.f326268a.getApplication().getPackageName(), '.', null, 2, null) + "/files/" + m();
    L6:
        return Environment.DIRECTORY_DCIM + '/' + AppHost.f326268a.getApplication().getString(R.string.app_string_name);
    }

    public static String l() {
        if (i() == false) goto L6;
        return Environment.DIRECTORY_PICTURES + '/' + StringsKt.substringAfterLast$default(AppHost.f326268a.getApplication().getPackageName(), '.', null, 2, null) + "/files/doraG";
    L6:
        return k();
    }

    public static boolean h(String r100) {
        boolean r101 = true;
        String r102 = StringsKt.trim(l(), new char[]{'/'});
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return false;
    L8:
        if (r100 != null) goto L10;
    L12:
        r101 = false;
    L13:
        if (r101 == true) goto L15;
        FLogger.f375446a.w("GalleryPaths", "isDataUnderPublicAlbumRoot: MISS dataPath=" + r100 + ", root=" + r102);
    L15:
        return r101;
    L10:
        if (StringsKt.contains(r100, HTTP.URL_DEFAULT + r102 + '/', true) != true) goto L12;
    L5:
        r103 = false;
        goto L6
    }

    public static boolean j(String r100) {
        boolean r101 = true;
        String r102 = StringsKt.trimEnd(l(), new char[]{'/'});
        if (r100 != null) goto L6;
        FLogger.f375446a.w("GalleryPaths", "isUnderPublicAlbumRoot: relativePath is null, root=" + r102);
        return false;
    L6:
        String r103 = StringsKt.trimEnd(r100, new char[]{'/'});
        if (r102.length() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        FLogger.f375446a.w("GalleryPaths", "isUnderPublicAlbumRoot: root is empty, path=" + r103);
        return false;
    L13:
        boolean r105 = StringsKt.equals(r103, r102, true);
        if (i() == true) goto L16;
    L18:
        boolean r106 = false;
    L19:
        if (r105 == true) goto L24;
        if (r106 == true) goto L24;
        r101 = false;
    L24:
        if (r101 == false) goto L26;
        FLogger.f375446a.d("GalleryPaths", "isUnderPublicAlbumRoot: hit path=" + r103 + ", root=" + r102 + ", exact=" + r105 + ", underSub=" + r106);
    L27:
        return r101;
    L26:
        FLogger.f375446a.w("GalleryPaths", "isUnderPublicAlbumRoot: MISS path=" + r103 + ", root=" + r102 + ", obric=" + i() + " (判否会导致该媒体被视为移出相册)");
        goto L27
    L16:
        if (StringsKt.startsWith(r103, r102.concat(HTTP.URL_DEFAULT), true) == false) goto L18;
        r106 = true;
        goto L19
    L9:
        r104 = false;
        goto L10
    }
}
