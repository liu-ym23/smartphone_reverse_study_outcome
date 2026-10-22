package vka;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import zka.r;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f555548a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ContentProviderClient f555549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f555550c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f555551d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f555552e = null;

    public f() {
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [vka.e] */
    static {
        f555548a = new f();
        f555550c = LazyKt.lazy(new c());
        f555551d = LazyKt.lazy(new d());
        f555552e = new e();
    }

    public static Handler b() {
        return (Handler) f555550c.getValue();
    }

    public static Context c() {
        return AppHost.f326268a.getApplication();
    }

    public static ContentResolver d() {
        return c().getContentResolver();
    }

    public static ContentProviderClient a(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, null, r112, false);
        return (ContentProviderClient) r113.f474983b;
    L6:
        ContentProviderClient r114 = r110.acquireContentProviderClient(r111);
        r100.a(240016, "android/content/ContentResolver", "acquireContentProviderClient", r110, r101, r114, r112, true);
        return r114;
    }

    public final Long insert(ala.e r100, ContentValues r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        r.a r102 = r.f572736a;
        Context r103 = c();
        r102.getClass();
        if (r.a.a(r103) == false) goto L18;
        Uri r104 = r100.toUri();
        Handler r105 = b();
        monitor-enter(r105);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f555549b != null) goto L9;
        f555549b = a(d(), r104);     // Catch: Throwable -> L15
    L9:
        Handler r106 = b();     // Catch: Throwable -> L15
        e r107 = f555552e;     // Catch: Throwable -> L15
        r106.removeCallbacks(r107);     // Catch: Throwable -> L15
        b().postDelayed(r107, 30000);     // Catch: Throwable -> L15
        ContentProviderClient r108 = f555549b;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L15
        Uri r109 = r108.insert(r100.toUri(), r101);     // Catch: Throwable -> L15
        monitor-exit(r105);
        if (r109 == null) goto L22;
        String r110 = r109.getLastPathSegment();
        if (r110 != null) goto L24;
        return null;
    L24:
        return Long.valueOf(CastLongProtector.parseLong(r110));
    L22:
        return null;
    L18:
        SQLiteDatabase r111 = (SQLiteDatabase) f555551d.getValue();
        ala.e.f4209a.getClass();
        return Long.valueOf(r111.insert(ala.e.a.a(r100), null, r101));
    }

    public static Pair e(ala.e r100, String r101, String[] r102) {
        Long r103 = r100.getId();
        if (r103 == null) goto L20;
        long r104 = r103.longValue();
        if (r101 != null) goto L7;
    L10:
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        String r106 = "_id = ?";
    L14:
        SpreadBuilder r107 = new SpreadBuilder(2);
        r107.add(String.valueOf(r104));
        if (r102 != null) goto L17;
        r102 = new String[0];
    L17:
        r107.addSpread(r102);
        return TuplesKt.to(r106, (String[]) r107.toArray(new String[r107.size()]));
    L13:
        r106 = "_id = ? AND (" + r101 + ')';
        goto L14
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r105 = false;
        goto L11
    L20:
        return TuplesKt.to(r101, r102);
    }

    public final int delete(ala.e r100, String r101, String[] r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        r.a r103 = r.f572736a;
        Context r104 = c();
        r103.getClass();
        if (r.a.a(r104) == false) goto L15;
        Uri r105 = r100.toUri();
        Handler r106 = b();
        monitor-enter(r106);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f555549b != null) goto L9;
        f555549b = a(d(), r105);     // Catch: Throwable -> L12
    L9:
        Handler r107 = b();     // Catch: Throwable -> L12
        e r108 = f555552e;     // Catch: Throwable -> L12
        r107.removeCallbacks(r108);     // Catch: Throwable -> L12
        b().postDelayed(r108, 30000);     // Catch: Throwable -> L12
        ContentProviderClient r109 = f555549b;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L12
        int r110 = r109.delete(r100.toUri(), r101, r102);     // Catch: Throwable -> L12
        monitor-exit(r106);
        return r110;
    L15:
        Pair r111 = e(r100, r101, r102);
        String r112 = (String) r111.component1();
        String[] r113 = (String[]) r111.component2();
        SQLiteDatabase r114 = (SQLiteDatabase) f555551d.getValue();
        ala.e.f4209a.getClass();
        return r114.delete(ala.e.a.a(r100), r112, r113);
    }

    public final int update(ala.e r100, ContentValues r101, String r102, String[] r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        r.a r104 = r.f572736a;
        Context r105 = c();
        r104.getClass();
        if (r.a.a(r105) == false) goto L15;
        Uri r106 = r100.toUri();
        Handler r107 = b();
        monitor-enter(r107);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f555549b != null) goto L9;
        f555549b = a(d(), r106);     // Catch: Throwable -> L12
    L9:
        Handler r108 = b();     // Catch: Throwable -> L12
        e r109 = f555552e;     // Catch: Throwable -> L12
        r108.removeCallbacks(r109);     // Catch: Throwable -> L12
        b().postDelayed(r109, 30000);     // Catch: Throwable -> L12
        ContentProviderClient r110 = f555549b;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L12
        int r111 = r110.update(r100.toUri(), r101, r102, r103);     // Catch: Throwable -> L12
        monitor-exit(r107);
        return r111;
    L15:
        Pair r112 = e(r100, r102, r103);
        String r113 = (String) r112.component1();
        String[] r114 = (String[]) r112.component2();
        SQLiteDatabase r115 = (SQLiteDatabase) f555551d.getValue();
        ala.e.f4209a.getClass();
        return r115.update(ala.e.a.a(r100), r101, r113, r114);
    }

    public final Cursor query(ala.e r100, String[] r110, String r111, String[] r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "token");
        r.a r101 = r.f572736a;
        Context r102 = c();
        r101.getClass();
        if (r.a.a(r102) == false) goto L15;
        Uri r103 = r100.toUri();
        Handler r104 = b();
        monitor-enter(r104);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f555549b != null) goto L9;
        f555549b = a(d(), r103);     // Catch: Throwable -> L12
    L9:
        Handler r105 = b();     // Catch: Throwable -> L12
        e r106 = f555552e;     // Catch: Throwable -> L12
        r105.removeCallbacks(r106);     // Catch: Throwable -> L12
        b().postDelayed(r106, 30000);     // Catch: Throwable -> L12
        ContentProviderClient r107 = f555549b;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L12
        Cursor r114 = r107.query(r103, r110, r111, r112, r113);     // Catch: Throwable -> L12
        monitor-exit(r104);
        return r114;
    L15:
        Pair r115 = e(r100, r111, r112);
        String r108 = (String) r115.component1();
        String[] r109 = (String[]) r115.component2();
        SQLiteDatabase r116 = (SQLiteDatabase) f555551d.getValue();
        ala.e.f4209a.getClass();
        return r116.query(ala.e.a.a(r100), r110, r108, r109, null, null, r113);
    }
}
