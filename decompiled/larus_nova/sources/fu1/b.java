package fu1;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements yt1.f<fu1.a> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // yt1.f
    public final <D> void a(yt1.b<D, fu1.a> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewDelegate");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
    }

    @Override // yt1.f
    public int getType() {
        return 1;
    }

    @Override // yt1.f
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        fu1.a r101 = new fu1.a(r100);
        r101.setTypeface(Typeface.SANS_SERIF);
        return r101;
    }

    @Override // yt1.f
    public final void b(com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b r100, com.bytedance.android.ecom.arch.slice.render.elements.g r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "viewManger");
        Intrinsics.checkNotNullParameter(r101, "childViewManager");
        Intrinsics.checkNotNullParameter(r100, "viewManger");
        Intrinsics.checkNotNullParameter(r101, "childViewManager");
    }
}
