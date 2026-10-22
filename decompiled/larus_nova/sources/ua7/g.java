package ua7;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class g extends b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f549268p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f549269q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f549270r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f549271s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f549272t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f549273u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f549274v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f549275w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f549276x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f549277y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f549278z;

    @Override // ua7.b
    public final String toString() {
        return "ThirdTokenResponse{platformName='" + this.f549268p + "', platformAppId=" + this.f549269q + ", accessToken='" + this.f549270r + "', expiresIn=" + this.f549271s + ", openId='" + this.f549272t + "', refreshToken='" + this.f549273u + "', refreshExpiresIn=" + this.f549274v + ", scopes='" + this.f549275w + "', refreshTime=" + this.f549276x + ", captcha='" + this.f549277y + "', descUrl='" + this.f549278z + "'}";
    }

    public void a(JSONObject r100, JSONObject r101) {
        this.f549270r = r101.optString("access_token");
        this.f549271s = r101.optLong("expires_in");
        this.f549272t = r101.optString(Constants.JumpUrlConstants.URL_KEY_OPENID);
        this.f549273u = r101.optString("refresh_token");
        this.f549274v = r101.optLong("refresh_expires_in");
        this.f549275w = r101.optString(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE);
        this.f549276x = r101.optLong("refresh_time", this.f549271s);
        this.f549259m = r100;
    }

    public g(boolean r100, int r101, String r102, String r103) {
        super(r100, r101);
        int r104 = CastIntegerProtector.parseInt(r103);     // Catch: Exception -> L5
    L6:
        this.f549268p = r102;
        this.f549269q = r104;
        return;
    L5:
        r104 = -1;
        goto L6
    }

    public g(boolean r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.f549268p = r102;
        this.f549269q = r103;
    }
}
