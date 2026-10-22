package com.bytedance.keva.ext.fast;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public class KevaMultiProcessContentProvider extends ContentProvider {
    private static final KevaMultiProcessFastAIDL.Stub stub = null;

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
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    static {
        stub = new AnonymousClass1();
    }

    public KevaMultiProcessContentProvider() {
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return new KevaBinderCursor(KevaMultiProcessFastConstant.KEY_BINDER, new StubParcelable(stub));
    }
}
