package vta;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f557248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f557249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f557250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f557251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f557252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f557253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f557254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vta.a f557255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONObject f557256i;

    public static final class a {
        public static b a(JSONObject r110) {
            int r100 = r110.optInt("settings_cache_timeout", AnnouncementViewModel.HOUR_DURATION);     // Catch: JSONException -> L24
            int r101 = r110.optInt("local_cache_timeout", AnnouncementViewModel.HOUR_DURATION);     // Catch: JSONException -> L24
            int r102 = r110.optInt("login_opt", 1);     // Catch: JSONException -> L24
            JSONObject r103 = r110.optJSONObject("intercept_conf");     // Catch: JSONException -> L24
            if (r103 != null) goto L34;
        L7:
            f r104 = null;
        L8:
            JSONObject r105 = r110.optJSONObject("sdk_loading_style");     // Catch: JSONException -> L24
            if (r105 != null) goto L32;
        L12:
            g r106 = null;
        L13:
            JSONObject r107 = r110.optJSONObject("app_uninstalled_handle");     // Catch: JSONException -> L24
            if (r107 != null) goto L30;
        L17:
            vta.a r108 = null;
        L18:
            JSONObject r111 = r110.optJSONObject("opt_settings");     // Catch: JSONException -> L24
            b r109 = new b(r100, r101, r102, r104, r106, r108, r111);     // Catch: JSONException -> L24
            h r112 = h.a.a(r111);     // Catch: JSONException -> L24
            if (r112 != null) goto L22;
            r112 = new h();     // Catch: JSONException -> L24
        L22:
            r109.f557248a = r112;     // Catch: JSONException -> L24
            return r109;
        L30:
            r108 = new vta.a(r107.optInt("need_handle", 1), r107.optString("h5_fallback_url"));     // Catch: JSONException -> L25
            goto L18
        L32:
            r106 = new g(r105.optLong("loading_timeout"), r105.optString("loading_icon_url"), r105.optString("loading_icon_gif_url"), r105.optString("loading_main_title"), r105.optString("loading_sub_title"));     // Catch: JSONException -> L26
            goto L13
        L34:
            r104 = new f(r103.optInt("duplicated_order_time"));     // Catch: JSONException -> L27
        L24:
            return null;
        }
    }

    public b(int r100, int r101, int r102, f r103, g r104, vta.a r105, JSONObject r106) {
        this.f557250c = r100;
        this.f557251d = r101;
        this.f557252e = r102;
        this.f557253f = r103;
        this.f557254g = r104;
        this.f557255h = r105;
        this.f557256i = r106;
        this.f557248a = new h();
        this.f557249b = "";
    }

    public final String a() {
        boolean r100 = false;
        if (this.f557249b.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L21;
        StringBuilder r102 = new StringBuilder();
        JSONObject r103 = this.f557256i;
        if (r103 == null) goto L15;
        Iterator<String> r104 = r103.keys();
        if (r104 == null) goto L15;
    L12:
        if (r104.hasNext() == false) goto L15;
        String r105 = r104.next();
        r102.append(r105);
        r102.append("_");
        r102.append(this.f557256i.opt(r105));
        r102.append("#");
    L15:
        if (r102.length() <= 0) goto L17;
        r100 = true;
    L17:
        if (r100 == false) goto L19;
        r102.deleteCharAt(r102.length() - 1);
    L19:
        this.f557249b = r102.toString();
    L21:
        return this.f557249b;
    L5:
        r101 = false;
        goto L6
    }
}
