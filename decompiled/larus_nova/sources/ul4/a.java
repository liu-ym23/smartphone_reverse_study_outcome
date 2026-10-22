package ul4;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.bytedance.dux.infopanel.DuxInfoPanelView;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxInfoPanelView f550610a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        DuxInfoPanelView r100 = this.f550610a;
        int r101 = DuxInfoPanelView.f205227i;
        r100.getClass();
    }

    public a(DuxInfoPanelView r100, Context r101) {
        this.f550610a = r100;
    }
}
