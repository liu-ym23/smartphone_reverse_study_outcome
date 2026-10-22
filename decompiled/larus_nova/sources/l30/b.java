package l30;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.web.jsbridge2.d0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f507209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IHybridComponent f507210b;

    public b(d0 r100, IHybridComponent r101) {
        this.f507209a = r100;
        this.f507210b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        d0 r102 = this.f507209a;
        if (r102 != null) goto L5;
    L7:
        IHybridComponent r103 = this.f507210b;
        if (r103 == null) goto L11;
        r103.sendJsEvent("deviceOrientationEvent", d.a());
        return;
    L11:
        return;
    L5:
        if (r102.f249346f == true) goto L7;
        r102.f("deviceOrientationEvent", d.a());
        goto L7
    }
}
