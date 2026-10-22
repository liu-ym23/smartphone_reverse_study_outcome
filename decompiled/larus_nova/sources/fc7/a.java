package fc7;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f476358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f476359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f476360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f476361d;

    public final String toString() {
        return "ErrorCodeTask{mErrorCode=" + this.f476358a + ", mType=" + this.f476359b + ", mInfo='" + this.f476360c + "', mDetail='" + this.f476361d + "'}";
    }

    public int getType() {
        return this.f476359b;
    }

    public a(int r100, int r101, String r102, String r103) {
        this.f476358a = r100;
        this.f476359b = r101;
        this.f476360c = r102;
        this.f476361d = r103;
    }
}
