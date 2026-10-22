package com.volcengine.zeus.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class PluginContentProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public abstract int delete(Uri r1, String r2, String[] r3);

    @Override // android.content.ContentProvider
    public abstract String getType(Uri r1);

    @Override // android.content.ContentProvider
    public abstract Uri insert(Uri r1, ContentValues r2);

    @Override // android.content.ContentProvider
    public abstract Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5);

    @Override // android.content.ContentProvider
    public abstract int update(Uri r1, ContentValues r2, String r3, String[] r4);

    public PluginContentProvider() {
    }
}
