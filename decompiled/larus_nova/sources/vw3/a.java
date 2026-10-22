package vw3;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.applog.log.n;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f557418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f557419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f557420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f557421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f557422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f557423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f557424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f557425h;

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("version", this.f557418a);     // Catch: Throwable -> L13
        r100.put(VideoThumbInfo.KEY_INTERVAL, this.f557419b);     // Catch: Throwable -> L13
        r100.put("forward_report_path", this.f557422e);     // Catch: Throwable -> L13
        r100.put("forward_report_host", this.f557421d);     // Catch: Throwable -> L13
        r100.put("forward_open", this.f557423f);     // Catch: Throwable -> L13
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L13
        Iterator r102 = ((ArrayList) this.f557424g).iterator();     // Catch: Throwable -> L13
    L5:
        if (r102.hasNext() == false) goto L7;
        String r103 = (String) r102.next();     // Catch: Throwable -> L13
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L13
        r104.put("forward_report_url", r103);     // Catch: Throwable -> L13
        r101.put(r104);     // Catch: Throwable -> L13
        goto L5
    L7:
        r100.put("forward_list", r101);     // Catch: Throwable -> L13
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L13
        Iterator r106 = ((HashSet) this.f557420c).iterator();     // Catch: Throwable -> L13
    L9:
        if (r106.hasNext() == false) goto L11;
        r105.put((String) r106.next());     // Catch: Throwable -> L13
        goto L9
    L11:
        r100.put("events", r105);     // Catch: Throwable -> L13
    L15:
        return r100;
    L13:
        th = move-exception;
        n.w().q("put json object for event forward failed", th, new Object[0]);
        goto L15
    }

    public final List<String> b() {
        if (this.f557423f != 0) goto L7;
        return null;
    L7:
        if (this.f557425h != null) goto L33;
        ArrayList r100 = new ArrayList();
        if (((ArrayList) this.f557424g).isEmpty() == true) goto L17;
        Iterator r101 = ((ArrayList) this.f557424g).iterator();
    L12:
        if (r101.hasNext() == false) goto L31;
        String r102 = (String) r101.next();
        if (TextUtils.isEmpty(r102) == true) goto L12;
        r100.add(r102);
    L31:
        this.f557425h = r100;
        goto L33
    L17:
        if (TextUtils.isEmpty(this.f557421d) == true) goto L31;
        if (this.f557421d.startsWith("https://") == false) goto L31;
        if (this.f557421d.endsWith(HTTP.URL_DEFAULT) == true) goto L31;
        String r103 = this.f557421d;
        if (TextUtils.isEmpty(this.f557422e) == false) goto L25;
    L29:
        String r104 = "/service/2/app_log/";
    L30:
        r100.add(r103 + r104);
        goto L31
    L25:
        if (this.f557422e.startsWith(HTTP.URL_DEFAULT) == false) goto L29;
        if (this.f557422e.endsWith(HTTP.URL_DEFAULT) == false) goto L29;
        r104 = this.f557422e;
    L33:
        return this.f557425h;
    }

    public final boolean c() {
        if (this.f557423f == 1) goto L5;
    L13:
        return false;
    L5:
        if (((HashSet) this.f557420c).isEmpty() == true) goto L13;
        if (this.f557419b <= 0) goto L13;
        if (b() == null) goto L13;
        if (b().isEmpty() == true) goto L13;
        return true;
    }

    public a() {
        this.f557418a = 0;
        this.f557419b = 60000;
        this.f557420c = new HashSet();
        this.f557423f = 0;
        this.f557424g = new ArrayList();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (r101.f557418a == this.f557418a) goto L7;
    L21:
        return false;
    L7:
        if (r101.f557419b != this.f557419b) goto L21;
        if (TextUtils.equals(r101.f557421d, this.f557421d) == false) goto L21;
        if (TextUtils.equals(r101.f557422e, this.f557422e) == false) goto L21;
        if (r101.f557423f != this.f557423f) goto L21;
        List<String> r102 = r101.f557424g;
        ArrayList r103 = (ArrayList) r102;
        if (r103.equals(this.f557424g) == false) goto L21;
        if (r101.f557420c.containsAll(this.f557420c) == false) goto L21;
        if (this.f557420c.containsAll(r101.f557420c) == false) goto L21;
        return true;
    L24:
        return super.equals(r100);
    }
}
