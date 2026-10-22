package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.StringUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f408160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f408161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f408162c;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[][] f408163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, C4722a> f408164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f408165c;

        /* JADX INFO: renamed from: com.ss.android.common.applog.j$a$a, reason: collision with other inner class name */
        public class C4722a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f408166a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f408167b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f408168c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f408169d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public long f408170e;

            public C4722a() {
            }
        }

        public a(j r100) {
            this.f408165c = r100;
            this.f408163a = new long[][]{new long[]{120000, 0, 12}, new long[]{120000, 5, 1}, new long[]{com.heytap.mcssdk.constant.a.f276323j, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
            this.f408164b = new HashMap();
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f408171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f408172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f408173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f408174d;

        public b() {
            this.f408171a = 0;
            this.f408172b = 6;
            this.f408173c = 0;
            this.f408174d = 0;
        }
    }

    public j(Context r100) {
        this.f408160a = r100;
        this.f408161b = new a(this);
        this.f408162c = new b();
    }

    public final boolean c(String r110) {
        a r100 = this.f408161b;
        monitor-enter(r100);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (StringUtils.isEmpty(r110) == false) goto L7;
    L17:
        monitor-exit(r100);
        return true;
    L7:
        if (((HashMap) r100.f408164b).containsKey(r110) == false) goto L17;
        a.C4722a r111 = (a.C4722a) ((HashMap) r100.f408164b).get(r110);     // Catch: Throwable -> L19
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L19
        long r102 = r101 - r111.f408169d;     // Catch: Throwable -> L19
        long[] r103 = r100.f408163a[r111.f408166a];     // Catch: Throwable -> L19
        if (r102 < r103[0]) goto L11;
        r111.f408167b = 1;     // Catch: Throwable -> L19
        r111.f408169d = r101;     // Catch: Throwable -> L19
        goto L17
    L11:
        int r104 = r111.f408167b;     // Catch: Throwable -> L19
        if (r104 >= r103[2]) goto L15;
        r111.f408167b = r104 + 1;     // Catch: Throwable -> L19
        goto L17
    L15:
        monitor-exit(r100);
        return false;
    }

    public final void d(JSONObject r100) {
        b r101 = this.f408162c;
        if (r101 == null) goto L26;
        int r102 = r100.optInt("backoff_ratio", 0);
        r101.f408171a = r102;
        if (r102 >= 0) goto L7;
    L8:
        r101.f408171a = 0;
    L10:
        if (r101.f408171a <= 0) goto L12;
        int r103 = 1;
    L13:
        int r104 = r100.optInt("max_request_frequency", r103);
        r101.f408172b = r104;
        if (r104 < 1) goto L16;
        if (r104 > 6) goto L16;
    L17:
        int r105 = r101.f408171a;
        if (r105 > 0) goto L20;
    L22:
        if (r105 != 0) goto L24;
        r101.f408173c = 0;
        r101.f408174d = 0;
    L24:
        ita.j.g("RatioDowngradeStrategy updateRatioDowngradeParams mBackoffRatio: " + r101.f408171a + ", mMaxRequestFrequency: " + r101.f408172b + ", mBackoffWindowStartTime: " + r101.f408173c + ", mBackoffWindowSendCount: " + r101.f408174d, null);
        return;
    L20:
        if (r101.f408173c != 0) goto L22;
        r101.f408173c = System.currentTimeMillis();
        r101.f408174d = 1;
    L16:
        r101.f408172b = r103;
        goto L17
    L12:
        r103 = 6;
        goto L13
    L7:
        if (r102 <= 10000) goto L10;
    }

    public final void b(int r110, String[] r111) {
        a r100 = this.f408161b;
        monitor-enter(r100);
        String r112 = r111[r110];     // Catch: Throwable -> L28
        if (StringUtils.isEmpty(r112) == false) goto L7;
    L26:
        monitor-exit(r100);
        return;
    L7:
        if (((HashMap) r100.f408164b).containsKey(r112) == false) goto L26;
        a.C4722a r101 = (a.C4722a) ((HashMap) r100.f408164b).get(r112);     // Catch: Throwable -> L28
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L28
        int r103 = r101.f408168c;     // Catch: Throwable -> L28
        long r104 = r103;
        long[][] r105 = r100.f408163a;     // Catch: Throwable -> L28
        int r106 = r101.f408166a;     // Catch: Throwable -> L28
        if (r104 < r105[r106][1]) goto L11;
    L14:
        if (r106 <= 0) goto L26;
        r101.f408166a = r106 - 1;     // Catch: Throwable -> L28
        r101.f408167b = 1;     // Catch: Throwable -> L28
        r101.f408168c = 1;     // Catch: Throwable -> L28
        r101.f408169d = r102;     // Catch: Throwable -> L28
        r101.f408170e = r102;     // Catch: Throwable -> L28
        int r107 = 0;
        SharedPreferences.Editor r108 = r100.f408165c.f408160a.getSharedPreferences(kta.b.f506097a, 0).edit();     // Catch: Throwable -> L28
        int r109 = r111.length;     // Catch: Throwable -> L28
    L16:
        if (r107 >= r109) goto L25;
        String r113 = r111[r107];     // Catch: Throwable -> L28
        if (StringUtils.isEmpty(r113) == true) goto L24;
        if (r113.equals(r112) == true) goto L24;
        if (((HashMap) r100.f408164b).containsKey(r113) == false) goto L24;
        a.C4722a r114 = (a.C4722a) ((HashMap) r100.f408164b).get(r113);     // Catch: Throwable -> L28
        r114.getClass();     // Catch: Throwable -> L28
        r114.f408166a = r101.f408166a;     // Catch: Throwable -> L28
        r114.f408167b = r101.f408167b;     // Catch: Throwable -> L28
        r114.f408168c = r101.f408168c;     // Catch: Throwable -> L28
        r114.f408169d = r101.f408169d;     // Catch: Throwable -> L28
        r114.f408170e = r101.f408170e;     // Catch: Throwable -> L28
        r108.putLong(r113 + "_downgrade_time", r102);     // Catch: Throwable -> L28
        r108.putInt(r113 + "_downgrade_index", r114.f408166a);     // Catch: Throwable -> L28
    L24:
        r107 = r107 + 1;     // Catch: Throwable -> L28
        goto L16
    L25:
        r108.putLong(r112 + "_downgrade_time", r102);     // Catch: Throwable -> L28
        r108.putInt(r112 + "_downgrade_index", r101.f408166a);     // Catch: Throwable -> L28
        r108.commit();     // Catch: Throwable -> L28
        goto L26
    L11:
        if ((r102 - r101.f408170e) > 1800000) goto L14;
        r101.f408168c = r103 + 1;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final void a(int r110, String[] r111, Throwable r112) {
        a r100 = this.f408161b;
        monitor-enter(r100);
    L30:
        th = move-exception;
        throw th;
    L5:
        if ((r112 instanceof CommonHttpException) == false) goto L28;
        int r113 = ((CommonHttpException) r112).getResponseCode();     // Catch: Throwable -> L30
        if (r113 < 500) goto L28;
        if (r113 >= 600) goto L28;
        String r114 = r111[r110];     // Catch: Throwable -> L30
        if (StringUtils.isEmpty(r114) == true) goto L28;
        if (((HashMap) r100.f408164b).containsKey(r114) == false) goto L28;
        a.C4722a r115 = (a.C4722a) ((HashMap) r100.f408164b).get(r114);     // Catch: Throwable -> L30
        int r101 = r115.f408166a;     // Catch: Throwable -> L30
        int r102 = 0;
        if (r101 >= (r100.f408163a.length - 1)) goto L27;
        r115.f408166a = r101 + 1;     // Catch: Throwable -> L30
        r115.f408167b = 1;     // Catch: Throwable -> L30
        r115.f408168c = 0;     // Catch: Throwable -> L30
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L30
        r115.f408169d = r103;     // Catch: Throwable -> L30
        r115.f408170e = r103;     // Catch: Throwable -> L30
        SharedPreferences.Editor r104 = r100.f408165c.f408160a.getSharedPreferences(kta.b.f506097a, 0).edit();     // Catch: Throwable -> L30
        int r105 = r111.length;     // Catch: Throwable -> L30
    L17:
        if (r102 >= r105) goto L26;
        String r106 = r111[r102];     // Catch: Throwable -> L30
        if (StringUtils.isEmpty(r106) == true) goto L25;
        if (r106.equals(r114) == true) goto L25;
        if (((HashMap) r100.f408164b).containsKey(r106) == false) goto L25;
        a.C4722a r107 = (a.C4722a) ((HashMap) r100.f408164b).get(r106);     // Catch: Throwable -> L30
        r107.getClass();     // Catch: Throwable -> L30
        r107.f408166a = r115.f408166a;     // Catch: Throwable -> L30
        r107.f408167b = r115.f408167b;     // Catch: Throwable -> L30
        r107.f408168c = r115.f408168c;     // Catch: Throwable -> L30
        r107.f408169d = r115.f408169d;     // Catch: Throwable -> L30
        r107.f408170e = r115.f408170e;     // Catch: Throwable -> L30
        r104.putLong(r106 + "_downgrade_time", r103);     // Catch: Throwable -> L30
        r104.putInt(r106 + "_downgrade_index", r107.f408166a);     // Catch: Throwable -> L30
    L25:
        r102 = r102 + 1;     // Catch: Throwable -> L30
        goto L17
    L26:
        r104.putLong(r114 + "_downgrade_time", r103);     // Catch: Throwable -> L30
        r104.putInt(r114 + "_downgrade_index", r115.f408166a);     // Catch: Throwable -> L30
        r104.commit();     // Catch: Throwable -> L30
        goto L28
    L27:
        r115.f408168c = 0;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r100);
    }
}
