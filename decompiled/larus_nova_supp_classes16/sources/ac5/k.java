package ac5;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.lark.route.SpaceRouteFragment;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.ss.android.lark.api.bean.ForsetiViewMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ SpaceRouteFragment a;

    public k(SpaceRouteFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ForsetiViewMode r4 = (ForsetiViewMode) r3;
        int r0 = SpaceRouteFragment.m;
        tt5.a.h("SpaceRouteFragment", "observeForsetiMode:mode:" + r4 + " mDestination:" + this.a.h);
        if (r4 == null) goto L21;
        SpaceRouteFragment r1 = this.a;
        if (r1.f != null) goto L7;
        return;
    L7:
        if (r1.l.contains(Integer.valueOf(r1.h)) == true) goto L9;
        return;
    L9:
        if (r4.isCompact() == false) goto L15;
        HomeMainTitleBar r5 = this.a.f;
        if (r5 == null) goto L24;
        AppCompatImageView r6 = r5.h;
        if (r6 == null) goto L25;
        r6.setVisibility(0);
        return;
    L25:
        return;
    L24:
        return;
    L15:
        HomeMainTitleBar r7 = this.a.f;
        if (r7 == null) goto L27;
        AppCompatImageView r8 = r7.h;
        if (r8 == null) goto L28;
        r8.setVisibility(8);
        return;
    L28:
        return;
    L27:
        return;
    }
}
