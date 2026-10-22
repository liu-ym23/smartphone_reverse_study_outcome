package com.bytedance.mira.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mira.log.MiraLogger;

/* JADX INFO: loaded from: classes21.dex */
public class MiraDefaultProvider extends ContentProvider {
    private static final String TAG = "MiraDefaultContentProvider";

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "MiraDefaultContentProvider onCreate");
        return false;
    }

    public MiraDefaultProvider() {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "MiraDefaultContentProvider getType, uri = " + r100);
        return "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "MiraDefaultContentProvider insert, uri = " + r100);
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "MiraDefaultContentProvider call");
        return super.call(r100, r101, r102);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "MiraDefaultContentProvider delete, uri = " + r100);
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "MiraDefaultContentProvider update, uri = " + r100);
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        MiraLogger.i(MiraLogger.TAG_PROVIDER, "MiraDefaultContentProvider query, uri = " + r100);
        return null;
    }
}
