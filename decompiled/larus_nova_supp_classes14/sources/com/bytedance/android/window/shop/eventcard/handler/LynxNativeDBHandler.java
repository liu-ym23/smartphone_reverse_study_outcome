package com.bytedance.android.window.shop.eventcard.handler;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.android.ec.window.base.db.WindowDatabase;
import com.bytedance.apm.constant.UploadTypeInf;
import ho.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LynxNativeDBHandler implements a {
    public static final Map<String, Object> a = null;
    public static final Map<String, Object> b = null;
    public static final LynxNativeDBHandler c = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/handler/LynxNativeDBHandler$LynxDBOperation;", "", "", "operation", "Ljava/lang/String;", "getOperation", "()Ljava/lang/String;", "Companion", "a", "INSERT", "REMOVE", "UPDATE", "QUERY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LynxDBOperation extends Enum<LynxDBOperation> {
        public static final a Companion = null;
        public static final LynxDBOperation INSERT = null;
        public static final LynxDBOperation QUERY = null;
        public static final LynxDBOperation REMOVE = null;
        public static final LynxDBOperation UPDATE = null;
        public static final /* synthetic */ LynxDBOperation[] a = null;
        public static final Map<String, LynxDBOperation> b = null;
        private final String operation;

        public static final class a {
            public a() {
            }
        }

        static {
            int r3 = 0;
            LynxDBOperation r1 = new LynxDBOperation("INSERT", 0, "insert");
            INSERT = r1;
            LynxDBOperation r2 = new LynxDBOperation("REMOVE", 1, "remove");
            REMOVE = r2;
            LynxDBOperation r4 = new LynxDBOperation("UPDATE", 2, "update");
            UPDATE = r4;
            LynxDBOperation r5 = new LynxDBOperation("QUERY", 3, "query");
            QUERY = r5;
            a = new LynxDBOperation[]{r1, r2, r4, r5};
            Companion = new a();
            LynxDBOperation[] r0 = values();
            LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r0.length), 16));
            int r7 = r0.length;
        L3:
            if (r3 >= r7) goto L5;
            LynxDBOperation r8 = r0[r3];
            r6.put(r8.operation, r8);
            r3 = r3 + 1;
            goto L3
        L5:
            b = r6;
        }

        public static LynxDBOperation valueOf(String r1) {
            return (LynxDBOperation) r27.a.a(LynxDBOperation.class, r1);
        }

        public static LynxDBOperation[] values() {
            return (LynxDBOperation[]) a.clone();
        }

        public static final /* synthetic */ Map access$getMapping$cp() {
            return b;
        }

        public final String getOperation() {
            return this.operation;
        }

        public LynxDBOperation(String r1, int r2, String r3) {
            super(r1, r2);
            this.operation = r3;
        }
    }

    public LynxNativeDBHandler() {
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
    }

    static {
        c = new LynxNativeDBHandler();
        a = MapsKt.mapOf(TuplesKt.to("success", Boolean.FALSE));
        b = MapsKt.mapOf(TuplesKt.to("success", Boolean.TRUE));
    }

    public static Map b(Map r3) {
        Object r4 = r3.get("entity");
        if ((r4 instanceof Map) == true) goto L5;
        r4 = null;
    L5:
        Map r5 = (Map) r4;
        if (r5 != null) goto L10;
        return MapsKt.emptyMap();
    L10:
        if (r5.isEmpty() == true) goto L18;
        Iterator r0 = r5.entrySet().iterator();
    L14:
        if (r0.hasNext() == false) goto L18;
        boolean r2 = true;
        if ((!(((Map.Entry) r0.next()).getKey() instanceof String)) == false) goto L14;
    L19:
        if (r2 == true) goto L21;
        return r5;
    L21:
        return MapsKt.emptyMap();
    L18:
        r2 = false;
        goto L19
    }

    private final Map<String, Object> insert(Map<String, ? extends Object> r3) {
        Map r4 = b(r3);
        io.e.m.getClass();
        Intrinsics.checkNotNullParameter(r4, "map");
        if (io.e.a.a(r4, io.e.i) == false) goto L5;
        io.e r5 = io.e.a.b(r4);
        WindowDatabase r0 = go.a.b.a();
        if (r0 == null) goto L17;
        n r1 = r0.g();
        if (r1 == null) goto L17;
        n r2 = r1;
        r2.a.assertNotSuspendingTransaction();
        r2.a.beginTransaction();
        r2.b.insertAndReturnId(r5);     // Catch: Throwable -> L13
        r2.a.setTransactionSuccessful();     // Catch: Throwable -> L13
        r2.a.endTransaction();
    L13:
        th = move-exception;
        r2.a.endTransaction();
        throw th;
    L17:
        return MapsKt.emptyMap();
    L5:
        return a;
    }

    private final Map<String, Object> query(Map<String, ? extends Object> r31) {
        Map r8 = b(r31);
        io.e.m.getClass();
        Intrinsics.checkNotNullParameter(r8, "map");
        if (io.e.a.a(r8, io.e.l) == false) goto L5;
        io.e r9 = io.e.a.b(r8);
        WindowDatabase r10 = go.a.b.a();
        if (r10 == null) goto L36;
        n r11 = r10.g();
        if (r11 == null) goto L36;
        String r12 = r9.a;
        String r13 = r9.b;
        String r14 = r9.c;
        n r15 = r11;
        RoomSQLiteQuery r16 = RoomSQLiteQuery.acquire("SELECT * FROM window_lynx_common WHERE user_id = ? and scene_id = ? and business = ? limit 1", 3);
        if (r12 != null) goto L13;
        r16.bindNull(1);
    L15:
        if (r13 != null) goto L17;
        r16.bindNull(2);
    L18:
        if (r14 != null) goto L20;
        r16.bindNull(3);
    L21:
        r15.a.assertNotSuspendingTransaction();
        Cursor r17 = DBUtil.query(r15.a, r16, false);
        int r18 = CursorUtil.getColumnIndexOrThrow(r17, "user_id");     // Catch: Throwable -> L32
        int r19 = CursorUtil.getColumnIndexOrThrow(r17, "scene_id");     // Catch: Throwable -> L32
        int r110 = CursorUtil.getColumnIndexOrThrow(r17, "business");     // Catch: Throwable -> L32
        int r111 = CursorUtil.getColumnIndexOrThrow(r17, UploadTypeInf.COUNT);     // Catch: Throwable -> L32
        int r112 = CursorUtil.getColumnIndexOrThrow(r17, "timestamp");     // Catch: Throwable -> L32
        int r20 = CursorUtil.getColumnIndexOrThrow(r17, "data");     // Catch: Throwable -> L32
        int r2 = CursorUtil.getColumnIndexOrThrow(r17, "reserved_string");     // Catch: Throwable -> L32
        int r1 = CursorUtil.getColumnIndexOrThrow(r17, "reserved_long");     // Catch: Throwable -> L32
        if (r17.moveToFirst() == false) goto L26;
        io.e r3 = new io.e(r17.getString(r18), r17.getString(r19), r17.getString(r110), r17.getInt(r111), r17.getLong(r112), r17.getString(r20), r17.getString(r2), r17.getLong(r1));     // Catch: Throwable -> L32
    L27:
        r17.close();
        r16.release();
        if (r3 == null) goto L36;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("user_id", r3.a), TuplesKt.to("scene_id", r3.b), TuplesKt.to("business", r3.c), TuplesKt.to(UploadTypeInf.COUNT, Integer.valueOf(r3.d)), TuplesKt.to("timestamp", Long.valueOf(r3.e)), TuplesKt.to("data", r3.f), TuplesKt.to("reserved_string", r3.g), TuplesKt.to("reserved_long", Long.valueOf(r3.h))});
    L26:
        r3 = null;
    L32:
        th = move-exception;
        r17.close();
        r16.release();
        throw th;
    L20:
        r16.bindString(3, r14);
        goto L21
    L17:
        r16.bindString(2, r13);
        goto L18
    L13:
        r16.bindString(1, r12);
    L36:
        return a;
    L5:
        return a;
    }

    private final Map<String, Object> update(Map<String, ? extends Object> r3) {
        Map r4 = b(r3);
        io.e.m.getClass();
        Intrinsics.checkNotNullParameter(r4, "map");
        if (io.e.a.a(r4, io.e.k) == false) goto L5;
        io.e r5 = io.e.a.b(r4);
        WindowDatabase r0 = go.a.b.a();
        if (r0 == null) goto L17;
        n r1 = r0.g();
        if (r1 == null) goto L17;
        n r2 = r1;
        r2.a.assertNotSuspendingTransaction();
        r2.a.beginTransaction();
        r2.d.handle(r5);     // Catch: Throwable -> L13
        r2.a.setTransactionSuccessful();     // Catch: Throwable -> L13
        r2.a.endTransaction();
    L13:
        th = move-exception;
        r2.a.endTransaction();
        throw th;
    L17:
        return b;
    L5:
        return a;
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        LynxDBOperation.a r6 = LynxDBOperation.Companion;
        Object r0 = r5.get("operation");
        LynxDBOperation r2 = null;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        r6.getClass();
        if (r1 == null) goto L9;
        r2 = (LynxDBOperation) LynxDBOperation.access$getMapping$cp().get(r1);
    L9:
        if (r2 == null) goto L11;
        int r7 = d.a[r2.ordinal()];
        if (r7 == 1) goto L39;
        if (r7 != 2) goto L17;
        Map r8 = b(r5);
        io.e.m.getClass();
        Intrinsics.checkNotNullParameter(r8, "map");
        if (io.e.a.a(r8, io.e.j) == false) goto L44;
        io.e r9 = io.e.a.b(r8);
        WindowDatabase r10 = go.a.b.a();
        if (r10 == null) goto L45;
        n r11 = r10.g();
        if (r11 == null) goto L45;
        n r12 = r11;
        r12.a.assertNotSuspendingTransaction();
        r12.a.beginTransaction();
        r12.c.handle(r9);     // Catch: Throwable -> L34
        r12.a.setTransactionSuccessful();     // Catch: Throwable -> L34
        r12.a.endTransaction();
    L34:
        th = move-exception;
        r12.a.endTransaction();
        throw th;
    L45:
        return b;
    L44:
        return a;
    L17:
        if (r7 == 3) goto L43;
        if (r7 != 4) goto L22;
        return query(r5);
    L22:
        throw new NoWhenBranchMatchedException();
    L43:
        return update(r5);
    L39:
        return insert(r5);
    L11:
        return MapsKt.emptyMap();
    }
}
