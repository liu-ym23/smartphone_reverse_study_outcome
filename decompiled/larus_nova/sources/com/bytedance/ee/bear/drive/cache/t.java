package com.bytedance.ee.bear.drive.cache;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.model.SubInfo;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile t f224065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f224066c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f224067a;

    public static DriveFilePath f() {
        Biz r100 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter("offlineV2", "relativePath");
        return new DriveFilePath(r100, "offlineV2", "", false);
    }

    public static DriveFilePath g() {
        Biz r100 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter("preloadVideoV2", "relativePath");
        return new DriveFilePath(r100, "preloadVideoV2", "", false);
    }

    public static DriveFilePath h() {
        Biz r100 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter("streamingOffline", "relativePath");
        return new DriveFilePath(r100, "streamingOffline", "", false);
    }

    public static DriveFilePath j() {
        Biz r100 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter("temp", "relativePath");
        return new DriveFilePath(r100, "temp", "", false);
    }

    public static DriveFilePath k() {
        Biz r100 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter("videoOffline", "relativePath");
        return new DriveFilePath(r100, "videoOffline", "", false);
    }

    public static t l() {
        if (f224065b != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f224065b != null) goto L9;
        f224065b = new t();     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return f224065b;
    }

    public t() {
        this.f224067a = (h0) org.koin.java.a.a(h0.class);
    }

    public static String c(w75.a r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof f85.a) == false) goto L10;
        return du5.d.a(r100.c().f558557a);
    L10:
        if ((r100 instanceof f85.b) == true) goto L12;
        return "";
    L12:
        return e(((f85.b.a) ((f85.b) r100).f558532a).f475877m, r100.c().f558557a);
    }

    public static String d(w75.c r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return c(r100.getDetails());
    }

    public static void n(y75.b r100) {
        Flowable.just(r100).observeOn(fo5.d.b()).subscribe(new o(), new p());
    }

    public static Flowable o(final String r100) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new e()).map(new f(r100));
    }

    public static String e(String r100, String r101) {
        return du5.d.a("_drivesdk_" + r100 + "_" + r101);
    }

    public static void q(final String r100, final String r101) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new q()).map(new r(r100, r101)).subscribe(new s(), new b());
    }

    public final Flowable<Boolean> m(final v85.a r100, final UserSession r101) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new a()).map(new k(this, r100, r101));
    }

    public static DriveCache i(final String r100, final boolean r101, final a95.a r102) {
        return (DriveCache) Flowable.just("").subscribeOn(fo5.d.b()).map(new c()).map(new d(r100, r101, r102)).blockingSingle();
    L4:
        e = move-exception;
        if (e.getMessage() != null) goto L8;
    L10:
        tt5.a.e("DriveCacheManager", "getSync exception, key = " + r100, e, false);
        return null;
    L8:
        if (e.getMessage().contains("The mapper function returned a null value") == false) goto L10;
        tt5.a.h("DriveCacheManager", "cache not hit, key = " + r100);
        return null;
    }

    public static f85.a a(String r210, DriveCache r211, String r212, a95.a r213) {
        if (r211 != null) goto L5;
    L17:
        tt5.a.d("DriveCacheManager", "driveCache or token is null");
        return null;
    L5:
        if (TextUtils.isEmpty(r210) == true) goto L17;
        if (r211.f216968b == null) goto L17;
        f85.a r100 = new f85.a(new f85.a.C5868a(r211.f216976j, r211.a(r213.f2278b), null, 0, "", r211.f216984r, r210, "", "", "", r211.f216971e, "", 0, 0, r212, null, r211.f216986t));
        r100.f(true);
        r100.f558544m = r211.getType();
        r100.f558553v = r211.f216972f;
        r100.f558554w = r211.f216973g;
        DriveFilePath r101 = r211.f216968b;
        UserSession r102 = r213.f2278b;
        if (z75.b.d(r101, r102) == false) goto L11;
        r100.f558542k = r101;
        String r103 = "DriveCacheManager";
    L12:
        DriveFilePath r104 = r211.f216969c;
        if (z75.b.d(r104, r102) == false) goto L15;
        r100.f558543l = r104;
    L15:
        r100.f558537f = r211.f216970d;
        r100.f558539h = r211.f216979m;
        r100.f558549r = r211.f216983q;
        r100.g(r211.f216985s);
        tt5.a.h(r103, "file model cache file find success. objToken=" + du5.b.g(r210));
        return r100;
    L11:
        r103 = "DriveCacheManager";
        tt5.a.k(r103, "convertDriveCacheToFileModel() file not exists");
        goto L12
    }

    public static y75.b b(String r100, String r101, String r102, String r103) {
        com.bytedance.ee.bear.drive.dao.e r104 = (com.bytedance.ee.bear.drive.dao.e) com.bytedance.ee.bear.drive.dao.c.c().b();
        r104.getClass();
        RoomSQLiteQuery r105 = RoomSQLiteQuery.acquire("SELECT * FROM drive_excel_sub_cache WHERE sdk_app_id = ? AND obj_token = ? AND data_version = ? AND sub_id = ?", 4);
        if (r100 != null) goto L5;
        r105.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r105.bindNull(2);
    L11:
        if (r102 != null) goto L13;
        r105.bindNull(3);
    L14:
        if (r103 != null) goto L16;
        r105.bindNull(4);
    L17:
        r104.f224398a.assertNotSuspendingTransaction();
        y75.b r106 = null;
        Cursor r107 = DBUtil.query(r104.f224398a, r105, false, null);
        int r108 = CursorUtil.getColumnIndexOrThrow(r107, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L23
        int r109 = CursorUtil.getColumnIndexOrThrow(r107, "obj_token");     // Catch: Throwable -> L23
        int r110 = CursorUtil.getColumnIndexOrThrow(r107, "data_version");     // Catch: Throwable -> L23
        int r111 = CursorUtil.getColumnIndexOrThrow(r107, SubInfo.KEY_SUB_ID);     // Catch: Throwable -> L23
        int r112 = CursorUtil.getColumnIndexOrThrow(r107, "json_data_file_path");     // Catch: Throwable -> L23
        int r113 = CursorUtil.getColumnIndexOrThrow(r107, "json_data");     // Catch: Throwable -> L23
        if (r107.moveToFirst() == false) goto L21;
        r106 = new y75.b();     // Catch: Throwable -> L23
        r106.f566619a = r107.getString(r108);     // Catch: Throwable -> L23
        r106.f566620b = r107.getString(r109);     // Catch: Throwable -> L23
        r106.f566621c = r107.getString(r110);     // Catch: Throwable -> L23
        r106.f566622d = r107.getString(r111);     // Catch: Throwable -> L23
        r106.f566623e = r107.getString(r112);     // Catch: Throwable -> L23
        r106.f566624f = r107.getString(r113);     // Catch: Throwable -> L23
    L21:
        r107.close();
        r105.release();
        return r106;
    L23:
        th = move-exception;
        r107.close();
        r105.release();
        throw th;
    L16:
        r105.bindString(4, r103);
        goto L17
    L13:
        r105.bindString(3, r102);
        goto L14
    L9:
        r105.bindString(2, r101);
        goto L11
    L5:
        r105.bindString(1, r100);
        goto L7
    }

    public static Flowable p(final String r100, final String r101, final String r102, final a95.a r103) {
        return Flowable.fromCallable(new l(r103, r101, r102, r100)).subscribeOn(fo5.d.b()).map(new m()).map(new n(r100));
    }
}
