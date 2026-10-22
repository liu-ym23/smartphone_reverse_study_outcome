package j21;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f496927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f496928b;

    public f(e r100, int r101) {
        this.f496927a = r100;
        this.f496928b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.revlink.impl.multianchor.vm.h r101 = (com.bytedance.android.live.revlink.impl.multianchor.vm.h) r100;
        jy0.b.c("ttlive_anchor_link_panel", "fetchRecommendList from preload completed event " + r101.f95053b + ' ' + this.f496928b, null, 4);
        if (r101.f95053b != this.f496928b) goto L5;
        this.f496927a.e(r101.f95052a);
        return;
    L5:
        this.f496927a.c(false);
    }
}
