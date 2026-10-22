package xh8;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements SupportSQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f563895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f563896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Callback f563897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f563898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f563899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f563900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f563901g;

    /* JADX INFO: loaded from: classes25.dex */
    public static class a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d[] f563902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SupportSQLiteOpenHelper.Callback f563903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f563904c;

        /* JADX INFO: renamed from: xh8.f$a$a, reason: collision with other inner class name */
        public class C8240a implements DatabaseErrorHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SupportSQLiteOpenHelper.Callback f563905a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d[] f563906b;

            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase r100) {
                SupportSQLiteOpenHelper.Callback r101 = this.f563905a;
                d[] r102 = this.f563906b;
                d r103 = r102[0];
                if (r103 != null) goto L5;
            L9:
                r102[0] = new d(r100);
            L10:
                r101.onCorruption(r102[0]);
                return;
            L5:
                if (r103.f563892a != r100) goto L7;
                boolean r104 = true;
            L8:
                if (r104 == true) goto L10;
            L7:
                r104 = false;
                goto L8
            }

            public C8240a(SupportSQLiteOpenHelper.Callback r100, d[] r101) {
                this.f563905a = r100;
                this.f563906b = r101;
            }
        }

        public final synchronized SupportSQLiteDatabase a() {
            monitor-enter(this);
            this.f563904c = false;     // Catch: Throwable -> L17
            SQLiteDatabase r100 = getReadableDatabase();     // Catch: SQLiteException -> L7 Throwable -> L17
        L10:
            if (this.f563904c == false) goto L14;
            close();     // Catch: Throwable -> L17
            SupportSQLiteDatabase r101 = a();     // Catch: Throwable -> L17
            monitor-exit(this);
            return r101;
        L14:
            d r102 = b(r100);     // Catch: Throwable -> L17
            monitor-exit(this);
            return r102;
        L7:
            e = move-exception;
            e.a(e, "getReadableSupportDatabase");     // Catch: Throwable -> L17
            FLogger.f375446a.e("OpenHelper", "getReadableSupportDatabase err", e);     // Catch: Throwable -> L17
            r100 = c.a().f563889a;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }

        public final synchronized SupportSQLiteDatabase c() {
            monitor-enter(this);
            this.f563904c = false;     // Catch: Throwable -> L17
            SQLiteDatabase r100 = getWritableDatabase();     // Catch: SQLiteException -> L7 Throwable -> L17
        L10:
            if (this.f563904c == false) goto L14;
            close();     // Catch: Throwable -> L17
            SupportSQLiteDatabase r101 = c();     // Catch: Throwable -> L17
            monitor-exit(this);
            return r101;
        L14:
            d r102 = b(r100);     // Catch: Throwable -> L17
            monitor-exit(this);
            return r102;
        L7:
            e = move-exception;
            e.a(e, "getWritableSupportDatabase");     // Catch: Throwable -> L17
            FLogger.f375446a.e("OpenHelper", "getWritableSupportDatabase err", e);     // Catch: Throwable -> L17
            r100 = c.a().f563889a;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final synchronized void close() {
            monitor-enter(this);
            super.close();     // Catch: Throwable -> L6
            this.f563902a[0] = null;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final d b(SQLiteDatabase r100) {
            d[] r101 = this.f563902a;
            d r102 = r101[0];
            if (r102 != null) goto L5;
        L9:
            r101[0] = new d(r100);
        L11:
            return r101[0];
        L5:
            if (r102.f563892a != r100) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == true) goto L11;
        L7:
            r103 = false;
            goto L8
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase r100) {
            this.f563903b.onConfigure(b(r100));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r100) {
            this.f563903b.onCreate(b(r100));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase r100) {
            if (this.f563904c == true) goto L6;
            this.f563903b.onOpen(b(r100));
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
            this.f563904c = true;
            this.f563903b.onDowngrade(b(r100), r101, r102);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
            this.f563904c = true;
            this.f563903b.onUpgrade(b(r100), r101, r102);
        }

        public a(Context r100, String r101, d[] r102, SupportSQLiteOpenHelper.Callback r110) {
            super(r100, r101, null, r110.version, new C8240a(r110, r102));
            this.f563903b = r110;
            this.f563902a = r102;
        }
    }

    public final a a() {
        Object r100 = this.f563899e;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f563900f != null) goto L15;
        d[] r101 = new d[1];     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT >= 23) goto L9;
    L13:
        this.f563900f = new a(this.f563895a, this.f563896b, r101, this.f563897c);     // Catch: Throwable -> L18
    L14:
        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(this.f563900f, this.f563901g);     // Catch: Throwable -> L18
        goto L15
    L9:
        if (this.f563896b == null) goto L13;
        if (this.f563898d == false) goto L13;
        PolarisFileWrapper r102 = new PolarisFileWrapper(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(this.f563895a), this.f563896b);     // Catch: Throwable -> L18
        this.f563900f = new a(this.f563895a, r102.getAbsolutePath(), r101, this.f563897c);     // Catch: Throwable -> L18
    L15:
        a r103 = this.f563900f;     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return r103;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a().close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getReadableDatabase() {
        return a().a();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getWritableDatabase() {
        return a().c();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final String getDatabaseName() {
        return this.f563896b;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean r100) {
        Object r101 = this.f563899e;
        monitor-enter(r101);
        a r102 = this.f563900f;     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(r102, r100);     // Catch: Throwable -> L10
    L7:
        this.f563901g = r100;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public f(Context r100, String r101, SupportSQLiteOpenHelper.Callback r102, boolean r103) {
        this.f563895a = r100;
        this.f563896b = r101;
        this.f563897c = r102;
        this.f563898d = r103;
        this.f563899e = new Object();
    }
}
