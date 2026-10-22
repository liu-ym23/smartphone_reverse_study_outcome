package g70;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements w70.a<h70.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f480203a;

    public b(c r100) {
        this.f480203a = r100;
    }

    @Override // w70.a
    public final Widget a(h70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return ((e70.h) this.f480203a.f480205b).l(r100);
    }
}
