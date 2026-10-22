package fx0;

import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f479057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.C5959b f479058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f479059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CallContext f479060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ExchangeType f479061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ py.k f479062f;

    public d(b r100, b.C5959b r101, Ref.ObjectRef r102, CallContext r103, ExchangeType r104, py.k r105) {
        this.f479057a = r100;
        this.f479058b = r101;
        this.f479059c = r102;
        this.f479060d = r103;
        this.f479061e = r104;
        this.f479062f = r105;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Long r111 = (Long) r110;
        Long r100 = this.f479058b.a();
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        long r102 = r101 - r111.longValue();
        qa0.a r112 = qa0.c.f532212b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        Intrinsics.checkNotNull(r112);
        com.bytedance.android.live.incentive.exchange.c r113 = (com.bytedance.android.live.incentive.exchange.c) r112;
        if (r113.d(r102) == false) goto L9;
        c r103 = new c(this, r102);
        r113.g(new com.bytedance.android.live.incentive.exchange.l(this.f479060d.getContext(), this.f479061e, r102, r103, this.f479062f));
        return;
    L9:
        this.f479057a.finishWithResult(new b.c(2, null));
        return;
    L5:
        r101 = 0;
        goto L6
    }
}
