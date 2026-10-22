package com.bytedance.bdturing.ttnet;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdturing.EventReport;
import ec4.h;
import qb4.r;
import qb4.s;

/* JADX INFO: loaded from: classes3.dex */
public class BdTuringInitProvider extends ContentProvider {
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
    public final boolean onCreate() {
        s r100 = s.b();     // Catch: Exception -> L15
        Context r101 = getContext();     // Catch: Exception -> L15
        if (r101 != null) goto L7;
        r100.getClass();     // Catch: Exception -> L15
    L13:
        h.a();     // Catch: Exception -> L15
        EventReport.f201689b = System.currentTimeMillis();     // Catch: Exception -> L15
    L17:
        return true;
    L7:
        if (r100.f532384a == true) goto L13;
        Application r102 = s.a(r101);     // Catch: Exception -> L15
        if (r102 == null) goto L13;
        r102.registerActivityLifecycleCallbacks(new r(r100));     // Catch: Exception -> L15
        s.f532383e = System.currentTimeMillis();     // Catch: Exception -> L15
        r100.f532384a = true;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    public BdTuringInitProvider() {
    }
}
