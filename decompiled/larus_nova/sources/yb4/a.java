package yb4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: yb4.a$a, reason: collision with other inner class name */
    public static final class C8323a {
    }

    static {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "db");
    }

    public a(Context r100) {
        super(r100, "verifystorage.db", null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "db");
        r100.execSQL("CREATE TABLE IF NOT EXISTS h5_storage (\n    id INTEGER PRIMARY KEY AUTOINCREMENT,\n    primary_key TEXT,\n    time_stamp LONG, \n    content TEXT\n    )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "db");
        r100.execSQL("DROP TABLE h5_storage");
        onCreate(r100);
    }
}
