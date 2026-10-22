package com.ss.android.lark.widget.halfscreen;

import android.view.View;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarkPhotoPickerView f445928a;

    public a(LarkPhotoPickerView r100) {
        this.f445928a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (((ArrayList) this.f445928a.f445898n.f447457b).size() != 0) goto L5;
        return;
    L5:
        LarkPhotoPickerView r111 = this.f445928a;
        Contexts.preferActivity(r111.getContext());
        List<Photo> r100 = this.f445928a.f445898n.f447457b;
        LarkPhotoPickerView.d r101 = r111.H;
        new ArrayList();
        new ArrayList();
        boolean r102 = r111.f445903s;
        int r103 = r111.f445900p;
        boolean r112 = !r111.R;
        boolean r113 = r111.f445904t;
        PhotoPreviewPickerParam r114 = new PhotoPreviewPickerParam(r100, 0, false, null, r102, r103, false, new ArrayList(r100), r112);
        PhotoPreviewPickerParam.access$002(r114, 0);
        PhotoPreviewPickerParam.access$102(r114, r113);
        r101.b(r114);
    }
}
