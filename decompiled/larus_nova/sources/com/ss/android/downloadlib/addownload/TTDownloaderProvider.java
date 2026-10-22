package com.ss.android.downloadlib.addownload;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;

/* JADX INFO: loaded from: classes5.dex */
public class TTDownloaderProvider extends ContentProvider {
    private static final String TAG = "DownloadClickIdManager";
    private TTDownloaderClickIdDBHelper dbHelper;
    private boolean isInit;

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (this.dbHelper == null) goto L5;
        return true;
    L5:
        if (this.isInit == true) goto L10;
        DownloadComponentManager.getInstance().submitScheduledTask(new AnonymousClass1(this), 10000);
        return true;
    L10:
        return true;
    }

    public TTDownloaderProvider() {
        this.isInit = false;
    }

    public static /* synthetic */ TTDownloaderClickIdDBHelper access$002(TTDownloaderProvider r100, TTDownloaderClickIdDBHelper r101) {
        r100.dbHelper = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(TTDownloaderProvider r100, boolean r101) {
        r100.isInit = r101;
        return r101;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        TTDownloaderClickIdDBHelper r102 = this.dbHelper;
        if (r102 != null) goto L9;
    L8:
        return null;
    L9:
        return ContentUris.withAppendedId(r100, r102.getWritableDatabase().insert(TTDownloaderClickIdDBHelper.CLICK_ID_TABLE_NAME, null, r101));
    L6:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(false, e, "insert database error");
        goto L8
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        TTDownloaderClickIdDBHelper r103 = this.dbHelper;
        if (r103 != null) goto L5;
        return Integer.MIN_VALUE;
    L5:
        return r103.getWritableDatabase().delete(TTDownloaderClickIdDBHelper.CLICK_ID_TABLE_NAME, r101, r102);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        TTDownloaderClickIdDBHelper r104 = this.dbHelper;
        if (r104 != null) goto L5;
        return Integer.MIN_VALUE;
    L5:
        return r104.getWritableDatabase().update(TTDownloaderClickIdDBHelper.CLICK_ID_TABLE_NAME, r101, r102, r103);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r110, String[] r111, String r112, String[] r113, String r114) {
        TTDownloaderClickIdDBHelper r115 = this.dbHelper;
        if (r115 == null) goto L12;
        return r115.getWritableDatabase().query(TTDownloaderClickIdDBHelper.CLICK_ID_TABLE_NAME, r111, r112, r113, null, null, r114, null);
    L6:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(false, e, "query database error");
        return null;
    L12:
        return null;
    }
}
