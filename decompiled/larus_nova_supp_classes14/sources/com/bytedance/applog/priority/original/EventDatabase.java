package com.bytedance.applog.priority.original;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class EventDatabase implements d {
    public static final /* synthetic */ int m = 0;
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
    public final h k;
    public final SqliteDbHelper l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.applog.priority.original.d
    public final void destroy() {
    }

    @Override // com.bytedance.applog.priority.original.d
    public final Set<Integer> d() {
        this.k.a(3);
        LinkedHashSet r1 = new LinkedHashSet();
        Cursor r0 = this.l.getWritableDatabase().rawQuery("select distinct(" + this.d + ") from " + this.c, null);     // Catch: Throwable -> L16
        Cursor r2 = r0;     // Catch: Throwable -> L11
    L6:
        if (r2.moveToNext() == false) goto L8;
        r1.add(Integer.valueOf(r2.getInt(0)));     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L16
    L18:
        return r1;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.a.b("SqliteDatabase:getAllGroupIds", th, EventDatabase$getAllGroupIds$2.INSTANCE);
        goto L18
    }

    public final Context getContext() {
        return this.b;
    }

    @Override // com.bytedance.applog.priority.original.d
    public final int a(final int r6) {
        this.k.a(2);
        Cursor r0 = this.l.getWritableDatabase().rawQuery("select count(1) from " + this.c + " where " + this.d + " = ?", new String[]{String.valueOf(r6)});     // Catch: Throwable -> L17
        Cursor r2 = r0;     // Catch: Throwable -> L12
        if (r2.moveToFirst() == false) goto L9;
        int r3 = r2.getInt(0);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L17
        return r3;
    L9:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L17
    L19:
        return 0;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.a.b("SqliteDatabase:count", th, new EventDatabase$count$2(r6));
        goto L19
    }

    @Override // com.bytedance.applog.priority.original.d
    public final void b(final Iterable<j> r10) {
        Intrinsics.checkNotNullParameter(r10, "keys");
        SQLiteDatabase r1 = this.l.getWritableDatabase();
        r1.beginTransaction();     // Catch: Throwable -> L16
        SQLiteStatement r0 = r1.compileStatement("delete from " + this.c + " where id = ?");     // Catch: Throwable -> L16
        Iterator<j> r2 = r10.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L12;
        j r3 = r2.next();     // Catch: Throwable -> L10
        if (r3.a < 0) goto L6;
        r0.clearBindings();     // Catch: Throwable -> L10
        r0.bindLong(1, r3.a);     // Catch: Throwable -> L10
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        goto L6
    L12:
        r1.setTransactionSuccessful();     // Catch: Throwable -> L10
        r0.close();     // Catch: Throwable -> L16
    L18:
        CommonKt.b(r1);
        return;
    L10:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.a.b("SqliteDatabase:deleteAll", th, new EventDatabase$deleteAll$2(r10));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CommonKt.b(r1);
        throw th;
    }

    @Override // com.bytedance.applog.priority.original.d
    public final boolean e(int r1) {
        if (a(r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.applog.priority.original.d
    public j insert(j r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, "value");
        h r2 = this.k;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, "value");
        if (r2.h == false) goto L35;
        r2.e.lock();     // Catch: Throwable -> L27
        List<Pair<j, String>> r0 = r2.f;     // Catch: Throwable -> L27
        ArrayList r1 = (ArrayList) r0;     // Catch: Throwable -> L27
        r1.add(TuplesKt.to(r11, r12));     // Catch: Throwable -> L27
        if (((ArrayList) r2.f).size() != 1) goto L12;
        h.b r13 = r2.g;     // Catch: Throwable -> L27
        Job r3 = r13.a.d;     // Catch: Throwable -> L27
        if (r3 == null) goto L10;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);     // Catch: Throwable -> L27
    L10:
        h r9 = r13.a;     // Catch: Throwable -> L27
        r9.d = BuildersKt.launch$default(r9, null, null, new InsertCache$eventCacheListener$1$onEventCacheAddFirst$1(r9, r13, null), 3, null);     // Catch: Throwable -> L27
    L12:
        if (((ArrayList) r2.f).size() >= r2.a.getMaxCacheSize()) goto L30;
    L25:
        r2.e.unlock();
        return r11;
    L30:
        ((SQLiteDatabase) r2.b.invoke()).beginTransaction();     // Catch: Throwable -> L23
        Iterator r14 = ((ArrayList) r2.f).iterator();     // Catch: Throwable -> L23
    L15:
        if (r14.hasNext() == false) goto L17;
        Pair r4 = (Pair) r14.next();     // Catch: Throwable -> L23
        j r5 = (j) r4.component1();     // Catch: Throwable -> L23
        String r6 = (String) r4.component2();     // Catch: Throwable -> L23
        r2.c.invoke(r5, r6);     // Catch: Throwable -> L23
        goto L15
    L17:
        ((ArrayList) r2.f).clear();     // Catch: Throwable -> L23
        Job r15 = r2.d;     // Catch: Throwable -> L23
        if (r15 == null) goto L20;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);     // Catch: Throwable -> L23
    L20:
        ((SQLiteDatabase) r2.b.invoke()).setTransactionSuccessful();     // Catch: Throwable -> L23
        Object r16 = r2.b.invoke();     // Catch: Throwable -> L27
    L24:
        ((SQLiteDatabase) r16).endTransaction();     // Catch: Throwable -> L27
        goto L25
    L23:
        r16 = r2.b.invoke();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r2.e.unlock();
        throw th;
    L35:
        return (j) r2.c.invoke(r11, r12);
    }

    public EventDatabase(com.bytedance.applog.log.a r16, Context r17, String r18, Model$PriorityName r19) {
        Intrinsics.checkNotNullParameter(r16, "logger");
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "appId");
        Intrinsics.checkNotNullParameter(r19, "priorityName");
        this.a = r16;
        this.b = r17;
        this.c = "event";
        this.d = "group_id";
        this.e = "monitor_id";
        this.f = "event_type";
        this.g = "event_stained";
        this.h = "timestamp";
        this.i = "event_name";
        this.j = "event_json";
        this.k = new h(new InsertCacheConfig(false, 0, 0, null, 15, null), new EventDatabase$insertCache$1(this), new EventDatabase$insertCache$2(this));
        this.l = new SqliteDbHelper(r16, r17, "applog_priority_db_" + r19.name() + '@' + r18, 1, CollectionsKt.listOf("CREATE TABLE IF NOT EXISTS event (\n        id integer primary key autoincrement, \n        group_id integer NOT NULL, \n        monitor_id varchar(32) NOT NULL, \n        event_type integer NOT NULL, \n        event_stained integer default 0, \n        timestamp integer NOT NULL, \n        event_name varchar(255) NOT NULL, \n        event_json TEXT NOT NULL \n        )"), null);
    }

    @Override // com.bytedance.applog.priority.original.d
    public final Pair<HashMap<j, JSONObject>, Boolean> c(final int r27, final long r28, final int r30, final long r31, Function1<? super JSONObject, Boolean> r33) {
        Intrinsics.checkNotNullParameter(r33, "filter");
        boolean r5 = true;
        this.k.a(1);
        HashMap r4 = new HashMap();
        HashSet r6 = new HashSet();
        long r7 = (System.currentTimeMillis() - r31) / ((long) ECDraweeView.SQUARE);
        boolean r9 = false;
        Cursor r2 = this.l.getWritableDatabase().rawQuery("select id, " + this.h + ", " + this.d + ", " + this.f + ", " + this.g + ", " + this.e + ", " + this.i + ", " + this.j + " from " + this.c + " where " + this.d + " = ?", new String[]{String.valueOf(r27)});     // Catch: Throwable -> L50
        Cursor r3 = r2;     // Catch: Throwable -> L40
        long r10 = 0;
        int r12 = 0;
    L5:
        if (r3.moveToNext() == false) goto L31;
        if (r10 >= r28) goto L65;
        r12 = r12 + 1;
        if (r12 >= r30) goto L65;
        long r16 = r3.getLong(0);     // Catch: Throwable -> L29
        long r19 = r3.getLong(r5 ? 1 : 0);     // Catch: Throwable -> L29
        if (r19 < r7) goto L15;
        int r18 = r3.getInt(2);     // Catch: Throwable -> L29
        Model$EventType.a r13 = Model$EventType.Companion;     // Catch: Throwable -> L29
        int r15 = r3.getInt(3);     // Catch: Throwable -> L29
        r13.getClass();     // Catch: Throwable -> L29
        Model$EventType r21 = Model$EventType.a.a(r15);     // Catch: Throwable -> L29
        if (r3.getInt(4) != r5) goto L19;
        boolean r22 = true;
    L20:
        String r23 = r3.getString(5);     // Catch: Throwable -> L29
        String r24 = r3.getString(6);     // Catch: Throwable -> L29
        String r14 = r3.getString(7);     // Catch: Throwable -> L29
        j r17 = new j(r16, r18, r19, r21, r22, r23, r24);     // Catch: Throwable -> L29
        JSONObject r110 = new JSONObject(r14);     // Catch: Throwable -> L23
    L25:
        if (((Boolean) r33.invoke(r110)).booleanValue() == false) goto L5;
        r4.put(r17, r110);     // Catch: Throwable -> L29
        r10 = r10 + ((long) CommonKt.g(r14));
        r6 = r6;
        r5 = true;
    L23:
        r110 = new JSONObject();     // Catch: Throwable -> L29
        goto L25
    L19:
        r22 = false;
        goto L20
    L15:
        r6.add(Long.valueOf(r16));     // Catch: Throwable -> L29
    L29:
        th = th;
    L42:
        Throwable r8 = th;
    L75:
        throw r8;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r2, r8);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        Throwable r11 = th;
        r5 = r9;
    L69:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L54
        boolean r1 = r11 instanceof SQLiteBlobTooBigException;     // Catch: Throwable -> L54
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L54
    L56:
        this.a.b("SqliteDatabase:getBySizeAndCount", r11, new EventDatabase$getBySizeAndCount$3(r27, r28, r30, r31));
    L58:
        return new Pair(r4, Boolean.valueOf(r5));
    L54:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L65:
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r11 = th;
    L38:
        th = move-exception;
        r8 = th;
        r9 = r5 ? 1 : 0;
        goto L75
    L31:
        r5 = false;
    L40:
        th = th;
    L50:
        th = move-exception;
        r11 = th;
        r5 = false;
        goto L69
    }
}
