package im2;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.ss.ugc.live.sdk.msg.network.HttpException;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e f490474a;

    public g(lmc.a.f r100) {
        this.f490474a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof NetworkErrorException) == false) goto L5;
        com.ss.ugc.live.sdk.msg.network.e r102 = this.f490474a;
        int r103 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        r102.a(com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(((NetworkErrorException) r101).statusCode, null)));
        return;
    L5:
        com.ss.ugc.live.sdk.msg.network.e r104 = this.f490474a;
        int r105 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        r104.a(com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception(r101)));
    }
}
