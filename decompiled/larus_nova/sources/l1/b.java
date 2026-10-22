package l1;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends com.apm.lite.k.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f506929a;

    public b() {
        this.f506929a = false;
    }

    @Override // com.apm.lite.k.f.a
    public final boolean a(String r100) {
        if (this.f506929a == true) goto L8;
        if (r100.contains("android.os.Looper.loop") == false) goto L8;
        this.f506929a = true;
    L8:
        return !this.f506929a;
    }
}
