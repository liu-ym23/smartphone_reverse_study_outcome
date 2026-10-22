package com.bytedance.ee.util.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import iu5.d;
import ju5.g;
import ju5.j;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f243108a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f243109b;

    public class a extends RoomDatabase.Callback {
        public a() {
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onCreate(SupportSQLiteDatabase r100) {
            super.onCreate(r100);
            tt5.a.b("KeyValueManager", "onCreate: ");
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onOpen(SupportSQLiteDatabase r100) {
            super.onOpen(r100);
            tt5.a.b("KeyValueManager", "onOpen: ");
        }
    }

    static {
        f243108a = new Object();
    }

    public b(Context r100) {
        a r101 = new a();
        DBController.a r102 = new DBController.a(r100);
        r102.f243099a = "docs_keyvaule.db";
        r102.f243100b = KeyValueDatabase.class;
        r102.f243102d = r101;
        DBController.a().W3("docs_keyvaule.db", r102);
    }

    public final j a(String r100) {
        monitor-enter(this);     // Catch: Exception -> L7
        KeyValueDatabase r101 = (KeyValueDatabase) DBController.a().r1("docs_keyvaule.db");     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Exception -> L7
        return ((g) r101.c()).a(r100);
    L9:
        th = move-exception;
        throw th;     // Catch: Exception -> L7
    L7:
        e = move-exception;
        d.c(e);
        return null;
    }
}
