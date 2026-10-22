package vc6;

import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.functions.Consumer;
import zz0.j;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f554120a;

    public d(b r100) {
        this.f554120a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        j r101 = (j) r100;
        b r102 = this.f554120a;
        r102.f554116c = r101;
        f.a(r102.f554118e.observeUIHandleStatus(r101).subscribe(new c(this)), this.f554120a.f554114a);
    }
}
