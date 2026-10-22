package z05;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f569617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f569618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f569619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f569620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f569621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f569622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f569623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f569624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f569625i;

    public g() {
    }

    public final int hashCode() {
        return (this.f569617a.hashCode() + this.f569623g.hashCode()) + this.f569622f.hashCode();
    }

    public final String toString() {
        return "VersionMetadata{token='" + this.f569617a + "', name='" + TextUtils.isEmpty(this.f569618b) + "', displayName='" + TextUtils.isEmpty(this.f569621e) + "', version='" + this.f569622f + "', parentToken='" + this.f569623g + "', createTime=" + this.f569624h + ", updateTime=" + this.f569625i + '}';
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this != r100) goto L9;
        return true;
    L9:
        if (g.class == r100.getClass()) goto L11;
        return false;
    L11:
        g r101 = (g) r100;
        if (TextUtils.equals(this.f569617a, r101.f569617a) == true) goto L15;
        return false;
    L15:
        if (TextUtils.equals(this.f569623g, r101.f569623g) == true) goto L18;
        return false;
    L18:
        if (TextUtils.equals(this.f569622f, r101.f569622f) == true) goto L21;
        return false;
    L21:
        if (TextUtils.equals(this.f569621e, r101.f569621e) == true) goto L24;
        return false;
    L24:
        if (Objects.equals(this.f569624h, r101.f569624h) == true) goto L27;
        return false;
    L27:
        return super.equals(r100);
    }
}
