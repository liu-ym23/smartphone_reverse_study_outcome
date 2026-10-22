package wia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.logger.Logger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class v extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f559902b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static v f559903c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f559904a;

    public static final class a {
        public a() {
        }

        public final v a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            v r101 = v.f559903c;
            if (r101 != null) goto L13;
            monitor-enter(this);
            r101 = v.f559903c;     // Catch: Throwable -> L10
            if (r101 != null) goto L8;
            r101 = new v(r100);     // Catch: Throwable -> L10
            v.f559903c = r101;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r101;
        }
    }

    static {
        f559902b = new a();
    }

    public final void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "entityId");
        this.f559904a.delete("EntityHistory", "entity_id = ? AND entity_type = ?", new String[]{r100, String.valueOf(r101)});
    }

    public final void d(List r100) {
        Intrinsics.checkNotNullParameter(r100, "indexIds");
        this.f559904a.beginTransaction();
        Iterator r101 = ((ArrayList) r100).iterator();     // Catch: Throwable -> L16
    L4:
        boolean r102 = true;
    L6:
        if (r101.hasNext() == false) goto L13;
        long r103 = ((Number) r101.next()).longValue();     // Catch: Throwable -> L16
        if (r102 == false) goto L12;
        if (e(r103) == true) goto L4;
    L12:
        r102 = false;
        goto L6
    L13:
        this.f559904a.setTransactionSuccessful();     // Catch: Throwable -> L16
        this.f559904a.endTransaction();
        return;
    L16:
        th = move-exception;
        this.f559904a.endTransaction();
        throw th;
    }

    public final boolean e(long r100) {
        int r101 = this.f559904a.delete("EntityHistory", "id = ?", new String[]{String.valueOf(r100)});
        if (r101 > 0) goto L5;
        Logger.INSTANCE.e("EntityDBHelper", "delete error: " + r100);
    L5:
        if (r101 > 0) goto L9;
        return false;
    L9:
        return true;
    }

    public final List<w> f() {
        v r100 = this;
        ArrayList r101 = new ArrayList();
        Long r102 = null;
    L4:
        if (r102 == null) goto L6;
        String[] r103 = {String.valueOf(r102.longValue())};
        String r104 = "id < ?";
    L7:
        Cursor r105 = r100.f559904a.query("EntityHistory", new String[]{"id", PickerReporterConstants.KEY.ENTITY_ID, "entity_data", EntityProvider.KEY_ENTITY_TYPE, "entity_action"}, r104, r103, null, null, "id DESC", "300");
        Long r106 = null;
    L49:
        if (r105.moveToNext() == false) goto L14;
        com.obric.capabilitykit.m r210 = a(r105.getString(r105.getColumnIndexOrThrow("entity_action")));     // Catch: Throwable -> L15 SQLiteBlobTooBigException -> L17
        r106 = Long.valueOf(r105.getLong(r105.getColumnIndexOrThrow("id")));     // Catch: Throwable -> L15 SQLiteBlobTooBigException -> L17
        if (r210 == null) goto L49;
        r101.add(new w(r106.longValue(), r105.getString(r105.getColumnIndexOrThrow(PickerReporterConstants.KEY.ENTITY_ID)), r105.getString(r105.getColumnIndexOrThrow("entity_data")), r105.getInt(r105.getColumnIndexOrThrow(EntityProvider.KEY_ENTITY_TYPE)), r210));     // Catch: Throwable -> L15 SQLiteBlobTooBigException -> L17
    L14:
        r105.close();
        v r107 = this;
        r102 = r106;
        boolean r110 = false;
    L37:
        if (r110 == true) goto L41;
        if (r102 == null) goto L41;
        r100 = r107;
    L41:
        return CollectionsKt.reversed(r101);
    L17:
        e = move-exception;
        Logger r108 = Logger.INSTANCE;     // Catch: Throwable -> L15
        r108.w("EntityDBHelper", "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L15
        r107 = this;
    L47:
        r108.w("EntityDBHelper", "EntityHistory cleared, deleted=" + r107.f559904a.delete("EntityHistory", null, null));     // Catch: Exception -> L26 Throwable -> L28
    L35:
        r101.clear();     // Catch: Throwable -> L28
        r105.close();
        r102 = r106;
        r110 = true;
    L26:
        e = e;
    L34:
        Logger.INSTANCE.w("EntityDBHelper", "EntityHistory clear failed", e);     // Catch: Throwable -> L28
    L30:
        e = e;
    L28:
        th = th;
    L43:
        r105.close();
        throw th;
    L15:
        th = th;
        goto L43
    L6:
        r104 = null;
        r103 = null;
        goto L7
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "db");
        r100.execSQL(StringsKt.trimIndent("\n            CREATE TABLE EntityHistory (\n                id INTEGER PRIMARY KEY AUTOINCREMENT,\n                entity_id TEXT,\n                entity_data TEXT,\n                entity_type INTEGER,\n                entity_action TEXT\n            )\n        "));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "db");
        Logger.INSTANCE.i("EntityDBHelper", "oldVersion: " + r101 + "  newVersion:" + r102);
        if (r101 != r102) goto L5;
        return;
    L5:
        int r103 = r101;
    L6:
        if (r103 >= r102) goto L8;
        Logger.INSTANCE.i("EntityDBHelper", "upgrade database form version " + r101 + " to version " + r102);
        r103 = r103 + 1;
        goto L6
    }

    public v(Context r100) {
        super(r100, "EntityHistory.db", null, 1);
        this.f559904a = getWritableDatabase();
    }

    public static com.obric.capabilitykit.m a(String r100) {
        com.obric.capabilitykit.m.f396254b.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        com.obric.capabilitykit.m[] r101 = com.obric.capabilitykit.m.values();
        int r102 = 0;
    L4:
        if (r102 >= 2) goto L9;
        com.obric.capabilitykit.m r103 = r101[r102];
        if (Intrinsics.areEqual(r103.b(), r100) == true) goto L13;
        r102 = r102 + 1;
        goto L4
    L13:
        return r103;
    L9:
        return null;
    }

    public final void c(String r110, int r111, String r210) {
        Intrinsics.checkNotNullParameter(r110, "entityId");
        Intrinsics.checkNotNullParameter(r210, ReportConstant.COMMON_ACTION_TYPE);
        Cursor r100 = this.f559904a.query("EntityHistory", new String[]{"id", PickerReporterConstants.KEY.ENTITY_ID, "entity_data", EntityProvider.KEY_ENTITY_TYPE, "entity_action"}, "entity_id = ? AND entity_type = ? AND entity_action = ?", new String[]{r110, String.valueOf(r111), r210}, null, null, "id ASC", "1");
        if (r100.moveToFirst() == false) goto L7;
        com.obric.capabilitykit.m r112 = a(r100.getString(r100.getColumnIndexOrThrow("entity_action")));
        if (r112 == null) goto L7;
        w r101 = new w(r100.getLong(r100.getColumnIndexOrThrow("id")), r100.getString(r100.getColumnIndexOrThrow(PickerReporterConstants.KEY.ENTITY_ID)), r100.getString(r100.getColumnIndexOrThrow("entity_data")), r100.getInt(r100.getColumnIndexOrThrow(EntityProvider.KEY_ENTITY_TYPE)), r112);
    L8:
        r100.close();
        if (r101 == null) goto L12;
        this.f559904a.delete("EntityHistory", "id = ?", new String[]{String.valueOf(r101.f559905a)});
        return;
    L12:
        return;
    L7:
        r101 = null;
        goto L8
    }
}
