package ve2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tf0.b f554339a;

    public g(com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r100) {
        this.f554339a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApply failed " + ((Throwable) r100).getMessage());
        this.f554339a.a();
    }
}
