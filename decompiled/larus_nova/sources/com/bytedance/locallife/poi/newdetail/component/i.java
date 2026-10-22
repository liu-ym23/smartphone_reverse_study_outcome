package com.bytedance.locallife.poi.newdetail.component;

import android.view.ViewPropertyAnimator;
import androidx.lifecycle.Observer;
import com.bytedance.locallife.poi.newdetail.widget.PoiInDoorBottomBar;

/* JADX INFO: loaded from: classes21.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiInDoorBottomBar f263215a;

    public i(PoiInDoorBottomBar r100) {
        this.f263215a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        PoiInDoorBottomBar r101 = this.f263215a;
        if (((com.bytedance.locallife.dito.data.u) r100).f258256b > 0) goto L5;
        r101.a();
        return;
    L5:
        if (r101.f263327j == false) goto L20;
        r101.f263327j = false;
        r101.f263328k.removeCallbacks(r101.f263329l);
        r101.f263328k.postDelayed(r101.f263329l, 300);
        ViewPropertyAnimator r102 = r101.animate();
        if (r102 == null) goto L16;
        ViewPropertyAnimator r103 = r102.translationY(r101.getHeight());
        if (r103 == null) goto L17;
        ViewPropertyAnimator r104 = r103.setDuration(300);
        if (r104 == null) goto L18;
        r104.start();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
