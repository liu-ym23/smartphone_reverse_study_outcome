package ds1;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSChorusConcertWidget f469834a;

    public b(VSChorusConcertWidget r100) {
        this.f469834a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 != null) goto L6;
    L14:
        if (r101 != null) goto L17;
    L25:
        int r102 = VSChorusConcertWidget.f119330l;
        this.f469834a.zq("onControlStatusListener PlayerViewControl.KEY.PlayerShadowBottom:" + r101);
        return;
    L17:
        if (r101.intValue() != 1) goto L25;
        VSChorusConcertWidget r103 = this.f469834a;
        int r104 = VSChorusConcertWidget.f119330l;
        r103.zq("播控组件 隐藏");
        es1.a r105 = this.f469834a.xq(false);
        if (r105 == null) goto L25;
        if (r105.f473682a != true) goto L25;
        FrameLayout r106 = this.f469834a.f119331a;
        if (r106 == null) goto L25;
        r106.setAlpha(1.0f);
        goto L25
    L6:
        if (r101.intValue() != 0) goto L14;
        VSChorusConcertWidget r107 = this.f469834a;
        int r108 = VSChorusConcertWidget.f119330l;
        r107.zq("播控组件 显示");
        es1.a r109 = this.f469834a.xq(false);
        if (r109 == null) goto L25;
        if (r109.f473682a != true) goto L25;
        FrameLayout r110 = this.f469834a.f119331a;
        if (r110 == null) goto L25;
        r110.setAlpha(0.2f);
        goto L25
    }
}
