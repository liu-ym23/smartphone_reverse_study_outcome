package com.bytedance.applog.priority.original;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes14.dex */
public final class SessionDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.applog.log.a f192691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f192692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f192693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f192694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f192695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f192696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f192697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f192698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f192699i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f192700j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f192701k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f192702l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f192703m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f192704n;

    public final List<a> a() {
        ArrayList r100 = new ArrayList();
        Cursor r101 = b().getReadableDatabase().rawQuery("select " + this.f192696f + ", " + this.f192701k + ", " + this.f192700j + ", " + this.f192699i + " from " + this.f192694d + " order by id asc", new String[0]);     // Catch: Throwable -> L26
        Cursor r102 = r101;     // Catch: Throwable -> L21
    L6:
        if (r102.moveToNext() == false) goto L18;
        String r103 = r102.getString(0);     // Catch: Throwable -> L21
        if (r102.getInt(1) != 1) goto L10;
        boolean r104 = true;
    L11:
        long r110 = r102.getLong(2);     // Catch: Throwable -> L21
        String r105 = r102.getString(3);     // Catch: Throwable -> L21
        if (r105 != null) goto L31;
    L13:
        JSONObject r106 = null;
    L17:
        r100.add(new a(r103, r104, r106, r110));     // Catch: Throwable -> L21
        goto L6
    L31:
        r106 = new JSONObject(r105);     // Catch: Throwable -> L29
        goto L17
    L10:
        r104 = false;
        goto L11
    L18:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r101, null);     // Catch: Throwable -> L26
    L28:
        return r100;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        this.f192691a.b("SessionDatabase:getAllLaunch", th, SessionDatabase$getAllLaunch$2.INSTANCE);
        goto L28
    }

    public final SqliteDbHelper b() {
        return (SqliteDbHelper) this.f192704n.getValue();
    }

    public final Context getContext() {
        return this.f192692b;
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
    public final List<c> c(final String r110) {
        SQLiteDatabase r100 = b().getReadableDatabase();
        ?? r101 = new LinkedHashMap();
        String r102 = "select " + this.f192696f + ", " + this.f192698h + ", " + this.f192697g + ", " + this.f192699i + " from " + this.f192695e + " where " + this.f192696f + " <> ? order by id asc";     // Catch: Throwable -> L47
        ?? r103 = 1;
        int r104 = 1;
        String[] r105 = new String[1];     // Catch: Throwable -> L47
        if (r110 != null) goto L6;
        String r106 = "";
    L62:
        int r107 = 0;
        r105[0] = r106;     // Catch: Throwable -> L47
        Cursor r108 = r100.rawQuery(r102, r105);     // Catch: Throwable -> L47
        Cursor r109 = r108;     // Catch: Throwable -> L39
        r101 = r101;
    L9:
        if (r109.moveToNext() == false) goto L31;
        final String r111 = r109.getString(r107);     // Catch: Throwable -> L39
        final String r112 = r109.getString(r104);     // Catch: Throwable -> L39
        final long r113 = r109.getLong(2);     // Catch: Throwable -> L39
        String r114 = r109.getString(3);     // Catch: Throwable -> L39
        Object r115 = r101.get(r111);     // Catch: Throwable -> L39
        Object r116 = r115;
        if (r115 != null) goto L14;
        c r117 = new c(r111, new JSONArray(), new JSONObject());     // Catch: Throwable -> L39
        r101.put(r111, r117);     // Catch: Throwable -> L39
        r116 = r117;
    L14:
        c r118 = (c) r116;     // Catch: Throwable -> L39
        JSONArray r119 = r118.f192729c;     // Catch: Throwable -> L39
        JSONArray r120 = new JSONArray();     // Catch: Throwable -> L39
        r120.put(r112);     // Catch: Throwable -> L39
        r103 = r101;
        Cursor r121 = r109;
        r120.put(Math.max(r113 / ((long) 1000), 1));     // Catch: Throwable -> L37
        r119.put(r120);     // Catch: Throwable -> L37
        r118.f192728b += r113;     // Catch: Throwable -> L37
        if (r114 != null) goto L19;
    L22:
        boolean r122 = true;
    L23:
        if (r122 == true) goto L30;
        JSONObject r123 = new JSONObject(r114);     // Catch: Throwable -> L28
        if (r123.length() <= 0) goto L30;
        CommonKt.h(r118.f192730d, r123);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        this.f192691a.b("SessionDatabase:queryTerminates", th, new SessionDatabase$queryTerminates$1$2(r111, r112, r113));     // Catch: Throwable -> L37
    L30:
        r101 = r103;
        r109 = r121;
        r104 = 1;
        r107 = 0;
        goto L9
    L19:
        if (r114.length() == 0) goto L22;
        r122 = false;
    L37:
        th = th;
    L41:
        Throwable r124 = th;
        throw r124;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        CloseableKt.closeFinally(r108, r124);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L31:
        r103 = r101;
        Unit r125 = Unit.INSTANCE;     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r108, null);     // Catch: Throwable -> L35
        ?? r126 = r103;
    L51:
        return CollectionsKt.toList(r126.values());
    L39:
        th = th;
        r103 = r101;
    L35:
        th = th;
    L49:
        this.f192691a.b("SessionDatabase:queryTerminates", th, new SessionDatabase$queryTerminates$2(r110));
        r126 = r103;
        goto L51
    L6:
        r106 = r110;
    L47:
        th = th;
        r103 = r101;
        goto L49
    }

    public SessionDatabase(com.bytedance.applog.log.a r100, Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "appId");
        this.f192691a = r100;
        this.f192692b = r110;
        this.f192693c = r111;
        this.f192694d = "session_launch";
        this.f192695e = "session_page";
        this.f192696f = "session_id";
        this.f192697g = "duration";
        this.f192698h = "page_name";
        this.f192699i = "extra_params";
        this.f192700j = "timestamp";
        this.f192701k = "foreground";
        this.f192702l = "CREATE TABLE IF NOT EXISTS session_launch (\n        id integer primary key autoincrement, \n        session_id varchar(64) NOT NULL, \n        foreground tinyint default 0,\n        timestamp integer default 0,\n        extra_params TEXT\n        )";
        this.f192703m = "CREATE TABLE IF NOT EXISTS session_page (\n        id integer primary key autoincrement, \n        session_id varchar(64) NOT NULL, \n        duration integer default 0, \n        page_name varchar(255) NOT NULL ,\n        extra_params TEXT\n        )";
        this.f192704n = LazyKt.lazy(new SessionDatabase$helper$2(this));
    }
}
