package vw;

import android.view.ViewTreeObserver;
import com.bytedance.android.goldboxentrance.saas.container.view.GoldBoxFloatLayout;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GoldBoxFloatLayout f557414a;

    public b(GoldBoxFloatLayout r100) {
        this.f557414a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        GoldBoxFloatLayout r100 = this.f557414a;
        r100.a(r100.getX(), this.f557414a.getY(), 0);
    }
}
