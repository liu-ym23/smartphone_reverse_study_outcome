package cra;

import android.text.TextUtils;
import com.bytedance.sdk.account.impl.h;
import com.bytedance.sdk.account.impl.j;
import com.bytedance.sdk.account.impl.k;
import com.bytedance.sdk.account.utils.r;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements Cloneable {
    public final String a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public String m;
    public String n;
    public String o;
    public String p;
    public long q;
    public long r;

    public final void e() {
        this.b = false;
        this.c = XmlPullParser.NO_NAMESPACE;
        this.d = null;
        this.e = XmlPullParser.NO_NAMESPACE;
        this.f = XmlPullParser.NO_NAMESPACE;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.h = 0;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.g = XmlPullParser.NO_NAMESPACE;
        this.q = 0;
        this.r = 0;
    }

    static {
        new String[]{"mobile", "email", "google", "facebook", "twitter", "instagram", "line", "kakaotalk", "vk", "tiktok"};
    }

    public final String c() {
        return "BDAccountPlatformEntity{mName='" + this.a + "', mPlatformId=" + this.l + ", mAccessToken='" + d(this.m) + "', mOpenId='" + d(this.n) + "', mScope='" + this.o + "', mExpire=" + this.i + "(" + r.a(this.i) + "), refreshAt=" + this.q + "(" + r.a(this.q) + ")}";
    }

    public final String toString() {
        return "BDAccountPlatformEntity{mName='" + this.a + "', mLogin=" + this.b + ", mNickname='" + this.c + "', mAvatar='" + this.d + "', mPlatformUid='" + this.e + "', mSecPlatformUid='" + this.f + "', mCreateTIme='" + this.g + "', mModifyTime=" + this.h + ", mExpire=" + this.i + "(" + r.a(this.i) + "), mExpireIn=" + this.j + ", mUserId=" + this.k + ", mPlatformId=" + this.l + ", mAccessToken='" + this.m + "', mOpenId='" + this.n + "', mScope='" + this.o + "', mExtra='" + this.p + "', refreshAt=" + this.q + "(" + r.a(this.q) + "), refreshTime=" + this.r + '}';
    }

    public final a b() throws CloneNotSupportedException {
        return (a) super.clone();
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public a(String r2) {
        this.a = r2;
        this.b = false;
        this.c = XmlPullParser.NO_NAMESPACE;
        this.d = null;
        this.e = XmlPullParser.NO_NAMESPACE;
    }

    public static String d(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return r4;
    L6:
        if (r4.length() > 12) goto L9;
        return "***";
    L9:
        return r4.substring(0, 6) + "***" + r4.substring(r4.length() - 6);
    }

    public final boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        if (com.bytedance.sdk.account.settings.a.a() == true) goto L7;
        return false;
    L7:
        if (System.currentTimeMillis() <= this.i) goto L13;
        j r6 = h.a();
        String r0 = this.a;
        int r2 = (int) this.l;
        r6.V0.post(new k(r6, r0, r2));
        return true;
    L13:
        return false;
    }
}
