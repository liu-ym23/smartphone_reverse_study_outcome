package com.bytedance.bdturing.livedetect;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.EventReport;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import qb4.c0;
import rb4.e;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.bytedance.bdturing.setting.c.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f201891f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f201892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f201893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f201894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f201895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f201896e;

    /* JADX INFO: renamed from: com.bytedance.bdturing.livedetect.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public class RunnableC2910a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f201897a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f201897a.g() == true) goto L9;
            a.b(this.f201897a);     // Catch: Throwable -> L6
            this.f201897a.e("setting_update", null);     // Catch: Throwable -> L6
            return;
        }

        public RunnableC2910a(a r100) {
            this.f201897a = r100;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f201898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f201899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f201900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f201901d;

        /* JADX INFO: renamed from: com.bytedance.bdturing.livedetect.a$b$a, reason: collision with other inner class name */
        public class RunnableC2911a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f201902a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f201903b;

            @Override // java.lang.Runnable
            public final void run() {
                b r100 = this.f201903b;     // Catch: Throwable -> L6
                a r101 = r100.f201901d;     // Catch: Throwable -> L6
                String r102 = r100.f201900c;     // Catch: Throwable -> L6
                c r103 = this.f201902a;     // Catch: Throwable -> L6
                r101.getClass();     // Catch: Throwable -> L6
                e r104 = e.a();     // Catch: Throwable -> L6
                com.bytedance.bdturing.livedetect.b r105 = new com.bytedance.bdturing.livedetect.b(r101, r102, r103);     // Catch: Throwable -> L6
                PThreadPoolExecutor r106 = r104.f536929a;     // Catch: Throwable -> L6
                if (r106 == null) goto L9;
                r106.execute(r105);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }

            public RunnableC2911a(b r100, c r101) {
                this.f201903b = r100;
                this.f201902a = r101;
            }
        }

        @Override // com.bytedance.bdturing.livedetect.a.c
        public final void G0(boolean r110, String r111) {
            long r100 = System.currentTimeMillis() - this.f201898a;
            if (TextUtils.isEmpty(r111) == true) goto L5;
            String r101 = r111;
        L6:
            String r102 = this.f201899b;
            JSONObject r103 = new JSONObject();     // Catch: Exception -> L13
            r103.put("key", EventConstant.Value.LOAD_MODEL);     // Catch: Exception -> L13
            if (r110 == false) goto L10;
            int r104 = 0;
        L11:
            r103.put("result", r104);     // Catch: Exception -> L13
            r103.put("custom", r102);     // Catch: Exception -> L13
            r103.put("duration", r100);     // Catch: Exception -> L13
            r103.put("msg", r101);     // Catch: Exception -> L13
            EventReport.w("turing_verify_sdk", r103, null);     // Catch: Exception -> L13
        L15:
            if (r110 == true) goto L19;
            a r105 = this.f201901d;
            int r106 = r105.f201892a;
            if (r106 >= 1) goto L19;
            r105.f201892a = r106 + 1;
            c0.a.f532328a.b(new RunnableC2911a(this, this), 500);
            return;
        L19:
            a r107 = this.f201901d;
            r107.f201894c = false;
            r107.f201892a = 0;
            if (r110 == true) goto L22;
            r107.f201896e++;
        L22:
            Iterator r108 = ((ArrayList) r107.f201895d).iterator();
        L24:
            if (r108.hasNext() == false) goto L31;
            c r109 = (c) r108.next();
            if (r109 == null) goto L24;
            r109.G0(r110, r111);     // Catch: Exception -> L29
        L29:
            e = move-exception;
            e.printStackTrace();
            goto L24
        L31:
            ((ArrayList) r107.f201895d).clear();
            return;
        L10:
            r104 = 1;
        L13:
            e = move-exception;
            e.printStackTrace();
            goto L15
        L5:
            r101 = "";
            goto L6
        }

        public b(a r100, long r101, String r102, String r103) {
            this.f201901d = r100;
            this.f201898a = r101;
            this.f201899b = r102;
            this.f201900c = r103;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public interface c {
        void G0(boolean r100, String r101);
    }

    public static a f() {
        if (f201891f != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f201891f != null) goto L9;
        f201891f = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f201891f;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f201893b) == false) goto L5;
        return "";
    L5:
        String r100 = vb4.e.f("detect_md5");
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return "";
    L9:
        return this.f201893b + File.separator + r100;
    }

    public final boolean g() {
        if (TextUtils.isEmpty(this.f201893b) == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r100 = new PolarisFileWrapper(d());
        PolarisFileWrapper r101 = new PolarisFileWrapper(h());
        if (r100.exists() == true) goto L8;
        return false;
    L8:
        if (r101.exists() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final String h() {
        if (TextUtils.isEmpty(this.f201893b) == false) goto L5;
        return "";
    L5:
        String r100 = vb4.e.f("kpt_md5");
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return "";
    L9:
        return this.f201893b + File.separator + r100;
    }

    public a() {
        this.f201895d = new ArrayList();
        this.f201896e = 0;
    }

    public static void b(a r100) {
        r100.getClass();
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.f201893b);
        if (r101.exists() == false) goto L7;
        hc4.c.f(r101);
        return;
    }

    public static Pair c(a r100) {
        r100.getClass();
        String r101 = vb4.e.f("detect_md5");
        String r102 = vb4.e.f("kpt_md5");
        if (TextUtils.isEmpty(r101) == true) goto L32;
        if (TextUtils.isEmpty(r102) == true) goto L32;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.f201893b);
        String r104 = File.separator;
        r103.append(r104);
        r103.append("det_model.bytenn");
        String r105 = r103.toString();
        String r106 = r100.f201893b + r104 + "kpt_model.bytenn";
        PolarisFileWrapper r107 = new PolarisFileWrapper(r105);
        PolarisFileWrapper r108 = new PolarisFileWrapper(r106);
        if (r107.exists() == false) goto L35;
        if (r108.exists() == false) goto L35;
        String r109 = hc4.c.g(r107);
        String r110 = hc4.c.g(r108);
        if (TextUtils.isEmpty(r109) == true) goto L34;
        if (TextUtils.isEmpty(r110) == true) goto L34;
        int r111 = 5;
        if (r109.equals(r101) == true) goto L20;
    L27:
        String r112 = "md5 not equal:cfg_detect_md5=" + r101 + ";detect_md5=" + r109 + ";cfg_kpt_md5=" + r102 + ";kpt_md5=" + r110;
    L33:
        return new Pair(Integer.valueOf(r111), r112);
    L20:
        if (r110.equals(r102) == false) goto L27;
        PolarisFileWrapper r113 = new PolarisFileWrapper(r100.d());
        PolarisFileWrapper r114 = new PolarisFileWrapper(r100.h());
        if (r107.renameTo(r113) == true) goto L24;
    L26:
        r112 = "rename fail";
        goto L33
    L24:
        if (r108.renameTo(r114) == false) goto L26;
        r112 = "";
        r111 = 0;
    L34:
        return new Pair(4, "get file md5 fail:detect_md5=" + r109 + ";kpt_md5=" + r110);
    L35:
        return new Pair(3, "mode file not exists");
    L32:
        return new Pair(1, "config md5 is empty:detect_md5=" + r101 + ";kpt_md5=" + r102);
    }

    public final void e(String r110, c r111) {
        if (r111 == null) goto L7;
        if (((ArrayList) this.f201895d).contains(r111) == true) goto L7;
        ((ArrayList) this.f201895d).add(r111);
    L7:
        if (this.f201894c == false) goto L9;
        return;
    L9:
        int r100 = Math.max(0, this.f201896e);
        String r101 = com.bytedance.bdturing.setting.e.f(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L31;
    L15:
        JSONObject r103 = null;
    L16:
        if (r103 == null) goto L23;
        JSONArray r104 = r103.optJSONArray(ScoreTags.STAR_URL_LIST);
        if (r104 == null) goto L23;
        if (r104.length() <= 0) goto L23;
        r102 = r104.optString(r100 % r104.length());
    L23:
        if (TextUtils.isEmpty(r102) == false) goto L27;
        if (r111 == null) goto L33;
        r111.G0(false, "url is empty");
        return;
    L33:
        return;
    L27:
        this.f201892a = 0;
        long r105 = System.currentTimeMillis();
        this.f201894c = true;
        b r112 = new b(this, r105, r110, r102);
        e r113 = e.a();
        com.bytedance.bdturing.livedetect.b r106 = new com.bytedance.bdturing.livedetect.b(this, r102, r112);
        PThreadPoolExecutor r114 = r113.f536929a;
        if (r114 == null) goto L34;
        r114.execute(r106);
        return;
    L34:
        return;
    L31:
        r103 = new JSONObject(r101);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    @Override // com.bytedance.bdturing.setting.c.a
    public final void a(int r100, String r101, long r102) {
        if (r100 == 200) goto L5;
        return;
    L5:
        if (g() == true) goto L9;
        c0.a.f532328a.b(new RunnableC2910a(this), 7000);
        return;
    }
}
