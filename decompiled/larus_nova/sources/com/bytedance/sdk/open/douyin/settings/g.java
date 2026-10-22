package com.bytedance.sdk.open.douyin.settings;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class g {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f269721s = "https://is.snssdk.com/service/settings/v3/";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f269722t = "douyin_open_sdk";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f269723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f269724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f269725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f269726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f269727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f269728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f269729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f269730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f269731i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f269732j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f269733k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f269734l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f269735m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f269736n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f269737o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f269738p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f269739q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<String, String> f269740r;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f269741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f269742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f269743c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f269744d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f269745e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f269746f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f269747g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f269748h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f269749i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f269750j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f269751k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f269752l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f269753m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f269754n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f269755o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private String f269756p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private long f269757q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private Map<String, String> f269758r;

        public b() {
            this.f269741a = g.f269721s;
            this.f269742b = g.f269722t;
            this.f269747g = Build.MODEL;
            this.f269748h = Build.BRAND;
        }

        public b a(int r100) {
            this.f269751k = r100;
            return this;
        }

        public b a(long r100) {
            this.f269757q = r100;
            return this;
        }

        public b a(String r100) {
            this.f269743c = r100;
            return this;
        }

        public b a(Map<String, String> r100) {
            this.f269758r = r100;
            return this;
        }

        public g a() {
            g r100 = new g(null);
            g.b(r100, this.f269741a);
            g.h(r100, this.f269742b);
            g.i(r100, this.f269743c);
            g.j(r100, this.f269744d);
            g.k(r100, this.f269745e);
            g.l(r100, this.f269746f);
            g.m(r100, this.f269747g);
            g.n(r100, this.f269748h);
            g.o(r100, this.f269749i);
            g.a(r100, this.f269756p);
            g.a(r100, this.f269757q);
            g.c(r100, this.f269750j);
            g.a(r100, this.f269751k);
            g.d(r100, this.f269752l);
            g.a(r100, this.f269758r);
            g.e(r100, this.f269753m);
            g.f(r100, this.f269754n);
            g.g(r100, this.f269755o);
            return r100;
        }

        public b b(String r100) {
            this.f269744d = r100;
            return this;
        }

        public String b() {
            return this.f269743c;
        }

        public b c(String r100) {
            this.f269742b = r100;
            return this;
        }

        public String c() {
            return this.f269744d;
        }

        public b d(String r100) {
            this.f269752l = r100;
            return this;
        }

        public String d() {
            return this.f269742b;
        }

        public b e(String r100) {
            this.f269756p = r100;
            return this;
        }

        public String e() {
            return this.f269756p;
        }

        public b f(String r100) {
            this.f269748h = r100;
            return this;
        }

        public String f() {
            return this.f269748h;
        }

        public b g(String r100) {
            this.f269749i = r100;
            return this;
        }

        public String g() {
            return this.f269749i;
        }

        public b h(String r100) {
            this.f269746f = r100;
            return this;
        }

        public String h() {
            return this.f269746f;
        }

        public b i(String r100) {
            this.f269747g = r100;
            return this;
        }

        public String i() {
            return this.f269747g;
        }

        public b j(String r100) {
            this.f269755o = r100;
            return this;
        }

        public Map<String, String> j() {
            return this.f269758r;
        }

        public long k() {
            return this.f269757q;
        }

        public b k(String r100) {
            this.f269750j = r100;
            return this;
        }

        public b l(String r100) {
            this.f269741a = r100;
            return this;
        }

        public String l() {
            return this.f269741a;
        }

        public b m(String r100) {
            this.f269753m = r100;
            return this;
        }

        public String m() {
            return this.f269745e;
        }

        public b n(String r100) {
            this.f269745e = r100;
            return this;
        }

        public b o(String r100) {
            this.f269754n = r100;
            return this;
        }
    }

    private g() {
    }

    public /* synthetic */ g(a r100) {
        this();
    }

    public static /* synthetic */ int a(g r100, int r101) {
        r100.f269735m = r101;
        return r101;
    }

    public static /* synthetic */ long a(g r100, long r101) {
        r100.f269733k = r101;
        return r101;
    }

    public static /* synthetic */ String a(g r100, String r101) {
        r100.f269732j = r101;
        return r101;
    }

    public static /* synthetic */ Map a(g r100, Map r101) {
        r100.f269740r = r101;
        return r101;
    }

    private void a(StringBuilder r100, String r101, String r102, Map<String, String> r103, boolean r104) {
        if (TextUtils.isEmpty(r102) == false) goto L8;
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.containsKey(r101) == true) goto L8;
        return;
    L8:
        if (r103 == null) goto L13;
        if (r103.containsKey(r101) == false) goto L13;
        r102 = r103.get(r101);
        r103.remove(r101);
    L13:
        if (r104 == false) goto L15;
        String r105 = "?";
    L16:
        r100.append(r105);
        r100.append(r101);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r102);
        return;
    L15:
        r105 = "&";
        goto L16
    }

    public static /* synthetic */ String b(g r100, String r101) {
        r100.f269723a = r101;
        return r101;
    }

    public static /* synthetic */ String c(g r100, String r101) {
        r100.f269734l = r101;
        return r101;
    }

    public static /* synthetic */ String d(g r100, String r101) {
        r100.f269736n = r101;
        return r101;
    }

    public static /* synthetic */ String e(g r100, String r101) {
        r100.f269737o = r101;
        return r101;
    }

    public static /* synthetic */ String f(g r100, String r101) {
        r100.f269738p = r101;
        return r101;
    }

    public static /* synthetic */ String g(g r100, String r101) {
        r100.f269739q = r101;
        return r101;
    }

    public static /* synthetic */ String h(g r100, String r101) {
        r100.f269724b = r101;
        return r101;
    }

    public static /* synthetic */ String i(g r100, String r101) {
        r100.f269725c = r101;
        return r101;
    }

    public static /* synthetic */ String j(g r100, String r101) {
        r100.f269726d = r101;
        return r101;
    }

    public static /* synthetic */ String k(g r100, String r101) {
        r100.f269727e = r101;
        return r101;
    }

    public static /* synthetic */ String l(g r100, String r101) {
        r100.f269728f = r101;
        return r101;
    }

    public static /* synthetic */ String m(g r100, String r101) {
        r100.f269729g = r101;
        return r101;
    }

    public static /* synthetic */ String n(g r100, String r101) {
        r100.f269730h = r101;
        return r101;
    }

    public static /* synthetic */ String o(g r100, String r101) {
        r100.f269731i = r101;
        return r101;
    }

    public String a() {
        StringBuilder r100 = new StringBuilder(this.f269723a);
        HashMap r101 = new HashMap();
        Map<String, String> r102 = this.f269740r;
        if (r102 == null) goto L5;
        r101.putAll(r102);
    L5:
        a(r100, Constant.KEY_CALL_NAME, this.f269724b, r101, true);
        a(r100, "app_id", this.f269725c, r101, false);
        a(r100, "app_name", this.f269726d, r101, false);
        a(r100, "version_code", this.f269727e, r101, false);
        a(r100, "device_platform", this.f269728f, r101, false);
        a(r100, "device_type", this.f269729g, r101, false);
        a(r100, "device_brand", this.f269730h, r101, false);
        a(r100, "device_id", this.f269731i, r101, false);
        a(r100, "ctx_infos", this.f269732j, r101, false);
        a(r100, "settings_time", "" + this.f269733k, r101, false);
        a(r100, "os_version", this.f269734l, r101, false);
        a(r100, "os_api", "" + this.f269735m, r101, false);
        a(r100, "channel", this.f269736n, r101, false);
        a(r100, "update_version_code", this.f269737o, r101, false);
        a(r100, "version_name", this.f269738p, r101, false);
        a(r100, WsConstants.KEY_INSTALL_ID, this.f269739q, r101, false);
        a(r100, "open_platform_sdk_china_name", com.bytedance.sdk.open.douyin.b.f269628e, r101, false);
        a(r100, "open_platform_sdk_china_version_code", "5.21.1-rc.0", r101, false);
        Iterator r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        a(r100, (String) r104.getKey(), (String) r104.getValue(), null, false);
        goto L7
    L10:
        return r100.toString();
    }

    public String toString() {
        return a();
    }
}
