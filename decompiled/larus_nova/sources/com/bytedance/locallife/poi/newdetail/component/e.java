package com.bytedance.locallife.poi.newdetail.component;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiDetailModalBar f263149a;

    public e(PoiDetailModalBar r100) {
        this.f263149a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 != null) goto L6;
    L11:
        if (r101 != null) goto L14;
        return;
    L14:
        if (r101.intValue() != 6) goto L21;
        View r102 = this.f263149a.f263037y;
        if (r102 == null) goto L24;
        r102.setAlpha(0.0f);
        return;
    L24:
        return;
    L21:
        return;
    L6:
        if (r101.intValue() != 4) goto L11;
        View r103 = this.f263149a.f263037y;
        if (r103 == null) goto L22;
        r103.setAlpha(1.0f);
        return;
    }
}
