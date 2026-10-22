package h57;

import com.bytedance.platform.aio.channel.RpcException;
import com.bytedance.platform.aio.channel.RpcExceptionMonitorLevel;
import com.bytedance.platform.aio.channel.b;
import com.bytedance.platform.aio.channel.f;
import com.bytedance.revenue.platform.api.core.rx.o;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a<R> implements b.InterfaceC3727b<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublishSubject<R> f483879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject f483880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f483881c;

    @Override // com.bytedance.platform.aio.channel.b.InterfaceC3727b
    public final void onClose() {
        this.f483879a.onComplete();
    }

    public final String toString() {
        return "Reader@" + hashCode() + " (tag = " + this.f483881c.f266591a + ')';
    }

    public a() {
        this.f483881c = new f();
        int r100 = o.f267521a;
        PublishSubject<R> r101 = PublishSubject.create();
        this.f483879a = r101;
        this.f483880b = r101;
    }

    @Override // com.bytedance.platform.aio.channel.b.InterfaceC3727b
    public final void U0(R r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f483879a.onNext(r100);
    }

    @Override // com.bytedance.platform.aio.channel.b.InterfaceC3727b
    public final void a(String r110, String r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r110, "category");
        Intrinsics.checkNotNullParameter(r111, "message");
        Intrinsics.checkNotNullParameter(r112, "extra");
        PublishSubject<R> r100 = this.f483879a;
        Intrinsics.checkNotNullParameter(r110, "category");
        Intrinsics.checkNotNullParameter(r111, "message");
        Intrinsics.checkNotNullParameter(r112, "extra");
        r100.onError(new RpcException(r110, r111, r112, RpcExceptionMonitorLevel.ERROR, null, 16, null));
    }
}
