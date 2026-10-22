package nz;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f521307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f521308b;

    public b0(Function1 r100, Function1 r101) {
        this.f521307a = r100;
        this.f521308b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        if (r101 != null) goto L5;
    L9:
        this.f521308b.invoke(new Throwable());
        return;
    L5:
        if (r101.statusCode != 0) goto L9;
        com.bytedance.android.live.broadcast.api.model.o r102 = (com.bytedance.android.live.broadcast.api.model.o) r101.data;
        if (r102 == null) goto L11;
        Unit r103 = (Unit) this.f521307a.invoke(r102);
        return;
    }
}
