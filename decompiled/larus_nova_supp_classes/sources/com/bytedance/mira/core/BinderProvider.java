package com.bytedance.mira.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.mira.Mira;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class BinderProvider extends ContentProvider {
    private static final String BUNDLE_BINDER = "binder";
    private static final String METHOD_QUERY_BINDER = "query_binder";

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    public abstract IBinder onBind();

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public BinderProvider() {
    }

    public static IBinder queryBinder(Context r2, Uri r3) {
        Bundle r4 = r2.getContentResolver().call(r3, METHOD_QUERY_BINDER, null, null);
        if (r4 == null) goto L8;
        r4.setClassLoader(Mira.getAppContext().getClassLoader());
        BinderParcel r5 = (BinderParcel) r4.getParcelable(BUNDLE_BINDER);
        if (r5 == null) goto L8;
        return r5.getBinder();
    L8:
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r1, String r2, Bundle r3) {
        if (METHOD_QUERY_BINDER.equals(r1) == false) goto L8;
        IBinder r4 = onBind();
        if (r4 == null) goto L10;
        Bundle r5 = new Bundle();
        r5.putParcelable(BUNDLE_BINDER, new BinderParcel(r4));
        return r5;
    L10:
        return null;
    L8:
        return null;
    }
}
