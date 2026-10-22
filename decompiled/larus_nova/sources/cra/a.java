package cra;

import android.text.TextUtils;
import com.bytedance.sdk.account.impl.h;
import com.bytedance.sdk.account.impl.j;
import com.bytedance.sdk.account.impl.k;
import com.bytedance.sdk.account.utils.r;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f465120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f465121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f465122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f465123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f465124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f465125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f465126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f465127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f465128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f465129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f465130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f465131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f465132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f465133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f465134p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f465135q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f465136r;

    public final void e() {
        this.f465120b = false;
        this.f465121c = "";
        this.f465122d = null;
        this.f465123e = "";
        this.f465124f = "";
        this.f465127i = 0;
        this.f465128j = 0;
        this.f465129k = 0;
        this.f465126h = 0;
        this.f465130l = 0;
        this.f465131m = null;
        this.f465132n = null;
        this.f465133o = null;
        this.f465134p = null;
        this.f465125g = "";
        this.f465135q = 0;
        this.f465136r = 0;
    }

    static {
        new String[]{"mobile", "email", "google", "facebook", "twitter", "instagram", "line", "kakaotalk", "vk", "tiktok"};
    }

    public final String c() {
        return "BDAccountPlatformEntity{mName='" + this.f465119a + "', mPlatformId=" + this.f465130l + ", mAccessToken='" + d(this.f465131m) + "', mOpenId='" + d(this.f465132n) + "', mScope='" + this.f465133o + "', mExpire=" + this.f465127i + "(" + r.a(this.f465127i) + "), refreshAt=" + this.f465135q + "(" + r.a(this.f465135q) + ")}";
    }

    public final String toString() {
        return "BDAccountPlatformEntity{mName='" + this.f465119a + "', mLogin=" + this.f465120b + ", mNickname='" + this.f465121c + "', mAvatar='" + this.f465122d + "', mPlatformUid='" + this.f465123e + "', mSecPlatformUid='" + this.f465124f + "', mCreateTIme='" + this.f465125g + "', mModifyTime=" + this.f465126h + ", mExpire=" + this.f465127i + "(" + r.a(this.f465127i) + "), mExpireIn=" + this.f465128j + ", mUserId=" + this.f465129k + ", mPlatformId=" + this.f465130l + ", mAccessToken='" + this.f465131m + "', mOpenId='" + this.f465132n + "', mScope='" + this.f465133o + "', mExtra='" + this.f465134p + "', refreshAt=" + this.f465135q + "(" + r.a(this.f465135q) + "), refreshTime=" + this.f465136r + '}';
    }

    public final a b() throws CloneNotSupportedException {
        return (a) super.clone();
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public a(String r100) {
        this.f465119a = r100;
        this.f465120b = false;
        this.f465121c = "";
        this.f465122d = null;
        this.f465123e = "";
    }

    public static String d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r100;
    L6:
        if (r100.length() > 12) goto L9;
        return "***";
    L9:
        return r100.substring(0, 6) + "***" + r100.substring(r100.length() - 6);
    }

    public final boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (com.bytedance.sdk.account.settings.a.a() == true) goto L7;
        return false;
    L7:
        if (System.currentTimeMillis() <= this.f465127i) goto L13;
        j r101 = h.a();
        String r102 = this.f465119a;
        int r103 = (int) this.f465130l;
        r101.V0.post(new k(r101, r102, r103));
        return true;
    L13:
        return false;
    }
}
