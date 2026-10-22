package u86;

import android.view.View;
import com.bytedance.ies.xelement.viewpager.Pager;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseLynxViewPager<BaseCustomViewPager, Pager<Object>> f549182a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    public c(BaseLynxViewPager<BaseCustomViewPager, Pager<Object>> r100) {
        this.f549182a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Pager r101 = this.f549182a.N();
        final BaseLynxViewPager<BaseCustomViewPager, Pager<Object>> r102 = this.f549182a;
        r101.post(new b(r102));
    }
}
