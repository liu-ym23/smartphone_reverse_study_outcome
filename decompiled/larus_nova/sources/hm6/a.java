package hm6;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import tt6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements b {
    public a() {
    }

    @Override // tt6.b
    public final void a() {
    }

    @Override // tt6.b
    public final void d() {
    }

    @Override // tt6.b
    public final void f() {
    }

    @Override // tt6.b
    public final HashMap<String, String> e() {
        return new HashMap();
    }

    @Override // tt6.b
    public final void c(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // tt6.b
    public final void b(View r100, tt6.a r101, HashMap r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "pendantListener");
        Intrinsics.checkNotNullParameter(r102, "trackParams");
    }
}
