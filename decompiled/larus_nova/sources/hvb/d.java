package hvb;

import com.bytedance.lark.rustclient.api.s;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.Message;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendHttpRequest$2$2$callBack$1;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Message<?, ?>> f487363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Disposable> f487364b;

    public d(MmNetRequestHandler$sendHttpRequest$2$2$callBack$1 r100, Ref.ObjectRef r101) {
        this.f487363a = r100;
        this.f487364b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        s r101 = (s) r100;
        lvb.a.a("RustSdkBridge", "[sendHttp] subscribe response=" + r101);
        int r102 = g.f487369a;
        Intrinsics.checkNotNull(r101);
        g.a(r101, this.f487363a, this.f487364b.element);
    }
}
