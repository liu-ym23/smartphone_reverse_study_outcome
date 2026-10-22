package n07;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516588a;

    public final String toString() {
        return "SccConfig{mServiceUrl='" + this.f516588a + "'}";
    }

    public c() {
        this.f516588a = new StringBuilder("//:sptth").reverse().toString() + "scc#bytedance#".replace('#', '.') + "com/scc_sdk/url_scan_v4?scc_mode=coreless&scc_from=Bullet&scc_sdk_version=30";
    }
}
