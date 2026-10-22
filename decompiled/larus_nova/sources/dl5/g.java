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

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile g f469127d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f469128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f469129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f469130c;

    public class a extends RoomDatabase.Callback {
        public a() {
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onCreate(SupportSQLiteDatabase r100) {
            super.onCreate(r100);
            tt5.a.b("OperationDataManager", "onCreate()... ");
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onOpen(SupportSQLiteDatabase r100) {
            super.onOpen(r100);
            tt5.a.b("OperationDataManager", "onOpen()... ");
        }
    }

    public final synchronized OperationDatabase a() {
        monitor-enter(this);
        OperationDatabase r100 = (OperationDatabase) DBController.a().r1("operation.db");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public static g b() {
        if (f469127d != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f469127d != null) goto L9;
        f469127d = new g(eu5.b.f474075a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f469127d;
    }

    public g(Application r100) {
        this.f469128a = new CompositeDisposable();
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        Application r102 = LarkContext.getApplication();
        r101.getClass();
        UserSession r103 = ((com.ss.android.lark.passportc.convention.a) k.a(r102, com.ss.android.lark.passportc.convention.a.class)).b();
        this.f469130c = ((dn4.a) k.b(((v) k.a(r102, v.class)).c(r103), dn4.a.class)).a().isCurrentEnable("ccm.mobile.download_file_report_db");
        DBController.a r104 = new DBController.a(r100);
        r104.f243099a = "operation.db";
        r104.f243100b = OperationDatabase.class;
        r104.f243102d = new a();
        DBController.a().W3("operation.db", r104);
    }
}
