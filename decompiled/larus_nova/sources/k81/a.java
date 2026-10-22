package k81;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f502079a;

    public a(Function1 r100) {
        this.f502079a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        Function1 r102 = this.f502079a;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke(r101.data);
        return;
    }
}
