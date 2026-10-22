package nr0;

import android.os.Bundle;
import com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements IEventListener {
    public g() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener
    public final Bundle onEvent(Bundle r100) {
        if (r100 == null) goto L6;
        long r101 = r100.getLong("lottery_id");
        CompositeDisposable r102 = h.f520161a;
        h.f520163c = Long.valueOf(r101);
        h.a(r101, false, false);
        return null;
    L6:
        return null;
    }
}
