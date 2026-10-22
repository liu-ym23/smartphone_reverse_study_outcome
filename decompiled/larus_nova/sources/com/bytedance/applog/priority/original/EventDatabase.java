package com.bytedance.applog.priority.original;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class EventDatabase implements d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f192660m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.applog.log.a f192661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f192662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f192663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f192664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f192665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f192666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f192667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f192668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f192669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f192670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f192671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SqliteDbHelper f192672l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.applog.priority.original.d
    public final void destroy() {
    }

    @Override // com.bytedance.applog.priority.original.d
    public final Set<Integer> d() {
        this.f192671k.a(3);
        LinkedHashSet r100 = new LinkedHashSet();
        Cursor r101 = this.f192672l.getWritableDatabase().rawQuery("select distinct(" + this.f192664d + ") from " + this.f192663c, null);     // Catch: Throwable -> L16
        Cursor r102 = r101;     // Catch: Throwable -> L11
    L6:
        if (r102.moveToNext() == false) goto L8;
        r100.add(Integer.valueOf(r102.getInt(0)));     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r101, null);     // Catch: Throwable -> L16
    L18:
        return r100;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.f192661a.b("SqliteDatabase:getAllGroupIds", th, EventDatabase$getAllGroupIds$2.INSTANCE);
        goto L18
    }

    public final Context getContext() {
        return this.f192662b;
    }

    @Override // com.bytedance.applog.priority.original.d
    public final int a(final int r100) {
        this.f192671k.a(2);
        Cursor r101 = this.f192672l.getWritableDatabase().rawQuery("select count(1) from " + this.f192663c + " where " + this.f192664d + " = ?", new String[]{String.valueOf(r100)});     // Catch: Throwable -> L17
        Cursor r102 = r101;     // Catch: Throwable -> L12
        if (r102.moveToFirst() == false) goto L9;
        int r103 = r102.getInt(0);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r101, null);     // Catch: Throwable -> L17
        return r103;
    L9:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r101, null);     // Catch: Throwable -> L17
    L19:
        return 0;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.f192661a.b("SqliteDatabase:count", th, new EventDatabase$count$2(r100));
        goto L19
    }

    @Override // com.bytedance.applog.priority.original.d
    public final void b(final Iterable<j> r110) {
        Intrinsics.checkNotNullParameter(r110, "keys");
        SQLiteDatabase r100 = this.f192672l.getWritableDatabase();
        r100.beginTransaction();     // Catch: Throwable -> L16
        SQLiteStatement r101 = r100.compileStatement("delete from " + this.f192663c + " where id = ?");     // Catch: Throwable -> L16
        Iterator<j> r102 = r110.iterator();     // Catch: Throwable -> L10
    L6:
        if (r102.hasNext() == false) goto L12;
        j r103 = r102.next();     // Catch: Throwable -> L10
        if (r103.f192742a < 0) goto L6;
        r101.clearBindings();     // Catch: Throwable -> L10
        r101.bindLong(1, r103.f192742a);     // Catch: Throwable -> L10
        r101.executeUpdateDelete();     // Catch: Throwable -> L10
        goto L6
    L12:
        r100.setTransactionSuccessful();     // Catch: Throwable -> L10
        r101.close();     // Catch: Throwable -> L16
    L18:
        CommonKt.b(r100);
        return;
    L10:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.f192661a.b("SqliteDatabase:deleteAll", th, new EventDatabase$deleteAll$2(r110));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CommonKt.b(r100);
        throw th;
    }

    @Override // com.bytedance.applog.priority.original.d
    public final boolean e(int r100) {
        if (a(r100) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.applog.priority.original.d
    public j insert(j r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "value");
        h r100 = this.f192671k;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "value");
        if (r100.f192738h == false) goto L35;
        r100.f192735e.lock();     // Catch: Throwable -> L27
        List<Pair<j, String>> r101 = r100.f192736f;     // Catch: Throwable -> L27
        ArrayList r102 = (ArrayList) r101;     // Catch: Throwable -> L27
        r102.add(TuplesKt.to(r110, r111));     // Catch: Throwable -> L27
        if (((ArrayList) r100.f192736f).size() != 1) goto L12;
        h.b r112 = r100.f192737g;     // Catch: Throwable -> L27
        Job r103 = r112.f192739a.f192734d;     // Catch: Throwable -> L27
        if (r103 == null) goto L10;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);     // Catch: Throwable -> L27
    L10:
        h r104 = r112.f192739a;     // Catch: Throwable -> L27
        r104.f192734d = BuildersKt.launch$default(r104, null, null, new InsertCache$eventCacheListener$1$onEventCacheAddFirst$1(r104, r112, null), 3, null);     // Catch: Throwable -> L27
    L12:
        if (((ArrayList) r100.f192736f).size() >= r100.f192731a.getMaxCacheSize()) goto L30;
    L25:
        r100.f192735e.unlock();
        return r110;
    L30:
        r100.f192732b.invoke().beginTransaction();     // Catch: Throwable -> L23
        Iterator r113 = ((ArrayList) r100.f192736f).iterator();     // Catch: Throwable -> L23
    L15:
        if (r113.hasNext() == false) goto L17;
        Pair r105 = (Pair) r113.next();     // Catch: Throwable -> L23
        j r106 = (j) r105.component1();     // Catch: Throwable -> L23
        String r107 = (String) r105.component2();     // Catch: Throwable -> L23
        r100.f192733c.invoke(r106, r107);     // Catch: Throwable -> L23
        goto L15
    L17:
        ((ArrayList) r100.f192736f).clear();     // Catch: Throwable -> L23
        Job r114 = r100.f192734d;     // Catch: Throwable -> L23
        if (r114 == null) goto L20;
        Job.DefaultImpls.cancel$default(r114, null, 1, null);     // Catch: Throwable -> L23
    L20:
        r100.f192732b.invoke().setTransactionSuccessful();     // Catch: Throwable -> L23
        SQLiteDatabase r115 = r100.f192732b.invoke();     // Catch: Throwable -> L27
    L24:
        r115.endTransaction();     // Catch: Throwable -> L27
        goto L25
    L23:
        r115 = r100.f192732b.invoke();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r100.f192735e.unlock();
        throw th;
    L35:
        return r100.f192733c.invoke(r110, r111);
    }

    public EventDatabase(com.bytedance.applog.log.a r110, Context r111, String r112, Model$PriorityName r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "appId");
        Intrinsics.checkNotNullParameter(r113, "priorityName");
        this.f192661a = r110;
        this.f192662b = r111;
        this.f192663c = "event";
        this.f192664d = "group_id";
        this.f192665e = "monitor_id";
        this.f192666f = "event_type";
        this.f192667g = "event_stained";
        this.f192668h = "timestamp";
        this.f192669i = ReportCardMonitorPlugin.EVENT_NAME;
        this.f192670j = "event_json";
        this.f192671k = new h(new InsertCacheConfig(false, 0, 0, null, 15, null), new EventDatabase$insertCache$1(this), new EventDatabase$insertCache$2(this));
        this.f192672l = new SqliteDbHelper(r110, r111, "applog_priority_db_" + r113.name() + '@' + r112, 1, CollectionsKt.listOf("CREATE TABLE IF NOT EXISTS event (\n        id integer primary key autoincrement, \n        group_id integer NOT NULL, \n        monitor_id varchar(32) NOT NULL, \n        event_type integer NOT NULL, \n        event_stained integer default 0, \n        timestamp integer NOT NULL, \n        event_name varchar(255) NOT NULL, \n        event_json TEXT NOT NULL \n        )"), null);
    }

    @Override // com.bytedance.applog.priority.original.d
    public final Pair<HashMap<j, JSONObject>, Boolean> c(final int r210, final long r211, final int r310, final long r311, Function1<? super JSONObject, Boolean> r312) {
        Intrinsics.checkNotNullParameter(r312, "filter");
        boolean r100 = true;
        this.f192671k.a(1);
        HashMap r101 = new HashMap();
        HashSet r102 = new HashSet();
        long r103 = (System.currentTimeMillis() - r311) / ((long) 1000);
        boolean r104 = false;
        Cursor r105 = this.f192672l.getWritableDatabase().rawQuery("select id, " + this.f192668h + ", " + this.f192664d + ", " + this.f192666f + ", " + this.f192667g + ", " + this.f192665e + ", " + this.f192669i + ", " + this.f192670j + " from " + this.f192663c + " where " + this.f192664d + " = ?", new String[]{String.valueOf(r210)});     // Catch: Throwable -> L50
        Cursor r106 = r105;     // Catch: Throwable -> L40
        long r110 = 0;
        int r111 = 0;
    L5:
        if (r106.moveToNext() == false) goto L31;
        if (r110 >= r211) goto L65;
        r111 = r111 + 1;
        if (r111 >= r310) goto L65;
        long r112 = r106.getLong(0);     // Catch: Throwable -> L29
        long r113 = r106.getLong(r100 ? 1 : 0);     // Catch: Throwable -> L29
        if (r113 < r103) goto L15;
        int r114 = r106.getInt(2);     // Catch: Throwable -> L29
        Model$EventType.a r115 = Model$EventType.Companion;     // Catch: Throwable -> L29
        int r116 = r106.getInt(3);     // Catch: Throwable -> L29
        r115.getClass();     // Catch: Throwable -> L29
        Model$EventType r212 = Model$EventType.a.a(r116);     // Catch: Throwable -> L29
        if (r106.getInt(4) != r100) goto L19;
        boolean r213 = true;
    L20:
        String r214 = r106.getString(5);     // Catch: Throwable -> L29
        String r215 = r106.getString(6);     // Catch: Throwable -> L29
        String r117 = r106.getString(7);     // Catch: Throwable -> L29
        j r118 = new j(r112, r114, r113, r212, r213, r214, r215);     // Catch: Throwable -> L29
        JSONObject r119 = new JSONObject(r117);     // Catch: Throwable -> L23
    L25:
        if (r312.invoke(r119).booleanValue() == false) goto L5;
        r101.put(r118, r119);     // Catch: Throwable -> L29
        r110 = r110 + ((long) CommonKt.g(r117));
        r102 = r102;
        r100 = true;
    L23:
        r119 = new JSONObject();     // Catch: Throwable -> L29
        goto L25
    L19:
        r213 = false;
        goto L20
    L15:
        r102.add(Long.valueOf(r112));     // Catch: Throwable -> L29
    L29:
        th = th;
    L42:
        Throwable r107 = th;
    L75:
        throw r107;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r105, r107);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        Throwable r108 = th;
        r100 = r104;
    L69:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L54
        boolean r120 = r108 instanceof SQLiteBlobTooBigException;     // Catch: Throwable -> L54
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L54
    L56:
        this.f192661a.b("SqliteDatabase:getBySizeAndCount", r108, new EventDatabase$getBySizeAndCount$3(r210, r211, r310, r311));
    L58:
        return new Pair(r101, Boolean.valueOf(r100));
    L54:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L65:
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r108 = th;
    L38:
        th = move-exception;
        r107 = th;
        r104 = r100 ? 1 : 0;
        goto L75
    L31:
        r100 = false;
    L40:
        th = th;
    L50:
        th = move-exception;
        r108 = th;
        r100 = false;
        goto L69
    }
}
