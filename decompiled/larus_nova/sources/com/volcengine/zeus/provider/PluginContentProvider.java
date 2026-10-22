package com.volcengine.zeus.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class PluginContentProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public abstract int delete(Uri r100, String r101, String[] r102);

    @Override // android.content.ContentProvider
    public abstract String getType(Uri r100);

    @Override // android.content.ContentProvider
    public abstract Uri insert(Uri r100, ContentValues r101);

    @Override // android.content.ContentProvider
    public abstract Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104);

    @Override // android.content.ContentProvider
    public abstract int update(Uri r100, ContentValues r101, String r102, String[] r103);

    public PluginContentProvider() {
    }
}
