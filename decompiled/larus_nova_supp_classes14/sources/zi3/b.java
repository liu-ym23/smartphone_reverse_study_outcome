package zi3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements c {
    public static final b a = null;

    public b() {
    }

    @Override // zi3.c
    public final void a(Context r2, List<PanelItem> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "items");
    }

    @Override // zi3.c
    public final View b(Context r2, Function1<? super View, Unit> r3, Function1<? super View, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onMenuClick");
        Intrinsics.checkNotNullParameter(r4, "onCloseClick");
        return null;
    }

    @Override // zi3.c
    public final boolean c() {
        return true;
    }

    @Override // zi3.c
    public final View d(Context r2, Function1<? super View, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onClick");
        return null;
    }

    @Override // zi3.c
    public final boolean e() {
        return false;
    }

    static {
        a = new b();
    }
}
