package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.xiaomi.push.fy;

/* JADX INFO: loaded from: classes41.dex */
public class TrafficProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final UriMatcher f464133a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Uri f968a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SQLiteOpenHelper f969a;

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri r100, ContentValues[] r101) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    static {
        f968a = UriProtector.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");
        UriMatcher r100 = new UriMatcher(-1);
        f464133a = r100;
        r100.addURI("com.xiaomi.push.providers.TrafficProvider", "traffic", 1);
        r100.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f969a = new a(getContext());
        return true;
    }

    public TrafficProvider() {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        if (f464133a.match(r100) != 1) goto L7;
        return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
    L7:
        throw new IllegalArgumentException("Unknown URI " + r100);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        if (f464133a.match(r100) != 2) goto L13;
        if (r101 != null) goto L7;
        return 0;
    L7:
        if (r101.containsKey("imsi") == false) goto L12;
        fy.m9116a(r101.getAsString("imsi"));
        return 0;
    L12:
        return 0;
    L13:
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r110, String[] r111, String r112, String[] r113, String r114) {
        Object r100 = a.f970a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f464133a.match(r110) != 1) goto L10;
        Cursor r115 = this.f969a.getReadableDatabase().query("traffic", r111, r112, r113, null, null, r114);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r115;
    L10:
        throw new IllegalArgumentException("Unknown URI " + r110);     // Catch: Throwable -> L11
    }
}
