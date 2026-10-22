package dl5;

import android.app.Application;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.bear.operation.database.OperationDatabase;
import com.bytedance.ee.util.db.DBController;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    public static volatile g d;
    public final CompositeDisposable a;
    public String b;
    public final boolean c;

    public class a extends RoomDatabase.Callback {
        public a() {
        }

        public final void onCreate(SupportSQLiteDatabase r2) {
            super.onCreate(r2);
            tt5.a.b("OperationDataManager", "onCreate()... ");
        }

        public final void onOpen(SupportSQLiteDatabase r2) {
            super.onOpen(r2);
            tt5.a.b("OperationDataManager", "onOpen()... ");
        }
    }

    public final synchronized OperationDatabase a() {
        monitor-enter(this);
        OperationDatabase r0 = (OperationDatabase) DBController.a().r1("operation.db");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static g b() {
        if (d != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new g(eu5.b.a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public g(Application r5) {
        this.a = new CompositeDisposable();
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = LarkContext.getApplication();
        r0.getClass();
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();
        this.c = ((dn4.a) k.b(((v) k.a(r1, v.class)).c(r2), dn4.a.class)).a().isCurrentEnable("ccm.mobile.download_file_report_db");
        DBController.a r3 = new DBController.a(r5);
        r3.a = "operation.db";
        r3.b = OperationDatabase.class;
        r3.d = new a();
        DBController.a().W3("operation.db", r3);
    }
}
