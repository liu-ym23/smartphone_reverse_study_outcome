package n07;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f516589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f516591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f516592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f516593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f516594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f516595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f516596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f516597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f516598j;

    public final boolean a() {
        if ("deny".equals(this.f516591c) == false) goto L5;
    L8:
        return true;
    L5:
        if ("black".equals(this.f516591c) == true) goto L8;
        return false;
    }

    public final String toString() {
        return "SccResult{mCode=" + this.f516589a + ", mMessage='" + this.f516590b + "', mLabel='" + this.f516591c + "', mClientReason='" + this.f516592d + "', mClientLogId='" + this.f516593e + "', mScore=" + this.f516594f + ", mBlockStyle='" + this.f516595g + "', mShowingBlankPage=" + this.f516596h + ", mPassedTime=" + this.f516597i + ", mOriginJsonResponse=" + this.f516598j + '}';
    }

    public d(JSONObject r100) {
        this.f516598j = r100;
        this.f516589a = r100.optInt("code", -1);
        this.f516590b = r100.optString("message", "fail");
        this.f516592d = r100.optString("scc_reason", "");
        this.f516597i = r100.optInt("scc_passed_time", -1);
        this.f516593e = r100.optString("scc_logid", "");
        JSONObject r101 = r100.optJSONObject("data");
        boolean r102 = false;
        if (r101 == null) goto L5;
        this.f516591c = r101.optString("label", "notice");
        this.f516594f = r101.optInt(com.bytedance.android.ec.core.event.a.KEY_SCORE, 0);
        this.f516595g = r101.optString("block_style", "");
    L7:
        if (a() == true) goto L9;
    L13:
        this.f516596h = r102;
        return;
    L9:
        if (TextUtils.isEmpty(this.f516595g) == false) goto L11;
    L12:
        r102 = true;
        goto L13
    L11:
        if (this.f516595g.equals("forbid") == false) goto L13;
    L5:
        this.f516591c = "allow";
        this.f516594f = 0;
        this.f516595g = "";
        goto L7
    }
}
