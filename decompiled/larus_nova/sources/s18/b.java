package s18;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f540179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f540180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f540181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f540182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f540183e;

    public final String toString() {
        return "ValidatorResult{valid=" + this.f540179a + ", msg='" + this.f540180b + "', invalidType='" + this.f540181c + "', invalidTypeMsg='" + this.f540182d + "'}";
    }

    public b() {
        this.f540179a = true;
    }

    public b(String r100) {
        this.f540179a = false;
        this.f540180b = r100;
    }
}
