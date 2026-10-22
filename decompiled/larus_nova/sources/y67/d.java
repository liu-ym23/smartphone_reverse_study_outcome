package y67;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f566377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f566378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f566379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f566380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f566381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f566382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f566383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f566384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f566385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f566386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONObject f566387l;

    public d() {
        throw null;
    }

    public d(JSONObject r100) {
        this.f566377b = true;
        this.f566378c = r100.optString("id");
        this.f566379d = r100.optString("name");
        this.f566380e = r100.optInt("importance", 3);
        this.f566381f = r100.optBoolean("bypassDnd", true);
        this.f566382g = r100.optInt("lockscreenVisibility", -1);
        this.f566383h = r100.optBoolean("lights", true);
        this.f566384i = r100.optBoolean("vibration", true);
        this.f566385j = r100.optBoolean("showBadge", true);
        this.f566377b = r100.optBoolean("enable", true);
        this.f566376a = r100.optString(SocialConstants.PARAM_APP_DESC);
        this.f566386k = r100.optString(RemoteMessageConst.Notification.SOUND);
        JSONObject r101 = r100.optJSONObject("channel_fields");
        this.f566387l = r101;
        if (r101 != null) goto L6;
        this.f566387l = new JSONObject();
        return;
    }
}
