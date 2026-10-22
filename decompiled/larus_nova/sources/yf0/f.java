package yf0;

import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogWidgetBaseContract$View;

/* JADX INFO: loaded from: classes46.dex */
public abstract class f<V extends InteractDialogWidgetBaseContract$View> extends com.bytedance.android.livesdk.common.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f567429b;

    public final <R> AutoDisposeConverter<R> c() {
        return this.f567429b.autoDisposeWithTransformer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(V r100) {
        this.f567429b = r100;
        this.f119692a = r100;
    }
}
