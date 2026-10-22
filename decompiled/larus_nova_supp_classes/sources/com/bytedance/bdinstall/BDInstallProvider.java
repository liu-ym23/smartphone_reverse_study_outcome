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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class BDInstallProvider extends ContentProvider {
    public static String a;
    public static UriMatcher b;
    public static Uri c;
    public static Context d;

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (b != null) goto L21;
        b(getContext());     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L21:
        Context r0 = getContext();     // Catch: Throwable -> L15
        String r1 = c1.a;     // Catch: Throwable -> L15
        if ((r0 instanceof Application) == true) goto L13;
        if (r0 == null) goto L13;
        r0 = r0.getApplicationContext();     // Catch: Throwable -> L15
    L13:
        ((Application) r0).registerActivityLifecycleCallbacks(i.a);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public BDInstallProvider() {
        c1.b = Boolean.TRUE;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static synchronized Uri a(Context r3) {
        monitor-enter(BDInstallProvider.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (c == null) goto L19;
    L13:
        Uri r4 = c.buildUpon().appendPath("install_info_change").build();     // Catch: Throwable -> L16
        monitor-exit(BDInstallProvider.class);
        return r4;
    L19:
        b(r3);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        return null;
    }

    public static void b(Context r6) throws IllegalStateException {
        if (TextUtils.isEmpty(a) == false) goto L21;
        String r0 = BDInstallProvider.class.getName();
        if (r6 != null) goto L26;
        String r7 = null;
    L19:
        a = r7;
        goto L21
    L26:
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        r7 = r6.getPackageName() + ".bdinstall.provider";
        goto L19
    L8:
        if (TextUtils.isEmpty(r0) == true) goto L18;
        ProviderInfo[] r1 = r6.getPackageManager().getPackageInfo(r6.getPackageName(), 8).providers;     // Catch: Exception -> L16
        int r2 = r1.length;     // Catch: Exception -> L16
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L18;
        ProviderInfo r4 = r1[r3];     // Catch: Exception -> L16
        if (r0.equals(r4.name) == true) goto L13;
        r3 = r3 + 1;
        goto L10
    L13:
        r7 = r4.authority;     // Catch: Exception -> L16
    L21:
        if (TextUtils.isEmpty(a) == true) goto L25;
        UriMatcher r8 = new UriMatcher(-1);
        b = r8;
        r8.addURI(a, "*/*", 65536);
        c = UriProtector.parse("content://" + a);
        return;
    L25:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        return "vnd.android.cursor.item/vnd." + a + ".item";
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r2, ProviderInfo r3) {
        d = r2;
        if (r3 == null) goto L5;
        a = r3.authority;
    L5:
        c1.b = Boolean.TRUE;
        super.attachInfo(r2, r3);
    }
}
