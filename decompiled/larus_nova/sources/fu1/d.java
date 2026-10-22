package fu1;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends SlcFlexElementView implements com.bytedance.android.livesdk.dslservice.view.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<View> f478856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f478857f;

    @Override // com.bytedance.android.livesdk.dslservice.view.a
    public final void reset() {
    }

    public final HashSet<View> getAutoGoneViewSet() {
        return this.f478856e;
    }

    public final View getLastSeparateView() {
        return this.f478857f;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        this.f478856e = new HashSet();
    }

    public final void setLastSeparateView(View r100) {
        this.f478857f = r100;
    }
}
