package ve2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ tf0.b a;

    public g(com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("SingleBroadcastMultiChorusStrategy", "multiChorusPrepareApply failed " + ((Throwable) r3).getMessage());
        this.a.a();
    }
}
