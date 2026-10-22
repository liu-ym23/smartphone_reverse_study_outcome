package com.bytedance.applog.priority.original;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SessionDatabase {
    public final com.bytedance.applog.log.a a;
    public final Context b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final Lazy n;

    public final List<a> a() {
        ArrayList r2 = new ArrayList();
        Cursor r0 = b().getReadableDatabase().rawQuery("select " + this.f + ", " + this.k + ", " + this.j + ", " + this.i + " from " + this.d + " order by id asc", new String[0]);     // Catch: Throwable -> L26
        Cursor r3 = r0;     // Catch: Throwable -> L21
    L6:
        if (r3.moveToNext() == false) goto L18;
        String r7 = r3.getString(0);     // Catch: Throwable -> L21
        if (r3.getInt(1) != 1) goto L10;
        boolean r8 = true;
    L11:
        long r10 = r3.getLong(2);     // Catch: Throwable -> L21
        String r4 = r3.getString(3);     // Catch: Throwable -> L21
        if (r4 != null) goto L31;
    L13:
        JSONObject r9 = null;
    L17:
        r2.add(new a(r7, r8, r9, r10));     // Catch: Throwable -> L21
        goto L6
    L31:
        r9 = new JSONObject(r4);     // Catch: Throwable -> L29
        goto L17
    L10:
        r8 = false;
        goto L11
    L18:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L26
    L28:
        return r2;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        this.a.b("SessionDatabase:getAllLaunch", th, SessionDatabase$getAllLaunch$2.INSTANCE);
        goto L28
    }

    public final SqliteDbHelper b() {
        return (SqliteDbHelper) this.n.getValue();
    }

    public final Context getContext() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.LinkedHashMap] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.LinkedHashMap] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.LinkedHashMap, java.util.Map] */
    public final List<c> c(final String r19) {
        SQLiteDatabase r5 = b().getReadableDatabase();
        ?? r6 = new LinkedHashMap();
        String r0 = "select " + this.f + ", " + this.h + ", " + this.g + ", " + this.i + " from " + this.e + " where " + this.f + " <> ? order by id asc";     // Catch: Throwable -> L47
        ?? r4 = 1;
        int r7 = 1;
        String[] r8 = new String[1];     // Catch: Throwable -> L47
        if (r19 != null) goto L6;
        String r9 = "";
    L62:
        int r10 = 0;
        r8[0] = r9;     // Catch: Throwable -> L47
        Cursor r11 = r5.rawQuery(r0, r8);     // Catch: Throwable -> L47
        Cursor r12 = r11;     // Catch: Throwable -> L39
        r6 = r6;
    L9:
        if (r12.moveToNext() == false) goto L31;
        final String r13 = r12.getString(r10);     // Catch: Throwable -> L39
        final String r14 = r12.getString(r7);     // Catch: Throwable -> L39
        final long r15 = r12.getLong(2);     // Catch: Throwable -> L39
        String r1 = r12.getString(3);     // Catch: Throwable -> L39
        Object r16 = r6.get(r13);     // Catch: Throwable -> L39
        Object r17 = r16;
        if (r16 != null) goto L14;
        c r18 = new c(r13, new JSONArray(), new JSONObject());     // Catch: Throwable -> L39
        r6.put(r13, r18);     // Catch: Throwable -> L39
        r17 = r18;
    L14:
        c r110 = (c) r17;     // Catch: Throwable -> L39
        JSONArray r111 = r110.c;     // Catch: Throwable -> L39
        JSONArray r112 = new JSONArray();     // Catch: Throwable -> L39
        r112.put(r14);     // Catch: Throwable -> L39
        r4 = r6;
        Cursor r113 = r12;
        r112.put(Math.max(r15 / ((long) ECDraweeView.SQUARE), 1));     // Catch: Throwable -> L37
        r111.put(r112);     // Catch: Throwable -> L37
        r110.b += r15;     // Catch: Throwable -> L37
        if (r1 != null) goto L19;
    L22:
        boolean r20 = true;
    L23:
        if (r20 == true) goto L30;
        JSONObject r21 = new JSONObject(r1);     // Catch: Throwable -> L28
        if (r21.length() <= 0) goto L30;
        CommonKt.h(r110.d, r21);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        this.a.b("SessionDatabase:queryTerminates", th, new SessionDatabase$queryTerminates$1$2(r13, r14, r15));     // Catch: Throwable -> L37
    L30:
        r6 = r4;
        r12 = r113;
        r7 = 1;
        r10 = 0;
        goto L9
    L19:
        if (r1.length() == 0) goto L22;
        r20 = false;
    L37:
        th = th;
    L41:
        Throwable r22 = th;
        throw r22;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        CloseableKt.closeFinally(r11, r22);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L31:
        r4 = r6;
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L35
        ?? r23 = r4;
    L51:
        return CollectionsKt.toList(r23.values());
    L39:
        th = th;
        r4 = r6;
    L35:
        th = th;
    L49:
        this.a.b("SessionDatabase:queryTerminates", th, new SessionDatabase$queryTerminates$2(r19));
        r23 = r4;
        goto L51
    L6:
        r9 = r19;
    L47:
        th = th;
        r4 = r6;
        goto L49
    }

    public SessionDatabase(com.bytedance.applog.log.a r9, Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "logger");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appId");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = "session_launch";
        this.e = "session_page";
        this.f = "session_id";
        this.g = "duration";
        this.h = "page_name";
        this.i = "extra_params";
        this.j = "timestamp";
        this.k = "foreground";
        this.l = "CREATE TABLE IF NOT EXISTS session_launch (\n        id integer primary key autoincrement, \n        session_id varchar(64) NOT NULL, \n        foreground tinyint default 0,\n        timestamp integer default 0,\n        extra_params TEXT\n        )";
        this.m = "CREATE TABLE IF NOT EXISTS session_page (\n        id integer primary key autoincrement, \n        session_id varchar(64) NOT NULL, \n        duration integer default 0, \n        page_name varchar(255) NOT NULL ,\n        extra_params TEXT\n        )";
        this.n = LazyKt.lazy(new SessionDatabase$helper$2(this));
    }
}
