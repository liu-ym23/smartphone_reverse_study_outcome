package com.bytedance.ee.bear.bitable.homepage.chart.widget.chart;

import android.view.View;
import com.lynx.react.bridge.JavaOnlyMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChartItemView f212699a;

    public b(ChartItemView r100) {
        this.f212699a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        int r109 = r104 - r102;
        if (r109 != (r108 - r106)) goto L8;
        if ((r103 - r101) != (r107 - r105)) goto L8;
        return;
    L8:
        if (this.f212699a.f212663m.hasRendered() == true) goto L11;
        tt5.a.h("ChartItemView", "has not rendered, will not send onContainerResize");
        return;
    L11:
        ks4.b r110 = this.f212699a.f212663m;
        JavaOnlyMap r111 = new JavaOnlyMap();
        r111.put("width", Integer.valueOf(r103 - r101));
        r111.put("height", Integer.valueOf(r109));
        Unit r112 = Unit.INSTANCE;
        r110.sendGlobalEventToJS("onContainerResize", CollectionsKt.listOf(r111));
    }
}
