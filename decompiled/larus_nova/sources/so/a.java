package so;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.ec.window.base.dynamicview.renderer.a<View, to.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f542691d = null;

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final void b(View r100, to.a r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "vo");
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    static {
        f542691d = new a();
    }

    public a() {
        super(View.class, to.a.class, "");
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final to.a d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        return a(r100);
    }
}
