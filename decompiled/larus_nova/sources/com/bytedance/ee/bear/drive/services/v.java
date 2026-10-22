package com.bytedance.ee.bear.drive.services;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.google.gson.Gson;
import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.Flowable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f224636a = 0;

    public static final class a {
        @JvmStatic
        public static y85.a a() {
            y85.a r100 = (y85.a) new Gson().fromJson(ay4.b.d("drive", 6).getString("KEY_TEST_SAVE_CONFIG", null), y85.a.class);     // Catch: Exception -> L9
            StringBuilder r101 = new StringBuilder("tryToFindSaveMockData enable=");     // Catch: Exception -> L9
            if (r100 == null) goto L6;
            Boolean r102 = Boolean.valueOf(r100.f566908a);     // Catch: Exception -> L9
        L7:
            r101.append(r102);     // Catch: Exception -> L9
            tt5.a.h("DriveSaveCacheManager", r101.toString());     // Catch: Exception -> L9
            return r100;
        L6:
            r102 = null;
        L9:
            e = move-exception;
            tt5.a.k("DriveSaveCacheManager", "tryToFindSaveMockData fail: " + e);
            return null;
        }
    }

    public interface b {
        Flowable<Boolean> a(UserSession r100);

        String getCacheKey();
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LocalSaveEntity f224637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f224638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f224639c;

        @Override // com.bytedance.ee.bear.drive.services.v.b
        public final String getCacheKey() {
            return com.bytedance.ee.bear.drive.cache.t.e(this.f224637a.getAppId(), this.f224637a.getFileId());
        }

        @Override // com.bytedance.ee.bear.drive.services.v.b
        public final Flowable<Boolean> a(UserSession r100) {
            Intrinsics.checkNotNullParameter(r100, "userSession");
            String r101 = getCacheKey();
            String r102 = this.f224637a.getFileId();
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            DriveFilePath r103 = i75.f.a(0).cacheName(r101);
            v85.b.a r104 = new v85.b.a();
            r104.f553694a = 0;
            r104.f553695b = r101;
            r104.f553696c = r102;
            r104.f553697d = this.f224638b;
            Intrinsics.checkNotNull(r103);
            r104.c(r103);
            DriveFilePath.Companion.getClass();
            r104.d(DriveFilePath.a.a());
            r104.f553700g = "";
            String r105 = this.f224637a.getDataVersion();
            if (r105 != null) goto L8;
            r105 = "";
        L8:
            r104.f553701h = r105;
            String r106 = this.f224639c;
            r104.f553702i = r106;
            r104.f553703j = r106;
            r104.f553704k = "";
            r104.f553705l = "3";
            r104.f553706m = "3";
            r104.f553707n = false;
            r104.f553708o = false;
            r104.f553713t = false;
            r104.f553710q = this.f224637a.getAppId();
            r104.f553711r = this.f224637a.getAuthExtra();
            v85.b r107 = new v85.b(r104);
            return com.bytedance.ee.bear.drive.cache.t.l().m(r107, r100);
        }

        public c(LocalSaveEntity r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "saveEntity");
            Intrinsics.checkNotNullParameter(r101, "fileName");
            Intrinsics.checkNotNullParameter(r102, "fileType");
            this.f224637a = r100;
            this.f224638b = r101;
            this.f224639c = r102;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LocalSaveEntity f224640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f224641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f224642c;

        @Override // com.bytedance.ee.bear.drive.services.v.b
        public final String getCacheKey() {
            return du5.d.a(this.f224640a.getFileId());
        }

        @Override // com.bytedance.ee.bear.drive.services.v.b
        public final Flowable<Boolean> a(UserSession r100) {
            Intrinsics.checkNotNullParameter(r100, "userSession");
            String r101 = getCacheKey();
            String r102 = this.f224640a.getFileId();
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            DriveFilePath r103 = i75.f.a(0).cacheName(r101);
            v85.c.a r104 = new v85.c.a();
            r104.f553694a = 0;
            r104.f553695b = r101;
            r104.f553696c = r102;
            r104.f553697d = this.f224641b;
            Intrinsics.checkNotNull(r103);
            r104.c(r103);
            DriveFilePath.Companion.getClass();
            r104.d(DriveFilePath.a.a());
            r104.f553700g = "";
            String r105 = this.f224640a.getDataVersion();
            if (r105 != null) goto L8;
            r105 = "";
        L8:
            r104.f553701h = r105;
            String r106 = this.f224642c;
            r104.f553702i = r106;
            r104.f553703j = r106;
            r104.f553704k = "";
            r104.f553705l = "3";
            r104.f553706m = "3";
            r104.f553707n = false;
            r104.f553708o = false;
            r104.f553714s = false;
            r104.f553710q = this.f224640a.getAppId();
            v85.c r107 = new v85.c(r104);
            return com.bytedance.ee.bear.drive.cache.t.l().m(r107, r100);
        }

        public d(LocalSaveEntity r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "saveEntity");
            Intrinsics.checkNotNullParameter(r101, "fileName");
            Intrinsics.checkNotNullParameter(r102, "fileType");
            this.f224640a = r100;
            this.f224641b = r101;
            this.f224642c = r102;
        }
    }

    static {
    }
}
