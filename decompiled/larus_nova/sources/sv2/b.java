package sv2;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f543633a;

    public b(a r100) {
        this.f543633a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), UIUtils.dip2Px(r100.getContext(), this.f543633a.getViewParams().f543641h));
        return;
    L7:
        return;
    }
}
