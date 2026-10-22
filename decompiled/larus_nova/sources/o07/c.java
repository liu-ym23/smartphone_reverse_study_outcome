package o07;

import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f521634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f521635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f521636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f521637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f521638e;

    public final String toString() {
        return "UrlRequest{paramMap=" + this.f521634a + ", url='" + this.f521635b + "', method='" + this.f521636c + "', body='" + this.f521637d + "', timeoutMs=" + this.f521638e + '}';
    }

    public c(String r100) {
        this.f521638e = 3000;
        this.f521635b = r100;
    }
}
