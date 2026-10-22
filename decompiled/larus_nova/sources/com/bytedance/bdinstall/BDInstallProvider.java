package com.bytedance.bdinstall;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes.dex */
public class BDInstallProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f199588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static UriMatcher f199589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Uri f199590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f199591d;

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (f199589b != null) goto L21;
        b(getContext());     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L21:
        Context r100 = getContext();     // Catch: Throwable -> L15
        String r101 = c1.f199627a;     // Catch: Throwable -> L15
        if ((r100 instanceof Application) == true) goto L13;
        if (r100 == null) goto L13;
        r100 = r100.getApplicationContext();     // Catch: Throwable -> L15
    L13:
        ((Application) r100).registerActivityLifecycleCallbacks(i.f199651a);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public BDInstallProvider() {
        c1.f199628b = Boolean.TRUE;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static synchronized Uri a(Context r100) {
        monitor-enter(BDInstallProvider.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f199590c == null) goto L19;
    L13:
        Uri r101 = f199590c.buildUpon().appendPath("install_info_change").build();     // Catch: Throwable -> L16
        monitor-exit(BDInstallProvider.class);
        return r101;
    L19:
        b(r100);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        return null;
    }

    public static void b(Context r100) throws IllegalStateException {
        if (TextUtils.isEmpty(f199588a) == false) goto L21;
        String r101 = BDInstallProvider.class.getName();
        if (r100 != null) goto L26;
        String r102 = null;
    L19:
        f199588a = r102;
        goto L21
    L26:
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        r102 = r100.getPackageName() + ".bdinstall.provider";
        goto L19
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        ProviderInfo[] r103 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 8).providers;     // Catch: Exception -> L16
        int r104 = r103.length;     // Catch: Exception -> L16
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L18;
        ProviderInfo r106 = r103[r105];     // Catch: Exception -> L16
        if (r101.equals(r106.name) == true) goto L13;
        r105 = r105 + 1;
        goto L10
    L13:
        r102 = r106.authority;     // Catch: Exception -> L16
    L21:
        if (TextUtils.isEmpty(f199588a) == true) goto L25;
        UriMatcher r107 = new UriMatcher(-1);
        f199589b = r107;
        r107.addURI(f199588a, "*/*", 65536);
        f199590c = UriProtector.parse("content://" + f199588a);
        return;
    L25:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return "vnd.android.cursor.item/vnd." + f199588a + ".item";
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r100, ProviderInfo r101) {
        f199591d = r100;
        if (r101 == null) goto L5;
        f199588a = r101.authority;
    L5:
        c1.f199628b = Boolean.TRUE;
        super.attachInfo(r100, r101);
    }
}
