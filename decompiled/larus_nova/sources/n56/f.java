package n56;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f518029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f518030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f518031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f518032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f518033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f518034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f518035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f518036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f518037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f518038j;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("JsMsg{type='");
        r100.append(this.f518029a);
        r100.append("', callback_id='");
        r100.append(this.f518030b);
        r100.append("', func='");
        r100.append(this.f518031c);
        r100.append("', params=");
        r100.append(this.f518032d);
        r100.append(", version=");
        r100.append(this.f518033e);
        r100.append(", namespace=");
        r100.append(this.f518034f);
        r100.append(", iFrameUrl=");
        r100.append(this.f518035g);
        r100.append(", safeV1AuthUrl=");
        r100.append(this.f518036h);
        r100.append(", permissionGroup=");
        if (TextUtils.isEmpty(this.f518037i) == false) goto L5;
        String r101 = "";
    L6:
        r100.append(r101);
        r100.append('}');
        return r100.toString();
    L5:
        r101 = this.f518037i;
        goto L6
    }

    public f() {
        this.f518038j = true;
    }
}
