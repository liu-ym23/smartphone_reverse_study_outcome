package gq7;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f482271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f482272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f482273c;

    public final String toString() {
        return "BaseStatFile{mPath='" + this.f482272b + "', mFile=" + this.f482273c + ", mLastInfo=" + this.f482271a + '}';
    }

    public a(String r100) {
        this.f482271a = null;
        this.f482272b = null;
        this.f482273c = null;
        this.f482272b = r100;
    }
}
