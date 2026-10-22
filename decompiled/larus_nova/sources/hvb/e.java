package hvb;

import com.bytedance.lark.rustclient.api.s;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.Message;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendPbRequest$3$callback$1;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Message<?, ?>> f487365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Disposable> f487366b;

    public e(MmNetRequestHandler$sendPbRequest$3$callback$1 r100, Ref.ObjectRef r101) {
        this.f487365a = r100;
        this.f487366b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        s r101 = (s) r100;
        int r102 = g.f487369a;
        Intrinsics.checkNotNull(r101);
        g.a(r101, this.f487365a, this.f487366b.element);
    }
}
