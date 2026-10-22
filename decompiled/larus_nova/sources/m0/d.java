package m0;

import java.util.List;
import o0.i;

/* JADX INFO: loaded from: classes28.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f511465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f511466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f511467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f511468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f511469e;

    public final int hashCode() {
        char r100 = this.f511466b;
        String r101 = this.f511469e;
        String r102 = this.f511468d;
        return ((((r100 + 0) * 31) + r101.hashCode()) * 31) + r102.hashCode();
    }

    public d(List r100, char r101, double r102, String r103, String r104) {
        this.f511465a = r100;
        this.f511466b = r101;
        this.f511467c = r102;
        this.f511468d = r103;
        this.f511469e = r104;
    }
}
