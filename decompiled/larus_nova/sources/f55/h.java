package f55;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements hg5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f475654a;

    public h(f r100) {
        this.f475654a = r100;
    }

    @Override // hg5.d
    public final void onError(Throwable r100) {
        tt5.a.e("LikeWrapper", "FileExtraInfoView doLike onError: ", r100, false);
        f.a(this.f475654a);
    }

    @Override // hg5.d
    public final void a(int r100, String r101, String r102) {
        tt5.a.h("LikeWrapper", "FileExtraInfoView doLike onFetched: code=" + r100 + " id=" + r102 + " msg=" + r101);
        if (r100 == 0) goto L5;
        f.a(this.f475654a);
        return;
    L5:
        com.bytedance.ee.util.ui.j.c(new g(this));
    }
}
