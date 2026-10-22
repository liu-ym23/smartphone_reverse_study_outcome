package ira;

import android.content.Intent;
import com.ss.android.ad.applinksdk.model.BizLineType;
import com.ss.android.ad.applinksdk.utils.MonitorUtils;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f495525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f495526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f495527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f495528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f495529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f495530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f495531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f495532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f495533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Intent f495534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f495535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f495536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f495537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BizLineType f495538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f495539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f495540p;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f495541a;

        public final d a() {
            this.f495541a.getClass();
            d r100 = this.f495541a;
            boolean r101 = false;
            if (r100.f495526b <= 0) goto L20;
            String r102 = r100.f495528d;
            if (r102 != null) goto L7;
        L10:
            boolean r103 = true;
        L11:
            if (r103 == true) goto L20;
            String r104 = this.f495541a.f495529e;
            if (r104 != null) goto L15;
        L18:
            boolean r105 = true;
        L19:
            if (r105 == true) goto L20;
        L21:
            String r106 = this.f495541a.f495531g;
            if (r106 != null) goto L24;
        L25:
            r101 = true;
        L26:
            if (r101 == false) goto L29;
            d r107 = this.f495541a;
            com.ss.android.ad.applinksdk.core.d.f406360e.getClass();
            r107.f495531g = com.ss.android.ad.applinksdk.core.d.f406359d;
        L29:
            return this.f495541a;
        L24:
            if (r106.length() != 0) goto L26;
        L15:
            if (r104.length() == 0) goto L18;
            r105 = false;
            goto L19
        L7:
            if (r102.length() == 0) goto L10;
            r103 = false;
        L20:
            MonitorUtils.a("AdAppLinkModel not valid");
            goto L21
        }

        public a() {
            this.f495541a = new d();
        }

        public final void b(int r100) {
            d r101 = this.f495541a;
            r101.f495537m = Integer.valueOf(r100);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        new b();
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("cid", Long.valueOf(this.f495526b));     // Catch: Exception -> L5
        r100.putOpt("group_id", 0L);     // Catch: Exception -> L5
        r100.putOpt("is_ad", Boolean.valueOf(this.f495527c));     // Catch: Exception -> L5
        r100.putOpt("log_extra", this.f495528d);     // Catch: Exception -> L5
        r100.putOpt("open_url", this.f495529e);     // Catch: Exception -> L5
        r100.putOpt("package_name", this.f495530f);     // Catch: Exception -> L5
        r100.putOpt("raw_back_url", this.f495531g);     // Catch: Exception -> L5
        r100.putOpt("is_from_landing_page", Boolean.valueOf(this.f495532h));     // Catch: Exception -> L5
        r100.putOpt("is_auto_jump", false);     // Catch: Exception -> L5
        r100.putOpt("is_blocked", Boolean.valueOf(this.f495533i));     // Catch: Exception -> L5
        r100.putOpt("in_auto_allow_list", Boolean.valueOf(this.f495525a));     // Catch: Exception -> L5
        r100.putOpt("app_link_type", Integer.valueOf(this.f495535k));     // Catch: Exception -> L5
        r100.putOpt("business_type", this.f495537m);     // Catch: Exception -> L5
        r100.putOpt(AdDownloadModel.JsonKey.BIZ_LINE_TYPE, Integer.valueOf(this.f495538n.getCode()));     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        MonitorUtils.b(e, "AdAppData toJson");
        goto L7
    }

    public d() {
        this.f495527c = true;
        this.f495528d = "";
        this.f495529e = "";
        this.f495530f = "";
        this.f495531g = "";
        this.f495535k = 1;
        this.f495538n = BizLineType.DEFAULT;
        this.f495539o = 335544320;
        this.f495540p = true;
    }

    public final String toString() {
        return a().toString();
    }
}
