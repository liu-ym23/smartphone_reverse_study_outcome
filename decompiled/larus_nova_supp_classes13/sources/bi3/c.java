package bi3;

import android.view.View;
import com.bytedance.android.shopping.skubuy.platform.view.PlatformErrorView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements n43.a {
    public final PlatformErrorView a;

    public final View getView() {
        return this.a;
    }

    public c(PlatformErrorView r2) {
        Intrinsics.checkNotNullParameter(r2, "errorView");
        this.a = r2;
    }

    public final void a(x43.a r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a.setState(r2);
    }

    public final void b(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.setOnCloseClickCallback(r2);
    }

    public final void c(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.setOnRetryClickedCallback(r2);
    }
}
