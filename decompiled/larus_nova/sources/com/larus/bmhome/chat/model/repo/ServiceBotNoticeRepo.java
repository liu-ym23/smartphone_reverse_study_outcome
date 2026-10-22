package com.larus.bmhome.chat.model.repo;

import android.util.LruCache;
import com.bytedance.keva.Keva;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class ServiceBotNoticeRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ServiceBotNoticeRepo f307747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f307748b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f307749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile FullPermissionSettings f307750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LruCache<String, DetailedPermissionSetting> f307751e = null;

    public static final class a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "LegacyDetailedCacheEntry(version=0, bootTime=0, data=null)";
        }
    }

    public static final class b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "LegacyFullCacheEntry(version=0, bootTime=0, data=null)";
        }
    }

    public ServiceBotNoticeRepo() {
    }

    static {
        f307747a = new ServiceBotNoticeRepo();
        f307748b = LazyKt.lazy(new f2());
        f307751e = new LruCache(80);
    }

    public static Keva g() {
        return (Keva) f307748b.getValue();
    }

    public static String e(String r100) {
        return AccountService.f365697a.getUserId() + '_' + r100;
    }

    public static FullPermissionSettings f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        String r101 = e(r100);
        if (Intrinsics.areEqual(f307749c, r101) == false) goto L7;
        FullPermissionSettings r102 = f307750d;
        if (r102 == null) goto L7;
        return r102;
    L7:
        FullPermissionSettings r103 = h(r101);
        if (r103 == null) goto L10;
        f307749c = r101;
        f307750d = r103;
        return r103;
    L10:
        return null;
    }

    public static FullPermissionSettings h(String r100) {
        FLogger.f375446a.i("ServiceBotNoticeRepo", "readFullCacheFromKeva key: " + r100);
        String r101 = g().getString(r100, null);
        if (r101 != null) goto L32;
        return null;
    L32:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        return (FullPermissionSettings) HttpExtKt.f360123f.fromJson(r101, FullPermissionSettings.class);
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        ((b) HttpExtKt.f360123f.fromJson(r101, b.class)).getClass();     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        f307747a.getClass();
        g().erase(r100);
        FLogger.f375446a.e("ServiceBotNoticeRepo", "readFullCacheFromKeva fail: " + r105);
    L17:
        if (Result.m9455isFailureimpl(r104) == false) goto L19;
        r104 = null;
    L19:
        FullPermissionSettings r106 = (FullPermissionSettings) r104;
        if (r106 != null) goto L30;
        return null;
    L30:
        f307747a.getClass();     // Catch: Throwable -> L24
        g().storeString(r100, HttpExtKt.f360123f.toJson(r106));     // Catch: Throwable -> L24
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L27:
        return r106;
    L24:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static String b(String r100, String r101) {
        return AccountService.f365697a.getUserId() + '_' + r100 + '_' + r101;
    }

    public static Object d(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ServiceBotNoticeRepo$fetchFullPermissionSetting$2(r100, null), r101);
    }

    public static void i(String r100, FullPermissionSettings r101) {
        String r102 = e(r100);
        f307749c = r102;
        f307750d = r101;
        FLogger.f375446a.i("ServiceBotNoticeRepo", "saveFullCache " + r102);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        g().storeString(r102, HttpExtKt.f360123f.toJson(r101));     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        FLogger.f375446a.e("ServiceBotNoticeRepo", "saveFullCache fail: " + r105);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static Object c(String r100, String r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ServiceBotNoticeRepo$fetchDetailedPermissionSetting$2(r100, r101, null), r102);
    }

    public static final void a(ServiceBotNoticeRepo r100, String r101, String r102, DetailedPermissionSetting r103) {
        r100.getClass();
        String r104 = b(r101, r102);
        FLogger.f375446a.i("ServiceBotNoticeRepo", "saveDetailedCache " + r104);
        f307751e.put(r104, r103);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L5
        g().storeString(r104, HttpExtKt.f360123f.toJson(r103));     // Catch: Throwable -> L5
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L13;
        FLogger.f375446a.e("ServiceBotNoticeRepo", "saveDetailedCache fail: " + r107);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static Object j(String r100, String r101, List r102, Continuation r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ServiceBotNoticeRepo$updateDetailedPermissionSetting$2(r100, r101, r102, null), r103);
    }
}
