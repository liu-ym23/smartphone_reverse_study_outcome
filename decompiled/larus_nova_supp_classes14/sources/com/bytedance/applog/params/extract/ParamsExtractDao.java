package com.bytedance.applog.params.extract;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.applog.log.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ParamsExtractDao {
    public final d a;
    public SQLiteStatement b;
    public SQLiteStatement c;

    public static final class a {
        public final String a;
        public final String b;
        public final JSONObject c;
        public final long d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            long r1 = this.d;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "ParamsExtractRecord(cpId=" + this.a + ", sessionId=" + this.b + ", json=" + this.c + ", createdAt=" + this.d + ')';
        }

        public a(String r3, JSONObject r4, long r5) {
            Intrinsics.checkNotNullParameter(r3, "cpId");
            Intrinsics.checkNotNullParameter("", "sessionId");
            Intrinsics.checkNotNullParameter(r4, "json");
            this.a = r3;
            this.b = "";
            this.c = r4;
            this.d = r5;
        }
    }

    public final int a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        SQLiteDatabase r1 = this.a.getWritableDatabase();
        if (this.b != null) goto L6;
        this.b = r1.compileStatement("INSERT OR ABORT INTO cp_entries(cp_id, session_id, json, created_at) VALUES(?, ?, ?, ?)");
    L6:
        if (this.c != null) goto L8;
        this.c = r1.compileStatement("DELETE FROM cp_entries WHERE session_id!=?");
    L8:
        r1.beginTransaction();
        SQLiteStatement r4 = this.c;     // Catch: Throwable -> L17 Exception -> L19
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L17 Exception -> L19
        r4.bindString(1, r10);     // Catch: Throwable -> L17 Exception -> L19
        int r5 = r4.executeUpdateDelete();     // Catch: Throwable -> L17 Exception -> L19
        r1.setTransactionSuccessful();     // Catch: Exception -> L15 Throwable -> L17
        r1.endTransaction();     // Catch: Exception -> L32
    L12:
        SQLiteStatement r11 = this.c;     // Catch: Exception -> L33
        if (r11 == null) goto L39;
    L25:
        r11.clearBindings();     // Catch: Exception -> L33
    L39:
    L15:
        Exception e = e;
    L21:
        n.w().c(c.a, "DB deleteHistoryByCurrentSession failed for session=" + r10, new Object[]{e});     // Catch: Throwable -> L17
        r1.endTransaction();     // Catch: Exception -> L34
    L23:
        r11 = this.c;     // Catch: Exception -> L33
        if (r11 == null) goto L39;
    L17:
        th = move-exception;
        r1.endTransaction();     // Catch: Exception -> L35
    L46:
        SQLiteStatement r0 = this.c;     // Catch: Exception -> L36
        if (r0 == null) goto L53;
        r0.clearBindings();     // Catch: Exception -> L36
        throw th;
    L53:
        throw th;
    L54:
        throw th;
    L19:
        e = move-exception;
        e = e;
        r5 = 0;
    L26:
        return r5;
    }

    public final Map<String, JSONObject> b(List<String> r18) {
        Intrinsics.checkNotNullParameter(r18, "ids");
        ArrayList r1 = (ArrayList) r18;
        if (r1.isEmpty() == true) goto L5;
        SQLiteDatabase r12 = this.a.getReadableDatabase();
        HashMap r13 = new HashMap(r1.size());
        Cursor r16 = null;
        String r2 = "SELECT cp_id, json FROM cp_entries WHERE cp_id IN (" + CollectionsKt.joinToString$default(r18, ",", null, null, 0, null, ParamsExtractDao$getByIds$placeholders$1.INSTANCE, 30, null) + ')';     // Catch: Throwable -> L24 Exception -> L26
        Object[] r0 = r18.toArray(new String[0]);     // Catch: Throwable -> L24 Exception -> L26
        if (r0 == null) goto L23;
        Cursor r3 = r12.rawQuery(r2, (String[]) r0);     // Catch: Throwable -> L24 Exception -> L26
    L41:
        if (r3.moveToNext() == false) goto L39;
        String r4 = r3.getString(r3.getColumnIndexOrThrow("cp_id"));     // Catch: Throwable -> L18 Exception -> L20
        r13.put(r4, new JSONObject(r3.getString(r3.getColumnIndexOrThrow("json"))));     // Catch: Exception -> L15 Throwable -> L18
    L15:
        e = move-exception;
        n.w().c(c.a, "Invalid JSON for cp_id=" + r4 + " in batch getByIds, skipping", new Object[]{e});     // Catch: Throwable -> L18 Exception -> L20
    L39:
        r3.close();     // Catch: Exception -> L35
    L31:
        return r13;
    L18:
        th = th;
        r16 = r3;
    L32:
        if (r16 != null) goto L45;
    L34:
        throw th;
    L45:
        r16.close();     // Catch: Exception -> L36
    L20:
        e = e;
        r16 = r3;
    L27:
        n.w().c(c.a, "DB batch query failed in getByIds", new Object[]{e});     // Catch: Throwable -> L24
        if (r16 == null) goto L31;
        r3 = r16;
        goto L39
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L24 Exception -> L26
    L24:
        th = th;
    L26:
        e = e;
        goto L27
    L5:
        return MapsKt.emptyMap();
    }

    public final List<String> c(String r14) {
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        SQLiteDatabase r2 = this.a.getReadableDatabase();
        ArrayList r1 = new ArrayList();
        Cursor r12 = null;
        r12 = r2.query("cp_entries", new String[]{"cp_id"}, "session_id!=?", new String[]{r14}, null, null, null);     // Catch: Exception -> L10 Throwable -> L15
    L5:
        if (r12.moveToNext() == false) goto L21;
        r1.add(r12.getString(r12.getColumnIndexOrThrow("cp_id")));     // Catch: Exception -> L10 Throwable -> L15
    L21:
        r12.close();     // Catch: Exception -> L19
    L14:
        return r1;
    L15:
        th = move-exception;
        if (r12 != null) goto L25;
    L18:
        throw th;
    L25:
        r12.close();     // Catch: Exception -> L20
    L10:
        e = move-exception;
        n.w().c(c.a, "DB listIdsBySession failed for session=" + r14, new Object[]{e});     // Catch: Throwable -> L15
        if (r12 == null) goto L14;
        goto L14
    }

    public ParamsExtractDao(Context r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "helper");
        this.a = r3;
    }

    public boolean insert(String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "cpId");
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "json");
        long r1 = System.currentTimeMillis();
        SQLiteDatabase r3 = this.a.getWritableDatabase();
        if (this.b != null) goto L6;
        this.b = r3.compileStatement("INSERT OR ABORT INTO cp_entries(cp_id, session_id, json, created_at) VALUES(?, ?, ?, ?)");
    L6:
        if (this.c != null) goto L8;
        this.c = r3.compileStatement("DELETE FROM cp_entries WHERE session_id!=?");
    L8:
        SQLiteStatement r4 = this.b;
        Intrinsics.checkNotNull(r4);
        boolean r5 = true;
        r4.bindString(1, r8);     // Catch: Throwable -> L13 Exception -> L15
        r4.bindString(2, r9);     // Catch: Throwable -> L13 Exception -> L15
        r4.bindString(3, r10);     // Catch: Throwable -> L13 Exception -> L15
        r4.bindLong(4, r1);     // Catch: Throwable -> L13 Exception -> L15
    L11:
        if (r4.executeInsert() != (-1)) goto L29;
    L17:
        r5 = false;
    L29:
        r4.clearBindings();     // Catch: Exception -> L22
    L19:
        return r5;
    L13:
        th = move-exception;
        r4.clearBindings();     // Catch: Exception -> L23
    L21:
        throw th;
    L15:
        e = move-exception;
        n.w().c(c.a, "DB insert failed for cp_id=" + r8, new Object[]{e});     // Catch: Throwable -> L13
        goto L17
    }
}
