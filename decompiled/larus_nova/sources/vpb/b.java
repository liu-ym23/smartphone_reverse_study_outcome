package vpb;

import io.reactivex.functions.Action;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f556732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f556733b;

    public b(a r100, long r101) {
        this.f556732a = r100;
        this.f556733b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        DecimalFormat r100 = f.f556745a;
        a r101 = this.f556732a;
        f.a("full", r101.f556718k, r101.f556708a, true, System.nanoTime() - this.f556733b, null);
    }
}
