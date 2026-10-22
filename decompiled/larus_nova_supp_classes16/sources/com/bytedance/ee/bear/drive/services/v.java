package com.bytedance.ee.bear.drive.services;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.google.gson.Gson;
import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.Flowable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static y85.a a() {
            y85.a r3 = (y85.a) new Gson().fromJson(ay4.b.d("drive", 6).getString("KEY_TEST_SAVE_CONFIG", null), y85.a.class);     // Catch: Exception -> L9
            StringBuilder r4 = new StringBuilder("tryToFindSaveMockData enable=");     // Catch: Exception -> L9
            if (r3 == null) goto L6;
            Boolean r1 = Boolean.valueOf(r3.a);     // Catch: Exception -> L9
        L7:
            r4.append(r1);     // Catch: Exception -> L9
            tt5.a.h("DriveSaveCacheManager", r4.toString());     // Catch: Exception -> L9
            return r3;
        L6:
            r1 = null;
        L9:
            e = move-exception;
            tt5.a.k("DriveSaveCacheManager", "tryToFindSaveMockData fail: " + e);
            return null;
        }
    }

    public interface b {
        Flowable<Boolean> a(UserSession r1);

        String getCacheKey();
    }

    public static final class c implements b {
        public final LocalSaveEntity a;
        public final String b;
        public final String c;

        @Override // com.bytedance.ee.bear.drive.services.v.b
        public final String getCacheKey() {
            return com.bytedance.ee.bear.drive.cache.t.e(this.a.getAppId(), this.a.getFileId());
        }

        @Override // com.bytedance.ee.bear.drive.services.v.b
        public final Flowable<Boolean> a(UserSession r7) {
            Intrinsics.checkNotNullParameter(r7, "userSession");
            String r0 = getCacheKey();
            String r1 = this.a.getFileId();
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            DriveFilePath r4 = i75.f.a(0).cacheName(r0);
            v85.b.a r5 = new v85.b.a();
            r5.a = 0;
            r5.b = r0;
            r5.c = r1;
            r5.d = this.b;
            Intrinsics.checkNotNull(r4);
            r5.c(r4);
            DriveFilePath.Companion.getClass();
            r5.d(DriveFilePath.a.a());
            r5.g = "";
            String r2 = this.a.getDataVersion();
            if (r2 != null) goto L8;
            r2 = "";
        L8:
            r5.h = r2;
            String r3 = this.c;
            r5.i = r3;
            r5.j = r3;
            r5.k = "";
            r5.l = "3";
            r5.m = "3";
            r5.n = false;
            r5.o = false;
            r5.t = false;
            r5.q = this.a.getAppId();
            r5.r = this.a.getAuthExtra();
            v85.b r6 = new v85.b(r5);
            return com.bytedance.ee.bear.drive.cache.t.l().m(r6, r7);
        }

        public c(LocalSaveEntity r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "saveEntity");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            Intrinsics.checkNotNullParameter(r4, "fileType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d implements b {
        public final LocalSaveEntity a;
        public final String b;
        public final String c;

        @Override // com.bytedance.ee.bear.drive.services.v.b
        public final String getCacheKey() {
            return du5.d.a(this.a.getFileId());
        }

        @Override // com.bytedance.ee.bear.drive.services.v.b
        public final Flowable<Boolean> a(UserSession r7) {
            Intrinsics.checkNotNullParameter(r7, "userSession");
            String r0 = getCacheKey();
            String r1 = this.a.getFileId();
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            DriveFilePath r4 = i75.f.a(0).cacheName(r0);
            v85.c.a r5 = new v85.c.a();
            r5.a = 0;
            r5.b = r0;
            r5.c = r1;
            r5.d = this.b;
            Intrinsics.checkNotNull(r4);
            r5.c(r4);
            DriveFilePath.Companion.getClass();
            r5.d(DriveFilePath.a.a());
            r5.g = "";
            String r2 = this.a.getDataVersion();
            if (r2 != null) goto L8;
            r2 = "";
        L8:
            r5.h = r2;
            String r3 = this.c;
            r5.i = r3;
            r5.j = r3;
            r5.k = "";
            r5.l = "3";
            r5.m = "3";
            r5.n = false;
            r5.o = false;
            r5.s = false;
            r5.q = this.a.getAppId();
            v85.c r6 = new v85.c(r5);
            return com.bytedance.ee.bear.drive.cache.t.l().m(r6, r7);
        }

        public d(LocalSaveEntity r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "saveEntity");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            Intrinsics.checkNotNullParameter(r4, "fileType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }
}
