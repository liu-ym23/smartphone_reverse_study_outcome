package u10;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f548278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f548279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f548280c;

    public h(e r100, Function1 r101, long r102) {
        this.f548278a = r100;
        this.f548279b = r101;
        this.f548280c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1 r101 = this.f548279b;
        r101.invoke((Throwable) r100);
        this.f548278a.f548269c.remove(Long.valueOf(this.f548280c));
    }
}
