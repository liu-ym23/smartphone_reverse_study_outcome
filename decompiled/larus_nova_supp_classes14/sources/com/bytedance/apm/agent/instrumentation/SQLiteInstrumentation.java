package com.bytedance.apm.agent.instrumentation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import com.bytedance.apm.agent.tracing.TraceMachine;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class SQLiteInstrumentation {
    public static final String SQLITE = "sqlite";

    public SQLiteInstrumentation() {
    }

    public static Cursor rawQuery(SQLiteDatabase r3, String r4, String[] r5) {
        TraceMachine.enterMethod(SQLITE, "rawQuery", "db_trace");
        Cursor r6 = r3.rawQuery(r4, r5);
        TraceMachine.exitMethod(r4);
        return r6;
    }

    public static Cursor rawQuery(SQLiteDatabase r2, String r3, String[] r4, CancellationSignal r5) {
        TraceMachine.enterMethod(SQLITE, "rawQuery", "db_trace");
        Cursor r6 = r2.rawQuery(r3, r4);
        TraceMachine.exitMethod(r3);
        return r6;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase r3, SQLiteDatabase.CursorFactory r4, String r5, String[] r6, String r7) {
        TraceMachine.enterMethod(SQLITE, "rawQueryWithFactory", "db_trace");
        Cursor r8 = r3.rawQueryWithFactory(r4, r5, r6, r7);
        TraceMachine.exitMethod(r5 + Arrays.toString(r6));
        return r8;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase r3, SQLiteDatabase.CursorFactory r4, String r5, String[] r6, String r7, CancellationSignal r8) {
        TraceMachine.enterMethod(SQLITE, "rawQueryWithFactory", "db_trace");
        Cursor r9 = r3.rawQueryWithFactory(r4, r5, r6, r7, r8);
        TraceMachine.exitMethod(r5 + Arrays.toString(r6));
        return r9;
    }

    public static Cursor query(SQLiteDatabase r10, String r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17) {
        TraceMachine.enterMethod(SQLITE, "query", "db_trace");
        Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17);
        TraceMachine.exitMethod(combineQuery(false, r11, r12, r13, r14, r15, r16, r17, null));
        return r0;
    }

    private static String combineQuery(boolean r0, String r1, String[] r2, String r3, String[] r4, String r5, String r6, String r7, String r8) {
        return "distinct: " + r0 + " table: " + r1 + " columns: " + Arrays.toString(r2) + " selection: " + r3 + " selectionArgs: " + Arrays.toString(r4);
    }

    public static Cursor query(SQLiteDatabase r10, String r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17, String r18) {
        TraceMachine.enterMethod(SQLITE, "query", "db_trace");
        Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18);
        TraceMachine.exitMethod(combineQuery(false, r11, r12, r13, r14, r15, r16, r17, r18));
        return r0;
    }

    public static Cursor query(SQLiteDatabase r3, boolean r4, String r5, String[] r6, String r7, String[] r8, String r9, String r10, String r11, String r12) {
        TraceMachine.enterMethod(SQLITE, "query", "db_trace");
        Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11, r12);
        TraceMachine.exitMethod(combineQuery(r4, r5, r6, r7, r8, r9, r10, r11, r12));
        return r13;
    }

    public static Cursor queryWithFactory(SQLiteDatabase r10, SQLiteDatabase.CursorFactory r11, boolean r12, String r13, String[] r14, String r15, String[] r16, String r17, String r18, String r19, String r20, CancellationSignal r21) {
        TraceMachine.enterMethod(SQLITE, "queryWithFactory", "db_trace");
        Cursor r0 = r10.queryWithFactory(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
        TraceMachine.exitMethod(combineQuery(false, r13, r14, r15, r16, r17, r18, r19, r20));
        return r0;
    }
}
