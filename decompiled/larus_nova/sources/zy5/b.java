package zy5;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b implements Runnable, Comparable<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f573942a;

    public b(int r100) {
        this.f573942a = r100;
    }

    @Override // java.lang.Comparable
    public final int compareTo(b r100) {
        int r101 = this.f573942a;
        int r102 = r100.f573942a;
        if (r101 >= r102) goto L5;
        return -1;
    L5:
        if (r101 <= r102) goto L7;
        return 1;
    L7:
        return 0;
    }
}
