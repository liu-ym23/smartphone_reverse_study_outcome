package yf0;

import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;

/* JADX INFO: loaded from: classes46.dex */
public abstract class e<V extends InteractDialogFragmentBaseContract$View> extends com.bytedance.android.livesdk.common.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f567428b;

    public final <R> AutoDisposeConverter<R> c() {
        return this.f567428b.S90();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(V r100) {
        this.f567428b = r100;
        this.f119692a = r100;
    }
}
