package ira;

import com.ss.android.ad.applinksdk.model.AppLinkEventConfig;
import com.ss.android.ad.applinksdk.utils.MonitorUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f495542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.ad.applinksdk.core.a f495543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f495544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f495545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppLinkEventConfig f495546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f495547f;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("cid", Long.valueOf(this.f495544c));     // Catch: Exception -> L5
        r100.putOpt("applink_model", this.f495545d.a());     // Catch: Exception -> L5
        r100.putOpt("applink_event_config", this.f495546e.a());     // Catch: Exception -> L5
        r100.putOpt("applink_time", Long.valueOf(this.f495547f));     // Catch: Exception -> L5
    L8:
        return r100.toString();
    L5:
        e = move-exception;
        MonitorUtils.b(e, "NativeAppLinkModel toJson");
        goto L8
    }

    public e(d r100, AppLinkEventConfig r101) {
        this.f495544c = r100.f495526b;
        this.f495545d = r100;
        this.f495546e = r101;
    }
}
