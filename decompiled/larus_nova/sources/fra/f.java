package fra;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f478636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f478637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f478638c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f478639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f478640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f478641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f478642g = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f478643a = null;

        static {
            f478643a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            dra.b r100 = new dra.b();     // Catch: Throwable -> L4
            r100.b("share_sdk_read_time_out");     // Catch: Throwable -> L4
            r100.c();     // Catch: Throwable -> L4
            Context r101 = f.f478636a;     // Catch: Throwable -> L4
            f.c(new c("", false, "time out", 8, 0));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f() {
    }

    static {
        f478638c = new Handler(Looper.getMainLooper());
        f478642g = a.f478643a;
    }

    public static void c(c r100) {
        f478640e = false;
        if (f478639d == false) goto L5;
        return;
    L5:
        f478641f = false;
        f478639d = true;
        f478638c.removeCallbacks(f478642g);
        b r101 = f478637b;
        f478637b = null;
        if (r101 == null) goto L8;
        r101.b(r100);
    L8:
        dra.b r102 = new dra.b();
        r102.b("share_sdk_read_result");
        r102.a("is_succ", Boolean.valueOf(r100.f478628d));
        r102.a(LocationMonitorConst.ERR_MSG, r100.f478629e);
        r102.a("query_type", Integer.valueOf(r100.f478630f));
        r102.a("pkg_name", r100.f478627c);
        r102.c();
    }

    public static boolean d(String r100) {
        Intent r101 = new Intent();
        r101.setComponent(new ComponentName(r100, "com.ss.android.account.share.data.write.activity.ShareDataActivity"));
        Context r102 = f478636a;
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r101.resolveActivityInfo(r102.getPackageManager(), 65536) == null) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean f(c r100) {
        if (f478639d == true) goto L8;
        b r101 = f478637b;
        if (r101 == null) goto L8;
        r101.a();
        c(r100);
    L8:
        return true;
    }

    public static void g(c r100) {
        f478641f = false;
        if (r100.f478628d == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100.f478626b) == true) goto L9;
        f(r100);
        return;
    }

    public static final c a(fra.a r110, String r111) {
        Context r100 = f478636a;     // Catch: Exception -> L16
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();     // Catch: Exception -> L16
    L6:
        AccountManager r101 = AccountManager.get(r100);     // Catch: Exception -> L16
        Account[] r102 = r101.getAccountsByType(r110.f478624f);     // Catch: Exception -> L16
        if (r102 == null) goto L23;
        int r103 = r102.length;     // Catch: Exception -> L16
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L23;
        String r105 = r101.getUserData(r102[r104], r111);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r105) == false) goto L12;
        r104 = r104 + 1;     // Catch: Exception -> L16
        goto L9
    L12:
        c r106 = new c(r110.f478619a, true, null, 12, 0);     // Catch: Exception -> L16
        r106.f478625a = r111;     // Catch: Exception -> L16
        r106.f478630f = 1;     // Catch: Exception -> L16
        r106.f478626b = r105;     // Catch: Exception -> L16
        return r106;
    L23:
        return new c(r110.f478619a, false, "read form account failed", 1);
    L16:
        e = move-exception;
        dra.b r107 = new dra.b();
        r107.b("share_sdk_read_data_err");
        r107.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r107.a("err_msg_stack", Log.getStackTraceString(e));
        r107.c();
        return new c(r110.f478619a, false, "read form account failed with error ".concat(String.valueOf(e.getMessage())), 1);
    }

    public static final c b(fra.a r110, String r111) {
        Uri r100 = UriProtector.parse("content://" + r110.f478619a + ".SecShareProviderAuthority/sec_share/" + r111 + "?aid=" + r110.f478620b);     // Catch: Exception -> L11
        Context r101 = f478636a;     // Catch: Exception -> L11
        if (r101 != null) goto L6;
        Intrinsics.throwNpe();     // Catch: Exception -> L11
    L6:
        Cursor r102 = e(r101.getContentResolver(), r100);     // Catch: Exception -> L11
        if (r102 == null) goto L16;
        r102.moveToFirst();     // Catch: Exception -> L11
        String r103 = r102.getString(r102.getColumnIndex(r111));     // Catch: Exception -> L11
        c r104 = new c(r110.f478619a, true, null, 12, 0);     // Catch: Exception -> L11
        r104.f478625a = r111;     // Catch: Exception -> L11
        r104.f478630f = 2;     // Catch: Exception -> L11
        r104.f478626b = r103;     // Catch: Exception -> L11
        return r104;
    L16:
        return new c(r110.f478619a, false, "read form provider", 2);
    L11:
        e = move-exception;
        e.printStackTrace();
        c r105 = new c(r110.f478619a, false, String.valueOf(e.getMessage()), 2);
        dra.b r112 = new dra.b();
        r112.b("share_sdk_read_data_err");
        r112.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r112.a("err_msg_stack", Log.getStackTraceString(e));
        r112.c();
        return r105;
    }

    public static Cursor e(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }
}
