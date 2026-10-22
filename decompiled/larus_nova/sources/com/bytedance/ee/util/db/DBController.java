package com.bytedance.ee.util.db;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes19.dex */
public final class DBController implements com.bytedance.ee.util.db.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f243098a = 0;

    public static class GetDBException extends RuntimeException {
        public GetDBException(String r100) {
            super(r100);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f243099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Class f243100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f243101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RoomDatabase.Callback f243102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<Migration> f243103e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f243104f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final RoomDatabase.JournalMode f243105g;

        public Context getContext() {
            return this.f243101c;
        }

        public a(Context r100) {
            this.f243103e = new ArrayList();
            int r101 = DBController.f243098a;
            this.f243104f = true;
            this.f243105g = RoomDatabase.JournalMode.AUTOMATIC;
            this.f243101c = r100;
        }

        public final void a(Migration... r100) {
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            Migration r103 = r100[r102];
            ((ArrayList) this.f243103e).add(r103);
            r102 = r102 + 1;
            goto L3
        }
    }

    public interface b {
        void a(String r100);
    }

    static {
        new ReentrantReadWriteLock();
    }

    public static com.bytedance.ee.util.db.a a() {
        com.bytedance.ee.util.db.a r100 = (com.bytedance.ee.util.db.a) k.a(LarkContext.getApplication(), com.bytedance.ee.util.db.a.class);
        if (r100 != null) goto L5;
        tt5.a.d("DBController", "dwarf IDBController is null");
    L5:
        return r100;
    }
}
