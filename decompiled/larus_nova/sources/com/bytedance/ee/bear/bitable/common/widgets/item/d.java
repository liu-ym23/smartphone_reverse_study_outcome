package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonItemView f210017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f210018b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r100 = 0;
        if (this.f210017a.getWrapViewFromXml().getWidth() == 0) goto L5;
        int r101 = this.f210017a.getWrapViewFromXml().getWidth();
        if (this.f210017a.getRightIconFromXml().getVisibility() == 8) goto L17;
    L19:
        int r102 = r101 - r100;
    L20:
        Integer r103 = null;
        if (this.f210017a.getDescFromXml().getVisibility() != 0) goto L30;
        Object r104 = this.f210017a.getDescFromXml().getTag();
        if ((r104 instanceof Integer) == false) goto L25;
        r103 = (Integer) r104;
    L25:
        if (r103 != null) goto L28;
    L29:
        int r105 = Math.max(this.f210018b.getWidth(), this.f210017a.getDescFromXml().getWidth());
        int r106 = r105 + r102;
        this.f210018b.setMaxWidth(r106);
        this.f210017a.getDescFromXml().setMaxWidth(r106);
        this.f210017a.getDescFromXml().setTag(Integer.valueOf(r102));
    L38:
        this.f210017a.getWrapViewFromXml().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L28:
        if (r103.intValue() == r102) goto L38;
    L30:
        Object r107 = this.f210018b.getTag();
        if ((r107 instanceof Integer) == false) goto L33;
        r103 = (Integer) r107;
    L33:
        if (r103 != null) goto L36;
    L37:
        TextView r108 = this.f210018b;
        r108.setMaxWidth(r108.getWidth() + r102);
        this.f210018b.setTag(Integer.valueOf(r102));
        goto L38
    L36:
        if (r103.intValue() == r102) goto L38;
    L17:
        if (this.f210017a.getEditable() == false) goto L19;
        r100 = n.d(28);
        goto L19
    L5:
        if (this.f210017a.getEditable() == false) goto L9;
        if (this.f210017a.getRightIconFromXml().getVisibility() != 8) goto L9;
    L12:
        r100 = n.d(28);
    L13:
        r102 = -r100;
    L9:
        if (this.f210017a.getEditable() == true) goto L13;
        if (this.f210017a.getRightIconFromXml().getVisibility() != 0) goto L13;
        goto L12
    }

    public d(CommonItemView r100, TextView r101) {
        this.f210017a = r100;
        this.f210018b = r101;
    }
}
