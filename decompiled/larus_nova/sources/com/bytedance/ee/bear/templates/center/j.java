package com.bytedance.ee.bear.templates.center;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.homepage.widget.CompatDrawableTextView;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TemplateCenterView f238938a;

    public j(TemplateCenterView r100) {
        this.f238938a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        TemplateCenterView r102 = this.f238938a;
        int r103 = 0;
        if (r101 == null) goto L5;
        boolean r104 = r101.booleanValue();
    L6:
        CompatDrawableTextView r105 = r102.f238905f;
        if (r105 == null) goto L13;
        if (r104 == true) goto L11;
        r103 = 8;
    L11:
        r105.setVisibility(r103);
        return;
    L13:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
