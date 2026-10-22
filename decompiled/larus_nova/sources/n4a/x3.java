package n4a;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class x3 extends a5 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f517919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, String> f517920l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f517921m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f517922n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f517923o;

    public x3() {
        this.f517919k = null;
        this.f517920l = null;
        this.f517921m = "";
        this.f517922n = null;
        this.f517923o = null;
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        return this.f517919k;
    }

    @Override // com.loc.bo
    public final String c() {
        return this.f517921m;
    }

    @Override // n4a.a5, com.loc.bo
    public final String e() {
        if (TextUtils.isEmpty(this.f517923o) == true) goto L7;
        return this.f517923o;
    L7:
        return super.e();
    }

    @Override // com.loc.bo
    public final Map<String, String> h() {
        return this.f517920l;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        return this.f517922n;
    }
}
