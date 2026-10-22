package fx2;

import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements f {
    @Override // fx2.f
    public final View getHybridView() {
        return null;
    }

    @Override // fx2.f
    public final View getKitView() {
        return null;
    }

    @Override // fx2.f
    public final void release() {
    }

    @Override // fx2.f
    public final void renderTemplate(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // fx2.f
    public final void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    @Override // fx2.f
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }
}
