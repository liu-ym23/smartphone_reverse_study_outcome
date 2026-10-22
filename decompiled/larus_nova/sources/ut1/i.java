package ut1;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements DrawerLayout.DrawerListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveDrawerLayout f551588a;

    public i(LiveDrawerLayout r100) {
        this.f551588a = r100;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void onDrawerClosed(View r100) {
        LiveDrawerLayout r101 = this.f551588a;
        r101.f122350d = false;
        r101.getClass();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void onDrawerOpened(View r100) {
        this.f551588a.f122350d = true;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void onDrawerStateChanged(int r100) {
        if (r100 != 0) goto L5;
        LiveDrawerLayout r101 = this.f551588a;
        int r102 = LiveDrawerLayout.f122346g;
        r101.getClass();
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void onDrawerSlide(View r100, float r101) {
        LiveDrawerLayout r102 = this.f551588a;
        int r103 = LiveDrawerLayout.f122346g;
        r102.getClass();
    }
}
