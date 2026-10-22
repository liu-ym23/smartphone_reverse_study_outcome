package hu0;

import com.bytedance.android.live.profit.format.voicechat.viewmodel.f;
import io.reactivex.functions.Consumer;
import nu0.j;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f487210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC6196a f487211b;

    public b(a r100, f r101) {
        this.f487210a = r100;
        this.f487211b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        j.c(this.f487210a, "on chat start timeout!!", null, 6);
        this.f487211b.c("aiNotJoin");
    }
}
