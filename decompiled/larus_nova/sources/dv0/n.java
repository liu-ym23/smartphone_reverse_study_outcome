package dv0;

import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: classes47.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SingleSubject<Long> f470131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SingleSubject f470132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f470134d;

    public n(String r100, long r101) {
        this.f470133c = r100;
        this.f470134d = r101;
        SingleSubject<Long> r102 = SingleSubject.create();
        this.f470131a = r102;
        this.f470132b = r102;
    }
}
