package com.bytedance.mira.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.mira.Mira;

/* JADX INFO: loaded from: classes.dex */
public abstract class BinderProvider extends ContentProvider {
    private static final String BUNDLE_BINDER = "binder";
    private static final String METHOD_QUERY_BINDER = "query_binder";

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

    public abstract IBinder onBind();

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    public BinderProvider() {
    }

    public static IBinder queryBinder(Context r100, Uri r101) {
        Bundle r102 = r100.getContentResolver().call(r101, METHOD_QUERY_BINDER, null, null);
        if (r102 == null) goto L8;
        r102.setClassLoader(Mira.getAppContext().getClassLoader());
        BinderParcel r103 = (BinderParcel) r102.getParcelable(BUNDLE_BINDER);
        if (r103 == null) goto L8;
        return r103.getBinder();
    L8:
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        if (METHOD_QUERY_BINDER.equals(r100) == false) goto L8;
        IBinder r103 = onBind();
        if (r103 == null) goto L10;
        Bundle r104 = new Bundle();
        r104.putParcelable(BUNDLE_BINDER, new BinderParcel(r103));
        return r104;
    L10:
        return null;
    L8:
        return null;
    }
}
