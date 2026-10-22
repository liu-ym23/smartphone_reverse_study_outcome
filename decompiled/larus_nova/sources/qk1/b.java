package qk1;

import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f533464a;

    public b(Function1 r100) {
        this.f533464a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        if (r101 == null) goto L10;
        T r102 = r101.data;
        if (((r0) r102) == null) goto L11;
        this.f533464a.invoke(r102);
        return;
    L11:
        return;
    }
}
