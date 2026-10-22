package d8a;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;

/* JADX INFO: loaded from: classes32.dex */
public abstract class k<T, C> {
    public k() {
    }

    public void cancel(LynxResourceRequest<T> r100) {
    }

    public void request(LynxResourceRequest<T> r100, LynxResourceCallback<C> r101) {
    }

    public void request(LynxResourceRequest<T> r100, LynxResourceCallback<C> r101, LynxContext r102) {
        request(r100, r101);
    }
}
