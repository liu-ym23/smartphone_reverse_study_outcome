package ut2;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f551619a;

    public b(c r100) {
        this.f551619a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof ApiServerException) == false) goto L8;
        ApiServerException r102 = (ApiServerException) r101;
        if (r102.getErrorCode() != 40001) goto L7;
        d r103 = this.f551619a.f551620a;
        d.j(r103, r103.getCallContext().getContext());
    L9:
        this.f551619a.f551620a.finishWithFailure();
        this.f551619a.f551622c.clear();
        return;
    L7:
        f2.c(r102.getPrompt(), 0);
        goto L9
    L8:
        f2.b(R.string.ttlive_network_error, 0);
        goto L9
    }
}
