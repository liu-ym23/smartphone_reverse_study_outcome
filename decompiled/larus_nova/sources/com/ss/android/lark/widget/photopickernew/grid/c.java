package com.ss.android.lark.widget.photopickernew.grid;

import android.view.View;
import com.ss.android.lark.widget.photopickernew.PhotoPickerFrameFragment2;
import java.util.Collections;
import java.util.List;
import rdc.m;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GridImageShowPlugin f447918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f447919b;

    public c(GridImageShowPlugin r100, t r101) {
        this.f447918a = r100;
        this.f447919b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        rdc.b r101 = this.f447918a.f447885d;
        t r102 = this.f447919b;
        m r103 = (m) r101;
        if (r102 != null) goto L5;
        r103.getClass();
        return;
    L5:
        PhotoPickerFrameFragment2 r104 = r103.f537366b;
        List<t> r105 = Collections.singletonList(r102);
        Boolean r106 = Boolean.valueOf(r103.f537365a.f537382d);
        Boolean r107 = Boolean.valueOf(r103.f537365a.f537383e);
        int r108 = PhotoPickerFrameFragment2.f447874h;
        if (r104.Z90(true, r105, r106, r107, "album", false) == false) goto L10;
        r103.f537366b.X90();
        return;
    }
}
