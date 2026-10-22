package f55;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements hg5.d {
    public final /* synthetic */ f a;

    public j(f r1) {
        this.a = r1;
    }

    public final void onError(Throwable r4) {
        tt5.a.e("LikeWrapper", "FileExtraInfoView unLike onError: ", r4, false);
        f.a(this.a);
    }

    public final void a(int r3, String r4, String r5) {
        tt5.a.h("LikeWrapper", "FileExtraInfoView unLike onFetched: code=" + r3 + " id=" + r5 + " msg=" + r4);
        if (r3 == 0) goto L5;
        f.a(this.a);
        return;
    L5:
        com.bytedance.ee.util.ui.j.c(new i(this));
    }
}
