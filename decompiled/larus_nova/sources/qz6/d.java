package qz6;

import java.util.List;
import sz6.i;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f535370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f535371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f535372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f535373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f535374e;

    public final int hashCode() {
        char r100 = this.f535371b;
        String r101 = this.f535374e;
        String r102 = this.f535373d;
        return ((((r100 + 0) * 31) + r101.hashCode()) * 31) + r102.hashCode();
    }

    public d(List r100, char r101, double r102, String r103, String r104) {
        this.f535370a = r100;
        this.f535371b = r101;
        this.f535372c = r102;
        this.f535373d = r103;
        this.f535374e = r104;
    }
}
