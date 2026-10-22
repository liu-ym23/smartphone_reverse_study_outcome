package yu0;

import io.reactivex.subjects.SingleSubject;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements zv0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleSubject f569215a;

    @Override // zv0.e
    public final void b() {
        this.f569215a.onSuccess(Unit.INSTANCE);
    }

    public a(SingleSubject r100) {
        this.f569215a = r100;
    }

    @Override // zv0.e
    public final void a(Throwable r100) {
        this.f569215a.onSuccess(Unit.INSTANCE);
    }

    @Override // zv0.e
    public final void c(zv0.d r100) {
        this.f569215a.onSuccess(Unit.INSTANCE);
    }
}
