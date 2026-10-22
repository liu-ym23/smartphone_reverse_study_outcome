package xu7;

/* JADX INFO: loaded from: classes23.dex */
public final class h extends wu7.g {
    @Override // wu7.g
    public final wu7.f[] l() {
        return new wu7.f[]{new j(), new j(), new j()};
    }

    public h() {
    }

    @Override // wu7.g
    public final void k(wu7.f... r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        wu7.f r102 = r100[r101];
        r101 = r101 + 1;
        r102.f561453f = r101 * 200;
        goto L4
    }
}
