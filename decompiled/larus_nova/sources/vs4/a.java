package vs4;

import com.bytedance.ee.bear.bitable.homepage.recommend.report.LoadFrom;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f556983a = 0;

    /* JADX INFO: renamed from: vs4.a$a, reason: collision with other inner class name */
    public static final class C8038a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f556984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f556985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f556986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f556987d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f556988e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f556989f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8038a) == true) goto L8;
            return false;
        L8:
            C8038a r101 = (C8038a) r100;
            if (this.f556984a == r101.f556984a) goto L12;
            return false;
        L12:
            if (this.f556985b == r101.f556985b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f556986c, r101.f556986c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f556987d, r101.f556987d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f556988e, r101.f556988e) == true) goto L24;
            return false;
        L24:
            if (this.f556989f == r101.f556989f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f556984a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f556985b) * 31;
            String r102 = this.f556986c;
            int r103 = 0;
            if (r102 != null) goto L5;
            int r104 = 0;
        L6:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f556987d;
            if (r106 != null) goto L9;
            int r107 = 0;
        L10:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f556988e;
            if (r109 == null) goto L14;
            r103 = r109.hashCode();
        L14:
            int r110 = (r108 + r103) * 31;
            long r111 = this.f556989f;
            return r110 + ((int) (r111 ^ (r111 >>> 32)));
        L9:
            r107 = r106.hashCode();
            goto L10
        L5:
            r104 = r102.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportRecommendViewParams(duration=" + this.f556984a + ", errorCode=" + this.f556985b + ", errorMsg=" + this.f556986c + ", loadType=" + this.f556987d + ", requestId=" + this.f556988e + ", requestIndex=" + this.f556989f + ')';
        }

        public C8038a(long r100, int r101, String r102, String r103, String r104, long r105) {
            this.f556984a = r100;
            this.f556985b = r101;
            this.f556986c = r102;
            this.f556987d = r103;
            this.f556988e = r104;
            this.f556989f = r105;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f556990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f556991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f556992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LoadFrom f556993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f556994e;

        public b(boolean r100, long r101, String r102, LoadFrom r103, String r104) {
            this.f556990a = r100;
            this.f556991b = r101;
            this.f556992c = r102;
            this.f556993d = r103;
            this.f556994e = r104;
        }

        public final void a() {
            boolean r100 = this.f556990a;
            long r101 = this.f556991b;
            String r102 = this.f556992c;
            LoadFrom r103 = this.f556993d;
            String r104 = this.f556994e;
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L13
            JSONObject r106 = new JSONObject();     // Catch: Throwable -> L13
            r106.put("isSuccess", r100);     // Catch: Throwable -> L13
            r106.put(ComplianceResult.JsonKey.REQUEST_DURATION, r101);     // Catch: Throwable -> L13
            r106.put("error_msg", r102);     // Catch: Throwable -> L13
            r106.put(ResourceData.KEY_LOAD_FROM, r103);     // Catch: Throwable -> L13
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.homepage.new.native.enable") == true) goto L6;
            boolean r107 = true;
        L7:
            r106.put("recommend_h5", r107);     // Catch: Throwable -> L13
            r106.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r104);     // Catch: Throwable -> L13
            lc5.f.a r108 = lc5.f.f508440a;     // Catch: Throwable -> L13
            com.bytedance.ee.bear.contract.d r109 = lc5.f.a.d();     // Catch: Throwable -> L13
            if (r109 == null) goto L10;
            r109.i("ccm_base_homepage_xyz_load_view", r106);     // Catch: Throwable -> L13
            Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L13
        L11:
            Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L13
        L15:
            Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
            if (r112 == null) goto L21;
            tt5.a.e("BitablePerformanceReport", "reportXyzLoadResult error", r112, false);
            return;
        L21:
            return;
        L10:
            r110 = null;
            goto L11
        L6:
            r107 = false;
        L13:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public a() {
    }

    public static /* synthetic */ void b(LoadFrom r100, String r101, long r102) {
        a(true, r100, r101, r102, "");
    }

    public static void a(boolean r100, LoadFrom r110, String r111, long r112, String r113) {
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r100, r112, r113, r110, r111));
    }
}
