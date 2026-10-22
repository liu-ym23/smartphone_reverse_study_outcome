package com.bytedance.ee.bear.drive.cache;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t {
    public static volatile t b;
    public static volatile boolean c;
    public final h0 a;

    public static DriveFilePath f() {
        Biz r0 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r0, "biz");
        Intrinsics.checkNotNullParameter("offlineV2", "relativePath");
        return new DriveFilePath(r0, "offlineV2", "", false);
    }

    public static DriveFilePath g() {
        Biz r0 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r0, "biz");
        Intrinsics.checkNotNullParameter("preloadVideoV2", "relativePath");
        return new DriveFilePath(r0, "preloadVideoV2", "", false);
    }

    public static DriveFilePath h() {
        Biz r0 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r0, "biz");
        Intrinsics.checkNotNullParameter("streamingOffline", "relativePath");
        return new DriveFilePath(r0, "streamingOffline", "", false);
    }

    public static DriveFilePath j() {
        Biz r0 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r0, "biz");
        Intrinsics.checkNotNullParameter("temp", "relativePath");
        return new DriveFilePath(r0, "temp", "", false);
    }

    public static DriveFilePath k() {
        Biz r0 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r0, "biz");
        Intrinsics.checkNotNullParameter("videoOffline", "relativePath");
        return new DriveFilePath(r0, "videoOffline", "", false);
    }

    public static t l() {
        if (b != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new t();     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public t() {
        this.a = (h0) org.koin.java.a.a(h0.class);
    }

    public static String c(w75.a r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        if ((r2 instanceof f85.a) == false) goto L10;
        return du5.d.a(r2.c().a);
    L10:
        if ((r2 instanceof f85.b) == true) goto L12;
        return "";
    L12:
        return e(((f85.b.a) ((f85.b) r2).a).m, r2.c().a);
    }

    public static String d(w75.c r0) {
        if (r0 != null) goto L6;
        return "";
    L6:
        return c(r0.getDetails());
    }

    public static void n(y75.b r2) {
        Flowable.just(r2).observeOn(fo5.d.b()).subscribe(new o(), new p());
    }

    public static Flowable o(final String r2) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new e()).map(new f(r2));
    }

    public static String e(String r2, String r3) {
        return du5.d.a("_drivesdk_" + r2 + OfflineDoc.DASH_DELIMITER + r3);
    }

    public static void q(final String r2, final String r3) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new q()).map(new r(r2, r3)).subscribe(new s(), new b());
    }

    public final Flowable<Boolean> m(final v85.a r3, final UserSession r4) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new a()).map(new k(this, r3, r4));
    }

    public static DriveCache i(final String r2, final boolean r3, final a95.a r4) {
        return (DriveCache) Flowable.just("").subscribeOn(fo5.d.b()).map(new c()).map(new d(r2, r3, r4)).blockingSingle();
    L4:
        e = move-exception;
        if (e.getMessage() != null) goto L8;
    L10:
        tt5.a.e("DriveCacheManager", "getSync exception, key = " + r2, e, false);
        return null;
    L8:
        if (e.getMessage().contains("The mapper function returned a null value") == false) goto L10;
        tt5.a.h("DriveCacheManager", "cache not hit, key = " + r2);
        return null;
    }

    public static f85.a a(String r24, DriveCache r26, String r27, a95.a r28) {
        if (r26 != null) goto L5;
    L17:
        tt5.a.d("DriveCacheManager", "driveCache or token is null");
        return null;
    L5:
        if (TextUtils.isEmpty(r24) == true) goto L17;
        if (r26.b == null) goto L17;
        f85.a r3 = new f85.a(new f85.a.C0229a(r26.j, r26.a(r28.b), null, 0, "", r26.r, r24, "", "", "", r26.e, "", 0, 0, r27, null, r26.t));
        r3.f(true);
        r3.m = r26.getType();
        r3.v = r26.f;
        r3.w = r26.g;
        DriveFilePath r2 = r26.b;
        UserSession r1 = r28.b;
        if (z75.b.d(r2, r1) == false) goto L11;
        r3.k = r2;
        String r4 = "DriveCacheManager";
    L12:
        DriveFilePath r5 = r26.c;
        if (z75.b.d(r5, r1) == false) goto L15;
        r3.l = r5;
    L15:
        r3.f = r26.d;
        r3.h = r26.m;
        r3.r = r26.q;
        r3.g(r26.s);
        tt5.a.h(r4, "file model cache file find success. objToken=" + du5.b.g(r24));
        return r3;
    L11:
        r4 = "DriveCacheManager";
        tt5.a.k(r4, "convertDriveCacheToFileModel() file not exists");
        goto L12
    }

    public static y75.b b(String r6, String r7, String r8, String r9) {
        com.bytedance.ee.bear.drive.dao.e r0 = (com.bytedance.ee.bear.drive.dao.e) com.bytedance.ee.bear.drive.dao.c.c().b();
        r0.getClass();
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM drive_excel_sub_cache WHERE sdk_app_id = ? AND obj_token = ? AND data_version = ? AND sub_id = ?", 4);
        if (r6 != null) goto L5;
        r1.bindNull(1);
    L7:
        if (r7 != null) goto L9;
        r1.bindNull(2);
    L11:
        if (r8 != null) goto L13;
        r1.bindNull(3);
    L14:
        if (r9 != null) goto L16;
        r1.bindNull(4);
    L17:
        r0.a.assertNotSuspendingTransaction();
        y75.b r10 = null;
        Cursor r11 = DBUtil.query(r0.a, r1, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r11, "sdk_app_id");     // Catch: Throwable -> L23
        int r13 = CursorUtil.getColumnIndexOrThrow(r11, "obj_token");     // Catch: Throwable -> L23
        int r2 = CursorUtil.getColumnIndexOrThrow(r11, "data_version");     // Catch: Throwable -> L23
        int r3 = CursorUtil.getColumnIndexOrThrow(r11, "sub_id");     // Catch: Throwable -> L23
        int r4 = CursorUtil.getColumnIndexOrThrow(r11, "json_data_file_path");     // Catch: Throwable -> L23
        int r5 = CursorUtil.getColumnIndexOrThrow(r11, "json_data");     // Catch: Throwable -> L23
        if (r11.moveToFirst() == false) goto L21;
        r10 = new y75.b();     // Catch: Throwable -> L23
        r10.a = r11.getString(r12);     // Catch: Throwable -> L23
        r10.b = r11.getString(r13);     // Catch: Throwable -> L23
        r10.c = r11.getString(r2);     // Catch: Throwable -> L23
        r10.d = r11.getString(r3);     // Catch: Throwable -> L23
        r10.e = r11.getString(r4);     // Catch: Throwable -> L23
        r10.f = r11.getString(r5);     // Catch: Throwable -> L23
    L21:
        r11.close();
        r1.release();
        return r10;
    L23:
        th = move-exception;
        r11.close();
        r1.release();
        throw th;
    L16:
        r1.bindString(4, r9);
        goto L17
    L13:
        r1.bindString(3, r8);
        goto L14
    L9:
        r1.bindString(2, r7);
        goto L11
    L5:
        r1.bindString(1, r6);
        goto L7
    }

    public static Flowable p(final String r1, final String r2, final String r3, final a95.a r4) {
        return Flowable.fromCallable(new l(r4, r2, r3, r1)).subscribeOn(fo5.d.b()).map(new m()).map(new n(r1));
    }
}
