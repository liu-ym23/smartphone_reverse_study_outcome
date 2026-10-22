package aj5;

import android.app.Application;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitDatabase;
import com.bytedance.ee.util.db.DBController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public final com.bytedance.ee.util.db.a a;

    public class a extends RoomDatabase.Callback {
        public a() {
        }

        public final void onCreate(SupportSQLiteDatabase r2) {
            super.onCreate(r2);
            tt5.a.b("Benefit_DataManager", "onCreate()... ");
        }

        public final void onOpen(SupportSQLiteDatabase r2) {
            super.onOpen(r2);
            tt5.a.b("Benefit_DataManager", "onOpen()... ");
        }
    }

    public final b a() {
        monitor-enter(this);
        BenefitDatabase r0 = (BenefitDatabase) this.a.r1("benefit.db");     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0.c();
    L7:
        th = move-exception;
        throw th;
    }

    public f(Application r3, com.bytedance.ee.util.db.a r4) {
        this.a = r4;
        DBController.a r0 = new DBController.a(r3);
        r0.a = "benefit.db";
        r0.b = BenefitDatabase.class;
        r0.d = new a();
        r4.W3("benefit.db", r0);
    }
}
